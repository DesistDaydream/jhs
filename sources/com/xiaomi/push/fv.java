package com.xiaomi.push;

import android.os.Bundle;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Objects;

/* loaded from: classes3.dex */
public class fv extends ft {

    /* renamed from: c  reason: collision with root package name */
    private b f8628c;

    /* renamed from: d  reason: collision with root package name */
    private String f8629d;

    /* renamed from: e  reason: collision with root package name */
    private int f8630e;

    /* renamed from: f  reason: collision with root package name */
    private a f8631f;

    /* loaded from: classes3.dex */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* loaded from: classes3.dex */
    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public fv(Bundle bundle) {
        super(bundle);
        this.f8628c = b.available;
        this.f8629d = null;
        this.f8630e = Integer.MIN_VALUE;
        this.f8631f = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f8628c = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f8629d = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f8630e = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f8631f = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public fv(b bVar) {
        this.f8628c = b.available;
        this.f8629d = null;
        this.f8630e = Integer.MIN_VALUE;
        this.f8631f = null;
        a(bVar);
    }

    public void a(int i2) {
        if (i2 >= -128 && i2 <= 128) {
            this.f8630e = i2;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i2 + " is not valid. Valid range is -128 through 128.");
    }

    public void a(a aVar) {
        this.f8631f = aVar;
    }

    public void a(b bVar) {
        Objects.requireNonNull(bVar, "Type cannot be null");
        this.f8628c = bVar;
    }

    public void a(String str) {
        this.f8629d = str;
    }

    @Override // com.xiaomi.push.ft
    public Bundle b() {
        Bundle b2 = super.b();
        b bVar = this.f8628c;
        if (bVar != null) {
            b2.putString("ext_pres_type", bVar.toString());
        }
        String str = this.f8629d;
        if (str != null) {
            b2.putString("ext_pres_status", str);
        }
        int i2 = this.f8630e;
        if (i2 != Integer.MIN_VALUE) {
            b2.putInt("ext_pres_prio", i2);
        }
        a aVar = this.f8631f;
        if (aVar != null && aVar != a.available) {
            b2.putString("ext_pres_mode", aVar.toString());
        }
        return b2;
    }

    @Override // com.xiaomi.push.ft
    public String c() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (t() != null) {
            sb.append(" xmlns=\"");
            sb.append(t());
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" id=\"");
            sb.append(k());
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" to=\"");
            sb.append(ge.a(m()));
            sb.append("\"");
        }
        if (n() != null) {
            sb.append(" from=\"");
            sb.append(ge.a(n()));
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" chid=\"");
            sb.append(ge.a(l()));
            sb.append("\"");
        }
        if (this.f8628c != null) {
            sb.append(" type=\"");
            sb.append(this.f8628c);
            sb.append("\"");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        if (this.f8629d != null) {
            sb.append("<status>");
            sb.append(ge.a(this.f8629d));
            sb.append("</status>");
        }
        if (this.f8630e != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.f8630e);
            sb.append("</priority>");
        }
        a aVar = this.f8631f;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>");
            sb.append(this.f8631f);
            sb.append("</show>");
        }
        sb.append(s());
        fx p = p();
        if (p != null) {
            sb.append(p.b());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
