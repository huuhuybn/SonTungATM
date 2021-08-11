package com.example.finaltest.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(Context context) {
        super(context, "final", null, 1);
    }

    public void SendData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public Cursor GetData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE LOP(MaLop TEXT PRIMARY KEY )");
        sqLiteDatabase.execSQL("CREATE TABLE SINHVIEN(MaSV TEXT PRIMARY KEY , MAMON TEXT, DIEM INTERGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LOP");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SINHVIEN");
        onCreate(sqLiteDatabase);
    }
}
