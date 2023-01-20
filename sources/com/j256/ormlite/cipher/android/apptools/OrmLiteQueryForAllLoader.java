package com.j256.ormlite.cipher.android.apptools;

import android.content.Context;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class OrmLiteQueryForAllLoader<T, ID> extends BaseOrmLiteLoader<T, ID> {
    public OrmLiteQueryForAllLoader(Context context) {
        super(context);
    }

    public OrmLiteQueryForAllLoader(Context context, Dao<T, ID> dao) {
        super(context, dao);
    }

    @Override // android.content.AsyncTaskLoader
    public List<T> loadInBackground() {
        Dao<T, ID> dao = this.dao;
        if (dao != null) {
            try {
                return dao.queryForAll();
            } catch (SQLException e2) {
                e2.printStackTrace();
                return Collections.emptyList();
            }
        }
        throw new IllegalStateException("Dao is not initialized.");
    }
}
