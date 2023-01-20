package com.m7.imkfsdk.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class LoadMoreWrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RecyclerView.Adapter adapter;
    private final int TYPE_ITEM = 1;
    private final int TYPE_FOOTER = 2;
    private int loadState = 2;
    public final int LOADING = 1;
    public final int LOADING_COMPLETE = 2;
    public final int LOADING_END = 3;

    /* loaded from: classes2.dex */
    public class FootViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout llEnd;
        public ProgressBar pbLoading;
        public TextView tvLoading;

        public FootViewHolder(View view) {
            super(view);
            this.pbLoading = (ProgressBar) view.findViewById(R.id.pb_loading);
            this.tvLoading = (TextView) view.findViewById(R.id.tv_loading);
            this.llEnd = (LinearLayout) view.findViewById(R.id.ll_end);
        }
    }

    public LoadMoreWrapper(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.adapter.getItemCount() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return i2 + 1 == getItemCount() ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder instanceof FootViewHolder) {
            FootViewHolder footViewHolder = (FootViewHolder) viewHolder;
            int i3 = this.loadState;
            if (i3 == 1) {
                footViewHolder.pbLoading.setVisibility(0);
                footViewHolder.tvLoading.setVisibility(0);
                footViewHolder.llEnd.setVisibility(8);
                return;
            } else if (i3 == 2) {
                footViewHolder.pbLoading.setVisibility(4);
                footViewHolder.tvLoading.setVisibility(4);
                footViewHolder.llEnd.setVisibility(8);
                return;
            } else if (i3 != 3) {
                return;
            } else {
                footViewHolder.pbLoading.setVisibility(8);
                footViewHolder.tvLoading.setVisibility(8);
                footViewHolder.llEnd.setVisibility(0);
                return;
            }
        }
        this.adapter.onBindViewHolder(viewHolder, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 2) {
            return new FootViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ykfsdk_layout_refresh_footer, viewGroup, false));
        }
        return this.adapter.onCreateViewHolder(viewGroup, i2);
    }

    public void setLoadState(int i2) {
        this.loadState = i2;
        notifyDataSetChanged();
    }
}
