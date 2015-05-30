package com.example.piyut.calovatest;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by piyut on 21/05/2015.
 */
public class MainMenu extends Activity {
    ListView list;
    MyMainAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        String[] items={"Task","Progress","Opportunity"};
        Integer[] imageres={R.drawable.computer,R.drawable.film,R.drawable.microscope};
        list= (ListView) findViewById(R.id.listViewMainMenu);
        adapter= new MyMainAdapter(MainMenu.this,items,imageres);
        list.setAdapter(adapter);
    }
}

class MyMainAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public MyMainAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.main_meni_item, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.career_item, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.textViewMainMenu);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewMainMenu);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        return rowView;

    }}
