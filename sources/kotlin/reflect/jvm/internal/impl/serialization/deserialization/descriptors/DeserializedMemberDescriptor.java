package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.p2.b0.g.t.c.t;
import h.p2.b0.g.t.c.w;
import h.p2.b0.g.t.f.z.c;
import h.p2.b0.g.t.f.z.g;
import h.p2.b0.g.t.f.z.h;
import h.p2.b0.g.t.f.z.i;
import h.p2.b0.g.t.i.n;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes3.dex */
public interface DeserializedMemberDescriptor extends t, w, h.p2.b0.g.t.l.b.x.a {

    /* loaded from: classes3.dex */
    public enum CoroutinesCompatibilityMode {
        COMPATIBLE,
        NEEDS_WRAPPER,
        INCOMPATIBLE
    }

    /* loaded from: classes3.dex */
    public static final class a {
        @d
        public static List<h> a(@d DeserializedMemberDescriptor deserializedMemberDescriptor) {
            return h.f15398f.a(deserializedMemberDescriptor.d0(), deserializedMemberDescriptor.J(), deserializedMemberDescriptor.I());
        }
    }

    @d
    List<h> E0();

    @d
    g F();

    @d
    i I();

    @d
    c J();

    @e
    h.p2.b0.g.t.l.b.x.e K();

    @d
    n d0();
}
