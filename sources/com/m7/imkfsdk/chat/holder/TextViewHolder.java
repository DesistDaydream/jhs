package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.PointBottomView;

/* loaded from: classes2.dex */
public class TextViewHolder extends BaseHolder {
    public ImageView chat_iv_robot_useful;
    public ImageView chat_iv_robot_useless;
    public RelativeLayout chat_ll_robot_useful;
    public RelativeLayout chat_ll_robot_useless;
    public RelativeLayout chat_rl_robot;
    public RelativeLayout chat_rl_robot_result;
    public TextView chat_tv_robot_result;
    public TextView chat_tv_robot_useful;
    public TextView chat_tv_robot_useless;
    public LinearLayout lin_content;
    public LinearLayout ll_flow;
    public LinearLayout ll_flow_multi;
    public RecyclerView mRecyclerView;
    public PointBottomView pointBottomView;
    private TextView tv_content;
    public TextView tv_multi_count;
    public TextView tv_multi_save;

    public TextViewHolder(int i2) {
        super(i2);
    }

    public LinearLayout getDescLinearLayout() {
        if (this.lin_content == null) {
            this.lin_content = (LinearLayout) this.baseView.findViewById(R.id.chart_content_lin);
        }
        return this.lin_content;
    }

    public TextView getDescTextView() {
        if (this.tv_content == null) {
            this.tv_content = (TextView) getBaseView().findViewById(R.id.chat_content_tv);
        }
        return this.tv_content;
    }

    public LinearLayout getFlowLinearLayout() {
        if (this.ll_flow == null) {
            this.ll_flow = (LinearLayout) this.baseView.findViewById(R.id.ll_flow);
        }
        return this.ll_flow;
    }

    public LinearLayout getLl_flow_multi() {
        return this.ll_flow_multi;
    }

    public PointBottomView getPointBottomView() {
        if (this.pointBottomView == null) {
            this.pointBottomView = (PointBottomView) getBaseView().findViewById(R.id.point);
        }
        return this.pointBottomView;
    }

    public TextView getTv_multi_count() {
        return this.tv_multi_count;
    }

    public TextView getTv_multi_save() {
        return this.tv_multi_save;
    }

    public RecyclerView getmRecyclerView() {
        if (this.mRecyclerView == null) {
            this.mRecyclerView = (RecyclerView) getBaseView().findViewById(R.id.recycler_view);
        }
        return this.mRecyclerView;
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        if (z) {
            this.type = 1;
            this.chat_rl_robot = (RelativeLayout) view.findViewById(R.id.chat_rl_robot);
            this.chat_rl_robot_result = (RelativeLayout) view.findViewById(R.id.chat_rl_robot_result);
            this.chat_ll_robot_useless = (RelativeLayout) view.findViewById(R.id.chat_ll_robot_useless);
            this.chat_ll_robot_useful = (RelativeLayout) view.findViewById(R.id.chat_ll_robot_useful);
            this.lin_content = (LinearLayout) view.findViewById(R.id.chart_content_lin);
            this.chat_iv_robot_useless = (ImageView) view.findViewById(R.id.chat_iv_robot_useless);
            this.chat_iv_robot_useful = (ImageView) view.findViewById(R.id.chat_iv_robot_useful);
            this.chat_tv_robot_useless = (TextView) view.findViewById(R.id.chat_tv_robot_useless);
            this.chat_tv_robot_useful = (TextView) view.findViewById(R.id.chat_tv_robot_useful);
            this.chat_tv_robot_result = (TextView) view.findViewById(R.id.chat_tv_robot_result);
            this.mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            this.pointBottomView = (PointBottomView) view.findViewById(R.id.point);
            this.ll_flow = (LinearLayout) view.findViewById(R.id.ll_flow);
            this.ll_flow_multi = (LinearLayout) view.findViewById(R.id.ll_flow_multi);
            this.tv_multi_save = (TextView) view.findViewById(R.id.tv_multi_save);
            this.tv_multi_count = (TextView) view.findViewById(R.id.tv_multi_count);
            return this;
        }
        this.tv_content = (TextView) view.findViewById(R.id.chat_content_tv);
        this.progressBar = (ProgressBar) view.findViewById(R.id.uploading_pb);
        this.type = 2;
        return this;
    }
}
