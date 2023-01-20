package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public final class v {
    private static v a;

    /* renamed from: c */
    private final Context f6794c;

    /* renamed from: e */
    private long f6796e;

    /* renamed from: f */
    private long f6797f;

    /* renamed from: d */
    private Map<Integer, Long> f6795d = new HashMap();

    /* renamed from: g */
    private LinkedBlockingQueue<Runnable> f6798g = new LinkedBlockingQueue<>();

    /* renamed from: h */
    private LinkedBlockingQueue<Runnable> f6799h = new LinkedBlockingQueue<>();

    /* renamed from: i */
    private final Object f6800i = new Object();

    /* renamed from: j */
    private int f6801j = 0;
    private final o b = o.a();

    private v(Context context) {
        this.f6794c = context;
    }

    public static /* synthetic */ int b(v vVar) {
        int i2 = vVar.f6801j - 1;
        vVar.f6801j = i2;
        return i2;
    }

    private void c(int i2) {
        x a2 = x.a();
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        final LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.f6800i) {
            y.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            int size = this.f6798g.size();
            final int size2 = this.f6799h.size();
            if (size == 0 && size2 == 0) {
                y.c("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            size2 = (a2 == null || !a2.c()) ? 0 : 0;
            a(this.f6798g, linkedBlockingQueue, size);
            a(this.f6799h, linkedBlockingQueue2, size2);
            a(size, linkedBlockingQueue);
            if (size2 > 0) {
                y.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            x a3 = x.a();
            if (a3 != null) {
                a3.a(new Runnable(this) { // from class: com.tencent.bugly.proguard.v.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Runnable runnable;
                        for (int i3 = 0; i3 < size2 && (runnable = (Runnable) linkedBlockingQueue2.poll()) != null; i3++) {
                            runnable.run();
                        }
                    }
                });
            }
        }
    }

    public static synchronized v a(Context context) {
        v vVar;
        synchronized (v.class) {
            if (a == null) {
                a = new v(context);
            }
            vVar = a;
        }
        return vVar;
    }

    public final boolean b(int i2) {
        if (com.tencent.bugly.b.f6489c) {
            y.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i2);
        y.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i2));
        if (currentTimeMillis < JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS) {
            y.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
            return false;
        }
        return true;
    }

    public static synchronized v a() {
        v vVar;
        synchronized (v.class) {
            vVar = a;
        }
        return vVar;
    }

    public final void a(int i2, an anVar, String str, String str2, u uVar, long j2, boolean z) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(new w(this.f6794c, i2, anVar.f6703g, a.a((Object) anVar), str, str2, uVar, true, z), true, true, j2);
        } catch (Throwable th2) {
            th = th2;
            if (y.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(int i2, an anVar, String str, String str2, u uVar, boolean z) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(new w(this.f6794c, i2, anVar.f6703g, a.a((Object) anVar), str, str2, uVar, 0, 0, false, null), z, false, 0L);
        } catch (Throwable th2) {
            th = th2;
            if (y.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final long a(boolean z) {
        long j2;
        long b = ab.b();
        int i2 = z ? 5 : 3;
        List<q> a2 = this.b.a(i2);
        if (a2 != null && a2.size() > 0) {
            j2 = 0;
            try {
                q qVar = a2.get(0);
                if (qVar.f6784e >= b) {
                    j2 = ab.b(qVar.f6786g);
                    if (i2 == 3) {
                        this.f6796e = j2;
                    } else {
                        this.f6797f = j2;
                    }
                    a2.remove(qVar);
                }
            } catch (Throwable th) {
                y.a(th);
            }
            if (a2.size() > 0) {
                this.b.a(a2);
            }
        } else {
            j2 = z ? this.f6797f : this.f6796e;
        }
        y.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j2 / 1024));
        return j2;
    }

    public final synchronized void a(long j2, boolean z) {
        int i2 = z ? 5 : 3;
        q qVar = new q();
        qVar.b = i2;
        qVar.f6784e = ab.b();
        qVar.f6782c = "";
        qVar.f6783d = "";
        qVar.f6786g = ab.c(j2);
        this.b.b(i2);
        this.b.a(qVar);
        if (z) {
            this.f6797f = j2;
        } else {
            this.f6796e = j2;
        }
        y.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j2 / 1024));
    }

    public final synchronized void a(int i2, long j2) {
        if (i2 < 0) {
            y.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i2));
            return;
        }
        this.f6795d.put(Integer.valueOf(i2), Long.valueOf(j2));
        q qVar = new q();
        qVar.b = i2;
        qVar.f6784e = j2;
        qVar.f6782c = "";
        qVar.f6783d = "";
        qVar.f6786g = new byte[0];
        this.b.b(i2);
        this.b.a(qVar);
        y.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i2), ab.a(j2));
    }

    public final synchronized long a(int i2) {
        if (i2 >= 0) {
            Long l2 = this.f6795d.get(Integer.valueOf(i2));
            if (l2 != null) {
                return l2.longValue();
            }
        } else {
            y.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i2));
        }
        return 0L;
    }

    private static void a(LinkedBlockingQueue<Runnable> linkedBlockingQueue, LinkedBlockingQueue<Runnable> linkedBlockingQueue2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            Runnable peek = linkedBlockingQueue.peek();
            if (peek == null) {
                return;
            }
            try {
                linkedBlockingQueue2.put(peek);
                linkedBlockingQueue.poll();
            } catch (Throwable th) {
                y.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
            }
        }
    }

    private void a(int i2, LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        x a2 = x.a();
        if (i2 > 0) {
            y.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(i2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        }
        for (int i3 = 0; i3 < i2; i3++) {
            final Runnable poll = linkedBlockingQueue.poll();
            if (poll == null) {
                return;
            }
            synchronized (this.f6800i) {
                if (this.f6801j >= 2 && a2 != null) {
                    a2.a(poll);
                } else {
                    y.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                    if (ab.a(new Runnable() { // from class: com.tencent.bugly.proguard.v.1
                        {
                            v.this = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            poll.run();
                            synchronized (v.this.f6800i) {
                                v.b(v.this);
                            }
                        }
                    }, "BUGLY_ASYNC_UPLOAD") != null) {
                        synchronized (this.f6800i) {
                            this.f6801j++;
                        }
                    } else {
                        y.d("[UploadManager] Failed to start a thread to execute asynchronous upload task,will try again next time.", new Object[0]);
                        a(poll, true);
                    }
                }
            }
        }
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            y.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            y.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f6800i) {
                if (z) {
                    this.f6798g.put(runnable);
                } else {
                    this.f6799h.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            y.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, boolean z, boolean z2, long j2) {
        if (runnable == null) {
            y.d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        y.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (!z2) {
            a(runnable, z);
            c(0);
        } else if (runnable == null) {
            y.d("[UploadManager] Upload task should not be null", new Object[0]);
        } else {
            y.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            Thread a2 = ab.a(runnable, "BUGLY_SYNC_UPLOAD");
            if (a2 == null) {
                y.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
                a(runnable, true);
                return;
            }
            try {
                a2.join(j2);
            } catch (Throwable th) {
                y.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
                a(runnable, true);
                c(0);
            }
        }
    }
}
