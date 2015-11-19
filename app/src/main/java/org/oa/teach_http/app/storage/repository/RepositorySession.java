package org.oa.teach_http.app.storage.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.oa.teach_http.app.storage.VkDatabaseHelper;

public class RepositorySession {

    private UserRepository mUserRepository;

    private SQLiteDatabase mDatabase;

    public RepositorySession(Context context) {
        VkDatabaseHelper vkDatabaseHelper = new VkDatabaseHelper(context);
        SQLiteDatabase mDatabase = vkDatabaseHelper.getWritableDatabase();
        mUserRepository = new UserRepository(mDatabase);
    }

    public UserRepository getUserRepository() {
        return mUserRepository;
    }

    public void closeDatabase() {
        mDatabase.close();
    }
}
