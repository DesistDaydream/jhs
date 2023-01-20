package h.p2.b0.g.t.l.b;

import h.k2.v.f0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class t {
    @k.e.a.d
    public static final t a = new t();

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f15536c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f15537d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ int[] f15538e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ int[] f15539f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ int[] f15540g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ int[] f15541h;

        static {
            int[] iArr = new int[ProtoBuf.Modality.values().length];
            iArr[ProtoBuf.Modality.FINAL.ordinal()] = 1;
            iArr[ProtoBuf.Modality.OPEN.ordinal()] = 2;
            iArr[ProtoBuf.Modality.ABSTRACT.ordinal()] = 3;
            iArr[ProtoBuf.Modality.SEALED.ordinal()] = 4;
            a = iArr;
            int[] iArr2 = new int[Modality.values().length];
            iArr2[Modality.FINAL.ordinal()] = 1;
            iArr2[Modality.OPEN.ordinal()] = 2;
            iArr2[Modality.ABSTRACT.ordinal()] = 3;
            iArr2[Modality.SEALED.ordinal()] = 4;
            b = iArr2;
            int[] iArr3 = new int[ProtoBuf.Visibility.values().length];
            iArr3[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;
            iArr3[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;
            iArr3[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;
            iArr3[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;
            iArr3[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;
            f15536c = iArr3;
            int[] iArr4 = new int[ProtoBuf.Class.Kind.values().length];
            iArr4[ProtoBuf.Class.Kind.CLASS.ordinal()] = 1;
            iArr4[ProtoBuf.Class.Kind.INTERFACE.ordinal()] = 2;
            iArr4[ProtoBuf.Class.Kind.ENUM_CLASS.ordinal()] = 3;
            iArr4[ProtoBuf.Class.Kind.ENUM_ENTRY.ordinal()] = 4;
            iArr4[ProtoBuf.Class.Kind.ANNOTATION_CLASS.ordinal()] = 5;
            iArr4[ProtoBuf.Class.Kind.OBJECT.ordinal()] = 6;
            iArr4[ProtoBuf.Class.Kind.COMPANION_OBJECT.ordinal()] = 7;
            f15537d = iArr4;
            int[] iArr5 = new int[ClassKind.values().length];
            iArr5[ClassKind.CLASS.ordinal()] = 1;
            iArr5[ClassKind.INTERFACE.ordinal()] = 2;
            iArr5[ClassKind.ENUM_CLASS.ordinal()] = 3;
            iArr5[ClassKind.ENUM_ENTRY.ordinal()] = 4;
            iArr5[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
            iArr5[ClassKind.OBJECT.ordinal()] = 6;
            f15538e = iArr5;
            int[] iArr6 = new int[ProtoBuf.TypeParameter.Variance.values().length];
            iArr6[ProtoBuf.TypeParameter.Variance.IN.ordinal()] = 1;
            iArr6[ProtoBuf.TypeParameter.Variance.OUT.ordinal()] = 2;
            iArr6[ProtoBuf.TypeParameter.Variance.INV.ordinal()] = 3;
            f15539f = iArr6;
            int[] iArr7 = new int[ProtoBuf.Type.Argument.Projection.values().length];
            iArr7[ProtoBuf.Type.Argument.Projection.IN.ordinal()] = 1;
            iArr7[ProtoBuf.Type.Argument.Projection.OUT.ordinal()] = 2;
            iArr7[ProtoBuf.Type.Argument.Projection.INV.ordinal()] = 3;
            iArr7[ProtoBuf.Type.Argument.Projection.STAR.ordinal()] = 4;
            f15540g = iArr7;
            int[] iArr8 = new int[Variance.values().length];
            iArr8[Variance.IN_VARIANCE.ordinal()] = 1;
            iArr8[Variance.OUT_VARIANCE.ordinal()] = 2;
            iArr8[Variance.INVARIANT.ordinal()] = 3;
            f15541h = iArr8;
        }
    }

    private t() {
    }

    @k.e.a.d
    public final ClassKind a(@k.e.a.e ProtoBuf.Class.Kind kind) {
        switch (kind == null ? -1 : a.f15537d[kind.ordinal()]) {
            case 1:
                return ClassKind.CLASS;
            case 2:
                return ClassKind.INTERFACE;
            case 3:
                return ClassKind.ENUM_CLASS;
            case 4:
                return ClassKind.ENUM_ENTRY;
            case 5:
                return ClassKind.ANNOTATION_CLASS;
            case 6:
            case 7:
                return ClassKind.OBJECT;
            default:
                return ClassKind.CLASS;
        }
    }

    @k.e.a.d
    public final Modality b(@k.e.a.e ProtoBuf.Modality modality) {
        int i2 = modality == null ? -1 : a.a[modality.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return Modality.FINAL;
                    }
                    return Modality.SEALED;
                }
                return Modality.ABSTRACT;
            }
            return Modality.OPEN;
        }
        return Modality.FINAL;
    }

    @k.e.a.d
    public final Variance c(@k.e.a.d ProtoBuf.Type.Argument.Projection projection) {
        int i2 = a.f15540g[projection.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    throw new IllegalArgumentException(f0.C("Only IN, OUT and INV are supported. Actual argument: ", projection));
                }
                return Variance.INVARIANT;
            }
            return Variance.OUT_VARIANCE;
        }
        return Variance.IN_VARIANCE;
    }

    @k.e.a.d
    public final Variance d(@k.e.a.d ProtoBuf.TypeParameter.Variance variance) {
        int i2 = a.f15539f[variance.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return Variance.INVARIANT;
                }
                throw new NoWhenBranchMatchedException();
            }
            return Variance.OUT_VARIANCE;
        }
        return Variance.IN_VARIANCE;
    }
}
