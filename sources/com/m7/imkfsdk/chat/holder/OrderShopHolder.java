package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class OrderShopHolder extends RecyclerView.ViewHolder {
    public final ImageView iv_shop_group_img;
    public final RelativeLayout rl_shop_main;
    public final TextView tv_shop_group_name;
    public final TextView tv_shop_group_state;

    public OrderShopHolder(View view) {
        super(view);
        this.rl_shop_main = (RelativeLayout) view.findViewById(R.id.rl_shop_main);
        this.tv_shop_group_name = (TextView) view.findViewById(R.id.tv_shop_group_name);
        this.iv_shop_group_img = (ImageView) view.findViewById(R.id.iv_shop_group_img);
        this.tv_shop_group_state = (TextView) view.findViewById(R.id.tv_shop_group_state);
    }
}
