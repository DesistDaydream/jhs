package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class ImageViewHolder extends BaseHolder {
    private ImageView iv_content;

    public ImageViewHolder(int i2) {
        super(i2);
    }

    public ImageView getImageView() {
        if (this.iv_content == null) {
            this.iv_content = (ImageView) getBaseView().findViewById(R.id.chat_content_iv);
        }
        return this.iv_content;
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.iv_content = (ImageView) view.findViewById(R.id.chat_content_iv);
        if (z) {
            this.type = 3;
            return this;
        }
        this.progressBar = (ProgressBar) view.findViewById(R.id.uploading_pb);
        this.type = 4;
        return this;
    }
}
