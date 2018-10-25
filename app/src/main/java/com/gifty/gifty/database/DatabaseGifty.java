package com.gifty.gifty.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/*This is the helper class that establishes the connection with the database
*file in the assets folder and allows the queries that are made to be fetched.
*/

public class DatabaseGifty extends SQLiteOpenHelper {
    private static String DB_NAME = "Gifty.db";
    private static String DB_PATH = "";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase myDataBase;
    private final Context context;
    private boolean mNeedUpdate=false;



    public DatabaseGifty(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        //setting the location of the database file
        DB_PATH="/data/data/" + context.getPackageName() + "/databases/";

        copyDataBase();

        this.getReadableDatabase();

    }

    //a method for updating the database
    public void updateDataBase() throws IOException {
        if (mNeedUpdate) {
            File dbFile = new File(DB_PATH + DB_NAME);
            if (dbFile.exists())
                dbFile.delete();
            copyDataBase();
            mNeedUpdate = false;
        }
    }



    //a method to check if the database exists
    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }


    //Copy the database file if it doesn't exist
    private void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }


    //method for copying the database file
    private void copyDBFile() throws IOException {

        String appDataPath = context.getApplicationInfo().dataDir;

        File dbFolder = new File(appDataPath + "/databases");//Make sure the /databases folder exists
        dbFolder.mkdir();//This can be called multiple times.

        File dbFilePath = new File(appDataPath + "/databases/Gifty.db");

        try {
            InputStream inputStream = context.getAssets().open("Gifty.db");
            OutputStream outputStream = new FileOutputStream(dbFilePath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer))>0)
            {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e){
            //handle
        }
    }

    //a method for opening the database file

    public boolean openDataBase() throws SQLException {
        myDataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return myDataBase != null;
    }


    //a method for closing the database
    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            mNeedUpdate = true;
    }
}
