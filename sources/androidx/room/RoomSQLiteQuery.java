package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    @VisibleForTesting
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    @VisibleForTesting
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    @VisibleForTesting
    public static final TreeMap<Integer, RoomSQLiteQuery> sQueryPool = new TreeMap<>();
    @VisibleForTesting
    public int mArgCount;
    private final int[] mBindingTypes;
    @VisibleForTesting
    public final byte[][] mBlobBindings;
    @VisibleForTesting
    public final int mCapacity;
    @VisibleForTesting
    public final double[] mDoubleBindings;
    @VisibleForTesting
    public final long[] mLongBindings;
    private volatile String mQuery;
    @VisibleForTesting
    public final String[] mStringBindings;

    private RoomSQLiteQuery(int capacity) {
        this.mCapacity = capacity;
        int i2 = capacity + 1;
        this.mBindingTypes = new int[i2];
        this.mLongBindings = new long[i2];
        this.mDoubleBindings = new double[i2];
        this.mStringBindings = new String[i2];
        this.mBlobBindings = new byte[i2];
    }

    public static RoomSQLiteQuery acquire(String query, int argumentCount) {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        synchronized (treeMap) {
            Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(argumentCount));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                RoomSQLiteQuery value = ceilingEntry.getValue();
                value.init(query, argumentCount);
                return value;
            }
            RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(argumentCount);
            roomSQLiteQuery.init(query, argumentCount);
            return roomSQLiteQuery;
        }
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
        supportSQLiteQuery.bindTo(new SupportSQLiteProgram() { // from class: androidx.room.RoomSQLiteQuery.1
            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindBlob(int index, byte[] value) {
                RoomSQLiteQuery.this.bindBlob(index, value);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindDouble(int index, double value) {
                RoomSQLiteQuery.this.bindDouble(index, value);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindLong(int index, long value) {
                RoomSQLiteQuery.this.bindLong(index, value);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindNull(int index) {
                RoomSQLiteQuery.this.bindNull(index);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindString(int index, String value) {
                RoomSQLiteQuery.this.bindString(index, value);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void clearBindings() {
                RoomSQLiteQuery.this.clearBindings();
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        });
        return acquire;
    }

    private static void prunePoolLocked() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        if (treeMap.size() <= 15) {
            return;
        }
        int size = treeMap.size() - 10;
        Iterator<Integer> it = treeMap.descendingKeySet().iterator();
        while (true) {
            int i2 = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i2;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int index, byte[] value) {
        this.mBindingTypes[index] = 5;
        this.mBlobBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int index, double value) {
        this.mBindingTypes[index] = 3;
        this.mDoubleBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int index, long value) {
        this.mBindingTypes[index] = 2;
        this.mLongBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int index) {
        this.mBindingTypes[index] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int index, String value) {
        this.mBindingTypes[index] = 4;
        this.mStringBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram program) {
        for (int i2 = 1; i2 <= this.mArgCount; i2++) {
            int i3 = this.mBindingTypes[i2];
            if (i3 == 1) {
                program.bindNull(i2);
            } else if (i3 == 2) {
                program.bindLong(i2, this.mLongBindings[i2]);
            } else if (i3 == 3) {
                program.bindDouble(i2, this.mDoubleBindings[i2]);
            } else if (i3 == 4) {
                program.bindString(i2, this.mStringBindings[i2]);
            } else if (i3 == 5) {
                program.bindBlob(i2, this.mBlobBindings[i2]);
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.mBindingTypes, 1);
        Arrays.fill(this.mStringBindings, (Object) null);
        Arrays.fill(this.mBlobBindings, (Object) null);
        this.mQuery = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void copyArgumentsFrom(RoomSQLiteQuery other) {
        int argCount = other.getArgCount() + 1;
        System.arraycopy(other.mBindingTypes, 0, this.mBindingTypes, 0, argCount);
        System.arraycopy(other.mLongBindings, 0, this.mLongBindings, 0, argCount);
        System.arraycopy(other.mStringBindings, 0, this.mStringBindings, 0, argCount);
        System.arraycopy(other.mBlobBindings, 0, this.mBlobBindings, 0, argCount);
        System.arraycopy(other.mDoubleBindings, 0, this.mDoubleBindings, 0, argCount);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.mArgCount;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.mQuery;
    }

    public void init(String query, int argCount) {
        this.mQuery = query;
        this.mArgCount = argCount;
    }

    public void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.mCapacity), this);
            prunePoolLocked();
        }
    }
}
