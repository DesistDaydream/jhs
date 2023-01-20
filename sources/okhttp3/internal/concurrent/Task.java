package okhttp3.internal.concurrent;

import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\tR\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\r¨\u0006!"}, d2 = {"Lokhttp3/internal/concurrent/Task;", "", "", "runOnce", "()J", "Lokhttp3/internal/concurrent/TaskQueue;", "queue", "Lh/t1;", "initQueue$okhttp", "(Lokhttp3/internal/concurrent/TaskQueue;)V", "initQueue", "", "toString", "()Ljava/lang/String;", "Lokhttp3/internal/concurrent/TaskQueue;", "getQueue$okhttp", "()Lokhttp3/internal/concurrent/TaskQueue;", "setQueue$okhttp", "", "cancelable", "Z", "getCancelable", "()Z", "nextExecuteNanoTime", "J", "getNextExecuteNanoTime$okhttp", "setNextExecuteNanoTime$okhttp", "(J)V", "name", "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;Z)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class Task {
    private final boolean cancelable;
    @d
    private final String name;
    private long nextExecuteNanoTime;
    @e
    private TaskQueue queue;

    public Task(@d String str, boolean z) {
        this.name = str;
        this.cancelable = z;
        this.nextExecuteNanoTime = -1L;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    @d
    public final String getName() {
        return this.name;
    }

    public final long getNextExecuteNanoTime$okhttp() {
        return this.nextExecuteNanoTime;
    }

    @e
    public final TaskQueue getQueue$okhttp() {
        return this.queue;
    }

    public final void initQueue$okhttp(@d TaskQueue taskQueue) {
        TaskQueue taskQueue2 = this.queue;
        if (taskQueue2 == taskQueue) {
            return;
        }
        if (taskQueue2 == null) {
            this.queue = taskQueue;
            return;
        }
        throw new IllegalStateException("task is in multiple queues".toString());
    }

    public abstract long runOnce();

    public final void setNextExecuteNanoTime$okhttp(long j2) {
        this.nextExecuteNanoTime = j2;
    }

    public final void setQueue$okhttp(@e TaskQueue taskQueue) {
        this.queue = taskQueue;
    }

    @d
    public String toString() {
        return this.name;
    }

    public /* synthetic */ Task(String str, boolean z, int i2, u uVar) {
        this(str, (i2 & 2) != 0 ? true : z);
    }
}
