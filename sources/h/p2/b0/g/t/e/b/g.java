package h.p2.b0.g.t.e.b;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import h.p2.b0.g.t.c.p0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes3.dex */
public final class g implements h.p2.b0.g.t.l.b.x.e {
    @k.e.a.d
    private final h.p2.b0.g.t.k.p.d b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private final h.p2.b0.g.t.k.p.d f15318c;
    @k.e.a.e

    /* renamed from: d  reason: collision with root package name */
    private final h.p2.b0.g.t.l.b.n<h.p2.b0.g.t.f.a0.f.e> f15319d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f15320e;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private final DeserializedContainerAbiStability f15321f;
    @k.e.a.e

    /* renamed from: g  reason: collision with root package name */
    private final m f15322g;
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private final String f15323h;

    public g(@k.e.a.d h.p2.b0.g.t.k.p.d dVar, @k.e.a.e h.p2.b0.g.t.k.p.d dVar2, @k.e.a.d ProtoBuf.Package r3, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.e h.p2.b0.g.t.l.b.n<h.p2.b0.g.t.f.a0.f.e> nVar, boolean z, @k.e.a.d DeserializedContainerAbiStability deserializedContainerAbiStability, @k.e.a.e m mVar) {
        String string;
        this.b = dVar;
        this.f15318c = dVar2;
        this.f15319d = nVar;
        this.f15320e = z;
        this.f15321f = deserializedContainerAbiStability;
        this.f15322g = mVar;
        Integer num = (Integer) h.p2.b0.g.t.f.z.e.a(r3, JvmProtoBuf.f16714m);
        String str = "main";
        if (num != null && (string = cVar.getString(num.intValue())) != null) {
            str = string;
        }
        this.f15323h = str;
    }

    @Override // h.p2.b0.g.t.l.b.x.e
    @k.e.a.d
    public String a() {
        return "Class '" + d().b().b() + '\'';
    }

    @Override // h.p2.b0.g.t.c.o0
    @k.e.a.d
    public p0 b() {
        return p0.a;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.g.b d() {
        return new h.p2.b0.g.t.g.b(this.b.g(), g());
    }

    @k.e.a.e
    public final h.p2.b0.g.t.k.p.d e() {
        return this.f15318c;
    }

    @k.e.a.e
    public final m f() {
        return this.f15322g;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.g.f g() {
        return h.p2.b0.g.t.g.f.f(StringsKt__StringsKt.p5(this.b.f(), Attributes.InternalPrefix, null, 2, null));
    }

    @k.e.a.d
    public String toString() {
        return ((Object) g.class.getSimpleName()) + ": " + this.b;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public g(@k.e.a.d h.p2.b0.g.t.e.b.m r11, @k.e.a.d kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package r12, @k.e.a.d h.p2.b0.g.t.f.z.c r13, @k.e.a.e h.p2.b0.g.t.l.b.n<h.p2.b0.g.t.f.a0.f.e> r14, boolean r15, @k.e.a.d kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability r16) {
        /*
            r10 = this;
            h.p2.b0.g.t.g.b r0 = r11.b()
            h.p2.b0.g.t.k.p.d r2 = h.p2.b0.g.t.k.p.d.b(r0)
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r11.c()
            java.lang.String r0 = r0.e()
            r1 = 0
            if (r0 != 0) goto L15
        L13:
            r3 = r1
            goto L25
        L15:
            int r3 = r0.length()
            if (r3 <= 0) goto L1d
            r3 = 1
            goto L1e
        L1d:
            r3 = 0
        L1e:
            if (r3 == 0) goto L13
            h.p2.b0.g.t.k.p.d r1 = h.p2.b0.g.t.k.p.d.d(r0)
            goto L13
        L25:
            r1 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.e.b.g.<init>(h.p2.b0.g.t.e.b.m, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, h.p2.b0.g.t.f.z.c, h.p2.b0.g.t.l.b.n, boolean, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability):void");
    }
}
