package com.m7.imkfsdk.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.model.entity.FlowBean;
import com.moor.imkf.model.entity.FromToMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class FlowAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    public List<FlowBean> data;
    private FromToMessage detail;
    private boolean isMulit;
    public HashMap<Integer, Boolean> map_flow = new HashMap<>();
    private OnItemClickListenr onItemClickListenr;

    /* loaded from: classes2.dex */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_choose_flow;
        public TextView tv_flowItem;

        public MyViewHolder(View view) {
            super(view);
            this.tv_flowItem = (TextView) view.findViewById(R.id.tv_flowItem);
            this.iv_choose_flow = (ImageView) view.findViewById(R.id.iv_choose_flow);
        }
    }

    /* loaded from: classes2.dex */
    public interface OnItemClickListenr {
        void setOnButtonClickListenr(int i2, boolean z, String str);
    }

    public FlowAdapter(Context context, List<FlowBean> list, boolean z, FromToMessage fromToMessage, OnItemClickListenr onItemClickListenr) {
        this.data = new ArrayList();
        this.isMulit = false;
        this.onItemClickListenr = onItemClickListenr;
        this.data = list;
        this.context = context;
        this.isMulit = z;
        this.detail = fromToMessage;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int i2) {
        final FlowBean flowBean = this.data.get(i2);
        myViewHolder.tv_flowItem.setText(flowBean.getButton());
        if (flowBean.isChoose()) {
            myViewHolder.iv_choose_flow.setVisibility(0);
            myViewHolder.tv_flowItem.setBackgroundResource(R.drawable.ykfsdk_ykf_bg_flow_btn);
        } else {
            myViewHolder.iv_choose_flow.setVisibility(8);
            myViewHolder.tv_flowItem.setBackgroundResource(R.drawable.ykfsdk_bg_flow_item);
        }
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.adapter.FlowAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (IMChatManager.getInstance().isManual || FlowAdapter.this.detail.isFlowSelect) {
                    return;
                }
                FlowBean flowBean2 = flowBean;
                flowBean2.setChoose(!flowBean2.isChoose());
                FlowAdapter.this.notifyDataSetChanged();
                FlowAdapter.this.onItemClickListenr.setOnButtonClickListenr(i2, flowBean.isChoose(), flowBean.getText());
                FlowAdapter.this.notifyItemChanged(myViewHolder.getAdapterPosition());
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ykfsdk_layout_item, viewGroup, false));
    }
}
