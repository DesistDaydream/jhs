package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0002\"\u0004\b\u0000\u0010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a,\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\u00060\u0006j\u0002`\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0080\b¢\u0006\u0004\b\n\u0010\u000b\u001a$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00002\u0006\u0010\r\u001a\u00020\fH\u0080\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\"\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018*\f\b\u0000\u0010\u001a\"\u00020\u00062\u00020\u0006¨\u0006\u001b"}, d2 = {ExifInterface.LONGITUDE_EAST, "", "Lkotlinx/coroutines/internal/SubscribersList;", e.j.a.b.c.f.f10128d, "()Ljava/util/List;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "Lkotlin/Function0;", "action", com.huawei.hms.push.e.a, "(Ljava/util/concurrent/locks/ReentrantLock;Lh/k2/u/a;)Ljava/lang/Object;", "", "expectedSize", "", "b", "(I)Ljava/util/Set;", "Ljava/util/concurrent/Executor;", "executor", "", "c", "(Ljava/util/concurrent/Executor;)Z", "Ljava/lang/reflect/Method;", am.av, "Ljava/lang/reflect/Method;", "REMOVE_FUTURE_ON_CANCEL", "ReentrantLock", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class e {
    private static final Method a;

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        a = method;
    }

    public static /* synthetic */ void a() {
    }

    @k.e.a.d
    public static final <E> Set<E> b(int i2) {
        return Collections.newSetFromMap(new IdentityHashMap(i2));
    }

    public static final boolean c(@k.e.a.d Executor executor) {
        Method method;
        try {
            if (!(executor instanceof ScheduledThreadPoolExecutor)) {
                executor = null;
            }
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) executor;
            if (scheduledThreadPoolExecutor != null && (method = a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @k.e.a.d
    public static final <E> List<E> d() {
        return new CopyOnWriteArrayList();
    }

    public static final <T> T e(@k.e.a.d ReentrantLock reentrantLock, @k.e.a.d h.k2.u.a<? extends T> aVar) {
        reentrantLock.lock();
        try {
            return aVar.invoke();
        } finally {
            h.k2.v.c0.d(1);
            reentrantLock.unlock();
            h.k2.v.c0.c(1);
        }
    }
}
