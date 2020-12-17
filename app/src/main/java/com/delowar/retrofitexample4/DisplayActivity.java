package com.delowar.retrofitexample4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import modelClass.Teams;

public class DisplayActivity extends AppCompatActivity {
    private Teams teamsList;
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        imageView=findViewById(R.id.select_image);
        textView=findViewById(R.id.select_name);

        Intent intent=getIntent();
        if (intent.getExtras()!=null){
            teamsList= (Teams) intent.getSerializableExtra("key");
            textView.setText(teamsList.getName());
            Picasso.get().load(teamsList.getImage_path())
                    .into(imageView);
           /* Log.e("data",name);*/
        }
    }
}