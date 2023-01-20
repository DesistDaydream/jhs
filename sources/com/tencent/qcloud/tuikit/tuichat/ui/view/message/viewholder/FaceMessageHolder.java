package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;

/* loaded from: classes3.dex */
public class FaceMessageHolder extends MessageContentHolder {
    private ImageView contentImage;
    private TextView videoDurationText;
    private ImageView videoPlayBtn;

    public FaceMessageHolder(View view) {
        super(view);
        this.contentImage = (ImageView) view.findViewById(R.id.content_image_iv);
        this.videoPlayBtn = (ImageView) view.findViewById(R.id.video_play_btn);
        this.videoDurationText = (TextView) view.findViewById(R.id.video_duration_tv);
    }

    private void performCustomFace(FaceMessageBean faceMessageBean, int i2) {
        this.videoPlayBtn.setVisibility(8);
        this.videoDurationText.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.contentImage.setLayoutParams(layoutParams);
        String str = new String(faceMessageBean.getData());
        if (str.contains(".gif") || str.contains(".png")) {
            str = str.substring(0, str.indexOf("."));
        }
        Bitmap customBitmap = FaceManager.getCustomBitmap(faceMessageBean.getIndex(), str);
        if (customBitmap == null) {
            Bitmap emoji = FaceManager.getEmoji(new String(faceMessageBean.getData()));
            if (emoji == null) {
                this.contentImage.setImageDrawable(this.itemView.getContext().getResources().getDrawable(R.drawable.face_delete));
                return;
            } else {
                this.contentImage.setImageBitmap(emoji);
                return;
            }
        }
        this.contentImage.setImageBitmap(customBitmap);
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
        performCustomFace((FaceMessageBean) tUIMessageBean, i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public void setHighLightBackground(int i2) {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(i2, PorterDuff.Mode.SRC_OVER);
        }
    }
}
