package com.elait.hms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 2017-02-20.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contacts.db";
    public static final String PATIENT_CONTACTS = "contacts";
    public static final String PATIENT_RECORDS = "patient_history";
    public static final String COLUMN_patient_id = "id";
    public static final String COLUMN_age = "age";
    public static final String COLUMN_contact_no = "contact_no";
    public static final String COLUMN_First_name = "fname";
    public static final String COLUMN_Last_name = "lname";
    public static final String COLUMN_gender = "gender";
    public static final String COLUMN_pres = "prescription";
    public static final String COLUMN_diagnosis = "diagnosis";
    public static final String COLUMN_note = "note";
    public static final String COLUMN_next_visit = "next_visit";
    public static final String COLUMN_date = "date";



    SQLiteDatabase db;


    public static final String CONTACT_CREATE = "create table contacts (id integer primary key not null , "
            + "fname text not null , lname text not null , age text not null , date text not null , contact_no text not null);";

    public static final String HISTORY_CREATE = "create table patient_history (id integer primary key not null, patient_id integer , "
            + "prescription text not null , diagnosis text not null , note text not null , next_visit text not null , date DateTime default Current_timestamp);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CONTACT_CREATE);
        db.execSQL(HISTORY_CREATE);
        this.db = db;
    }


    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    public void insertcontacts(Contact c) {
        db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(COLUMN_patient_id, c.getId());
        value.put(COLUMN_age, c.getage());
        value.put(COLUMN_contact_no, c.getContact_no());
        value.put(COLUMN_First_name, c.getFname());
        value.put(COLUMN_Last_name, c.getLname());
        value.put(COLUMN_date, c.getDate());
        db.insert(PATIENT_CONTACTS, null, value);
    }

    public void insertPatientRecord(Patient_Records c) {
        db = this.getWritableDatabase();
        ContentValues value1 = new ContentValues();
        value1.put(COLUMN_diagnosis, c.getDiagnosis());
        value1.put(COLUMN_pres, c.getPrescription());
        value1.put(COLUMN_note, c.getNotes());
        value1.put(COLUMN_next_visit, c.getNext_visit());
        value1.put(COLUMN_date, c.getDate());
        db.insert(PATIENT_RECORDS, null, value1);
    }


    public Cursor getadddetails(SQLiteDatabase db) {
        Cursor cursor;
        String[] projections = {COLUMN_First_name,COLUMN_contact_no};
        cursor = db.query(PATIENT_CONTACTS, projections, null, null, null, null, null);
        return cursor;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        String query = "DROP TABLE if exist " + PATIENT_CONTACTS;
        String query1 = "DROP TABLE if exist " + PATIENT_RECORDS;
        db.execSQL(query);
        db.execSQL(query1);
        this.onCreate(db);

    }
}

