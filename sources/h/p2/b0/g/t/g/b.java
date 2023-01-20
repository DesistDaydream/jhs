package h.p2.b0.g.t.g;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.tencent.android.tpns.mqtt.MqttTopic;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ boolean f15411d = false;
    private final c a;
    private final c b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f15412c;

    public b(@k.e.a.d c cVar, @k.e.a.d c cVar2, boolean z) {
        if (cVar == null) {
            a(1);
        }
        if (cVar2 == null) {
            a(2);
        }
        this.a = cVar;
        this.b = cVar2;
        this.f15412c = z;
    }

    private static /* synthetic */ void a(int i2) {
        String str = (i2 == 5 || i2 == 6 || i2 == 7 || i2 == 9 || i2 == 13 || i2 == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 5 || i2 == 6 || i2 == 7 || i2 == 9 || i2 == 13 || i2 == 14) ? 2 : 3];
        switch (i2) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = "string";
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i2 == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i2 == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i2 == 7) {
            objArr[1] = "getShortClassName";
        } else if (i2 == 9) {
            objArr[1] = "asSingleFqName";
        } else if (i2 == 13 || i2 == 14) {
            objArr[1] = "asString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 5 && i2 != 6 && i2 != 7 && i2 != 9 && i2 != 13 && i2 != 14) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @k.e.a.d
    public static b e(@k.e.a.d String str) {
        if (str == null) {
            a(11);
        }
        return f(str, false);
    }

    @k.e.a.d
    public static b f(@k.e.a.d String str, boolean z) {
        if (str == null) {
            a(12);
        }
        return new b(new c(StringsKt__StringsKt.v5(str, Attributes.InternalPrefix, "").replace(Attributes.InternalPrefix, '.')), new c(StringsKt__StringsKt.n5(str, Attributes.InternalPrefix, str)), z);
    }

    @k.e.a.d
    public static b m(@k.e.a.d c cVar) {
        if (cVar == null) {
            a(0);
        }
        return new b(cVar.e(), cVar.g());
    }

    @k.e.a.d
    public c b() {
        if (this.a.d()) {
            c cVar = this.b;
            if (cVar == null) {
                a(9);
            }
            return cVar;
        }
        return new c(this.a.b() + "." + this.b.b());
    }

    @k.e.a.d
    public String c() {
        if (this.a.d()) {
            String b = this.b.b();
            if (b == null) {
                a(13);
            }
            return b;
        }
        String str = this.a.b().replace('.', Attributes.InternalPrefix) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.b.b();
        if (str == null) {
            a(14);
        }
        return str;
    }

    @k.e.a.d
    public b d(@k.e.a.d f fVar) {
        if (fVar == null) {
            a(8);
        }
        return new b(h(), this.b.c(fVar), this.f15412c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.b.equals(bVar.b) && this.f15412c == bVar.f15412c;
    }

    @k.e.a.e
    public b g() {
        c e2 = this.b.e();
        if (e2.d()) {
            return null;
        }
        return new b(h(), e2, this.f15412c);
    }

    @k.e.a.d
    public c h() {
        c cVar = this.a;
        if (cVar == null) {
            a(5);
        }
        return cVar;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.valueOf(this.f15412c).hashCode();
    }

    @k.e.a.d
    public c i() {
        c cVar = this.b;
        if (cVar == null) {
            a(6);
        }
        return cVar;
    }

    @k.e.a.d
    public f j() {
        f g2 = this.b.g();
        if (g2 == null) {
            a(7);
        }
        return g2;
    }

    public boolean k() {
        return this.f15412c;
    }

    public boolean l() {
        return !this.b.e().d();
    }

    public String toString() {
        if (this.a.d()) {
            return MqttTopic.TOPIC_LEVEL_SEPARATOR + c();
        }
        return c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@k.e.a.d c cVar, @k.e.a.d f fVar) {
        this(cVar, c.k(fVar), false);
        if (cVar == null) {
            a(3);
        }
        if (fVar == null) {
            a(4);
        }
    }
}
