package com.myllenno.youngtors.view.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.myllenno.youngtors.model.capsule.FriendConverse;
import com.myllenno.youngtors.R;

import java.util.ArrayList;

public class Friends extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_friends);

        // Delete focus in search block.
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        /*recyclerView = (RecyclerView) findViewById(R.id.friends);
        recyclerView.setHasFixedSize(true);
        //friends.setLayoutManager(new LinearLayoutManager(this));
        //friends.setItemAnimator(new DefaultItemAnimator());

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new FriendsAdapter(refreshFriends(), "online");
        recyclerView.setAdapter(adapter);*/
        /*adapter = new MyAdapter(dataSet);
        friends.setAdapter(adapter);*/

        //adapter = new CountryAdapter(CountryManager.getInstance().getCountries(), R.layout.row_country, this);
    }

    private ArrayList<FriendConverse> refreshFriends(){
        ArrayList<FriendConverse> friendsModels = new ArrayList<FriendConverse>();
        friendsModels.add(new FriendConverse(0, "Lucas", "Mensagem","10h", "online"));
        friendsModels.add(new FriendConverse(2, "Bruna", "Mensagem","12h", "online"));
        friendsModels.add(new FriendConverse(3, "Larissa", "Mensagem","15h", "online"));
        return friendsModels;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
