package ru.startandroid.lessons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;

public class third extends AppCompatActivity {
    TextView name;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //DatabaseBandler databaseBandler= new DatabaseBandler(this);

        name = (TextView) findViewById(R.id.griddata);
        image = (ImageView) findViewById(R.id.imageView);
        Intent intent = getIntent();

        //name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image", 0));
        String text = " ";
        try {
            InputStream is = getAssets().open("mytext.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();

        }
        name.setText(text);
    }
}