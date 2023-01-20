package e.i.b.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class c {
    public static k.a.b.f a;
    public static j b;

    /* renamed from: c  reason: collision with root package name */
    public static List<h> f10067c;

    /* loaded from: classes.dex */
    public static final class b {
        public j a;
        public List<h> b;

        public List<h> a() {
            return this.b;
        }

        public j b() {
            return this.a;
        }

        public boolean c() {
            return (a() == null || b() == null) ? false : true;
        }

        public b d(h hVar) {
            if (hVar != null) {
                List<h> list = this.b;
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    this.b = arrayList;
                    arrayList.add(hVar);
                } else if (!list.contains(hVar)) {
                    this.b.add(hVar);
                }
            }
            return this;
        }

        private b(List<h> list) {
            if (list != null) {
                this.b = new ArrayList(list);
            }
            this.a = new e.i.b.a.b();
        }
    }

    private c() {
    }

    public static void a(h hVar) {
        if (hVar == null || hVar.a() == null || hVar.a().size() == 0) {
            return;
        }
        d(new b(f10067c).d(hVar));
    }

    private static short b(byte[] bArr, byte[] bArr2, int i2) {
        int i3 = i2 % 8;
        short s = (short) (bArr2[i2] & 255);
        return (bArr[i2 / 8] & g.f10072g[i3]) != 0 ? (short) (s | 256) : s;
    }

    private static int c(char c2) {
        int i2 = c2 - 19968;
        if (i2 < 0 || i2 >= 7000) {
            if (7000 <= i2 && i2 < 14000) {
                return b(e.a, e.b, i2 - g.f10070e);
            }
            return b(f.a, f.b, i2 - g.f10071f);
        }
        return b(d.a, d.b, i2);
    }

    public static void d(b bVar) {
        if (bVar == null) {
            f10067c = null;
            a = null;
            b = null;
        } else if (bVar.c()) {
            f10067c = Collections.unmodifiableList(bVar.a());
            a = k.a(bVar.a());
            b = bVar.b();
        }
    }

    public static boolean e(char c2) {
        return (19968 <= c2 && c2 <= 40869 && c(c2) > 0) || 12295 == c2;
    }

    public static b f() {
        return new b(null);
    }

    public static String g(char c2) {
        if (e(c2)) {
            return c2 == 12295 ? g.f10068c : g.f10074i[c(c2)];
        }
        return String.valueOf(c2);
    }

    public static String h(String str, String str2) {
        return e.i.b.a.a.b(str, a, f10067c, str2, b);
    }
}
