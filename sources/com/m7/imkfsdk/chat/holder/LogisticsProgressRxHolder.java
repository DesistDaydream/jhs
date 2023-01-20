package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class LogisticsProgressRxHolder extends BaseHolder {
    public RelativeLayout rl_logistics;
    public RecyclerView rv_logistics_rx;

    public LogisticsProgressRxHolder(int i2) {
        super(i2);
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.rl_logistics = (RelativeLayout) view.findViewById(R.id.rl_logistics);
        this.rv_logistics_rx = (RecyclerView) view.findViewById(R.id.rv_logistics_rx);
        return this;
    }
}
