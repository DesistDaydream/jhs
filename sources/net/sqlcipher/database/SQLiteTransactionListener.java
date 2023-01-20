package net.sqlcipher.database;

/* loaded from: classes4.dex */
public interface SQLiteTransactionListener {
    void onBegin();

    void onCommit();

    void onRollback();
}
