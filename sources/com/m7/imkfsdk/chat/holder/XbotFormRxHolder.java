package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class XbotFormRxHolder extends BaseHolder {
    private TextView tv_formName;
    private TextView tv_formPrompt;

    public XbotFormRxHolder(int i2) {
        super(i2);
    }

    public TextView getformNameView() {
        if (this.tv_formName == null) {
            this.tv_formName = (TextView) getBaseView().findViewById(R.id.tv_formName);
        }
        return this.tv_formName;
    }

    public TextView getformPromptView() {
        if (this.tv_formPrompt == null) {
            this.tv_formPrompt = (TextView) getBaseView().findViewById(R.id.tv_formPrompt);
        }
        return this.tv_formPrompt;
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.tv_formPrompt = (TextView) view.findViewById(R.id.tv_formPrompt);
        this.tv_formName = (TextView) view.findViewById(R.id.tv_formName);
        if (z) {
            this.type = 25;
        }
        return this;
    }
}
