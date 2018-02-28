package com.example.diu.loginapppractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="POS.db";
    private static final String TABLE_NAME_USER="User_table";
    private static final String COL_ID="ID";
    private static final String COL_USER_NAME="USER_NAME";
    private static final String COL_EMAIL="EMAIL";
    private static final String COL_PASSWORD="PASSWORD";
    private static final String COL_PHONE="PHONE";
    private static final String COL_GENDER="GENDER";
    private static final String COL_USER_TYPE="USER_TYPE";
    private SQLiteDatabase db;
    public Database(Context context) {
        super(context,DATABASE_NAME,null,1);
        db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create table query
        String CREATE_TABLE="create table "+TABLE_NAME_USER+"(" +COL_ID+ "'INTEGER PRIMARY KEY AUTOINCREMENT',"+COL_USER_NAME+"'TEXT',"+COL_EMAIL+"'TEXT',"+COL_PASSWORD+"'TEXT',"+COL_PHONE+"'TEXT',"+COL_GENDER+"'TEXT',"+COL_USER_TYPE+"'TEXT')";
        //execute query
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_USER);
        onCreate(sqLiteDatabase);
    }

    public long insertUserInfo(User user){
        long a=0;
        try{
             db=this.getReadableDatabase();
            ContentValues values=new ContentValues();
            values.put(COL_USER_NAME,user.getUsername());
            values.put(COL_EMAIL,user.getEmail());
            values.put(COL_PHONE,user.getPhone());
            values.put(COL_PASSWORD,user.getPassword());
            values.put(COL_GENDER,user.getGender());
            values.put(COL_USER_TYPE,user.getUserType());
            a=db.insert(TABLE_NAME_USER,null,values);

        }
        catch (SQLException exception){
            Log.d("UserInfo Insert:", exception.toString());
        }
        return a;
    }


//login
public boolean verifyLogin(String userName, String password) {

    // array of columns to fetch
    String[] columns = {
            COL_ID
    };
    SQLiteDatabase db = this.getReadableDatabase();
    // selection criteria
    String selection = COL_USER_NAME + " = ?" + " AND " + COL_PASSWORD + " = ?";

    // selection arguments
    String[] selectionArgs = {userName,password};

    // query user table with conditions
    /**
     * Here query function is used to fetch records from user table this function works like we use sql query.
     * SQL query equivalent to this query function is
     * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
     */
    Cursor cursor = db.query(TABLE_NAME_USER, //Table to query
            columns,                    //columns to return
            selection,                  //columns for the WHERE clause
            selectionArgs,              //The values for the WHERE clause
            null,                       //group the rows
            null,                       //filter by row groups
            null);                      //The sort order

    int cursorCount = cursor.getCount();

    cursor.close();
    db.close();
    if (cursorCount > 0) {
        return true;
    }

    return false;
}


}
