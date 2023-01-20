package com.moor.imkf.lib.jobqueue.inMemoryQueue;

import androidx.annotation.NonNull;
import com.moor.imkf.lib.jobqueue.base.Constraint;
import com.moor.imkf.lib.jobqueue.base.JobHolder;
import com.moor.imkf.lib.jobqueue.base.JobQueue;
import com.moor.imkf.lib.jobqueue.config.Configuration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class SimpleInMemoryPriorityQueue implements JobQueue {
    private final long sessionId;
    private final TreeSet<JobHolder> jobs = new TreeSet<>(new Comparator<JobHolder>() { // from class: com.moor.imkf.lib.jobqueue.inMemoryQueue.SimpleInMemoryPriorityQueue.1
        private int compareInt(int i2, int i3) {
            if (i2 > i3) {
                return -1;
            }
            return i3 > i2 ? 1 : 0;
        }

        private int compareLong(long j2, long j3) {
            if (j2 > j3) {
                return -1;
            }
            return j3 > j2 ? 1 : 0;
        }

        @Override // java.util.Comparator
        public int compare(JobHolder jobHolder, JobHolder jobHolder2) {
            if (jobHolder.getJob().getId().equals(jobHolder2.getJob().getId())) {
                return 0;
            }
            int compareInt = compareInt(jobHolder.getPriority(), jobHolder2.getPriority());
            if (compareInt != 0) {
                return compareInt;
            }
            int i2 = -compareLong(jobHolder.getCreatedNs(), jobHolder2.getCreatedNs());
            return i2 != 0 ? i2 : -compareLong(jobHolder.getInsertionOrder().longValue(), jobHolder2.getInsertionOrder().longValue());
        }
    });
    private final Map<String, JobHolder> idCache = new HashMap();
    private final AtomicLong insertionOrderCounter = new AtomicLong(0);
    private final List<String> reusedList = new ArrayList();

    public SimpleInMemoryPriorityQueue(Configuration configuration, long j2) {
        this.sessionId = j2;
    }

    private static boolean matches(JobHolder jobHolder, Constraint constraint, boolean z) {
        if ((constraint.getNowInNs() >= jobHolder.getDeadlineNs() || (z && jobHolder.hasDeadline())) || constraint.getMaxNetworkType() >= jobHolder.getRequiredNetworkType()) {
            if (constraint.getTimeLimit() == null || jobHolder.getDelayUntilNs() <= constraint.getTimeLimit().longValue()) {
                if ((jobHolder.getGroupId() == null || !constraint.getExcludeGroups().contains(jobHolder.getGroupId())) && !constraint.getExcludeJobIds().contains(jobHolder.getId())) {
                    return constraint.getTagConstraint() == null || !(jobHolder.getTags() == null || constraint.getTags().isEmpty() || !constraint.getTagConstraint().matches(constraint.getTags(), jobHolder.getTags()));
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public void clear() {
        this.jobs.clear();
        this.idCache.clear();
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public int count() {
        return this.jobs.size();
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public int countReadyJobs(@NonNull Constraint constraint) {
        this.reusedList.clear();
        Iterator<JobHolder> it = this.jobs.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            JobHolder next = it.next();
            String groupId = next.getGroupId();
            if (groupId == null || !this.reusedList.contains(groupId)) {
                if (matches(next, constraint, false)) {
                    i2++;
                    if (groupId != null) {
                        this.reusedList.add(groupId);
                    }
                }
            }
        }
        this.reusedList.clear();
        return i2;
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public JobHolder findJobById(@NonNull String str) {
        return this.idCache.get(str);
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    @NonNull
    public Set<JobHolder> findJobs(@NonNull Constraint constraint) {
        HashSet hashSet = new HashSet();
        Iterator<JobHolder> it = this.jobs.iterator();
        while (it.hasNext()) {
            JobHolder next = it.next();
            if (matches(next, constraint, false)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public Long getNextJobDelayUntilNs(@NonNull Constraint constraint) {
        long delayUntilNs;
        Iterator<JobHolder> it = this.jobs.iterator();
        Long l2 = null;
        while (it.hasNext()) {
            JobHolder next = it.next();
            boolean z = true;
            if (matches(next, constraint, true)) {
                z = (next.hasDelay() && matches(next, constraint, false)) ? false : false;
                boolean hasDeadline = next.hasDeadline();
                if (hasDeadline == z) {
                    delayUntilNs = Math.min(next.getDeadlineNs(), next.getDelayUntilNs());
                } else if (hasDeadline) {
                    delayUntilNs = next.getDeadlineNs();
                } else {
                    delayUntilNs = next.getDelayUntilNs();
                }
                if (l2 == null || delayUntilNs < l2.longValue()) {
                    l2 = Long.valueOf(delayUntilNs);
                }
            }
        }
        return l2;
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public boolean insert(@NonNull JobHolder jobHolder) {
        jobHolder.setInsertionOrder(this.insertionOrderCounter.incrementAndGet());
        if (this.idCache.get(jobHolder.getId()) == null) {
            this.idCache.put(jobHolder.getId(), jobHolder);
            this.jobs.add(jobHolder);
            return true;
        }
        throw new IllegalArgumentException("cannot add a job with the same id twice");
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public boolean insertOrReplace(@NonNull JobHolder jobHolder) {
        if (jobHolder.getInsertionOrder() == null) {
            return insert(jobHolder);
        }
        JobHolder jobHolder2 = this.idCache.get(jobHolder.getId());
        if (jobHolder2 != null) {
            remove(jobHolder2);
        }
        this.idCache.put(jobHolder.getId(), jobHolder);
        this.jobs.add(jobHolder);
        return true;
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public JobHolder nextJobAndIncRunCount(@NonNull Constraint constraint) {
        Iterator<JobHolder> it = this.jobs.iterator();
        while (it.hasNext()) {
            JobHolder next = it.next();
            if (matches(next, constraint, false)) {
                remove(next);
                next.setRunCount(next.getRunCount() + 1);
                next.setRunningSessionId(this.sessionId);
                return next;
            }
        }
        return null;
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public void onJobCancelled(JobHolder jobHolder) {
        remove(jobHolder);
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public void remove(@NonNull JobHolder jobHolder) {
        this.idCache.remove(jobHolder.getId());
        this.jobs.remove(jobHolder);
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public void substitute(@NonNull JobHolder jobHolder, @NonNull JobHolder jobHolder2) {
        remove(jobHolder2);
        insert(jobHolder);
    }
}
