package org.oa.teach_http.app.fragments;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.oa.teach_http.app.R;
import org.oa.teach_http.app.activity.MainActivity;
import org.oa.teach_http.app.adapters.FriendsAdapter;
import org.oa.teach_http.app.models.User;
import org.oa.teach_http.app.storage.StorageResponseListener;
import org.oa.teach_http.app.utils.Constants;
import org.oa.teach_http.app.view.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

public class FriendsFragment extends NavDrawerFragment {
    private static final String FRIENDS_MAIN_PAGE_TITLE = "friends";

    private static final String FRIENDS_ONLINE_PAGE_TITLE = "online";

    private SlidingTabLayout mSlidingTabLayout;

    private ViewPager mViewPager;

    private List<List<User>> mFriends;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.friends_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mFriends = new ArrayList<List<User>>();

        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tab);
    }

    @Override
    public void onStart() {
        super.onStart();

        ((MainActivity) getActivity()).getStorage().getFriends(new StorageResponseListener<User>() {
            @Override
            public void onResponse(List<User> items, int responseType) {
                if (items == null) {
                    return;
                }

                mFriends.add(Constants.PAGE_NUMBER_ALL, items);
                mFriends.add(Constants.PAGE_NUMBER_ONLINE, getFriendsOnline(items));

                if (mViewPager.getAdapter() == null) {
                    mViewPager.setAdapter(new FriendsPagerAdapter());
                } else {
                    mViewPager.getAdapter().notifyDataSetChanged();
                }

                mSlidingTabLayout.setViewPager(mViewPager);
            }
        });
    }

    private ArrayList<User> getFriendsOnline(List<User> items) {
        List<User> list = new ArrayList<User>();

        for (User item : items) {
            if (item.getOnline() == Constants.STATUS_ONLINE) {
                list.add(item);
            }
        }

        return (ArrayList<User>) list;
    }

    private class FriendsPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Constants.FRIENDS_LIST_PAGES_COUNT;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view.equals(o);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case Constants.FRIENDS_MAIN_LIST:
                    return mFriends.get(position).size() + " " + FRIENDS_MAIN_PAGE_TITLE;
                case Constants.FRIENDS_ONLINE_LIST:
                    return mFriends.get(position).size() + " " + FRIENDS_ONLINE_PAGE_TITLE;
                default:
                    return Integer.toString(position + 1);
            }
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = getActivity().getLayoutInflater().inflate(R.layout.friends_list, container, false);
            container.addView(view);

            ListView listView = (ListView) view.findViewById(R.id.friends_list);
            listView.setAdapter(new FriendsAdapter(getContext(), mFriends.get(position)));

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
