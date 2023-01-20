package com.tencent.android.tpush;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Set;

/* loaded from: classes3.dex */
public class XGPush4Msdk {
    private static long a = 0;
    private static long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static String f5939c = "";

    private static boolean a(long j2, long j3, long j4) {
        return j2 >= j3 && j2 < j4;
    }

    public static long addLocalNotification(Context context, XGLocalMessage xGLocalMessage) {
        if (XGPushConfig.enableDebug) {
            TLogger.i("XGPush4Msdk", "addLocalNotification:msg=" + xGLocalMessage.toString() + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        return XGPushManager.a(context, xGLocalMessage, getQQAccessId(context));
    }

    public static void addTags(Context context, String str, Set<String> set) {
        if (XGPushConfig.enableDebug) {
            TLogger.d("XGPush4Msdk", "addTags: operateName=" + str + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        if (context != null && set != null && !set.isEmpty()) {
            String a2 = XGPushManager.a(set, "addTags");
            if (a2 == null) {
                TLogger.ee("XGPush4Msdk", "addTags -> getTagsFromSet return null!!!");
                return;
            }
            if (XGPushConfig.enableDebug) {
                TLogger.ii("XGPush4Msdk", "addTags -> setTags with all tags = " + a2);
            }
            XGPushManager.a(context, a2, 5, getQQAccessId(context), getQQAppKey(context), str);
            return;
        }
        TLogger.ee("XGPush4Msdk", "the parameter context or tags of addTags is invalid.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context) {
        return context.getPackageName() + Constants.COLON_SEPARATOR + "XG_DEBUG_SERVER_INFO";
    }

    public static void cleanTags(Context context, String str) {
        if (XGPushConfig.enableDebug) {
            TLogger.d("XGPush4Msdk", "cleanTags: operateName=" + str + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        if (context == null) {
            TLogger.ee("XGPush4Msdk", "the parameter context of cleanTags is invalid");
            return;
        }
        if (XGPushConfig.enableDebug) {
            TLogger.ii("XGPush4Msdk", "Action -> cleanTags");
        }
        XGPushManager.a(context, "*", 8, getQQAccessId(context), getQQAppKey(context), str);
    }

    public static void deleteTag(Context context, String str) {
        if (XGPushConfig.enableDebug) {
            TLogger.d("XGPush4Msdk", "deleteTag: tagName=" + str + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        XGPushManager.a(context, str, 2, getQQAccessId(context), getQQAppKey(context), str);
    }

    public static void deleteTags(Context context, String str, Set<String> set) {
        if (XGPushConfig.enableDebug) {
            TLogger.d("XGPush4Msdk", "deleteTags: operateName=" + str + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        if (context != null && set != null && !set.isEmpty()) {
            String a2 = XGPushManager.a(set, "deleteTags");
            if (a2 == null) {
                TLogger.ee("XGPush4Msdk", "deleteTags -> getTagsFromSet return null!!!");
                return;
            }
            if (XGPushConfig.enableDebug) {
                TLogger.ii("XGPush4Msdk", "deleteTags -> setTags with all tags = " + a2);
            }
            XGPushManager.a(context, a2, 7, getQQAccessId(context), getQQAppKey(context), str);
            return;
        }
        TLogger.ee("XGPush4Msdk", "the parameter context or tags of deleteTags is invalid.");
    }

    public static String getDebugServerInfo(Context context) {
        return PushPreferences.getString(context, b(context), null);
    }

    public static long getQQAccessId(Context context) {
        long j2 = b;
        if (j2 <= 0) {
            b = PushPreferences.getLong(context, "TPUSH_QQ_ACCESS_ID", j2);
        }
        return b;
    }

    public static String getQQAppKey(Context context) {
        if (!TextUtils.isEmpty(f5939c)) {
            return f5939c;
        }
        String string = PushPreferences.getString(context, "__en__TPUSH_QQ_ACCESS_KEY", f5939c);
        if (!TextUtils.isEmpty(string)) {
            f5939c = Rijndael.decrypt(string);
        } else {
            f5939c = PushPreferences.getString(context, "TPUSH_QQ_ACCESS_KEY", "");
            PushPreferences.putString(context, "TPUSH_QQ_ACCESS_KEY", "");
        }
        return f5939c;
    }

    public static boolean isDebugServerInfoStrategyItem(Context context) {
        try {
            String debugServerInfo = getDebugServerInfo(com.tencent.android.tpush.service.b.e());
            if (!i.b(debugServerInfo)) {
                String[] split = debugServerInfo.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length == 2) {
                    if (split[0].length() > 4) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            TLogger.e("XGPush4Msdk", " .isDebugServerInfoStrategyItem", th);
        }
        return false;
    }

    public static void registerPush(Context context, XGIOperateCallback xGIOperateCallback) {
        if (XGPushConfig.enableDebug) {
            TLogger.i("XGPush4Msdk", "registerPush=,qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        if (xGIOperateCallback == null) {
            xGIOperateCallback = new XGIOperateCallback() { // from class: com.tencent.android.tpush.XGPush4Msdk.2
                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i2, String str) {
                    TLogger.e("XGPush4Msdk", "xg register push onFail. token:" + obj + ", errCode:" + i2 + ",msg:" + str);
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i2) {
                    TLogger.i("XGPush4Msdk", "xg register push onSuccess. token:" + obj);
                }
            };
        }
        XGPushManager.a(context, null, -1, null, xGIOperateCallback, getQQAccessId(context), getQQAppKey(context), null, null, null, -1L);
    }

    public static void setDebugServerInfo(final Context context, String str, int i2) {
        if (!i.b(str)) {
            String b2 = b(context);
            PushPreferences.putString(context, b2, str + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
            return;
        }
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.XGPush4Msdk.1
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                Context context2 = context;
                if (i.b(PushPreferences.getString(context2, XGPush4Msdk.b(context2), null))) {
                    return;
                }
                Context context3 = context;
                PushPreferences.remove(context3, XGPush4Msdk.b(context3));
            }
        });
    }

    public static void setDefaultNotificationBuilder(Context context, XGPushNotificationBuilder xGPushNotificationBuilder) {
        XGPushManager.setDefaultNotificationBuilder(context, xGPushNotificationBuilder);
    }

    public static void setPushNotificationBuilder(Context context, int i2, XGPushNotificationBuilder xGPushNotificationBuilder) {
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        }
        if (i2 < 5000 || i2 > 6000) {
            throw new IllegalArgumentException("notificationBulderId超过范围[5000, 6000].");
        }
        if (xGPushNotificationBuilder == null) {
            return;
        }
        com.tencent.android.tpush.message.b.a(context, i2, xGPushNotificationBuilder);
    }

    public static void setQQAppId(Context context, long j2) {
        long j3 = 0;
        if (a(j2, 0L, 200000L)) {
            j3 = 90000000;
        } else if (!a(j2, 99000000L, 100000000L)) {
            if (a(j2, 100200000L, 100600000L)) {
                j3 = -10000000;
            } else if (a(j2, 101000000L, 101400000L)) {
                j3 = -10400000;
            } else if (a(j2, 900000000L, 900100000L)) {
                j3 = -809000000;
            } else if (a(j2, 1000000000L, 1000100000L)) {
                j3 = -908900000;
            } else if (a(j2, 1101000000L, 1104500000L)) {
                j3 = -1009800000;
            } else if (a(j2, 1150000000L, 1150100000L)) {
                j3 = -1055300000;
            } else if (a(j2, 100600000L, 101000000L)) {
                j3 = -5800000;
            } else if (a(j2, 1104500000L, 1109300000L)) {
                j3 = -1009300000;
            } else if (a(j2, 1109300000L, 1119300000L)) {
                j3 = -1029300000;
            } else if (a(j2, 1119300000L, 1120000000L)) {
                j3 = -1049300000;
            } else {
                TLogger.e("XGPush4Msdk", "手Q的appid：" + j2 + " 不在固定的范围，请联系msdk和信鸽的同事解决之。");
            }
        }
        long j4 = j3 + 2100000000 + j2;
        a = j2;
        b = j4;
        PushPreferences.putLong(context, "TPUSH_QQ_ACCESS_ID", j4);
        PushPreferences.remove(context, "TPUSH_QQ_APP_ID");
        String str = "MSDK_" + j2;
        f5939c = str;
        PushPreferences.putString(context, "__en__TPUSH_QQ_ACCESS_KEY", Rijndael.encrypt(str));
        PushPreferences.remove(context, "TPUSH_QQ_ACCESS_KEY");
    }

    public static void setQQAppKey(Context context, String str) {
    }

    public static void setTag(Context context, String str) {
        TLogger.d("XGPush4Msdk", "setTag: tagName=" + str + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        XGPushManager.a(context, str, 1, getQQAccessId(context), getQQAppKey(context), str);
    }

    public static void setTags(Context context, String str, Set<String> set) {
        if (XGPushConfig.enableDebug) {
            TLogger.d("XGPush4Msdk", "setTags: operateName=" + str + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        if (context != null && set != null && !set.isEmpty()) {
            String a2 = XGPushManager.a(set, "setTags");
            if (a2 == null) {
                TLogger.ee("XGPush4Msdk", "setTags -> getTagsFromSet return null!!!");
                return;
            }
            TLogger.ii("XGPush4Msdk", "Action -> setTags with all tags = " + a2);
            XGPushManager.a(context, a2, 6, getQQAccessId(context), getQQAppKey(context), str);
            return;
        }
        TLogger.ee("XGPush4Msdk", "the parameter context or tags of setTags is invalid.");
    }

    public static void unregisterPush(Context context, XGIOperateCallback xGIOperateCallback) {
        if (XGPushConfig.enableDebug) {
            TLogger.i("XGPush4Msdk", "unregisterPush,qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        if (xGIOperateCallback == null) {
            xGIOperateCallback = new XGIOperateCallback() { // from class: com.tencent.android.tpush.XGPush4Msdk.3
                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i2, String str) {
                    TLogger.e("XGPush4Msdk", "xg unregisterPush push onFail. token:" + obj + ", errCode:" + i2 + ",msg:" + str);
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i2) {
                    TLogger.i("XGPush4Msdk", "xg unregisterPush push onSuccess. flag:" + i2);
                }
            };
        }
        XGPushManager.a(context, xGIOperateCallback, getQQAccessId(context), getQQAppKey(context), (String) null, (String) null, (String) null);
    }
}
