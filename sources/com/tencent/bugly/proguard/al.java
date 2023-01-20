package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class al extends j {
    private static ArrayList<ak> A;
    private static Map<String, String> B;
    private static Map<String, String> C;
    private static Map<String, String> v;
    private static aj w;
    private static ai x;
    private static ArrayList<ai> y;
    private static ArrayList<ai> z;
    public String a = "";
    public long b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f6688c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f6689d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6690e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f6691f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f6692g = "";

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f6693h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f6694i = "";

    /* renamed from: j  reason: collision with root package name */
    public aj f6695j = null;

    /* renamed from: k  reason: collision with root package name */
    public int f6696k = 0;

    /* renamed from: l  reason: collision with root package name */
    public String f6697l = "";

    /* renamed from: m  reason: collision with root package name */
    public String f6698m = "";
    public ai n = null;
    public ArrayList<ai> o = null;
    public ArrayList<ai> p = null;
    public ArrayList<ak> q = null;
    public Map<String, String> r = null;
    public Map<String, String> s = null;
    private String t = "";
    private boolean u = true;

    static {
        HashMap hashMap = new HashMap();
        v = hashMap;
        hashMap.put("", "");
        w = new aj();
        x = new ai();
        y = new ArrayList<>();
        y.add(new ai());
        z = new ArrayList<>();
        z.add(new ai());
        A = new ArrayList<>();
        A.add(new ak());
        HashMap hashMap2 = new HashMap();
        B = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        C = hashMap3;
        hashMap3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(i iVar) {
        iVar.a(this.a, 0);
        iVar.a(this.b, 1);
        iVar.a(this.f6688c, 2);
        String str = this.f6689d;
        if (str != null) {
            iVar.a(str, 3);
        }
        String str2 = this.f6690e;
        if (str2 != null) {
            iVar.a(str2, 4);
        }
        String str3 = this.f6691f;
        if (str3 != null) {
            iVar.a(str3, 5);
        }
        String str4 = this.f6692g;
        if (str4 != null) {
            iVar.a(str4, 6);
        }
        Map<String, String> map = this.f6693h;
        if (map != null) {
            iVar.a((Map) map, 7);
        }
        String str5 = this.f6694i;
        if (str5 != null) {
            iVar.a(str5, 8);
        }
        aj ajVar = this.f6695j;
        if (ajVar != null) {
            iVar.a((j) ajVar, 9);
        }
        iVar.a(this.f6696k, 10);
        String str6 = this.f6697l;
        if (str6 != null) {
            iVar.a(str6, 11);
        }
        String str7 = this.f6698m;
        if (str7 != null) {
            iVar.a(str7, 12);
        }
        ai aiVar = this.n;
        if (aiVar != null) {
            iVar.a((j) aiVar, 13);
        }
        ArrayList<ai> arrayList = this.o;
        if (arrayList != null) {
            iVar.a((Collection) arrayList, 14);
        }
        ArrayList<ai> arrayList2 = this.p;
        if (arrayList2 != null) {
            iVar.a((Collection) arrayList2, 15);
        }
        ArrayList<ak> arrayList3 = this.q;
        if (arrayList3 != null) {
            iVar.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.r;
        if (map2 != null) {
            iVar.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.s;
        if (map3 != null) {
            iVar.a((Map) map3, 18);
        }
        String str8 = this.t;
        if (str8 != null) {
            iVar.a(str8, 19);
        }
        iVar.a(this.u, 20);
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(h hVar) {
        this.a = hVar.b(0, true);
        this.b = hVar.a(this.b, 1, true);
        this.f6688c = hVar.b(2, true);
        this.f6689d = hVar.b(3, false);
        this.f6690e = hVar.b(4, false);
        this.f6691f = hVar.b(5, false);
        this.f6692g = hVar.b(6, false);
        this.f6693h = (Map) hVar.a((h) v, 7, false);
        this.f6694i = hVar.b(8, false);
        this.f6695j = (aj) hVar.a((j) w, 9, false);
        this.f6696k = hVar.a(this.f6696k, 10, false);
        this.f6697l = hVar.b(11, false);
        this.f6698m = hVar.b(12, false);
        this.n = (ai) hVar.a((j) x, 13, false);
        this.o = (ArrayList) hVar.a((h) y, 14, false);
        this.p = (ArrayList) hVar.a((h) z, 15, false);
        this.q = (ArrayList) hVar.a((h) A, 16, false);
        this.r = (Map) hVar.a((h) B, 17, false);
        this.s = (Map) hVar.a((h) C, 18, false);
        this.t = hVar.b(19, false);
        this.u = hVar.a(20, false);
    }
}
