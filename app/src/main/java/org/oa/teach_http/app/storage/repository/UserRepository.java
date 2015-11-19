package org.oa.teach_http.app.storage.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;

import org.oa.teach_http.app.models.User;
import org.oa.teach_http.app.service.ResponseListener;
import org.oa.teach_http.app.storage.DBSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UserRepository {

    private final Executor mExecutor = Executors.newSingleThreadExecutor();

    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private final SQLiteDatabase mDatabase;

    public UserRepository(SQLiteDatabase database) {
        mDatabase = database;
    }

    public void insert(final User user) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBSchema.USERS_FIRST_NAME, user.getFirstName());
                contentValues.put(DBSchema.USERS_LAST_NAME, user.getLastName());
                contentValues.put(DBSchema.USERS_ID, user.getUid());
                contentValues.put(DBSchema.USERS_PHOTO_100, user.getPhotoURL());
                contentValues.put(DBSchema.USERS_STATUS_ONLINE, user.getOnline());

                mDatabase.insert(DBSchema.USERS_TABLE, null, contentValues);
            }
        });
    }

    public void update(final User user) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBSchema.USERS_FIRST_NAME, user.getFirstName());
                contentValues.put(DBSchema.USERS_LAST_NAME, user.getLastName());
                contentValues.put(DBSchema.USERS_PHOTO_100, user.getPhotoURL());
                contentValues.put(DBSchema.USERS_STATUS_ONLINE, user.getOnline());

                mDatabase.update(DBSchema.USERS_TABLE, contentValues, "uid=?",
                        new String[]{String.valueOf(user.getUid())});
            }
        });
    }

    public void getFriends(final ResponseListener<User> listener) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Cursor cursor = mDatabase.query(DBSchema.USERS_TABLE, null, null,
                        null, null, null, null);

                if (!cursor.moveToFirst()) {
                    listener.onResponse(null);
                    return;
                }

                int firstNameIndex = cursor.getColumnIndex(DBSchema.USERS_FIRST_NAME);
                int lastNameIndex = cursor.getColumnIndex(DBSchema.USERS_LAST_NAME);
                int uidIndex = cursor.getColumnIndex(DBSchema.USERS_ID);
                int photo100Index = cursor.getColumnIndex(DBSchema.USERS_PHOTO_100);
                int statusOnlineIndex = cursor.getColumnIndex(DBSchema.USERS_STATUS_ONLINE);

                final List<User> friends = new ArrayList<User>();
                do {
                    User user = new User();

                    user.setFirstName(cursor.getString(firstNameIndex));
                    user.setLastName(cursor.getString(lastNameIndex));
                    user.setUid(cursor.getLong(uidIndex));
                    user.setPhotoURL(cursor.getString(photo100Index));
                    user.setOnline(cursor.getInt(statusOnlineIndex));

                    friends.add(user);
                } while (cursor.moveToNext());

                cursor.close();

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        listener.onResponse(friends);
                    }
                });
            }
        });
    }

    public void insertOrReplace(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBSchema.USERS_STORAGE_ID, user.getStorageId());
        contentValues.put(DBSchema.USERS_FIRST_NAME, user.getFirstName());
        contentValues.put(DBSchema.USERS_LAST_NAME, user.getLastName());
        contentValues.put(DBSchema.USERS_ID, user.getUid());
        contentValues.put(DBSchema.USERS_PHOTO_100, user.getPhotoURL());
        contentValues.put(DBSchema.USERS_STATUS_ONLINE, user.getOnline());

        mDatabase.insertWithOnConflict(DBSchema.USERS_TABLE, null,
                contentValues, SQLiteDatabase.CONFLICT_REPLACE);
    }

    public void insertOrReplace(final List<User> items) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for (User user : items) {
                    insertOrReplace(user);
                }
            }
        });
    }
}
