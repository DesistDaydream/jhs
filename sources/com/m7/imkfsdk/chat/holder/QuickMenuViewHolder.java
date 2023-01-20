package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.LinearLayout;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class QuickMenuViewHolder extends BaseHolder {
    private LinearLayout ll_fast;

    public QuickMenuViewHolder(int i2) {
        super(i2);
    }

    public LinearLayout getLl_fast() {
        return this.ll_fast;
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.ll_fast = (LinearLayout) view.findViewById(R.id.ll_fast);
        return this;
    }
}
