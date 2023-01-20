package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class as extends j implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    private static ArrayList<ar> f6736f;

    /* renamed from: g  reason: collision with root package name */
    private static Map<String, String> f6737g;
    public byte a = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f6738c = "";

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<ar> f6739d = null;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f6740e = null;

    @Override // com.tencent.bugly.proguard.j
    public final void a(i iVar) {
        iVar.a(this.a, 0);
        String str = this.b;
        if (str != null) {
            iVar.a(str, 1);
        }
        String str2 = this.f6738c;
        if (str2 != null) {
            iVar.a(str2, 2);
        }
        ArrayList<ar> arrayList = this.f6739d;
        if (arrayList != null) {
            iVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f6740e;
        if (map != null) {
            iVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(h hVar) {
        this.a = hVar.a(this.a, 0, true);
        this.b = hVar.b(1, false);
        this.f6738c = hVar.b(2, false);
        if (f6736f == null) {
            f6736f = new ArrayList<>();
            f6736f.add(new ar());
        }
        this.f6739d = (ArrayList) hVar.a((h) f6736f, 3, false);
        if (f6737g == null) {
            HashMap hashMap = new HashMap();
            f6737g = hashMap;
            hashMap.put("", "");
        }
        this.f6740e = (Map) hVar.a((h) f6737g, 4, false);
    }
}
