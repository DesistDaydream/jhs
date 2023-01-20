package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.CircleProgressView;

/* loaded from: classes2.dex */
public class FileViewHolder extends BaseHolder {
    private ImageView chat_content_iv_download;
    private CircleProgressView chat_content_pb_progress;
    private TextView chat_content_tv_name;
    private TextView chat_content_tv_size;
    private TextView chat_content_tv_status;
    private ImageView ykf_chat_file_icon;

    public FileViewHolder(int i2) {
        super(i2);
    }

    public ImageView getChat_content_iv_download() {
        if (this.chat_content_iv_download == null) {
            this.chat_content_iv_download = (ImageView) getBaseView().findViewById(R.id.chat_content_iv_download);
        }
        return this.chat_content_iv_download;
    }

    public CircleProgressView getChat_content_pb_progress() {
        if (this.chat_content_pb_progress == null) {
            this.chat_content_pb_progress = (CircleProgressView) getBaseView().findViewById(R.id.chat_content_pb_progress);
        }
        return this.chat_content_pb_progress;
    }

    public TextView getChat_content_tv_name() {
        if (this.chat_content_tv_name == null) {
            this.chat_content_tv_name = (TextView) getBaseView().findViewById(R.id.chat_content_tv_name);
        }
        return this.chat_content_tv_name;
    }

    public TextView getChat_content_tv_size() {
        if (this.chat_content_tv_size == null) {
            this.chat_content_tv_size = (TextView) getBaseView().findViewById(R.id.chat_content_tv_size);
        }
        return this.chat_content_tv_size;
    }

    public TextView getChat_content_tv_status() {
        if (this.chat_content_tv_status == null) {
            this.chat_content_tv_status = (TextView) getBaseView().findViewById(R.id.chat_content_tv_status);
        }
        return this.chat_content_tv_status;
    }

    public ImageView getYkf_chat_file_icon() {
        if (this.ykf_chat_file_icon == null) {
            this.ykf_chat_file_icon = (ImageView) getBaseView().findViewById(R.id.ykf_chat_file_icon);
        }
        return this.ykf_chat_file_icon;
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.chat_content_tv_name = (TextView) view.findViewById(R.id.chat_content_tv_name);
        this.chat_content_tv_size = (TextView) view.findViewById(R.id.chat_content_tv_size);
        this.chat_content_tv_status = (TextView) view.findViewById(R.id.chat_content_tv_status);
        this.chat_content_pb_progress = (CircleProgressView) view.findViewById(R.id.chat_content_pb_progress);
        if (z) {
            this.chat_content_iv_download = (ImageView) view.findViewById(R.id.chat_content_iv_download);
            this.type = 8;
            return this;
        }
        this.progressBar = (ProgressBar) view.findViewById(R.id.uploading_pb);
        this.type = 9;
        return this;
    }
}
