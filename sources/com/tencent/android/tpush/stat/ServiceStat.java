package com.tencent.android.tpush.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.h;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.PushStatClientReport;
import com.tencent.android.tpush.service.protocol.j;
import com.tencent.android.tpush.stat.event.g;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ServiceStat {
    public static final String ACCOUNT_EVENT_ID = "SdkAccount";
    public static final String ACK_EVENT_ID = "Ack";
    public static final String APP_LIST_EVENT_ID = "app_list";
    public static final int EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED = 129;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_APP_RECEIVED = 8;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_CLEAN_UP = 64;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_REVOKE_MESSAGE_SERVICE_RECEIVED = 2048;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_SERVICE_RECEIVED = 4;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_SHOW = 128;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_USER_CLICK = 16;
    public static final int EnumPushChannel = 0;
    public static final int EnumPushChannel_CHANNEL_FCM = 101;
    public static final int EnumPushChannel_CHANNEL_HONOR = 107;
    public static final int EnumPushChannel_CHANNEL_HUAWEI = 102;
    public static final int EnumPushChannel_CHANNEL_LOCAL = 99;
    public static final int EnumPushChannel_CHANNEL_MEIZU = 106;
    public static final int EnumPushChannel_CHANNEL_OPPO = 105;
    public static final int EnumPushChannel_CHANNEL_VIVO = 104;
    public static final int EnumPushChannel_CHANNEL_XG = 100;
    public static final int EnumPushChannel_CHANNEL_XIAOMI = 103;
    public static final String FAILED_CNT = "failed_cnt";
    public static final String HEARTBEAT_EVENT_ID = "SdkHeartbeat";
    public static final String IS_CUSTOMDATA_VERSION_EVENT_ID = "IsCustomDataVersion";
    public static final String LAST_REPORT_APPLIST = "last_reportAppList_time";
    public static final String LAST_REPORT_NOTIFICATION = "last_reportNotification_time";
    public static final String NETWORKTYOE = "np";
    public static final String NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID = "Action";
    public static final String NOTIFICATION_STATUS_EVENT_ID = "notification_st";
    public static final String REGISTER_EVENT_ID = "SdkRegister";
    public static final String SDK_ACK_EVENT_ID = "SdkAck";
    public static final String SDK_OTHER_PULLUP_ID = "OtherPull";
    public static final String SERVICE_EVENT_ID = "SdkService";
    public static final String SHOW_EVENT_ID = "SHOW";
    public static final String SRV_ACK_EVENT_ID = "SrvAck";
    public static final String STRATTIME = "failed_cnt";
    public static final String SUCC_CNT = "suc_cnt";
    public static final String UNREGISTER_EVENT_ID = "SdkUnRegister";
    public static final String VERIFY_EVENT_ID = "Verify";
    public static AtomicBoolean _isInited = new AtomicBoolean(false);
    private static Context a = null;
    private static boolean b = false;

    /* renamed from: c */
    private static volatile a f6378c;

    /* loaded from: classes3.dex */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            NetworkInfo networkInfo;
            if (intent == null || context == null || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) == null) {
                return;
            }
            TLogger.v("ServiceStat", "NetworkReceiver - Connection state changed to - " + networkInfo.toString());
            if (intent.getBooleanExtra("noConnectivity", false)) {
                TLogger.v("ServiceStat", "stat network is disConnected");
            } else if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                TLogger.v("ServiceStat", "stat network connected and sendLocalMsg on 5s later");
                CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.stat.ServiceStat.a.1
                    {
                        a.this = this;
                    }

                    @Override // com.tencent.tpns.baseapi.base.util.TTask
                    public void TRun() {
                        ServiceStat.sendLocalMsg(context);
                    }
                }, 5000L);
            } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                TLogger.v("ServiceStat", "Network is disconnected.");
            } else {
                TLogger.v("ServiceStat", "other network state - " + networkInfo.getState() + ". Do nothing.");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00d5 A[Catch: all -> 0x00fb, TryCatch #0 {all -> 0x00fb, blocks: (B:45:0x000f, B:47:0x0037, B:50:0x0041, B:51:0x0047, B:53:0x0063, B:54:0x0065, B:56:0x0072, B:58:0x0078, B:61:0x0081, B:63:0x008e, B:65:0x00d5, B:66:0x00f3, B:62:0x0088), top: B:73:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r16, android.content.Intent r17, int r18) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.stat.ServiceStat.a(android.content.Context, android.content.Intent, int):void");
    }

    public static void appReportInMsgUserDisabled(Context context, Intent intent) {
        a(context, intent, EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED);
    }

    public static void appReportNotificationCleared(Context context, Intent intent) {
        a(context, intent, 64);
    }

    public static void appReportNotificationClicked(Context context, Intent intent) {
        a(context, intent, 16);
    }

    public static void appReportNotificationShowed(Context context, Intent intent) {
        a(context, intent, 128);
    }

    public static void appReportPullupAck(Context context, Intent intent) {
    }

    public static void appReportRevokeMessageServiceReceived(Context context, Intent intent) {
        a(context, intent, 2048);
    }

    public static void appReportSDKReceived(Context context, Intent intent) {
        a(context, intent, 8);
    }

    public static void appReportServiceReceived(Context context, Intent intent) {
        a(context, intent, 4);
    }

    public static void commit() {
        StatServiceImpl.commitEvents(a, -1);
    }

    public static void debug(boolean z) {
        d.a(z);
    }

    public static synchronized void init(Context context) {
        synchronized (ServiceStat.class) {
            if (_isInited.get()) {
                return;
            }
            d.c(true);
            d.a(StatReportStrategy.INSTANT);
            StatServiceImpl.setContext(context);
            StatServiceImpl.getHandler(context);
            a = context.getApplicationContext();
            if (f6378c == null) {
                TLogger.d("ServiceStat", "register network receiver on ServiceStat.init");
                f6378c = new a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                a.getApplicationContext().registerReceiver(f6378c, intentFilter);
            }
            _isInited.set(true);
        }
    }

    public static void reportAck(ArrayList<PushStatClientReport> arrayList) {
    }

    public static void reportCloudControl(Context context, long j2, int i2, String str, long j3) {
        try {
            init(context);
            com.tencent.android.tpush.stat.event.b bVar = new com.tencent.android.tpush.stat.event.b(context, j2, i2);
            if (j3 != 0) {
                bVar.b = j3;
            }
            if (!TextUtils.isEmpty(str)) {
                bVar.a = str;
            }
            StatServiceImpl.reportXGEvent(context.getApplicationContext(), bVar);
        } catch (Throwable th) {
            TLogger.w("ServiceStat", "unexpected for reportCloudControl", th);
        }
    }

    public static void reportCustomData(Context context, String str, Properties properties) {
        init(context);
        StatServiceImpl.trackCustomKVEvent(context, str, properties);
    }

    public static void reportCustomData4FirstLaunch(Context context) {
        init(context);
        StatServiceImpl.trackCustomKVEvent(context, "FIRST_OPEN", null);
    }

    public static void reportErrCode(Context context, int i2, String str, long j2, String str2) {
        try {
            if (CloudManager.getInstance(context).disableReptErrCode()) {
                TLogger.d("ServiceStat", "disable reportErrCode");
                return;
            }
            init(context);
            g gVar = new g(context, i2, str2);
            if (!TextUtils.isEmpty(str)) {
                gVar.f6469m = str;
            }
            if (j2 != 0) {
                gVar.n = j2;
            }
            StatServiceImpl.reportXGEvent(context.getApplicationContext(), gVar);
        } catch (Throwable th) {
            TLogger.w("ServiceStat", "unexpected for reportErrCode", th);
        }
    }

    public static void reportIsCustomDataAcquisitionVersion(Context context) {
    }

    public static void reportLaunchEvent(Context context, int i2, int i3, long j2) {
        init(context);
        StatServiceImpl.trackLaunchEvent(context, i2, i3, j2);
    }

    public static void reportNotifactionClickedOrClear(ArrayList<PushStatClientReport> arrayList) {
    }

    public static void reportPullYYB() {
    }

    public static void reportSrvAck(ArrayList<j> arrayList) {
    }

    public static void reportTokenFailed(Context context) {
        try {
            if (b) {
                return;
            }
            String h2 = com.tencent.android.tpush.c.d.h();
            int i2 = 0;
            int i3 = (h.a(context).c() && XGPushConfig.isUsedFcmPush(context)) ? ErrCode.INNER_ERROR_FCM_TOKEN_ERROR : 0;
            if (com.tencent.android.tpush.c.d.a(context).l()) {
                if (com.tencent.android.tpush.e.a.b(context)) {
                    i2 = ErrCode.INNER_ERROR_SYS_TOKEN_ERROR;
                } else if ((ChannelUtils.isBrandXiaoMi() || ChannelUtils.isBrandBlackShark()) && !i.b(com.tencent.android.tpush.c.d.a)) {
                    i2 = ErrCode.INNER_ERROR_XIAOMI_TOKEN_ERROR;
                } else if ((ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) && !i.b(i.l(context))) {
                    i2 = ErrCode.INNER_ERROR_HUAWEI_TOKEN_ERROR;
                } else if (ChannelUtils.isBrandMeiZu() && !i.b(com.tencent.android.tpush.c.d.f6077c)) {
                    i2 = ErrCode.INNER_ERROR_MEIZU_TOKEN_ERROR;
                } else if (("oppo".equals(h2) || "oneplus".equals(h2) || "realme".equals(h2)) && !i.b(com.tencent.android.tpush.c.d.f6079e)) {
                    i2 = ErrCode.INNER_ERROR_OPPO_TOKEN_ERROR;
                } else if ("vivo".equals(h2) && !i.b(i.m(context))) {
                    i2 = ErrCode.INNER_ERROR_VIVO_TOKEN_ERROR;
                }
            }
            if (i3 == 0 && i2 == 0) {
                return;
            }
            b = true;
            if (i3 != 0 && i2 != 0) {
                reportErrCode(context, ErrCode.INNER_ERROR_FCM_AND_ChANNEL_TOKEN_ERROR, h2 + Constants.COLON_SEPARATOR + XGPushConfig.getOtherPushErrCode(context), 0L, "inner");
            } else if (i3 != 0) {
                reportErrCode(context, i3, h2 + Constants.COLON_SEPARATOR + XGPushConfig.getOtherPushErrCode(context), 0L, "inner");
            } else if (i2 != 0) {
                reportErrCode(context, i2, h2 + Constants.COLON_SEPARATOR + XGPushConfig.getOtherPushErrCode(context), 0L, "inner");
            }
        } catch (Throwable th) {
            TLogger.w("ServiceStat", "unexpected for reportTokenFailed", th);
        }
    }

    public static void reportXGLBS(Context context, String str, JSONObject jSONObject) {
    }

    public static void reportXGStat(Context context, long j2, String str, JSONObject jSONObject) {
    }

    public static void reportXGStat2(Context context, String str, JSONObject jSONObject) {
    }

    public static void sendLocalMsg(Context context) {
        if (context == null) {
            return;
        }
        init(context);
        if (StatServiceImpl.storedList) {
            StatServiceImpl.storedList = !StatServiceImpl.sendLocalMsg(context, -1);
        }
    }
}
