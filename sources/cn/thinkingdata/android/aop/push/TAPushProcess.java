package cn.thinkingdata.android.aop.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.thinkingdata.android.utils.TDLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TAPushProcess {
    private static final int GT_PUSH_MSG = 100;
    private static TAPushProcess INSTANCE = null;
    private static final String TAG = "ThinkingAnalytics.process";
    private final Map<String, TANotificationInfo> mGeTuiMap = new HashMap();
    private final Handler mPushHandler;

    private TAPushProcess() {
        HandlerThread handlerThread = new HandlerThread("TA.PushThread");
        handlerThread.start();
        this.mPushHandler = new Handler(handlerThread.getLooper()) { // from class: cn.thinkingdata.android.aop.push.TAPushProcess.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 100) {
                    try {
                        String str = (String) message.obj;
                        if (TextUtils.isEmpty(str) || !TAPushProcess.this.mGeTuiMap.containsKey(str)) {
                            return;
                        }
                        TANotificationInfo tANotificationInfo = (TANotificationInfo) TAPushProcess.this.mGeTuiMap.get(str);
                        TAPushProcess.this.mGeTuiMap.remove(str);
                        if (tANotificationInfo != null) {
                            TAPushTrackHelper.trackGeTuiNotificationClicked(tANotificationInfo.title, tANotificationInfo.content, null, tANotificationInfo.time);
                        }
                    } catch (Exception e2) {
                        TDLog.e(TAPushProcess.TAG, e2.getMessage());
                    }
                }
            }
        };
    }

    public static synchronized TAPushProcess getInstance() {
        TAPushProcess tAPushProcess;
        synchronized (TAPushProcess.class) {
            if (INSTANCE == null) {
                INSTANCE = new TAPushProcess();
            }
            tAPushProcess = INSTANCE;
        }
        return tAPushProcess;
    }

    public void onNotificationClick(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (context instanceof Activity) {
                TAPushTrackHelper.trackJPushOpenActivity(intent);
            }
        } catch (Exception e2) {
            TDLog.e(TAG, e2.getMessage());
        }
    }

    public void trackGTDelayed(String str, String str2, String str3) {
        try {
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.obj = str;
            this.mGeTuiMap.put(str, new TANotificationInfo(str2, str3, System.currentTimeMillis()));
            this.mPushHandler.sendMessageDelayed(obtain, 200L);
        } catch (Exception e2) {
            TDLog.e(TAG, e2.getMessage());
        }
    }

    public void trackGeTuiReceiveMessageData(String str, String str2) {
        try {
            if (this.mPushHandler.hasMessages(100) && this.mGeTuiMap.containsKey(str2)) {
                this.mPushHandler.removeMessages(100);
                TANotificationInfo tANotificationInfo = this.mGeTuiMap.get(str2);
                if (tANotificationInfo != null) {
                    TAPushTrackHelper.trackGeTuiNotificationClicked(tANotificationInfo.title, tANotificationInfo.content, str, tANotificationInfo.time);
                }
                this.mGeTuiMap.remove(str2);
                TDLog.i(TAG, " onGeTuiReceiveMessage:msg id : " + str2);
            }
        } catch (Exception e2) {
            TDLog.e(TAG, e2.getMessage());
        }
    }
}
