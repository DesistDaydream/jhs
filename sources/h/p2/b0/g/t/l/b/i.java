package h.p2.b0.g.t.l.b;

import h.t2.y;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;

/* loaded from: classes3.dex */
public final class i {
    @k.e.a.d
    private final g a;
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.c b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final h.p2.b0.g.t.c.k f15517c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final h.p2.b0.g.t.f.z.g f15518d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final h.p2.b0.g.t.f.z.i f15519e;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private final h.p2.b0.g.t.f.z.a f15520f;
    @k.e.a.e

    /* renamed from: g  reason: collision with root package name */
    private final h.p2.b0.g.t.l.b.x.e f15521g;
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private final TypeDeserializer f15522h;
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    private final MemberDeserializer f15523i;

    public i(@k.e.a.d g gVar, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.f.z.g gVar2, @k.e.a.d h.p2.b0.g.t.f.z.i iVar, @k.e.a.d h.p2.b0.g.t.f.z.a aVar, @k.e.a.e h.p2.b0.g.t.l.b.x.e eVar, @k.e.a.e TypeDeserializer typeDeserializer, @k.e.a.d List<ProtoBuf.TypeParameter> list) {
        String a;
        this.a = gVar;
        this.b = cVar;
        this.f15517c = kVar;
        this.f15518d = gVar2;
        this.f15519e = iVar;
        this.f15520f = aVar;
        this.f15521g = eVar;
        this.f15522h = new TypeDeserializer(this, typeDeserializer, list, "Deserializer for \"" + kVar.getName() + y.a, (eVar == null || (a = eVar.a()) == null) ? "[container not found]" : a, false, 32, null);
        this.f15523i = new MemberDeserializer(this);
    }

    public static /* synthetic */ i b(i iVar, h.p2.b0.g.t.c.k kVar, List list, h.p2.b0.g.t.f.z.c cVar, h.p2.b0.g.t.f.z.g gVar, h.p2.b0.g.t.f.z.i iVar2, h.p2.b0.g.t.f.z.a aVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            cVar = iVar.b;
        }
        h.p2.b0.g.t.f.z.c cVar2 = cVar;
        if ((i2 & 8) != 0) {
            gVar = iVar.f15518d;
        }
        h.p2.b0.g.t.f.z.g gVar2 = gVar;
        if ((i2 & 16) != 0) {
            iVar2 = iVar.f15519e;
        }
        h.p2.b0.g.t.f.z.i iVar3 = iVar2;
        if ((i2 & 32) != 0) {
            aVar = iVar.f15520f;
        }
        return iVar.a(kVar, list, cVar2, gVar2, iVar3, aVar);
    }

    @k.e.a.d
    public final i a(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d List<ProtoBuf.TypeParameter> list, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.g gVar, @k.e.a.d h.p2.b0.g.t.f.z.i iVar, @k.e.a.d h.p2.b0.g.t.f.z.a aVar) {
        return new i(this.a, cVar, kVar, gVar, h.p2.b0.g.t.f.z.j.b(aVar) ? iVar : this.f15519e, aVar, this.f15521g, this.f15522h, list);
    }

    @k.e.a.d
    public final g c() {
        return this.a;
    }

    @k.e.a.e
    public final h.p2.b0.g.t.l.b.x.e d() {
        return this.f15521g;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.c.k e() {
        return this.f15517c;
    }

    @k.e.a.d
    public final MemberDeserializer f() {
        return this.f15523i;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.f.z.c g() {
        return this.b;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.m.m h() {
        return this.a.u();
    }

    @k.e.a.d
    public final TypeDeserializer i() {
        return this.f15522h;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.f.z.g j() {
        return this.f15518d;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.f.z.i k() {
        return this.f15519e;
    }
}
