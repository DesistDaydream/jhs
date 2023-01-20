package com.m7.imkfsdk.chat.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.holder.LogisticsProgressHolder;
import com.m7.imkfsdk.chat.model.OrderInfoBean;
import com.m7.imkfsdk.utils.StringBuilderUtils;
import java.util.List;

/* loaded from: classes2.dex */
public class LogisticsProgressListAdapter extends RecyclerView.Adapter<LogisticsProgressHolder> {
    private static final int TYPE_BOTTOM = 2;
    private static final int TYPE_NORMAL = 1;
    private static final int TYPE_TOP = 0;
    private Context context;
    public List<OrderInfoBean> data;
    private boolean isFormMoreProgress;

    public LogisticsProgressListAdapter(List<OrderInfoBean> list, boolean z) {
        this.data = list;
        this.isFormMoreProgress = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.isFormMoreProgress) {
            return this.data.size();
        }
        if (this.data.size() > 3) {
            return 3;
        }
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (i2 == 0) {
            return 0;
        }
        return i2 == this.data.size() - 1 ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull LogisticsProgressHolder logisticsProgressHolder, int i2) {
        List<OrderInfoBean> list = this.data;
        if (list == null || list.size() <= 0) {
            return;
        }
        if (getItemViewType(i2) == 0) {
            logisticsProgressHolder.view_topline.setVisibility(4);
            logisticsProgressHolder.view_bottomline.setVisibility(0);
            logisticsProgressHolder.view_dot.setBackgroundResource(this.data.size() == 1 ? R.drawable.ykfsdk_timelline_dot_bottom : R.drawable.ykfsdk_timelline_dot_first);
        } else if (getItemViewType(i2) == 1) {
            logisticsProgressHolder.view_topline.setVisibility(0);
            logisticsProgressHolder.view_bottomline.setVisibility(0);
            logisticsProgressHolder.view_dot.setBackgroundResource(R.drawable.ykfsdk_timelline_dot_normal);
        } else if (this.isFormMoreProgress) {
            logisticsProgressHolder.view_bottomline.setVisibility(4);
            logisticsProgressHolder.view_dot.setBackgroundResource(R.drawable.ykfsdk_timelline_dot_bottom);
        } else if (this.data.size() > 3) {
            logisticsProgressHolder.view_bottomline.setVisibility(0);
            logisticsProgressHolder.view_dot.setBackgroundResource(R.drawable.ykfsdk_timelline_dot_normal);
        } else {
            logisticsProgressHolder.view_bottomline.setVisibility(4);
        }
        OrderInfoBean orderInfoBean = this.data.get(i2);
        logisticsProgressHolder.tvAcceptTime.setText(orderInfoBean.getDesc());
        logisticsProgressHolder.tvAcceptStation.setText(StringBuilderUtils.setPhoneNum(this.context, new SpannableStringBuilder(orderInfoBean.getTitle())));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public LogisticsProgressHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        Context context = viewGroup.getContext();
        this.context = context;
        return new LogisticsProgressHolder(LayoutInflater.from(context).inflate(R.layout.ykfsdk_item_logistics_progress, viewGroup, false));
    }
}
