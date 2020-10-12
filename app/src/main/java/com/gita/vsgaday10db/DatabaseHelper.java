package com.gita.vsgaday10db;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import java.util.ArrayList;

public class DatabaseHelper {

    public static String DATABASE_NAME = "student_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_STUDENTS = "students";
    private static final String KEY_ID = "id";
    private static final String KEY_FIRSTNAME = "name";

    private static final String CREATE_TABLE_STUDENT = "CREATE TABLE"
            + TABLE_STUDENTS + "(" + KEY_ID
            + "INTEGER," + KEY_FIRSTNAME + "TEXT );";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d("table", CREATE_TABLE_STUDENT);
    }
}
