package com.moor.imkf.lib.jsoup.helper;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes2.dex */
public abstract class ChangeNotifyingArrayList<E> extends ArrayList<E> {
    public ChangeNotifyingArrayList(int i2) {
        super(i2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        onContentsChanged();
        return super.add(e2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        onContentsChanged();
        return super.addAll(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        onContentsChanged();
        super.clear();
    }

    public abstract void onContentsChanged();

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E remove(int i2) {
        onContentsChanged();
        return (E) super.remove(i2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        onContentsChanged();
        return super.removeAll(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    public void removeRange(int i2, int i3) {
        onContentsChanged();
        super.removeRange(i2, i3);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        onContentsChanged();
        return super.retainAll(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        onContentsChanged();
        return (E) super.set(i2, e2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        onContentsChanged();
        super.add(i2, e2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        onContentsChanged();
        return super.addAll(i2, collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        onContentsChanged();
        return super.remove(obj);
    }
}
