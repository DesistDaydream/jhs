package i.b.y3;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.umeng.analytics.pro.am;
import h.o2.q;
import i.b.w3.k0;
import i.b.w3.m0;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0016\u0010\u0003\u001a\u00020\u00008\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0007\u001a\u00020\u00048\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u001b\u0010\f\u001a\u00020\t*\u00020\b8À\u0002@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0016\u0010\u0010\u001a\u00020\r8\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0012\u001a\u00020\r8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f\"\u0016\u0010\u0014\u001a\u00020\r8\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f\"\u0016\u0010\u0015\u001a\u00020\u00048\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\n\u0010\u0006\"\u0016\u0010\u0017\u001a\u00020\r8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000f\"\u0016\u0010\u0019\u001a\u00020\r8\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u000f\"\u0016\u0010\u001b\u001a\u00020\u00008\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0002\"\u0016\u0010\u001f\u001a\u00020\u001c8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"", "g", "J", "IDLE_WORKER_KEEP_ALIVE_NS", "", "b", "Ljava/lang/String;", "DEFAULT_SCHEDULER_NAME", "Li/b/y3/i;", "", am.av, "(Li/b/y3/i;)Z", "isBlocking", "", "f", ExpandableTextView.P, "MAX_POOL_SIZE", "j", "TASK_PROBABLY_BLOCKING", e.j.a.b.c.f.f10128d, "BLOCKING_DEFAULT_PARALLELISM", "DEFAULT_DISPATCHER_NAME", "i", "TASK_NON_BLOCKING", com.huawei.hms.push.e.a, "CORE_POOL_SIZE", "c", "WORK_STEALING_TIME_RESOLUTION_NS", "Li/b/y3/m;", "h", "Li/b/y3/m;", "schedulerTimeSource", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class l {
    @k.e.a.d
    public static final String a = "Dispatchers.Default";
    @k.e.a.d
    public static final String b = "DefaultDispatcher";
    @h.k2.d

    /* renamed from: c  reason: collision with root package name */
    public static final long f15928c;
    @h.k2.d

    /* renamed from: d  reason: collision with root package name */
    public static final int f15929d;
    @h.k2.d

    /* renamed from: e  reason: collision with root package name */
    public static final int f15930e;
    @h.k2.d

    /* renamed from: f  reason: collision with root package name */
    public static final int f15931f;
    @h.k2.d

    /* renamed from: g  reason: collision with root package name */
    public static final long f15932g;
    @h.k2.d
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    public static m f15933h = null;

    /* renamed from: i  reason: collision with root package name */
    public static final int f15934i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f15935j = 1;

    static {
        long e2;
        int d2;
        int d3;
        int d4;
        long e3;
        e2 = m0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f15928c = e2;
        d2 = m0.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        f15929d = d2;
        d3 = m0.d("kotlinx.coroutines.scheduler.core.pool.size", q.n(k0.a(), 2), 1, 0, 8, null);
        f15930e = d3;
        d4 = m0.d("kotlinx.coroutines.scheduler.max.pool.size", q.B(k0.a() * 128, d3, CoroutineScheduler.u), 0, CoroutineScheduler.u, 4, null);
        f15931f = d4;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e3 = m0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f15932g = timeUnit.toNanos(e3);
        f15933h = g.a;
    }

    public static final boolean a(@k.e.a.d i iVar) {
        return iVar.b.f0() == 1;
    }
}
