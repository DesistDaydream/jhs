package net.sqlcipher;

import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes4.dex */
public interface DatabaseErrorHandler {
    void onCorruption(SQLiteDatabase sQLiteDatabase);
}
