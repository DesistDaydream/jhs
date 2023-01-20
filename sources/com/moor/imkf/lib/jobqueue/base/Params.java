package com.moor.imkf.lib.jobqueue.base;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;

/* loaded from: classes2.dex */
public class Params {
    public static final long FOREVER = Long.MAX_VALUE;
    public static final long NEVER = Long.MIN_VALUE;
    private Boolean cancelOnDeadline;
    private long delayMs;
    private int priority;
    private HashSet<String> tags;
    public int requiredNetworkType = 0;
    private String groupId = null;
    private String singleId = null;
    private boolean persistent = false;
    private long deadlineMs = 0;

    public Params(int i2) {
        this.priority = i2;
    }

    public Params addTags(String... strArr) {
        if (this.tags == null) {
            this.tags = new HashSet<>();
        }
        Collections.addAll(this.tags, strArr);
        return this;
    }

    public Params clearTags() {
        this.tags = null;
        return this;
    }

    public Params delayInMs(long j2) {
        this.delayMs = j2;
        return this;
    }

    @Nullable
    public Boolean getCancelOnDeadline() {
        return this.cancelOnDeadline;
    }

    public long getDeadlineMs() {
        return this.deadlineMs;
    }

    public long getDelayMs() {
        return this.delayMs;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getSingleId() {
        return this.singleId;
    }

    public HashSet<String> getTags() {
        return this.tags;
    }

    public Params groupBy(String str) {
        this.groupId = str;
        return this;
    }

    public boolean isNetworkRequired() {
        return this.requiredNetworkType >= 1;
    }

    public boolean isPersistent() {
        return this.persistent;
    }

    public boolean isUnmeteredNetworkRequired() {
        return this.requiredNetworkType >= 2;
    }

    public Params overrideDeadlineToCancelInMs(long j2) {
        if (!Boolean.FALSE.equals(this.cancelOnDeadline)) {
            this.deadlineMs = j2;
            this.cancelOnDeadline = Boolean.TRUE;
            return this;
        }
        throw new IllegalArgumentException("cannot set deadline to cancel and run. You need to pick one");
    }

    public Params overrideDeadlineToRunInMs(long j2) {
        if (!Boolean.TRUE.equals(this.cancelOnDeadline)) {
            this.deadlineMs = j2;
            this.cancelOnDeadline = Boolean.FALSE;
            return this;
        }
        throw new IllegalArgumentException("cannot set deadline to cancel and run. You need to pick one");
    }

    public Params persist() {
        this.persistent = true;
        return this;
    }

    public Params removeTags(String... strArr) {
        if (this.tags == null) {
            return this;
        }
        for (String str : strArr) {
            this.tags.remove(str);
        }
        return this;
    }

    public Params requireNetwork() {
        if (this.requiredNetworkType != 2) {
            this.requiredNetworkType = 1;
        }
        return this;
    }

    public Params requireUnmeteredNetwork() {
        this.requiredNetworkType = 2;
        return this;
    }

    public Params setDelayMs(long j2) {
        this.delayMs = j2;
        return this;
    }

    public Params setGroupId(String str) {
        this.groupId = str;
        return this;
    }

    public Params setPersistent(boolean z) {
        this.persistent = z;
        return this;
    }

    public Params setRequiresNetwork(boolean z) {
        if (z) {
            if (this.requiredNetworkType == 0) {
                this.requiredNetworkType = 1;
            }
        } else {
            this.requiredNetworkType = 0;
        }
        return this;
    }

    public Params setRequiresUnmeteredNetwork(boolean z) {
        if (z) {
            this.requiredNetworkType = 2;
        } else if (this.requiredNetworkType != 1) {
            this.requiredNetworkType = 0;
        }
        return this;
    }

    public Params setSingleId(String str) {
        this.singleId = str;
        return this;
    }

    public boolean shouldCancelOnDeadline() {
        return Boolean.TRUE.equals(this.cancelOnDeadline);
    }

    public Params singleInstanceBy(String str) {
        this.singleId = str;
        return this;
    }
}
