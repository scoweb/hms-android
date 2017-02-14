package com.elait.hms;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchListViewAdapter extends ArrayAdapter<String> {

    private MainActivity activity;
    private List<String> PatientList;
    private List<String> searchList;

    public SearchListViewAdapter(MainActivity context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.PatientList = objects;
        this.searchList = new ArrayList<>();
        this.searchList.addAll(PatientList);
    }

    @Override
    public int getCount() {
        return PatientList.size();
    }

    @Override
    public String getItem(int position) {
        return PatientList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.search_item_listview, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

        holder.friendName.setText(getItem(position));

        //get first letter of each String item
        String firstLetter = String.valueOf(getItem(position).charAt(0));

/*        ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
        // generate random color
        int color = generator.getColor(getItem(position));

        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstLetter, color); // radius in px

        holder.imageView.setImageDrawable(drawable);*/

        return convertView;
    }

    // Filter method
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        PatientList.clear();
        if (charText.length() == 0) {
            PatientList.addAll(searchList);
        } else {
            for (String s : searchList) {
                if (s.toLowerCase(Locale.getDefault()).contains(charText)) {
                    PatientList.add(s);
                }
            }
        }
        notifyDataSetChanged();
    }

    private class ViewHolder {
        private ImageView imageView;
        private TextView friendName;

        public ViewHolder(View v) {
//            imageView = (ImageView) v.findViewById(R.id .image_view);
            friendName = (TextView) v.findViewById(R.id.text);
        }
    }
}