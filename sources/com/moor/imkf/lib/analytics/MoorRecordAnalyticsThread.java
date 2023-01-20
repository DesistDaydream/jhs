package com.moor.imkf.lib.analytics;

import android.os.Handler;
import android.os.HandlerThread;
import com.moor.imkf.lib.analytics.bean.MoorAnalyticsBean;
import com.moor.imkf.lib.basedb.MoorAnalyticsDao;

/* loaded from: classes2.dex */
public class MoorRecordAnalyticsThread {
    private HandlerThread handlerThread;
    private Handler recordHandler;

    /* loaded from: classes2.dex */
    public static class AddRecordRunnable implements Runnable {
        private MoorAnalyticsBean moorAnalyticsBean;

        public AddRecordRunnable(MoorAnalyticsBean moorAnalyticsBean) {
            this.moorAnalyticsBean = moorAnalyticsBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MoorAnalyticsBean moorAnalyticsBean = this.moorAnalyticsBean;
                if (moorAnalyticsBean == null || moorAnalyticsBean == null) {
                    return;
                }
                MoorAnalyticsUtils.send(moorAnalyticsBean.getAnalyticsStr(), new MoorAnalyticsSendListener() { // from class: com.moor.imkf.lib.analytics.MoorRecordAnalyticsThread.AddRecordRunnable.1
                    @Override // com.moor.imkf.lib.analytics.MoorAnalyticsSendListener
                    public void onFail() {
                        try {
                            MoorAnalyticsDao.getInstance().createOrUpdate(AddRecordRunnable.this.moorAnalyticsBean);
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.moor.imkf.lib.analytics.MoorAnalyticsSendListener
                    public void onSuccess() {
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final MoorRecordAnalyticsThread sInstance = new MoorRecordAnalyticsThread();

        private SingletonHolder() {
        }
    }

    public static MoorRecordAnalyticsThread getInstance() {
        return SingletonHolder.sInstance;
    }

    public void postAddRecord(MoorAnalyticsBean moorAnalyticsBean) {
        if (moorAnalyticsBean != null) {
            if (this.handlerThread == null) {
                HandlerThread handlerThread = new HandlerThread("MoorRecordAnalyticsThread");
                this.handlerThread = handlerThread;
                handlerThread.start();
            }
            if (this.recordHandler == null) {
                this.recordHandler = new Handler(this.handlerThread.getLooper());
            }
            this.recordHandler.post(new AddRecordRunnable(moorAnalyticsBean));
        }
    }

    public void quitRecordAnalytics() {
        try {
            HandlerThread handlerThread = this.handlerThread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.recordHandler = null;
            }
        } catch (Exception unused) {
        }
    }

    private MoorRecordAnalyticsThread() {
        if (this.handlerThread == null || this.recordHandler == null) {
            HandlerThread handlerThread = new HandlerThread("MoorRecordAnalyticsThread");
            this.handlerThread = handlerThread;
            handlerThread.start();
            this.recordHandler = new Handler(this.handlerThread.getLooper());
        }
    }
}
