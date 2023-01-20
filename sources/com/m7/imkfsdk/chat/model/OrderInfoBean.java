package com.m7.imkfsdk.chat.model;

import com.moor.imkf.model.entity.NewCardInfoAttrs;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class OrderInfoBean implements Serializable {
    private NewCardInfoAttrs attr_one;
    private NewCardInfoAttrs attr_two;
    private String desc;
    private String img;
    private String is_current;
    private String item_type;
    private String other_title_one;
    private String other_title_three;
    private String other_title_two;
    private OrderInfoParams params;
    private String price;
    private String status;
    private String sub_title;
    private String target;
    private String target_url;
    private String title;

    public OrderInfoBean(String str) {
        this.item_type = str;
    }

    public NewCardInfoAttrs getAttr_one() {
        return this.attr_one;
    }

    public NewCardInfoAttrs getAttr_two() {
        return this.attr_two;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getImg() {
        return this.img;
    }

    public String getIs_current() {
        return this.is_current;
    }

    public String getItem_type() {
        return this.item_type;
    }

    public String getOther_title_one() {
        return this.other_title_one;
    }

    public String getOther_title_three() {
        return this.other_title_three;
    }

    public String getOther_title_two() {
        return this.other_title_two;
    }

    public OrderInfoParams getParams() {
        return this.params;
    }

    public String getPrice() {
        return this.price;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSub_title() {
        return this.sub_title;
    }

    public String getTarget() {
        return this.target;
    }

    public String getTarget_url() {
        return this.target_url;
    }

    public String getTitle() {
        return this.title;
    }

    public OrderInfoBean setAttr_one(NewCardInfoAttrs newCardInfoAttrs) {
        this.attr_one = newCardInfoAttrs;
        return this;
    }

    public OrderInfoBean setAttr_two(NewCardInfoAttrs newCardInfoAttrs) {
        this.attr_two = newCardInfoAttrs;
        return this;
    }

    public OrderInfoBean setDesc(String str) {
        this.desc = str;
        return this;
    }

    public OrderInfoBean setImg(String str) {
        this.img = str;
        return this;
    }

    public OrderInfoBean setIs_current(String str) {
        this.is_current = str;
        return this;
    }

    public OrderInfoBean setItem_type(String str) {
        this.item_type = str;
        return this;
    }

    public OrderInfoBean setOther_title_one(String str) {
        this.other_title_one = str;
        return this;
    }

    public OrderInfoBean setOther_title_three(String str) {
        this.other_title_three = str;
        return this;
    }

    public OrderInfoBean setOther_title_two(String str) {
        this.other_title_two = str;
        return this;
    }

    public OrderInfoBean setParams(OrderInfoParams orderInfoParams) {
        this.params = orderInfoParams;
        return this;
    }

    public OrderInfoBean setPrice(String str) {
        this.price = str;
        return this;
    }

    public OrderInfoBean setStatus(String str) {
        this.status = str;
        return this;
    }

    public OrderInfoBean setSub_title(String str) {
        this.sub_title = str;
        return this;
    }

    public OrderInfoBean setTarget(String str) {
        this.target = str;
        return this;
    }

    public OrderInfoBean setTarget_url(String str) {
        this.target_url = str;
        return this;
    }

    public OrderInfoBean setTitle(String str) {
        this.title = str;
        return this;
    }
}
