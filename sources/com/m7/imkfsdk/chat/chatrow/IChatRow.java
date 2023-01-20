package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.moor.imkf.model.entity.FromToMessage;

/* loaded from: classes2.dex */
public interface IChatRow {
    View buildChatView(LayoutInflater layoutInflater, View view);

    void buildChattingBaseData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2);

    int getChatViewType();
}
