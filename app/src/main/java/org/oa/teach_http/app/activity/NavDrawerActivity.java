package org.oa.teach_http.app.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.oa.teach_http.app.R;

public abstract class NavDrawerActivity extends AppCompatActivity {
    protected DrawerLayout mDrawerLayout;
    protected ListView mDrawerList;
    protected Toolbar mToolbar;
    protected ActionBar mActionBar;
    protected String[] mScreenTitles;

    protected ActionBarDrawerToggle mDrawerToggle;
    protected CharSequence mTitle;

    protected AdapterView.OnItemClickListener mDrawerOnItemClickListener;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        onContentViewSet();
    }

    protected void onContentViewSet() {
        initActivity();

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mScreenTitles));
        mDrawerList.setOnItemClickListener(mDrawerOnItemClickListener);

        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                mActionBar.setTitle(mTitle);
                supportInvalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    protected void initActivity() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(mToolbar);

        mActionBar = getSupportActionBar();

        mScreenTitles = getResources().getStringArray(R.array.fragments_titles);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
}
