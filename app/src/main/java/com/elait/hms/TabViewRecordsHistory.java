package com.elait.hms;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Shreya Gupta on 25-02-2017.
 */
// DataListView Activity for Displaying the Records of pre registered patients.

public class TabViewRecordsHistory extends android.support.v4.app.Fragment {
    ListView listView;
    SQLiteDatabase db;
    int i;
    DatabaseHelper helper;
    Cursor cursor;
   // String patient_id;

    HistoryListDataAdapter history_listDataAdapter ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.history_activity_data_list_view_activity, container, false);
        listView = (ListView) rootView.findViewById(R.id.List_view_history);
        helper = new DatabaseHelper(getActivity().getApplicationContext());
        db = helper.getReadableDatabase();
        String id_history = getActivity().getIntent().getStringExtra("PATIENT_ID");
        cursor = helper.getPatientHistory(db, id_history);

        history_listDataAdapter = new HistoryListDataAdapter(getActivity().getApplicationContext(), R.layout.tab_view_records, null);
        listView.setAdapter(history_listDataAdapter);

     /*   if (savedInstanceState == null) {
            Bundle extras = getActivity().getIntent().getExtras();
            if (extras == null) {
                patient_id = null;
            } else {
                patient_id = extras.getString("PATIENT_ID");
            }
        } else {
            patient_id = (String) savedInstanceState.getSerializable("PATIENT_ID");
        }
        Log.i("Variable", patient_id);*/

        if (cursor.moveToFirst()) {

            do {
                String prescription,notes,diagnosis,date;

                date = cursor.getString(0);
                prescription = cursor.getString(1);
                diagnosis = cursor.getString(2);
                notes = cursor.getString(3);

                HistoryDataProvider dataProvider = new HistoryDataProvider(prescription,notes,diagnosis,date);
                history_listDataAdapter.add(dataProvider);
            } while (cursor.moveToNext());
        }
        return rootView;

    }
}
