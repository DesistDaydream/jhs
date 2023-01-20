package com.meizu.cloud.pushsdk.c.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.c.a.b;
import com.meizu.cloud.pushsdk.c.c.b;
import com.meizu.cloud.pushsdk.c.c.c;
import com.meizu.cloud.pushsdk.c.c.f;
import com.meizu.cloud.pushsdk.c.c.g;
import com.meizu.cloud.pushsdk.c.c.h;
import com.meizu.cloud.pushsdk.c.c.j;
import com.meizu.cloud.pushsdk.c.c.k;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b<T extends b> {
    private static final String a = "b";
    private static final g w = g.a("application/json; charset=utf-8");
    private static final g x = g.a("text/x-markdown; charset=utf-8");
    private static final Object z = new Object();
    private com.meizu.cloud.pushsdk.c.c.a A;
    private int B;
    private boolean C;
    private int D;
    private com.meizu.cloud.pushsdk.c.d.a E;
    private Bitmap.Config F;
    private int G;
    private int H;
    private ImageView.ScaleType I;
    private final Executor J;
    private String K;
    private Type L;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final com.meizu.cloud.pushsdk.c.a.d f4665c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4666d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4667e;

    /* renamed from: f  reason: collision with root package name */
    private int f4668f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f4669g;

    /* renamed from: h  reason: collision with root package name */
    private e f4670h;

    /* renamed from: i  reason: collision with root package name */
    private final HashMap<String, String> f4671i;

    /* renamed from: j  reason: collision with root package name */
    private HashMap<String, String> f4672j;

    /* renamed from: k  reason: collision with root package name */
    private HashMap<String, String> f4673k;

    /* renamed from: l  reason: collision with root package name */
    private HashMap<String, String> f4674l;

    /* renamed from: m  reason: collision with root package name */
    private final HashMap<String, String> f4675m;
    private final HashMap<String, String> n;
    private HashMap<String, File> o;
    private String p;
    private String q;
    private JSONObject r;
    private JSONArray s;
    private String t;
    private byte[] u;
    private File v;
    private g y;

    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.values().length];
            a = iArr;
            try {
                iArr[e.JSON_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.JSON_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[e.BITMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[e.PREFETCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a<T extends a> {
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private Object f4676c;

        /* renamed from: g  reason: collision with root package name */
        private final String f4680g;

        /* renamed from: h  reason: collision with root package name */
        private final String f4681h;

        /* renamed from: j  reason: collision with root package name */
        private Executor f4683j;

        /* renamed from: k  reason: collision with root package name */
        private String f4684k;
        private com.meizu.cloud.pushsdk.c.a.d a = com.meizu.cloud.pushsdk.c.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        private final HashMap<String, String> f4677d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        private final HashMap<String, String> f4678e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        private final HashMap<String, String> f4679f = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        private int f4682i = 0;

        public a(String str, String str2, String str3) {
            this.b = str;
            this.f4680g = str2;
            this.f4681h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0156b<T extends C0156b> {

        /* renamed from: c  reason: collision with root package name */
        private final String f4685c;

        /* renamed from: d  reason: collision with root package name */
        private Object f4686d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap.Config f4687e;

        /* renamed from: f  reason: collision with root package name */
        private int f4688f;

        /* renamed from: g  reason: collision with root package name */
        private int f4689g;

        /* renamed from: h  reason: collision with root package name */
        private ImageView.ScaleType f4690h;

        /* renamed from: l  reason: collision with root package name */
        private Executor f4694l;

        /* renamed from: m  reason: collision with root package name */
        private String f4695m;
        private com.meizu.cloud.pushsdk.c.a.d a = com.meizu.cloud.pushsdk.c.a.d.MEDIUM;

        /* renamed from: i  reason: collision with root package name */
        private final HashMap<String, String> f4691i = new HashMap<>();

        /* renamed from: j  reason: collision with root package name */
        private final HashMap<String, String> f4692j = new HashMap<>();

        /* renamed from: k  reason: collision with root package name */
        private final HashMap<String, String> f4693k = new HashMap<>();
        private final int b = 0;

        public C0156b(String str) {
            this.f4685c = str;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f4692j.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* loaded from: classes2.dex */
    public static class c<T extends c> {
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private Object f4696c;

        /* renamed from: j  reason: collision with root package name */
        private Executor f4703j;

        /* renamed from: k  reason: collision with root package name */
        private String f4704k;

        /* renamed from: l  reason: collision with root package name */
        private String f4705l;
        private com.meizu.cloud.pushsdk.c.a.d a = com.meizu.cloud.pushsdk.c.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        private final HashMap<String, String> f4697d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        private final HashMap<String, String> f4698e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        private final HashMap<String, String> f4699f = new HashMap<>();

        /* renamed from: g  reason: collision with root package name */
        private final HashMap<String, String> f4700g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        private final HashMap<String, File> f4701h = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        private int f4702i = 0;

        public c(String str) {
            this.b = str;
        }

        public T a(String str, File file) {
            this.f4701h.put(str, file);
            return this;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f4698e.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* loaded from: classes2.dex */
    public static class d<T extends d> {

        /* renamed from: c  reason: collision with root package name */
        private final String f4706c;

        /* renamed from: d  reason: collision with root package name */
        private Object f4707d;
        private Executor o;
        private String p;
        private String q;
        private com.meizu.cloud.pushsdk.c.a.d a = com.meizu.cloud.pushsdk.c.a.d.MEDIUM;

        /* renamed from: e  reason: collision with root package name */
        private JSONObject f4708e = null;

        /* renamed from: f  reason: collision with root package name */
        private JSONArray f4709f = null;

        /* renamed from: g  reason: collision with root package name */
        private String f4710g = null;

        /* renamed from: h  reason: collision with root package name */
        private byte[] f4711h = null;

        /* renamed from: i  reason: collision with root package name */
        private File f4712i = null;

        /* renamed from: j  reason: collision with root package name */
        private final HashMap<String, String> f4713j = new HashMap<>();

        /* renamed from: k  reason: collision with root package name */
        private final HashMap<String, String> f4714k = new HashMap<>();

        /* renamed from: l  reason: collision with root package name */
        private final HashMap<String, String> f4715l = new HashMap<>();

        /* renamed from: m  reason: collision with root package name */
        private final HashMap<String, String> f4716m = new HashMap<>();
        private final HashMap<String, String> n = new HashMap<>();
        private final int b = 1;

        public d(String str) {
            this.f4706c = str;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f4714k.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f4672j = new HashMap<>();
        this.f4673k = new HashMap<>();
        this.f4674l = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.f4666d = 1;
        this.b = 0;
        this.f4665c = aVar.a;
        this.f4667e = aVar.b;
        this.f4669g = aVar.f4676c;
        this.p = aVar.f4680g;
        this.q = aVar.f4681h;
        this.f4671i = aVar.f4677d;
        this.f4675m = aVar.f4678e;
        this.n = aVar.f4679f;
        this.D = aVar.f4682i;
        this.J = aVar.f4683j;
        this.K = aVar.f4684k;
    }

    public b(C0156b c0156b) {
        this.f4672j = new HashMap<>();
        this.f4673k = new HashMap<>();
        this.f4674l = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.f4666d = 0;
        this.b = c0156b.b;
        this.f4665c = c0156b.a;
        this.f4667e = c0156b.f4685c;
        this.f4669g = c0156b.f4686d;
        this.f4671i = c0156b.f4691i;
        this.F = c0156b.f4687e;
        this.H = c0156b.f4689g;
        this.G = c0156b.f4688f;
        this.I = c0156b.f4690h;
        this.f4675m = c0156b.f4692j;
        this.n = c0156b.f4693k;
        this.J = c0156b.f4694l;
        this.K = c0156b.f4695m;
    }

    public b(c cVar) {
        this.f4672j = new HashMap<>();
        this.f4673k = new HashMap<>();
        this.f4674l = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.f4666d = 2;
        this.b = 1;
        this.f4665c = cVar.a;
        this.f4667e = cVar.b;
        this.f4669g = cVar.f4696c;
        this.f4671i = cVar.f4697d;
        this.f4675m = cVar.f4699f;
        this.n = cVar.f4700g;
        this.f4674l = cVar.f4698e;
        this.o = cVar.f4701h;
        this.D = cVar.f4702i;
        this.J = cVar.f4703j;
        this.K = cVar.f4704k;
        if (cVar.f4705l != null) {
            this.y = g.a(cVar.f4705l);
        }
    }

    public b(d dVar) {
        this.f4672j = new HashMap<>();
        this.f4673k = new HashMap<>();
        this.f4674l = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.f4666d = 0;
        this.b = dVar.b;
        this.f4665c = dVar.a;
        this.f4667e = dVar.f4706c;
        this.f4669g = dVar.f4707d;
        this.f4671i = dVar.f4713j;
        this.f4672j = dVar.f4714k;
        this.f4673k = dVar.f4715l;
        this.f4675m = dVar.f4716m;
        this.n = dVar.n;
        this.r = dVar.f4708e;
        this.s = dVar.f4709f;
        this.t = dVar.f4710g;
        this.v = dVar.f4712i;
        this.u = dVar.f4711h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = g.a(dVar.q);
        }
    }

    public com.meizu.cloud.pushsdk.c.a.c a() {
        this.f4670h = e.STRING;
        return com.meizu.cloud.pushsdk.c.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.c.a.c a(k kVar) {
        com.meizu.cloud.pushsdk.c.a.c<Bitmap> a2;
        int i2 = AnonymousClass2.a[this.f4670h.ordinal()];
        if (i2 == 1) {
            try {
                return com.meizu.cloud.pushsdk.c.a.c.a(new JSONArray(com.meizu.cloud.pushsdk.c.g.g.a(kVar.b().a()).h()));
            } catch (Exception e2) {
                return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e2)));
            }
        } else if (i2 == 2) {
            try {
                return com.meizu.cloud.pushsdk.c.a.c.a(new JSONObject(com.meizu.cloud.pushsdk.c.g.g.a(kVar.b().a()).h()));
            } catch (Exception e3) {
                return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e3)));
            }
        } else if (i2 == 3) {
            try {
                return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.g.g.a(kVar.b().a()).h());
            } catch (Exception e4) {
                return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e4)));
            }
        } else if (i2 != 4) {
            if (i2 != 5) {
                return null;
            }
            return com.meizu.cloud.pushsdk.c.a.c.a("prefetch");
        } else {
            synchronized (z) {
                try {
                    try {
                        a2 = com.meizu.cloud.pushsdk.c.h.b.a(kVar, this.G, this.H, this.F, this.I);
                    } catch (Exception e5) {
                        return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e5)));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return a2;
        }
    }

    public com.meizu.cloud.pushsdk.c.b.a a(com.meizu.cloud.pushsdk.c.b.a aVar) {
        try {
            if (aVar.a() != null && aVar.a().b() != null && aVar.a().b().a() != null) {
                aVar.b(com.meizu.cloud.pushsdk.c.g.g.a(aVar.a().b().a()).h());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar;
    }

    public void a(com.meizu.cloud.pushsdk.c.c.a aVar) {
        this.A = aVar;
    }

    public void a(String str) {
        this.K = str;
    }

    public com.meizu.cloud.pushsdk.c.a.c b() {
        this.f4670h = e.BITMAP;
        return com.meizu.cloud.pushsdk.c.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.c.a.c c() {
        return com.meizu.cloud.pushsdk.c.e.c.a(this);
    }

    public int d() {
        return this.b;
    }

    public String e() {
        String str = this.f4667e;
        for (Map.Entry<String, String> entry : this.n.entrySet()) {
            str = str.replace("{" + entry.getKey() + "}", String.valueOf(entry.getValue()));
        }
        f.a f2 = f.c(str).f();
        for (Map.Entry<String, String> entry2 : this.f4675m.entrySet()) {
            f2.a(entry2.getKey(), entry2.getValue());
        }
        return f2.b().toString();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public e f() {
        return this.f4670h;
    }

    public int g() {
        return this.f4666d;
    }

    public String h() {
        return this.K;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public com.meizu.cloud.pushsdk.c.d.a i() {
        return new com.meizu.cloud.pushsdk.c.d.a() { // from class: com.meizu.cloud.pushsdk.c.a.b.1
            @Override // com.meizu.cloud.pushsdk.c.d.a
            public void a(long j2, long j3) {
                b.this.B = (int) ((100 * j2) / j3);
                if (b.this.E == null || b.this.C) {
                    return;
                }
                b.this.E.a(j2, j3);
            }
        };
    }

    public String j() {
        return this.p;
    }

    public String k() {
        return this.q;
    }

    public com.meizu.cloud.pushsdk.c.c.a l() {
        return this.A;
    }

    public j m() {
        JSONObject jSONObject = this.r;
        if (jSONObject != null) {
            g gVar = this.y;
            return gVar != null ? j.a(gVar, jSONObject.toString()) : j.a(w, jSONObject.toString());
        }
        JSONArray jSONArray = this.s;
        if (jSONArray != null) {
            g gVar2 = this.y;
            return gVar2 != null ? j.a(gVar2, jSONArray.toString()) : j.a(w, jSONArray.toString());
        }
        String str = this.t;
        if (str != null) {
            g gVar3 = this.y;
            return gVar3 != null ? j.a(gVar3, str) : j.a(x, str);
        }
        File file = this.v;
        if (file != null) {
            g gVar4 = this.y;
            return gVar4 != null ? j.a(gVar4, file) : j.a(x, file);
        }
        byte[] bArr = this.u;
        if (bArr != null) {
            g gVar5 = this.y;
            return gVar5 != null ? j.a(gVar5, bArr) : j.a(x, bArr);
        }
        b.a aVar = new b.a();
        try {
            for (Map.Entry<String, String> entry : this.f4672j.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    aVar.a(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry<String, String> entry2 : this.f4673k.entrySet()) {
                if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                    aVar.b(entry2.getKey(), entry2.getValue());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public j n() {
        h.a a2 = new h.a().a(h.f4754e);
        try {
            for (Map.Entry<String, String> entry : this.f4674l.entrySet()) {
                a2.a(com.meizu.cloud.pushsdk.c.c.c.a("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""), j.a((g) null, entry.getValue()));
            }
            for (Map.Entry<String, File> entry2 : this.o.entrySet()) {
                if (entry2.getValue() != null) {
                    String name = entry2.getValue().getName();
                    j a3 = j.a(g.a(com.meizu.cloud.pushsdk.c.h.b.a(name)), entry2.getValue());
                    a2.a(com.meizu.cloud.pushsdk.c.c.c.a("Content-Disposition", "form-data; name=\"" + entry2.getKey() + "\"; filename=\"" + name + "\""), a3);
                    g gVar = this.y;
                    if (gVar != null) {
                        a2.a(gVar);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return a2.a();
    }

    public com.meizu.cloud.pushsdk.c.c.c o() {
        c.a aVar = new c.a();
        try {
            for (Map.Entry<String, String> entry : this.f4671i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f4668f + ", mMethod=" + this.b + ", mPriority=" + this.f4665c + ", mRequestType=" + this.f4666d + ", mUrl=" + this.f4667e + '}';
    }
}
