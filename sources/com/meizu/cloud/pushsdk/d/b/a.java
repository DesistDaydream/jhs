package com.meizu.cloud.pushsdk.d.b;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.meizu.cloud.pushsdk.c.c.i;
import com.meizu.cloud.pushsdk.c.c.j;
import com.meizu.cloud.pushsdk.c.c.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public abstract class a {
    public final Context a;
    public final f b;

    /* renamed from: c */
    public final int f4801c;

    /* renamed from: d */
    public final int f4802d;

    /* renamed from: e */
    public final int f4803e;

    /* renamed from: f */
    public final TimeUnit f4804f;

    /* renamed from: g */
    public final AtomicBoolean f4805g;

    /* renamed from: h */
    private final String f4806h;

    /* renamed from: i */
    private final com.meizu.cloud.pushsdk.c.c.g f4807i;

    /* renamed from: j */
    private Uri.Builder f4808j;

    /* renamed from: k */
    private d f4809k;

    /* renamed from: l */
    private b f4810l;

    /* renamed from: m */
    private h f4811m;
    private final SSLSocketFactory n;
    private final HostnameVerifier o;
    private String p;
    private final long q;
    private final long r;
    private final com.meizu.cloud.pushsdk.c.c.a s;

    /* renamed from: com.meizu.cloud.pushsdk.d.b.a$a */
    /* loaded from: classes2.dex */
    public static class C0158a {
        public final String a;
        public final Context b;

        /* renamed from: m */
        public SSLSocketFactory f4825m;
        public HostnameVerifier n;

        /* renamed from: c */
        public f f4815c = null;

        /* renamed from: d */
        public d f4816d = d.POST;

        /* renamed from: e */
        public b f4817e = b.Single;

        /* renamed from: f */
        public h f4818f = h.HTTPS;

        /* renamed from: g */
        public int f4819g = 5;

        /* renamed from: h */
        public int f4820h = 250;

        /* renamed from: i */
        public int f4821i = 5;

        /* renamed from: j */
        public long f4822j = 40000;

        /* renamed from: k */
        public long f4823k = 40000;

        /* renamed from: l */
        public TimeUnit f4824l = TimeUnit.SECONDS;
        public com.meizu.cloud.pushsdk.c.c.a o = new com.meizu.cloud.pushsdk.c.c.e();

        public C0158a(String str, Context context, Class<? extends a> cls) {
            this.a = str;
            this.b = context;
        }

        public C0158a a(int i2) {
            this.f4819g = i2;
            return this;
        }

        public C0158a a(com.meizu.cloud.pushsdk.c.c.a aVar) {
            if (aVar != null) {
                this.o = aVar;
                String simpleName = C0158a.class.getSimpleName();
                com.meizu.cloud.pushsdk.d.f.c.c(simpleName, "set new call " + aVar, new Object[0]);
            }
            return this;
        }

        public C0158a a(b bVar) {
            this.f4817e = bVar;
            return this;
        }

        public C0158a a(f fVar) {
            this.f4815c = fVar;
            return this;
        }

        public C0158a b(int i2) {
            this.f4820h = i2;
            return this;
        }

        public C0158a c(int i2) {
            this.f4821i = i2;
            return this;
        }
    }

    public a(C0158a c0158a) {
        String simpleName = a.class.getSimpleName();
        this.f4806h = simpleName;
        this.f4807i = com.meizu.cloud.pushsdk.c.c.g.a("application/json; charset=utf-8");
        this.f4805g = new AtomicBoolean(false);
        this.f4809k = c0158a.f4816d;
        this.b = c0158a.f4815c;
        this.a = c0158a.b;
        this.f4810l = c0158a.f4817e;
        this.f4811m = c0158a.f4818f;
        this.n = c0158a.f4825m;
        this.o = c0158a.n;
        this.f4801c = c0158a.f4819g;
        this.f4802d = c0158a.f4821i;
        this.f4803e = c0158a.f4820h;
        this.q = c0158a.f4822j;
        this.r = c0158a.f4823k;
        this.p = c0158a.a;
        this.f4804f = c0158a.f4824l;
        this.s = c0158a.o;
        c();
        com.meizu.cloud.pushsdk.d.f.c.c(simpleName, "Emitter created successfully!", new Object[0]);
    }

    private i a(com.meizu.cloud.pushsdk.d.a.a aVar) {
        a(aVar, "");
        this.f4808j.clearQuery();
        HashMap hashMap = (HashMap) aVar.a();
        for (String str : hashMap.keySet()) {
            this.f4808j.appendQueryParameter(str, (String) hashMap.get(str));
        }
        return new i.a().a(this.f4808j.build().toString()).a().c();
    }

    private i a(ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.meizu.cloud.pushsdk.d.a.a> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().a());
        }
        com.meizu.cloud.pushsdk.d.a.b bVar = new com.meizu.cloud.pushsdk.d.a.b("push_group_data", arrayList2);
        String str = this.f4806h;
        com.meizu.cloud.pushsdk.d.f.c.b(str, "final SelfDescribingJson " + bVar, new Object[0]);
        String uri = this.f4808j.build().toString();
        return new i.a().a(uri).a(j.a(this.f4807i, bVar.toString())).c();
    }

    private void a(k kVar) {
        if (kVar != null) {
            try {
                if (kVar.b() != null) {
                    kVar.b().close();
                }
            } catch (Exception unused) {
                com.meizu.cloud.pushsdk.d.f.c.b(this.f4806h, "Unable to close source data", new Object[0]);
            }
        }
    }

    private void a(com.meizu.cloud.pushsdk.d.a.a aVar, String str) {
        if ("".equals(str)) {
            str = com.meizu.cloud.pushsdk.d.f.e.a();
        }
        aVar.a("stm", str);
    }

    private void c() {
        StringBuilder sb;
        String str;
        String str2 = this.f4806h;
        com.meizu.cloud.pushsdk.d.f.c.a(str2, "security " + this.f4811m, new Object[0]);
        if (this.f4811m == h.HTTP) {
            sb = new StringBuilder();
            str = "http://";
        } else {
            sb = new StringBuilder();
            str = "https://";
        }
        sb.append(str);
        sb.append(this.p);
        this.f4808j = Uri.parse(sb.toString()).buildUpon();
        if (this.f4809k == d.GET) {
            this.f4808j.appendPath("i");
        } else {
            this.f4808j.appendEncodedPath("push_data_report/mobile");
        }
    }

    public int a(i iVar) {
        k kVar = null;
        try {
            com.meizu.cloud.pushsdk.d.f.c.b(this.f4806h, "Sending request: %s", iVar);
            kVar = this.s.a(iVar);
            return kVar.a();
        } catch (IOException e2) {
            com.meizu.cloud.pushsdk.d.f.c.a(this.f4806h, "Request sending failed: %s", Log.getStackTraceString(e2));
            return -1;
        } finally {
            a(kVar);
        }
    }

    public LinkedList<e> a(c cVar) {
        int size = cVar.a().size();
        LinkedList<Long> b = cVar.b();
        LinkedList<e> linkedList = new LinkedList<>();
        long j2 = 22;
        if (this.f4809k == d.GET) {
            for (int i2 = 0; i2 < size; i2++) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(b.get(i2));
                com.meizu.cloud.pushsdk.d.a.a aVar = cVar.a().get(i2);
                linkedList.add(new e(aVar.b() + 22 > this.q, a(aVar), linkedList2));
            }
        } else {
            int i3 = 0;
            while (i3 < size) {
                LinkedList linkedList3 = new LinkedList();
                ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList = new ArrayList<>();
                long j3 = 0;
                int i4 = i3;
                while (i4 < this.f4810l.a() + i3 && i4 < size) {
                    com.meizu.cloud.pushsdk.d.a.a aVar2 = cVar.a().get(i4);
                    long b2 = aVar2.b() + j2;
                    if (b2 + 88 > this.r) {
                        ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList2 = new ArrayList<>();
                        LinkedList linkedList4 = new LinkedList();
                        arrayList2.add(aVar2);
                        linkedList4.add(b.get(i4));
                        linkedList.add(new e(true, a(arrayList2), linkedList4));
                    } else {
                        j3 += b2;
                        if (j3 + 88 + (arrayList.size() - 1) > this.r) {
                            linkedList.add(new e(false, a(arrayList), linkedList3));
                            ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList3 = new ArrayList<>();
                            LinkedList linkedList5 = new LinkedList();
                            arrayList3.add(aVar2);
                            linkedList5.add(b.get(i4));
                            arrayList = arrayList3;
                            linkedList3 = linkedList5;
                            j3 = b2;
                        } else {
                            arrayList.add(aVar2);
                            linkedList3.add(b.get(i4));
                        }
                    }
                    i4++;
                    j2 = 22;
                }
                if (!arrayList.isEmpty()) {
                    linkedList.add(new e(false, a(arrayList), linkedList3));
                }
                i3 += this.f4810l.a();
                j2 = 22;
            }
        }
        return linkedList;
    }

    public abstract void a();

    public abstract void a(com.meizu.cloud.pushsdk.d.a.a aVar, boolean z);

    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    public String b() {
        return this.f4808j.clearQuery().build().toString();
    }
}
