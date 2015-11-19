package org.oa.teach_http.app.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.oa.teach_http.app.R;
import org.oa.teach_http.app.activity.MainActivity;
import org.oa.teach_http.app.adapters.GroupsAdapter;
import org.oa.teach_http.app.models.Group;
import org.oa.teach_http.app.service.ApiService;
import org.oa.teach_http.app.service.ResponseListener;
import org.oa.teach_http.app.utils.Constants;
import org.oa.teach_http.app.view.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

public class GroupsFragment extends NavDrawerFragment {
    private static final String GROUPS_MAIN_PAGE_TITLE = "Groups";

    private static final String GROUPS_EVENTS_PAGE_TITLE = "Events";

    private SlidingTabLayout mSlidingTabLayout;

    private ViewPager mViewPager;

    private List<List<Group>> mGroups;

    private List<Group> catchEventsFromGroups(List<Group> items) {
        List<Group> events = new ArrayList<Group>();

        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getType().equals("event")) {
                events.add(items.remove(i));
            }
        }
        return events;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.groups_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mGroups = new ArrayList<List<Group>>();

        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tab);
    }

    @Override
    public void onStart() {
        super.onStart();
        ApiService.ApiWorker worker = ((MainActivity) getActivity()).getApiService();

        worker.getGroups(new ResponseListener<Group>() {
            @Override
            public void onResponse(final List<Group> items) {

                List<Group> events = catchEventsFromGroups(items);

                mGroups.add(Constants.PAGE_NUMBER_ALL, items);
                mGroups.add(Constants.PAGE_NUMBER_ONLINE, events);

                mViewPager.setAdapter(new GroupsPagerAdapter());
                mSlidingTabLayout.setViewPager(mViewPager);
            }
        });
    }

    private class GroupsPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return Constants.GROUPS_LIST_PAGES_COUNT;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view.equals(o);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case Constants.GROUPS_MAIN_LIST:
                    return mGroups.get(position).size() + " " + GROUPS_MAIN_PAGE_TITLE;
                case Constants.GROUPS_EVENTS_LIST:
                    return mGroups.get(position).size() + " " + GROUPS_EVENTS_PAGE_TITLE;
                default:
                    return Integer.toString(position + 1);
            }
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = getActivity().getLayoutInflater().inflate(R.layout.groups_list, container, false);
            container.addView(view);

            ListView listView = (ListView) view.findViewById(R.id.groups_list);
            listView.setAdapter(new GroupsAdapter(getContext(), mGroups.get(position)));

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
