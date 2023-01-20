package okhttp3;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.qiniu.android.collect.ReportItem;
import h.a2.u;
import h.i;
import h.k2.g;
import h.k2.v.f0;
import h.q0;
import h.t1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010\u0016B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b?\u0010@J\u001d\u0010\u0006\u001a\b\u0018\u00010\u0004R\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\u000f2\n\u0010\u000e\u001a\u00060\u0004R\u00020\u0005H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0010\u001a\u00020\u000f2\n\u0010\u000e\u001a\u00060\u0004R\u00020\u0005H\u0000¢\u0006\u0004\b\u001a\u0010\u0013J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u001a\u0010\u0018J\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0004\b\u001f\u0010\u001eJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020 ¢\u0006\u0004\b#\u0010\"J\u000f\u0010'\u001a\u00020$H\u0007¢\u0006\u0004\b%\u0010&R*\u0010(\u001a\u00020 2\u0006\u0010(\u001a\u00020 8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010,R\u0013\u0010'\u001a\u00020$8G@\u0006¢\u0006\u0006\u001a\u0004\b'\u0010&R.\u0010/\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010-8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R*\u00105\u001a\u00020 2\u0006\u00105\u001a\u00020 8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010)\u001a\u0004\b6\u0010\"\"\u0004\b7\u0010,R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u0005088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R \u0010;\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u0005088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010:R \u0010<\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u0005088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lokhttp3/Dispatcher;", "", "", ReportItem.RequestKeyHost, "Lokhttp3/internal/connection/RealCall$AsyncCall;", "Lokhttp3/internal/connection/RealCall;", "findExistingCallWithHost", "(Ljava/lang/String;)Lokhttp3/internal/connection/RealCall$AsyncCall;", "", "promoteAndExecute", "()Z", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Deque;", "calls", "call", "Lh/t1;", "finished", "(Ljava/util/Deque;Ljava/lang/Object;)V", "enqueue$okhttp", "(Lokhttp3/internal/connection/RealCall$AsyncCall;)V", "enqueue", "cancelAll", "()V", "executed$okhttp", "(Lokhttp3/internal/connection/RealCall;)V", "executed", "finished$okhttp", "", "Lokhttp3/Call;", "queuedCalls", "()Ljava/util/List;", "runningCalls", "", "queuedCallsCount", "()I", "runningCallsCount", "Ljava/util/concurrent/ExecutorService;", "-deprecated_executorService", "()Ljava/util/concurrent/ExecutorService;", "executorService", "maxRequests", ExpandableTextView.P, "getMaxRequests", "setMaxRequests", "(I)V", "Ljava/lang/Runnable;", "<set-?>", "idleCallback", "Ljava/lang/Runnable;", "getIdleCallback", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "maxRequestsPerHost", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "Ljava/util/ArrayDeque;", "runningSyncCalls", "Ljava/util/ArrayDeque;", "readyAsyncCalls", "runningAsyncCalls", "executorServiceOrNull", "Ljava/util/concurrent/ExecutorService;", "<init>", "(Ljava/util/concurrent/ExecutorService;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Dispatcher {
    private ExecutorService executorServiceOrNull;
    @e
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<>();
        this.runningAsyncCalls = new ArrayDeque<>();
        this.runningSyncCalls = new ArrayDeque<>();
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String str) {
        Iterator<RealCall.AsyncCall> it = this.runningAsyncCalls.iterator();
        while (it.hasNext()) {
            RealCall.AsyncCall next = it.next();
            if (f0.g(next.getHost(), str)) {
                return next;
            }
        }
        Iterator<RealCall.AsyncCall> it2 = this.readyAsyncCalls.iterator();
        while (it2.hasNext()) {
            RealCall.AsyncCall next2 = it2.next();
            if (f0.g(next2.getHost(), str)) {
                return next2;
            }
        }
        return null;
    }

    private final <T> void finished(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.idleCallback;
                t1 t1Var = t1.a;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (promoteAndExecute() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private final boolean promoteAndExecute() {
        int i2;
        boolean z;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
            while (it.hasNext()) {
                RealCall.AsyncCall next = it.next();
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                } else if (next.getCallsPerHost().get() < this.maxRequestsPerHost) {
                    it.remove();
                    next.getCallsPerHost().incrementAndGet();
                    arrayList.add(next);
                    this.runningAsyncCalls.add(next);
                }
            }
            z = runningCallsCount() > 0;
            t1 t1Var = t1.a;
        }
        int size = arrayList.size();
        for (i2 = 0; i2 < size; i2++) {
            ((RealCall.AsyncCall) arrayList.get(i2)).executeOn(executorService());
        }
        return z;
    }

    @g(name = "-deprecated_executorService")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "executorService", imports = {}))
    @d
    /* renamed from: -deprecated_executorService  reason: not valid java name */
    public final ExecutorService m157deprecated_executorService() {
        return executorService();
    }

    public final synchronized void cancelAll() {
        Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
        while (it.hasNext()) {
            it.next().getCall().cancel();
        }
        Iterator<RealCall.AsyncCall> it2 = this.runningAsyncCalls.iterator();
        while (it2.hasNext()) {
            it2.next().getCall().cancel();
        }
        Iterator<RealCall> it3 = this.runningSyncCalls.iterator();
        while (it3.hasNext()) {
            it3.next().cancel();
        }
    }

    public final void enqueue$okhttp(@d RealCall.AsyncCall asyncCall) {
        RealCall.AsyncCall findExistingCallWithHost;
        synchronized (this) {
            this.readyAsyncCalls.add(asyncCall);
            if (!asyncCall.getCall().getForWebSocket() && (findExistingCallWithHost = findExistingCallWithHost(asyncCall.getHost())) != null) {
                asyncCall.reuseCallsPerHostFrom(findExistingCallWithHost);
            }
            t1 t1Var = t1.a;
        }
        promoteAndExecute();
    }

    public final synchronized void executed$okhttp(@d RealCall realCall) {
        this.runningSyncCalls.add(realCall);
    }

    @g(name = "executorService")
    @d
    public final synchronized ExecutorService executorService() {
        if (this.executorServiceOrNull == null) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            SynchronousQueue synchronousQueue = new SynchronousQueue();
            this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, Util.threadFactory(Util.okHttpName + " Dispatcher", false));
        }
        return this.executorServiceOrNull;
    }

    public final void finished$okhttp(@d RealCall.AsyncCall asyncCall) {
        asyncCall.getCallsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, asyncCall);
    }

    @e
    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    @d
    public final synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        ArrayDeque<RealCall.AsyncCall> arrayDeque = this.readyAsyncCalls;
        arrayList = new ArrayList(u.Y(arrayDeque, 10));
        for (RealCall.AsyncCall asyncCall : arrayDeque) {
            arrayList.add(asyncCall.getCall());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    @d
    public final synchronized List<Call> runningCalls() {
        ArrayDeque<RealCall> arrayDeque;
        ArrayList arrayList;
        arrayDeque = this.runningSyncCalls;
        ArrayDeque<RealCall.AsyncCall> arrayDeque2 = this.runningAsyncCalls;
        arrayList = new ArrayList(u.Y(arrayDeque2, 10));
        for (RealCall.AsyncCall asyncCall : arrayDeque2) {
            arrayList.add(asyncCall.getCall());
        }
        return Collections.unmodifiableList(CollectionsKt___CollectionsKt.q4(arrayDeque, arrayList));
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void setIdleCallback(@e Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final void setMaxRequests(int i2) {
        if (i2 >= 1) {
            synchronized (this) {
                this.maxRequests = i2;
                t1 t1Var = t1.a;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(("max < 1: " + i2).toString());
    }

    public final void setMaxRequestsPerHost(int i2) {
        if (i2 >= 1) {
            synchronized (this) {
                this.maxRequestsPerHost = i2;
                t1 t1Var = t1.a;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(("max < 1: " + i2).toString());
    }

    public final void finished$okhttp(@d RealCall realCall) {
        finished(this.runningSyncCalls, realCall);
    }

    public Dispatcher(@d ExecutorService executorService) {
        this();
        this.executorServiceOrNull = executorService;
    }
}
