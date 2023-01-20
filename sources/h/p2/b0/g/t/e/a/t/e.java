package h.p2.b0.g.t.e.a.t;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.qcloud.tuicore.TUIConstants;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.e.a.x.r;
import h.p2.b0.g.t.n.z;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public interface e {
    public static final e a = new a();

    /* loaded from: classes3.dex */
    public static class a implements e {
        private static /* synthetic */ void c(int i2) {
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = TUIConstants.TUIChat.OWNER;
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = PushConstants.MZ_PUSH_MESSAGE_METHOD;
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (i2 == 5 || i2 == 6) {
                objArr[2] = "reportSignatureErrors";
            } else {
                objArr[2] = "resolvePropagatedSignature";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.e.a.t.e
        @k.e.a.d
        public b a(@k.e.a.d r rVar, @k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d z zVar, @k.e.a.e z zVar2, @k.e.a.d List<v0> list, @k.e.a.d List<t0> list2) {
            if (rVar == null) {
                c(0);
            }
            if (dVar == null) {
                c(1);
            }
            if (zVar == null) {
                c(2);
            }
            if (list == null) {
                c(3);
            }
            if (list2 == null) {
                c(4);
            }
            return new b(zVar, zVar2, list, list2, Collections.emptyList(), false);
        }

        @Override // h.p2.b0.g.t.e.a.t.e
        public void b(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor, @k.e.a.d List<String> list) {
            if (callableMemberDescriptor == null) {
                c(5);
            }
            if (list == null) {
                c(6);
            }
            throw new UnsupportedOperationException("Should not be called");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        private final z a;
        private final z b;

        /* renamed from: c  reason: collision with root package name */
        private final List<v0> f15271c;

        /* renamed from: d  reason: collision with root package name */
        private final List<t0> f15272d;

        /* renamed from: e  reason: collision with root package name */
        private final List<String> f15273e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f15274f;

        public b(@k.e.a.d z zVar, @k.e.a.e z zVar2, @k.e.a.d List<v0> list, @k.e.a.d List<t0> list2, @k.e.a.d List<String> list3, boolean z) {
            if (zVar == null) {
                a(0);
            }
            if (list == null) {
                a(1);
            }
            if (list2 == null) {
                a(2);
            }
            if (list3 == null) {
                a(3);
            }
            this.a = zVar;
            this.b = zVar2;
            this.f15271c = list;
            this.f15272d = list2;
            this.f15273e = list3;
            this.f15274f = z;
        }

        private static /* synthetic */ void a(int i2) {
            String str = (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : 3];
            switch (i2) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            if (i2 == 4) {
                objArr[1] = "getReturnType";
            } else if (i2 == 5) {
                objArr[1] = "getValueParameters";
            } else if (i2 == 6) {
                objArr[1] = "getTypeParameters";
            } else if (i2 != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            } else {
                objArr[1] = "getErrors";
            }
            if (i2 != 4 && i2 != 5 && i2 != 6 && i2 != 7) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 != 4 && i2 != 5 && i2 != 6 && i2 != 7) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @k.e.a.d
        public List<String> b() {
            List<String> list = this.f15273e;
            if (list == null) {
                a(7);
            }
            return list;
        }

        @k.e.a.e
        public z c() {
            return this.b;
        }

        @k.e.a.d
        public z d() {
            z zVar = this.a;
            if (zVar == null) {
                a(4);
            }
            return zVar;
        }

        @k.e.a.d
        public List<t0> e() {
            List<t0> list = this.f15272d;
            if (list == null) {
                a(6);
            }
            return list;
        }

        @k.e.a.d
        public List<v0> f() {
            List<v0> list = this.f15271c;
            if (list == null) {
                a(5);
            }
            return list;
        }

        public boolean g() {
            return this.f15274f;
        }
    }

    @k.e.a.d
    b a(@k.e.a.d r rVar, @k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d z zVar, @k.e.a.e z zVar2, @k.e.a.d List<v0> list, @k.e.a.d List<t0> list2);

    void b(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor, @k.e.a.d List<String> list);
}
