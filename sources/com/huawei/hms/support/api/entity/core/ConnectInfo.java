package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

/* loaded from: classes2.dex */
public class ConnectInfo implements IMessageEntity {
    @Packed
    private List<String> a;
    @Packed
    private List<Scope> b;
    @Packed

    /* renamed from: c  reason: collision with root package name */
    private String f3681c;
    @Packed

    /* renamed from: d  reason: collision with root package name */
    private String f3682d;

    public ConnectInfo() {
    }

    public List<String> getApiNameList() {
        return this.a;
    }

    public String getFingerprint() {
        return this.f3681c;
    }

    public List<Scope> getScopeList() {
        return this.b;
    }

    public String getSubAppID() {
        return this.f3682d;
    }

    public void setApiNameList(List<String> list) {
        this.a = list;
    }

    public void setFingerprint(String str) {
        this.f3681c = str;
    }

    public void setScopeList(List<Scope> list) {
        this.b = list;
    }

    public void setSubAppID(String str) {
        this.f3682d = str;
    }

    public ConnectInfo(List<String> list, List<Scope> list2, String str, String str2) {
        this.a = list;
        this.b = list2;
        this.f3681c = str;
        this.f3682d = str2;
    }
}
