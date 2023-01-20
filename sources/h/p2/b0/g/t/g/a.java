package h.p2.b0.g.t.g;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.tencent.android.tpns.mqtt.MqttTopic;
import h.k2.v.f0;
import h.k2.v.u;

/* loaded from: classes3.dex */
public final class a {
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final C0458a f15406e = new C0458a(null);
    @Deprecated
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final f f15407f;
    @Deprecated
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final c f15408g;
    @k.e.a.d
    private final c a;
    @k.e.a.e
    private final c b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final f f15409c;
    @k.e.a.e

    /* renamed from: d  reason: collision with root package name */
    private final c f15410d;

    /* renamed from: h.p2.b0.g.t.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0458a {
        private C0458a() {
        }

        public /* synthetic */ C0458a(u uVar) {
            this();
        }
    }

    static {
        f i2 = f.i("<local>");
        f15407f = i2;
        f15408g = c.k(i2);
    }

    public a(@k.e.a.d c cVar, @k.e.a.e c cVar2, @k.e.a.d f fVar, @k.e.a.e c cVar3) {
        this.a = cVar;
        this.b = cVar2;
        this.f15409c = fVar;
        this.f15410d = cVar3;
    }

    @k.e.a.d
    public final f a() {
        return this.f15409c;
    }

    @k.e.a.e
    public final c b() {
        return this.b;
    }

    @k.e.a.d
    public final c c() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f0.g(this.a, aVar.a) && f0.g(this.b, aVar.b) && f0.g(this.f15409c, aVar.f15409c) && f0.g(this.f15410d, aVar.f15410d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        c cVar = this.b;
        int hashCode2 = (((hashCode + (cVar == null ? 0 : cVar.hashCode())) * 31) + this.f15409c.hashCode()) * 31;
        c cVar2 = this.f15410d;
        return hashCode2 + (cVar2 != null ? cVar2.hashCode() : 0);
    }

    @k.e.a.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(h.t2.u.j2(c().b(), '.', Attributes.InternalPrefix, false, 4, null));
        sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (b() != null) {
            sb.append(b());
            sb.append(".");
        }
        sb.append(a());
        return sb.toString();
    }

    public /* synthetic */ a(c cVar, c cVar2, f fVar, c cVar3, int i2, u uVar) {
        this(cVar, cVar2, fVar, (i2 & 8) != 0 ? null : cVar3);
    }

    public a(@k.e.a.d c cVar, @k.e.a.d f fVar) {
        this(cVar, null, fVar, null, 8, null);
    }
}
