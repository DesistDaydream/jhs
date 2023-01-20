package com.tencent.qcloud.tuikit.tuicontact.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuikit.tuicontact.R;
import java.util.List;

/* loaded from: classes3.dex */
public class ForwardContactSelectorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> list;
    private RecyclerView mRecycleView;

    public ForwardContactSelectorAdapter(Context context) {
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecycleView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ContactViewHolder contactViewHolder = (ContactViewHolder) viewHolder;
        if (contactViewHolder == null || TextUtils.isEmpty(this.list.get(i2))) {
            return;
        }
        GlideEngine.loadImage(contactViewHolder.userIconView, this.list.get(i2));
    }

    public void setDataSource(List<String> list) {
        if (list == null) {
            List<String> list2 = this.list;
            if (list2 != null) {
                list2.clear();
            }
        } else {
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ContactViewHolder(LayoutInflater.from(this.context).inflate(R.layout.forward_contact_selector_item, viewGroup, false));
    }
}
