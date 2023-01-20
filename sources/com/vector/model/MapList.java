package com.vector.model;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0002\u0010\u000bJ#\u0010\u0007\u001a\u00020\f2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\fH\u0016J\u0015\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014J\u0013\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/vector/model/MapList;", "K", ExifInterface.LONGITUDE_EAST, "Ljava/util/ArrayList;", "()V", "map", "", "add", "", "key", e.a, "(Ljava/lang/Object;Ljava/lang/Object;)Z", "", "index", "", "(Ljava/lang/Object;ILjava/lang/Object;)V", "clear", "getByKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "getKeys", "", "has", "(Ljava/lang/Object;)Z", "removeByKey", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MapList<K, E> extends ArrayList<E> {
    @d
    private final Map<K, E> map = new LinkedHashMap();

    public final boolean add(K k2, E e2) {
        this.map.put(k2, e2);
        return super.add(e2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.map.clear();
        super.clear();
    }

    @k.e.a.e
    public final E getByKey(K k2) {
        return this.map.get(k2);
    }

    @d
    public final Set<K> getKeys() {
        return this.map.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public final boolean has(K k2) {
        return this.map.get(k2) != null;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i2) {
        return (E) removeAt(i2);
    }

    public /* bridge */ Object removeAt(int i2) {
        return super.remove(i2);
    }

    public final boolean removeByKey(K k2) {
        E remove = this.map.remove(k2);
        return remove != null && super.remove(remove);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public final void add(K k2, int i2, E e2) {
        this.map.put(k2, e2);
        super.add(i2, (int) e2);
    }
}
