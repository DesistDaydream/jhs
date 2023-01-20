package com.j256.ormlite.cipher.android.compat;

import android.annotation.TargetApi;
import android.os.CancellationSignal;
import com.j256.ormlite.cipher.android.compat.ApiCompatibility;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes2.dex */
public class JellyBeanApiCompatibility extends BasicApiCompatibility {

    @TargetApi(16)
    /* loaded from: classes2.dex */
    public static class JellyBeanCancellationHook implements ApiCompatibility.CancellationHook {
        private final CancellationSignal cancellationSignal = new CancellationSignal();

        @Override // com.j256.ormlite.cipher.android.compat.ApiCompatibility.CancellationHook
        public void cancel() {
            this.cancellationSignal.cancel();
        }
    }

    @Override // com.j256.ormlite.cipher.android.compat.BasicApiCompatibility, com.j256.ormlite.cipher.android.compat.ApiCompatibility
    public ApiCompatibility.CancellationHook createCancellationHook() {
        return new JellyBeanCancellationHook();
    }

    @Override // com.j256.ormlite.cipher.android.compat.BasicApiCompatibility, com.j256.ormlite.cipher.android.compat.ApiCompatibility
    public Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, ApiCompatibility.CancellationHook cancellationHook) {
        if (cancellationHook == null) {
            return sQLiteDatabase.rawQuery(str, strArr);
        }
        throw new RuntimeException("Not supported by ");
    }
}
