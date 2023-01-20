package k.a.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes4.dex */
public class f {
    private final g a;
    private final d b;

    /* loaded from: classes4.dex */
    public static class b {
        private final g a;
        private final f b;

        public b a(String str) {
            this.b.f(str);
            return this;
        }

        public b b(Collection<String> collection) {
            this.b.g(collection);
            return this;
        }

        public b c(String... strArr) {
            this.b.h(strArr);
            return this;
        }

        public f d() {
            this.b.k();
            return this.b;
        }

        public b e() {
            return f();
        }

        public b f() {
            this.a.g(true);
            return this;
        }

        public b g() {
            this.a.f(false);
            return this;
        }

        public b h() {
            this.a.h(true);
            return this;
        }

        public b i() {
            this.a.i(true);
            return this;
        }

        public b j() {
            return g();
        }

        public b k() {
            this.b.a.j(true);
            return this;
        }

        private b() {
            g gVar = new g();
            this.a = gVar;
            this.b = new f(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        if (str.isEmpty()) {
            return;
        }
        if (r()) {
            str = str.toLowerCase();
        }
        i(str).a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Collection<String> collection) {
        for (String str : collection) {
            f(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String[] strArr) {
        for (String str : strArr) {
            f(str);
        }
    }

    private d i(String str) {
        return p().d(str);
    }

    public static b j() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        d p = p();
        for (d dVar : p.h()) {
            dVar.m(p);
            linkedBlockingDeque.add(dVar);
        }
        while (!linkedBlockingDeque.isEmpty()) {
            d dVar2 = (d) linkedBlockingDeque.remove();
            for (Character ch : dVar2.i()) {
                d j2 = dVar2.j(ch);
                linkedBlockingDeque.add(j2);
                d f2 = dVar2.f();
                while (f2.j(ch) == null) {
                    f2 = f2.f();
                }
                d j3 = f2.j(ch);
                j2.m(j3);
                j2.b(j3.e());
            }
        }
    }

    private e m(k.a.b.a aVar, String str, int i2) {
        return new k.a.b.b(str.substring(i2 + 1, aVar == null ? str.length() : aVar.getStart()));
    }

    private e n(k.a.b.a aVar, String str) {
        return new c(str.substring(aVar.getStart(), aVar.H() + 1), aVar);
    }

    private d p() {
        return this.b;
    }

    private d q(d dVar, Character ch) {
        d j2 = dVar.j(ch);
        while (j2 == null) {
            dVar = dVar.f();
            j2 = dVar.j(ch);
        }
        return j2;
    }

    private boolean r() {
        return this.a.b();
    }

    private boolean s(CharSequence charSequence, k.a.b.a aVar) {
        if (aVar.getStart() == 0 || !Character.isAlphabetic(charSequence.charAt(aVar.getStart() - 1))) {
            return aVar.H() + 1 != charSequence.length() && Character.isAlphabetic(charSequence.charAt(aVar.H() + 1));
        }
        return true;
    }

    private void w(CharSequence charSequence, List<k.a.b.a> list) {
        ArrayList<k.a.b.a> arrayList = new ArrayList();
        for (k.a.b.a aVar : list) {
            if (s(charSequence, aVar)) {
                arrayList.add(aVar);
            }
        }
        for (k.a.b.a aVar2 : arrayList) {
            list.remove(aVar2);
        }
    }

    private void x(CharSequence charSequence, List<k.a.b.a> list) {
        long length = charSequence.length();
        ArrayList<k.a.b.a> arrayList = new ArrayList();
        for (k.a.b.a aVar : list) {
            if ((aVar.getStart() != 0 && !Character.isWhitespace(charSequence.charAt(aVar.getStart() - 1))) || (aVar.H() + 1 != length && !Character.isWhitespace(charSequence.charAt(aVar.H() + 1)))) {
                arrayList.add(aVar);
            }
        }
        for (k.a.b.a aVar2 : arrayList) {
            list.remove(aVar2);
        }
    }

    private boolean y(int i2, d dVar, k.a.b.h.c cVar) {
        Collection<String> e2 = dVar.e();
        if (e2 == null || e2.isEmpty()) {
            return false;
        }
        boolean z = false;
        for (String str : e2) {
            z = cVar.b(new k.a.b.a((i2 - str.length()) + 1, i2, str)) || z;
            if (z && this.a.e()) {
                break;
            }
        }
        return z;
    }

    public boolean l(CharSequence charSequence) {
        return o(charSequence) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public k.a.b.a o(java.lang.CharSequence r7) {
        /*
            r6 = this;
            k.a.b.g r0 = r6.a
            boolean r0 = r0.a()
            if (r0 != 0) goto L1f
            java.util.Collection r7 = r6.t(r7)
            if (r7 == 0) goto L85
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L85
            java.util.Iterator r7 = r7.iterator()
            java.lang.Object r7 = r7.next()
            k.a.b.a r7 = (k.a.b.a) r7
            return r7
        L1f:
            k.a.b.d r0 = r6.p()
            r1 = 0
        L24:
            int r2 = r7.length()
            if (r1 >= r2) goto L85
            char r2 = r7.charAt(r1)
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            k.a.b.g r3 = r6.a
            boolean r3 = r3.b()
            if (r3 == 0) goto L46
            char r2 = r2.charValue()
            char r2 = java.lang.Character.toLowerCase(r2)
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
        L46:
            k.a.b.d r0 = r6.q(r0, r2)
            java.util.Collection r2 = r0.e()
            if (r2 == 0) goto L82
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L82
            java.util.Iterator r2 = r2.iterator()
        L5a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L82
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            k.a.b.a r4 = new k.a.b.a
            int r5 = r3.length()
            int r5 = r1 - r5
            int r5 = r5 + 1
            r4.<init>(r5, r1, r3)
            k.a.b.g r3 = r6.a
            boolean r3 = r3.c()
            if (r3 == 0) goto L81
            boolean r3 = r6.s(r7, r4)
            if (r3 != 0) goto L5a
        L81:
            return r4
        L82:
            int r1 = r1 + 1
            goto L24
        L85:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.b.f.o(java.lang.CharSequence):k.a.b.a");
    }

    public Collection<k.a.b.a> t(CharSequence charSequence) {
        return u(charSequence, new k.a.b.h.b());
    }

    public Collection<k.a.b.a> u(CharSequence charSequence, k.a.b.h.d dVar) {
        v(charSequence, dVar);
        List<k.a.b.a> a2 = dVar.a();
        if (this.a.c()) {
            w(charSequence, a2);
        }
        if (this.a.d()) {
            x(charSequence, a2);
        }
        if (!this.a.a()) {
            new k.a.a.b(a2).b(a2);
        }
        return a2;
    }

    public void v(CharSequence charSequence, k.a.b.h.c cVar) {
        d p = p();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            Character valueOf = Character.valueOf(charSequence.charAt(i2));
            if (this.a.b()) {
                valueOf = Character.valueOf(Character.toLowerCase(valueOf.charValue()));
            }
            p = q(p, valueOf);
            if (y(i2, p, cVar) && this.a.e()) {
                return;
            }
        }
    }

    public Collection<e> z(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (k.a.b.a aVar : t(str)) {
            if (aVar.getStart() - i2 > 1) {
                arrayList.add(m(aVar, str, i2));
            }
            arrayList.add(n(aVar, str));
            i2 = aVar.H();
        }
        if (str.length() - i2 > 1) {
            arrayList.add(m(null, str, i2));
        }
        return arrayList;
    }

    private f(g gVar) {
        this.a = gVar;
        this.b = new d();
    }
}
