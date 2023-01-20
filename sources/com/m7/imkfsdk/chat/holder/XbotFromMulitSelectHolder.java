package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.MulitTagView;

/* loaded from: classes2.dex */
public class XbotFromMulitSelectHolder extends RecyclerView.ViewHolder {
    public final MulitTagView tagView;
    public final TextView tv_required;
    public final TextView tv_title;

    public XbotFromMulitSelectHolder(View view) {
        super(view);
        this.tv_title = (TextView) view.findViewById(R.id.tv_title);
        this.tv_required = (TextView) view.findViewById(R.id.tv_required);
        this.tagView = (MulitTagView) view.findViewById(R.id.mtv_tagview);
    }
}
