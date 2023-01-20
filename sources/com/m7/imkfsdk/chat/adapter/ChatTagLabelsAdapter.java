package com.m7.imkfsdk.chat.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.moor.imkf.model.entity.FlowBean;
import java.util.List;

/* loaded from: classes2.dex */
public class ChatTagLabelsAdapter extends RecyclerView.Adapter<ChatTagViewHolder> {
    public List<FlowBean> datas;
    private onItemClickListener mListener;

    /* loaded from: classes2.dex */
    public static class ChatTagViewHolder extends RecyclerView.ViewHolder {
        public TextView tvFlowItem;

        public ChatTagViewHolder(View view) {
            super(view);
            this.tvFlowItem = (TextView) view.findViewById(R.id.tv_flowItem);
        }
    }

    /* loaded from: classes2.dex */
    public interface onItemClickListener {
        void OnItemClick(FlowBean flowBean);
    }

    public ChatTagLabelsAdapter(List<FlowBean> list) {
        this.datas = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<FlowBean> list = this.datas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void refreshData(List<FlowBean> list) {
        this.datas.clear();
        this.datas = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(onItemClickListener onitemclicklistener) {
        this.mListener = onitemclicklistener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ChatTagViewHolder chatTagViewHolder, final int i2) {
        chatTagViewHolder.tvFlowItem.setText(this.datas.get(i2).getButton());
        chatTagViewHolder.tvFlowItem.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.adapter.ChatTagLabelsAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChatTagLabelsAdapter.this.mListener != null) {
                    ChatTagLabelsAdapter.this.mListener.OnItemClick(ChatTagLabelsAdapter.this.datas.get(i2));
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ChatTagViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ChatTagViewHolder(View.inflate(viewGroup.getContext(), R.layout.ykfsdk_item_chat_tag_label, null));
    }
}
