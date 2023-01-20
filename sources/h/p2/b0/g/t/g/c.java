package h.p2.b0.g.t.g;

import java.util.List;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    public static final c f15413c = new c("");
    @k.e.a.d
    private final d a;
    private transient c b;

    public c(@k.e.a.d String str) {
        if (str == null) {
            a(1);
        }
        this.a = new d(str, this);
    }

    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i3 = 2;
                break;
            case 8:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(format);
            case 8:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @k.e.a.d
    public static c k(@k.e.a.d f fVar) {
        if (fVar == null) {
            a(13);
        }
        return new c(d.m(fVar));
    }

    @k.e.a.d
    public String b() {
        String b = this.a.b();
        if (b == null) {
            a(4);
        }
        return b;
    }

    @k.e.a.d
    public c c(@k.e.a.d f fVar) {
        if (fVar == null) {
            a(8);
        }
        return new c(this.a.c(fVar), this);
    }

    public boolean d() {
        return this.a.e();
    }

    @k.e.a.d
    public c e() {
        c cVar = this.b;
        if (cVar != null) {
            if (cVar == null) {
                a(6);
            }
            return cVar;
        } else if (!d()) {
            c cVar2 = new c(this.a.g());
            this.b = cVar2;
            if (cVar2 == null) {
                a(7);
            }
            return cVar2;
        } else {
            throw new IllegalStateException("root");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.a.equals(((c) obj).a);
    }

    @k.e.a.d
    public List<f> f() {
        List<f> h2 = this.a.h();
        if (h2 == null) {
            a(11);
        }
        return h2;
    }

    @k.e.a.d
    public f g() {
        f i2 = this.a.i();
        if (i2 == null) {
            a(9);
        }
        return i2;
    }

    @k.e.a.d
    public f h() {
        f j2 = this.a.j();
        if (j2 == null) {
            a(10);
        }
        return j2;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean i(@k.e.a.d f fVar) {
        if (fVar == null) {
            a(12);
        }
        return this.a.k(fVar);
    }

    @k.e.a.d
    public d j() {
        d dVar = this.a;
        if (dVar == null) {
            a(5);
        }
        return dVar;
    }

    public String toString() {
        return this.a.toString();
    }

    public c(@k.e.a.d d dVar) {
        if (dVar == null) {
            a(2);
        }
        this.a = dVar;
    }

    private c(@k.e.a.d d dVar, c cVar) {
        if (dVar == null) {
            a(3);
        }
        this.a = dVar;
        this.b = cVar;
    }
}
