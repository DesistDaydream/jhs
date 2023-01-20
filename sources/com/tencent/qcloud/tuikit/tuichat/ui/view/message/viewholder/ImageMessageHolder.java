package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import com.xiaomi.mipush.sdk.Constants;
import e.b.a.t.g;
import e.b.a.t.k.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ImageMessageHolder extends MessageContentHolder {
    private static final int DEFAULT_MAX_SIZE = 540;
    private static final int DEFAULT_RADIUS = 10;
    private ImageView contentImage;
    private final List<String> downloadEles;
    private String mImagePath;
    private TextView videoDurationText;
    private ImageView videoPlayBtn;

    public ImageMessageHolder(View view) {
        super(view);
        this.downloadEles = new ArrayList();
        this.mImagePath = null;
        this.contentImage = (ImageView) view.findViewById(R.id.content_image_iv);
        this.videoPlayBtn = (ImageView) view.findViewById(R.id.video_play_btn);
        this.videoDurationText = (TextView) view.findViewById(R.id.video_duration_tv);
    }

    private ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, ImageMessageBean imageMessageBean) {
        if (imageMessageBean.getImgWidth() != 0 && imageMessageBean.getImgHeight() != 0) {
            if (imageMessageBean.getImgWidth() > imageMessageBean.getImgHeight()) {
                layoutParams.width = DEFAULT_MAX_SIZE;
                layoutParams.height = (imageMessageBean.getImgHeight() * DEFAULT_MAX_SIZE) / imageMessageBean.getImgWidth();
            } else {
                layoutParams.width = (imageMessageBean.getImgWidth() * DEFAULT_MAX_SIZE) / imageMessageBean.getImgHeight();
                layoutParams.height = DEFAULT_MAX_SIZE;
            }
        }
        return layoutParams;
    }

    private void performImage(final ImageMessageBean imageMessageBean, final int i2) {
        ImageView imageView = this.contentImage;
        imageView.setLayoutParams(getImageParams(imageView.getLayoutParams(), imageMessageBean));
        resetParentLayout();
        this.videoPlayBtn.setVisibility(8);
        this.videoDurationText.setVisibility(8);
        List<ImageMessageBean.ImageBean> imageBeanList = imageMessageBean.getImageBeanList();
        String dataPath = imageMessageBean.getDataPath();
        String originImagePath = TUIChatUtils.getOriginImagePath(imageMessageBean);
        if (!TextUtils.isEmpty(originImagePath)) {
            dataPath = originImagePath;
        }
        if (!TextUtils.isEmpty(dataPath)) {
            GlideEngine.loadCornerImageWithoutPlaceHolder(this.contentImage, dataPath, null, 10.0f);
        } else {
            GlideEngine.clear(this.contentImage);
            int i3 = 0;
            while (true) {
                if (i3 >= imageBeanList.size()) {
                    break;
                }
                final ImageMessageBean.ImageBean imageBean = imageBeanList.get(i3);
                if (imageBean.getType() == 2) {
                    synchronized (this.downloadEles) {
                        if (!this.downloadEles.contains(imageBean.getUUID())) {
                            this.downloadEles.add(imageBean.getUUID());
                            final String generateImagePath = ImageUtil.generateImagePath(imageBean.getUUID(), 2);
                            if (!generateImagePath.equals(this.mImagePath)) {
                                GlideEngine.clear(this.contentImage);
                            }
                            imageBean.downloadImage(generateImagePath, new ImageMessageBean.ImageBean.ImageDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.ImageMessageHolder.1
                                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                                public void onError(int i4, String str) {
                                    ImageMessageHolder.this.downloadEles.remove(imageBean.getUUID());
                                    TUIChatLog.e("MessageAdapter img getImage", i4 + Constants.COLON_SEPARATOR + str);
                                }

                                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                                public void onProgress(long j2, long j3) {
                                    TUIChatLog.i("downloadImage progress current:", j2 + ", total:" + j3);
                                }

                                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                                public void onSuccess() {
                                    ImageMessageHolder.this.downloadEles.remove(imageBean.getUUID());
                                    imageMessageBean.setDataPath(generateImagePath);
                                    GlideEngine.loadCornerImageWithoutPlaceHolder(ImageMessageHolder.this.contentImage, imageMessageBean.getDataPath(), new g() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.ImageMessageHolder.1.1
                                        @Override // e.b.a.t.g
                                        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, p pVar, boolean z) {
                                            ImageMessageHolder.this.mImagePath = null;
                                            return false;
                                        }

                                        @Override // e.b.a.t.g
                                        public boolean onResourceReady(Object obj, Object obj2, p pVar, DataSource dataSource, boolean z) {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            ImageMessageHolder.this.mImagePath = generateImagePath;
                                            return false;
                                        }
                                    }, 10.0f);
                                }
                            });
                        }
                    }
                } else {
                    i3++;
                }
            }
        }
        if (this.isMultiSelectMode) {
            this.contentImage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.ImageMessageHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnItemClickListener onItemClickListener = ImageMessageHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageClick(view, i2, imageMessageBean);
                    }
                }
            });
            return;
        }
        this.contentImage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.ImageMessageHolder.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(TUIChatService.getAppContext(), ImageVideoScanActivity.class);
                intent.addFlags(268435456);
                ImageMessageHolder imageMessageHolder = ImageMessageHolder.this;
                if (imageMessageHolder.isForwardMode && imageMessageHolder.getDataSource() != null && !ImageMessageHolder.this.getDataSource().isEmpty()) {
                    intent.putExtra(TUIChatConstants.OPEN_MESSAGES_SCAN_FORWARD, (Serializable) ImageMessageHolder.this.getDataSource());
                }
                intent.putExtra(TUIChatConstants.OPEN_MESSAGE_SCAN, imageMessageBean);
                intent.putExtra(TUIChatConstants.FORWARD_MODE, ImageMessageHolder.this.isForwardMode);
                TUIChatService.getAppContext().startActivity(intent);
            }
        });
        this.contentImage.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.ImageMessageHolder.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                OnItemClickListener onItemClickListener = ImageMessageHolder.this.onItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onMessageLongClick(view, i2, imageMessageBean);
                    return true;
                }
                return true;
            }
        });
    }

    private void resetParentLayout() {
        ((FrameLayout) this.contentImage.getParent().getParent()).setPadding(17, 0, 13, 0);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public void clearHighLightBackground() {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(null);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.message_adapter_content_image;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i2) {
        this.msgContentFrame.setBackground(null);
        performImage((ImageMessageBean) tUIMessageBean, i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public void setHighLightBackground(int i2) {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
