package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import h.k2.u.l;
import h.p2.b0.g.t.g.f;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class MemberScope$Companion$ALL_NAME_FILTER$1 extends Lambda implements l<f, Boolean> {
    public static final MemberScope$Companion$ALL_NAME_FILTER$1 INSTANCE = new MemberScope$Companion$ALL_NAME_FILTER$1();

    public MemberScope$Companion$ALL_NAME_FILTER$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(f fVar) {
        return Boolean.valueOf(invoke2(fVar));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d f fVar) {
        return true;
    }
}
