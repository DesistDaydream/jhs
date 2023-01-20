package com.jihuanshe.ui.widget.imagepreview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.VideoView;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public class GPVideoPlayerActivity extends Activity {
    public VideoView a;

    /* loaded from: classes2.dex */
    public class a implements MediaPlayer.OnErrorListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Toast.makeText(GPVideoPlayerActivity.this, (int) R.string.Playback_failed, 0).show();
            return false;
        }
    }

    public static void startActivity(Context context, String str) {
        Intent intent = new Intent(context, GPVideoPlayerActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_gpvideoplayer);
        VideoView videoView = (VideoView) findViewById(R.id.gpVideo);
        this.a = videoView;
        videoView.setVideoPath(getIntent().getStringExtra("url"));
        this.a.setOnErrorListener(new a());
        this.a.start();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.stopPlayback();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.a.pause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a.isPlaying()) {
            return;
        }
        this.a.start();
    }
}
