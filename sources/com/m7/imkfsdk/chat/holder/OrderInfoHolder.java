package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class OrderInfoHolder extends RecyclerView.ViewHolder {
    public final ImageView iv_child_img;
    public final RelativeLayout rl_child_main;
    public final TextView tv_child_;
    public final TextView tv_child_num;
    public final TextView tv_child_price;
    public final TextView tv_child_second;
    public final TextView tv_child_state;
    public final TextView tv_child_title;

    public OrderInfoHolder(View view) {
        super(view);
        this.tv_child_title = (TextView) view.findViewById(R.id.tv_child_title);
        this.iv_child_img = (ImageView) view.findViewById(R.id.iv_child_img);
        this.tv_child_price = (TextView) view.findViewById(R.id.tv_child_price);
        this.tv_child_ = (TextView) view.findViewById(R.id.tv_child_);
        this.tv_child_num = (TextView) view.findViewById(R.id.tv_child_num);
        this.tv_child_second = (TextView) view.findViewById(R.id.tv_child_second);
        this.tv_child_state = (TextView) view.findViewById(R.id.tv_child_state);
        this.rl_child_main = (RelativeLayout) view.findViewById(R.id.rl_child_main);
    }
}
