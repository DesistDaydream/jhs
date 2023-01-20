package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class d extends c {

    /* renamed from: f */
    private static HashMap<String, byte[]> f6744f;

    /* renamed from: g */
    private static HashMap<String, HashMap<String, byte[]>> f6745g;

    /* renamed from: e */
    private f f6746e;

    public d() {
        f fVar = new f();
        this.f6746e = fVar;
        fVar.a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final <T> void a(String str, T t) {
        if (!str.startsWith(".")) {
            super.a(str, (String) t);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is " + str);
    }

    public final void b(String str) {
        this.f6746e.f6750c = str;
    }

    @Override // com.tencent.bugly.proguard.c
    public final void c() {
        super.c();
        this.f6746e.a = (short) 3;
    }

    public final void c(String str) {
        this.f6746e.f6751d = str;
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final byte[] a() {
        f fVar = this.f6746e;
        if (fVar.a == 2) {
            if (!fVar.f6750c.equals("")) {
                if (this.f6746e.f6751d.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (fVar.f6750c == null) {
                fVar.f6750c = "";
            }
            if (fVar.f6751d == null) {
                fVar.f6751d = "";
            }
        }
        i iVar = new i(0);
        iVar.a(this.b);
        if (this.f6746e.a == 2) {
            iVar.a((Map) this.a, 0);
        } else {
            iVar.a((Map) ((c) this).f6741d, 0);
        }
        this.f6746e.f6752e = k.a(iVar.a());
        i iVar2 = new i(0);
        iVar2.a(this.b);
        this.f6746e.a(iVar2);
        byte[] a = k.a(iVar2.a());
        int length = a.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                h hVar = new h(bArr, 4);
                hVar.a(this.b);
                this.f6746e.a(hVar);
                f fVar = this.f6746e;
                if (fVar.a == 3) {
                    h hVar2 = new h(fVar.f6752e);
                    hVar2.a(this.b);
                    if (f6744f == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        f6744f = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    ((c) this).f6741d = hVar2.a((Map) f6744f, 0, false);
                    return;
                }
                h hVar3 = new h(fVar.f6752e);
                hVar3.a(this.b);
                if (f6745g == null) {
                    f6745g = new HashMap<>();
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    hashMap2.put("", new byte[0]);
                    f6745g.put("", hashMap2);
                }
                this.a = hVar3.a((Map) f6745g, 0, false);
                new HashMap();
                return;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    public final void a(int i2) {
        this.f6746e.b = 1;
    }
}
