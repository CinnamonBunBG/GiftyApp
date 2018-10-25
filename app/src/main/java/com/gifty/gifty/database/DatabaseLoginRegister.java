package com.gifty.gifty.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gifty.gifty.login.User;

import java.util.ArrayList;
import java.util.List;
// A class dealing with the database that hold the users and their details
public class DatabaseLoginRegister extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_USER = "user";
    private static final String COLUMN_ID = "user_id";
    private static final String COLUMN_NAME = "user_name";
    private static final String COLUMN_EMAIL = "user_email";
    private static final String COLUMN_PASSWORD = "user_password";

// sql query for the creation of the table holding the users
    private String CREATE_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT,"
            + COLUMN_EMAIL + " TEXT," + COLUMN_PASSWORD + " TEXT" + ")";


    private String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;


    // Constructor
    public DatabaseLoginRegister(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    //create the db
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }


    //upgrade method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //if it exists
        db.execSQL(DROP_TABLE);

        // Create table again
        onCreate(db);

    }

    //A method to add user

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASSWORD, user.getPassword());

        db.insert(TABLE_USER, null, values);
        db.close();
    }


    //A method to check if the user exists
    public boolean checkUser(String email) {


        String[] columns = {
                COLUMN_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COLUMN_EMAIL + " = ?";

        String[] selectionArgs = {email};

        // sql query
        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

     //A method to check if the user exists
    public boolean checkUser(String email, String password) {

        String[] columns = {
                COLUMN_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_EMAIL + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};

        // sql query

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}