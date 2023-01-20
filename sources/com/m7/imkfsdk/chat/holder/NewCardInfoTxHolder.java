package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class NewCardInfoTxHolder extends BaseHolder {
    public ImageView iv_order_img;
    public LinearLayout ll_order_main;
    public LinearLayout ll_other_title;
    public TextView tv_order_;
    public TextView tv_order_title;
    public TextView tv_send_order;

    public NewCardInfoTxHolder(int i2) {
        super(i2);
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.ll_other_title = (LinearLayout) view.findViewById(R.id.ll_other_title);
        this.iv_order_img = (ImageView) view.findViewById(R.id.iv_order_img);
        this.tv_order_title = (TextView) view.findViewById(R.id.tv_order_title);
        this.tv_order_ = (TextView) view.findViewById(R.id.tv_order_);
        this.tv_send_order = (TextView) view.findViewById(R.id.tv_send_order);
        this.ll_order_main = (LinearLayout) view.findViewById(R.id.ll_order_main);
        return this;
    }
}
