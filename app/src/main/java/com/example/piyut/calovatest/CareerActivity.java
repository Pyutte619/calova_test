package com.example.piyut.calovatest;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by piyut on 20/05/2015.
 */
public class CareerActivity extends Activity {
    ListView list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.career_choice);

        final String[] itemName={"teaching","coding","making film"};
        final Integer[] imgRes={R.drawable._backgroundimage,R.drawable.computer,R.drawable.film};
        list= (ListView) findViewById(R.id.listViewCareer);
        adapter=new MyAdapter(CareerActivity.this,itemName,imgRes);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i=new Intent(CareerActivity.this,DetailCareer.class);
                i.putExtra("title",itemName[position]);
                i.putExtra("image",imgRes[position]);
                startActivity(i);
            }
        });
    }
}

class MyAdapter extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public MyAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.career_item, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.career_item, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.textViewCareer);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewCareer);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        return rowView;

    };}
