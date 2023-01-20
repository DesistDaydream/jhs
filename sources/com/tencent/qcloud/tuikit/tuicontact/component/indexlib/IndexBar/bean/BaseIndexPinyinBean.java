package com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.bean;

/* loaded from: classes3.dex */
public abstract class BaseIndexPinyinBean extends BaseIndexBean {
    private String baseIndexPinyin;

    public String getBaseIndexPinyin() {
        return this.baseIndexPinyin;
    }

    public abstract String getTarget();

    public boolean isNeedToPinyin() {
        return true;
    }

    public BaseIndexPinyinBean setBaseIndexPinyin(String str) {
        this.baseIndexPinyin = str;
        return this;
    }
}
