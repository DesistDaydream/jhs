package com.moor.imkf.lib.jobqueue.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes2.dex */
public @interface CancelReason {
    public static final int CANCELLED_VIA_SHOULD_RE_RUN = 5;
    public static final int CANCELLED_WHILE_RUNNING = 3;
    public static final int REACHED_DEADLINE = 7;
    public static final int REACHED_RETRY_LIMIT = 2;
    public static final int SINGLE_INSTANCE_ID_QUEUED = 1;
    public static final int SINGLE_INSTANCE_WHILE_RUNNING = 6;
}
