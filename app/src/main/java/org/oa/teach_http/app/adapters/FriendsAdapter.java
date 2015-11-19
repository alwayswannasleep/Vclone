package org.oa.teach_http.app.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.oa.teach_http.app.R;
import org.oa.teach_http.app.models.User;
import org.oa.teach_http.app.utils.Constants;
import org.oa.teach_http.app.utils.ImageUtils;

import java.util.List;

public class FriendsAdapter extends ArrayAdapter<User> {

    public FriendsAdapter(Context context, List<User> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = View.inflate(getContext(),
                    R.layout.friends_list_item, null);
        }

        final ImageView fIsOnlineView = (ImageView) itemView
                .findViewById(R.id.friend_list_item_is_online);
        final ImageView fAvatarView = (ImageView) itemView
                .findViewById(R.id.friend_list_item_avatar);
        final TextView fNameView = (TextView) itemView
                .findViewById(R.id.friend_list_item_name);

        final User user = getItem(position);

        fNameView.setText(user.getFirstName() + " " + user.getLastName());

        ImageUtils.loadImage(fAvatarView, user.getPhotoURL());

        if (user.getOnline() == Constants.STATUS_ONLINE) {
            fIsOnlineView.setVisibility(View.VISIBLE);
        } else {
            fIsOnlineView.setVisibility(View.INVISIBLE);
        }

        return itemView;
    }
}
