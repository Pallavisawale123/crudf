package com.example.crudf.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.crudf.model.Contact;
import com.example.crudf.model.UserAct;
import com.example.crudf.params.Params;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MyDbHelper extends SQLiteOpenHelper {

    /*private static final String CREATE_TABLE_TODO = "CREATE TABLE "
            + TABLE_TODO + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TODO
            + " TEXT," + KEY_STATUS + " INTEGER," + KEY_CREATED_AT
            + " DATETIME" + ")";
package com.example.crudf.model;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;
   // private int id1;
    private String from1;
    private String to1;
    private  String created_at;


}

    // Tag table create statement
    private static final String CREATE_TABLE_TAG = "CREATE TABLE " + TABLE_TAG
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TAG_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";
 */
    private static final String create = "CREATE TABLE " + Params.TABLE_NAME + "("
            + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_NAME
            + " TEXT, " + Params.KEY_PHONE + " TEXT" + ")";
   private static final String create2 = "CREATE TABLE " + Params.TABLE_NAME2 + "("
            + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_FROM
            + " TEXT, " + Params.KEY_TO + " TEXT," + Params.KEY_TIME + " TEXT" + ")";
      //  Log.d("dbh", "second Query being run is : "+ create1);


    public MyDbHelper(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create);
        db.execSQL(create2);

        Log.d("dbh", "Query being run is : "+ create);
       //// db.execSQL(create);

        Log.d("dbh", "second Query being run is : "+ create2);
      //  db.execSQL(create1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Params.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +  Params.TABLE_NAME2);
       // db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO_TAG);

        // create new tables
        onCreate(db);

    }
    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, contact.getName());
        values.put(Params.KEY_PHONE, contact.getPhoneNumber());


        db.insert(Params.TABLE_NAME, null, values);

        Log.d("dbh", "Successfully inserted");

        ContentValues values1 = new ContentValues();
        values1.put(Params.KEY_FROM, contact.getFrom1 ());
        values1.put(Params.KEY_TO, contact.getTo1 ());
        values1.put(Params.KEY_TIME,contact.getCreated_at ());


        db.insert(Params.TABLE_NAME2, null, values1);
        Log.d("dbh", "Successfully inserted");

        db.close();


    }
    public List<Contact> getAllContacts(){
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if(cursor.moveToFirst()){
            do{
                Contact contact=new Contact ( );
                //Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contactList.add(contact);
            }while(cursor.moveToNext());

        }
        return contactList;
    }

    public int updateContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, contact.getName());
        values.put(Params.KEY_PHONE, contact.getPhoneNumber());

        //Lets update now
        return db.update(Params.TABLE_NAME, values, Params.KEY_ID + "=?",
                new String[]{String.valueOf(contact.getId())});

    }

    public void deleteById(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.TABLE_NAME,Params.KEY_ID +"=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void deleteContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.TABLE_NAME,Params.KEY_ID +"=?", new String[]{String.valueOf(contact.getId())});
        db.close();
    }

    public int getCount(){
        String query = "SELECT * FROM "+ Params.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);
        return c.getCount();
    }
   /* private String getDateTime()
    {
        SimpleDateFormat sd=new SimpleDateFormat ("yyyy-MM-ddcHH:mm:ss", Locale.getDefault ());
        Date d=new Date ();
        return sd.format(d);
    }*/

}
