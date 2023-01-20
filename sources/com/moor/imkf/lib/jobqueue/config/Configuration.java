package com.moor.imkf.lib.jobqueue.config;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.moor.imkf.lib.jobqueue.base.DefaultQueueFactory;
import com.moor.imkf.lib.jobqueue.base.QueueFactory;
import com.moor.imkf.lib.jobqueue.di.DependencyInjector;
import com.moor.imkf.lib.jobqueue.log.CustomLogger;
import com.moor.imkf.lib.jobqueue.log.JqLog;
import com.moor.imkf.lib.jobqueue.network.NetworkUtil;
import com.moor.imkf.lib.jobqueue.network.NetworkUtilImpl;
import com.moor.imkf.lib.jobqueue.persistentQueue.sqlite.SqliteJobQueue;
import com.moor.imkf.lib.jobqueue.scheduling.Scheduler;
import com.moor.imkf.lib.jobqueue.timer.SystemTimer;
import com.moor.imkf.lib.jobqueue.timer.Timer;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class Configuration {
    public static final String DEFAULT_ID = "default_job_manager";
    public static final int DEFAULT_LOAD_FACTOR_PER_CONSUMER = 3;
    public static final int DEFAULT_THREAD_KEEP_ALIVE_SECONDS = 15;
    public static final int DEFAULT_THREAD_PRIORITY = 5;
    public static final int MAX_CONSUMER_COUNT = 5;
    public static final int MIN_CONSUMER_COUNT = 0;
    public Context appContext;
    public boolean batchSchedulerRequests;
    public int consumerKeepAlive;
    public CustomLogger customLogger;
    public DependencyInjector dependencyInjector;
    public String id;
    public boolean inTestMode;
    public int loadFactor;
    public int maxConsumerCount;
    public int minConsumerCount;
    public NetworkUtil networkUtil;
    public QueueFactory queueFactory;
    public boolean resetDelaysOnRestart;
    public Scheduler scheduler;
    public ThreadFactory threadFactory;
    public int threadPriority;
    public Timer timer;

    public boolean batchSchedulerRequests() {
        return this.batchSchedulerRequests;
    }

    @NonNull
    public Context getAppContext() {
        return this.appContext;
    }

    public int getConsumerKeepAlive() {
        return this.consumerKeepAlive;
    }

    @Nullable
    public CustomLogger getCustomLogger() {
        return this.customLogger;
    }

    @Nullable
    public DependencyInjector getDependencyInjector() {
        return this.dependencyInjector;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    public int getLoadFactor() {
        return this.loadFactor;
    }

    public int getMaxConsumerCount() {
        return this.maxConsumerCount;
    }

    public int getMinConsumerCount() {
        return this.minConsumerCount;
    }

    @NonNull
    public NetworkUtil getNetworkUtil() {
        return this.networkUtil;
    }

    @NonNull
    public QueueFactory getQueueFactory() {
        return this.queueFactory;
    }

    @Nullable
    public Scheduler getScheduler() {
        return this.scheduler;
    }

    @Nullable
    public ThreadFactory getThreadFactory() {
        return this.threadFactory;
    }

    public int getThreadPriority() {
        return this.threadPriority;
    }

    @NonNull
    public Timer getTimer() {
        return this.timer;
    }

    public boolean isInTestMode() {
        return this.inTestMode;
    }

    public boolean resetDelaysOnRestart() {
        return this.resetDelaysOnRestart;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private Configuration configuration;
        private Pattern idRegex = Pattern.compile("^([A-Za-z]|[0-9]|_|-)+$");

        public Builder(@NonNull Context context) {
            Configuration configuration = new Configuration();
            this.configuration = configuration;
            configuration.appContext = context.getApplicationContext();
        }

        @NonNull
        public Configuration build() {
            Configuration configuration = this.configuration;
            if (configuration.queueFactory == null) {
                configuration.queueFactory = new DefaultQueueFactory();
            }
            Configuration configuration2 = this.configuration;
            if (configuration2.networkUtil == null) {
                configuration2.networkUtil = new NetworkUtilImpl(configuration2.appContext);
            }
            Configuration configuration3 = this.configuration;
            if (configuration3.timer == null) {
                configuration3.timer = new SystemTimer();
            }
            return this.configuration;
        }

        @NonNull
        public Builder consumerKeepAlive(int i2) {
            this.configuration.consumerKeepAlive = i2;
            return this;
        }

        @NonNull
        public Builder consumerThreadPriority(int i2) {
            this.configuration.threadPriority = i2;
            return this;
        }

        @NonNull
        public Builder customLogger(@Nullable CustomLogger customLogger) {
            this.configuration.customLogger = customLogger;
            return this;
        }

        @NonNull
        public Builder id(@NonNull String str) {
            if (str != null && this.idRegex.matcher(str).matches()) {
                this.configuration.id = str;
                return this;
            }
            throw new IllegalArgumentException("id cannot be null or empty and can only include alphanumeric characters, - or _ .");
        }

        @NonNull
        public Builder inTestMode() {
            this.configuration.inTestMode = true;
            return this;
        }

        @NonNull
        public Builder injector(@Nullable DependencyInjector dependencyInjector) {
            this.configuration.dependencyInjector = dependencyInjector;
            return this;
        }

        @NonNull
        public Builder jobSerializer(@NonNull SqliteJobQueue.JobSerializer jobSerializer) {
            this.configuration.queueFactory = new DefaultQueueFactory(jobSerializer);
            return this;
        }

        @NonNull
        public Builder loadFactor(int i2) {
            this.configuration.loadFactor = i2;
            return this;
        }

        @NonNull
        public Builder maxConsumerCount(int i2) {
            this.configuration.maxConsumerCount = i2;
            return this;
        }

        @NonNull
        public Builder minConsumerCount(int i2) {
            this.configuration.minConsumerCount = i2;
            return this;
        }

        @NonNull
        public Builder networkUtil(@Nullable NetworkUtil networkUtil) {
            this.configuration.networkUtil = networkUtil;
            return this;
        }

        @NonNull
        public Builder queueFactory(@Nullable QueueFactory queueFactory) {
            Configuration configuration = this.configuration;
            if (configuration.queueFactory != null && queueFactory != null) {
                throw new RuntimeException("already set a queue factory. This might happen ifyou've provided a custom job serializer");
            }
            configuration.queueFactory = queueFactory;
            return this;
        }

        @NonNull
        public Builder resetDelaysOnRestart() {
            this.configuration.resetDelaysOnRestart = true;
            return this;
        }

        @NonNull
        public Builder scheduler(@Nullable Scheduler scheduler, boolean z) {
            Configuration configuration = this.configuration;
            configuration.scheduler = scheduler;
            configuration.batchSchedulerRequests = z;
            return this;
        }

        @NonNull
        public Builder threadFactory(@Nullable ThreadFactory threadFactory) {
            this.configuration.threadFactory = threadFactory;
            return this;
        }

        @NonNull
        public Builder timer(@Nullable Timer timer) {
            this.configuration.timer = timer;
            return this;
        }

        @NonNull
        public Builder scheduler(@Nullable Scheduler scheduler) {
            return scheduler(scheduler, true);
        }
    }

    private Configuration() {
        this.id = DEFAULT_ID;
        this.maxConsumerCount = 5;
        this.minConsumerCount = 0;
        this.consumerKeepAlive = 15;
        this.loadFactor = 3;
        this.customLogger = new JqLog.ErrorLogger();
        this.inTestMode = false;
        this.resetDelaysOnRestart = false;
        this.threadPriority = 5;
        this.batchSchedulerRequests = true;
        this.threadFactory = null;
    }
}
