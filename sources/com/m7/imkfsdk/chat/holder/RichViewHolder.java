package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class RichViewHolder extends BaseHolder {
    private TextView content;
    private ImageView iv;
    private LinearLayout kf_chat_rich_lin;
    private TextView name;
    private TextView title;

    public RichViewHolder(int i2) {
        super(i2);
    }

    public TextView getContent() {
        if (this.content == null) {
            this.content = (TextView) this.baseView.findViewById(R.id.kf_chat_rich_content);
        }
        return this.content;
    }

    public ImageView getImageView() {
        if (this.iv == null) {
            this.iv = (ImageView) getBaseView().findViewById(R.id.kf_chat_rich_iv);
        }
        return this.iv;
    }

    public LinearLayout getKf_chat_rich_lin() {
        if (this.kf_chat_rich_lin == null) {
            this.kf_chat_rich_lin = (LinearLayout) this.baseView.findViewById(R.id.kf_chat_rich_lin);
        }
        return this.kf_chat_rich_lin;
    }

    public TextView getName() {
        if (this.name == null) {
            this.name = (TextView) this.baseView.findViewById(R.id.kf_chat_rich_name);
        }
        return this.name;
    }

    public TextView getTitle() {
        if (this.title == null) {
            this.title = (TextView) this.baseView.findViewById(R.id.kf_chat_rich_title);
        }
        return this.title;
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.title = (TextView) view.findViewById(R.id.kf_chat_rich_title);
        this.content = (TextView) view.findViewById(R.id.kf_chat_rich_content);
        this.name = (TextView) view.findViewById(R.id.kf_chat_rich_name);
        this.iv = (ImageView) view.findViewById(R.id.kf_chat_rich_iv);
        this.kf_chat_rich_lin = (LinearLayout) view.findViewById(R.id.kf_chat_rich_lin);
        this.progressBar = (ProgressBar) view.findViewById(R.id.uploading_pb);
        return this;
    }
}
