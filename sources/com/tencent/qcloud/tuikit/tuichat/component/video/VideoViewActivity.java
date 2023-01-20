package com.tencent.qcloud.tuikit.tuichat.component.video;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: classes3.dex */
public class VideoViewActivity extends Activity {
    private static final String TAG = VideoViewActivity.class.getSimpleName();
    private UIKitVideoView mVideoView;
    private int videoWidth = 0;
    private int videoHeight = 0;

    private void updateVideoView() {
        int min;
        int max;
        String str = TAG;
        TUIChatLog.i(str, "updateVideoView videoWidth: " + this.videoWidth + " videoHeight: " + this.videoHeight);
        if (this.videoWidth > 0 || this.videoHeight > 0) {
            if (getResources().getConfiguration().orientation != 1) {
                min = Math.max(ScreenUtil.getScreenWidth(this), ScreenUtil.getScreenHeight(this));
                max = Math.min(ScreenUtil.getScreenWidth(this), ScreenUtil.getScreenHeight(this));
            } else {
                min = Math.min(ScreenUtil.getScreenWidth(this), ScreenUtil.getScreenHeight(this));
                max = Math.max(ScreenUtil.getScreenWidth(this), ScreenUtil.getScreenHeight(this));
            }
            int[] scaledSize = ScreenUtil.scaledSize(min, max, this.videoWidth, this.videoHeight);
            TUIChatLog.i(str, "scaled width: " + scaledSize[0] + " height: " + scaledSize[1]);
            ViewGroup.LayoutParams layoutParams = this.mVideoView.getLayoutParams();
            layoutParams.width = scaledSize[0];
            layoutParams.height = scaledSize[1];
            this.mVideoView.setLayoutParams(layoutParams);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        String str = TAG;
        TUIChatLog.i(str, "onConfigurationChanged start");
        super.onConfigurationChanged(configuration);
        updateVideoView();
        TUIChatLog.i(str, "onConfigurationChanged end");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "onCreate start");
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_video_view);
        this.mVideoView = (UIKitVideoView) findViewById(R.id.video_play_view);
        String stringExtra = getIntent().getStringExtra(TUIChatConstants.CAMERA_IMAGE_PATH);
        Uri uri = (Uri) getIntent().getParcelableExtra(TUIChatConstants.CAMERA_VIDEO_PATH);
        Bitmap bitmapFormPath = ImageUtil.getBitmapFormPath(stringExtra);
        if (bitmapFormPath != null) {
            this.videoWidth = bitmapFormPath.getWidth();
            this.videoHeight = bitmapFormPath.getHeight();
            updateVideoView();
        }
        this.mVideoView.setVideoURI(uri);
        this.mVideoView.setOnPreparedListener(new IPlayer.OnPreparedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.VideoViewActivity.1
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnPreparedListener
            public void onPrepared(IPlayer iPlayer) {
                VideoViewActivity.this.mVideoView.start();
            }
        });
        this.mVideoView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.VideoViewActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoViewActivity.this.mVideoView.isPlaying()) {
                    VideoViewActivity.this.mVideoView.pause();
                } else {
                    VideoViewActivity.this.mVideoView.start();
                }
            }
        });
        findViewById(R.id.video_view_back).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.VideoViewActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoViewActivity.this.mVideoView.stop();
                VideoViewActivity.this.finish();
            }
        });
        TUIChatLog.i(str, "onCreate end");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TUIChatLog.i(TAG, "onStop");
        UIKitVideoView uIKitVideoView = this.mVideoView;
        if (uIKitVideoView != null) {
            uIKitVideoView.stop();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        TUIChatLog.i(TAG, "onStop");
        super.onStop();
        UIKitVideoView uIKitVideoView = this.mVideoView;
        if (uIKitVideoView != null) {
            uIKitVideoView.pause();
        }
    }
}
