package ru.startandroid.lessons;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.List;

public class second extends AppCompatActivity {

GridView gridView;
    String[] placeName={"Торе","Хадын","Азас"};
    int[] placeImg= {R.drawable.tore,R.drawable.azas,R.drawable.had};
    //int fav_image={R.drawable.ico


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //localBd=new DatabaseBandler(this);


           gridView = (GridView)findViewById(R.id.gridview);
           final CustomAdapter customAdapter= new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Intent intent= new Intent(getApplicationContext(),third.class);
        intent.putExtra("name",placeName[i]);
        intent.putExtra("image",placeImg[i]);
        Context context;
        startActivity(intent);}
        });
        }
private class CustomAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return placeImg.length;
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
        View viewl=(View) getLayoutInflater().inflate(R.layout.gridlayout,null);
        TextView name=(TextView) viewl.findViewById(R.id.places);
        ImageView image=(ImageView) viewl.findViewById(R.id.images);
  //      ImageView fav_image=(ImageView)viewl.findViewById(R.id.fav);
        name.setText(placeName[i]);
        image.setImageResource(placeImg[i]);
        return viewl;
       // if(localBd.IsFav(gridView.getAdapter{

    }

    };}







