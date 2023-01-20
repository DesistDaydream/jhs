package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.CursorAdapter;
import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.stmt.PreparedQuery;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public abstract class OrmLiteCursorAdapter<T, ViewType extends View> extends CursorAdapter {
    public PreparedQuery<T> preparedQuery;

    public OrmLiteCursorAdapter(Context context) {
        super(context, (Cursor) null, false);
    }

    @Override // android.widget.CursorAdapter
    public final void bindView(View view, Context context, Cursor cursor) {
        doBindView(view, context, cursor);
    }

    public abstract void bindView(ViewType viewtype, Context context, T t);

    @Override // android.widget.CursorAdapter
    public final void changeCursor(Cursor cursor) {
        throw new UnsupportedOperationException("Please use OrmLiteCursorAdapter.changeCursor(Cursor,PreparedQuery) instead");
    }

    public T cursorToObject(Cursor cursor) throws SQLException {
        return this.preparedQuery.mapRow(new AndroidDatabaseResults(cursor, null, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void doBindView(View view, Context context, Cursor cursor) {
        try {
            bindView((OrmLiteCursorAdapter<T, ViewType>) view, context, (Context) cursorToObject(cursor));
        } catch (SQLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public T getTypedItem(int i2) {
        try {
            return cursorToObject((Cursor) super.getItem(i2));
        } catch (SQLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void setPreparedQuery(PreparedQuery<T> preparedQuery) {
        this.preparedQuery = preparedQuery;
    }

    public void changeCursor(Cursor cursor, PreparedQuery<T> preparedQuery) {
        setPreparedQuery(preparedQuery);
        super.changeCursor(cursor);
    }
}
