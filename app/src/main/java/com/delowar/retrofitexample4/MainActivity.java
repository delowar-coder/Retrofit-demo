package com.delowar.retrofitexample4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapter.CustomAdapter;
import Interface.ApiClientClass;
import modelClass.ArrayDesignClass;
import modelClass.Teams;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
     private List<Teams> teamsList;
     private GridView gridView;
     private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=findViewById(R.id.grid_view);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MainActivity.this,DisplayActivity.class).putExtra("key",teamsList.get(i)));
            }
        });
        teamsList=new ArrayList<>();
        Call<ArrayDesignClass> callApi=getApiClients().getAllTeams(
                "4T5MKzBnypzju4LpC7p1Q0Up3vfuthzW6M0cKXvq0e3cUXZHxEqkMeXarRAb");
        callApi.enqueue(new Callback<ArrayDesignClass>() {
            @Override
            public void onResponse(Call<ArrayDesignClass> call, Response<ArrayDesignClass> response) {
                if (response.isSuccessful()){
                    teamsList=response.body().getData();

                    customAdapter=new CustomAdapter(getApplicationContext(),teamsList);
                    gridView.setAdapter(customAdapter);
                    /*Log.d("Total array list","size is :"+teamsList.size());*/
                }else {
                    String message="An error occurred try again leter...";
                    Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayDesignClass> call, Throwable t) {
                String message=t.getLocalizedMessage();
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static Retrofit getRetrofit(){
         Retrofit retrofit=new Retrofit.Builder()
                  .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();
         return retrofit;
    }
    public static ApiClientClass getApiClients(){
        ApiClientClass apiClientClass=getRetrofit().create(ApiClientClass.class);
        return apiClientClass;
    }

}