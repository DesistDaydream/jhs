package com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import com.xiaomi.mipush.sdk.Constants;
import e.b.a.t.g;
import e.b.a.t.k.p;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ImageReplyQuoteView extends TUIReplyQuoteView {
    public static final int DEFAULT_RADIUS = 0;
    public final List<String> downloadEles;
    public ImageView imageMsgIv;
    public View imageMsgLayout;
    public String mImagePath;
    public ImageView videoPlayIv;

    public ImageReplyQuoteView(Context context) {
        super(context);
        this.downloadEles = new ArrayList();
        this.mImagePath = null;
        this.imageMsgLayout = findViewById(R.id.image_msg_layout);
        this.imageMsgIv = (ImageView) findViewById(R.id.image_msg_iv);
        this.videoPlayIv = (ImageView) findViewById(R.id.video_play_iv);
    }

    public ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, int i2, int i3) {
        if (i2 != 0 && i3 != 0) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.reply_message_image_size);
            if (i2 > i3) {
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = (dimensionPixelSize * i3) / i2;
            } else {
                layoutParams.width = (i2 * dimensionPixelSize) / i3;
                layoutParams.height = dimensionPixelSize;
            }
        }
        return layoutParams;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public int getLayoutResourceId() {
        return R.layout.chat_reply_quote_image_layout;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        final ImageMessageBean imageMessageBean = (ImageMessageBean) tUIReplyQuoteBean.getMessageBean();
        this.imageMsgLayout.setVisibility(0);
        ImageView imageView = this.imageMsgIv;
        imageView.setLayoutParams(getImageParams(imageView.getLayoutParams(), imageMessageBean.getImgWidth(), imageMessageBean.getImgHeight()));
        List<ImageMessageBean.ImageBean> imageBeanList = imageMessageBean.getImageBeanList();
        String dataPath = imageMessageBean.getDataPath();
        String originImagePath = TUIChatUtils.getOriginImagePath(imageMessageBean);
        if (!TextUtils.isEmpty(originImagePath)) {
            dataPath = originImagePath;
        }
        if (!TextUtils.isEmpty(dataPath)) {
            GlideEngine.loadCornerImageWithoutPlaceHolder(this.imageMsgIv, dataPath, null, 0.0f);
            return;
        }
        GlideEngine.clear(this.imageMsgIv);
        for (int i2 = 0; i2 < imageBeanList.size(); i2++) {
            final ImageMessageBean.ImageBean imageBean = imageBeanList.get(i2);
            if (imageBean.getType() == 2) {
                synchronized (this.downloadEles) {
                    if (!this.downloadEles.contains(imageBean.getUUID())) {
                        this.downloadEles.add(imageBean.getUUID());
                        final String generateImagePath = ImageUtil.generateImagePath(imageBean.getUUID(), 2);
                        if (!generateImagePath.equals(this.mImagePath)) {
                            GlideEngine.clear(this.imageMsgIv);
                        }
                        imageBean.downloadImage(generateImagePath, new ImageMessageBean.ImageBean.ImageDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.ImageReplyQuoteView.1
                            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                            public void onError(int i3, String str) {
                                ImageReplyQuoteView.this.downloadEles.remove(imageBean.getUUID());
                                TUIChatLog.e("MessageAdapter img getImage", i3 + Constants.COLON_SEPARATOR + str);
                            }

                            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                            public void onProgress(long j2, long j3) {
                                TUIChatLog.i("downloadImage progress current:", j2 + ", total:" + j3);
                            }

                            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                            public void onSuccess() {
                                ImageReplyQuoteView.this.downloadEles.remove(imageBean.getUUID());
                                imageMessageBean.setDataPath(generateImagePath);
                                GlideEngine.loadCornerImageWithoutPlaceHolder(ImageReplyQuoteView.this.imageMsgIv, imageMessageBean.getDataPath(), new g() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.ImageReplyQuoteView.1.1
                                    @Override // e.b.a.t.g
                                    public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, p pVar, boolean z) {
                                        ImageReplyQuoteView.this.mImagePath = null;
                                        return false;
                                    }

                                    @Override // e.b.a.t.g
                                    public boolean onResourceReady(Object obj, Object obj2, p pVar, DataSource dataSource, boolean z) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        ImageReplyQuoteView.this.mImagePath = generateImagePath;
                                        return false;
                                    }
                                }, 0.0f);
                            }
                        });
                    }
                }
                return;
            }
        }
    }
}
