package com.elait.hms;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
=======
import android.widget.TextView;

import static android.os.Build.VERSION_CODES.M;
>>>>>>> origin/V0.1-S_DATA

/**
 * Created by balasubramanian on 02/02/17.
 */

public class TabDemography extends Fragment {
<<<<<<< HEAD
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_demography, container, false);
=======

    String p_demography[][] = new String[][]{
            {"Vikram", "9432088774", "M", "43", "20 years", "high", "12333", "Bengaluru", "positive"},
            {"Jyotsna", "8904454741", "F", "24", "10 years", "low", "12333", "Mumbai", "negative"},
            {"Randeep", "7878051445", "M", "31", "NO", "High Sistolith Pressure", "12333", "Kolkata", "positive"},
            {"Chander", "9787475200", "M", "28", "Chain Smoker for past 5 years", "High Sistolith and Dialic Pressure", "12333", "Delhi", "positive"},
            {"Archana", "9901232547", "F", "58", "NO", "Hypotension", "2500333", "Chennai", "negative"}

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_demography, container, false);
        String name = getActivity().getIntent().getStringExtra("PATIENT_NAME");
        String phn =getActivity(). getIntent().getStringExtra("MOBILE_NO");

        for (String[] p_dg : p_demography) {

            if (p_dg[0].equals(name) && p_dg[1].equals(phn)) {
                TextView tv_gender=(TextView) view.findViewById(R.id.gender);
                tv_gender.setText(p_dg[2]);
                TextView tv_age=(TextView) view.findViewById(R.id.age);
                tv_age.setText(p_dg[3]);
                TextView tv_sh=(TextView) view.findViewById(R.id.sh);
                tv_sh.setText(p_dg[4]);
                TextView tv_hth=(TextView) view.findViewById(R.id.hth);
                tv_hth.setText(p_dg[5]);
                TextView tv_emergency=(TextView) view.findViewById(R.id.emergency_no);
                tv_emergency.setText(p_dg[6]);
                TextView tv_add=(TextView) view.findViewById(R.id.address);
                tv_add.setText(p_dg[7]);
                TextView tv_dh=(TextView) view.findViewById(R.id.dh);
                tv_dh.setText(p_dg[8]);

            }
        }

        return view ;
>>>>>>> origin/V0.1-S_DATA
    }
}