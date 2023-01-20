package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class LogisticsProgressHolder extends RecyclerView.ViewHolder {
    public TextView tvAcceptStation;
    public TextView tvAcceptTime;
    public View view_bottomline;
    public View view_dot;
    public View view_topline;

    public LogisticsProgressHolder(View view) {
        super(view);
        this.tvAcceptStation = (TextView) view.findViewById(R.id.tvAcceptStation);
        this.view_topline = view.findViewById(R.id.view_topline);
        this.view_bottomline = view.findViewById(R.id.view_bottomline);
        this.tvAcceptTime = (TextView) view.findViewById(R.id.tvAcceptTime);
        this.view_dot = view.findViewById(R.id.view_dot);
    }
}
