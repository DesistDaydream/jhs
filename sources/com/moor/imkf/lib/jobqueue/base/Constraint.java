package com.moor.imkf.lib.jobqueue.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class Constraint {
    private boolean excludeRunning;
    private int maxNetworkType;
    private long nowInNs;
    private TagConstraint tagConstraint;
    private Long timeLimit;
    private final Set<String> tags = new HashSet();
    private final List<String> excludeGroups = new ArrayList();
    private final List<String> excludeJobIds = new ArrayList();

    public void clear() {
        this.maxNetworkType = 2;
        this.tagConstraint = null;
        this.tags.clear();
        this.excludeGroups.clear();
        this.excludeJobIds.clear();
        this.excludeRunning = false;
        this.timeLimit = null;
        this.nowInNs = Long.MIN_VALUE;
    }

    public boolean excludeRunning() {
        return this.excludeRunning;
    }

    public List<String> getExcludeGroups() {
        return this.excludeGroups;
    }

    public List<String> getExcludeJobIds() {
        return this.excludeJobIds;
    }

    public int getMaxNetworkType() {
        return this.maxNetworkType;
    }

    public long getNowInNs() {
        return this.nowInNs;
    }

    public TagConstraint getTagConstraint() {
        return this.tagConstraint;
    }

    public Set<String> getTags() {
        return this.tags;
    }

    public Long getTimeLimit() {
        return this.timeLimit;
    }

    public void setExcludeGroups(Collection<String> collection) {
        this.excludeGroups.clear();
        if (collection != null) {
            this.excludeGroups.addAll(collection);
        }
    }

    public void setExcludeJobIds(Collection<String> collection) {
        this.excludeJobIds.clear();
        if (collection != null) {
            this.excludeJobIds.addAll(collection);
        }
    }

    public void setExcludeRunning(boolean z) {
        this.excludeRunning = z;
    }

    public void setMaxNetworkType(int i2) {
        this.maxNetworkType = i2;
    }

    public void setNowInNs(long j2) {
        this.nowInNs = j2;
    }

    public void setTagConstraint(TagConstraint tagConstraint) {
        this.tagConstraint = tagConstraint;
    }

    public void setTags(String[] strArr) {
        this.tags.clear();
        if (strArr != null) {
            Collections.addAll(this.tags, strArr);
        }
    }

    public void setTimeLimit(Long l2) {
        this.timeLimit = l2;
    }
}
