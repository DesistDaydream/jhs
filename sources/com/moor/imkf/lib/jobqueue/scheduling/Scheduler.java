package com.moor.imkf.lib.jobqueue.scheduling;

import android.content.Context;

/* loaded from: classes2.dex */
public abstract class Scheduler {
    private Callback callback;
    private Context context;

    /* loaded from: classes2.dex */
    public interface Callback {
        boolean start(SchedulerConstraint schedulerConstraint);

        boolean stop(SchedulerConstraint schedulerConstraint);
    }

    public abstract void cancelAll();

    public Context getApplicationContext() {
        return this.context;
    }

    public void init(Context context, Callback callback) {
        this.context = context.getApplicationContext();
        this.callback = callback;
    }

    public abstract void onFinished(SchedulerConstraint schedulerConstraint, boolean z);

    public abstract void request(SchedulerConstraint schedulerConstraint);

    public final boolean start(SchedulerConstraint schedulerConstraint) {
        Callback callback = this.callback;
        if (callback != null) {
            return callback.start(schedulerConstraint);
        }
        throw new IllegalStateException("JobManager callback is not configured");
    }

    public final boolean stop(SchedulerConstraint schedulerConstraint) {
        Callback callback = this.callback;
        if (callback != null) {
            return callback.stop(schedulerConstraint);
        }
        throw new IllegalStateException("JobManager callback is not configured");
    }
}
