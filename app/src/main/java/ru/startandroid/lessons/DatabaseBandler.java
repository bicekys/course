package ru.startandroid.lessons;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;

/**
 * Created by Пользователь on 19.05.2019.
 */

public class DatabaseBandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="data.db";

    private static final String TABLE_NAME="info";

    //fields
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_INFORMATION="inform";

    SQLiteDatabase database;
    public DatabaseBandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    database=getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("CREATE TABLE"+ TABLE_NAME+"("+COLUMN_ID+"INTEGER PRIMARY KEY,"+COLUMN_NAME+"TEXT,"+COLUMN_INFORMATION+"TEXT");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop"+TABLE_NAME);
        onCreate(db);
    }
}
