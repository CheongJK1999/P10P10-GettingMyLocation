package sg.edu.rp.c346.id19043996.p10_gettingmylocation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "locations.db";

    private static final String COLUMN_ID = "_id";
    private static final String TABLE_LOCATIONS = "locations";
    private static final String COLUMN_UPDATE = "update";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_LOCATIONS +  "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_UPDATE + "TEXT)";

        db.execSQL(createTableSql);
        Log.i("info" ,"created tables");

        for (int i = 0; i< 4; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ID, "Data number " + i);
            values.put(COLUMN_UPDATE, "Data number " + i);
            db.insert(TABLE_LOCATIONS, null, values);
        }
        Log.i("info", "location records inserted");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATIONS);

        onCreate(db);
    }

    public long insertLocations(String update) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_UPDATE, update);

        long result = db.insert(TABLE_LOCATIONS, null, values);
        db.close();
        Log.d("SQL Insert","ID:"+ result); //id returned, shouldn’t be -1
        return result;
    }

    public ArrayList<Locations> getAllLocations() {
        ArrayList<Locations> locations = new ArrayList<Locations>();
        String selectQuery = "SELECT " + COLUMN_ID + ","
                + COLUMN_UPDATE
                + " FROM " + TABLE_LOCATIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                String updateContent = cursor.getString(1);
                Locations location = new Locations(updateContent);
                locations.add(location);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return locations;
    }
}
