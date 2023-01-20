package com.tencent.qcloud.tuikit.tuicontact.ui.view;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuicontact.R;

/* loaded from: classes3.dex */
public class ContactViewHolder extends RecyclerView.ViewHolder {
    public ImageView userIconView;

    public ContactViewHolder(View view) {
        super(view);
        this.userIconView = (ImageView) view.findViewById(R.id.ivAvatar);
    }
}
