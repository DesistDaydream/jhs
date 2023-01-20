package com.j256.ormlite.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

/* loaded from: classes2.dex */
public interface ForeignCollection<T> extends Collection<T>, CloseableIterable<T> {
    @Override // java.util.Collection
    boolean add(T t);

    void closeLastIterator() throws IOException;

    CloseableIterator<T> closeableIterator(int i2);

    Dao<T, ?> getDao();

    CloseableWrappedIterable<T> getWrappedIterable();

    CloseableWrappedIterable<T> getWrappedIterable(int i2);

    boolean isEager();

    CloseableIterator<T> iterator(int i2);

    CloseableIterator<T> iteratorThrow() throws SQLException;

    CloseableIterator<T> iteratorThrow(int i2) throws SQLException;

    int refresh(T t) throws SQLException;

    int refreshAll() throws SQLException;

    int refreshCollection() throws SQLException;

    int update(T t) throws SQLException;

    int updateAll() throws SQLException;
}
