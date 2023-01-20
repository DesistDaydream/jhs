package com.moor.imkf.lib.jobqueue.base;

import com.moor.imkf.lib.jobqueue.config.Configuration;

/* loaded from: classes2.dex */
public interface QueueFactory {
    JobQueue createNonPersistent(Configuration configuration, long j2);

    JobQueue createPersistentQueue(Configuration configuration, long j2);
}
