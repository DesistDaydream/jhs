package kotlin.reflect.full;

import h.k2.v.n0;
import h.p2.d;
import h.p2.h;
import h.p2.p;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1;

@Metadata(k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final /* synthetic */ class KClasses$isSubclassOf$1 extends PropertyReference1 {
    public static final p INSTANCE = new KClasses$isSubclassOf$1();

    @Override // h.p2.p
    @e
    public Object get(@e Object obj) {
        return KClasses.O((d) obj);
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    public String getName() {
        return "superclasses";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public h getOwner() {
        return n0.h(KClasses.class, "kotlin-reflection");
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getSuperclasses(Lkotlin/reflect/KClass;)Ljava/util/List;";
    }
}
