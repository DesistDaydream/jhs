package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.i.f;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class a {
    public int a;
    private final Map<String, c> b;

    /* renamed from: c */
    private final Map<String, d> f5840c;

    /* renamed from: com.ss.android.socialbase.downloader.network.a.a$a */
    /* loaded from: classes3.dex */
    public static final class C0214a {
        private static final a a = new a();
    }

    public void a(String str, c cVar) {
        synchronized (this.b) {
            this.b.put(str, cVar);
        }
    }

    public d b(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        d remove;
        synchronized (this.f5840c) {
            remove = this.f5840c.remove(str);
        }
        if (remove != null) {
            if (f.a(remove.f(), list)) {
                try {
                    remove.e();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (remove.h() && remove.g()) {
                    return remove;
                }
            }
            try {
                remove.d();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private a() {
        this.b = new HashMap();
        this.f5840c = new LinkedHashMap(3);
        this.a = 3;
    }

    public void a(int i2) {
        this.a = i2;
    }

    public c a(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        c remove;
        synchronized (this.b) {
            remove = this.b.remove(str);
        }
        if (remove != null) {
            if (f.a(remove.h(), list)) {
                try {
                    remove.d();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (remove.f() && remove.e()) {
                    return remove;
                }
            }
            try {
                remove.c();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public boolean a(String str) {
        c cVar = this.b.get(str);
        if (cVar != null) {
            if (cVar.g()) {
                return true;
            }
            return cVar.f() && cVar.e();
        }
        return false;
    }

    public static a a() {
        return C0214a.a;
    }
}
