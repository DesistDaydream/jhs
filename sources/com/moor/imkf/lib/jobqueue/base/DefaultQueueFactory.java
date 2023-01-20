package com.moor.imkf.lib.jobqueue.base;

import com.moor.imkf.lib.jobqueue.cachedQueue.CachedJobQueue;
import com.moor.imkf.lib.jobqueue.config.Configuration;
import com.moor.imkf.lib.jobqueue.inMemoryQueue.SimpleInMemoryPriorityQueue;
import com.moor.imkf.lib.jobqueue.persistentQueue.sqlite.SqliteJobQueue;

/* loaded from: classes2.dex */
public class DefaultQueueFactory implements QueueFactory {
    public SqliteJobQueue.JobSerializer jobSerializer;

    public DefaultQueueFactory() {
        this.jobSerializer = new SqliteJobQueue.JavaSerializer();
    }

    @Override // com.moor.imkf.lib.jobqueue.base.QueueFactory
    public JobQueue createNonPersistent(Configuration configuration, long j2) {
        return new CachedJobQueue(new SimpleInMemoryPriorityQueue(configuration, j2));
    }

    @Override // com.moor.imkf.lib.jobqueue.base.QueueFactory
    public JobQueue createPersistentQueue(Configuration configuration, long j2) {
        return new CachedJobQueue(new SqliteJobQueue(configuration, j2, this.jobSerializer));
    }

    public DefaultQueueFactory(SqliteJobQueue.JobSerializer jobSerializer) {
        this.jobSerializer = jobSerializer;
    }
}
