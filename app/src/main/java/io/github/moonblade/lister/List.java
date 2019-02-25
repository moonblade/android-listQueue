package io.github.moonblade.lister;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import io.github.moonblade.lister.Helpers.ListAdapter;
import io.github.moonblade.lister.Helpers.ListItem;
import io.github.moonblade.lister.Helpers.ListQueue;

public class List extends AppCompatActivity {
    RecyclerView recyclerView;
    ListQueue listQueue;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listQueue = new ListQueue();
        listQueue.add(new ListItem("1"));
        listQueue.add(new ListItem("2"));
        listQueue.add(new ListItem("3"));
        listQueue.add(new ListItem("4"));
        listQueue.add(new ListItem("5"));
        listQueue.add(new ListItem("6"));

        createRecyclerViewList();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listQueue.add(new ListItem((listQueue.getQueue().size()+1)+""));
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void createRecyclerViewList() {
        recyclerView = (RecyclerView) findViewById(R.id.listView);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ListAdapter(listQueue);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
