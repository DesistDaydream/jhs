package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes2.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new a();
    public Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.b entrySet;
    public final e<K, V> header;
    private LinkedTreeMap<K, V>.c keySet;
    public int modCount;
    public e<K, V> root;
    public int size;

    /* loaded from: classes2.dex */
    public class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AbstractSet<Map.Entry<K, V>> {

        /* loaded from: classes2.dex */
        public class a extends LinkedTreeMap<K, V>.d<Map.Entry<K, V>> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> findByEntry;
            if ((obj instanceof Map.Entry) && (findByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) != null) {
                LinkedTreeMap.this.removeInternal(findByEntry, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes2.dex */
    public final class c extends AbstractSet<K> {

        /* loaded from: classes2.dex */
        public class a extends LinkedTreeMap<K, V>.d<K> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f3205f;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes2.dex */
    public abstract class d<T> implements Iterator<T> {
        public e<K, V> a;
        public e<K, V> b = null;

        /* renamed from: c  reason: collision with root package name */
        public int f3200c;

        public d() {
            this.a = LinkedTreeMap.this.header.f3203d;
            this.f3200c = LinkedTreeMap.this.modCount;
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (eVar != linkedTreeMap.header) {
                if (linkedTreeMap.modCount == this.f3200c) {
                    this.a = eVar.f3203d;
                    this.b = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != LinkedTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.b;
            if (eVar != null) {
                LinkedTreeMap.this.removeInternal(eVar, true);
                this.b = null;
                this.f3200c = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private void rebalance(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.b;
            e<K, V> eVar3 = eVar.f3202c;
            int i2 = eVar2 != null ? eVar2.f3207h : 0;
            int i3 = eVar3 != null ? eVar3.f3207h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e<K, V> eVar4 = eVar3.b;
                e<K, V> eVar5 = eVar3.f3202c;
                int i5 = (eVar4 != null ? eVar4.f3207h : 0) - (eVar5 != null ? eVar5.f3207h : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    rotateRight(eVar3);
                    rotateLeft(eVar);
                } else {
                    rotateLeft(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e<K, V> eVar6 = eVar2.b;
                e<K, V> eVar7 = eVar2.f3202c;
                int i6 = (eVar6 != null ? eVar6.f3207h : 0) - (eVar7 != null ? eVar7.f3207h : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    rotateLeft(eVar2);
                    rotateRight(eVar);
                } else {
                    rotateRight(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.f3207h = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.f3207h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.a;
        }
    }

    private void replaceInParent(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.a;
        eVar.a = null;
        if (eVar2 != null) {
            eVar2.a = eVar3;
        }
        if (eVar3 != null) {
            if (eVar3.b == eVar) {
                eVar3.b = eVar2;
                return;
            } else {
                eVar3.f3202c = eVar2;
                return;
            }
        }
        this.root = eVar2;
    }

    private void rotateLeft(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.b;
        e<K, V> eVar3 = eVar.f3202c;
        e<K, V> eVar4 = eVar3.b;
        e<K, V> eVar5 = eVar3.f3202c;
        eVar.f3202c = eVar4;
        if (eVar4 != null) {
            eVar4.a = eVar;
        }
        replaceInParent(eVar, eVar3);
        eVar3.b = eVar;
        eVar.a = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.f3207h : 0, eVar4 != null ? eVar4.f3207h : 0) + 1;
        eVar.f3207h = max;
        eVar3.f3207h = Math.max(max, eVar5 != null ? eVar5.f3207h : 0) + 1;
    }

    private void rotateRight(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.b;
        e<K, V> eVar3 = eVar.f3202c;
        e<K, V> eVar4 = eVar2.b;
        e<K, V> eVar5 = eVar2.f3202c;
        eVar.b = eVar5;
        if (eVar5 != null) {
            eVar5.a = eVar;
        }
        replaceInParent(eVar, eVar2);
        eVar2.f3202c = eVar;
        eVar.a = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.f3207h : 0, eVar5 != null ? eVar5.f3207h : 0) + 1;
        eVar.f3207h = max;
        eVar2.f3207h = Math.max(max, eVar4 != null ? eVar4.f3207h : 0) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> eVar = this.header;
        eVar.f3204e = eVar;
        eVar.f3203d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    public e<K, V> find(K k2, boolean z) {
        int i2;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.comparator;
        e<K, V> eVar2 = this.root;
        if (eVar2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k2 : null;
            while (true) {
                if (comparable != null) {
                    i2 = comparable.compareTo(eVar2.f3205f);
                } else {
                    i2 = comparator.compare(k2, (K) eVar2.f3205f);
                }
                if (i2 == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i2 < 0 ? eVar2.b : eVar2.f3202c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i2 = 0;
        }
        if (z) {
            e<K, V> eVar4 = this.header;
            if (eVar2 == null) {
                if (comparator == NATURAL_ORDER && !(k2 instanceof Comparable)) {
                    throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
                }
                eVar = new e<>(eVar2, k2, eVar4, eVar4.f3204e);
                this.root = eVar;
            } else {
                eVar = new e<>(eVar2, k2, eVar4, eVar4.f3204e);
                if (i2 < 0) {
                    eVar2.b = eVar;
                } else {
                    eVar2.f3202c = eVar;
                }
                rebalance(eVar2, true);
            }
            this.size++;
            this.modCount++;
            return eVar;
        }
        return null;
    }

    public e<K, V> findByEntry(Map.Entry<?, ?> entry) {
        e<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.f3206g, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e<K, V> findByObject(Object obj) {
        if (obj != 0) {
            try {
                return find(obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f3206g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        LinkedTreeMap<K, V>.c cVar2 = new c();
        this.keySet = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        Objects.requireNonNull(k2, "key == null");
        e<K, V> find = find(k2, true);
        V v2 = find.f3206g;
        find.f3206g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f3206g;
        }
        return null;
    }

    public void removeInternal(e<K, V> eVar, boolean z) {
        int i2;
        if (z) {
            e<K, V> eVar2 = eVar.f3204e;
            eVar2.f3203d = eVar.f3203d;
            eVar.f3203d.f3204e = eVar2;
        }
        e<K, V> eVar3 = eVar.b;
        e<K, V> eVar4 = eVar.f3202c;
        e<K, V> eVar5 = eVar.a;
        int i3 = 0;
        if (eVar3 != null && eVar4 != null) {
            e<K, V> b2 = eVar3.f3207h > eVar4.f3207h ? eVar3.b() : eVar4.a();
            removeInternal(b2, false);
            e<K, V> eVar6 = eVar.b;
            if (eVar6 != null) {
                i2 = eVar6.f3207h;
                b2.b = eVar6;
                eVar6.a = b2;
                eVar.b = null;
            } else {
                i2 = 0;
            }
            e<K, V> eVar7 = eVar.f3202c;
            if (eVar7 != null) {
                i3 = eVar7.f3207h;
                b2.f3202c = eVar7;
                eVar7.a = b2;
                eVar.f3202c = null;
            }
            b2.f3207h = Math.max(i2, i3) + 1;
            replaceInParent(eVar, b2);
            return;
        }
        if (eVar3 != null) {
            replaceInParent(eVar, eVar3);
            eVar.b = null;
        } else if (eVar4 != null) {
            replaceInParent(eVar, eVar4);
            eVar.f3202c = null;
        } else {
            replaceInParent(eVar, null);
        }
        rebalance(eVar5, false);
        this.size--;
        this.modCount++;
    }

    public e<K, V> removeInternalByKey(Object obj) {
        e<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new e<>();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }

    /* loaded from: classes2.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {
        public e<K, V> a;
        public e<K, V> b;

        /* renamed from: c  reason: collision with root package name */
        public e<K, V> f3202c;

        /* renamed from: d  reason: collision with root package name */
        public e<K, V> f3203d;

        /* renamed from: e  reason: collision with root package name */
        public e<K, V> f3204e;

        /* renamed from: f  reason: collision with root package name */
        public final K f3205f;

        /* renamed from: g  reason: collision with root package name */
        public V f3206g;

        /* renamed from: h  reason: collision with root package name */
        public int f3207h;

        public e() {
            this.f3205f = null;
            this.f3204e = this;
            this.f3203d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.b; eVar2 != null; eVar2 = eVar2.b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f3202c; eVar2 != null; eVar2 = eVar2.f3202c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k2 = this.f3205f;
                if (k2 == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k2.equals(entry.getKey())) {
                    return false;
                }
                V v = this.f3206g;
                if (v == null) {
                    if (entry.getValue() != null) {
                        return false;
                    }
                } else if (!v.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f3205f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f3206g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.f3205f;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.f3206g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f3206g;
            this.f3206g = v;
            return v2;
        }

        public String toString() {
            return this.f3205f + "=" + this.f3206g;
        }

        public e(e<K, V> eVar, K k2, e<K, V> eVar2, e<K, V> eVar3) {
            this.a = eVar;
            this.f3205f = k2;
            this.f3207h = 1;
            this.f3203d = eVar2;
            this.f3204e = eVar3;
            eVar3.f3203d = this;
            eVar2.f3204e = this;
        }
    }
}
