package com.moor.imkf.lib.jobqueue.base;

import java.util.Collection;
import java.util.Set;

/* loaded from: classes2.dex */
public enum TagConstraint {
    ALL,
    ANY;

    public boolean matches(String[] strArr, Set<String> set) {
        if (this == ANY) {
            for (String str : strArr) {
                if (set.contains(str)) {
                    return true;
                }
            }
            return false;
        }
        for (String str2 : strArr) {
            if (!set.contains(str2)) {
                return false;
            }
        }
        return true;
    }

    public boolean matches(Collection<String> collection, Set<String> set) {
        if (this == ANY) {
            for (String str : collection) {
                if (set.contains(str)) {
                    return true;
                }
            }
            return false;
        }
        for (String str2 : collection) {
            if (!set.contains(str2)) {
                return false;
            }
        }
        return true;
    }
}
