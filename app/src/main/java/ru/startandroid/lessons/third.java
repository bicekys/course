package ru.startandroid.lessons;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;



public class third extends second {
    private static final String TAG = "MainActivity";

    private adapt mSectionsPageAdapter;

    private ViewPager mViewPager;
    ImageView btn_favourites;
  /*  IItemClickListener itemClickListener;
    public void setItemClickListener(IItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new adapt(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        btn_favourites=(ImageView) findViewById(R.id.favorite_button);
        setupViewPager(mViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapt adapter = new adapt(getSupportFragmentManager());
        adapter.addFragment(new tab1frag(), "Инфо ");
        adapter.addFragment(new tab2frag(), "Фото");
        adapter.addFragment(new tab3frag(), "Видео");
        viewPager.setAdapter(adapter);
    }

}




