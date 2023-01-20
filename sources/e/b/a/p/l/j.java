package e.b.a.p.l;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<i>> f9697c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Map<String, String> f9698d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: d  reason: collision with root package name */
        private static final String f9699d = "User-Agent";

        /* renamed from: e  reason: collision with root package name */
        private static final String f9700e;

        /* renamed from: f  reason: collision with root package name */
        private static final Map<String, List<i>> f9701f;
        private boolean a = true;
        private Map<String, List<i>> b = f9701f;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9702c = true;

        static {
            String g2 = g();
            f9700e = g2;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(g2)) {
                hashMap.put(f9699d, Collections.singletonList(new b(g2)));
            }
            f9701f = Collections.unmodifiableMap(hashMap);
        }

        private Map<String, List<i>> d() {
            HashMap hashMap = new HashMap(this.b.size());
            for (Map.Entry<String, List<i>> entry : this.b.entrySet()) {
                hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return hashMap;
        }

        private void e() {
            if (this.a) {
                this.a = false;
                this.b = d();
            }
        }

        private List<i> f(String str) {
            List<i> list = this.b.get(str);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                this.b.put(str, arrayList);
                return arrayList;
            }
            return list;
        }

        @VisibleForTesting
        public static String g() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = property.charAt(i2);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append(k.b.a.a.o.e.a);
                }
            }
            return sb.toString();
        }

        public a a(@NonNull String str, @NonNull i iVar) {
            if (this.f9702c && f9699d.equalsIgnoreCase(str)) {
                return h(str, iVar);
            }
            e();
            f(str).add(iVar);
            return this;
        }

        public a b(@NonNull String str, @NonNull String str2) {
            return a(str, new b(str2));
        }

        public j c() {
            this.a = true;
            return new j(this.b);
        }

        public a h(@NonNull String str, @Nullable i iVar) {
            e();
            if (iVar == null) {
                this.b.remove(str);
            } else {
                List<i> f2 = f(str);
                f2.clear();
                f2.add(iVar);
            }
            if (this.f9702c && f9699d.equalsIgnoreCase(str)) {
                this.f9702c = false;
            }
            return this;
        }

        public a i(@NonNull String str, @Nullable String str2) {
            return h(str, str2 == null ? null : new b(str2));
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements i {
        @NonNull
        private final String a;

        public b(@NonNull String str) {
            this.a = str;
        }

        @Override // e.b.a.p.l.i
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.a + "'}";
        }
    }

    public j(Map<String, List<i>> map) {
        this.f9697c = Collections.unmodifiableMap(map);
    }

    @NonNull
    private String a(@NonNull List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String a2 = list.get(i2).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f9697c.entrySet()) {
            String a2 = a(entry.getValue());
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put(entry.getKey(), a2);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f9697c.equals(((j) obj).f9697c);
        }
        return false;
    }

    @Override // e.b.a.p.l.h
    public Map<String, String> getHeaders() {
        if (this.f9698d == null) {
            synchronized (this) {
                if (this.f9698d == null) {
                    this.f9698d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f9698d;
    }

    public int hashCode() {
        return this.f9697c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f9697c + '}';
    }
}
