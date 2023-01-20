package com.tencent.android.tpush.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CacheHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.xiaomi.mipush.sdk.Constants;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20160810", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
/* loaded from: classes3.dex */
public class b {
    public static void a(final Context context) {
        if (context == null) {
            TLogger.ee("OtherPushClient", "updateToken Error: context is null");
            return;
        }
        try {
            if (XGPushConfig.isUsedOtherPush(context) && d.a(context).k()) {
                CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.c.b.1
                    @Override // com.tencent.tpns.baseapi.base.util.TTask
                    public void TRun() {
                        b.c(context);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        final String token = XGPushConfig.getToken(context);
        if (token == null) {
            TLogger.i("OtherPushClient", "updateToken: TPNS Token has not registered");
            return;
        }
        d.a(context).o();
        String i2 = d.a(context).i();
        final String e2 = d.a(context).e();
        TLogger.ii("OtherPushClient", "handleUpdateToken other push token is : " + e2 + " other push type: " + i2);
        if (!i.b(i2) && !i.b(e2)) {
            try {
                final long accessId = XGPushConfig.getAccessId(context);
                String accessKey = XGPushConfig.getAccessKey(context);
                String str = (String) CacheHelper.get(context, com.tencent.android.tpush.d.b.a.a(accessId + ""));
                if (!i.b(str)) {
                    long longValue = ((Long) CacheHelper.get(context, com.tencent.android.tpush.d.b.a.b(accessId + ""))).longValue();
                    if (str.equals(token + Constants.COLON_SEPARATOR + e2) && Math.abs(System.currentTimeMillis() - longValue) < 86400000) {
                        TLogger.ii("OtherPushClient", "Already bind OtherPush succeed token with accessId = " + accessId + "  token = " + token + " otherPushType = " + i2 + " otherPushToken = " + e2);
                        return;
                    }
                    TLogger.ii("OtherPushClient", "OtherToken or Mid changed , go on bind");
                }
                BroadcastAgent.registerReceiver(context, new BroadcastReceiver() { // from class: com.tencent.android.tpush.c.b.2
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(final Context context2, Intent intent) {
                        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.c.b.2.1
                            @Override // com.tencent.tpns.baseapi.base.util.TTask
                            public void TRun() {
                                TLogger.ii("OtherPushClient", "handleUpdateOtherPushToken call back to " + context2.getPackageName());
                                Context context3 = context2;
                                CacheHelper.Key<String> a = com.tencent.android.tpush.d.b.a.a(accessId + "");
                                CacheHelper.set(context3, a.set(token + Constants.COLON_SEPARATOR + e2), com.tencent.android.tpush.d.b.a.b(accessId + "").set(Long.valueOf(System.currentTimeMillis())));
                            }
                        });
                        i.a(context2, this);
                    }
                }, new IntentFilter("com.tencent.android.xg.vip.action.UPDATE.OTHER.TOKEN.RESULT.V4"));
                Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.UPDATE_OTHER_PUSH_TOKEN.V4");
                intent.putExtra("accId", Rijndael.encrypt("" + accessId));
                intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ACC_KEY, Rijndael.encrypt("" + accessKey));
                intent.putExtra("token", Rijndael.encrypt(token));
                intent.putExtra("other_push_type", Rijndael.encrypt(i2));
                intent.putExtra("other_push_token", Rijndael.encrypt(e2));
                BroadcastAgent.sendBroadcast(context, intent);
                return;
            } catch (Throwable th) {
                TLogger.e("OtherPushClient", "sendBroadcast action ACTION_UPDATE_OTHER_PUSH_TOKEN error", th);
                return;
            }
        }
        TLogger.ww("OtherPushClient", "updateToken Error: get otherPushType or otherPushToken is null");
    }
}
