package h.p2.b0.g.t.e.b;

import androidx.exifinterface.media.ExifInterface;
import h.k2.v.f0;
import h.p2.b0.g.t.e.b.h;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes3.dex */
public final class j implements i<h> {
    @k.e.a.d
    public static final j a = new j();

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            iArr[PrimitiveType.CHAR.ordinal()] = 2;
            iArr[PrimitiveType.BYTE.ordinal()] = 3;
            iArr[PrimitiveType.SHORT.ordinal()] = 4;
            iArr[PrimitiveType.INT.ordinal()] = 5;
            iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            iArr[PrimitiveType.LONG.ordinal()] = 7;
            iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            a = iArr;
        }
    }

    private j() {
    }

    @Override // h.p2.b0.g.t.e.b.i
    @k.e.a.d
    /* renamed from: g */
    public h b(@k.e.a.d h hVar) {
        if (hVar instanceof h.d) {
            h.d dVar = (h.d) hVar;
            return dVar.i() != null ? e(h.p2.b0.g.t.k.p.d.c(dVar.i().getWrapperFqName()).f()) : hVar;
        }
        return hVar;
    }

    @Override // h.p2.b0.g.t.e.b.i
    @k.e.a.d
    /* renamed from: h */
    public h a(@k.e.a.d String str) {
        JvmPrimitiveType jvmPrimitiveType;
        h cVar;
        str.length();
        char charAt = str.charAt(0);
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = values[i2];
            if (jvmPrimitiveType.getDesc().charAt(0) == charAt) {
                break;
            }
            i2++;
        }
        if (jvmPrimitiveType == null) {
            if (charAt == 'V') {
                return new h.d(null);
            }
            if (charAt == '[') {
                cVar = new h.a(a(str.substring(1)));
            } else {
                if (charAt == 'L') {
                    StringsKt__StringsKt.a3(str, ';', false, 2, null);
                }
                cVar = new h.c(str.substring(1, str.length() - 1));
            }
            return cVar;
        }
        return new h.d(jvmPrimitiveType);
    }

    @Override // h.p2.b0.g.t.e.b.i
    @k.e.a.d
    /* renamed from: i */
    public h.c e(@k.e.a.d String str) {
        return new h.c(str);
    }

    @Override // h.p2.b0.g.t.e.b.i
    @k.e.a.d
    /* renamed from: j */
    public h c(@k.e.a.d PrimitiveType primitiveType) {
        switch (a.a[primitiveType.ordinal()]) {
            case 1:
                return h.a.a();
            case 2:
                return h.a.c();
            case 3:
                return h.a.b();
            case 4:
                return h.a.h();
            case 5:
                return h.a.f();
            case 6:
                return h.a.e();
            case 7:
                return h.a.g();
            case 8:
                return h.a.d();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // h.p2.b0.g.t.e.b.i
    @k.e.a.d
    /* renamed from: k */
    public h f() {
        return e("java/lang/Class");
    }

    @Override // h.p2.b0.g.t.e.b.i
    @k.e.a.d
    /* renamed from: l */
    public String d(@k.e.a.d h hVar) {
        String desc;
        if (hVar instanceof h.a) {
            return f0.C("[", d(((h.a) hVar).i()));
        }
        if (hVar instanceof h.d) {
            JvmPrimitiveType i2 = ((h.d) hVar).i();
            return (i2 == null || (desc = i2.getDesc()) == null) ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : desc;
        } else if (hVar instanceof h.c) {
            return 'L' + ((h.c) hVar).i() + ';';
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
