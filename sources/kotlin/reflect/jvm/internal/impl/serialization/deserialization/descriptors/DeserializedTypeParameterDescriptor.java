package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.a2.u;
import h.k2.v.f0;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.d1.b;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.r0;
import h.p2.b0.g.t.f.z.f;
import h.p2.b0.g.t.l.b.i;
import h.p2.b0.g.t.l.b.q;
import h.p2.b0.g.t.l.b.t;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;

/* loaded from: classes3.dex */
public final class DeserializedTypeParameterDescriptor extends b {
    @d

    /* renamed from: k  reason: collision with root package name */
    private final i f16846k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final ProtoBuf.TypeParameter f16847l;
    @d

    /* renamed from: m  reason: collision with root package name */
    private final h.p2.b0.g.t.l.b.x.b f16848m;

    public DeserializedTypeParameterDescriptor(@d i iVar, @d ProtoBuf.TypeParameter typeParameter, int i2) {
        super(iVar.h(), iVar.e(), e.w0.b(), q.b(iVar.g(), typeParameter.getName()), t.a.d(typeParameter.getVariance()), typeParameter.getReified(), i2, o0.a, r0.a.a);
        this.f16846k = iVar;
        this.f16847l = typeParameter;
        this.f16848m = new h.p2.b0.g.t.l.b.x.b(iVar.h(), new DeserializedTypeParameterDescriptor$annotations$1(this));
    }

    @Override // h.p2.b0.g.t.c.d1.d
    @d
    public List<z> H0() {
        List<ProtoBuf.Type> o = f.o(this.f16847l, this.f16846k.j());
        if (o.isEmpty()) {
            return h.a2.t.k(DescriptorUtilsKt.g(this).y());
        }
        TypeDeserializer i2 = this.f16846k.i();
        ArrayList arrayList = new ArrayList(u.Y(o, 10));
        for (ProtoBuf.Type type : o) {
            arrayList.add(i2.p(type));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.c.b1.b, h.p2.b0.g.t.c.b1.a
    @d
    /* renamed from: J0 */
    public h.p2.b0.g.t.l.b.x.b getAnnotations() {
        return this.f16848m;
    }

    @d
    public final ProtoBuf.TypeParameter K0() {
        return this.f16847l;
    }

    @Override // h.p2.b0.g.t.c.d1.d
    @d
    /* renamed from: L0 */
    public Void G0(@d z zVar) {
        throw new IllegalStateException(f0.C("There should be no cycles for deserialized type parameters, but found for: ", this));
    }
}
