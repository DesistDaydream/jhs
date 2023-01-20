package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class InvestigateViewHolder extends BaseHolder {
    private LinearLayout chat_investigate_ll;
    private TextView tv;

    public InvestigateViewHolder(int i2) {
        super(i2);
    }

    public LinearLayout getChat_investigate_ll() {
        if (this.chat_investigate_ll == null) {
            this.chat_investigate_ll = (LinearLayout) this.baseView.findViewById(R.id.chat_investigate_ll);
        }
        return this.chat_investigate_ll;
    }

    public TextView getChat_investigate_tv() {
        if (this.tv == null) {
            this.tv = (TextView) this.baseView.findViewById(R.id.tv);
        }
        return this.tv;
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.chat_investigate_ll = (LinearLayout) view.findViewById(R.id.chat_investigate_ll);
        this.tv = (TextView) view.findViewById(R.id.tv);
        this.type = 7;
        return this;
    }
}
