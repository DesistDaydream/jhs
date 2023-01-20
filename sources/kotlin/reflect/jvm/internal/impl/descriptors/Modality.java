package kotlin.reflect.jvm.internal.impl.descriptors;

import h.k2.v.u;
import k.e.a.d;

/* loaded from: classes3.dex */
public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;
    
    @d
    public static final a Companion = new a(null);

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final Modality a(boolean z, boolean z2, boolean z3) {
            if (z) {
                return Modality.SEALED;
            }
            if (z2) {
                return Modality.ABSTRACT;
            }
            if (z3) {
                return Modality.OPEN;
            }
            return Modality.FINAL;
        }
    }
}
