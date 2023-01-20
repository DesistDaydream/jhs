package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class UpdateBean implements Serializable {
    public boolean a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f3689c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3690d = true;

    public static <T> T a(T t) {
        return t;
    }

    public String getClientAppName() {
        return (String) a(this.b);
    }

    public boolean getResolutionInstallHMS() {
        return this.a;
    }

    public ArrayList getTypeList() {
        return (ArrayList) a(this.f3689c);
    }

    public boolean isNeedConfirm() {
        return ((Boolean) a(Boolean.valueOf(this.f3690d))).booleanValue();
    }

    public void setClientAppId(String str) {
    }

    public void setClientAppName(String str) {
        this.b = str;
    }

    public void setClientPackageName(String str) {
    }

    public void setClientVersionCode(int i2) {
    }

    public void setHmsOrApkUpgrade(boolean z) {
    }

    public void setNeedConfirm(boolean z) {
        this.f3690d = z;
    }

    public void setResolutionInstallHMS(boolean z) {
        this.a = z;
    }

    public void setTypeList(ArrayList arrayList) {
        this.f3689c = arrayList;
    }
}
