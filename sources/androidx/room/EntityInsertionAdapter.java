package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    public EntityInsertionAdapter(RoomDatabase database) {
        super(database);
    }

    public abstract void bind(SupportSQLiteStatement statement, T entity);

    public final void insert(T entity) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, entity);
            acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T entity) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, entity);
            return acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[entities.size()];
            int i2 = 0;
            for (T t : entities) {
                bind(acquire, t);
                jArr[i2] = acquire.executeInsert();
                i2++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            Long[] lArr = new Long[entities.size()];
            int i2 = 0;
            for (T t : entities) {
                bind(acquire, t);
                lArr[i2] = Long.valueOf(acquire.executeInsert());
                i2++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(entities.length);
            int i2 = 0;
            for (T t : entities) {
                bind(acquire, t);
                arrayList.add(i2, Long.valueOf(acquire.executeInsert()));
                i2++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final void insert(T[] entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T t : entities) {
                bind(acquire, t);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[entities.length];
            int i2 = 0;
            for (T t : entities) {
                bind(acquire, t);
                jArr[i2] = acquire.executeInsert();
                i2++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            Long[] lArr = new Long[entities.length];
            int i2 = 0;
            for (T t : entities) {
                bind(acquire, t);
                lArr[i2] = Long.valueOf(acquire.executeInsert());
                i2++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(entities.size());
            int i2 = 0;
            for (T t : entities) {
                bind(acquire, t);
                arrayList.add(i2, Long.valueOf(acquire.executeInsert()));
                i2++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final void insert(Iterable<? extends T> entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T t : entities) {
                bind(acquire, t);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }
}
