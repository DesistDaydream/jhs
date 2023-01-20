package com.m7.imkfsdk.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.model.CommonQuestionBean;
import com.m7.imkfsdk.chat.model.DetailsQuestionBean;
import com.moor.imkf.http.HttpManager;
import com.moor.imkf.listener.HttpResponseListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class QuetionParentAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<DetailsQuestionBean> detailsQuestionBeans = new ArrayList<>();
    private List<CommonQuestionBean> list;
    private Context mContext;

    /* loaded from: classes2.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView iv_tip;
        public final RelativeLayout rl_OneQuestion;
        public final RecyclerView rv_question_child;
        public final TextView tv_commonQuetion;
        public final View view_line;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.tv_commonQuetion = (TextView) view.findViewById(R.id.tv_commonQuetion);
            this.rl_OneQuestion = (RelativeLayout) view.findViewById(R.id.rl_OneQuestion);
            this.view_line = view.findViewById(R.id.view_line);
            this.iv_tip = (ImageView) view.findViewById(R.id.iv_tip);
            this.rv_question_child = (RecyclerView) view.findViewById(R.id.rv_question_child);
        }
    }

    public QuetionParentAdapter(Context context, List<CommonQuestionBean> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i2) {
        viewHolder.tv_commonQuetion.setText(this.list.get(i2).getTabContent());
        viewHolder.rl_OneQuestion.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.adapter.QuetionParentAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (viewHolder.rv_question_child.isShown()) {
                    viewHolder.iv_tip.setImageResource(R.drawable.ykfsdk_kf_icon_question_down);
                    viewHolder.rv_question_child.setVisibility(8);
                    return;
                }
                viewHolder.iv_tip.setImageResource(R.drawable.ykfsdk_kf_icon_question_up);
                HttpManager.getDetailQuestions(((CommonQuestionBean) QuetionParentAdapter.this.list.get(i2)).getTabId(), 1, 30, new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.adapter.QuetionParentAdapter.1.1
                    @Override // com.moor.imkf.listener.HttpResponseListener
                    public void onFailed() {
                    }

                    @Override // com.moor.imkf.listener.HttpResponseListener
                    public void onSuccess(String str) {
                        try {
                            viewHolder.rv_question_child.setVisibility(0);
                            JSONArray jSONArray = new JSONObject(str).getJSONArray("list");
                            if (jSONArray.length() > 0) {
                                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                                    DetailsQuestionBean detailsQuestionBean = new DetailsQuestionBean();
                                    detailsQuestionBean.setQuestionId(jSONObject.getString("_id"));
                                    detailsQuestionBean.setTitle(jSONObject.getString("title"));
                                    QuetionParentAdapter.this.detailsQuestionBeans.add(detailsQuestionBean);
                                }
                                viewHolder.rv_question_child.setAdapter(new QuestionChildAdapter(QuetionParentAdapter.this.detailsQuestionBeans));
                                return;
                            }
                            viewHolder.rv_question_child.setVisibility(8);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                });
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
