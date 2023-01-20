package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.gson.Gson;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.ReceiveCardInfoRxHolder;
import com.m7.imkfsdk.chat.holder.ViewHolderTag;
import com.m7.imkfsdk.utils.GlideUtil;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.NewCardInfo;
import com.tencent.android.tpns.mqtt.MqttTopic;
import e.j.e.t.a;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ReceivedCardInfoRxChatRow extends BaseChatRow {
    private int padding;

    public ReceivedCardInfoRxChatRow(int i2) {
        super(i2);
        this.padding = MoorDensityUtil.dp2px(8.0f);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_received_newcardinfo_rx, (ViewGroup) null);
            inflate.setTag(new ReceiveCardInfoRxHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        ReceiveCardInfoRxHolder receiveCardInfoRxHolder = (ReceiveCardInfoRxHolder) baseHolder;
        if (fromToMessage == null || fromToMessage.newCardInfo == null) {
            return;
        }
        NewCardInfo newCardInfo = (NewCardInfo) new Gson().o(fromToMessage.newCardInfo, new a<NewCardInfo>() { // from class: com.m7.imkfsdk.chat.chatrow.ReceivedCardInfoRxChatRow.1
        }.getType());
        receiveCardInfoRxHolder.tv_logistics_tx_title.setText(newCardInfo.getTitle());
        receiveCardInfoRxHolder.tv_logistics_tx_second.setText(newCardInfo.getSub_title());
        if (newCardInfo.getAttr_one() != null) {
            receiveCardInfoRxHolder.tv_logistics_tx_num.setText(newCardInfo.getAttr_one().getContent());
            String color = newCardInfo.getAttr_one().getColor();
            if (color.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                try {
                    receiveCardInfoRxHolder.tv_logistics_tx_num.setTextColor(Color.parseColor(color));
                } catch (Exception unused) {
                }
            }
        }
        if (newCardInfo.getAttr_two() != null) {
            receiveCardInfoRxHolder.tv_logistics_tx_state.setText(newCardInfo.getAttr_two().getContent());
            String color2 = newCardInfo.getAttr_two().getColor();
            if (color2.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                try {
                    receiveCardInfoRxHolder.tv_logistics_tx_state.setTextColor(Color.parseColor(color2));
                } catch (Exception unused2) {
                }
            }
        }
        if (!"".equals(newCardInfo.getPrice())) {
            receiveCardInfoRxHolder.tv_logistics_tx_price.setVisibility(0);
            receiveCardInfoRxHolder.tv_logistics_tx_state.setVisibility(0);
            receiveCardInfoRxHolder.tv_logistics_tx_num.setVisibility(0);
            receiveCardInfoRxHolder.tv_logistics_tx_price.setText(newCardInfo.getPrice());
            receiveCardInfoRxHolder.tv_logistics_tx_second.setMaxLines(1);
        } else {
            receiveCardInfoRxHolder.tv_logistics_tx_price.setVisibility(8);
            receiveCardInfoRxHolder.tv_logistics_tx_state.setVisibility(8);
            receiveCardInfoRxHolder.tv_logistics_tx_num.setVisibility(8);
            receiveCardInfoRxHolder.tv_logistics_tx_second.setMaxLines(2);
        }
        ArrayList<String> arrayList = new ArrayList();
        if (!"".equals(newCardInfo.getOther_title_one())) {
            arrayList.add(newCardInfo.getOther_title_one());
        }
        if (!"".equals(newCardInfo.getOther_title_two())) {
            arrayList.add(newCardInfo.getOther_title_two());
        }
        if (!"".equals(newCardInfo.getOther_title_three())) {
            arrayList.add(newCardInfo.getOther_title_three());
        }
        if (arrayList.size() > 0) {
            receiveCardInfoRxHolder.ll_received_new_order_info.removeAllViews();
            receiveCardInfoRxHolder.ll_received_new_order_info.setVisibility(0);
            for (String str : arrayList) {
                TextView textView = new TextView(context);
                int i3 = this.padding;
                textView.setPadding(i3, 0, i3, i3 / 2);
                textView.setTextSize(12.0f);
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setTextColor(context.getResources().getColor(R.color.ykfsdk_color_666666));
                textView.setText(str);
                receiveCardInfoRxHolder.ll_received_new_order_info.addView(textView);
            }
        } else {
            receiveCardInfoRxHolder.ll_received_new_order_info.setVisibility(8);
        }
        GlideUtil.loadImage(context, newCardInfo.getImg(), 2.0f, receiveCardInfoRxHolder.iv_logistics_tx_img);
        View.OnClickListener onClickListener = ((ChatActivity) context).getChatAdapter().getOnClickListener();
        receiveCardInfoRxHolder.kf_chat_rich_lin.setTag(ViewHolderTag.createTag(newCardInfo.getTarget(), 9));
        receiveCardInfoRxHolder.kf_chat_rich_lin.setOnClickListener(onClickListener);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.RECEIVED_ORDER_INFO_ROW_RECEIVED.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
