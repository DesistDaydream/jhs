package com.meizu.cloud.pushsdk.c.c;

import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public class b extends j {
    private static final g a = g.a("application/x-www-form-urlencoded");
    private final List<String> b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f4729c;

    /* loaded from: classes2.dex */
    public static final class a {
        private final List<String> a = new ArrayList();
        private final List<String> b = new ArrayList();

        public a a(String str, String str2) {
            this.a.add(f.a(str, HttpUrl.FORM_ENCODE_SET, false, false, true, true));
            this.b.add(f.a(str2, HttpUrl.FORM_ENCODE_SET, false, false, true, true));
            return this;
        }

        public b a() {
            return new b(this.a, this.b);
        }

        public a b(String str, String str2) {
            this.a.add(f.a(str, HttpUrl.FORM_ENCODE_SET, true, false, true, true));
            this.b.add(f.a(str2, HttpUrl.FORM_ENCODE_SET, true, false, true, true));
            return this;
        }
    }

    private b(List<String> list, List<String> list2) {
        this.b = m.a(list);
        this.f4729c = m.a(list2);
    }

    private long a(com.meizu.cloud.pushsdk.c.g.c cVar, boolean z) {
        com.meizu.cloud.pushsdk.c.g.b bVar = z ? new com.meizu.cloud.pushsdk.c.g.b() : cVar.b();
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                bVar.b(38);
            }
            bVar.b(this.b.get(i2));
            bVar.b(61);
            bVar.b(this.f4729c.get(i2));
        }
        if (z) {
            long a2 = bVar.a();
            bVar.j();
            return a2;
        }
        return 0L;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public g a() {
        return a;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public void a(com.meizu.cloud.pushsdk.c.g.c cVar) {
        a(cVar, false);
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public long b() {
        return a((com.meizu.cloud.pushsdk.c.g.c) null, true);
    }
}
