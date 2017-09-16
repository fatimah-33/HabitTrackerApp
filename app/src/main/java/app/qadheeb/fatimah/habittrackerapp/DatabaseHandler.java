package app.qadheeb.fatimah.habittrackerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static app.qadheeb.fatimah.habittrackerapp.Contract.CREATE_TABLE;
import static app.qadheeb.fatimah.habittrackerapp.Contract.DATABASE_VERSION;
import static app.qadheeb.fatimah.habittrackerapp.Contract.DATABASE_NAME;
import static app.qadheeb.fatimah.habittrackerapp.Contract.DROP_TABLE;
import static app.qadheeb.fatimah.habittrackerapp.Contract.HabitData.HABIT_NAME;
import static app.qadheeb.fatimah.habittrackerapp.Contract.HabitData.KEY_ID;
import static app.qadheeb.fatimah.habittrackerapp.Contract.HabitData.TABLE_NAME;


/**
 * Created by fatimah on 9/16/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);

    }

    public void insert(int keyId, String name) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, keyId);
        contentValues.put(HABIT_NAME, name);
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    public Cursor readData() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projection = {KEY_ID, HABIT_NAME};

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }
}
