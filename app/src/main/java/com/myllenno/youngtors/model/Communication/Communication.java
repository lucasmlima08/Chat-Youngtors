package com.myllenno.youngtors.model.Communication;

import android.content.Context;
import android.util.Log;

import com.myllenno.youngtors.model.capsule.Message;
import com.myllenno.youngtors.model.methods.Basic;
import com.myllenno.youngtors.model.interfaces.CommunicationTCP;
import com.myllenno.youngtors.model.capsule.User;
import com.myllenno.youngtors.model.methods.Essential;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class Communication implements CommunicationTCP {

    private Basic methodsBasic;
    private Essential methodsEssential;

    private ArrayList<Message> requestsReceived;
    private ArrayList<Message> requestsSend;

    private User user;
    private Context context;
    private String serverIP;
    private int serverPort;
    private Socket client;
    private boolean status;


    public Communication(Context context, User user){
        this.context = context;
        this.user = user;
    }

    @Override
    public void startConnection() {
        try {
            serverIP = "192.168.15.2";
            serverPort = 4345;
            client = new Socket(serverIP, serverPort);

            requestsReceived = new ArrayList<Message>();
            requestsSend = new ArrayList<Message>();

            methodsBasic = new Basic();
            methodsEssential = new Essential();

            status = true;
            authentication();
        } catch (Exception e) {
            Log.e("Erro ao abrir a conexão com o servidor.", e.getMessage());
        }
    }

    @Override
    public void authentication() {
        try {
            boolean available = false;
            // Envia o Id do Cliente.
            PrintStream printStream = new PrintStream(client.getOutputStream());
            // Aguarda a resposta do servidor.
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
            while (!available) {
                printStream.println(user.getId());
                Log.i("Mensagem informativa.", "Identificador enviado: " + user.getId());
                String read = bufferedReader.readLine();

                // Verifica se o usuário foi rejeitado pelo servidor.
                if (read.equals("accepted")){
                    Log.i("Mensagem informativa.", "Cliente aceito pelo servidor!");
                    requestsReceived().start();
                    requestSend().start();
                    available = true;
                }

                // Verifica se o cliente foi rejeitado pelo servidor.
                if (read.equals("blocked")){
                    methodsBasic.showMessageLine(context, "Autenticação recusada pelo servidor!");
                    stopConnection();
                    available = true;
                }
            }
        } catch (Exception e) {
            Log.e("Problemas na autenticação do cliente.", e.getMessage());
        }
    }

    @Override
    public void processMessages(Message message) {
        requestsReceived.add(message);
    }

    @Override
    public Thread requestsReceived() {
        Thread send = new Thread(new Runnable() {
            public void run() {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
                    while (status) {
                        // Faz a leitura das requisições enviadas pelo cliente e joga na lista.
                        String read = bufferedReader.readLine();
                        if (!read.equals("")){
                            // Aqui deve ser tratado a mensagem recebida.
                            Message request = methodsEssential.processMessagesReceived(read);
                            requestsReceived.add(request);
                            Log.i("Mensagem Recebida.", request.getMessage());
                        }
                    }
                } catch (Exception e) {
                    Log.e("Erro ao ler a requisição do cliente: ", e.getMessage());
                }
            }
        });
        return send;
    }

    @Override
    public Thread requestSend() {
        Thread received = new Thread(new Runnable() {
            public void run() {
                try {
                    PrintStream printStream = new PrintStream(client.getOutputStream());
                    while (status) {
                        ArrayList<Message> requestsClone = new ArrayList<>(requestsSend);
                        int index = 0;
                        // Percorre as requisições recebidas e envia para o cliente.
                        for (Message request: requestsClone) {
                            // Aqui deve ser tratado a mensagem enviada.
                            printStream.println(methodsEssential.processMessagesSend(request));
                            Log.i("Mensagem Enviada.", request.getMessage());
                            requestsSend.remove(index);
                        }
                    }
                } catch (Exception e) {
                    Log.e("Erro ao enviar a requisição recebida.", e.getMessage());
                }
            }
        });
        return received;
    }

    @Override
    public void stopConnection() {
        status = false;
        client = null;
        requestsReceived = null;
        requestsSend = null;
        methodsBasic = null;
        methodsEssential = null;
    }
}
