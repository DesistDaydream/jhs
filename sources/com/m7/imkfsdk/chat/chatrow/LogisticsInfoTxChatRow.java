package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.LogisticsInfoTxHolder;
import com.m7.imkfsdk.chat.holder.ViewHolderTag;
import com.m7.imkfsdk.utils.GlideUtil;
import com.moor.imkf.lib.utils.MoorNullUtil;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.NewCardInfo;
import com.tencent.android.tpns.mqtt.MqttTopic;
import e.j.e.t.a;

/* loaded from: classes2.dex */
public class LogisticsInfoTxChatRow extends BaseChatRow {
    public LogisticsInfoTxChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_logistics_tx, (ViewGroup) null);
            inflate.setTag(new LogisticsInfoTxHolder(this.mRowType).initBaseHolder(inflate, false));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        LogisticsInfoTxHolder logisticsInfoTxHolder = (LogisticsInfoTxHolder) baseHolder;
        if (fromToMessage == null || fromToMessage.newCardInfo == null) {
            return;
        }
        NewCardInfo newCardInfo = (NewCardInfo) new Gson().o(fromToMessage.newCardInfo, new a<NewCardInfo>() { // from class: com.m7.imkfsdk.chat.chatrow.LogisticsInfoTxChatRow.1
        }.getType());
        if (MoorNullUtil.checkNULL(newCardInfo.getTitle())) {
            logisticsInfoTxHolder.tv_logistics_tx_title.setText(newCardInfo.getTitle());
        }
        if (MoorNullUtil.checkNULL(newCardInfo.getSub_title())) {
            logisticsInfoTxHolder.tv_logistics_tx_.setText(newCardInfo.getSub_title());
        }
        if (MoorNullUtil.checkNULL(newCardInfo.getAttr_one().getColor())) {
            String color = newCardInfo.getAttr_one().getColor();
            if (color.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                try {
                    logisticsInfoTxHolder.tv_logistics_tx_num.setTextColor(Color.parseColor(color));
                } catch (Exception unused) {
                }
            }
        }
        if (MoorNullUtil.checkNULL(newCardInfo.getAttr_two().getColor())) {
            String color2 = newCardInfo.getAttr_two().getColor();
            if (color2.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                try {
                    logisticsInfoTxHolder.tv_logistics_tx_state.setTextColor(Color.parseColor(color2));
                } catch (Exception unused2) {
                }
            }
        }
        if (MoorNullUtil.checkNULL(newCardInfo.getAttr_one().getContent())) {
            logisticsInfoTxHolder.tv_logistics_tx_num.setText(newCardInfo.getAttr_one().getContent());
        }
        if (MoorNullUtil.checkNULL(newCardInfo.getAttr_two().getContent())) {
            logisticsInfoTxHolder.tv_logistics_tx_state.setText(newCardInfo.getAttr_two().getContent());
        }
        if (MoorNullUtil.checkNULL(newCardInfo.getPrice())) {
            logisticsInfoTxHolder.tv_logistics_tx_price.setText(newCardInfo.getPrice());
        }
        if (MoorNullUtil.checkNULL(newCardInfo.getOther_title_three())) {
            logisticsInfoTxHolder.tv_logistics_tx_second.setText(newCardInfo.getOther_title_three());
        }
        if (MoorNullUtil.checkNULL(newCardInfo.getOther_title_two())) {
            logisticsInfoTxHolder.tv_logistics_tx_second.setText(newCardInfo.getOther_title_two());
        }
        if (MoorNullUtil.checkNULL(newCardInfo.getOther_title_one())) {
            logisticsInfoTxHolder.tv_logistics_tx_second.setText(newCardInfo.getOther_title_one());
        }
        GlideUtil.loadImage(context, newCardInfo.getImg(), 2.0f, logisticsInfoTxHolder.iv_logistics_tx_img);
        View.OnClickListener onClickListener = ((ChatActivity) context).getChatAdapter().getOnClickListener();
        BaseChatRow.getMsgStateResId(i2, logisticsInfoTxHolder, fromToMessage, onClickListener);
        logisticsInfoTxHolder.kf_chat_rich_lin.setTag(ViewHolderTag.createTag(newCardInfo.getTarget_url(), 14));
        logisticsInfoTxHolder.kf_chat_rich_lin.setOnClickListener(onClickListener);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.LOGISTICS_INFORMATION_ROW_TRANSMIT.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
