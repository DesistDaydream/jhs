package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class XbotFromFileHolder extends RecyclerView.ViewHolder {
    public final LinearLayout ll_xbot_file;
    public final RelativeLayout rl_xbot_form_addfile;
    public final TextView tv_required;
    public final TextView tv_title;

    public XbotFromFileHolder(View view) {
        super(view);
        this.rl_xbot_form_addfile = (RelativeLayout) view.findViewById(R.id.rl_xbot_form_addfile);
        this.ll_xbot_file = (LinearLayout) view.findViewById(R.id.ll_xbot_file);
        this.tv_title = (TextView) view.findViewById(R.id.tv_title);
        this.tv_required = (TextView) view.findViewById(R.id.tv_required);
    }
}
