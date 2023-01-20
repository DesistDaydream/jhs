package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import h.k2.u.l;
import h.k2.v.n0;
import h.p2.b0.g.t.l.b.w.c;
import h.p2.h;
import java.io.InputStream;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.FunctionReference;

/* loaded from: classes3.dex */
public /* synthetic */ class BuiltInsLoaderImpl$createPackageFragmentProvider$1 extends FunctionReference implements l<String, InputStream> {
    public BuiltInsLoaderImpl$createPackageFragmentProvider$1(c cVar) {
        super(1, cVar);
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    @d
    public final String getName() {
        return "loadResource";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final h getOwner() {
        return n0.d(c.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final String getSignature() {
        return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
    }

    @Override // h.k2.u.l
    @e
    public final InputStream invoke(@d String str) {
        return ((c) this.receiver).a(str);
    }
}
