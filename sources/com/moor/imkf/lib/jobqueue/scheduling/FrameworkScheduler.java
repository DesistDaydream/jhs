package com.moor.imkf.lib.jobqueue.scheduling;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.moor.imkf.lib.jobqueue.log.JqLog;
import java.util.UUID;

@TargetApi(21)
/* loaded from: classes2.dex */
public class FrameworkScheduler extends Scheduler {
    private static final String KEY_DEADLINE = "keyDeadline";
    private static final String KEY_DELAY = "delay";
    @VisibleForTesting
    public static final String KEY_ID = "id";
    private static final String KEY_NETWORK_STATUS = "networkStatus";
    private static final String KEY_UUID = "uuid";
    private ComponentName componentName;
    private JobScheduler jobScheduler;
    @Nullable
    private JobService jobService;
    private SharedPreferences preferences;
    public final Class<? extends FrameworkJobSchedulerService> serviceImpl;

    public FrameworkScheduler(Class<? extends FrameworkJobSchedulerService> cls) {
        this.serviceImpl = cls;
    }

    @VisibleForTesting
    public static SchedulerConstraint fromBundle(PersistableBundle persistableBundle) throws Exception {
        SchedulerConstraint schedulerConstraint = new SchedulerConstraint(persistableBundle.getString(KEY_UUID));
        if (schedulerConstraint.getUuid() == null) {
            schedulerConstraint.setUuid(UUID.randomUUID().toString());
        }
        schedulerConstraint.setNetworkStatus(persistableBundle.getInt(KEY_NETWORK_STATUS, 0));
        schedulerConstraint.setDelayInMs(persistableBundle.getLong(KEY_DELAY, 0L));
        if (persistableBundle.containsKey(KEY_DEADLINE)) {
            schedulerConstraint.setOverrideDeadlineInMs(Long.valueOf(persistableBundle.getLong(KEY_DEADLINE, Long.MAX_VALUE)));
        }
        return schedulerConstraint;
    }

    private SharedPreferences getPreferences(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (FrameworkScheduler.class) {
            if (this.preferences == null) {
                this.preferences = context.getSharedPreferences("jobqueue_fw_scheduler", 0);
            }
            sharedPreferences = this.preferences;
        }
        return sharedPreferences;
    }

    @VisibleForTesting
    public static PersistableBundle toPersistentBundle(SchedulerConstraint schedulerConstraint) {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(KEY_UUID, schedulerConstraint.getUuid());
        persistableBundle.putInt(KEY_NETWORK_STATUS, schedulerConstraint.getNetworkStatus());
        persistableBundle.putLong(KEY_DELAY, schedulerConstraint.getDelayInMs());
        Long overrideDeadlineInMs = schedulerConstraint.getOverrideDeadlineInMs();
        if (overrideDeadlineInMs != null) {
            persistableBundle.putLong(KEY_DEADLINE, overrideDeadlineInMs.longValue());
        }
        return persistableBundle;
    }

    @Override // com.moor.imkf.lib.jobqueue.scheduling.Scheduler
    public void cancelAll() {
        JqLog.d("[FW Scheduler] cancel all", new Object[0]);
        getJobScheduler().cancelAll();
    }

    @SuppressLint({"CommitPrefEdits"})
    @VisibleForTesting
    public int createId() {
        int i2;
        synchronized (FrameworkScheduler.class) {
            SharedPreferences preferences = getPreferences(getApplicationContext());
            i2 = preferences.getInt("id", 0) + 1;
            preferences.edit().putInt("id", i2).commit();
        }
        return i2;
    }

    @VisibleForTesting
    public ComponentName getComponentName() {
        if (this.componentName == null) {
            this.componentName = new ComponentName(getApplicationContext().getPackageName(), this.serviceImpl.getCanonicalName());
        }
        return this.componentName;
    }

    @VisibleForTesting
    public JobScheduler getJobScheduler() {
        if (this.jobScheduler == null) {
            this.jobScheduler = (JobScheduler) getApplicationContext().getSystemService("jobscheduler");
        }
        return this.jobScheduler;
    }

    @Override // com.moor.imkf.lib.jobqueue.scheduling.Scheduler
    public void onFinished(SchedulerConstraint schedulerConstraint, boolean z) {
        JqLog.d("[FW Scheduler] on finished job %s. reschedule:%s", schedulerConstraint, Boolean.valueOf(z));
        JobService jobService = this.jobService;
        if (jobService == null) {
            JqLog.e("[FW Scheduler] scheduler onFinished is called but i don't have a job service", new Object[0]);
            return;
        }
        Object data = schedulerConstraint.getData();
        if (data instanceof JobParameters) {
            jobService.jobFinished((JobParameters) data, z);
        } else {
            JqLog.e("[FW Scheduler] cannot obtain the job parameters", new Object[0]);
        }
    }

    public boolean onStartJob(JobParameters jobParameters) {
        try {
            SchedulerConstraint fromBundle = fromBundle(jobParameters.getExtras());
            JqLog.d("[FW Scheduler] start job %s %d", fromBundle, Integer.valueOf(jobParameters.getJobId()));
            fromBundle.setData(jobParameters);
            return start(fromBundle);
        } catch (Exception e2) {
            JqLog.e(e2, "bad bundle from framework job scheduler start callback.", new Object[0]);
            return false;
        }
    }

    public boolean onStopJob(JobParameters jobParameters) {
        try {
            return stop(fromBundle(jobParameters.getExtras()));
        } catch (Exception e2) {
            JqLog.e(e2, "bad bundle from job scheduler stop callback", new Object[0]);
            return false;
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.scheduling.Scheduler
    @SuppressLint({"SwitchIntDef"})
    public void request(SchedulerConstraint schedulerConstraint) {
        JobScheduler jobScheduler = getJobScheduler();
        int createId = createId();
        JobInfo.Builder persisted = new JobInfo.Builder(createId, getComponentName()).setExtras(toPersistentBundle(schedulerConstraint)).setPersisted(true);
        int networkStatus = schedulerConstraint.getNetworkStatus();
        if (networkStatus == 1) {
            persisted.setRequiredNetworkType(1);
        } else if (networkStatus != 2) {
            persisted.setRequiredNetworkType(0);
            persisted.setRequiresDeviceIdle(true);
        } else {
            persisted.setRequiredNetworkType(2);
        }
        if (schedulerConstraint.getDelayInMs() > 0) {
            persisted.setMinimumLatency(schedulerConstraint.getDelayInMs());
        }
        if (schedulerConstraint.getOverrideDeadlineInMs() != null) {
            persisted.setOverrideDeadline(schedulerConstraint.getOverrideDeadlineInMs().longValue());
        }
        int schedule = jobScheduler.schedule(persisted.build());
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(schedule > 0);
        objArr[1] = Integer.valueOf(schedule);
        objArr[2] = Integer.valueOf(createId);
        JqLog.d("[FW Scheduler] scheduled a framework job. Success? %s id: %d created id: %d", objArr);
    }

    public void setJobService(@Nullable JobService jobService) {
        this.jobService = jobService;
    }
}
