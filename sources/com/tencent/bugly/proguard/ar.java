package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ar extends j {

    /* renamed from: i  reason: collision with root package name */
    private static Map<String, String> f6729i;
    public long a = 0;
    public byte b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f6730c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f6731d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6732e = "";

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f6733f = null;

    /* renamed from: h  reason: collision with root package name */
    private String f6735h = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f6734g = true;

    static {
        HashMap hashMap = new HashMap();
        f6729i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(i iVar) {
        iVar.a(this.a, 0);
        iVar.a(this.b, 1);
        String str = this.f6730c;
        if (str != null) {
            iVar.a(str, 2);
        }
        String str2 = this.f6731d;
        if (str2 != null) {
            iVar.a(str2, 3);
        }
        String str3 = this.f6732e;
        if (str3 != null) {
            iVar.a(str3, 4);
        }
        Map<String, String> map = this.f6733f;
        if (map != null) {
            iVar.a((Map) map, 5);
        }
        String str4 = this.f6735h;
        if (str4 != null) {
            iVar.a(str4, 6);
        }
        iVar.a(this.f6734g, 7);
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(h hVar) {
        this.a = hVar.a(this.a, 0, true);
        this.b = hVar.a(this.b, 1, true);
        this.f6730c = hVar.b(2, false);
        this.f6731d = hVar.b(3, false);
        this.f6732e = hVar.b(4, false);
        this.f6733f = (Map) hVar.a((h) f6729i, 5, false);
        this.f6735h = hVar.b(6, false);
        this.f6734g = hVar.a(7, false);
    }
}
