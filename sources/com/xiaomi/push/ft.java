package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public abstract class ft {
    public static final DateFormat b;

    /* renamed from: d  reason: collision with root package name */
    private static String f8618d;

    /* renamed from: e  reason: collision with root package name */
    private static long f8619e;

    /* renamed from: f  reason: collision with root package name */
    private String f8620f;

    /* renamed from: g  reason: collision with root package name */
    private String f8621g;

    /* renamed from: h  reason: collision with root package name */
    private String f8622h;

    /* renamed from: i  reason: collision with root package name */
    private String f8623i;

    /* renamed from: j  reason: collision with root package name */
    private String f8624j;

    /* renamed from: k  reason: collision with root package name */
    private String f8625k;

    /* renamed from: l  reason: collision with root package name */
    private List<fq> f8626l;

    /* renamed from: m  reason: collision with root package name */
    private final Map<String, Object> f8627m;
    private fx n;
    public static final String a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: c  reason: collision with root package name */
    private static String f8617c = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        b = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(e.j.a.c.m.o.a));
        f8618d = ge.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        f8619e = 0L;
    }

    public ft() {
        this.f8620f = f8617c;
        this.f8621g = null;
        this.f8622h = null;
        this.f8623i = null;
        this.f8624j = null;
        this.f8625k = null;
        this.f8626l = new CopyOnWriteArrayList();
        this.f8627m = new HashMap();
        this.n = null;
    }

    public ft(Bundle bundle) {
        this.f8620f = f8617c;
        this.f8621g = null;
        this.f8622h = null;
        this.f8623i = null;
        this.f8624j = null;
        this.f8625k = null;
        this.f8626l = new CopyOnWriteArrayList();
        this.f8627m = new HashMap();
        this.n = null;
        this.f8622h = bundle.getString("ext_to");
        this.f8623i = bundle.getString("ext_from");
        this.f8624j = bundle.getString("ext_chid");
        this.f8621g = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f8626l = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fq a2 = fq.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f8626l.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.n = new fx(bundle2);
        }
    }

    public static synchronized String j() {
        String sb;
        synchronized (ft.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f8618d);
            long j2 = f8619e;
            f8619e = 1 + j2;
            sb2.append(Long.toString(j2));
            sb = sb2.toString();
        }
        return sb;
    }

    public static String u() {
        return a;
    }

    public void a(fq fqVar) {
        this.f8626l.add(fqVar);
    }

    public void a(fx fxVar) {
        this.n = fxVar;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f8620f)) {
            bundle.putString("ext_ns", this.f8620f);
        }
        if (!TextUtils.isEmpty(this.f8623i)) {
            bundle.putString("ext_from", this.f8623i);
        }
        if (!TextUtils.isEmpty(this.f8622h)) {
            bundle.putString("ext_to", this.f8622h);
        }
        if (!TextUtils.isEmpty(this.f8621g)) {
            bundle.putString("ext_pkt_id", this.f8621g);
        }
        if (!TextUtils.isEmpty(this.f8624j)) {
            bundle.putString("ext_chid", this.f8624j);
        }
        fx fxVar = this.n;
        if (fxVar != null) {
            bundle.putBundle("ext_ERROR", fxVar.a());
        }
        List<fq> list = this.f8626l;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            for (fq fqVar : this.f8626l) {
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

    public fq b(String str, String str2) {
        for (fq fqVar : this.f8626l) {
            if (str2 == null || str2.equals(fqVar.b())) {
                if (str.equals(fqVar.a())) {
                    return fqVar;
                }
            }
        }
        return null;
    }

    public abstract String c();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ft ftVar = (ft) obj;
        fx fxVar = this.n;
        if (fxVar == null ? ftVar.n == null : fxVar.equals(ftVar.n)) {
            String str = this.f8623i;
            if (str == null ? ftVar.f8623i == null : str.equals(ftVar.f8623i)) {
                if (this.f8626l.equals(ftVar.f8626l)) {
                    String str2 = this.f8621g;
                    if (str2 == null ? ftVar.f8621g == null : str2.equals(ftVar.f8621g)) {
                        String str3 = this.f8624j;
                        if (str3 == null ? ftVar.f8624j == null : str3.equals(ftVar.f8624j)) {
                            Map<String, Object> map = this.f8627m;
                            if (map == null ? ftVar.f8627m == null : map.equals(ftVar.f8627m)) {
                                String str4 = this.f8622h;
                                if (str4 == null ? ftVar.f8622h == null : str4.equals(ftVar.f8622h)) {
                                    String str5 = this.f8620f;
                                    String str6 = ftVar.f8620f;
                                    if (str5 != null) {
                                        if (str5.equals(str6)) {
                                            return true;
                                        }
                                    } else if (str6 == null) {
                                        return true;
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
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f8620f;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8621g;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8622h;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f8623i;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f8624j;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f8626l.hashCode()) * 31) + this.f8627m.hashCode()) * 31;
        fx fxVar = this.n;
        return hashCode5 + (fxVar != null ? fxVar.hashCode() : 0);
    }

    public String k() {
        if ("ID_NOT_AVAILABLE".equals(this.f8621g)) {
            return null;
        }
        if (this.f8621g == null) {
            this.f8621g = j();
        }
        return this.f8621g;
    }

    public void k(String str) {
        this.f8621g = str;
    }

    public String l() {
        return this.f8624j;
    }

    public void l(String str) {
        this.f8624j = str;
    }

    public String m() {
        return this.f8622h;
    }

    public void m(String str) {
        this.f8622h = str;
    }

    public String n() {
        return this.f8623i;
    }

    public void n(String str) {
        this.f8623i = str;
    }

    public String o() {
        return this.f8625k;
    }

    public void o(String str) {
        this.f8625k = str;
    }

    public fq p(String str) {
        return b(str, null);
    }

    public fx p() {
        return this.n;
    }

    public synchronized Object q(String str) {
        Map<String, Object> map = this.f8627m;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized Collection<fq> q() {
        if (this.f8626l == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f8626l));
    }

    public synchronized Collection<String> r() {
        if (this.f8627m == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f8627m.keySet()));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String s() {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ft.s():java.lang.String");
    }

    public String t() {
        return this.f8620f;
    }
}
