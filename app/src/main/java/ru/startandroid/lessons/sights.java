package ru.startandroid.lessons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class sights extends AppCompatActivity {
        GridView gridView;
        String[] sigtName={"Центр","Музей"};
        int[] sigtImg= {R.drawable.centerasia,R.drawable.musuam};
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sights);


            gridView = (GridView)findViewById(R.id.gridview);
            ru.startandroid.lessons.sights.CustomAdapter customAdapter= new ru.startandroid.lessons.sights.CustomAdapter();
            gridView.setAdapter(customAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                    Intent intent= new Intent(getApplicationContext(),third.class);
                    intent.putExtra("name",sigtName[i]);
                    intent.putExtra("image",sigtImg[i]);
                    startActivity(intent);}
            });
        }
        private class CustomAdapter extends BaseAdapter {
            @Override
            public int getCount() {
                return sigtImg.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View viewl=(View) getLayoutInflater().inflate(R.layout.gridlayoutsigths,null);
                TextView name=(TextView) viewl.findViewById(R.id.places);
                ImageView image=(ImageView) viewl.findViewById(R.id.images);
                name.setText(sigtName[i]);
                image.setImageResource(sigtImg[i]);
                return viewl;
            }}}

