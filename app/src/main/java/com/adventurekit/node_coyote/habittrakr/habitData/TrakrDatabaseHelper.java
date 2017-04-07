package com.adventurekit.node_coyote.habittrakr.habitData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.adventurekit.node_coyote.habittrakr.habitData.TrakrContract.TrakrEntry;

/**
 * Created by node_coyote on 4/6/17.
 */

/**
 * Manages database creation and versioning for HabitTrakr app
 */
public class TrakrDatabaseHelper extends SQLiteOpenHelper {

    // Name of the actual database file
    private static final String DATABASE_NAME = "trakr.db";

    // Database version. If schema changes, this number should be incremented
    private static final int DATABASE_VERSION = 1;

    /**
     * Use this constructor to create a new {@link TrakrDatabaseHelper}
     *
     * @param context get the context
     */
    public TrakrDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // onCreate builds a new database if one does not already exist
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL create table String
        String SQL_CREATE_TRAKR_TABLE = "CREATE TABLE " + TrakrEntry.TABLE_NAME + " ("
                + TrakrEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TrakrEntry.COLUMN_JOURNAL + " INTEGER NOT NULL DEFAULT 0, "
                + TrakrEntry.COLUMN_EXERCISE + " INTEGER NOT NULL DEFAULT 0. "
                + TrakrEntry.COLUMN_GOALS + " TEXT, "
                + TrakrEntry.COLUMN_KINDNESS + " TEXT);";

        // Execute SQL string statement
        db.execSQL(SQL_CREATE_TRAKR_TABLE);

    }

    // Use to upgrade the database to a new version with the DATABASE_VERSION constant
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // We won't be upgrading yet, but maybe later
    }
}
