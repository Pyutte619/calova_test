package com.example.piyut.calovatest;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;

/**
 * Created by piyut on 20/05/2015.
 */
public class ChoiceInterest extends Activity{

    private StaggeredGridView gridView;
    private GridViewAdapter gridAdapter;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interest_choice);

        gridView = (StaggeredGridView) findViewById(R.id.grid_view);
        gridAdapter = new GridViewAdapter(this, R.layout.choice_item, getData());
        gridView.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE);

        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ChoiceInterest.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    next= (Button) findViewById(R.id.buttonNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ChoiceInterest.this,CareerActivity.class);
                startActivity(i);
            }
        });

    }
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.imgs);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
        }
        return imageItems;
    }
}
