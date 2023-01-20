package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ao extends j {

    /* renamed from: i  reason: collision with root package name */
    private static byte[] f6710i;

    /* renamed from: j  reason: collision with root package name */
    private static Map<String, String> f6711j;
    public byte a = 0;
    public int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f6712c = null;

    /* renamed from: f  reason: collision with root package name */
    private String f6715f = "";

    /* renamed from: d  reason: collision with root package name */
    public long f6713d = 0;

    /* renamed from: g  reason: collision with root package name */
    private String f6716g = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6714e = "";

    /* renamed from: h  reason: collision with root package name */
    private Map<String, String> f6717h = null;

    static {
        f6710i = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        f6711j = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(i iVar) {
        iVar.a(this.a, 0);
        iVar.a(this.b, 1);
        byte[] bArr = this.f6712c;
        if (bArr != null) {
            iVar.a(bArr, 2);
        }
        String str = this.f6715f;
        if (str != null) {
            iVar.a(str, 3);
        }
        iVar.a(this.f6713d, 4);
        String str2 = this.f6716g;
        if (str2 != null) {
            iVar.a(str2, 5);
        }
        String str3 = this.f6714e;
        if (str3 != null) {
            iVar.a(str3, 6);
        }
        Map<String, String> map = this.f6717h;
        if (map != null) {
            iVar.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(h hVar) {
        this.a = hVar.a(this.a, 0, true);
        this.b = hVar.a(this.b, 1, true);
        this.f6712c = hVar.c(2, false);
        this.f6715f = hVar.b(3, false);
        this.f6713d = hVar.a(this.f6713d, 4, false);
        this.f6716g = hVar.b(5, false);
        this.f6714e = hVar.b(6, false);
        this.f6717h = (Map) hVar.a((h) f6711j, 7, false);
    }
}
