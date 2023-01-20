package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.content.Intent;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.OrderMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.MaxWidthFrameLayout;
import java.text.DecimalFormat;
import java.util.Objects;

/* loaded from: classes3.dex */
public class OrderViewHolder extends MessageBaseHolder implements View.OnClickListener {
    private OrderMessageBean bean;
    private TextView check;
    private ImageView iv;
    private TextView name;
    private TextView price;
    private TextView tips;
    private TextView yunfei;

    public OrderViewHolder(View view) {
        super(view);
        this.iv = (ImageView) view.findViewById(R.id.image);
        this.name = (TextView) view.findViewById(R.id.name);
        this.tips = (TextView) view.findViewById(R.id.tips);
        this.price = (TextView) view.findViewById(R.id.price);
        this.yunfei = (TextView) view.findViewById(R.id.yunfei);
        this.check = (TextView) view.findViewById(R.id.check);
        view.findViewById(R.id.audio_unread).setVisibility(8);
    }

    private CharSequence getPrice(Double d2) {
        String format = new DecimalFormat("#.##").format(d2);
        String str = format + "¥";
        SpannableString spannableString = new SpannableString(str);
        int indexOf = str.indexOf(format);
        spannableString.setSpan(new AbsoluteSizeSpan(8, true), format.length() + indexOf, spannableString.length(), 18);
        spannableString.setSpan(new SuperscriptSpan(), indexOf + format.length(), spannableString.length(), 17);
        return spannableString;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.chat_order_item;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public void layoutViews(TUIMessageBean tUIMessageBean, int i2) {
        super.layoutViews(tUIMessageBean, i2);
        FrameLayout frameLayout = this.msgContentFrame;
        ((MaxWidthFrameLayout) frameLayout).maxWidthPx = 0;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.width = ScreenUtil.getScreenWidth(this.itemView.getContext()) - ScreenUtil.dip2px(38.0f);
        this.msgContentFrame.setLayoutParams(layoutParams);
        OrderMessageBean orderMessageBean = (OrderMessageBean) tUIMessageBean;
        this.bean = orderMessageBean;
        GlideEngine.loadImage(this.iv, orderMessageBean.getImage());
        this.name.setText(this.bean.getTitle());
        this.tips.setText(this.bean.getContent());
        this.price.setText(getPrice(this.bean.getPrice()));
        TextView textView = this.yunfei;
        textView.setText("含运费" + this.bean.getYunfei() + "元");
        this.check.setText(this.bean.getButton());
        this.msgContentFrame.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent;
        try {
            if (Objects.equals(this.bean.getSeller_id(), TUILogin.getUserId())) {
                intent = new Intent(view.getContext(), Class.forName("com.jihuanshe.ui.page.order.SellerOrderDetailActivity"));
            } else {
                intent = new Intent(view.getContext(), Class.forName("com.jihuanshe.ui.page.order.OrderDetailActivity"));
            }
            intent.addFlags(268435456);
            intent.putExtra("id", Integer.valueOf(this.bean.getOrder_id()));
            view.getContext().startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
