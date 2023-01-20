package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class LogisticsInfoTxHolder extends BaseHolder {
    public ImageView iv_logistics_tx_img;
    public LinearLayout kf_chat_rich_lin;
    public TextView tv_logistics_tx_;
    public TextView tv_logistics_tx_num;
    public TextView tv_logistics_tx_price;
    public TextView tv_logistics_tx_second;
    public TextView tv_logistics_tx_state;
    public TextView tv_logistics_tx_title;

    public LogisticsInfoTxHolder(int i2) {
        super(i2);
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.iv_logistics_tx_img = (ImageView) view.findViewById(R.id.iv_logistics_tx_img);
        this.tv_logistics_tx_title = (TextView) view.findViewById(R.id.tv_logistics_tx_title);
        this.tv_logistics_tx_price = (TextView) view.findViewById(R.id.tv_logistics_tx_price);
        this.tv_logistics_tx_ = (TextView) view.findViewById(R.id.tv_logistics_tx_);
        this.tv_logistics_tx_num = (TextView) view.findViewById(R.id.tv_logistics_tx_num);
        this.tv_logistics_tx_second = (TextView) view.findViewById(R.id.tv_logistics_tx_second);
        this.tv_logistics_tx_state = (TextView) view.findViewById(R.id.tv_logistics_tx_state);
        this.progressBar = (ProgressBar) view.findViewById(R.id.uploading_pb);
        this.kf_chat_rich_lin = (LinearLayout) view.findViewById(R.id.kf_chat_rich_lin);
        return this;
    }
}
