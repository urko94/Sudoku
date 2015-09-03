package com.apps.urban.sudoku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Urban on 31-Aug-15.
 */
public class DBTools extends SQLiteOpenHelper{

    public DBTools(Context applicationContext){

        super(applicationContext, "sudoku.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String query = "CREATE TABLE sudokuGame (sudokuId INTEGER PRIMARY KEY  NOT NULL , sudokuNumbers VARCHAR NOT NULL , sudokuTime INTEGER)";

        database.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS sudokuGame";

        database.execSQL(query);
        onCreate(database);

    }

    public void insertSudoku(HashMap<String, String> queryValues){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("sudokuNumbers", queryValues.get("sudokuNumbers"));
        values.put("sudokuTime", queryValues.get("sudokuTime"));

        database.insert("sudokuGame", null, values);

        database.close();
    }

    public int updateSudoku(HashMap<String, String> queryValues){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("sudokuNumbers", queryValues.get("sudokuNumbers"));
        values.put("sudokuTime", queryValues.get("sudokuTime"));

        return database.update("sudokuGame", values, "sudokuId" + " = ?", new String[] {queryValues.get("sudokuId") });
    }

    public void deleteSudoku(String id){

        SQLiteDatabase database = this.getWritableDatabase();
        String deleteQuery = "DELETE FROM sudokuGame WHERE sudokuId='" + id + "'";

        database.execSQL(deleteQuery);
    }

    public ArrayList<HashMap<String, String>> getAllSudoku(){

        ArrayList<HashMap<String, String>> sudokuArraysList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT * FROM sudokuGame";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                HashMap<String, String> sudokuMap = new HashMap<String, String>();

                sudokuMap.put("sudokuId", cursor.getString(0));
                sudokuMap.put("sudokuNumbers", cursor.getString(1));
                sudokuMap.put("sudokuTime", cursor.getString(2));

                sudokuArraysList.add(sudokuMap);
            }while (cursor.moveToNext());
        }

        return sudokuArraysList;
    }

    public HashMap<String, String> getSudokuInfo(String id){

        HashMap<String, String> sudokuMap = new HashMap<String, String>();
        SQLiteDatabase database = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM sudokuGame WHERE sudokuId='" + id + "'";
        Cursor cursor = database.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){

            do{
                sudokuMap.put("sudokuId", cursor.getString(0));
                sudokuMap.put("sudokuNumbers", cursor.getString(1));
                sudokuMap.put("sudokuTime", cursor.getString(2));
            }while (cursor.moveToNext());
        }

        return sudokuMap;
    }
}
