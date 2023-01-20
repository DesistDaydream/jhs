package h.p2.b0.g.t.l.b;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class u {

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f15542c;

        static {
            int[] iArr = new int[ProtoBuf.MemberKind.values().length];
            iArr[ProtoBuf.MemberKind.DECLARATION.ordinal()] = 1;
            iArr[ProtoBuf.MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
            iArr[ProtoBuf.MemberKind.DELEGATION.ordinal()] = 3;
            iArr[ProtoBuf.MemberKind.SYNTHESIZED.ordinal()] = 4;
            a = iArr;
            int[] iArr2 = new int[CallableMemberDescriptor.Kind.values().length];
            iArr2[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;
            iArr2[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;
            iArr2[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;
            iArr2[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;
            b = iArr2;
            int[] iArr3 = new int[ProtoBuf.Visibility.values().length];
            iArr3[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;
            iArr3[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;
            iArr3[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;
            iArr3[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;
            iArr3[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;
            f15542c = iArr3;
        }
    }

    @k.e.a.d
    public static final h.p2.b0.g.t.c.s a(@k.e.a.d t tVar, @k.e.a.e ProtoBuf.Visibility visibility) {
        switch (visibility == null ? -1 : a.f15542c[visibility.ordinal()]) {
            case 1:
                return h.p2.b0.g.t.c.r.f15210d;
            case 2:
                return h.p2.b0.g.t.c.r.a;
            case 3:
                return h.p2.b0.g.t.c.r.b;
            case 4:
                return h.p2.b0.g.t.c.r.f15209c;
            case 5:
                return h.p2.b0.g.t.c.r.f15211e;
            case 6:
                return h.p2.b0.g.t.c.r.f15212f;
            default:
                return h.p2.b0.g.t.c.r.a;
        }
    }

    @k.e.a.d
    public static final CallableMemberDescriptor.Kind b(@k.e.a.d t tVar, @k.e.a.e ProtoBuf.MemberKind memberKind) {
        int i2 = memberKind == null ? -1 : a.a[memberKind.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return CallableMemberDescriptor.Kind.DECLARATION;
                    }
                    return CallableMemberDescriptor.Kind.SYNTHESIZED;
                }
                return CallableMemberDescriptor.Kind.DELEGATION;
            }
            return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
        }
        return CallableMemberDescriptor.Kind.DECLARATION;
    }
}
