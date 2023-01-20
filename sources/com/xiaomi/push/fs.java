package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: classes3.dex */
public class fs extends ft {

    /* renamed from: c  reason: collision with root package name */
    private String f8606c;

    /* renamed from: d  reason: collision with root package name */
    private String f8607d;

    /* renamed from: e  reason: collision with root package name */
    private String f8608e;

    /* renamed from: f  reason: collision with root package name */
    private String f8609f;

    /* renamed from: g  reason: collision with root package name */
    private String f8610g;

    /* renamed from: h  reason: collision with root package name */
    private String f8611h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8612i;

    /* renamed from: j  reason: collision with root package name */
    private String f8613j;

    /* renamed from: k  reason: collision with root package name */
    private String f8614k;

    /* renamed from: l  reason: collision with root package name */
    private String f8615l;

    /* renamed from: m  reason: collision with root package name */
    private String f8616m;
    private String n;
    private boolean o;

    public fs() {
        this.f8606c = null;
        this.f8607d = null;
        this.f8612i = false;
        this.f8614k = "";
        this.f8615l = "";
        this.f8616m = "";
        this.n = "";
        this.o = false;
    }

    public fs(Bundle bundle) {
        super(bundle);
        this.f8606c = null;
        this.f8607d = null;
        this.f8612i = false;
        this.f8614k = "";
        this.f8615l = "";
        this.f8616m = "";
        this.n = "";
        this.o = false;
        this.f8606c = bundle.getString("ext_msg_type");
        this.f8608e = bundle.getString("ext_msg_lang");
        this.f8607d = bundle.getString("ext_msg_thread");
        this.f8609f = bundle.getString("ext_msg_sub");
        this.f8610g = bundle.getString("ext_msg_body");
        this.f8611h = bundle.getString("ext_body_encode");
        this.f8613j = bundle.getString("ext_msg_appid");
        this.f8612i = bundle.getBoolean("ext_msg_trans", false);
        this.o = bundle.getBoolean("ext_msg_encrypt", false);
        this.f8614k = bundle.getString("ext_msg_seq");
        this.f8615l = bundle.getString("ext_msg_mseq");
        this.f8616m = bundle.getString("ext_msg_fseq");
        this.n = bundle.getString("ext_msg_status");
    }

    public String a() {
        return this.f8606c;
    }

    public void a(String str) {
        this.f8613j = str;
    }

    public void a(String str, String str2) {
        this.f8610g = str;
        this.f8611h = str2;
    }

    public void a(boolean z) {
        this.f8612i = z;
    }

    @Override // com.xiaomi.push.ft
    public Bundle b() {
        Bundle b = super.b();
        if (!TextUtils.isEmpty(this.f8606c)) {
            b.putString("ext_msg_type", this.f8606c);
        }
        String str = this.f8608e;
        if (str != null) {
            b.putString("ext_msg_lang", str);
        }
        String str2 = this.f8609f;
        if (str2 != null) {
            b.putString("ext_msg_sub", str2);
        }
        String str3 = this.f8610g;
        if (str3 != null) {
            b.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.f8611h)) {
            b.putString("ext_body_encode", this.f8611h);
        }
        String str4 = this.f8607d;
        if (str4 != null) {
            b.putString("ext_msg_thread", str4);
        }
        String str5 = this.f8613j;
        if (str5 != null) {
            b.putString("ext_msg_appid", str5);
        }
        if (this.f8612i) {
            b.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f8614k)) {
            b.putString("ext_msg_seq", this.f8614k);
        }
        if (!TextUtils.isEmpty(this.f8615l)) {
            b.putString("ext_msg_mseq", this.f8615l);
        }
        if (!TextUtils.isEmpty(this.f8616m)) {
            b.putString("ext_msg_fseq", this.f8616m);
        }
        if (this.o) {
            b.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.n)) {
            b.putString("ext_msg_status", this.n);
        }
        return b;
    }

    public void b(String str) {
        this.f8614k = str;
    }

    public void b(boolean z) {
        this.o = z;
    }

    @Override // com.xiaomi.push.ft
    public String c() {
        fx p;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (t() != null) {
            sb.append(" xmlns=\"");
            sb.append(t());
            sb.append("\"");
        }
        if (this.f8608e != null) {
            sb.append(" xml:lang=\"");
            sb.append(i());
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
        if (!TextUtils.isEmpty(e())) {
            sb.append(" seq=\"");
            sb.append(e());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb.append(" mseq=\"");
            sb.append(f());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb.append(" fseq=\"");
            sb.append(g());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(h())) {
            sb.append(" status=\"");
            sb.append(h());
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
        if (this.f8612i) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f8613j)) {
            sb.append(" appid=\"");
            sb.append(d());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.f8606c)) {
            sb.append(" type=\"");
            sb.append(this.f8606c);
            sb.append("\"");
        }
        if (this.o) {
            sb.append(" s=\"1\"");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        if (this.f8609f != null) {
            sb.append("<subject>");
            sb.append(ge.a(this.f8609f));
            sb.append("</subject>");
        }
        if (this.f8610g != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.f8611h)) {
                sb.append(" encode=\"");
                sb.append(this.f8611h);
                sb.append("\"");
            }
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            sb.append(ge.a(this.f8610g));
            sb.append("</body>");
        }
        if (this.f8607d != null) {
            sb.append("<thread>");
            sb.append(this.f8607d);
            sb.append("</thread>");
        }
        if (com.umeng.analytics.pro.d.O.equalsIgnoreCase(this.f8606c) && (p = p()) != null) {
            sb.append(p.b());
        }
        sb.append(s());
        sb.append("</message>");
        return sb.toString();
    }

    public void c(String str) {
        this.f8615l = str;
    }

    public String d() {
        return this.f8613j;
    }

    public void d(String str) {
        this.f8616m = str;
    }

    public String e() {
        return this.f8614k;
    }

    public void e(String str) {
        this.n = str;
    }

    @Override // com.xiaomi.push.ft
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fs fsVar = (fs) obj;
        if (super.equals(fsVar)) {
            String str = this.f8610g;
            if (str == null ? fsVar.f8610g == null : str.equals(fsVar.f8610g)) {
                String str2 = this.f8608e;
                if (str2 == null ? fsVar.f8608e == null : str2.equals(fsVar.f8608e)) {
                    String str3 = this.f8609f;
                    if (str3 == null ? fsVar.f8609f == null : str3.equals(fsVar.f8609f)) {
                        String str4 = this.f8607d;
                        if (str4 == null ? fsVar.f8607d == null : str4.equals(fsVar.f8607d)) {
                            return this.f8606c == fsVar.f8606c;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public String f() {
        return this.f8615l;
    }

    public void f(String str) {
        this.f8606c = str;
    }

    public String g() {
        return this.f8616m;
    }

    public void g(String str) {
        this.f8609f = str;
    }

    public String h() {
        return this.n;
    }

    public void h(String str) {
        this.f8610g = str;
    }

    @Override // com.xiaomi.push.ft
    public int hashCode() {
        String str = this.f8606c;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8610g;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8607d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f8608e;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f8609f;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String i() {
        return this.f8608e;
    }

    public void i(String str) {
        this.f8607d = str;
    }

    public void j(String str) {
        this.f8608e = str;
    }
}
