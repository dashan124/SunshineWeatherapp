package com.example.android.sunshine.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dashan on 30/3/18.
 */

public class WeatherDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="weather.db";
    private static final int DATABASE_VERSION =1;
    public WeatherDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_WEATHER_TABLE =

                "CREATE TABLE " + WeatherContract.WeatherEntry.TABLE_NAME + " (" +

                /*
                 * WeatherEntry did not explicitly declare a column called "_ID". However,
                 * WeatherEntry implements the interface, "BaseColumns", which does have a field
                 * named "_ID". We use that here to designate our table's primary key.
                 */
                        WeatherContract.WeatherEntry._ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                        WeatherContract.WeatherEntry.COLUMN_DATE       + " INTEGER, "                 +

                        WeatherContract.WeatherEntry.COLUMN_WEATHER_ID + " INTEGER, "                 +

                        WeatherContract.WeatherEntry.COLUMN_MIN_TEMP   + " REAL, "                    +
                        WeatherContract.WeatherEntry.COLUMN_MAX_TEMP   + " REAL, "                    +

                        WeatherContract.WeatherEntry.COLUMN_HUMIDITY   + " REAL, "                    +
                        WeatherContract.WeatherEntry.COLUMN_PRESSURE   + " REAL, "                    +

                        WeatherContract.WeatherEntry.COLUMN_WIND_SPEED + " REAL, "                    +
                        WeatherContract.WeatherEntry.COLUMN_DEGREES    + " REAL" + ");";

        /*
         * After we've spelled out our SQLite table creation statement above, we actually execute
         * that SQL with the execSQL method of our SQLite database object.
         */
        db.execSQL(SQL_CREATE_WEATHER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
