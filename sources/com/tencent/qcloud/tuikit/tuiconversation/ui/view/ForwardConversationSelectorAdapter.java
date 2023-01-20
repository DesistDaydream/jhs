package com.tencent.qcloud.tuikit.tuiconversation.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuiconversation.R;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class ForwardConversationSelectorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ConversationInfo> list;
    private OnItemClickListener mOnItemClickListener;

    /* loaded from: classes3.dex */
    public static class ConversationViewHolder extends RecyclerView.ViewHolder {
        public ConversationIconView conversationUserIconView;

        public ConversationViewHolder(View view) {
            super(view);
            this.conversationUserIconView = (ConversationIconView) view.findViewById(R.id.conversation_user_icon_view);
        }
    }

    /* loaded from: classes3.dex */
    public interface OnItemClickListener {
        void onClick(View view, int i2);
    }

    public ForwardConversationSelectorAdapter(Context context) {
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ConversationInfo> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i2) {
        ConversationViewHolder conversationViewHolder = (ConversationViewHolder) viewHolder;
        conversationViewHolder.conversationUserIconView.setVisibility(0);
        conversationViewHolder.conversationUserIconView.setConversation(this.list.get(i2));
        conversationViewHolder.conversationUserIconView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.view.ForwardConversationSelectorAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForwardConversationSelectorAdapter.this.mOnItemClickListener.onClick(view, i2);
            }
        });
    }

    public void setDataSource(List<ConversationInfo> list) {
        if (list == null) {
            List<ConversationInfo> list2 = this.list;
            if (list2 != null) {
                list2.clear();
            }
        } else {
            this.list = list;
        }
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ConversationViewHolder(LayoutInflater.from(this.context).inflate(R.layout.forward_conversation_selector_item, viewGroup, false));
    }
}
