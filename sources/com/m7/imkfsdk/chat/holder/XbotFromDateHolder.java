package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class XbotFromDateHolder extends RecyclerView.ViewHolder {
    public final TextView tv_date;
    public final TextView tv_required;
    public final TextView tv_title;

    public XbotFromDateHolder(View view) {
        super(view);
        this.tv_title = (TextView) view.findViewById(R.id.tv_title);
        this.tv_required = (TextView) view.findViewById(R.id.tv_required);
        this.tv_date = (TextView) view.findViewById(R.id.tv_date);
    }
}
