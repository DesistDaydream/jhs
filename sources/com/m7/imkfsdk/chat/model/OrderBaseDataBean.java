package com.m7.imkfsdk.chat.model;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public class OrderBaseDataBean {
    private String empty_message;
    private ArrayList<OrderInfoBean> item_list;
    private String list_num;
    private String list_title;
    private String message;
    private ArrayList<OrderInfoBean> shop_list;
    private int shop_list_show;

    public String getEmpty_message() {
        return this.empty_message;
    }

    public ArrayList<OrderInfoBean> getItem_list() {
        return this.item_list;
    }

    public String getList_num() {
        return this.list_num;
    }

    public String getList_title() {
        return this.list_title;
    }

    public String getMessage() {
        return this.message;
    }

    public ArrayList<OrderInfoBean> getShop_list() {
        return this.shop_list;
    }

    public int getShop_list_show() {
        return this.shop_list_show;
    }

    public OrderBaseDataBean setEmpty_message(String str) {
        this.empty_message = str;
        return this;
    }

    public OrderBaseDataBean setItem_list(ArrayList<OrderInfoBean> arrayList) {
        this.item_list = arrayList;
        return this;
    }

    public OrderBaseDataBean setList_num(String str) {
        this.list_num = str;
        return this;
    }

    public OrderBaseDataBean setList_title(String str) {
        this.list_title = str;
        return this;
    }

    public OrderBaseDataBean setMessage(String str) {
        this.message = str;
        return this;
    }

    public OrderBaseDataBean setShop_list(ArrayList<OrderInfoBean> arrayList) {
        this.shop_list = arrayList;
        return this;
    }

    public void setShop_list_show(int i2) {
        this.shop_list_show = i2;
    }
}
