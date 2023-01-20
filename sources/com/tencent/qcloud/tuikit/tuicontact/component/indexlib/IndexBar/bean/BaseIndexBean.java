package com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.bean;

import com.tencent.qcloud.tuikit.tuicontact.component.indexlib.suspension.ISuspensionInterface;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class BaseIndexBean implements ISuspensionInterface, Serializable {
    private String baseIndexTag;

    public String getBaseIndexTag() {
        return this.baseIndexTag;
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.component.indexlib.suspension.ISuspensionInterface
    public String getSuspensionTag() {
        return this.baseIndexTag;
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.component.indexlib.suspension.ISuspensionInterface
    public boolean isShowSuspension() {
        return true;
    }

    public BaseIndexBean setBaseIndexTag(String str) {
        this.baseIndexTag = str;
        return this;
    }
}
