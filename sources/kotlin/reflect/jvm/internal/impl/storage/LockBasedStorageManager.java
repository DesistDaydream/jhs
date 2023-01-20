package kotlin.reflect.jvm.internal.impl.storage;

import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import h.t1;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes3.dex */
public class LockBasedStorageManager implements h.p2.b0.g.t.m.m {

    /* renamed from: d  reason: collision with root package name */
    private static final String f16849d = StringsKt__StringsKt.w5(LockBasedStorageManager.class.getCanonicalName(), ".", "");

    /* renamed from: e  reason: collision with root package name */
    public static final h.p2.b0.g.t.m.m f16850e = new a("NO_LOCKS", f.a, h.p2.b0.g.t.m.e.b);

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f16851f = false;
    public final h.p2.b0.g.t.m.j a;
    private final f b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16852c;

    /* loaded from: classes3.dex */
    public enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* loaded from: classes3.dex */
    public static class a extends LockBasedStorageManager {
        public a(String str, f fVar, h.p2.b0.g.t.m.j jVar) {
            super(str, fVar, jVar, null);
        }

        private static /* synthetic */ void j(int i2) {
            String str = i2 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 1 ? 3 : 2];
            if (i2 != 1) {
                objArr[0] = MessageKey.MSG_SOURCE;
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i2 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i2 != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String format = String.format(str, objArr);
            if (i2 == 1) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager
        @k.e.a.d
        public <K, V> n<V> p(@k.e.a.d String str, K k2) {
            if (str == null) {
                j(0);
            }
            n<V> a = n.a();
            if (a == null) {
                j(1);
            }
            return a;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f16853e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LockBasedStorageManager lockBasedStorageManager, h.k2.u.a aVar, Object obj) {
            super(lockBasedStorageManager, aVar);
            this.f16853e = obj;
        }

        private static /* synthetic */ void a(int i2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.h
        @k.e.a.d
        public n<T> c(boolean z) {
            n<T> d2 = n.d(this.f16853e);
            if (d2 == 0) {
                a(0);
            }
            return d2;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends k<T> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.k2.u.l f16855f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.k2.u.l f16856g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LockBasedStorageManager lockBasedStorageManager, h.k2.u.a aVar, h.k2.u.l lVar, h.k2.u.l lVar2) {
            super(lockBasedStorageManager, aVar);
            this.f16855f = lVar;
            this.f16856g = lVar2;
        }

        private static /* synthetic */ void a(int i2) {
            String str = i2 != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i2 != 2 ? 2 : 3];
            if (i2 != 2) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            } else {
                objArr[0] = "value";
            }
            if (i2 != 2) {
                objArr[1] = "recursionDetected";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            }
            if (i2 == 2) {
                objArr[2] = "doPostCompute";
            }
            String format = String.format(str, objArr);
            if (i2 == 2) {
                throw new IllegalArgumentException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.h
        @k.e.a.d
        public n<T> c(boolean z) {
            h.k2.u.l lVar = this.f16855f;
            if (lVar == null) {
                n<T> c2 = super.c(z);
                if (c2 == 0) {
                    a(0);
                }
                return c2;
            }
            n<T> d2 = n.d(lVar.invoke(Boolean.valueOf(z)));
            if (d2 == 0) {
                a(1);
            }
            return d2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.i
        public void d(@k.e.a.d T t) {
            if (t == 0) {
                a(2);
            }
            this.f16856g.invoke(t);
        }
    }

    /* loaded from: classes3.dex */
    public static class d<K, V> extends e<K, V> implements h.p2.b0.g.t.m.a<K, V> {

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ boolean f16858d = false;

        public /* synthetic */ d(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap concurrentMap, a aVar) {
            this(lockBasedStorageManager, concurrentMap);
        }

        private static /* synthetic */ void b(int i2) {
            String str = i2 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 3 ? 3 : 2];
            if (i2 == 1) {
                objArr[0] = "map";
            } else if (i2 == 2) {
                objArr[0] = "computation";
            } else if (i2 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i2 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i2 == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i2 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 3) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.e, h.p2.b0.g.t.m.a
        @k.e.a.d
        public V a(K k2, @k.e.a.d h.k2.u.a<? extends V> aVar) {
            if (aVar == null) {
                b(2);
            }
            V v = (V) super.a(k2, aVar);
            if (v == null) {
                b(3);
            }
            return v;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private d(@k.e.a.d LockBasedStorageManager lockBasedStorageManager, @k.e.a.d ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(lockBasedStorageManager, concurrentMap, null);
            if (lockBasedStorageManager == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e<K, V> extends l<g<K, V>, V> implements h.p2.b0.g.t.m.b<K, V> {

        /* loaded from: classes3.dex */
        public class a implements h.k2.u.l<g<K, V>, V> {
            @Override // h.k2.u.l
            /* renamed from: a */
            public V invoke(g<K, V> gVar) {
                return (V) ((g) gVar).b.invoke();
            }
        }

        public /* synthetic */ e(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap concurrentMap, a aVar) {
            this(lockBasedStorageManager, concurrentMap);
        }

        private static /* synthetic */ void b(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "map";
            } else if (i2 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i2 != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @k.e.a.e
        public V a(K k2, @k.e.a.d h.k2.u.a<? extends V> aVar) {
            if (aVar == null) {
                b(2);
            }
            return invoke(new g(k2, aVar));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private e(@k.e.a.d LockBasedStorageManager lockBasedStorageManager, @k.e.a.d ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(lockBasedStorageManager, concurrentMap, new a());
            if (lockBasedStorageManager == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        public static final f a = new a();

        /* loaded from: classes3.dex */
        public static class a implements f {
            private static /* synthetic */ void b(int i2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.f
            @k.e.a.d
            public RuntimeException a(@k.e.a.d Throwable th) {
                if (th == null) {
                    b(0);
                }
                throw h.p2.b0.g.t.p.c.b(th);
            }
        }

        @k.e.a.d
        RuntimeException a(@k.e.a.d Throwable th);
    }

    /* loaded from: classes3.dex */
    public static class g<K, V> {
        private final K a;
        private final h.k2.u.a<? extends V> b;

        public g(K k2, h.k2.u.a<? extends V> aVar) {
            this.a = k2;
            this.b = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.a.equals(((g) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public static class h<T> implements h.p2.b0.g.t.m.i<T> {
        private final LockBasedStorageManager a;
        private final h.k2.u.a<? extends T> b;
        @k.e.a.e

        /* renamed from: c  reason: collision with root package name */
        private volatile Object f16859c;

        public h(@k.e.a.d LockBasedStorageManager lockBasedStorageManager, @k.e.a.d h.k2.u.a<? extends T> aVar) {
            if (lockBasedStorageManager == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
            this.f16859c = NotValue.NOT_COMPUTED;
            this.a = lockBasedStorageManager;
            this.b = aVar;
        }

        private static /* synthetic */ void a(int i2) {
            String str = (i2 == 2 || i2 == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 2 || i2 == 3) ? 2 : 3];
            if (i2 == 1) {
                objArr[0] = "computable";
            } else if (i2 == 2 || i2 == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i2 == 2) {
                objArr[1] = "recursionDetected";
            } else if (i2 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i2 != 2 && i2 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 != 2 && i2 != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public void b(T t) {
        }

        @k.e.a.d
        public n<T> c(boolean z) {
            n<T> p = this.a.p("in a lazy value", null);
            if (p == null) {
                a(2);
            }
            return p;
        }

        @Override // h.k2.u.a
        public T invoke() {
            T invoke;
            Object obj = this.f16859c;
            if (obj instanceof NotValue) {
                this.a.a.lock();
                try {
                    Object obj2 = this.f16859c;
                    if (obj2 instanceof NotValue) {
                        NotValue notValue = NotValue.COMPUTING;
                        if (obj2 == notValue) {
                            this.f16859c = NotValue.RECURSION_WAS_DETECTED;
                            n<T> c2 = c(true);
                            if (!c2.c()) {
                                invoke = c2.b();
                            }
                        }
                        if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                            n<T> c3 = c(false);
                            if (!c3.c()) {
                                invoke = c3.b();
                            }
                        }
                        this.f16859c = notValue;
                        invoke = this.b.invoke();
                        b(invoke);
                        this.f16859c = invoke;
                    } else {
                        invoke = (T) WrappedValues.f(obj2);
                    }
                    return invoke;
                } finally {
                    this.a.a.unlock();
                }
            }
            return (T) WrappedValues.f(obj);
        }

        public boolean o() {
            return (this.f16859c == NotValue.NOT_COMPUTED || this.f16859c == NotValue.COMPUTING) ? false : true;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class i<T> extends h<T> {
        @k.e.a.e

        /* renamed from: d  reason: collision with root package name */
        private volatile h.p2.b0.g.t.m.k<T> f16860d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(@k.e.a.d LockBasedStorageManager lockBasedStorageManager, @k.e.a.d h.k2.u.a<? extends T> aVar) {
            super(lockBasedStorageManager, aVar);
            if (lockBasedStorageManager == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
            this.f16860d = null;
        }

        private static /* synthetic */ void a(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.h
        public final void b(T t) {
            this.f16860d = new h.p2.b0.g.t.m.k<>(t);
            try {
                d(t);
            } finally {
                this.f16860d = null;
            }
        }

        public abstract void d(T t);

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.h, h.k2.u.a
        public T invoke() {
            h.p2.b0.g.t.m.k<T> kVar = this.f16860d;
            if (kVar != null && kVar.b()) {
                return kVar.a();
            }
            return (T) super.invoke();
        }
    }

    /* loaded from: classes3.dex */
    public static class j<T> extends h<T> implements h.p2.b0.g.t.m.h<T> {

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ boolean f16861d = false;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(@k.e.a.d LockBasedStorageManager lockBasedStorageManager, @k.e.a.d h.k2.u.a<? extends T> aVar) {
            super(lockBasedStorageManager, aVar);
            if (lockBasedStorageManager == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i2) {
            String str = i2 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 2 ? 3 : 2];
            if (i2 == 1) {
                objArr[0] = "computable";
            } else if (i2 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i2 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i2 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 2) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.h, h.k2.u.a
        @k.e.a.d
        public T invoke() {
            T t = (T) super.invoke();
            if (t == null) {
                a(2);
            }
            return t;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class k<T> extends i<T> implements h.p2.b0.g.t.m.h<T> {

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ boolean f16862e = false;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(@k.e.a.d LockBasedStorageManager lockBasedStorageManager, @k.e.a.d h.k2.u.a<? extends T> aVar) {
            super(lockBasedStorageManager, aVar);
            if (lockBasedStorageManager == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i2) {
            String str = i2 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 2 ? 3 : 2];
            if (i2 == 1) {
                objArr[0] = "computable";
            } else if (i2 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i2 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i2 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 2) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.i, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.h, h.k2.u.a
        @k.e.a.d
        public T invoke() {
            T t = (T) super.invoke();
            if (t == null) {
                a(2);
            }
            return t;
        }
    }

    /* loaded from: classes3.dex */
    public static class l<K, V> implements h.p2.b0.g.t.m.g<K, V> {
        private final LockBasedStorageManager a;
        private final ConcurrentMap<K, Object> b;

        /* renamed from: c  reason: collision with root package name */
        private final h.k2.u.l<? super K, ? extends V> f16863c;

        public l(@k.e.a.d LockBasedStorageManager lockBasedStorageManager, @k.e.a.d ConcurrentMap<K, Object> concurrentMap, @k.e.a.d h.k2.u.l<? super K, ? extends V> lVar) {
            if (lockBasedStorageManager == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (lVar == null) {
                b(2);
            }
            this.a = lockBasedStorageManager;
            this.b = concurrentMap;
            this.f16863c = lVar;
        }

        private static /* synthetic */ void b(int i2) {
            String str = (i2 == 3 || i2 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 3 || i2 == 4) ? 2 : 3];
            if (i2 == 1) {
                objArr[0] = "map";
            } else if (i2 == 2) {
                objArr[0] = "compute";
            } else if (i2 == 3 || i2 == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i2 == 3) {
                objArr[1] = "recursionDetected";
            } else if (i2 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i2 != 3 && i2 != 4) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 != 3 && i2 != 4) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @k.e.a.d
        private AssertionError d(K k2, Object obj) {
            AssertionError assertionError = (AssertionError) LockBasedStorageManager.q(new AssertionError("Race condition detected on input " + k2 + ". Old value is " + obj + " under " + this.a));
            if (assertionError == null) {
                b(4);
            }
            return assertionError;
        }

        public LockBasedStorageManager c() {
            return this.a;
        }

        @k.e.a.d
        public n<V> e(K k2, boolean z) {
            n<V> p = this.a.p("", k2);
            if (p == null) {
                b(3);
            }
            return p;
        }

        @Override // h.k2.u.l
        @k.e.a.e
        public V invoke(K k2) {
            V v;
            Object obj = this.b.get(k2);
            if (obj == null || obj == NotValue.COMPUTING) {
                this.a.a.lock();
                try {
                    Object obj2 = this.b.get(k2);
                    NotValue notValue = NotValue.COMPUTING;
                    if (obj2 == notValue) {
                        obj2 = NotValue.RECURSION_WAS_DETECTED;
                        n<V> e2 = e(k2, true);
                        if (!e2.c()) {
                            v = e2.b();
                            return v;
                        }
                    }
                    if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                        n<V> e3 = e(k2, false);
                        if (!e3.c()) {
                            v = e3.b();
                            return v;
                        }
                    }
                    if (obj2 != null) {
                        v = (V) WrappedValues.d(obj2);
                        return v;
                    }
                    this.b.put(k2, notValue);
                    V invoke = this.f16863c.invoke(k2);
                    Object put = this.b.put(k2, WrappedValues.b(invoke));
                    if (put == notValue) {
                        return invoke;
                    }
                    throw d(k2, put);
                } finally {
                    this.a.a.unlock();
                }
            }
            return (V) WrappedValues.d(obj);
        }

        @Override // h.p2.b0.g.t.m.g
        public boolean x(K k2) {
            Object obj = this.b.get(k2);
            return (obj == null || obj == NotValue.COMPUTING) ? false : true;
        }
    }

    /* loaded from: classes3.dex */
    public static class m<K, V> extends l<K, V> implements h.p2.b0.g.t.m.f<K, V> {

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ boolean f16864d = false;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(@k.e.a.d LockBasedStorageManager lockBasedStorageManager, @k.e.a.d ConcurrentMap<K, Object> concurrentMap, @k.e.a.d h.k2.u.l<? super K, ? extends V> lVar) {
            super(lockBasedStorageManager, concurrentMap, lVar);
            if (lockBasedStorageManager == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (lVar == null) {
                b(2);
            }
        }

        private static /* synthetic */ void b(int i2) {
            String str = i2 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 3 ? 3 : 2];
            if (i2 == 1) {
                objArr[0] = "map";
            } else if (i2 == 2) {
                objArr[0] = "compute";
            } else if (i2 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i2 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i2 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 3) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.l, h.k2.u.l
        @k.e.a.d
        public V invoke(K k2) {
            V v = (V) super.invoke(k2);
            if (v == null) {
                b(3);
            }
            return v;
        }
    }

    /* loaded from: classes3.dex */
    public static class n<T> {

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f16865c = false;
        private final T a;
        private final boolean b;

        private n(T t, boolean z) {
            this.a = t;
            this.b = z;
        }

        @k.e.a.d
        public static <T> n<T> a() {
            return new n<>(null, true);
        }

        @k.e.a.d
        public static <T> n<T> d(T t) {
            return new n<>(t, false);
        }

        public T b() {
            return this.a;
        }

        public boolean c() {
            return this.b;
        }

        public String toString() {
            return c() ? "FALL_THROUGH" : String.valueOf(this.a);
        }
    }

    public /* synthetic */ LockBasedStorageManager(String str, f fVar, h.p2.b0.g.t.m.j jVar, a aVar) {
        this(str, fVar, jVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void j(int r13) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.j(int):void");
    }

    public static /* synthetic */ f k(LockBasedStorageManager lockBasedStorageManager) {
        return lockBasedStorageManager.b;
    }

    @k.e.a.d
    private static <K> ConcurrentMap<K, Object> m() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @k.e.a.d
    public static <T extends Throwable> T q(@k.e.a.d T t) {
        if (t == null) {
            j(36);
        }
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            } else if (!stackTrace[i3].getClassName().startsWith(f16849d)) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i2, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        if (t == null) {
            j(37);
        }
        return t;
    }

    @Override // h.p2.b0.g.t.m.m
    @k.e.a.d
    public <K, V> h.p2.b0.g.t.m.a<K, V> a() {
        return new d(this, m(), null);
    }

    @Override // h.p2.b0.g.t.m.m
    @k.e.a.d
    public <T> h.p2.b0.g.t.m.h<T> b(@k.e.a.d h.k2.u.a<? extends T> aVar, @k.e.a.d T t) {
        if (aVar == null) {
            j(26);
        }
        if (t == null) {
            j(27);
        }
        return new b(this, aVar, t);
    }

    @Override // h.p2.b0.g.t.m.m
    @k.e.a.d
    public <T> h.p2.b0.g.t.m.h<T> c(@k.e.a.d h.k2.u.a<? extends T> aVar) {
        if (aVar == null) {
            j(23);
        }
        return new j(this, aVar);
    }

    @Override // h.p2.b0.g.t.m.m
    public <T> T d(@k.e.a.d h.k2.u.a<? extends T> aVar) {
        if (aVar == null) {
            j(34);
        }
        this.a.lock();
        try {
            return aVar.invoke();
        } finally {
        }
    }

    @Override // h.p2.b0.g.t.m.m
    @k.e.a.d
    public <T> h.p2.b0.g.t.m.i<T> e(@k.e.a.d h.k2.u.a<? extends T> aVar) {
        if (aVar == null) {
            j(30);
        }
        return new h(this, aVar);
    }

    @Override // h.p2.b0.g.t.m.m
    @k.e.a.d
    public <T> h.p2.b0.g.t.m.h<T> f(@k.e.a.d h.k2.u.a<? extends T> aVar, h.k2.u.l<? super Boolean, ? extends T> lVar, @k.e.a.d h.k2.u.l<? super T, t1> lVar2) {
        if (aVar == null) {
            j(28);
        }
        if (lVar2 == null) {
            j(29);
        }
        return new c(this, aVar, lVar, lVar2);
    }

    @Override // h.p2.b0.g.t.m.m
    @k.e.a.d
    public <K, V> h.p2.b0.g.t.m.g<K, V> g(@k.e.a.d h.k2.u.l<? super K, ? extends V> lVar) {
        if (lVar == null) {
            j(19);
        }
        h.p2.b0.g.t.m.g<K, V> o = o(lVar, m());
        if (o == null) {
            j(20);
        }
        return o;
    }

    @Override // h.p2.b0.g.t.m.m
    @k.e.a.d
    public <K, V> h.p2.b0.g.t.m.b<K, V> h() {
        return new e(this, m(), null);
    }

    @Override // h.p2.b0.g.t.m.m
    @k.e.a.d
    public <K, V> h.p2.b0.g.t.m.f<K, V> i(@k.e.a.d h.k2.u.l<? super K, ? extends V> lVar) {
        if (lVar == null) {
            j(9);
        }
        h.p2.b0.g.t.m.f<K, V> n2 = n(lVar, m());
        if (n2 == null) {
            j(10);
        }
        return n2;
    }

    @k.e.a.d
    public <K, V> h.p2.b0.g.t.m.f<K, V> n(@k.e.a.d h.k2.u.l<? super K, ? extends V> lVar, @k.e.a.d ConcurrentMap<K, Object> concurrentMap) {
        if (lVar == null) {
            j(14);
        }
        if (concurrentMap == null) {
            j(15);
        }
        return new m(this, concurrentMap, lVar);
    }

    @k.e.a.d
    public <K, V> h.p2.b0.g.t.m.g<K, V> o(@k.e.a.d h.k2.u.l<? super K, ? extends V> lVar, @k.e.a.d ConcurrentMap<K, Object> concurrentMap) {
        if (lVar == null) {
            j(21);
        }
        if (concurrentMap == null) {
            j(22);
        }
        return new l(this, concurrentMap, lVar);
    }

    @k.e.a.d
    public <K, V> n<V> p(@k.e.a.d String str, K k2) {
        String str2;
        if (str == null) {
            j(35);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Recursion detected ");
        sb.append(str);
        if (k2 == null) {
            str2 = "";
        } else {
            str2 = "on input: " + k2;
        }
        sb.append(str2);
        sb.append(" under ");
        sb.append(this);
        throw ((AssertionError) q(new AssertionError(sb.toString())));
    }

    public String toString() {
        return getClass().getSimpleName() + TIMMentionEditText.TIM_MENTION_TAG + Integer.toHexString(hashCode()) + " (" + this.f16852c + ")";
    }

    private LockBasedStorageManager(@k.e.a.d String str, @k.e.a.d f fVar, @k.e.a.d h.p2.b0.g.t.m.j jVar) {
        if (str == null) {
            j(4);
        }
        if (fVar == null) {
            j(5);
        }
        if (jVar == null) {
            j(6);
        }
        this.a = jVar;
        this.b = fVar;
        this.f16852c = str;
    }

    public LockBasedStorageManager(String str) {
        this(str, (Runnable) null, (h.k2.u.l<InterruptedException, t1>) null);
    }

    public LockBasedStorageManager(String str, @k.e.a.e Runnable runnable, @k.e.a.e h.k2.u.l<InterruptedException, t1> lVar) {
        this(str, f.a, h.p2.b0.g.t.m.j.a.a(runnable, lVar));
    }
}
