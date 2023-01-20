package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class XbotFromSingleTextHolder extends RecyclerView.ViewHolder {
    public final EditText et_single;
    public final TextView tv_required;
    public final TextView tv_title;

    public XbotFromSingleTextHolder(View view) {
        super(view);
        this.et_single = (EditText) view.findViewById(R.id.et_single);
        this.tv_title = (TextView) view.findViewById(R.id.tv_title);
        this.tv_required = (TextView) view.findViewById(R.id.tv_required);
    }
}
