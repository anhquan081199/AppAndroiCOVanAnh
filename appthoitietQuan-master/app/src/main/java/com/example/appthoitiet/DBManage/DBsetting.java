package com.example.appthoitiet.DBManage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.appthoitiet.Model.setting;

import java.util.ArrayList;

public class DBsetting extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="DBsetting";
    private static final String TABLE_NAME ="setting";
    private static final String ID ="id";
    private static final String LANGUAGE ="language";
    private static final String NHIETDOST ="nhietdost";
    private static final String TDGIO ="tdgio";

    ContentValues values;
    private Context context;

    public DBsetting(Context context) {
        super(context, DATABASE_NAME,null,1);
        Log.d("DBsetting", "DBsetting: ");
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE "+TABLE_NAME +" (" +
                ID +" integer primary key, "+
                LANGUAGE + " integer, "+
                NHIETDOST +" integer, "+
               TDGIO+" integer)";

        db.execSQL(sqlQuery);
        Log.d("DBManager", "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("DBManager", "onUpgrade: ");
    }


    public void addSetting(setting settingsql){

        SQLiteDatabase db = this.getWritableDatabase();
        values = new ContentValues();
        values.put(LANGUAGE, settingsql.getLanguage());
        values.put(NHIETDOST, settingsql.getNhietdost());
        values.put(TDGIO, settingsql.getTdgio());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }



    public ArrayList<setting> getAllSetting() {
        ArrayList<setting> listWeather = new ArrayList<setting>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
               setting settingsql=new setting();
               settingsql.setId(cursor.getInt(0));
               settingsql.setLanguage(cursor.getInt(1));
              settingsql.setNhietdost(cursor.getInt(2));
               settingsql.setTdgio(cursor.getInt(3));

                listWeather.add(settingsql);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listWeather;
    }

    public int Updatelanguage(setting settingsql){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(LANGUAGE,settingsql.getLanguage());

        return db.update(TABLE_NAME,values,ID +"=?",new String[] { String.valueOf(settingsql.getId())});


    }
    public int Updatenhietdo(setting settingsql){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NHIETDOST,settingsql.getNhietdost());

        return db.update(TABLE_NAME,values,ID +"=?",new String[] { String.valueOf(settingsql.getId())});


    }
    public int Updatetdgio(setting settingsql){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TDGIO,settingsql.getTdgio());

        return db.update(TABLE_NAME,values,ID +"=?",new String[] { String.valueOf(settingsql.getId())});

    }
}

