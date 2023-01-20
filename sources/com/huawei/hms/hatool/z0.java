package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* loaded from: classes2.dex */
public class z0 {
    public static z0 b;
    public Context a;

    /* loaded from: classes2.dex */
    public static class a extends a1 {
        public String a;
        public String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.huawei.hms.hatool.a1
        public String a() {
            return com.huawei.hms.hatool.a.d(this.a, this.b);
        }

        @Override // com.huawei.hms.hatool.a1
        public String a(String str) {
            return e.k.c.a.a.h.d.d.b(str);
        }

        @Override // com.huawei.hms.hatool.a1
        public String b() {
            return com.huawei.hms.hatool.a.g(this.a, this.b);
        }

        @Override // com.huawei.hms.hatool.a1
        public String c() {
            return com.huawei.hms.hatool.a.j(this.a, this.b);
        }

        @Override // com.huawei.hms.hatool.a1
        public int d() {
            return (com.huawei.hms.hatool.a.k(this.a, this.b) ? 4 : 0) | 0 | (com.huawei.hms.hatool.a.e(this.a, this.b) ? 2 : 0) | (com.huawei.hms.hatool.a.h(this.a, this.b) ? 1 : 0);
        }
    }

    public static z0 a() {
        z0 z0Var;
        synchronized (z0.class) {
            if (b == null) {
                b = new z0();
            }
            z0Var = b;
        }
        return z0Var;
    }

    public String a(String str, String str2) {
        return g.a(this.a, str, str2);
    }

    public String a(boolean z) {
        if (z) {
            String e2 = b.e();
            if (TextUtils.isEmpty(e2)) {
                e2 = g0.a(this.a, "global_v2", "uuid", "");
                if (TextUtils.isEmpty(e2)) {
                    e2 = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                    g0.b(this.a, "global_v2", "uuid", e2);
                }
                b.h(e2);
            }
            return e2;
        }
        return "";
    }

    public void a(Context context) {
        if (this.a == null) {
            this.a = context;
        }
    }

    public String b(String str, String str2) {
        return g.b(this.a, str, str2);
    }

    public x0 c(String str, String str2) {
        return new a(str, str2).a(this.a);
    }

    public String d(String str, String str2) {
        return c1.b(str, str2);
    }

    public Pair<String, String> e(String str, String str2) {
        if (com.huawei.hms.hatool.a.f(str, str2)) {
            String p = i.c().b().p();
            String q = i.c().b().q();
            if (TextUtils.isEmpty(p) || TextUtils.isEmpty(q)) {
                Pair<String, String> e2 = b1.e(this.a);
                i.c().b().k((String) e2.first);
                i.c().b().l((String) e2.second);
                return e2;
            }
            return new Pair<>(p, q);
        }
        return new Pair<>("", "");
    }

    public String f(String str, String str2) {
        return c1.a(str, str2);
    }
}
