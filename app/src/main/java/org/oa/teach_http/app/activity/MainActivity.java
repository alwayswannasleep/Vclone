package org.oa.teach_http.app.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.oa.teach_http.app.R;
import org.oa.teach_http.app.fragments.FragmentsFactory;
import org.oa.teach_http.app.fragments.ProgressFragment;
import org.oa.teach_http.app.service.ApiService;
import org.oa.teach_http.app.service.MediaService;
import org.oa.teach_http.app.storage.Storage;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String EXTRA_FRAGMENT_INDEX = "FRAGMENT_INDEX";

    private String[] mScreenTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private ActionBar mActionBar;
    private Toolbar mToolbar;

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        init();

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mScreenTitles));
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCurrentFragmentIndex = position;
                selectItem(position);
            }
        });

        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                mActionBar.setTitle(mTitle);
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpen(View drawerView) {
                mActionBar.setTitle(mDrawerTitle);
                supportInvalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_search).setVisible(!drawerOpen);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, R.string.action_search, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

    public ApiService.ApiWorker getApiService() {
        return mApiRequestService;
    }

    public void setTitle(CharSequence title) {
        mTitle = title;
        mActionBar.setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public Storage getStorage() {
        return mStorage;
    }

    public MediaService.MediaWorker getMediaService() {
        return mMediaService;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStorage.closeStorage();
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

    private void init() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(mToolbar);

        mActionBar = getSupportActionBar();

        mScreenTitles = getResources().getStringArray(R.array.fragments_titles);
    }
}
