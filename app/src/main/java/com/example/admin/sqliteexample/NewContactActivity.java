package com.example.admin.sqliteexample;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class NewContactActivity extends Activity {
    EditText ContactName, ContactMobile, ContactEmail;
    Button Save;
    Context context=this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        ContactName=(EditText)findViewById(R.id.ContactName);
        ContactMobile=(EditText)findViewById(R.id.ContactMobile);
        ContactEmail=(EditText)findViewById(R.id.ContactEmail);
        Save=(Button)findViewById(R.id.Save);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=ContactName.getText().toString();
                String mob=ContactMobile.getText().toString();
                String email=ContactEmail.getText().toString();
                userDbHelper=new UserDbHelper(context);
                sqLiteDatabase=userDbHelper.getWritableDatabase();
                userDbHelper.addInformations(name,mob,email,sqLiteDatabase);
                Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
                userDbHelper.close();
            }
        });
    }



//    public void addContact(){
//        String name=ContactName.getText().toString();
//        String mob=ContactMobile.getText().toString();
//        String email=ContactEmail.getText().toString();
//        userDbHelper=new UserDbHelper(context);
//        sqLiteDatabase=userDbHelper.getWritableDatabase();
//        userDbHelper.addInformations(name,mob,email,sqLiteDatabase);
//
//    }

}
