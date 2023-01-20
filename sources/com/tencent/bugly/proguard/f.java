package com.tencent.bugly.proguard;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class f extends j {

    /* renamed from: e  reason: collision with root package name */
    public byte[] f6752e;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, String> f6756i;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, String> f6757j;

    /* renamed from: m  reason: collision with root package name */
    private static /* synthetic */ boolean f6749m = true;

    /* renamed from: k  reason: collision with root package name */
    private static byte[] f6747k = null;

    /* renamed from: l  reason: collision with root package name */
    private static Map<String, String> f6748l = null;
    public short a = 0;

    /* renamed from: f  reason: collision with root package name */
    private byte f6753f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f6754g = 0;
    public int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f6750c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f6751d = null;

    /* renamed from: h  reason: collision with root package name */
    private int f6755h = 0;

    @Override // com.tencent.bugly.proguard.j
    public final void a(i iVar) {
        iVar.a(this.a, 1);
        iVar.a(this.f6753f, 2);
        iVar.a(this.f6754g, 3);
        iVar.a(this.b, 4);
        iVar.a(this.f6750c, 5);
        iVar.a(this.f6751d, 6);
        iVar.a(this.f6752e, 7);
        iVar.a(this.f6755h, 8);
        iVar.a((Map) this.f6756i, 9);
        iVar.a((Map) this.f6757j, 10);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f6749m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        f fVar = (f) obj;
        return k.a(1, (int) fVar.a) && k.a(1, (int) fVar.f6753f) && k.a(1, fVar.f6754g) && k.a(1, fVar.b) && k.a((Object) 1, (Object) fVar.f6750c) && k.a((Object) 1, (Object) fVar.f6751d) && k.a((Object) 1, (Object) fVar.f6752e) && k.a(1, fVar.f6755h) && k.a((Object) 1, (Object) fVar.f6756i) && k.a((Object) 1, (Object) fVar.f6757j);
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(h hVar) {
        try {
            this.a = hVar.a(this.a, 1, true);
            this.f6753f = hVar.a(this.f6753f, 2, true);
            this.f6754g = hVar.a(this.f6754g, 3, true);
            this.b = hVar.a(this.b, 4, true);
            this.f6750c = hVar.b(5, true);
            this.f6751d = hVar.b(6, true);
            if (f6747k == null) {
                f6747k = new byte[]{0};
            }
            this.f6752e = hVar.c(7, true);
            this.f6755h = hVar.a(this.f6755h, 8, true);
            if (f6748l == null) {
                HashMap hashMap = new HashMap();
                f6748l = hashMap;
                hashMap.put("", "");
            }
            this.f6756i = (Map) hVar.a((h) f6748l, 9, true);
            if (f6748l == null) {
                HashMap hashMap2 = new HashMap();
                f6748l = hashMap2;
                hashMap2.put("", "");
            }
            this.f6757j = (Map) hVar.a((h) f6748l, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            PrintStream printStream = System.out;
            printStream.println("RequestPacket decode error " + e.a(this.f6752e));
            throw new RuntimeException(e2);
        }
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(StringBuilder sb, int i2) {
        z zVar = new z(sb, i2);
        zVar.a(this.a, "iVersion");
        zVar.a(this.f6753f, "cPacketType");
        zVar.a(this.f6754g, "iMessageType");
        zVar.a(this.b, "iRequestId");
        zVar.a(this.f6750c, "sServantName");
        zVar.a(this.f6751d, "sFuncName");
        zVar.a(this.f6752e, "sBuffer");
        zVar.a(this.f6755h, "iTimeout");
        zVar.a((Map) this.f6756i, "context");
        zVar.a((Map) this.f6757j, "status");
    }
}
