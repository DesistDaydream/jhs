package com.huawei.hms.api;

import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class FailedBinderCallBack {
    private static final long AGING_TIME = 10000;
    public static final String CALLER_ID = "callId";
    private static final String TAG = "FailedBinderCallBack";
    private static FailedBinderCallBack instance;
    private static Map<Long, BinderCallBack> binderCallBackMap = new ConcurrentHashMap();
    private static final Object LOCK_OBJECT = new Object();

    /* loaded from: classes2.dex */
    public interface BinderCallBack {
        void binderCallBack(int i2);
    }

    private FailedBinderCallBack() {
    }

    private void agingCheck() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - 10000;
        for (Long l2 : binderCallBackMap.keySet()) {
            if (time >= l2.longValue()) {
                binderCallBackMap.remove(l2);
            }
        }
    }

    public static FailedBinderCallBack getInstance() {
        synchronized (LOCK_OBJECT) {
            if (instance == null) {
                instance = new FailedBinderCallBack();
            }
        }
        return instance;
    }

    private void putCallBackInMap(Long l2, BinderCallBack binderCallBack) {
        if (binderCallBackMap == null) {
            HMSLog.e(TAG, "binderCallBackMap is null");
            return;
        }
        agingCheck();
        binderCallBackMap.put(l2, binderCallBack);
    }

    public BinderCallBack getCallBack(Long l2) {
        Map<Long, BinderCallBack> map = binderCallBackMap;
        if (map == null) {
            HMSLog.e(TAG, "binderCallBackMap is null");
            return null;
        }
        return map.remove(l2);
    }

    public void setCallBack(Long l2, BinderCallBack binderCallBack) {
        putCallBackInMap(l2, binderCallBack);
    }
}
