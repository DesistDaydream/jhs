package com.tencent.android.tpush.stat.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import com.tencent.android.tpush.InnerTpnsActivity;
import com.tencent.android.tpush.TpnsActivity;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.b;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import java.util.Set;

/* loaded from: classes3.dex */
public class a extends TTask {
    private static long a;
    private static long b;

    /* renamed from: g  reason: collision with root package name */
    private static String f6401g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile boolean f6402h;

    /* renamed from: i  reason: collision with root package name */
    private static a f6403i;

    /* renamed from: c  reason: collision with root package name */
    private Intent f6404c;

    /* renamed from: d  reason: collision with root package name */
    private String f6405d;

    /* renamed from: e  reason: collision with root package name */
    private Context f6406e;

    /* renamed from: f  reason: collision with root package name */
    private int f6407f;

    public a(Context context, Intent intent, String str, int i2) {
        super("AppLaunchTask");
        this.f6404c = intent;
        this.f6405d = str;
        this.f6406e = context;
        this.f6407f = i2;
    }

    private void a() {
        Context context = this.f6406e;
        if (i.c(context, context.getPackageName()) && PushPreferences.getBoolean(this.f6406e, "app_first_launch", true)) {
            ServiceStat.reportCustomData4FirstLaunch(this.f6406e);
            PushPreferences.putBoolean(this.f6406e, "app_first_launch", false);
        }
    }

    private void b() {
        if (!CloudManager.getInstance(this.f6406e).disableRepLanuEv()) {
            int i2 = 4;
            long j2 = 0;
            if (!TextUtils.equals(this.f6405d, TpnsActivity.class.getCanonicalName()) && !TextUtils.equals(this.f6405d, InnerTpnsActivity.class.getCanonicalName())) {
                Intent intent = this.f6404c;
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data == null || i.b(data.getHost())) {
                        String action = this.f6404c.getAction();
                        Set<String> categories = this.f6404c.getCategories();
                        boolean z = categories != null && categories.contains("android.intent.category.LAUNCHER");
                        if (TextUtils.equals(action, "android.intent.action.MAIN") && z) {
                            i2 = 1;
                        }
                    } else {
                        i2 = 2;
                    }
                }
            } else {
                i2 = 3;
                j2 = TpnsActivity.getMsgIdWithIntent(this.f6404c);
            }
            ServiceStat.reportLaunchEvent(this.f6406e, i2, b(this.f6406e), j2);
            return;
        }
        TLogger.d("AppLaunchTask", "disabled report launch event");
    }

    private static synchronized int c() {
        synchronized (a.class) {
            long currentTimeMillis = System.currentTimeMillis() - a;
            long j2 = b;
            if (j2 != 0 || currentTimeMillis <= JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS) {
                return (j2 != 0 || currentTimeMillis <= 8000) ? -1 : 1;
            }
            return 2;
        }
    }

    @Override // com.tencent.tpns.baseapi.base.util.TTask
    public void TRun() {
        Context context = this.f6406e;
        if (context == null) {
            TLogger.d("AppLaunchTask", "context was null");
        } else if (i.a(context) > 0) {
            TLogger.d("AppLaunchTask", "TPNS init failed!");
        } else {
            if (this.f6407f == 2) {
                a();
                b();
            }
            b.a(this.f6406e, true);
        }
    }

    private static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (i.b(f6401g)) {
            String token = GuidInfoManager.getToken(context.getApplicationContext());
            f6401g = token;
            return !i.b(token);
        }
        return true;
    }

    public static void a(Context context, String str, String str2) {
        try {
            if (i.b(str)) {
                TLogger.d("AppLaunchTask", "token was null");
            } else if (context == null) {
                TLogger.d("AppLaunchTask", "context was null");
            } else if (!Util.isMainProcess(context)) {
                TLogger.d("AppLaunchTask", "must run at main process");
            } else {
                f6401g = str;
                if (!f6402h || f6403i == null) {
                    return;
                }
                CommonWorkingThread.getInstance().execute(f6403i);
                f6402h = false;
                f6403i = null;
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(Activity activity, String str) {
        try {
            if (activity == null) {
                TLogger.w("AppLaunchTask", "onActivityEntry - activity was null, reason:" + str);
            } else if (a(activity)) {
                TLogger.d("AppLaunchTask", "activity was wake translucent Activity");
            } else {
                int c2 = c();
                if (!a((Context) activity)) {
                    if (c2 == 2) {
                        f6402h = true;
                        f6403i = a(activity, str, c2);
                        return;
                    }
                    return;
                }
                if (c2 > 0) {
                    b(activity, str, c2);
                }
                if (b == 0) {
                    b = System.currentTimeMillis();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Activity activity, String str) {
        try {
            if (activity == null) {
                TLogger.w("AppLaunchTask", "onActivityExits - activity was null, reason:" + str);
            } else if (a(activity)) {
                TLogger.d("AppLaunchTask", "setLastedBackgroundTime - activity was wake translucent Activity");
            } else {
                a = System.currentTimeMillis();
                if (b != 0) {
                    b = 0L;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(Activity activity, String str, int i2) {
        try {
            a a2 = a(activity, str, i2);
            if (a2 != null) {
                CommonWorkingThread.getInstance().execute(a2);
            }
            f6403i = null;
            f6402h = false;
        } catch (Throwable th) {
            TLogger.d("AppLaunchTask", "unexpected for runAppLaunch:" + th.getMessage());
        }
    }

    private static boolean a(Activity activity) {
        if (activity == null) {
            TLogger.d("AppLaunchTask", "isWakeTranslucentActivity - activity was null");
            return false;
        }
        String className = activity.getComponentName().getClassName();
        return (!i.a(activity) || TextUtils.equals(className, TpnsActivity.class.getCanonicalName()) || TextUtils.equals(className, InnerTpnsActivity.class.getCanonicalName())) ? false : true;
    }

    private int b(Context context) {
        long j2 = PushPreferences.getLong(context, "fisrt.launch.of.the.day", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        boolean a2 = i.a(currentTimeMillis, j2);
        if (!a2) {
            PushPreferences.putLong(context, "fisrt.launch.of.the.day", currentTimeMillis);
        }
        return !a2 ? 1 : 0;
    }

    private static a a(Activity activity, String str, int i2) {
        if (activity == null) {
            TLogger.d("AppLaunchTask", "runAppLaunch - activity was null");
            return null;
        }
        String className = activity.getComponentName().getClassName();
        return new a(activity.getApplicationContext(), activity.getIntent(), className, i2);
    }
}
