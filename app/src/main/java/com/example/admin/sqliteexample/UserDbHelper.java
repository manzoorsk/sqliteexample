package com.example.admin.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by admin on 9/6/2016.
 */
public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="USERINFO.DB";
    private static final int DATABASE_VERSION=1;
    private static final String CREATE_QUERY=
            "CREATE TABLE "+ UserContract.NewUserInfo.TABLE_NAME+"("+ UserContract.NewUserInfo.USER_NAME+" TEXT, "+
                    UserContract.NewUserInfo.USER_MOB+" TEXT, "+ UserContract.NewUserInfo.USER_EMAIL+" TEXT);";

    public UserDbHelper(Context context){
        super(context ,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Database created / opened.....");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Table Created.....");

    }


    public void addInformations(String name,String mob,String email,SQLiteDatabase db){
        ContentValues contentValues=new ContentValues();
        contentValues.put(UserContract.NewUserInfo.USER_NAME,name);
        contentValues.put(UserContract.NewUserInfo.USER_MOB,mob);
        contentValues.put(UserContract.NewUserInfo.USER_EMAIL,email);
        try {
            db.insert(UserContract.NewUserInfo.TABLE_NAME,null,contentValues);
            Log.e("DATABASE OPERATIONS","One row is inserted.....");
        }catch (Exception e){

        }return;

//        db.insert(UserContract.NewUserInfo.TABLE_NAME,null,contentValues);
//        Log.e("DATABASE OPERATIONS","One row is inserted.....");

    }

    public Cursor getInformations(SQLiteDatabase db){

        Cursor cursor;
        String[] projections ={UserContract.NewUserInfo.USER_NAME, UserContract.NewUserInfo.USER_MOB, UserContract.NewUserInfo.USER_EMAIL};
        cursor=db.query(UserContract.NewUserInfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVwrsion) {

    }
}
