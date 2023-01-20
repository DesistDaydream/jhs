package com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FaceReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;

/* loaded from: classes3.dex */
public class FaceReplyQuoteView extends TUIReplyQuoteView {
    private final ImageView contentImage;

    public FaceReplyQuoteView(Context context) {
        super(context);
        this.contentImage = (ImageView) findViewById(R.id.content_image_iv);
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
        return R.layout.chat_reply_quote_face_layout;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        FaceReplyQuoteBean faceReplyQuoteBean = (FaceReplyQuoteBean) tUIReplyQuoteBean;
        String str = new String(faceReplyQuoteBean.getData());
        if (!str.contains("@2x")) {
            str = str + "@2x";
        }
        Bitmap customBitmap = FaceManager.getCustomBitmap(faceReplyQuoteBean.getIndex(), str);
        if (customBitmap == null) {
            customBitmap = FaceManager.getEmoji(new String(faceReplyQuoteBean.getData()));
        }
        if (customBitmap != null) {
            ImageView imageView = this.contentImage;
            imageView.setLayoutParams(getImageParams(imageView.getLayoutParams(), customBitmap.getWidth(), customBitmap.getHeight()));
            this.contentImage.setImageBitmap(customBitmap);
            return;
        }
        this.contentImage.setImageDrawable(getContext().getResources().getDrawable(R.drawable.face_delete));
    }
}
