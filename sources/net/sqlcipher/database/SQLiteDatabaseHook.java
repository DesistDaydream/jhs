package net.sqlcipher.database;

/* loaded from: classes4.dex */
public interface SQLiteDatabaseHook {
    void postKey(SQLiteDatabase sQLiteDatabase);

    void preKey(SQLiteDatabase sQLiteDatabase);
}
