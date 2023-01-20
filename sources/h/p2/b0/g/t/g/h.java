package h.p2.b0.g.t.g;

/* loaded from: classes3.dex */
public class h {
    public static final f a = f.i("<no name provided>");
    public static final f b = f.i("<root package>");

    /* renamed from: c  reason: collision with root package name */
    public static final f f15419c = f.f("Companion");

    /* renamed from: d  reason: collision with root package name */
    public static final f f15420d = f.f("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");

    /* renamed from: e  reason: collision with root package name */
    public static final f f15421e = f.i("<anonymous>");

    private static /* synthetic */ void a(int i2) {
        String str = i2 != 1 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[i2 != 1 ? 2 : 3];
        if (i2 != 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        } else {
            objArr[0] = "name";
        }
        if (i2 != 1) {
            objArr[1] = "safeIdentifier";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        }
        if (i2 == 1) {
            objArr[2] = "isSafeIdentifier";
        }
        String format = String.format(str, objArr);
        if (i2 == 1) {
            throw new IllegalArgumentException(format);
        }
    }

    public static boolean b(@k.e.a.d f fVar) {
        if (fVar == null) {
            a(1);
        }
        return (fVar.b().isEmpty() || fVar.g()) ? false : true;
    }

    @k.e.a.d
    public static f c(@k.e.a.e f fVar) {
        if (fVar == null || fVar.g()) {
            fVar = f15420d;
        }
        if (fVar == null) {
            a(0);
        }
        return fVar;
    }
}
