package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, byte[]> f6741d = null;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Object> f6742e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private h f6743f = new h();

    @Override // com.tencent.bugly.proguard.a
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public final <T> T b(String str, T t) throws b {
        HashMap<String, byte[]> hashMap = this.f6741d;
        if (hashMap != null) {
            if (hashMap.containsKey(str)) {
                if (this.f6742e.containsKey(str)) {
                    return (T) this.f6742e.get(str);
                }
                try {
                    this.f6743f.a(this.f6741d.get(str));
                    this.f6743f.a(this.b);
                    T t2 = (T) this.f6743f.a((h) t, 0, true);
                    if (t2 != null) {
                        this.f6742e.put(str, t2);
                    }
                    return t2;
                } catch (Exception e2) {
                    throw new b(e2);
                }
            }
            return null;
        } else if (this.a.containsKey(str)) {
            if (this.f6742e.containsKey(str)) {
                return (T) this.f6742e.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator<Map.Entry<String, byte[]>> it = this.a.get(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                next.getKey();
                bArr = next.getValue();
            }
            try {
                this.f6743f.a(bArr);
                this.f6743f.a(this.b);
                T t3 = (T) this.f6743f.a((h) t, 0, true);
                this.f6742e.put(str, t3);
                return t3;
            } catch (Exception e3) {
                throw new b(e3);
            }
        } else {
            return null;
        }
    }

    public void c() {
        this.f6741d = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.a
    public <T> void a(String str, T t) {
        if (this.f6741d == null) {
            super.a(str, (String) t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else {
            if (t != null) {
                if (!(t instanceof Set)) {
                    i iVar = new i();
                    iVar.a(this.b);
                    iVar.a(t, 0);
                    this.f6741d.put(str, k.a(iVar.a()));
                    return;
                }
                throw new IllegalArgumentException("can not support Set");
            }
            throw new IllegalArgumentException("put value can not is null");
        }
    }

    @Override // com.tencent.bugly.proguard.a
    public byte[] a() {
        if (this.f6741d != null) {
            i iVar = new i(0);
            iVar.a(this.b);
            iVar.a((Map) this.f6741d, 0);
            return k.a(iVar.a());
        }
        return super.a();
    }

    @Override // com.tencent.bugly.proguard.a
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f6743f.a(bArr);
            this.f6743f.a(this.b);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f6741d = this.f6743f.a((Map) hashMap, 0, false);
        }
    }
}
