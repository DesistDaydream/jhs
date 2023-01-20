package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.InvestigateViewHolder;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.YKFConstants;
import com.moor.imkf.listener.SubmitInvestigateListener;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.Investigate;
import com.moor.imkf.model.entity.MsgInves;

/* loaded from: classes2.dex */
public class InvestigateChatRow extends BaseChatRow {
    private Context context;
    private SharedPreferences sp;

    public InvestigateChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_investigate, (ViewGroup) null);
            inflate.setTag(new InvestigateViewHolder(this.mRowType).initBaseHolder(inflate, false));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(final Context context, BaseHolder baseHolder, final FromToMessage fromToMessage, int i2) {
        this.context = context;
        this.sp = context.getSharedPreferences(YKFConstants.MOOR_SP, 0);
        InvestigateViewHolder investigateViewHolder = (InvestigateViewHolder) baseHolder;
        LinearLayout chat_investigate_ll = investigateViewHolder.getChat_investigate_ll();
        TextView chat_investigate_tv = investigateViewHolder.getChat_investigate_tv();
        chat_investigate_ll.removeAllViews();
        final String string = this.sp.getString(YKFConstants.SATISFYTHANK, context.getString(R.string.ykfsdk_satisfy_thank));
        if (fromToMessage != null) {
            chat_investigate_tv.setText(this.sp.getString(YKFConstants.SATISFYTHANK, context.getString(R.string.ykfsdk_satisfy_title)));
            for (final MsgInves msgInves : fromToMessage.investigates) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.ykfsdk_kf_investigate_item, (ViewGroup) null);
                ((TextView) linearLayout.findViewById(R.id.investigate_item_tv_name)).setText(msgInves.name);
                linearLayout.setTag(msgInves);
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.InvestigateChatRow.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Investigate investigate = new Investigate();
                        MsgInves msgInves2 = msgInves;
                        investigate.name = msgInves2.name;
                        investigate.value = msgInves2.value;
                        IMChatManager.getInstance().submitInvestigate(investigate, new SubmitInvestigateListener() { // from class: com.m7.imkfsdk.chat.chatrow.InvestigateChatRow.1.1
                            @Override // com.moor.imkf.listener.SubmitInvestigateListener
                            public void onFailed() {
                            }

                            @Override // com.moor.imkf.listener.SubmitInvestigateListener
                            public void onSuccess() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                Toast.makeText(context, string, 0).show();
                                IMChatManager.getInstance().deleteInvestigateMsg(fromToMessage);
                                ((ChatActivity) context).updateMessage();
                            }
                        });
                    }
                });
                chat_investigate_ll.addView(linearLayout);
            }
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.INVESTIGATE_ROW_TRANSMIT.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
