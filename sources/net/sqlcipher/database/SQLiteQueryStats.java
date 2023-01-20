package net.sqlcipher.database;

/* loaded from: classes4.dex */
public class SQLiteQueryStats {
    public long largestIndividualRowSize;
    public long totalQueryResultSize;

    public SQLiteQueryStats(long j2, long j3) {
        this.totalQueryResultSize = 0L;
        this.largestIndividualRowSize = 0L;
        this.totalQueryResultSize = j2;
        this.largestIndividualRowSize = j3;
    }

    public long getLargestIndividualRowSize() {
        return this.largestIndividualRowSize;
    }

    public long getTotalQueryResultSize() {
        return this.totalQueryResultSize;
    }
}
