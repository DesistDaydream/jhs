package com.bytedance.pangle.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    public static String b = "request_finish";

    /* renamed from: c  reason: collision with root package name */
    public static String f2210c = "download_start";

    /* renamed from: d  reason: collision with root package name */
    public static String f2211d = "download_finish";

    /* renamed from: e  reason: collision with root package name */
    public static String f2212e = "install_start";

    /* renamed from: f  reason: collision with root package name */
    public static String f2213f = "install_finish";

    /* renamed from: g  reason: collision with root package name */
    public static String f2214g = "load_start";

    /* renamed from: h  reason: collision with root package name */
    public static String f2215h = "load_finish";

    /* renamed from: i  reason: collision with root package name */
    private static volatile b f2216i;
    public final List<com.bytedance.pangle.b.a> a = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public static int A = 41000;
        public static int B = 42000;
        public static int a = 12000;
        public static int b = 12001;

        /* renamed from: c  reason: collision with root package name */
        public static int f2217c = 12002;

        /* renamed from: d  reason: collision with root package name */
        public static int f2218d = 12003;

        /* renamed from: e  reason: collision with root package name */
        public static int f2219e = 12004;

        /* renamed from: f  reason: collision with root package name */
        public static int f2220f = 20000;

        /* renamed from: g  reason: collision with root package name */
        public static int f2221g = 21000;

        /* renamed from: h  reason: collision with root package name */
        public static int f2222h = 21001;

        /* renamed from: i  reason: collision with root package name */
        public static int f2223i = 21002;

        /* renamed from: j  reason: collision with root package name */
        public static int f2224j = 22000;

        /* renamed from: k  reason: collision with root package name */
        public static int f2225k = 22001;

        /* renamed from: l  reason: collision with root package name */
        public static int f2226l = 22002;

        /* renamed from: m  reason: collision with root package name */
        public static int f2227m = 22999;
        public static int n = 30000;
        public static int o = 31000;
        public static int p = 32000;
        public static int q = 32001;
        public static int r = 32002;
        public static int s = 32003;
        public static int t = 32004;
        public static int u = 32005;
        public static int v = 32006;
        public static int w = 32007;
        public static int x = 32008;
        public static int y = 32999;
        public static int z = 40000;

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0000, code lost:
            continue;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String b$a1663646904328dc(java.lang.String r2) {
            /*
            L0:
                r0 = 73
                r1 = 96
            L4:
                switch(r0) {
                    case 72: goto L26;
                    case 73: goto L8;
                    case 74: goto Lb;
                    default: goto L7;
                }
            L7:
                goto L2b
            L8:
                switch(r1) {
                    case 94: goto L0;
                    case 95: goto L26;
                    case 96: goto L26;
                    default: goto Lb;
                }
            Lb:
                switch(r1) {
                    case 55: goto Lf;
                    case 56: goto L26;
                    case 57: goto L26;
                    default: goto Le;
                }
            Le:
                goto L0
            Lf:
                char[] r2 = r2.toCharArray()
                r0 = 0
            L14:
                int r1 = r2.length
                if (r0 >= r1) goto L20
                char r1 = r2[r0]
                r1 = r1 ^ r0
                char r1 = (char) r1
                r2[r0] = r1
                int r0 = r0 + 1
                goto L14
            L20:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r2)
                return r0
            L26:
                r0 = 74
                r1 = 55
                goto L4
            L2b:
                r0 = 72
                goto L4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.b.b.a.b$a1663646904328dc(java.lang.String):java.lang.String");
        }
    }

    private b() {
    }

    public static b a() {
        if (f2216i == null) {
            synchronized (b.class) {
                f2216i = new b();
            }
        }
        return f2216i;
    }

    public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.a) {
            for (com.bytedance.pangle.b.a aVar : this.a) {
                aVar.a(str, jSONObject, jSONObject2, jSONObject3);
            }
        }
    }
}
