package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
public class j1 {
    public String a;
    public m b;

    public j1(String str) {
        this.a = str;
        this.b = new m(str);
        i.c().a(this.a, this.b);
    }

    public void a(int i2) {
        y.d("hmsSdk", "onReport. TAG: " + this.a + ", TYPE: " + i2);
        i1.a().a(this.a, i2);
    }

    public void a(int i2, String str, LinkedHashMap<String, String> linkedHashMap) {
        y.d("hmsSdk", "onEvent. TAG: " + this.a + ", TYPE: " + i2 + ", eventId : " + str);
        if (s0.a(str) || !c(i2)) {
            y.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.a + ", TYPE: " + i2);
            return;
        }
        if (!s0.a(linkedHashMap)) {
            y.e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.a + ", TYPE: " + i2);
            linkedHashMap = null;
        }
        i1.a().a(this.a, i2, str, linkedHashMap);
    }

    public void a(Context context, String str, String str2) {
        y.d("hmsSdk", "onEvent(context). TAG: " + this.a + ", eventId : " + str);
        if (context == null) {
            y.e("hmsSdk", "context is null in onevent ");
        } else if (s0.a(str) || !c(0)) {
            y.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.a);
        } else {
            if (!s0.a("value", str2, 65536)) {
                y.e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.a);
                str2 = "";
            }
            i1.a().a(this.a, context, str, str2);
        }
    }

    public void a(k kVar) {
        y.c("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.a);
        if (kVar != null) {
            this.b.a(kVar);
            return;
        }
        y.e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
        this.b.a((k) null);
    }

    public final k b(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return this.b.a();
                }
                return this.b.d();
            }
            return this.b.b();
        }
        return this.b.c();
    }

    public void b(k kVar) {
        y.c("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.a);
        if (kVar != null) {
            this.b.b(kVar);
            return;
        }
        this.b.b(null);
        y.e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
    }

    public final boolean c(int i2) {
        String str;
        if (i2 != 2) {
            k b = b(i2);
            if (b != null && !TextUtils.isEmpty(b.h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i2;
        } else if ("_default_config_tag".equals(this.a)) {
            return true;
        } else {
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        y.e("hmsSdk", str);
        return false;
    }
}
