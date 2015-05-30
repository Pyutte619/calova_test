package com.example.piyut.calovatest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by piyut on 21/05/2015.
 */
public class DetailCareer extends Activity{
    String title;
    int imageRes;
    ImageView image;
    TextView titleText,deskText;
    Button btnPickCareer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_career);

        title=getIntent().getStringExtra("title").toString();
        imageRes=getIntent().getIntExtra("image",0);
        btnPickCareer= (Button) findViewById(R.id.pickCareer);

        image= (ImageView) findViewById(R.id.imageViewDetail);
        titleText= (TextView) findViewById(R.id.textViewDetailTitile);
        deskText= (TextView) findViewById(R.id.textViewdetailDeskrip);
        titleText.setText("title");
        image.setImageResource(imageRes);
        deskText.setText("htfhv jfhjgdgfgf hjkgfgdgf ghdfjfd");

       btnPickCareer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(DetailCareer.this,MainMenu.class);
               startActivity(i);
           }
       });
    }
}
