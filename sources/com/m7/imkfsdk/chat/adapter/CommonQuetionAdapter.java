package com.m7.imkfsdk.chat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.CommonDetailQuestionActivity;
import com.m7.imkfsdk.chat.model.CommonQuestionBean;
import java.util.List;

/* loaded from: classes2.dex */
public class CommonQuetionAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<CommonQuestionBean> list;
    private Context mContext;

    /* loaded from: classes2.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final RelativeLayout rl_OneQuestion;
        public final TextView tv_commonQuetion;
        public final View view_line;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.tv_commonQuetion = (TextView) view.findViewById(R.id.tv_commonQuetion);
            this.rl_OneQuestion = (RelativeLayout) view.findViewById(R.id.rl_OneQuestion);
            this.view_line = view.findViewById(R.id.view_line);
        }
    }

    public CommonQuetionAdapter(Context context, List<CommonQuestionBean> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i2) {
        viewHolder.tv_commonQuetion.setText(this.list.get(i2).getTabContent());
        viewHolder.rl_OneQuestion.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.adapter.CommonQuetionAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(CommonQuetionAdapter.this.mContext, CommonDetailQuestionActivity.class);
                intent.putExtra("tabId", ((CommonQuestionBean) CommonQuetionAdapter.this.list.get(i2)).getTabId());
                CommonQuetionAdapter.this.mContext.startActivity(intent);
            }
        });
        if (i2 == this.list.size() - 1) {
            viewHolder.view_line.setVisibility(8);
        } else {
            viewHolder.view_line.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ykfsdk_item_question_parent, viewGroup, false));
    }
}
