package com.j256.ormlite.dao;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class ReferenceObjectCache implements ObjectCache {
    private final ConcurrentHashMap<Class<?>, Map<Object, Reference<Object>>> classMaps = new ConcurrentHashMap<>();
    private final boolean useWeak;

    public ReferenceObjectCache(boolean z) {
        this.useWeak = z;
    }

    private void cleanMap(Map<Object, Reference<Object>> map) {
        Iterator<Map.Entry<Object, Reference<Object>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().get() == null) {
                it.remove();
            }
        }
    }

    private Map<Object, Reference<Object>> getMapForClass(Class<?> cls) {
        Map<Object, Reference<Object>> map = this.classMaps.get(cls);
        if (map == null) {
            return null;
        }
        return map;
    }

    public static ReferenceObjectCache makeSoftCache() {
        return new ReferenceObjectCache(false);
    }

    public static ReferenceObjectCache makeWeakCache() {
        return new ReferenceObjectCache(true);
    }

    public <T> void cleanNullReferences(Class<T> cls) {
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            cleanMap(mapForClass);
        }
    }

    public <T> void cleanNullReferencesAll() {
        for (Map<Object, Reference<Object>> map : this.classMaps.values()) {
            cleanMap(map);
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T> void clear(Class<T> cls) {
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            mapForClass.clear();
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public void clearAll() {
        for (Map<Object, Reference<Object>> map : this.classMaps.values()) {
            map.clear();
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T, ID> T get(Class<T> cls, ID id) {
        Reference<Object> reference;
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass == null || (reference = mapForClass.get(id)) == null) {
            return null;
        }
        T t = (T) reference.get();
        if (t == null) {
            mapForClass.remove(id);
            return null;
        }
        return t;
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T, ID> void put(Class<T> cls, ID id, T t) {
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            if (this.useWeak) {
                mapForClass.put(id, new WeakReference(t));
            } else {
                mapForClass.put(id, new SoftReference(t));
            }
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public synchronized <T> void registerClass(Class<T> cls) {
        if (this.classMaps.get(cls) == null) {
            this.classMaps.put(cls, new ConcurrentHashMap());
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T, ID> void remove(Class<T> cls, ID id) {
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            mapForClass.remove(id);
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T> int size(Class<T> cls) {
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass == null) {
            return 0;
        }
        return mapForClass.size();
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public int sizeAll() {
        int i2 = 0;
        for (Map<Object, Reference<Object>> map : this.classMaps.values()) {
            i2 += map.size();
        }
        return i2;
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T, ID> T updateId(Class<T> cls, ID id, ID id2) {
        Reference<Object> remove;
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass == null || (remove = mapForClass.remove(id)) == null) {
            return null;
        }
        mapForClass.put(id2, remove);
        return (T) remove.get();
    }
}
