package com.j256.ormlite.cipher.android.apptools.support;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import com.j256.ormlite.cipher.android.AndroidCompiledStatement;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.StatementBuilder;
import java.sql.SQLException;
import net.sqlcipher.Cursor;

/* loaded from: classes2.dex */
public class OrmLiteCursorLoader<T> extends AsyncTaskLoader<Cursor> implements Dao.DaoObserver {
    public Cursor cursor;
    public Dao<T, ?> dao;
    public PreparedQuery<T> query;

    public OrmLiteCursorLoader(Context context, Dao<T, ?> dao, PreparedQuery<T> preparedQuery) {
        super(context);
        this.dao = dao;
        this.query = preparedQuery;
    }

    public PreparedQuery<T> getQuery() {
        return this.query;
    }

    @Override // com.j256.ormlite.dao.Dao.DaoObserver
    public void onChange() {
        onContentChanged();
    }

    @Override // androidx.loader.content.Loader
    public void onReset() {
        super.onReset();
        onStopLoading();
        Cursor cursor = this.cursor;
        if (cursor != null) {
            if (!cursor.isClosed()) {
                this.cursor.close();
            }
            this.cursor = null;
        }
        this.dao.unregisterObserver(this);
    }

    @Override // androidx.loader.content.Loader
    public void onStartLoading() {
        this.dao.registerObserver(this);
        Cursor cursor = this.cursor;
        if (cursor == null) {
            forceLoad();
            return;
        }
        deliverResult(cursor);
        if (takeContentChanged()) {
            forceLoad();
        }
    }

    @Override // androidx.loader.content.Loader
    public void onStopLoading() {
        cancelLoad();
    }

    public void setQuery(PreparedQuery<T> preparedQuery) {
        this.query = preparedQuery;
    }

    @Override // androidx.loader.content.Loader
    public void deliverResult(Cursor cursor) {
        if (isReset()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.cursor;
        this.cursor = cursor;
        if (isStarted()) {
            super.deliverResult((OrmLiteCursorLoader<T>) cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        try {
            Cursor cursor = ((AndroidCompiledStatement) this.query.compile(this.dao.getConnectionSource().getReadOnlyConnection(this.dao.getTableName()), StatementBuilder.StatementType.SELECT)).getCursor();
            cursor.getCount();
            return cursor;
        } catch (SQLException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void onCanceled(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }
}
