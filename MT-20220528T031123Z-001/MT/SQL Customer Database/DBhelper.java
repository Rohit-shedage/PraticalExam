package com.example.customer;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    public DBhelper(MainActivity mainActivity) {
        super(mainActivity, "Customer.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table CustomerDetails(name TEXT primary key, email_address TEXT, contact NUM) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists CustomerDetails");

    }

    public boolean insertData(String name, String email_address, String contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email_address", email_address);
        contentValues.put("contact", contact);

        long result = db.insert("CustomerDetails", null,  contentValues);

        if(result == -1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }

    public boolean updateData(String name, String email_address, Number contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email_address", email_address);
        contentValues.put("contact", (Integer) contact);

        Cursor cursorUpdate = db.rawQuery("Select * from CustomerDetails where name = ?", new String[]{name});

        if (cursorUpdate.getCount() > 0)
        {
            long result = db.update("CustomerDetails", contentValues, "name = ?", new String[]{name});

            if(result == -1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        return false;
    }

    public boolean deleteData(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursorDelete = db.rawQuery("Select * from CustomerDetails where name = ?", new String[]{name});

        if (cursorDelete.getCount() > 0)
        {
            long result = db.delete("CustomerDetails", "name = ?", new String[]{name});

            if(result == -1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        return false;
    }

    public Cursor viewData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursorView = db.rawQuery("Select * from CustomerDetails", null);
        return cursorView;
    }
}