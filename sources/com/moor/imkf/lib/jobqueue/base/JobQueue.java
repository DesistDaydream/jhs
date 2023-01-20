package com.moor.imkf.lib.jobqueue.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Set;

/* loaded from: classes2.dex */
public interface JobQueue {
    void clear();

    int count();

    int countReadyJobs(@NonNull Constraint constraint);

    @Nullable
    JobHolder findJobById(@NonNull String str);

    @NonNull
    Set<JobHolder> findJobs(@NonNull Constraint constraint);

    @Nullable
    Long getNextJobDelayUntilNs(@NonNull Constraint constraint);

    boolean insert(@NonNull JobHolder jobHolder);

    boolean insertOrReplace(@NonNull JobHolder jobHolder);

    @Nullable
    JobHolder nextJobAndIncRunCount(@NonNull Constraint constraint);

    void onJobCancelled(JobHolder jobHolder);

    void remove(@NonNull JobHolder jobHolder);

    void substitute(@NonNull JobHolder jobHolder, @NonNull JobHolder jobHolder2);
}
