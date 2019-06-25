package ru.startandroid.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivitynew extends AppCompatActivity {
    ListView listView;
    private String titles[] = {
            " Природа",
            " Достопримечательности",
            " Туры",
            " Избранное",
            " Прогноз погоды",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitynew);//к какому лейауту привязан активити

        // Получим идентификатор ListView компонент
        listView = (ListView) findViewById(R.id.listView);
        //устанавливаем массив в ListView

     ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.activity_list_item,android.R.id.text1,titles
             );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent myintent= new Intent(view.getContext(),second.class);
                    startActivityForResult(myintent,0);}

                if (position==1){
                    Intent myintent= new Intent(view.getContext(),sights.class);
                    startActivityForResult(myintent,0);}

               if (position==2){
                    Intent myintent= new Intent(view.getContext(),tours.class);
                    startActivityForResult(myintent,0);}
                if (position==3) {
                        Intent myintent = new Intent(view.getContext(), save.class);
                        startActivityForResult(myintent, 0);
                    }
                if (position==4) {
                    Intent myintent = new Intent(view.getContext(), forecast.class);
                    startActivityForResult(myintent, 0);
                }
            }}

        );}}
        //Обрабатываем щелчки на элементах ListView:



