package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class fr extends ft {

    /* renamed from: c  reason: collision with root package name */
    private a f8600c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, String> f8601d;

    /* loaded from: classes3.dex */
    public static class a {
        public static final a a = new a("get");
        public static final a b = new a("set");

        /* renamed from: c  reason: collision with root package name */
        public static final a f8602c = new a("result");

        /* renamed from: d  reason: collision with root package name */
        public static final a f8603d = new a(com.umeng.analytics.pro.d.O);

        /* renamed from: e  reason: collision with root package name */
        public static final a f8604e = new a(com.heytap.mcssdk.constant.b.y);

        /* renamed from: f  reason: collision with root package name */
        private String f8605f;

        private a(String str) {
            this.f8605f = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = a;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = b;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = f8603d;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = f8602c;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = f8604e;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        public String toString() {
            return this.f8605f;
        }
    }

    public fr() {
        this.f8600c = a.a;
        this.f8601d = new HashMap();
    }

    public fr(Bundle bundle) {
        super(bundle);
        this.f8600c = a.a;
        this.f8601d = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f8600c = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public a a() {
        return this.f8600c;
    }

    public void a(a aVar) {
        if (aVar == null) {
            aVar = a.a;
        }
        this.f8600c = aVar;
    }

    public synchronized void a(Map<String, String> map) {
        this.f8601d.putAll(map);
    }

    @Override // com.xiaomi.push.ft
    public Bundle b() {
        Bundle b = super.b();
        a aVar = this.f8600c;
        if (aVar != null) {
            b.putString("ext_iq_type", aVar.toString());
        }
        return b;
    }

    @Override // com.xiaomi.push.ft
    public String c() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (k() != null) {
            sb.append("id=\"" + k() + "\" ");
        }
        if (m() != null) {
            sb.append("to=\"");
            sb.append(ge.a(m()));
            sb.append("\" ");
        }
        if (n() != null) {
            sb.append("from=\"");
            sb.append(ge.a(n()));
            sb.append("\" ");
        }
        if (l() != null) {
            sb.append("chid=\"");
            sb.append(ge.a(l()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f8601d.entrySet()) {
            sb.append(ge.a(entry.getKey()));
            sb.append("=\"");
            sb.append(ge.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.f8600c == null) {
            str = "type=\"get\">";
        } else {
            sb.append("type=\"");
            sb.append(a());
            str = "\">";
        }
        sb.append(str);
        String d2 = d();
        if (d2 != null) {
            sb.append(d2);
        }
        sb.append(s());
        fx p = p();
        if (p != null) {
            sb.append(p.b());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public String d() {
        return null;
    }
}
