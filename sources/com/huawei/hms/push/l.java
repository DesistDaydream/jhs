package com.huawei.hms.push;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.effective.android.panel.Constants;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.android.tpns.mqtt.MqttTopic;

/* loaded from: classes2.dex */
public class l {
    public static int a(Context context) {
        int i2 = context.getApplicationInfo().icon;
        if (i2 == 0) {
            int identifier = context.getResources().getIdentifier("btn_star_big_on", "drawable", Constants.ANDROID);
            HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
            if (identifier == 0) {
                HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
                return 17301651;
            }
            return identifier;
        }
        return i2;
    }

    public static int b(Context context, k kVar) {
        int i2 = 0;
        if (context != null && kVar != null) {
            if (!TextUtils.isEmpty(kVar.m())) {
                String[] split = kVar.m().split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                if (split.length == 3) {
                    i2 = r.a(context, split[1], split[2]);
                }
            }
            if (i2 == 0) {
                i2 = r.a(context, "com.huawei.messaging.default_notification_icon");
            }
            return i2 != 0 ? i2 : a(context);
        }
        HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
        return 0;
    }

    public static Bitmap a(Context context, k kVar) {
        if (context == null || kVar == null) {
            return null;
        }
        try {
            if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                return null;
            } else if ("com.huawei.android.pushagent".equals(kVar.k())) {
                return null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("get left bitmap from ");
                sb.append(kVar.k());
                HMSLog.i("PushSelfShowLog", sb.toString());
                return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(kVar.k())).getBitmap();
            }
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("PushSelfShowLog", "build left icon occur NameNotFoundException.");
            return null;
        } catch (Exception unused2) {
            HMSLog.e("PushSelfShowLog", "build left icon occur Exception.");
            return null;
        }
    }

    @TargetApi(23)
    public static void a(Context context, Notification.Builder builder, k kVar) {
        if (context != null && builder != null && kVar != null) {
            builder.setSmallIcon(b(context, kVar));
        } else {
            HMSLog.e("PushSelfShowLog", "msg is null");
        }
    }
}
