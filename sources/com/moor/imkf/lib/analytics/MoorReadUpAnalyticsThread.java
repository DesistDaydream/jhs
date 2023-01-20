package com.moor.imkf.lib.analytics;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import com.moor.imkf.lib.analytics.bean.MoorAnalyticsBean;
import com.moor.imkf.lib.basedb.MoorAnalyticsDao;
import com.moor.imkf.lib.utils.MoorLogUtils;
import java.util.List;

/* loaded from: classes2.dex */
public class MoorReadUpAnalyticsThread {
    public static int READ_NEXT = 309;
    private HandlerThread handlerThread;
    private Handler readHandler;

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final MoorReadUpAnalyticsThread sInstance = new MoorReadUpAnalyticsThread();

        private SingletonHolder() {
        }
    }

    public static MoorReadUpAnalyticsThread getInstance() {
        return SingletonHolder.sInstance;
    }

    public void quitReadAnalytics() {
        try {
            HandlerThread handlerThread = this.handlerThread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.readHandler = null;
            }
        } catch (Exception unused) {
        }
    }

    public void startReadTask() {
        if (this.handlerThread == null) {
            HandlerThread handlerThread = new HandlerThread("MoorReadUpAnalyticsThread");
            this.handlerThread = handlerThread;
            handlerThread.start();
        }
        Handler handler = new Handler(this.handlerThread.getLooper()) { // from class: com.moor.imkf.lib.analytics.MoorReadUpAnalyticsThread.1
            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                List<MoorAnalyticsBean> queryForLimit = MoorAnalyticsDao.getInstance().queryForLimit(10L);
                if (queryForLimit != null && queryForLimit.size() > 0) {
                    for (final MoorAnalyticsBean moorAnalyticsBean : queryForLimit) {
                        MoorLogUtils.e("AnalyticsSend", "READ_NEXT");
                        MoorAnalyticsUtils.send(moorAnalyticsBean.getAnalyticsStr(), new MoorAnalyticsSendListener() { // from class: com.moor.imkf.lib.analytics.MoorReadUpAnalyticsThread.1.1
                            @Override // com.moor.imkf.lib.analytics.MoorAnalyticsSendListener
                            public void onFail() {
                            }

                            @Override // com.moor.imkf.lib.analytics.MoorAnalyticsSendListener
                            public void onSuccess() {
                                MoorAnalyticsDao.getInstance().deleteToDao(moorAnalyticsBean);
                            }
                        });
                    }
                }
                if (MoorReadUpAnalyticsThread.this.readHandler != null) {
                    MoorReadUpAnalyticsThread.this.readHandler.sendEmptyMessageDelayed(MoorReadUpAnalyticsThread.READ_NEXT, 180000L);
                }
            }
        };
        this.readHandler = handler;
        handler.sendEmptyMessage(READ_NEXT);
    }

    private MoorReadUpAnalyticsThread() {
        if (this.handlerThread == null || this.readHandler == null) {
            HandlerThread handlerThread = new HandlerThread("MoorReadUpAnalyticsThread");
            this.handlerThread = handlerThread;
            handlerThread.start();
        }
    }
}
