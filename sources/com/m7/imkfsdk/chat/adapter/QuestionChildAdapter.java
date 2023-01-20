package com.m7.imkfsdk.chat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.model.DetailsQuestionBean;
import com.moor.imkf.IMChat;
import com.moor.imkf.IMMessage;
import com.moor.imkf.event.QuestionEvent;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.listener.ChatListener;
import com.qiniu.android.common.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import k.c.a.c;

/* loaded from: classes2.dex */
public class QuestionChildAdapter extends RecyclerView.Adapter<SwipeHolder> {
    private List<DetailsQuestionBean> list;

    /* loaded from: classes2.dex */
    public static class SwipeHolder extends RecyclerView.ViewHolder {
        public final RelativeLayout rl_item;
        public final TextView tv_detailQuestion;
        public final View view_line;

        public SwipeHolder(View view) {
            super(view);
            this.tv_detailQuestion = (TextView) view.findViewById(R.id.tv_detailQuestion);
            this.rl_item = (RelativeLayout) view.findViewById(R.id.rl_item);
            this.view_line = view.findViewById(R.id.view_line);
        }
    }

    public QuestionChildAdapter(List<DetailsQuestionBean> list) {
        this.list = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SwipeHolder swipeHolder, final int i2) {
        swipeHolder.tv_detailQuestion.setText(this.list.get(i2).getTitle());
        swipeHolder.rl_item.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.adapter.QuestionChildAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String title = ((DetailsQuestionBean) QuestionChildAdapter.this.list.get(i2)).getTitle();
                try {
                    String encode = URLEncoder.encode("【常见问题】" + title, Constants.UTF_8);
                    IMChat.getInstance().sendQuestionMsg(((DetailsQuestionBean) QuestionChildAdapter.this.list.get(i2)).getQuestionId(), encode, IMMessage.createQuestionMessage(encode), new ChatListener() { // from class: com.m7.imkfsdk.chat.adapter.QuestionChildAdapter.1.1
                        @Override // com.moor.imkf.listener.ChatListener
                        public void onFailed(String str) {
                            MoorLogUtils.eTag("SendMessage", str);
                        }

                        @Override // com.moor.imkf.listener.ChatListener
                        public void onProgress(int i3) {
                        }

                        @Override // com.moor.imkf.listener.ChatListener
                        public void onSuccess(String str) {
                            c.f().q(new QuestionEvent());
                        }
                    });
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        });
        if (i2 == this.list.size() - 1) {
            swipeHolder.view_line.setVisibility(8);
        } else {
            swipeHolder.view_line.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SwipeHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new SwipeHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ykfsdk_item_question_child, viewGroup, false));
    }
}
