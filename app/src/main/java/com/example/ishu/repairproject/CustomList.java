package com.example.ishu.repairproject;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;

public class CustomList extends ArrayAdapter<String> {
    private String[] names;
    private String[] desc;
    private Activity context;

    public CustomList(Activity context, String[] names, String[] desc) {
        super(context, R.layout.list_layout, names);
        this.context = context;
        this.names = names;
        this.desc = desc;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);
//        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
//        TextView textViewDesc = (TextView) listViewItem.findViewById(R.id.textViewDesc);
        RatingBar rb = (RatingBar) listViewItem.findViewById(R.id.rb);
        ImageView image=(ImageView)listViewItem.findViewById(R.id.imageView_round);

//        textViewName.setText(names[position]);
//        textViewDesc.setText(desc[position]);

        rb.setRating(2.5f);
        rb.setIsIndicator(true);

        for(int i=0;i<10;i++)
        image.setImageResource(R.drawable.student);

//        try {
//
//            if (textViewName.getText().toString().length() > 0)
//                listViewItem.setVisibility(View.VISIBLE);
//            else
//                listViewItem.setVisibility(View.GONE);
//        }
//        catch (Exception e)
//        {
//            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
//        }
//
            if (position % 2 == 0)
                listViewItem.setBackgroundResource(R.drawable.gradiant_bg);
            else
                listViewItem.setBackgroundColor(Color.parseColor("WHITE"));

        return  listViewItem;
    }


}
