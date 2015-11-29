package org.oa.teach_http.app.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import org.oa.teach_http.app.R;
import org.oa.teach_http.app.fragments.FragmentsFactory;
import org.oa.teach_http.app.fragments.ProgressFragment;
import org.oa.teach_http.app.service.ApiService;
import org.oa.teach_http.app.service.MediaService;
import org.oa.teach_http.app.storage.Storage;

public class MainActivity extends NavDrawerActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String EXTRA_FRAGMENT_INDEX = "FRAGMENT_INDEX";

    private Storage mStorage;

    private ApiService.ApiWorker mApiRequestService;
    private MediaService.MediaWorker mMediaService;

    private int mCurrentFragmentIndex = 0;

    private ServiceConnection mApiServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mApiRequestService = (ApiService.ApiWorker) service;
            mStorage = new Storage(getApplicationContext(), mApiRequestService);

            selectItem(mCurrentFragmentIndex);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    private ServiceConnection mMediaServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMediaService = (MediaService.MediaWorker) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public Storage getStorage() {
        return mStorage;
    }

    public MediaService.MediaWorker getMediaService() {
        return mMediaService;
    }

    public ApiService.ApiWorker getApiService() {
        return mApiRequestService;
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        mActionBar.setTitle(mTitle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, ApiService.class),
                mApiServiceConnection, BIND_AUTO_CREATE);

        bindService(new Intent(this, MediaService.class),
                mMediaServiceConnection, BIND_AUTO_CREATE);

        Fragment fragment = new ProgressFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.content_frame, fragment, null).commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mApiServiceConnection);
        unbindService(mMediaServiceConnection);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_FRAGMENT_INDEX, mCurrentFragmentIndex);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCurrentFragmentIndex = savedInstanceState.getInt(EXTRA_FRAGMENT_INDEX);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStorage.closeStorage();
    }

    @Override
    protected void initActivity() {
        super.initActivity();

        mDrawerOnItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCurrentFragmentIndex = position;
                selectItem(position);
            }
        };
    }

    private void selectItem(int position) {
        Fragment fragment = FragmentsFactory.getFragment(position);

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            setTitle(mScreenTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            Log.e(TAG, "Error.Fragment is not created.");
            Toast.makeText(this, "Fragment is not created.", Toast.LENGTH_SHORT).show();
        }
    }
}
