package com.moor.imkf.model.entity;

import java.util.List;

/* loaded from: classes2.dex */
public class ShopListBean {
    private List<ShopCardListBean> card_list;
    private String img;
    private String status;
    private String target;
    private String title;

    public List<ShopCardListBean> getCard_list() {
        return this.card_list;
    }

    public String getImg() {
        return this.img;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTarget() {
        return this.target;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCard_list(List<ShopCardListBean> list) {
        this.card_list = list;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTarget(String str) {
        this.target = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
