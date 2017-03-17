package com.example.admin.sqliteexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DataListActivity extends AppCompatActivity {

    ListView list_view;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);
        list_view=(ListView)findViewById(R.id.list_view);
        listDataAdapter=new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        list_view.setAdapter(listDataAdapter);
        userDbHelper=new UserDbHelper(getApplicationContext());
        sqLiteDatabase=userDbHelper.getReadableDatabase();
        cursor=userDbHelper.getInformations(sqLiteDatabase);
        if (cursor.moveToFirst()){
            do{
                String name,mob,email;
                name=cursor.getString(0);
                mob=cursor.getString(1);
                email=cursor.getString(2);
                DataProvider dataProvider=new DataProvider(name,mob,email);
                listDataAdapter.add(dataProvider);

            }while (cursor.moveToNext());
        }
    }
}
