package com.elait.hms;

/**
 * Created by User on 2017-02-23.
 */

public class Contact {
    String id;
    String age, contact_no;


    String fname, gender, date,lname;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setage(String age) {
        this.age = age;

    }

    public String getage() {

        return age;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;

    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getContact_no() {

        return contact_no;

    }

    public void setFname(String name) {
        this.fname = name;

    }

    public String getFname() {
        return fname;
    }

    public void setgender(String gender) {
        this.gender = gender;

    }

    public String getgender() {

        return gender;
    }

}
