package h.p2.b0.g.t.g;

import h.k2.u.l;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt___ArraysKt;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: e  reason: collision with root package name */
    private static final f f15414e = f.i("<root>");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f15415f = Pattern.compile("\\.");

    /* renamed from: g  reason: collision with root package name */
    private static final l<String, f> f15416g = new a();
    @k.e.a.d
    private final String a;
    private transient c b;

    /* renamed from: c  reason: collision with root package name */
    private transient d f15417c;

    /* renamed from: d  reason: collision with root package name */
    private transient f f15418d;

    /* loaded from: classes3.dex */
    public static class a implements l<String, f> {
        @Override // h.k2.u.l
        /* renamed from: a */
        public f invoke(String str) {
            return f.e(str);
        }
    }

    public d(@k.e.a.d String str, @k.e.a.d c cVar) {
        if (str == null) {
            a(0);
        }
        if (cVar == null) {
            a(1);
        }
        this.a = str;
        this.b = cVar;
    }

    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i3 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        if (i2 != 1) {
            switch (i2) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i2) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(format);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    private void d() {
        int lastIndexOf = this.a.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.f15418d = f.e(this.a.substring(lastIndexOf + 1));
            this.f15417c = new d(this.a.substring(0, lastIndexOf));
            return;
        }
        this.f15418d = f.e(this.a);
        this.f15417c = c.f15413c.j();
    }

    @k.e.a.d
    public static d m(@k.e.a.d f fVar) {
        if (fVar == null) {
            a(16);
        }
        return new d(fVar.b(), c.f15413c.j(), fVar);
    }

    @k.e.a.d
    public String b() {
        String str = this.a;
        if (str == null) {
            a(4);
        }
        return str;
    }

    @k.e.a.d
    public d c(@k.e.a.d f fVar) {
        String str;
        if (fVar == null) {
            a(9);
        }
        if (e()) {
            str = fVar.b();
        } else {
            str = this.a + "." + fVar.b();
        }
        return new d(str, this, fVar);
    }

    public boolean e() {
        return this.a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.a.equals(((d) obj).a);
    }

    public boolean f() {
        return this.b != null || b().indexOf(60) < 0;
    }

    @k.e.a.d
    public d g() {
        d dVar = this.f15417c;
        if (dVar != null) {
            if (dVar == null) {
                a(7);
            }
            return dVar;
        } else if (!e()) {
            d();
            d dVar2 = this.f15417c;
            if (dVar2 == null) {
                a(8);
            }
            return dVar2;
        } else {
            throw new IllegalStateException("root");
        }
    }

    @k.e.a.d
    public List<f> h() {
        List<f> emptyList = e() ? Collections.emptyList() : ArraysKt___ArraysKt.Kh(f15415f.split(this.a), f15416g);
        if (emptyList == null) {
            a(14);
        }
        return emptyList;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @k.e.a.d
    public f i() {
        f fVar = this.f15418d;
        if (fVar != null) {
            if (fVar == null) {
                a(10);
            }
            return fVar;
        } else if (!e()) {
            d();
            f fVar2 = this.f15418d;
            if (fVar2 == null) {
                a(11);
            }
            return fVar2;
        } else {
            throw new IllegalStateException("root");
        }
    }

    @k.e.a.d
    public f j() {
        if (e()) {
            f fVar = f15414e;
            if (fVar == null) {
                a(12);
            }
            return fVar;
        }
        f i2 = i();
        if (i2 == null) {
            a(13);
        }
        return i2;
    }

    public boolean k(@k.e.a.d f fVar) {
        if (fVar == null) {
            a(15);
        }
        if (e()) {
            return false;
        }
        int indexOf = this.a.indexOf(46);
        String str = this.a;
        String b = fVar.b();
        if (indexOf == -1) {
            indexOf = this.a.length();
        }
        return str.regionMatches(0, b, 0, indexOf);
    }

    @k.e.a.d
    public c l() {
        c cVar = this.b;
        if (cVar != null) {
            if (cVar == null) {
                a(5);
            }
            return cVar;
        }
        c cVar2 = new c(this);
        this.b = cVar2;
        if (cVar2 == null) {
            a(6);
        }
        return cVar2;
    }

    @k.e.a.d
    public String toString() {
        String b = e() ? f15414e.b() : this.a;
        if (b == null) {
            a(17);
        }
        return b;
    }

    public d(@k.e.a.d String str) {
        if (str == null) {
            a(2);
        }
        this.a = str;
    }

    private d(@k.e.a.d String str, d dVar, f fVar) {
        if (str == null) {
            a(3);
        }
        this.a = str;
        this.f15417c = dVar;
        this.f15418d = fVar;
    }
}
