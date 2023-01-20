package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class c implements g {

    /* renamed from: e */
    private static final ArrayList<String> f5843e;
    public final String a;
    public final long b;

    /* renamed from: c */
    public List<com.ss.android.socialbase.downloader.model.c> f5844c;

    /* renamed from: g */
    private int f5847g;

    /* renamed from: h */
    private long f5848h;

    /* renamed from: i */
    private boolean f5849i;

    /* renamed from: j */
    private boolean f5850j;

    /* renamed from: k */
    private g f5851k;

    /* renamed from: f */
    private Map<String, String> f5846f = null;

    /* renamed from: d */
    public final Object f5845d = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        f5843e = arrayList;
        arrayList.add("Content-Length");
        arrayList.add("Content-Range");
        arrayList.add("Transfer-Encoding");
        arrayList.add("Accept-Ranges");
        arrayList.add("Etag");
        arrayList.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) {
        this.a = str;
        this.f5844c = list;
        this.b = j2;
    }

    public void a() throws Exception {
        if (this.f5846f != null) {
            return;
        }
        try {
            this.f5850j = true;
            this.f5851k = com.ss.android.socialbase.downloader.downloader.c.a(this.a, this.f5844c);
            synchronized (this.f5845d) {
                if (this.f5851k != null) {
                    HashMap hashMap = new HashMap();
                    this.f5846f = hashMap;
                    a(this.f5851k, hashMap);
                    this.f5847g = this.f5851k.b();
                    this.f5848h = System.currentTimeMillis();
                    this.f5849i = a(this.f5847g);
                }
                this.f5850j = false;
                this.f5845d.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f5845d) {
                if (this.f5851k != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f5846f = hashMap2;
                    a(this.f5851k, hashMap2);
                    this.f5847g = this.f5851k.b();
                    this.f5848h = System.currentTimeMillis();
                    this.f5849i = a(this.f5847g);
                }
                this.f5850j = false;
                this.f5845d.notifyAll();
                throw th;
            }
        }
    }

    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        return this.f5847g;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        g gVar = this.f5851k;
        if (gVar != null) {
            gVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.f5845d) {
            if (this.f5850j && this.f5846f == null) {
                this.f5845d.wait();
            }
        }
    }

    public boolean e() {
        return this.f5849i;
    }

    public boolean f() {
        return System.currentTimeMillis() - this.f5848h < b.b;
    }

    public boolean g() {
        return this.f5850j;
    }

    public List<com.ss.android.socialbase.downloader.model.c> h() {
        return this.f5844c;
    }

    public Map<String, String> i() {
        return this.f5846f;
    }

    private void a(g gVar, Map<String, String> map) {
        if (gVar == null || map == null) {
            return;
        }
        Iterator<String> it = f5843e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, gVar.a(next));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        Map<String, String> map = this.f5846f;
        if (map != null) {
            return map.get(str);
        }
        g gVar = this.f5851k;
        if (gVar != null) {
            return gVar.a(str);
        }
        return null;
    }
}
