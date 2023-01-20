package com.tencent.android.tpush.service.util;

import android.app.AppOpsManager;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {
    public static int a = -1;
    private static volatile String b;

    public static int b(Context context) {
        try {
        } catch (Throwable th) {
            TLogger.e("NotificationsUtils", th.getMessage());
        }
        if (CloudManager.getInstance(context).disableCollData()) {
            TLogger.d("NotificationsUtils", "disable notification status");
            return 4;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            TLogger.i("NotificationsUtils", "OS >= 26, return true");
            return NotificationManagerCompat.from(context).areNotificationsEnabled() ? 2 : 1;
        }
        if (i2 >= 19) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i3 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0 ? 2 : 1;
        }
        return 4;
    }

    public static List<a> c(Context context) {
        List<NotificationChannel> notificationChannels;
        if (context == null) {
            return null;
        }
        if (CloudManager.getInstance(context).disableCollData()) {
            TLogger.d("NotificationsUtils", "disable notification status");
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && NotificationManagerCompat.from(context).areNotificationsEnabled() && (notificationChannels = ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).getNotificationChannels()) != null && notificationChannels.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (NotificationChannel notificationChannel : notificationChannels) {
                a a2 = a(context, notificationChannel);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return null;
    }

    public static boolean a(Context context) {
        try {
        } catch (Throwable th) {
            TLogger.e("NotificationsUtils", th.getMessage());
        }
        if (CloudManager.getInstance(context).disableCollData()) {
            TLogger.d("NotificationsUtils", "disable notification");
            return true;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            TLogger.i("NotificationsUtils", "OS >= 26, return true");
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        }
        if (i2 >= 19) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i3 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0;
        }
        return true;
    }

    /* loaded from: classes3.dex */
    public static class a implements Comparable<a> {
        public int a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f6372c;

        public a(int i2, String str, String str2) {
            this.a = i2;
            this.b = str;
            this.f6372c = str2;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", this.a);
            jSONObject.put("id", this.b);
            jSONObject.put("name", this.f6372c);
            return jSONObject;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            if (aVar != null) {
                return (this.b + this.f6372c + "").compareTo(aVar.b + aVar.f6372c + "");
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, int i2, List<a> list) {
        try {
            TLogger.d("NotificationsUtils", "lastNtfStr:" + b);
            if (b != null && !TextUtils.isEmpty(b.trim())) {
                String a2 = a(i2, list);
                TLogger.d("NotificationsUtils", "currentNtfStr:" + a2);
                return !TextUtils.equals(b, a2);
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    private static a a(Context context, NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            String group = notificationChannel.getGroup();
            CharSequence name = notificationChannel.getName();
            String id = notificationChannel.getId();
            return new a(a(context, group, id), id, name.toString());
        }
        return null;
    }

    private static int a(Context context, String str, String str2) {
        NotificationChannel notificationChannel;
        NotificationChannelGroup notificationChannelGroup;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            if ((i2 < 28 || str == null || (notificationChannelGroup = notificationManager.getNotificationChannelGroup(str)) == null || !notificationChannelGroup.isBlocked()) && (notificationChannel = notificationManager.getNotificationChannel(str2)) != null) {
                return notificationChannel.getImportance();
            }
        }
        return 0;
    }

    public static String a(int i2, List<a> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Md5.md5(a(list) + i2 + "");
        }
        return i2 + "";
    }

    private static String a(List<a> list) {
        if (list != null && list.size() != 0) {
            try {
                Collections.sort(list);
                StringBuffer stringBuffer = new StringBuffer();
                for (a aVar : list) {
                    if (aVar != null) {
                        stringBuffer.append(aVar.b);
                        stringBuffer.append(aVar.f6372c);
                        stringBuffer.append(aVar.a);
                    }
                }
                return stringBuffer.toString();
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static void a(final Context context, boolean z) {
        TTask tTask = new TTask() { // from class: com.tencent.android.tpush.service.util.b.1
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                TLogger.d("NotificationsUtils", "onCheckNotification registerStatus: " + b.a);
                if (b.a == 1) {
                    if (b.b(context, b.b(context), b.c(context)) && XGApiConfig.isRegistered(context)) {
                        TLogger.i("NotificationsUtils", "notificationStateChanged was changed, registerPush again");
                        XGPushManager.registerPush(context);
                        return;
                    }
                    TLogger.d("NotificationsUtils", "notification not changed, or unRegistered");
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            CommonWorkingThread.getInstance().execute(tTask);
        } else {
            tTask.run();
        }
    }

    public static void a(String str) {
        TLogger.d("NotificationsUtils", "updateLastUploadMd5Str:" + b + ",str:" + str);
        if (str == null) {
            TLogger.d("NotificationsUtils", "params was null, ingore!");
        }
        b = str;
    }
}
