package ru.startandroid.lessons;



import android.content.Context;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;

import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v4.util.CircularArray;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Пользователь on 19.05.2019.
 */

public class DatabaseBandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static String DATABASE_NAME="mydb.db";
    private static String DB_PATH="";
Context mContext=null;

    public SQLiteDatabase myDataBase;

    public DatabaseBandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    this.mContext=context;
        if (Build.VERSION.SDK_INT>=17)
         DB_PATH=context.getApplicationInfo().dataDir+"/databases/";
    else
        DB_PATH="/data/data/"+context.getPackageName()+"/databases/";
        CopDataBase();
        this.getReadableDatabase();
    }


    private boolean check(){
        SQLiteDatabase tempdb=null;
        try {
            String path=DB_PATH+DATABASE_NAME;
            tempdb=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READWRITE);

        }
        catch (Exception ex){

        }
        if (tempdb!=null)
            tempdb.close();
        return tempdb!=null?true:false;
    }

    public void CopDataBase() {
        InputStream myinput = null;
        OutputStream myoutput = null;
        try {
            myinput = mContext.getAssets().open(DATABASE_NAME);
            String outFilename = DB_PATH + DATABASE_NAME;
            myoutput = new FileOutputStream(outFilename);

            byte[] buffer = new byte[1024];
            int lengt;
            while ((lengt = myinput.read(buffer)) > 0) {
                myoutput.write(buffer, 0, lengt);
            }
            myoutput.flush();
            myoutput.close();
            myinput.close();
        }

    catch(IOException ex){

    }

  }
  public void openData(){
      String path=DB_PATH+DATABASE_NAME;
      myDataBase=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READWRITE);
  }
  public void create()
  {
      boolean isexist=check();
      if (isexist){
  }else {
  this.getReadableDatabase();
          try {
              CopDataBase();
          }
          catch (Exception ex)
              {

  }}}


  public List<Account> getAllUsers(){
        List<Account> temp=new ArrayList<Account>();
      SQLiteDatabase db=this.getWritableDatabase();
      Cursor c;
      try {
          c=db.rawQuery("SELECT * FROM INFOS",null);
          if(c==null) return  null;
          c.moveToFirst();
do {
    Account account=new Account(c.getString(c.getColumnIndex("name")),c.getString(c.getColumnIndex("info")));
    temp.add(account);


}while (c.moveToNext());
          c.close();
      }catch (Exception ex){}
      db.close();
      return temp;
    };
    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }}



    /* //избранное
  public void AddToFav(String PlaceId){
      SQLiteDatabase db=getReadableDatabase();
      String query=String.format("INSERT INTO Favorites(PlaceId) VALUES('%s');",PlaceId);
  }
      public void RemoveToFav(String PlaceId){
          SQLiteDatabase db=getReadableDatabase();
          String query=String.format("DELETE FROM Favorites WHERE PlaceId='%s');",PlaceId);
      }
      public boolean IsFav(String PlaceId){
          SQLiteDatabase db=getReadableDatabase();
          String query=String.format("SELECT*FROM Favorites WHERE PlaceId='%s');",PlaceId);
          Cursor cursor=db.rawQuery(query,null);
          if(cursor.getCount()<=0){
              cursor.close();
              return false;
          }
          cursor.close();
          return true;
      }
  */


