package com.example.appthoitiet.DBManage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.appthoitiet.Model.history;

import java.util.ArrayList;

public class DBHistory extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="historyone";
    private static final String TABLE_NAME ="historylisview";
    private static final String ID ="id";
    private static final String TRANGTHAITT ="trangthaitt";
    private static final String DAYANDMONTH ="dayandmonth";
    private static final String ICON ="icon";
    private static final String NAME ="name";
    private static final String TIME ="time";
    private static final String TEMPERATURE ="temperature";

    ContentValues values;
    private Context context;

    public DBHistory(Context context) {
        super(context, DATABASE_NAME,null,1);
        Log.d("DBManager", "DBManager: ");
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE "+TABLE_NAME +" (" +
                ID +" integer primary key, "+
                TRANGTHAITT + " TEXT, "+
        DAYANDMONTH + " TEXT, "+
                ICON + " TEXT, "+
                NAME + " TEXT, "+
                TIME +" TEXT, "+
                TEMPERATURE+" integer)";

        db.execSQL(sqlQuery);
        Log.d("DBManager", "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("DBManager", "onUpgrade: ");
    }


    public void addHistory1(history historysql2){

        SQLiteDatabase db = this.getWritableDatabase();
        values = new ContentValues();
        values.put(TRANGTHAITT,historysql2.getTrangthaitt());
        values.put(DAYANDMONTH,historysql2.getDayandmonth());
        values.put(ICON,historysql2.getIcon());
        values.put(NAME, historysql2.getName());
        values.put(TIME, historysql2.getTime());
        values.put(TEMPERATURE, historysql2.getTemperature());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public ArrayList<history> getAllHistory() {
        ArrayList<history> listStudent = new ArrayList<history>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                history historysql = new history();
                historysql.setId(cursor.getInt(0));
                historysql.setTrangthaitt(cursor.getString(1));
                historysql.setDayandmonth(cursor.getString(2));
                historysql.setIcon(cursor.getString(3));
                historysql.setName(cursor.getString(4));
                historysql.setTime(cursor.getString(5));
                historysql.setTemperature(cursor.getInt(6));

                listStudent.add(historysql);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listStudent;
    }
}
