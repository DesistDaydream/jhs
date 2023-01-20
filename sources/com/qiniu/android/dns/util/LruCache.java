package com.qiniu.android.dns.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class LruCache<K, V> extends LinkedHashMap<K, V> {
    private int size;

    public LruCache() {
        this(256);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.size;
    }

    public LruCache(int i2) {
        super(i2, 1.0f, true);
        this.size = i2;
    }
}
