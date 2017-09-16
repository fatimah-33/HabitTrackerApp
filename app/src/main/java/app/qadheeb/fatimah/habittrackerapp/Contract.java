package app.qadheeb.fatimah.habittrackerapp;

import android.provider.BaseColumns;

/**
 * Created by fatimah on 9/16/17.
 */

public class Contract {
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "habitDatabase";


    static final String CREATE_TABLE = "CREATE TABLE " + HabitData.TABLE_NAME + "(" + HabitData.KEY_ID +
            " INTEGER PRIMARY KEY" + "," + HabitData.HABIT_NAME + " TEXT" + ")";

    static final String DROP_TABLE = "DROP TABLE IF EXISTS " + HabitData.TABLE_NAME;

    public static abstract class HabitData implements BaseColumns {
        public static final String TABLE_NAME = "habit";
        public static final String KEY_ID = "id";
        public static final String HABIT_NAME = "habit_name";
    }


}
