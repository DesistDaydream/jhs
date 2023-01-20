package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class fx {
    private int a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f8643c;

    /* renamed from: d  reason: collision with root package name */
    private String f8644d;

    /* renamed from: e  reason: collision with root package name */
    private String f8645e;

    /* renamed from: f  reason: collision with root package name */
    private List<fq> f8646f;

    /* loaded from: classes3.dex */
    public static class a {
        public static final a a = new a("internal-server-error");
        public static final a b = new a("forbidden");

        /* renamed from: c  reason: collision with root package name */
        public static final a f8647c = new a("bad-request");

        /* renamed from: d  reason: collision with root package name */
        public static final a f8648d = new a("conflict");

        /* renamed from: e  reason: collision with root package name */
        public static final a f8649e = new a("feature-not-implemented");

        /* renamed from: f  reason: collision with root package name */
        public static final a f8650f = new a("gone");

        /* renamed from: g  reason: collision with root package name */
        public static final a f8651g = new a("item-not-found");

        /* renamed from: h  reason: collision with root package name */
        public static final a f8652h = new a("jid-malformed");

        /* renamed from: i  reason: collision with root package name */
        public static final a f8653i = new a("not-acceptable");

        /* renamed from: j  reason: collision with root package name */
        public static final a f8654j = new a("not-allowed");

        /* renamed from: k  reason: collision with root package name */
        public static final a f8655k = new a("not-authorized");

        /* renamed from: l  reason: collision with root package name */
        public static final a f8656l = new a("payment-required");

        /* renamed from: m  reason: collision with root package name */
        public static final a f8657m = new a("recipient-unavailable");
        public static final a n = new a("redirect");
        public static final a o = new a("registration-required");
        public static final a p = new a("remote-server-error");
        public static final a q = new a("remote-server-not-found");
        public static final a r = new a("remote-server-timeout");
        public static final a s = new a("resource-constraint");
        public static final a t = new a("service-unavailable");
        public static final a u = new a("subscription-required");
        public static final a v = new a("undefined-condition");
        public static final a w = new a("unexpected-request");
        public static final a x = new a("request-timeout");
        private String y;

        public a(String str) {
            this.y = str;
        }

        public String toString() {
            return this.y;
        }
    }

    public fx(int i2, String str, String str2, String str3, String str4, List<fq> list) {
        this.f8646f = null;
        this.a = i2;
        this.b = str;
        this.f8644d = str2;
        this.f8643c = str3;
        this.f8645e = str4;
        this.f8646f = list;
    }

    public fx(Bundle bundle) {
        this.f8646f = null;
        this.a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.b = bundle.getString("ext_err_type");
        }
        this.f8643c = bundle.getString("ext_err_cond");
        this.f8644d = bundle.getString("ext_err_reason");
        this.f8645e = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f8646f = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fq a2 = fq.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f8646f.add(a2);
                }
            }
        }
    }

    public fx(a aVar) {
        this.f8646f = null;
        a(aVar);
        this.f8645e = null;
    }

    private void a(a aVar) {
        this.f8643c = aVar.y;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.b;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.a);
        String str2 = this.f8644d;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f8643c;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.f8645e;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<fq> list = this.f8646f;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            for (fq fqVar : this.f8646f) {
                Bundle e2 = fqVar.e();
                if (e2 != null) {
                    bundleArr[i2] = e2;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.a);
        sb.append("\"");
        if (this.b != null) {
            sb.append(" type=\"");
            sb.append(this.b);
            sb.append("\"");
        }
        if (this.f8644d != null) {
            sb.append(" reason=\"");
            sb.append(this.f8644d);
            sb.append("\"");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        if (this.f8643c != null) {
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(this.f8643c);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f8645e != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.f8645e);
            sb.append("</text>");
        }
        for (fq fqVar : c()) {
            sb.append(fqVar.d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    public synchronized List<fq> c() {
        List<fq> list = this.f8646f;
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f8643c;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.a);
        sb.append(")");
        if (this.f8645e != null) {
            sb.append(ExpandableTextView.N);
            sb.append(this.f8645e);
        }
        return sb.toString();
    }
}
