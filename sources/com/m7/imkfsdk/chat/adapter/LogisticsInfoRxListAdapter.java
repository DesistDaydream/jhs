package com.m7.imkfsdk.chat.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.OrderInfoHolder;
import com.m7.imkfsdk.chat.holder.OrderShopHolder;
import com.m7.imkfsdk.chat.holder.ViewHolderTag;
import com.m7.imkfsdk.chat.model.OrderInfoBean;
import com.m7.imkfsdk.utils.GlideUtil;
import com.moor.imkf.lib.utils.MoorNullUtil;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.util.List;

/* loaded from: classes2.dex */
public class LogisticsInfoRxListAdapter extends RecyclerView.Adapter {
    private String _id;
    private Context context;
    private String current;
    private boolean isFromMoreLogistics;
    public List<OrderInfoBean> mData;
    private int showCount;
    private static final int SHOP_ITEM_LAYOUT = R.layout.ykfsdk_item_shop_group;
    private static final int ORDER_ITEM_LAYOUT = R.layout.ykfsdk_item_shop_child;

    public LogisticsInfoRxListAdapter(List<OrderInfoBean> list, String str, boolean z, String str2, int i2) {
        int i3 = 0;
        this.showCount = 0;
        this.mData = list;
        this.current = str;
        this._id = str2;
        this.isFromMoreLogistics = z;
        this.showCount = i2;
        if (i2 < list.size()) {
            int i4 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    i3 = i4;
                    break;
                }
                if (list.get(i3).getItem_type().equals("0")) {
                    if (i4 == this.showCount) {
                        break;
                    }
                    i4++;
                }
                i3++;
            }
            this.showCount = i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<OrderInfoBean> list = this.mData;
        if (list != null) {
            if (this.isFromMoreLogistics) {
                return list.size();
            }
            int size = list.size();
            int i2 = this.showCount;
            if (size > i2) {
                if (this.mData.get(i2 - 1).getItem_type().equals("1")) {
                    return this.showCount - 1;
                }
                return this.showCount;
            }
            if (this.mData.size() == this.showCount) {
                List<OrderInfoBean> list2 = this.mData;
                if (list2.get(list2.size() - 1).getItem_type().equals("1")) {
                    return this.showCount - 1;
                }
            }
            return this.mData.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return this.mData.get(i2).getItem_type().equals("1") ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        OrderInfoBean orderInfoBean = this.mData.get(i2);
        View.OnClickListener onClickListener = ((ChatActivity) this.context).getChatAdapter().getOnClickListener();
        if (itemViewType == 1) {
            OrderShopHolder orderShopHolder = (OrderShopHolder) viewHolder;
            orderShopHolder.tv_shop_group_name.setText(orderInfoBean.getTitle());
            orderShopHolder.tv_shop_group_state.setText(orderInfoBean.getStatus());
            GlideUtil.loadImage(this.context, orderInfoBean.getImg(), 2.0f, orderShopHolder.iv_shop_group_img);
            if (!"self".equals(orderInfoBean.getTarget()) && "url".equals(orderInfoBean.getTarget())) {
                orderShopHolder.rl_shop_main.setTag(ViewHolderTag.createTag(orderInfoBean.getTarget_url(), 12));
                orderShopHolder.rl_shop_main.setOnClickListener(onClickListener);
                return;
            }
            return;
        }
        OrderInfoHolder orderInfoHolder = (OrderInfoHolder) viewHolder;
        if (MoorNullUtil.checkNULL(orderInfoBean.getTitle())) {
            orderInfoHolder.tv_child_title.setText(orderInfoBean.getTitle());
        }
        if (MoorNullUtil.checkNULL(orderInfoBean.getSub_title())) {
            orderInfoHolder.tv_child_.setText(orderInfoBean.getSub_title());
        }
        if (MoorNullUtil.checkNULL(orderInfoBean.getAttr_one().getColor())) {
            String color = orderInfoBean.getAttr_one().getColor();
            if (color.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                try {
                    orderInfoHolder.tv_child_num.setTextColor(Color.parseColor(color));
                } catch (Exception unused) {
                }
            }
        }
        if (MoorNullUtil.checkNULL(orderInfoBean.getAttr_two().getColor())) {
            String color2 = orderInfoBean.getAttr_two().getColor();
            if (color2.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                try {
                    orderInfoHolder.tv_child_state.setTextColor(Color.parseColor(color2));
                } catch (Exception unused2) {
                }
            }
        }
        if (MoorNullUtil.checkNULL(orderInfoBean.getAttr_one().getContent())) {
            orderInfoHolder.tv_child_num.setText(orderInfoBean.getAttr_one().getContent());
        }
        if (MoorNullUtil.checkNULL(orderInfoBean.getAttr_two().getContent())) {
            orderInfoHolder.tv_child_state.setText(orderInfoBean.getAttr_two().getContent());
        }
        if (MoorNullUtil.checkNULL(orderInfoBean.getPrice())) {
            orderInfoHolder.tv_child_price.setText(orderInfoBean.getPrice());
        }
        if (MoorNullUtil.checkNULL(orderInfoBean.getOther_title_three())) {
            orderInfoHolder.tv_child_second.setText(orderInfoBean.getOther_title_three());
        }
        if (MoorNullUtil.checkNULL(orderInfoBean.getOther_title_two())) {
            orderInfoHolder.tv_child_second.setText(orderInfoBean.getOther_title_two());
        }
        if (MoorNullUtil.checkNULL(orderInfoBean.getOther_title_one())) {
            orderInfoHolder.tv_child_second.setText(orderInfoBean.getOther_title_one());
        }
        GlideUtil.loadImage(this.context, orderInfoBean.getImg(), 2.0f, orderInfoHolder.iv_child_img);
        if (orderInfoBean.getParams() == null || !MoorNullUtil.checkNULL(orderInfoBean.getParams().getOrderNo())) {
            return;
        }
        if ("url".equals(orderInfoBean.getTarget())) {
            orderInfoHolder.rl_child_main.setTag(ViewHolderTag.createTag(orderInfoBean.getTarget_url(), 12));
            orderInfoHolder.rl_child_main.setOnClickListener(onClickListener);
        } else if ("next".equals(orderInfoBean.getTarget())) {
            orderInfoHolder.rl_child_main.setTag(ViewHolderTag.createTag(this.current, this._id, orderInfoBean, 10));
            orderInfoHolder.rl_child_main.setOnClickListener(onClickListener);
        } else {
            "self".equals(orderInfoBean.getTarget());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        Context context = viewGroup.getContext();
        this.context = context;
        if (i2 == 1) {
            return new OrderShopHolder(LayoutInflater.from(context).inflate(SHOP_ITEM_LAYOUT, viewGroup, false));
        }
        return new OrderInfoHolder(LayoutInflater.from(context).inflate(ORDER_ITEM_LAYOUT, viewGroup, false));
    }
}
