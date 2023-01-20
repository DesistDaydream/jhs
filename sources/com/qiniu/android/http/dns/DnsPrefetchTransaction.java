package com.qiniu.android.http.dns;

import com.qiniu.android.common.Zone;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.transaction.TransactionManager;

/* loaded from: classes3.dex */
public class DnsPrefetchTransaction {
    private static boolean isDnsLoaded = false;

    public static synchronized boolean addDnsCheckAndPrefetchTransaction(final Zone zone, final UpToken upToken) {
        String str;
        synchronized (DnsPrefetchTransaction.class) {
            if (DnsPrefetcher.getInstance().isDnsOpen()) {
                if (upToken != null && (str = upToken.token) != null && str.length() != 0) {
                    TransactionManager transactionManager = TransactionManager.getInstance();
                    if (transactionManager.existTransactionsForName(upToken.token)) {
                        return false;
                    }
                    transactionManager.addTransaction(new TransactionManager.Transaction(upToken.token, 0, new Runnable() { // from class: com.qiniu.android.http.dns.DnsPrefetchTransaction.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DnsPrefetcher.getInstance().checkAndPrefetchDnsIfNeed(Zone.this, upToken);
                        }
                    }));
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public static synchronized boolean addDnsLocalLoadTransaction() {
        synchronized (DnsPrefetchTransaction.class) {
            if (isDnsLoaded) {
                return false;
            }
            if (DnsPrefetcher.getInstance().isDnsOpen()) {
                isDnsLoaded = true;
                TransactionManager.getInstance().addTransaction(new TransactionManager.Transaction("loadDns", 0, new Runnable() { // from class: com.qiniu.android.http.dns.DnsPrefetchTransaction.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DnsPrefetcher.getInstance().recoverCache();
                        DnsPrefetcher.getInstance().localFetch();
                    }
                }));
                return true;
            }
            return false;
        }
    }

    public static synchronized boolean setDnsCheckWhetherCachedValidTransactionAction() {
        synchronized (DnsPrefetchTransaction.class) {
            if (DnsPrefetcher.getInstance().isDnsOpen()) {
                TransactionManager transactionManager = TransactionManager.getInstance();
                if (transactionManager.existTransactionsForName("dnsCheckWhetherCachedValidTransaction")) {
                    return false;
                }
                transactionManager.addTransaction(new TransactionManager.Transaction("dnsCheckWhetherCachedValidTransaction", 10, 120, new Runnable() { // from class: com.qiniu.android.http.dns.DnsPrefetchTransaction.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DnsPrefetcher.getInstance().checkWhetherCachedDnsValid();
                    }
                }));
                return true;
            }
            return false;
        }
    }

    public static synchronized boolean addDnsCheckAndPrefetchTransaction(final String[] strArr) {
        synchronized (DnsPrefetchTransaction.class) {
            if (DnsPrefetcher.getInstance().isDnsOpen()) {
                if (strArr != null && strArr.length != 0) {
                    TransactionManager.getInstance().addTransaction(new TransactionManager.Transaction(null, 0, new Runnable() { // from class: com.qiniu.android.http.dns.DnsPrefetchTransaction.3
                        @Override // java.lang.Runnable
                        public void run() {
                            DnsPrefetcher.getInstance().addPreFetchHosts(strArr);
                        }
                    }));
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}
