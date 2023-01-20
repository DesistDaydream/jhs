package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase database) {
        super(database);
    }

    public abstract void bind(SupportSQLiteStatement statement, T entity);

    @Override // androidx.room.SharedSQLiteStatement
    public abstract String createQuery();

    public final int handle(T entity) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, entity);
            return acquire.executeUpdateDelete();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> entities) {
        SupportSQLiteStatement acquire = acquire();
        int i2 = 0;
        try {
            for (T t : entities) {
                bind(acquire, t);
                i2 += acquire.executeUpdateDelete();
            }
            return i2;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            int i2 = 0;
            for (T t : entities) {
                bind(acquire, t);
                i2 += acquire.executeUpdateDelete();
            }
            return i2;
        } finally {
            release(acquire);
        }
    }
}
