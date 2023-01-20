package com.tencent.qcloud.tuikit.tuichat.bean.message;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.imsdk.v2.V2TIMMessage;
import e.j.e.r.c;

/* loaded from: classes3.dex */
public class OrderMessageBean extends TUIMessageBean {
    private String button;
    private String content;
    private String image;
    private String order_id;
    @c("total_price")
    private Double price;
    @c("seller_user_id")
    private String seller_id;
    private String title;
    @c("shipping_price")
    private Double yunfei;

    public String getButton() {
        return this.button;
    }

    public String getContent() {
        return this.content;
    }

    public String getImage() {
        return this.image;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getSeller_id() {
        return this.seller_id;
    }

    public String getTitle() {
        return this.title;
    }

    public Double getYunfei() {
        return this.yunfei;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public String onGetDisplayString() {
        return "[订单通知]";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        try {
            OrderMessageBean orderMessageBean = (OrderMessageBean) new Gson().n(new String(v2TIMMessage.getCustomElem().getData()), OrderMessageBean.class);
            if (orderMessageBean != null) {
                this.order_id = orderMessageBean.getOrder_id();
                this.seller_id = orderMessageBean.getSeller_id();
                this.price = orderMessageBean.getPrice();
                this.yunfei = orderMessageBean.getYunfei();
                this.title = orderMessageBean.getTitle();
                this.content = orderMessageBean.getContent();
                this.button = orderMessageBean.getButton();
                this.image = orderMessageBean.getImage();
            }
        } catch (JsonSyntaxException unused) {
        }
    }
}
