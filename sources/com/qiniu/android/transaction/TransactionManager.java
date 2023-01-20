package com.qiniu.android.transaction;

import com.qiniu.android.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public class TransactionManager {
    private static final TransactionManager transactionManager = new TransactionManager();
    private Timer timer;
    public final ConcurrentLinkedQueue<Transaction> transactionList = new ConcurrentLinkedQueue<>();
    public long actionCount = 0;

    private TransactionManager() {
    }

    private synchronized void createTimer() {
        if (this.timer != null) {
            return;
        }
        Timer timer = new Timer();
        this.timer = timer;
        timer.schedule(new TimerTask() { // from class: com.qiniu.android.transaction.TransactionManager.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                TransactionManager.this.timerAction();
            }
        }, 0L, 1000L);
    }

    public static TransactionManager getInstance() {
        return transactionManager;
    }

    private void handleAllTransaction() {
        Iterator<Transaction> it = this.transactionList.iterator();
        while (it.hasNext()) {
            Transaction next = it.next();
            handleTransaction(next);
            if (next.maybeCompleted()) {
                removeTransaction(next);
            }
        }
    }

    private void handleTransaction(Transaction transaction) {
        transaction.handleAction();
    }

    private void invalidateTimer() {
        this.timer.cancel();
        this.timer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timerAction() {
        this.actionCount++;
        handleAllTransaction();
    }

    public void addTransaction(Transaction transaction) {
        if (transaction == null) {
            return;
        }
        this.transactionList.add(transaction);
        createTimer();
    }

    public synchronized void destroyResource() {
        invalidateTimer();
        this.transactionList.clear();
    }

    public boolean existTransactionsForName(String str) {
        String str2;
        Iterator<Transaction> it = this.transactionList.iterator();
        while (it.hasNext()) {
            Transaction next = it.next();
            if ((str == null && next.name == null) || ((str2 = next.name) != null && str2.equals(str))) {
                return true;
            }
        }
        return false;
    }

    public synchronized void performTransaction(Transaction transaction) {
        if (transaction == null) {
            return;
        }
        if (!this.transactionList.contains(transaction)) {
            this.transactionList.add(transaction);
        }
        transaction.nextExecutionTime = Utils.currentSecondTimestamp();
    }

    public void removeTransaction(Transaction transaction) {
        if (transaction == null) {
            return;
        }
        this.transactionList.remove(transaction);
    }

    public ArrayList<Transaction> transactionsForName(String str) {
        String str2;
        ArrayList<Transaction> arrayList = new ArrayList<>();
        Iterator<Transaction> it = this.transactionList.iterator();
        while (it.hasNext()) {
            Transaction next = it.next();
            if ((str == null && next.name == null) || ((str2 = next.name) != null && str2.equals(str))) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* loaded from: classes3.dex */
    public static class Transaction {
        private static final int TransactionTypeNormal = 0;
        private static final int TransactionTypeTime = 1;
        public final Runnable actionHandler;
        public final int after;
        private long createTime;
        public long executedCount;
        private final int interval;
        private boolean isExecuting;
        public final String name;
        public long nextExecutionTime;
        private final int type;

        public Transaction(String str, int i2, Runnable runnable) {
            this.executedCount = 0L;
            this.isExecuting = false;
            this.type = 0;
            this.name = str;
            this.after = i2;
            this.interval = 0;
            this.actionHandler = runnable;
            long currentSecondTimestamp = Utils.currentSecondTimestamp();
            this.createTime = currentSecondTimestamp;
            this.nextExecutionTime = currentSecondTimestamp + i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void handleAction() {
            if (shouldAction()) {
                Runnable runnable = this.actionHandler;
                if (runnable != null) {
                    this.isExecuting = true;
                    this.executedCount++;
                    try {
                        runnable.run();
                    } catch (Exception unused) {
                    }
                    this.nextExecutionTime = Utils.currentSecondTimestamp() + this.interval;
                    this.isExecuting = false;
                }
            }
        }

        public boolean isExecuting() {
            return this.isExecuting;
        }

        public boolean maybeCompleted() {
            int i2 = this.type;
            if (i2 == 0) {
                return this.executedCount > 0;
            }
            if (i2 == 1) {
            }
            return false;
        }

        public boolean shouldAction() {
            long currentSecondTimestamp = Utils.currentSecondTimestamp();
            int i2 = this.type;
            return i2 == 0 ? this.executedCount < 1 && currentSecondTimestamp >= this.nextExecutionTime : i2 == 1 && currentSecondTimestamp >= this.nextExecutionTime;
        }

        public Transaction(String str, int i2, int i3, Runnable runnable) {
            this.executedCount = 0L;
            this.isExecuting = false;
            this.type = 1;
            this.name = str;
            this.after = i2;
            this.interval = i3;
            this.actionHandler = runnable;
            long currentSecondTimestamp = Utils.currentSecondTimestamp();
            this.createTime = currentSecondTimestamp;
            this.nextExecutionTime = currentSecondTimestamp + i2;
        }
    }
}
