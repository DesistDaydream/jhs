package com.moor.imkf.lib.jobqueue.base;

import com.moor.imkf.lib.jobqueue.log.JqLog;
import com.moor.imkf.lib.jobqueue.timer.Timer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/* loaded from: classes2.dex */
public class RunningJobSet {
    private ArrayList<String> publicClone;
    private final Timer timer;
    private final TreeSet<String> internalSet = new TreeSet<>();
    private final Map<String, Long> groupDelays = new HashMap();
    private long groupDelayTimeout = Long.MAX_VALUE;

    public RunningJobSet(Timer timer) {
        this.timer = timer;
    }

    private long calculateNextDelayForGroups() {
        long j2 = Long.MAX_VALUE;
        for (Long l2 : this.groupDelays.values()) {
            if (l2.longValue() < j2) {
                j2 = l2.longValue();
            }
        }
        return j2;
    }

    public synchronized void add(String str) {
        if (str == null) {
            return;
        }
        if (this.internalSet.add(str)) {
            this.publicClone = null;
        }
    }

    public synchronized void addGroupUntil(String str, long j2) {
        JqLog.d("add group delay to %s until %s", str, Long.valueOf(j2));
        Long l2 = this.groupDelays.get(str);
        if (l2 == null || l2.longValue() <= j2) {
            this.groupDelays.put(str, Long.valueOf(j2));
            this.groupDelayTimeout = calculateNextDelayForGroups();
            this.publicClone = null;
        }
    }

    public synchronized void clear() {
        this.internalSet.clear();
        this.groupDelays.clear();
        this.publicClone = null;
    }

    public Long getNextDelayForGroups() {
        long j2 = this.groupDelayTimeout;
        if (j2 == Long.MAX_VALUE) {
            return null;
        }
        return Long.valueOf(j2);
    }

    public synchronized Collection<String> getSafe() {
        long nanoTime = this.timer.nanoTime();
        if (this.publicClone == null || nanoTime > this.groupDelayTimeout) {
            if (this.groupDelays.isEmpty()) {
                this.publicClone = new ArrayList<>(this.internalSet);
                this.groupDelayTimeout = Long.MAX_VALUE;
            } else {
                TreeSet treeSet = new TreeSet((SortedSet) this.internalSet);
                Iterator<Map.Entry<String, Long>> it = this.groupDelays.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, Long> next = it.next();
                    if (next.getValue().longValue() > nanoTime) {
                        if (!treeSet.contains(next.getKey())) {
                            treeSet.add(next.getKey());
                        }
                    } else {
                        it.remove();
                    }
                }
                this.publicClone = new ArrayList<>(treeSet);
                this.groupDelayTimeout = calculateNextDelayForGroups();
            }
        }
        return this.publicClone;
    }

    public synchronized void remove(String str) {
        if (str == null) {
            return;
        }
        if (this.internalSet.remove(str)) {
            this.publicClone = null;
        }
    }
}
