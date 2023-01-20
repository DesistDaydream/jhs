package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class XbotSubmitHolder extends RecyclerView.ViewHolder {
    public final Button bt_form_submit;

    public XbotSubmitHolder(View view) {
        super(view);
        this.bt_form_submit = (Button) view.findViewById(R.id.bt_form_submit);
    }
}
