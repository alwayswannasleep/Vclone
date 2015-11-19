package org.oa.teach_http.app.fragments;

import android.support.v4.app.Fragment;
import android.util.Log;

public class FragmentsFactory {

    public static final int FRIENDS_FRAGMENT = 0;

    public static final int GROUPS_FRAGMENT = 1;

    public static final int AUDIO_FRAGMENT = 2;

    public static Fragment getFragment(int fragmentType) {
        Fragment fragment = null;

        switch (fragmentType) {
            case FRIENDS_FRAGMENT:
                fragment = new FriendsFragment();
                break;
            case GROUPS_FRAGMENT:
                fragment = new GroupsFragment();
                break;
            case AUDIO_FRAGMENT:
                fragment = new AudioFragment();
                break;
            default:
                Log.e("FragmentsFactory", "Wrong type of fragment.");
                break;
        }

        return fragment;
    }
}
