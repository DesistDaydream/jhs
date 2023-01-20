package h.g2;

import h.k2.v.f0;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public class k {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        @h.k2.d
        @k.e.a.e
        public static final Method a;
        @h.k2.d
        @k.e.a.e
        public static final Method b;
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public static final a f14865c = new a();

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            int length = methods.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                method = null;
                if (i3 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i3];
                if (f0.g(method2.getName(), "addSuppressed") && f0.g((Class) ArraysKt___ArraysKt.Ws(method2.getParameterTypes()), Throwable.class)) {
                    break;
                }
                i3++;
            }
            a = method2;
            int length2 = methods.length;
            while (true) {
                if (i2 >= length2) {
                    break;
                }
                Method method3 = methods[i2];
                if (f0.g(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i2++;
            }
            b = method;
        }

        private a() {
        }
    }

    public void a(@k.e.a.d Throwable th, @k.e.a.d Throwable th2) {
        Method method = a.a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    @k.e.a.d
    public Random b() {
        return new h.n2.b();
    }

    @k.e.a.e
    public h.t2.h c(@k.e.a.d MatchResult matchResult, @k.e.a.d String str) {
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    @k.e.a.d
    public List<Throwable> d(@k.e.a.d Throwable th) {
        Object invoke;
        Method method = a.b;
        if (method != null && (invoke = method.invoke(th, new Object[0])) != null) {
            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Array<kotlin.Throwable>");
            List<Throwable> t = h.a2.n.t((Throwable[]) invoke);
            if (t != null) {
                return t;
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }
}
