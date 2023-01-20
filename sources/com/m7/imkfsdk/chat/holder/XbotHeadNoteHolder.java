package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class XbotHeadNoteHolder extends RecyclerView.ViewHolder {
    public final TextView tv_formNotes;

    public XbotHeadNoteHolder(View view) {
        super(view);
        this.tv_formNotes = (TextView) view.findViewById(R.id.tv_formNotes);
    }
}
