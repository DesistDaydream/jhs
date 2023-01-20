package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.dialog.BottomXbotFormDialog;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.XbotFormRxHolder;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.XbotForm;

/* loaded from: classes2.dex */
public class XbotFormRxChatRow extends BaseChatRow {
    public XbotFormRxChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_xbot_form_rx, (ViewGroup) null);
            inflate.setTag(new XbotFormRxHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(final Context context, BaseHolder baseHolder, final FromToMessage fromToMessage, int i2) {
        XbotFormRxHolder xbotFormRxHolder = (XbotFormRxHolder) baseHolder;
        if (fromToMessage == null || TextUtils.isEmpty(fromToMessage.xbotForm)) {
            return;
        }
        XbotForm xbotForm = (XbotForm) new Gson().n(fromToMessage.xbotForm, XbotForm.class);
        if (!TextUtils.isEmpty(xbotForm.formPrompt)) {
            xbotFormRxHolder.getformPromptView().setText(xbotForm.formPrompt);
        }
        if (fromToMessage.isSubmitXbotForm) {
            xbotFormRxHolder.getformNameView().setVisibility(8);
        } else {
            xbotFormRxHolder.getformNameView().setVisibility(0);
        }
        if (TextUtils.isEmpty(xbotForm.formName)) {
            return;
        }
        xbotFormRxHolder.getformNameView().setText(xbotForm.formName);
        xbotFormRxHolder.getformNameView().setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.XbotFormRxChatRow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                XbotForm xbotForm2 = (XbotForm) new Gson().n(fromToMessage.xbotForm, XbotForm.class);
                BottomXbotFormDialog.init(xbotForm2.formName, xbotForm2, fromToMessage._id).show(((ChatActivity) context).getSupportFragmentManager(), "");
            }
        });
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.XBOT_FORM_DATA_RECEIVED.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
