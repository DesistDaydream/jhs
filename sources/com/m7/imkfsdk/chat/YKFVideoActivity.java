package com.m7.imkfsdk.chat;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import androidx.annotation.Nullable;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.utils.statusbar.StatusBarUtils;
import com.moor.imkf.YKFConstants;
import com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener;
import com.moor.imkf.lib.http.donwload.MoorDownLoadUtils;
import java.util.UUID;

/* loaded from: classes2.dex */
public class YKFVideoActivity extends KFBaseActivity {
    private String dirStr;
    private ImageView iv_closevideo;
    private Context mContext;
    private RelativeLayout rl_video_progress;
    private String video_url;
    private VideoView ykf_videoview;

    /* loaded from: classes2.dex */
    public class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {
        public MyPlayerOnCompletionListener() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            YKFVideoActivity.this.ykf_videoview.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initVideo(String str) {
        Uri parse = Uri.parse(str);
        this.ykf_videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.m7.imkfsdk.chat.YKFVideoActivity.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.m7.imkfsdk.chat.YKFVideoActivity.3.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i2, int i3) {
                        if (i2 == 3) {
                            YKFVideoActivity.this.rl_video_progress.setVisibility(8);
                            return true;
                        }
                        return true;
                    }
                });
            }
        });
        this.ykf_videoview.setOnCompletionListener(new MyPlayerOnCompletionListener());
        this.ykf_videoview.setVideoURI(parse);
        MediaController mediaController = new MediaController(this);
        this.ykf_videoview.setMediaController(mediaController);
        mediaController.setMediaPlayer(this.ykf_videoview);
        this.ykf_videoview.start();
        this.ykf_videoview.requestFocus();
    }

    @Override // com.m7.imkfsdk.chat.KFBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        setContentView(R.layout.ykfsdk_ykf_videoactivity);
        StatusBarUtils.setTransparent(this);
        this.ykf_videoview = (VideoView) findViewById(R.id.ykf_videoview);
        this.iv_closevideo = (ImageView) findViewById(R.id.iv_closevideo);
        this.rl_video_progress = (RelativeLayout) findViewById(R.id.rl_video_progress);
        String stringExtra = getIntent().getStringExtra(YKFConstants.YKFVIDEOPATHURI);
        this.video_url = stringExtra;
        MoorDownLoadUtils.loadFile(stringExtra, "7moor_video" + UUID.randomUUID(), new IMoorOnDownloadListener() { // from class: com.m7.imkfsdk.chat.YKFVideoActivity.1
            @Override // com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener
            public void onDownloadFailed() {
            }

            @Override // com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener
            public void onDownloadStart() {
            }

            @Override // com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener
            public void onDownloadSuccess(final String str) {
                YKFVideoActivity.this.runOnUiThread(new Runnable() { // from class: com.m7.imkfsdk.chat.YKFVideoActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        YKFVideoActivity.this.initVideo(str);
                    }
                });
            }

            @Override // com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener
            public void onDownloading(int i2) {
            }
        });
        this.iv_closevideo.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.YKFVideoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YKFVideoActivity.this.finish();
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.ykf_videoview.isPlaying()) {
            this.ykf_videoview.stopPlayback();
        }
        super.onDestroy();
    }
}
