package com.tencent.qcloud.tuikit.tuichat.bean;

import android.view.View;

/* loaded from: classes3.dex */
public class InputMoreActionUnit {
    private int actionId;
    private ChatInfo chatInfo;
    private int iconResId;
    private int titleId;
    private View unitView;
    private int priority = 0;
    private OnActionClickListener onClickListener = new OnActionClickListener();

    /* loaded from: classes3.dex */
    public class OnActionClickListener {
        public OnActionClickListener() {
        }

        public void onClick() {
            InputMoreActionUnit inputMoreActionUnit = InputMoreActionUnit.this;
            inputMoreActionUnit.onAction(inputMoreActionUnit.getChatId(), InputMoreActionUnit.this.getChatType());
        }
    }

    public int getActionId() {
        return this.actionId;
    }

    public String getChatId() {
        ChatInfo chatInfo = this.chatInfo;
        if (chatInfo != null) {
            return chatInfo.getId();
        }
        return null;
    }

    public int getChatType() {
        ChatInfo chatInfo = this.chatInfo;
        if (chatInfo != null) {
            return chatInfo.getType();
        }
        return 0;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public OnActionClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getTitleId() {
        return this.titleId;
    }

    public View getUnitView() {
        return this.unitView;
    }

    public boolean isEnable(int i2) {
        return true;
    }

    public void onAction(String str, int i2) {
    }

    public void setActionId(int i2) {
        this.actionId = i2;
    }

    public void setChatInfo(ChatInfo chatInfo) {
        this.chatInfo = chatInfo;
    }

    public void setIconResId(int i2) {
        this.iconResId = i2;
    }

    public void setOnClickListener(OnActionClickListener onActionClickListener) {
        this.onClickListener = onActionClickListener;
    }

    public void setPriority(int i2) {
        this.priority = i2;
    }

    public void setTitleId(int i2) {
        this.titleId = i2;
    }

    public void setUnitView(View view) {
        this.unitView = view;
    }
}
