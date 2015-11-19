package org.oa.teach_http.app.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

public class MediaService extends Service {
    public static final String TAG = MediaService.class.getSimpleName();

    public static class MediaWorker extends Binder {

        private MediaPlayer mMediaPlayer;

        public MediaWorker() {
            mMediaPlayer = new MediaPlayer();
        }

        public void playMusiFromUrl(String url) {
            mMediaPlayer.reset();
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer player) {
                    player.start();
                }
            });

            try {
                mMediaPlayer.setDataSource(url);
            } catch (IOException e) {
                Log.e(TAG, e.getMessage(), e);
            }

            mMediaPlayer.prepareAsync();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MediaWorker();
    }
}
