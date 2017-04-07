package com.adventurekit.node_coyote.habittrakr.habitData;

import android.provider.BaseColumns;

/**
 * Created by node_coyote on 4/6/17.
 */

/**
 * Contract for HabitTrakr app
 */
public final class TrakrContract {

    // Empty constructor should not be used
    private TrakrContract() {
    }

    /**
     * Inner class defines database constants for different habits
     */
    public static final class TrakrEntry implements BaseColumns {

        // database name "trakr"
        public final static String TABLE_NAME = "trakr";

        // following convention for id      Type: INTEGER
        public final static String _ID = BaseColumns._ID;

        /**
         * Type: INTEGER
         * Minutes walked or ran in one day
         */
        public final static String COLUMN_EXERCISE = "exercise";

        /**
         *  Type: INTEGER
         *  Wrote in journal today (boolean)
         *  0: Did not write in journal
         *  1: Wrote in journal
         */
        public final static String COLUMN_JOURNAL = "journal";

        /**
         * Type: TEXT
         * Name of the friend or family member
         * who received kindness from the user
         */
        public final static String COLUMN_KINDNESS = "kindness";

        /**
         * Type: TEXT
         * Small goal or accomplishment
         * e.g. Used a Jackhammer for the first time or
         *      Didn't eat meat today
         */
        public final static String COLUMN_GOALS = "goals";

        /**
         * Values for COLUMN_JOURNAL
         */
        public static final int DID_NOT_WRITE_IN_JOURNAL = 0;
        public static final int WROTE_IN_JOURNAL = 1;

    }
}
