package com.tencent.android.tpush;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.baseapi.crosssp.ProviderMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class a {
    public static final String a = XGPushProvider.AUTH_PRIX;
    private static ReentrantLock b = new ReentrantLock();

    /* renamed from: c */
    private static Map<String, String> f6049c = new HashMap();

    public static synchronized Map<String, ProviderInfo> a(Context context) {
        HashMap hashMap;
        synchronized (a.class) {
            hashMap = new HashMap();
            for (ProviderInfo providerInfo : context.getPackageManager().queryContentProviders(null, 0, 0)) {
                if (providerInfo.name.equals(XGPushProvider.class.getName()) && providerInfo.authority.equals(a(providerInfo.packageName))) {
                    hashMap.put(providerInfo.packageName, providerInfo);
                    TLogger.d("ProviderUtils", "get local XG App list:" + providerInfo.authority + Constants.ACCEPT_TIME_SEPARATOR_SP + providerInfo.packageName + Constants.ACCEPT_TIME_SEPARATOR_SP + providerInfo.name);
                }
            }
        }
        return hashMap;
    }

    public static void b(Context context, String str, String str2) {
        Uri parse = Uri.parse("content://" + str + XGPushProvider.AUTH_PRIX + MqttTopic.TOPIC_LEVEL_SEPARATOR + TypeStr.feedback.getStr());
        ContentValues contentValues = new ContentValues();
        contentValues.put("feedback", Rijndael.encrypt(str2));
        try {
            ProviderMessage.update(context, parse, contentValues, null, null);
        } catch (Throwable th) {
            TLogger.e("ProviderUtils", "error : ", th);
        }
    }

    public static void c(Context context) {
        a(context, TypeStr.hearbeat_cyclecheck.getStr());
    }

    public static Map<Long, RegisterEntity> d(Context context) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        RegisterEntity currentAppRegisterEntity = CacheManager.getCurrentAppRegisterEntity(context);
        if (currentAppRegisterEntity != null) {
            concurrentHashMap.put(Long.valueOf(currentAppRegisterEntity.accessId), currentAppRegisterEntity);
        }
        return concurrentHashMap;
    }

    public static void b(Context context) {
        a(context, TypeStr.hearbeat.getStr());
    }

    public static String a(String str) {
        return str + a;
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str2);
            ProviderMessage.insert(context, Uri.parse("content://" + str + XGPushProvider.AUTH_PRIX + MqttTopic.TOPIC_LEVEL_SEPARATOR + TypeStr.msg.getStr()), contentValues);
            return true;
        } catch (Throwable th) {
            TLogger.e("ProviderUtils", "sendMsgByPkgName", th);
            ServiceStat.reportErrCode(context, ErrCode.INNER_ERROR_MSG_SHOW_ERROR, "sendMsgByPkgName err:" + Util.getThrowableToString(th), 0L, "inner");
            return false;
        }
    }

    public static boolean a(Context context, String str, Intent intent) {
        return a(context, str, intent.toURI());
    }

    private static void a(Context context, String str) {
        if (str == null) {
            return;
        }
        try {
            ProviderMessage.getType(context, Uri.parse("content://" + context.getPackageName() + XGPushProvider.AUTH_PRIX + MqttTopic.TOPIC_LEVEL_SEPARATOR + str));
        } catch (Throwable th) {
            TLogger.e("ProviderUtils", "heartbeat Provider error", th);
        }
    }
}
