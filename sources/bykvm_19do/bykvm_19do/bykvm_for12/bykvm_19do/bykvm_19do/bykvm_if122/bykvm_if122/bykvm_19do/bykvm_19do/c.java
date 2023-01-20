package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class c {
    public final y a;
    public final a0 b;

    /* loaded from: classes.dex */
    public static class a {
        public final long a;
        public final y b;

        /* renamed from: c */
        public final a0 f331c;

        /* renamed from: d */
        private Date f332d;

        /* renamed from: e */
        private String f333e;

        /* renamed from: f */
        private Date f334f;

        /* renamed from: g */
        private String f335g;

        /* renamed from: h */
        private Date f336h;

        /* renamed from: i */
        private long f337i;

        /* renamed from: j */
        private long f338j;

        /* renamed from: k */
        private String f339k;

        /* renamed from: l */
        private int f340l;

        public a(long j2, y yVar, a0 a0Var) {
            this.f340l = -1;
            this.a = j2;
            this.b = yVar;
            this.f331c = a0Var;
            if (a0Var != null) {
                this.f337i = a0Var.t();
                this.f338j = a0Var.r();
                r m2 = a0Var.m();
                int b = m2.b();
                for (int i2 = 0; i2 < b; i2++) {
                    String a = m2.a(i2);
                    String b2 = m2.b(i2);
                    if ("Date".equalsIgnoreCase(a)) {
                        this.f332d = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.d.a(b2);
                        this.f333e = b2;
                    } else if ("Expires".equalsIgnoreCase(a)) {
                        this.f336h = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.d.a(b2);
                    } else if ("Last-Modified".equalsIgnoreCase(a)) {
                        this.f334f = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.d.a(b2);
                        this.f335g = b2;
                    } else if ("ETag".equalsIgnoreCase(a)) {
                        this.f339k = b2;
                    } else if ("Age".equalsIgnoreCase(a)) {
                        this.f340l = e.a(b2, -1);
                    }
                }
            }
        }

        private static boolean a(y yVar) {
            return (yVar.a("If-Modified-Since") == null && yVar.a("If-None-Match") == null) ? false : true;
        }

        private long b() {
            Date date = this.f332d;
            long max = date != null ? Math.max(0L, this.f338j - date.getTime()) : 0L;
            int i2 = this.f340l;
            if (i2 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i2));
            }
            long j2 = this.f338j;
            return max + (j2 - this.f337i) + (this.a - j2);
        }

        private long c() {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d j2 = this.f331c.j();
            if (j2.d() != -1) {
                return TimeUnit.SECONDS.toMillis(j2.d());
            }
            if (this.f336h != null) {
                Date date = this.f332d;
                long time = this.f336h.getTime() - (date != null ? date.getTime() : this.f338j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            } else if (this.f334f == null || this.f331c.s().g().k() != null) {
                return 0L;
            } else {
                Date date2 = this.f332d;
                long time2 = (date2 != null ? date2.getTime() : this.f337i) - this.f334f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        private c d() {
            if (this.f331c == null) {
                return new c(this.b, null);
            }
            if ((!this.b.d() || this.f331c.l() != null) && c.a(this.f331c, this.b)) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d b = this.b.b();
                if (b.h() || a(this.b)) {
                    return new c(this.b, null);
                }
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d j2 = this.f331c.j();
                if (j2.a()) {
                    return new c(null, this.f331c);
                }
                long b2 = b();
                long c2 = c();
                if (b.d() != -1) {
                    c2 = Math.min(c2, TimeUnit.SECONDS.toMillis(b.d()));
                }
                long j3 = 0;
                long millis = b.f() != -1 ? TimeUnit.SECONDS.toMillis(b.f()) : 0L;
                if (!j2.g() && b.e() != -1) {
                    j3 = TimeUnit.SECONDS.toMillis(b.e());
                }
                if (!j2.h()) {
                    long j4 = millis + b2;
                    if (j4 < j3 + c2) {
                        a0.a p = this.f331c.p();
                        if (j4 >= c2) {
                            p.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (b2 > 86400000 && e()) {
                            p.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new c(null, p.a());
                    }
                }
                String str = this.f339k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.f334f != null) {
                    str = this.f335g;
                } else if (this.f332d == null) {
                    return new c(this.b, null);
                } else {
                    str = this.f333e;
                }
                r.a a = this.b.c().a();
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(a, str2, str);
                return new c(this.b.f().a(a.a()).a(), this.f331c);
            }
            return new c(this.b, null);
        }

        private boolean e() {
            return this.f331c.j().d() == -1 && this.f336h == null;
        }

        public c a() {
            c d2 = d();
            return (d2.a == null || !this.b.b().j()) ? d2 : new c(null, null);
        }
    }

    public c(y yVar, a0 a0Var) {
        this.a = yVar;
        this.b = a0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0055, code lost:
        if (r2.j().b() == false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x006d A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0 r2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y r3) {
        /*
            int r0 = r2.k()
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 == r1) goto L57
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L57
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L57
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L57
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L57
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L57
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L30
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L57
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L57
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L57
            switch(r0) {
                case 300: goto L57;
                case 301: goto L57;
                case 302: goto L30;
                default: goto L2f;
            }
        L2f:
            goto L6d
        L30:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r2.b(r0)
            if (r0 != 0) goto L57
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r0 = r2.j()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L57
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r0 = r2.j()
            boolean r0 = r0.c()
            if (r0 != 0) goto L57
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r0 = r2.j()
            boolean r0 = r0.b()
            if (r0 == 0) goto L6d
        L57:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r2 = r2.j()
            boolean r2 = r2.i()
            if (r2 != 0) goto L6d
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d r2 = r3.b()
            boolean r2 = r2.i()
            if (r2 != 0) goto L6d
            r2 = 1
            goto L6e
        L6d:
            r2 = 0
        L6e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.c.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y):boolean");
    }
}
