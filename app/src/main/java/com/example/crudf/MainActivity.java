package com.example.crudf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.crudf.adapter.RecyclerViewAdapter;
import com.example.crudf.data.MyDbHelper;
import com.example.crudf.model.Contact;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayAdapter<String> arrayAdapter;
    private String getDateTime()
    {
        SimpleDateFormat sd=new SimpleDateFormat ("yyyy-MM-ddcHH:mm:ss", Locale.getDefault ());
        Date d=new Date ();
        return sd.format(d);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recyclerview initialization
        recyclerView = findViewById(R.id.recView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        MyDbHelper db = new MyDbHelper(MainActivity.this);

        // Creating a contact object for the db
        Contact contact = new Contact();
        contact.setPhoneNumber("9421847552");
        contact.setName("pallavi");
        Contact contact2 = new Contact();
        contact2.setPhoneNumber("7070655000");
        contact2.setName("pooja");
           // String ss=getDateTime();
       Contact contact3 = new Contact();
        contact3.setFrom1 ( "main" );
       contact3.setTo1 ( "le" );
       contact3.setCreated_at ( getDateTime() );
       db.addContact ( contact3 );
        // Adding a contact to the db;
            //String dvalue=((MainActivity)getCallingActivity ()).getDateTime;
        db.addContact(contact);
       // db.addContact(contact);
        //db.addContact(contact);
        db.addContact(contact2);
       // db.addContact(contact2);



        // Get all contacts
        List<Contact> contactList = db.getAllContacts();

//        Use your recyclerView
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactList);
        recyclerView.setAdapter(recyclerViewAdapter);

        Log.d("dbh", "sis you have "+ db.getCount()+ " contacts in your database");


    }
}
