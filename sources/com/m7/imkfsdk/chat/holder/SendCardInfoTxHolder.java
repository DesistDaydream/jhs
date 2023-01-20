package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class SendCardInfoTxHolder extends BaseHolder {
    public ImageView iv_child_img;
    public LinearLayout kf_chat_rich_lin;
    public TextView tv_child_;
    public TextView tv_child_num;
    public TextView tv_child_price;
    public TextView tv_child_state;
    public TextView tv_child_title;

    public SendCardInfoTxHolder(int i2) {
        super(i2);
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.iv_child_img = (ImageView) view.findViewById(R.id.iv_child_img);
        this.tv_child_title = (TextView) view.findViewById(R.id.tv_child_title);
        this.tv_child_ = (TextView) view.findViewById(R.id.tv_child_);
        this.tv_child_num = (TextView) view.findViewById(R.id.tv_child_num);
        this.tv_child_price = (TextView) view.findViewById(R.id.tv_child_price);
        this.tv_child_state = (TextView) view.findViewById(R.id.tv_child_state);
        this.progressBar = (ProgressBar) view.findViewById(R.id.uploading_pb);
        this.kf_chat_rich_lin = (LinearLayout) view.findViewById(R.id.kf_chat_rich_lin);
        return this;
    }
}
