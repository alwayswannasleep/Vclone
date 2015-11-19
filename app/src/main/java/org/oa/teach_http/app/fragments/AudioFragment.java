package org.oa.teach_http.app.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.oa.teach_http.app.R;
import org.oa.teach_http.app.activity.MainActivity;
import org.oa.teach_http.app.adapters.AudiosAdapter;
import org.oa.teach_http.app.models.Audio;
import org.oa.teach_http.app.service.ApiService;
import org.oa.teach_http.app.service.MediaService;
import org.oa.teach_http.app.service.ResponseListener;

import java.util.ArrayList;
import java.util.List;

public class AudioFragment extends NavDrawerFragment {

    private List<Audio> mAudios;

    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.audios_fragment, container, false);

        mListView = (ListView) view.findViewById(R.id.audios_list);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mAudios = new ArrayList<Audio>();
    }

    @Override
    public void onStart() {
        super.onStart();
        ApiService.ApiWorker apiWorker = ((MainActivity) getActivity()).getApiService();

        apiWorker.getAudios(new ResponseListener<Audio>() {
            @Override
            public void onResponse(final List<Audio> items) {
                mAudios = items;
                mListView.setAdapter(new AudiosAdapter(getContext(), mAudios));
            }
        });

        final MediaService.MediaWorker mediaWorker = ((MainActivity) getActivity()).getMediaService();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mediaWorker.playMusiFromUrl(((Audio) parent.getItemAtPosition(position)).getUrl());
            }
        });
    }
}
