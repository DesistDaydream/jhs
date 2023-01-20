package com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes3.dex */
public class VideoReplyQuoteView extends ImageReplyQuoteView {
    public VideoReplyQuoteView(Context context) {
        super(context);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.ImageReplyQuoteView, com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        final VideoMessageBean videoMessageBean = (VideoMessageBean) tUIReplyQuoteBean.getMessageBean();
        ViewGroup.LayoutParams imageParams = getImageParams(this.imageMsgIv.getLayoutParams(), videoMessageBean.getImgWidth(), videoMessageBean.getImgHeight());
        this.imageMsgIv.setLayoutParams(imageParams);
        this.videoPlayIv.setLayoutParams(imageParams);
        this.imageMsgLayout.setVisibility(0);
        this.videoPlayIv.setVisibility(0);
        if (!TextUtils.isEmpty(videoMessageBean.getDataPath())) {
            GlideEngine.loadCornerImageWithoutPlaceHolder(this.imageMsgIv, videoMessageBean.getDataPath(), null, 0.0f);
            return;
        }
        GlideEngine.clear(this.imageMsgIv);
        synchronized (this.downloadEles) {
            if (!this.downloadEles.contains(videoMessageBean.getSnapshotUUID())) {
                this.downloadEles.add(videoMessageBean.getSnapshotUUID());
            }
        }
        final String str = TUIConfig.getImageDownloadDir() + videoMessageBean.getSnapshotUUID();
        videoMessageBean.downloadSnapshot(str, new VideoMessageBean.VideoDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.VideoReplyQuoteView.1
            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
            public void onError(int i2, String str2) {
                VideoReplyQuoteView.this.downloadEles.remove(videoMessageBean.getSnapshotUUID());
                TUIChatLog.e("MessageAdapter video getImage", i2 + Constants.COLON_SEPARATOR + str2);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
            public void onProgress(long j2, long j3) {
                TUIChatLog.i("downloadSnapshot progress current:", j2 + ", total:" + j3);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
            public void onSuccess() {
                VideoReplyQuoteView.this.downloadEles.remove(videoMessageBean.getSnapshotUUID());
                videoMessageBean.setDataPath(str);
                GlideEngine.loadCornerImageWithoutPlaceHolder(VideoReplyQuoteView.this.imageMsgIv, videoMessageBean.getDataPath(), null, 0.0f);
            }
        });
    }
}
