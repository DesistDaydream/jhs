package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.dropdownmenu.DropDownMenu;

/* loaded from: classes2.dex */
public class XbotFromSingleSelectHolder extends RecyclerView.ViewHolder {
    public final DropDownMenu drop_single;
    public final TextView tv_required;
    public final TextView tv_title;

    public XbotFromSingleSelectHolder(View view) {
        super(view);
        this.drop_single = (DropDownMenu) view.findViewById(R.id.drop_single);
        this.tv_title = (TextView) view.findViewById(R.id.tv_title);
        this.tv_required = (TextView) view.findViewById(R.id.tv_required);
    }
}
