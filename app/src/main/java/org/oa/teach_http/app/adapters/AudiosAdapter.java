package org.oa.teach_http.app.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import org.oa.teach_http.app.R;
import org.oa.teach_http.app.models.Audio;

import java.util.List;

public class AudiosAdapter extends ArrayAdapter<Audio> {

    public AudiosAdapter(Context context, List<Audio> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = View.inflate(getContext(),
                    R.layout.audios_list_item, null);
        }

        Audio audio = getItem(position);

        TextView aNameView = (TextView) itemView
                .findViewById(R.id.audio_title);
        TextView aArtistView = (TextView) itemView
                .findViewById(R.id.audio_artist);

        aNameView.setText(audio.getTitle());
        aArtistView.setText(audio.getArtist());

        return itemView;
    }
}
