package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class c {
    private String a;
    private final Map<String, d> b = new ConcurrentHashMap(16);

    /* renamed from: c  reason: collision with root package name */
    private List<b> f3524c = new ArrayList(16);

    public d a(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
            return null;
        }
        return this.b.get(str);
    }

    public List<b> a() {
        return this.f3524c;
    }

    public void a(String str, d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        this.b.put(str, dVar);
    }

    public void a(List<b> list) {
        this.f3524c = list;
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
    }

    public void c(String str) {
        this.a = str;
    }
}