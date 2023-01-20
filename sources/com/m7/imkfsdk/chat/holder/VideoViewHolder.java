package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class VideoViewHolder extends BaseHolder {
    private ImageView chat_to_video_icon;
    private TextView tv_content;

    public VideoViewHolder(int i2) {
        super(i2);
    }

    public TextView getDescTextView() {
        if (this.tv_content == null) {
            this.tv_content = (TextView) getBaseView().findViewById(R.id.chat_content_tv);
        }
        return this.tv_content;
    }

    public ImageView getVideoIcon() {
        if (this.chat_to_video_icon == null) {
            this.chat_to_video_icon = (ImageView) getBaseView().findViewById(R.id.chat_to_video_icon);
        }
        return this.chat_to_video_icon;
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.tv_content = (TextView) view.findViewById(R.id.chat_content_tv);
        this.chat_to_video_icon = (ImageView) view.findViewById(R.id.chat_to_video_icon);
        if (z) {
            this.type = 17;
            return this;
        }
        this.progressBar = (ProgressBar) view.findViewById(R.id.uploading_pb);
        this.type = 16;
        return this;
    }
}
