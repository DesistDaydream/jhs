package h.p2.b0.g.t.l.b;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public interface l {
    public static final l a = new a();

    /* loaded from: classes3.dex */
    public static class a implements l {
        private static /* synthetic */ void c(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "unresolvedSuperClasses";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            if (i2 != 2) {
                objArr[2] = "reportIncompleteHierarchy";
            } else {
                objArr[2] = "reportCannotInferVisibility";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.l.b.l
        public void a(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor) {
            if (callableMemberDescriptor == null) {
                c(2);
            }
        }

        @Override // h.p2.b0.g.t.l.b.l
        public void b(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d List<String> list) {
            if (dVar == null) {
                c(0);
            }
            if (list == null) {
                c(1);
            }
        }
    }

    void a(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor);

    void b(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d List<String> list);
}
