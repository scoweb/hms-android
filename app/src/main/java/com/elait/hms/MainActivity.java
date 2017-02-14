/*package com.elait.hms;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.elait.hms.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    //    SearchView searchView =
    //            (SearchView) menu.findItem(R.id.action_search).getActionView();
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        //searchView.setSearchableInfo(
        //        searchManager.getSearchableInfo(getComponentName()));
        //ComponentName cn = new ComponentName(this, SearchResultsActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.send_sms:
                Toast.makeText(view.getContext(), "SMS Button Pressed!",
                        Toast.LENGTH_LONG).show();
        }
    }
}
*/
package com.elait.hms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> stringArrayList;
    private SearchListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.list_item);

        setData();
        adapter = new SearchListViewAdapter(this, R.layout.search_item_listview, stringArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, (String)parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent (MainActivity.this,TabsActivity.class);
//TODO - put that was clicked.
                startActivity(intent);
            }
        });
        listView.setVisibility(View.INVISIBLE);
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
        listView.setVisibility(View.VISIBLE);
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(getApplicationContext(), "Search button clicked", Toast.LENGTH_SHORT).show();
                execSearch(item);
                return true;
            case R.id.action_add_person:
                Toast.makeText(getApplicationContext(),"Add button Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_home:
                Toast.makeText(getApplicationContext(),"Home button Clicked", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void execSearch(MenuItem item)
    {
        final SearchView searchView = (SearchView) item.getActionView();
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
   }
}