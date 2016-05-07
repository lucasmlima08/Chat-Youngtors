package com.myllenno.youngtors.model.interfaces;

import com.myllenno.youngtors.model.capsule.Message;

public interface CommunicationTCP {

    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *  Método de abertura do cliente:
     *  Inicia a conexão com o servidor.
     *  Chama o método de autenticação.
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    void startConnection();

    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *  Método de autenticação e inicialização da comunicação do cliente:
     *  Envia o identificador de autenticação.
     *  Aguarda a resposta de aceitação do servidor.
     *  Em caso de aceitação inicia as threads de requisições.
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    void authentication();

    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *  Realiza a leitura de novas requisições do usuário.
     *  Inclui as requisições lidas na lista de requisições.
     *  Faz a comunicação com o banco de dados.
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    void processMessages(Message message);

    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *  Thread de recebimento de mensagens do servidor para o cliente:
     *  Faz a leitura das requisições pelo socket do servidor.
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    Thread requestsReceived();

    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *  Thread de envio de mensagens para outros clientes:
     *  Faz o envio das requisições para o socket do servidor.
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    Thread requestSend();

    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *  Método de fechamento da comunicação do cliente:
     *  Interrompe as threads e o socket de comunicação com o servidor.
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    void stopConnection();
}
