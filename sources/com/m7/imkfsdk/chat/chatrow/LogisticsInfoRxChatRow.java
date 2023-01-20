package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.Gson;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.adapter.LogisticsInfoRxListAdapter;
import com.m7.imkfsdk.chat.adapter.LogisticsProgressListAdapter;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.LogisticsInfoRxHolder;
import com.m7.imkfsdk.chat.holder.ViewHolderTag;
import com.m7.imkfsdk.chat.model.OrderBaseBean;
import com.m7.imkfsdk.chat.model.OrderInfoBean;
import com.moor.imkf.lib.utils.MoorNullUtil;
import com.moor.imkf.model.entity.FromToMessage;
import e.j.e.t.a;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class LogisticsInfoRxChatRow extends BaseChatRow {
    private ViewHolderTag holderTag;
    private int moreSize;
    private int type;

    public LogisticsInfoRxChatRow(int i2) {
        super(i2);
        this.moreSize = 5;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_logistics_rx, (ViewGroup) null);
            inflate.setTag(new LogisticsInfoRxHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        LogisticsInfoRxHolder logisticsInfoRxHolder = (LogisticsInfoRxHolder) baseHolder;
        String str = fromToMessage.msgTask;
        if (str == null || "".equals(str)) {
            return;
        }
        OrderBaseBean orderBaseBean = (OrderBaseBean) new Gson().o(fromToMessage.msgTask, new a<OrderBaseBean>() { // from class: com.m7.imkfsdk.chat.chatrow.LogisticsInfoRxChatRow.1
        }.getType());
        if (orderBaseBean.getData() != null) {
            ArrayList<OrderInfoBean> shop_list = orderBaseBean.getData().getShop_list();
            if (shop_list == null) {
                shop_list = orderBaseBean.getData().getItem_list();
            }
            if (shop_list == null) {
                shop_list = new ArrayList<>();
            }
            logisticsInfoRxHolder.rv_logistics_rx.setVisibility(shop_list.size() > 0 ? 0 : 8);
            logisticsInfoRxHolder.tv_no_data.setVisibility(shop_list.size() > 0 ? 8 : 0);
            logisticsInfoRxHolder.ll_order_content.setVisibility(shop_list.size() > 0 ? 0 : 8);
            logisticsInfoRxHolder.tv_no_data.setText(orderBaseBean.getData().getEmpty_message());
            logisticsInfoRxHolder.kf_chat_rich_title.setText(shop_list.size() > 0 ? orderBaseBean.getData().getMessage() : orderBaseBean.getData().getEmpty_message());
            boolean equals = "0".equals(orderBaseBean.getResp_type());
            View.OnClickListener onClickListener = ((ChatActivity) context).getChatAdapter().getOnClickListener();
            logisticsInfoRxHolder.kf_chat_rich_content.setText(context.getString(R.string.ykfsdk_ykf_lookmore));
            logisticsInfoRxHolder.rv_logistics_rx.setLayoutManager(new LinearLayoutManager(context));
            logisticsInfoRxHolder.rv_logistics_rx.setNestedScrollingEnabled(false);
            if (equals) {
                logisticsInfoRxHolder.tv_logistics_progress_num.setVisibility(8);
                logisticsInfoRxHolder.tv_logistics_progress_name.setVisibility(8);
                logisticsInfoRxHolder.rl_progress_top.setVisibility(8);
                if ("1".equals(fromToMessage.showOrderInfo)) {
                    logisticsInfoRxHolder.rv_logistics_rx.setVisibility(8);
                    logisticsInfoRxHolder.kf_chat_rich_content.setText(context.getString(R.string.ykfsdk_ykf_reselect));
                    logisticsInfoRxHolder.rl_logistics.setVisibility(0);
                    logisticsInfoRxHolder.view_middle.setVisibility(0);
                    logisticsInfoRxHolder.view_top.setVisibility(0);
                } else if ("2".equals(fromToMessage.showOrderInfo)) {
                    logisticsInfoRxHolder.rv_logistics_rx.setVisibility(8);
                    logisticsInfoRxHolder.rl_logistics.setVisibility(8);
                    logisticsInfoRxHolder.view_middle.setVisibility(8);
                    logisticsInfoRxHolder.view_top.setVisibility(8);
                } else {
                    this.moreSize = orderBaseBean.getData().getShop_list_show();
                    logisticsInfoRxHolder.rv_logistics_rx.setVisibility(0);
                    logisticsInfoRxHolder.view_top.setVisibility(0);
                    logisticsInfoRxHolder.rv_logistics_rx.setAdapter(new LogisticsInfoRxListAdapter(shop_list, orderBaseBean.getCurrent(), false, fromToMessage._id, this.moreSize));
                    logisticsInfoRxHolder.view_middle.setVisibility(shop_list.size() < this.moreSize ? 8 : 0);
                    logisticsInfoRxHolder.rl_logistics.setVisibility(shop_list.size() < this.moreSize ? 8 : 0);
                }
                this.type = 11;
                this.holderTag = ViewHolderTag.createTag(orderBaseBean.getCurrent(), fromToMessage._id, this.type);
            } else {
                logisticsInfoRxHolder.tv_logistics_progress_num.setVisibility(0);
                String list_title = orderBaseBean.getData().getList_title();
                String list_num = orderBaseBean.getData().getList_num();
                if (shop_list.size() > 0) {
                    if (!TextUtils.isEmpty(list_title)) {
                        logisticsInfoRxHolder.tv_logistics_progress_name.setVisibility(0);
                        logisticsInfoRxHolder.tv_logistics_progress_name.setText(list_title);
                    } else {
                        logisticsInfoRxHolder.tv_logistics_progress_name.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(list_num)) {
                        logisticsInfoRxHolder.tv_logistics_progress_num.setVisibility(0);
                        logisticsInfoRxHolder.tv_logistics_progress_num.setText(list_num);
                    } else {
                        logisticsInfoRxHolder.tv_logistics_progress_num.setVisibility(8);
                    }
                    logisticsInfoRxHolder.kf_chat_rich_title.setText(orderBaseBean.getData().getMessage());
                    logisticsInfoRxHolder.rl_progress_top.setVisibility(0);
                    logisticsInfoRxHolder.rv_logistics_rx.setAdapter(new LogisticsProgressListAdapter(shop_list, false));
                    logisticsInfoRxHolder.rl_logistics.setVisibility(shop_list.size() < 3 ? 8 : 0);
                    this.type = 13;
                    this.holderTag = ViewHolderTag.createTag(fromToMessage, 13, i2);
                } else if (MoorNullUtil.checkNULL(orderBaseBean.getData().getList_num())) {
                    if (!TextUtils.isEmpty(list_title)) {
                        logisticsInfoRxHolder.tv_logistics_progress_name.setVisibility(0);
                        logisticsInfoRxHolder.tv_logistics_progress_name.setText(list_title);
                    } else {
                        logisticsInfoRxHolder.tv_logistics_progress_name.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(list_num)) {
                        logisticsInfoRxHolder.tv_logistics_progress_num.setVisibility(0);
                        logisticsInfoRxHolder.tv_logistics_progress_num.setText(list_num);
                    } else {
                        logisticsInfoRxHolder.tv_logistics_progress_num.setVisibility(8);
                    }
                    logisticsInfoRxHolder.kf_chat_rich_title.setText(orderBaseBean.getData().getMessage());
                    logisticsInfoRxHolder.ll_order_content.setVisibility(0);
                    logisticsInfoRxHolder.rl_progress_top.setVisibility(0);
                    logisticsInfoRxHolder.tv_no_data.setVisibility(0);
                } else {
                    logisticsInfoRxHolder.ll_order_content.setVisibility(8);
                    logisticsInfoRxHolder.tv_no_data.setVisibility(8);
                    logisticsInfoRxHolder.kf_chat_rich_title.setText(orderBaseBean.getData().getEmpty_message());
                    logisticsInfoRxHolder.rl_progress_top.setVisibility(8);
                    logisticsInfoRxHolder.rv_logistics_rx.setVisibility(8);
                }
            }
            logisticsInfoRxHolder.rl_logistics.setTag(this.holderTag);
            logisticsInfoRxHolder.rl_logistics.setOnClickListener(onClickListener);
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.LOGISTICS_INFORMATION_ROW_RECEIVED.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
