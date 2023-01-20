package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class LogisticsInfoRxHolder extends BaseHolder {
    public TextView kf_chat_rich_content;
    public TextView kf_chat_rich_title;
    public LinearLayout ll_order_content;
    public RelativeLayout rl_logistics;
    public RelativeLayout rl_progress_top;
    public RecyclerView rv_logistics_rx;
    public TextView tv_logistics_progress_name;
    public TextView tv_logistics_progress_num;
    public TextView tv_no_data;
    public View view_middle;
    public View view_top;

    public LogisticsInfoRxHolder(int i2) {
        super(i2);
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.rv_logistics_rx = (RecyclerView) view.findViewById(R.id.rv_logistics_rx);
        this.rl_logistics = (RelativeLayout) view.findViewById(R.id.rl_logistics);
        this.kf_chat_rich_title = (TextView) view.findViewById(R.id.kf_chat_rich_title);
        this.kf_chat_rich_content = (TextView) view.findViewById(R.id.kf_chat_rich_content);
        this.rl_progress_top = (RelativeLayout) view.findViewById(R.id.rl_progress_top);
        this.tv_no_data = (TextView) view.findViewById(R.id.tv_no_data);
        this.tv_logistics_progress_name = (TextView) view.findViewById(R.id.tv_logistics_progress_name);
        this.tv_logistics_progress_num = (TextView) view.findViewById(R.id.tv_logistics_progress_num);
        this.ll_order_content = (LinearLayout) view.findViewById(R.id.ll_order_content);
        this.view_top = view.findViewById(R.id.view_top);
        this.view_middle = view.findViewById(R.id.view_middle);
        return this;
    }
}
