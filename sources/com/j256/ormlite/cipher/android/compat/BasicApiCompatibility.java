package com.j256.ormlite.cipher.android.compat;

import com.j256.ormlite.cipher.android.compat.ApiCompatibility;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes2.dex */
public class BasicApiCompatibility implements ApiCompatibility {
    @Override // com.j256.ormlite.cipher.android.compat.ApiCompatibility
    public ApiCompatibility.CancellationHook createCancellationHook() {
        return null;
    }

    @Override // com.j256.ormlite.cipher.android.compat.ApiCompatibility
    public Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, ApiCompatibility.CancellationHook cancellationHook) {
        return sQLiteDatabase.rawQuery(str, strArr);
    }
}
