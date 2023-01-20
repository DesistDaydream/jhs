package kotlin.reflect.jvm.internal.impl.descriptors;

import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.w;
import java.util.Collection;
import k.e.a.d;

/* loaded from: classes3.dex */
public interface CallableMemberDescriptor extends a, w {

    /* loaded from: classes3.dex */
    public enum Kind {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean isReal() {
            return this != FAKE_OVERRIDE;
        }
    }

    void A0(@d Collection<? extends CallableMemberDescriptor> collection);

    @d
    CallableMemberDescriptor P(k kVar, Modality modality, s sVar, Kind kind, boolean z);

    @Override // h.p2.b0.g.t.c.a, h.p2.b0.g.t.c.k
    @d
    CallableMemberDescriptor a();

    @Override // h.p2.b0.g.t.c.a
    @d
    Collection<? extends CallableMemberDescriptor> d();

    @d
    Kind i();
}
