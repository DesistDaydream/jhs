package com.j256.ormlite.cipher.android.compat;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes2.dex */
public interface ApiCompatibility {

    /* loaded from: classes2.dex */
    public interface CancellationHook {
        void cancel();
    }

    CancellationHook createCancellationHook();

    Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, CancellationHook cancellationHook);
}
