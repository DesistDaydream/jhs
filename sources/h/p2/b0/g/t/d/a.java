package h.p2.b0.g.t.d;

import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.d.b.b;
import h.p2.b0.g.t.d.b.c;
import h.p2.b0.g.t.g.f;
import k.e.a.d;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;

/* loaded from: classes3.dex */
public final class a {
    public static final void a(@d c cVar, @d b bVar, @d h.p2.b0.g.t.c.d dVar, @d f fVar) {
        h.p2.b0.g.t.d.b.a location;
        if (cVar == c.a.a || (location = bVar.getLocation()) == null) {
            return;
        }
        cVar.b(location.getFilePath(), cVar.a() ? location.getPosition() : Position.Companion.a(), h.p2.b0.g.t.k.c.m(dVar).b(), ScopeKind.CLASSIFIER, fVar.b());
    }

    public static final void b(@d c cVar, @d b bVar, @d b0 b0Var, @d f fVar) {
        c(cVar, bVar, b0Var.e().b(), fVar.b());
    }

    public static final void c(@d c cVar, @d b bVar, @d String str, @d String str2) {
        h.p2.b0.g.t.d.b.a location;
        if (cVar == c.a.a || (location = bVar.getLocation()) == null) {
            return;
        }
        cVar.b(location.getFilePath(), cVar.a() ? location.getPosition() : Position.Companion.a(), str, ScopeKind.PACKAGE, str2);
    }
}
