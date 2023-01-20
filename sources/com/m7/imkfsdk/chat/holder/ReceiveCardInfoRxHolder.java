package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class ReceiveCardInfoRxHolder extends BaseHolder {
    public ImageView iv_logistics_tx_img;
    public LinearLayout kf_chat_rich_lin;
    public LinearLayout ll_received_new_order_info;
    public TextView tv_logistics_tx_num;
    public TextView tv_logistics_tx_price;
    public TextView tv_logistics_tx_second;
    public TextView tv_logistics_tx_state;
    public TextView tv_logistics_tx_title;

    public ReceiveCardInfoRxHolder(int i2) {
        super(i2);
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.iv_logistics_tx_img = (ImageView) view.findViewById(R.id.iv_logistics_tx_img);
        this.tv_logistics_tx_title = (TextView) view.findViewById(R.id.tv_logistics_tx_title);
        this.tv_logistics_tx_price = (TextView) view.findViewById(R.id.tv_logistics_tx_price);
        this.tv_logistics_tx_num = (TextView) view.findViewById(R.id.tv_logistics_tx_num);
        this.tv_logistics_tx_second = (TextView) view.findViewById(R.id.tv_logistics_tx_second);
        this.tv_logistics_tx_state = (TextView) view.findViewById(R.id.tv_logistics_tx_state);
        this.kf_chat_rich_lin = (LinearLayout) view.findViewById(R.id.kf_chat_rich_lin);
        this.ll_received_new_order_info = (LinearLayout) view.findViewById(R.id.ll_received_new_order_info);
        return this;
    }
}
