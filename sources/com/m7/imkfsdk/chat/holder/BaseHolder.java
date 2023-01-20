package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class BaseHolder {
    public View baseView;
    public RelativeLayout chart_from_container;
    public ImageView chattingAvatar;
    public View chattingMaskView;
    public TextView chattingTime;
    public TextView chatting_withdraw_tv;
    public CheckBox checkBox;
    public View clickAreaView;
    public ProgressBar progressBar;
    public TextView tv_un_read;
    public int type;
    public ImageView uploadState;

    public BaseHolder(int i2) {
        this.type = i2;
    }

    public View getBaseView() {
        return this.baseView;
    }

    public ImageView getChattingAvatar() {
        return this.chattingAvatar;
    }

    public View getChattingMaskView() {
        return this.chattingMaskView;
    }

    public TextView getChattingTime() {
        return this.chattingTime;
    }

    public CheckBox getCheckBox() {
        return this.checkBox;
    }

    public View getClickAreaView() {
        return this.clickAreaView;
    }

    public RelativeLayout getContainer() {
        if (this.chart_from_container == null) {
            this.chart_from_container = (RelativeLayout) getBaseView().findViewById(R.id.chart_from_container);
        }
        return this.chart_from_container;
    }

    public TextView getTv_un_read() {
        if (this.tv_un_read == null) {
            this.tv_un_read = (TextView) this.baseView.findViewById(R.id.tv_read_un);
        }
        return this.tv_un_read;
    }

    public int getType() {
        return this.type;
    }

    public ProgressBar getUploadProgressBar() {
        return this.progressBar;
    }

    public ImageView getUploadState() {
        return this.uploadState;
    }

    public TextView getWithdrawTextView() {
        if (this.chatting_withdraw_tv == null) {
            this.chatting_withdraw_tv = (TextView) getBaseView().findViewById(R.id.chatting_withdraw_tv);
        }
        return this.chatting_withdraw_tv;
    }

    public void initBaseHolder(View view) {
        this.baseView = view;
        this.chattingTime = (TextView) view.findViewById(R.id.chatting_time_tv);
        this.chattingAvatar = (ImageView) view.findViewById(R.id.chatting_avatar_iv);
        this.uploadState = (ImageView) view.findViewById(R.id.chatting_state_iv);
        this.chatting_withdraw_tv = (TextView) view.findViewById(R.id.chatting_withdraw_tv);
        this.chart_from_container = (RelativeLayout) view.findViewById(R.id.chart_from_container);
        this.tv_un_read = (TextView) view.findViewById(R.id.tv_read_un);
    }

    public void setChattingTime(TextView textView) {
        this.chattingTime = textView;
    }

    public void setEditMode(boolean z) {
        int i2 = z ? 0 : 8;
        CheckBox checkBox = this.checkBox;
        if (checkBox != null && checkBox.getVisibility() != i2) {
            this.checkBox.setVisibility(i2);
        }
        View view = this.chattingMaskView;
        if (view == null || view.getVisibility() == i2) {
            return;
        }
        this.chattingMaskView.setVisibility(i2);
    }

    public BaseHolder(View view) {
        this.baseView = view;
    }
}
