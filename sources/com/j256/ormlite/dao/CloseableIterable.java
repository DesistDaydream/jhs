package com.j256.ormlite.dao;

/* loaded from: classes2.dex */
public interface CloseableIterable<T> extends Iterable<T> {
    CloseableIterator<T> closeableIterator();
}
