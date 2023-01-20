package kotlin.reflect.jvm.internal.impl.builtins;

import h.k2.u.a;
import java.util.ServiceLoader;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class BuiltInsLoader$Companion$Instance$2 extends Lambda implements a<BuiltInsLoader> {
    public static final BuiltInsLoader$Companion$Instance$2 INSTANCE = new BuiltInsLoader$Companion$Instance$2();

    public BuiltInsLoader$Companion$Instance$2() {
        super(0);
    }

    @Override // h.k2.u.a
    @d
    public final BuiltInsLoader invoke() {
        BuiltInsLoader builtInsLoader = (BuiltInsLoader) CollectionsKt___CollectionsKt.r2(ServiceLoader.load(BuiltInsLoader.class, BuiltInsLoader.class.getClassLoader()));
        if (builtInsLoader != null) {
            return builtInsLoader;
        }
        throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
    }
}
