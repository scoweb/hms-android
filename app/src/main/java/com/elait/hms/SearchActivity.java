package com.elait.hms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> stringArrayList;
    private SearchListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setData();
//        adapter = new SearchListViewAdapter(this, R.layout.search_item_listview, stringArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SearchActivity.this, (String)parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setData() {
        stringArrayList = new ArrayList<>();
        stringArrayList.add("Vikram Sivaram");
        stringArrayList.add("Jyotsna Neilval");
        stringArrayList.add("Randeep Sarkar");
        stringArrayList.add("Chander Bala");
        stringArrayList.add("Archana Kumar");
        stringArrayList.add("Sanjana Sridhar");
        stringArrayList.add("Arpit Sripathy");
        stringArrayList.add("Geogre Jacob");
        stringArrayList.add("Aravindan Sreeram");
        stringArrayList.add("Vipin Nair");
        stringArrayList.add("Vinod Kumar");
        stringArrayList.add("Archana Pai");
        stringArrayList.add("Kappar Singh");
        stringArrayList.add("Moushmi Kaur");
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        getMenuInflater().inflate( R.menu.menu_main, menu);

        MenuItem myActionMenuItem = menu.findItem( R.id.action_search);
        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    adapter.filter("");
                    listView.clearTextFilter();
                } else {
                    adapter.filter(newText);
                }
                return true;
            }
        });

        return true;
    }
}