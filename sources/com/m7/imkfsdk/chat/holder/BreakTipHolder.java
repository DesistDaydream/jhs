package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class BreakTipHolder extends BaseHolder {
    private TextView tv_content;

    public BreakTipHolder(int i2) {
        super(i2);
    }

    public TextView getDescTextView() {
        if (this.tv_content == null) {
            this.tv_content = (TextView) getBaseView().findViewById(R.id.chat_content_tv);
        }
        return this.tv_content;
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.tv_content = (TextView) view.findViewById(R.id.chat_content_tv);
        if (z) {
            this.type = 11;
        }
        return this;
    }
}
