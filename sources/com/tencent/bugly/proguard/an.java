package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class an extends j {
    private static byte[] y;
    private static Map<String, String> z;
    public int a = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f6699c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f6700d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6701e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f6702f = "";

    /* renamed from: g  reason: collision with root package name */
    public int f6703g = 0;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f6704h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f6705i = "";

    /* renamed from: j  reason: collision with root package name */
    public String f6706j = "";

    /* renamed from: k  reason: collision with root package name */
    public Map<String, String> f6707k = null;

    /* renamed from: l  reason: collision with root package name */
    public String f6708l = "";

    /* renamed from: m  reason: collision with root package name */
    public long f6709m = 0;
    public String n = "";
    public String o = "";
    public String p = "";
    public long q = 0;
    private String u = "";
    public String r = "";
    private String v = "";
    private String w = "";
    public String s = "";
    public String t = "";
    private String x = "";

    static {
        y = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        z = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(i iVar) {
        iVar.a(this.a, 0);
        iVar.a(this.b, 1);
        iVar.a(this.f6699c, 2);
        iVar.a(this.f6700d, 3);
        String str = this.f6701e;
        if (str != null) {
            iVar.a(str, 4);
        }
        iVar.a(this.f6702f, 5);
        iVar.a(this.f6703g, 6);
        iVar.a(this.f6704h, 7);
        String str2 = this.f6705i;
        if (str2 != null) {
            iVar.a(str2, 8);
        }
        String str3 = this.f6706j;
        if (str3 != null) {
            iVar.a(str3, 9);
        }
        Map<String, String> map = this.f6707k;
        if (map != null) {
            iVar.a((Map) map, 10);
        }
        String str4 = this.f6708l;
        if (str4 != null) {
            iVar.a(str4, 11);
        }
        iVar.a(this.f6709m, 12);
        String str5 = this.n;
        if (str5 != null) {
            iVar.a(str5, 13);
        }
        String str6 = this.o;
        if (str6 != null) {
            iVar.a(str6, 14);
        }
        String str7 = this.p;
        if (str7 != null) {
            iVar.a(str7, 15);
        }
        iVar.a(this.q, 16);
        String str8 = this.u;
        if (str8 != null) {
            iVar.a(str8, 17);
        }
        String str9 = this.r;
        if (str9 != null) {
            iVar.a(str9, 18);
        }
        String str10 = this.v;
        if (str10 != null) {
            iVar.a(str10, 19);
        }
        String str11 = this.w;
        if (str11 != null) {
            iVar.a(str11, 20);
        }
        String str12 = this.s;
        if (str12 != null) {
            iVar.a(str12, 21);
        }
        String str13 = this.t;
        if (str13 != null) {
            iVar.a(str13, 22);
        }
        String str14 = this.x;
        if (str14 != null) {
            iVar.a(str14, 23);
        }
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(h hVar) {
        this.a = hVar.a(this.a, 0, true);
        this.b = hVar.b(1, true);
        this.f6699c = hVar.b(2, true);
        this.f6700d = hVar.b(3, true);
        this.f6701e = hVar.b(4, false);
        this.f6702f = hVar.b(5, true);
        this.f6703g = hVar.a(this.f6703g, 6, true);
        this.f6704h = hVar.c(7, true);
        this.f6705i = hVar.b(8, false);
        this.f6706j = hVar.b(9, false);
        this.f6707k = (Map) hVar.a((h) z, 10, false);
        this.f6708l = hVar.b(11, false);
        this.f6709m = hVar.a(this.f6709m, 12, false);
        this.n = hVar.b(13, false);
        this.o = hVar.b(14, false);
        this.p = hVar.b(15, false);
        this.q = hVar.a(this.q, 16, false);
        this.u = hVar.b(17, false);
        this.r = hVar.b(18, false);
        this.v = hVar.b(19, false);
        this.w = hVar.b(20, false);
        this.s = hVar.b(21, false);
        this.t = hVar.b(22, false);
        this.x = hVar.b(23, false);
    }
}
