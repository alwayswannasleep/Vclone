package org.oa.teach_http.app.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VkDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "vk";

    private static final int VERSION = 1;

    public VkDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS USERS(storage_id INTEGER PRIMARY KEY AUTOINCREMENT, uid INTEGER, first_name TEXT, last_name TEXT, status_online INTEGER, photo_100 TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE USERS;");
        onCreate(db);
    }
}
