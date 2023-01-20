package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes2.dex */
public class LimitQueue<E> extends ConcurrentLinkedQueue<E> {
    private static final String TAG = "LimitQueue";
    private static final long serialVersionUID = -4636313759149307798L;
    private boolean deduplication;
    private int limit;

    public LimitQueue(int i2) {
        this.deduplication = false;
        this.limit = i2;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e2) {
        if (this.deduplication) {
            super.remove(e2);
        }
        if (super.size() >= this.limit) {
            super.poll();
        }
        return super.add(e2);
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.size() > this.limit) {
            return false;
        }
        if (this.deduplication) {
            super.removeAll(collection);
        }
        for (int size = (collection.size() + super.size()) - this.limit; size > 0; size--) {
            super.poll();
        }
        return super.addAll(collection);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        super.clear();
    }

    public E get(int i2) {
        Iterator<E> it = iterator();
        E e2 = null;
        for (int i3 = 0; i3 <= i2 && it.hasNext(); i3++) {
            e2 = it.next();
        }
        return e2;
    }

    public int getLimit() {
        return this.limit;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public boolean offer(E e2) {
        if (this.deduplication) {
            super.remove(e2);
        }
        if (super.size() >= this.limit) {
            super.poll();
        }
        return super.offer(e2);
    }

    public E peekLast() {
        Iterator<E> it = iterator();
        E e2 = null;
        while (it.hasNext()) {
            e2 = it.next();
        }
        return e2;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public E poll() {
        return (E) super.poll();
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        try {
            return (E) super.remove();
        } catch (NoSuchElementException unused) {
            Logger.w(TAG, "remove failed, limitQueue is empty");
            return null;
        }
    }

    public LimitQueue(int i2, boolean z) {
        this.deduplication = false;
        this.limit = i2;
        this.deduplication = z;
    }

    public LimitQueue(Collection<? extends E> collection, boolean z) {
        this(collection.size(), z);
        addAll(collection);
    }
}
