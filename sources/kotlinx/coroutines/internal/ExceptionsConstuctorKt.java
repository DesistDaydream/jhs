package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.b2.b;
import h.k2.u.l;
import h.k2.v.f0;
import h.r0;
import h.t1;
import i.b.h0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.ArraysKt___ArraysKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a1\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\t\u0010\n\u001a8\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007j\u0002`\b2\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0007H\u0082\b¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\"\u0010\u0014\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000fH\u0082\u0010¢\u0006\u0004\b\u0014\u0010\u0012\"\u0016\u0010\u0016\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015\"<\u0010\u001a\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u000e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007j\u0002`\b0\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\"\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001c*(\b\u0002\u0010\u001e\"\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00072\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007¨\u0006\u001f"}, d2 = {"", ExifInterface.LONGITUDE_EAST, "exception", "f", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Ljava/lang/reflect/Constructor;", "constructor", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", am.av, "(Ljava/lang/reflect/Constructor;)Lh/k2/u/l;", ReportItem.LogTypeBlock, e.a, "(Lh/k2/u/l;)Lh/k2/u/l;", "Ljava/lang/Class;", "", "defaultValue", f.f10128d, "(Ljava/lang/Class;I)I", "accumulator", "b", ExpandableTextView.P, "throwableFields", "Ljava/util/WeakHashMap;", "c", "Ljava/util/WeakHashMap;", "exceptionCtors", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "cacheLock", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ExceptionsConstuctorKt {
    private static final int a = d(Throwable.class, -1);
    private static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    private static final WeakHashMap<Class<? extends Throwable>, l<Throwable, Throwable>> f16981c = new WeakHashMap<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", am.av, "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "h/b2/b$d", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.g(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
        }
    }

    private static final l<Throwable, Throwable> a(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2 && f0.g(parameterTypes[0], String.class) && f0.g(parameterTypes[1], Throwable.class)) {
                    return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(constructor);
                }
                return null;
            }
            Class<?> cls = parameterTypes[0];
            if (f0.g(cls, Throwable.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(constructor);
            }
            if (f0.g(cls, String.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(constructor);
            }
            return null;
        }
        return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(constructor);
    }

    private static final int b(Class<?> cls, int i2) {
        do {
            int i3 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i3++;
                }
            }
            i2 += i3;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i2;
    }

    public static /* synthetic */ int c(Class cls, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return b(cls, i2);
    }

    private static final int d(Class<?> cls, int i2) {
        Integer m106constructorimpl;
        h.k2.a.g(cls);
        try {
            Result.a aVar = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(Integer.valueOf(c(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th));
        }
        Integer valueOf = Integer.valueOf(i2);
        if (Result.m112isFailureimpl(m106constructorimpl)) {
            m106constructorimpl = valueOf;
        }
        return ((Number) m106constructorimpl).intValue();
    }

    private static final l<Throwable, Throwable> e(l<? super Throwable, ? extends Throwable> lVar) {
        return new ExceptionsConstuctorKt$safeCtor$1(lVar);
    }

    @k.e.a.e
    public static final <E extends Throwable> E f(@d E e2) {
        Object m106constructorimpl;
        ReentrantReadWriteLock.ReadLock readLock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        if (e2 instanceof h0) {
            try {
                Result.a aVar = Result.Companion;
                m106constructorimpl = Result.m106constructorimpl(((h0) e2).createCopy());
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                m106constructorimpl = Result.m106constructorimpl(r0.a(th));
            }
            return (E) (Result.m112isFailureimpl(m106constructorimpl) ? null : m106constructorimpl);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = b;
        ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
        readLock2.lock();
        try {
            l<Throwable, Throwable> lVar = f16981c.get(e2.getClass());
            if (lVar != null) {
                return (E) lVar.invoke(e2);
            }
            int i2 = 0;
            if (a != d(e2.getClass(), 0)) {
                readLock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i3 = 0; i3 < readHoldCount; i3++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    f16981c.put(e2.getClass(), ExceptionsConstuctorKt$tryCopyException$4$1.INSTANCE);
                    t1 t1Var = t1.a;
                    return null;
                } finally {
                    while (i2 < readHoldCount) {
                        readLock.lock();
                        i2++;
                    }
                    writeLock.unlock();
                }
            }
            Iterator it = ArraysKt___ArraysKt.hv(e2.getClass().getConstructors(), new a()).iterator();
            l<Throwable, Throwable> lVar2 = null;
            while (it.hasNext() && (lVar2 = a((Constructor) it.next())) == null) {
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = b;
            readLock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i4 = 0; i4 < readHoldCount; i4++) {
                readLock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                f16981c.put(e2.getClass(), lVar2 != null ? lVar2 : ExceptionsConstuctorKt$tryCopyException$5$1.INSTANCE);
                t1 t1Var2 = t1.a;
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
                if (lVar2 != null) {
                    return (E) lVar2.invoke(e2);
                }
                return null;
            } finally {
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock2.unlock();
        }
    }
}
