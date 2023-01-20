package com.m7.imkfsdk.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.utils.GlideUtil;
import com.moor.imkf.model.entity.MoorFastBtnBean;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class MoorFastBtnHorizontalAdapter extends RecyclerView.Adapter<FastViewHolder> {
    private Context context;
    public ArrayList<MoorFastBtnBean> datas;
    private OnItemClickListener mListener;

    /* loaded from: classes2.dex */
    public static class FastViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_fast_btn;
        public RelativeLayout sl_fast_btn;
        public TextView tv_fast_text;

        public FastViewHolder(View view) {
            super(view);
            this.sl_fast_btn = (RelativeLayout) view.findViewById(R.id.sl_fast_btn);
            this.tv_fast_text = (TextView) view.findViewById(R.id.tv_fast_text);
            this.iv_fast_btn = (ImageView) view.findViewById(R.id.iv_fast_btn);
        }
    }

    /* loaded from: classes2.dex */
    public interface OnItemClickListener {
        void OnItemClick(View view, MoorFastBtnBean moorFastBtnBean);
    }

    public MoorFastBtnHorizontalAdapter(Context context, ArrayList<MoorFastBtnBean> arrayList) {
        this.datas = arrayList;
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<MoorFastBtnBean> arrayList = this.datas;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final FastViewHolder fastViewHolder, int i2) {
        fastViewHolder.tv_fast_text.setText(this.datas.get(i2).getName());
        fastViewHolder.sl_fast_btn.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.adapter.MoorFastBtnHorizontalAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MoorFastBtnHorizontalAdapter.this.mListener != null) {
                    OnItemClickListener onItemClickListener = MoorFastBtnHorizontalAdapter.this.mListener;
                    FastViewHolder fastViewHolder2 = fastViewHolder;
                    onItemClickListener.OnItemClick(fastViewHolder2.sl_fast_btn, MoorFastBtnHorizontalAdapter.this.datas.get(fastViewHolder2.getAdapterPosition()));
                }
            }
        });
        GlideUtil.loadImageNoRounder(this.context, this.datas.get(i2).getIcon(), fastViewHolder.iv_fast_btn);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public FastViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new FastViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ykfsdk_item_fast_btn, viewGroup, false));
    }
}
