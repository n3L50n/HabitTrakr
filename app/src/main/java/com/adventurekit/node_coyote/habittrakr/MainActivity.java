package com.adventurekit.node_coyote.habittrakr;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.adventurekit.node_coyote.habittrakr.habitData.TrakrDatabaseHelper;
import com.adventurekit.node_coyote.habittrakr.habitData.TrakrContract.TrakrEntry;

public class MainActivity extends AppCompatActivity {

    // Database helper variable gives access to the database
    private TrakrDatabaseHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Reads a from the rows of habit objects in the database
     */
    private Cursor readHabit(int id) {

        // Create or open a database, then read from it
        SQLiteDatabase db = mHelper.getReadableDatabase();

        String[] projection = {
                TrakrEntry._ID,
                TrakrEntry.COLUMN_JOURNAL,
                TrakrEntry.COLUMN_EXERCISE,
                TrakrEntry.COLUMN_GOALS,
                TrakrEntry.COLUMN_KINDNESS};

        // Query the Trakr table
        Cursor cursor = db.query(
                TrakrEntry.TABLE_NAME,      // The table to query
                projection,                 // The columns to return
                null,                       // The columns for the WHERE clause
                null,                       // The values for the WHERE clause
                null,                       // Don't group the rows
                null,                       // Don't filter by row groups
                null);                     // The sort order

        try {
            int idColumnIndex = cursor.getColumnIndex(TrakrEntry._ID);
            int journalColumnIndex = cursor.getColumnIndex(TrakrEntry.COLUMN_JOURNAL);
            int exerciseColumnIndex = cursor.getColumnIndex(TrakrEntry.COLUMN_EXERCISE);
            int goalsColumnIndex = cursor.getColumnIndex(TrakrEntry.COLUMN_GOALS);
            int kindnessColumnIndex = cursor.getColumnIndex(TrakrEntry.COLUMN_KINDNESS);

            // Iterate through the rows returned in the cursor
            // while loop will continue until there are no more rows
            while (cursor.moveToNext()) {

                int currentId = cursor.getInt(idColumnIndex);
                int currentJournal = cursor.getInt(journalColumnIndex);
                int currentExercise = cursor.getInt(exerciseColumnIndex);
                int currentGoals = cursor.getInt(goalsColumnIndex);
                int currentKindness = cursor.getInt(kindnessColumnIndex);

                // Do cool stuff with these values like add them to a UI  :)
            }

        } finally {
            // Clean the dishes
            cursor.close();
        }
        return cursor;
    }

    /**
     * Inserts a habit object into the database
     */
    private void insertHabit() {
        // Place database in write mode
        SQLiteDatabase db = mHelper.getWritableDatabase();

        // Create a Content Values object with column names as keys
        // and habits as values
        ContentValues values = new ContentValues();
        values.put(TrakrEntry.COLUMN_JOURNAL, TrakrEntry.WROTE_IN_JOURNAL);
        values.put(TrakrEntry.COLUMN_EXERCISE, 35);
        values.put(TrakrEntry.COLUMN_GOALS, "Helped Mum with retaining wall");
        values.put(TrakrEntry.COLUMN_KINDNESS, "Grandma");

        // insert a new habit trakr row into the database
        long newRowId = db.insert(TrakrEntry.TABLE_NAME, null, values);
    }
}
