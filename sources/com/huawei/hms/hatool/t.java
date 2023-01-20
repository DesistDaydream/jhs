package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public class t {
    public List<q> a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f3606c;

    /* renamed from: d  reason: collision with root package name */
    public String f3607d;

    public t(List<q> list, String str, String str2, String str3) {
        this.a = list;
        this.b = str;
        this.f3606c = str2;
        this.f3607d = str3;
    }

    public void a() {
        if (!"_default_config_tag".equals(this.f3606c)) {
            a(this.a, this.f3606c, this.b);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (q qVar : this.a) {
            String c2 = qVar.c();
            if (TextUtils.isEmpty(c2) || "oper".equals(c2)) {
                arrayList4.add(qVar);
            } else if ("maint".equals(c2)) {
                arrayList.add(qVar);
            } else if ("preins".equals(c2)) {
                arrayList2.add(qVar);
            } else if ("diffprivacy".equals(c2)) {
                arrayList3.add(qVar);
            }
        }
        a(arrayList4, "oper", "_default_config_tag");
        a(arrayList, "maint", "_default_config_tag");
        a(arrayList2, "preins", "_default_config_tag");
        a(arrayList3, "diffprivacy", "_default_config_tag");
    }

    public final void a(List<q> list, String str, String str2) {
        if (list.isEmpty()) {
            return;
        }
        int size = (list.size() / 500) + 1;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i2 * 500;
            List<q> subList = list.subList(i3, Math.min(list.size(), i3 + 500));
            String replace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            long currentTimeMillis = System.currentTimeMillis();
            long b = c.b(str2, str) * 86400000;
            ArrayList arrayList = new ArrayList();
            for (q qVar : subList) {
                if (!q0.a(qVar.b(), currentTimeMillis, b)) {
                    arrayList.add(qVar);
                }
            }
            if (arrayList.size() > 0) {
                new u(str2, str, this.f3607d, arrayList, replace).a();
            } else {
                y.e("hmsSdk", "No data to report handler");
            }
        }
    }
}
