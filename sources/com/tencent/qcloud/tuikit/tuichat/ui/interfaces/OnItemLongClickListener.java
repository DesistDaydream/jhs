package com.tencent.qcloud.tuikit.tuichat.ui.interfaces;

import android.view.View;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;

/* loaded from: classes3.dex */
public interface OnItemLongClickListener {
    void onMessageLongClick(View view, int i2, TUIMessageBean tUIMessageBean);

    void onReplyMessageClick(View view, int i2, String str);

    void onSendFailBtnClick(View view, int i2, TUIMessageBean tUIMessageBean);

    void onUserIconClick(View view, int i2, TUIMessageBean tUIMessageBean);

    void onUserIconLongClick(View view, int i2, TUIMessageBean tUIMessageBean);
}
