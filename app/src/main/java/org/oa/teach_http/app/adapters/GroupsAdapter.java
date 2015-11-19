package org.oa.teach_http.app.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.oa.teach_http.app.R;
import org.oa.teach_http.app.models.Group;
import org.oa.teach_http.app.utils.ImageUtils;

import java.util.List;

public class GroupsAdapter extends ArrayAdapter<Group> {

    public GroupsAdapter(Context context, List<Group> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = View.inflate(getContext(),
                    R.layout.groups_list_item, null);
        }

        ImageView gAvatarView = (ImageView) itemView
                .findViewById(R.id.group_list_item_avatar);
        TextView gNameView = (TextView) itemView
                .findViewById(R.id.group_list_item_name);
        TextView gTypeView = (TextView) itemView
                .findViewById(R.id.group_list_item_type);

        Group group = getItem(position);

        ImageUtils.loadImage(gAvatarView, group.getPhoto100());
        gNameView.setText(group.getName());
        gTypeView.setText(group.getType());

        return itemView;
    }
}
