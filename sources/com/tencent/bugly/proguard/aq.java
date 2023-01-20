package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class aq extends j implements Cloneable {
    private static Map<String, String> n;
    private static /* synthetic */ boolean o = true;

    /* renamed from: m  reason: collision with root package name */
    private static ap f6718m = new ap();
    public boolean a = true;
    public boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6719c = true;

    /* renamed from: d  reason: collision with root package name */
    public String f6720d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6721e = "";

    /* renamed from: f  reason: collision with root package name */
    public ap f6722f = null;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f6723g = null;

    /* renamed from: h  reason: collision with root package name */
    public long f6724h = 0;

    /* renamed from: j  reason: collision with root package name */
    private String f6726j = "";

    /* renamed from: k  reason: collision with root package name */
    private String f6727k = "";

    /* renamed from: l  reason: collision with root package name */
    private int f6728l = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f6725i = 0;

    static {
        HashMap hashMap = new HashMap();
        n = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(i iVar) {
        iVar.a(this.a, 0);
        iVar.a(this.b, 1);
        iVar.a(this.f6719c, 2);
        String str = this.f6720d;
        if (str != null) {
            iVar.a(str, 3);
        }
        String str2 = this.f6721e;
        if (str2 != null) {
            iVar.a(str2, 4);
        }
        ap apVar = this.f6722f;
        if (apVar != null) {
            iVar.a((j) apVar, 5);
        }
        Map<String, String> map = this.f6723g;
        if (map != null) {
            iVar.a((Map) map, 6);
        }
        iVar.a(this.f6724h, 7);
        String str3 = this.f6726j;
        if (str3 != null) {
            iVar.a(str3, 8);
        }
        String str4 = this.f6727k;
        if (str4 != null) {
            iVar.a(str4, 9);
        }
        iVar.a(this.f6728l, 10);
        iVar.a(this.f6725i, 11);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        aq aqVar = (aq) obj;
        return k.a(this.a, aqVar.a) && k.a(this.b, aqVar.b) && k.a(this.f6719c, aqVar.f6719c) && k.a(this.f6720d, aqVar.f6720d) && k.a(this.f6721e, aqVar.f6721e) && k.a(this.f6722f, aqVar.f6722f) && k.a(this.f6723g, aqVar.f6723g) && k.a(this.f6724h, aqVar.f6724h) && k.a(this.f6726j, aqVar.f6726j) && k.a(this.f6727k, aqVar.f6727k) && k.a(this.f6728l, aqVar.f6728l) && k.a(this.f6725i, aqVar.f6725i);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(h hVar) {
        this.a = hVar.a(0, true);
        this.b = hVar.a(1, true);
        this.f6719c = hVar.a(2, true);
        this.f6720d = hVar.b(3, false);
        this.f6721e = hVar.b(4, false);
        this.f6722f = (ap) hVar.a((j) f6718m, 5, false);
        this.f6723g = (Map) hVar.a((h) n, 6, false);
        this.f6724h = hVar.a(this.f6724h, 7, false);
        this.f6726j = hVar.b(8, false);
        this.f6727k = hVar.b(9, false);
        this.f6728l = hVar.a(this.f6728l, 10, false);
        this.f6725i = hVar.a(this.f6725i, 11, false);
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(StringBuilder sb, int i2) {
        z zVar = new z(sb, i2);
        zVar.a(this.a, "enable");
        zVar.a(this.b, "enableUserInfo");
        zVar.a(this.f6719c, "enableQuery");
        zVar.a(this.f6720d, "url");
        zVar.a(this.f6721e, "expUrl");
        zVar.a((j) this.f6722f, "security");
        zVar.a((Map) this.f6723g, "valueMap");
        zVar.a(this.f6724h, "strategylastUpdateTime");
        zVar.a(this.f6726j, "httpsUrl");
        zVar.a(this.f6727k, "httpsExpUrl");
        zVar.a(this.f6728l, "eventRecordCount");
        zVar.a(this.f6725i, "eventTimeInterval");
    }
}
