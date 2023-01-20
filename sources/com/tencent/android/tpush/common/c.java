package com.tencent.android.tpush.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.vivo.push.PushClientConstants;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class c {
    private static int a;
    private static int b;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f6088c;

    /* renamed from: d  reason: collision with root package name */
    private static ReentrantLock f6089d = new ReentrantLock();

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Context context = this.a;
            if (context == null) {
                super.handleMessage(message);
                return;
            }
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2) {
                    c.i(context, message.arg1);
                    return;
                } else {
                    super.handleMessage(message);
                    return;
                }
            }
            if (c.b > 0) {
                c.a(1);
            }
            if (c.b == 0) {
                c.h(this.a, c.a);
                int unused = c.a = 0;
                c.f6088c.removeCallbacks(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        bundle.putString("class", i.p(context));
        bundle.putInt("badgenumber", i2);
        context.getContentResolver().call(Uri.parse(str), "change_badge", (String) null, bundle);
    }

    public static void e(final Context context, final int i2) {
        String b2 = i.b();
        if (TextUtils.isEmpty(b2) || !"vivo".equals(b2)) {
            return;
        }
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.common.c.4
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                try {
                    TLogger.i("BadgeUtils", "set vivo badge " + i2);
                    Intent intent = new Intent();
                    intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                    intent.putExtra(Constants.FLAG_PACKAGE_NAME, context.getPackageName());
                    intent.putExtra(PushClientConstants.TAG_CLASS_NAME, i.p(context));
                    intent.putExtra("notificationNum", i2);
                    intent.addFlags(16777216);
                    context.sendBroadcast(intent);
                } catch (Throwable th) {
                    TLogger.w("BadgeUtils", "set vivo badge error: " + th.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(final Context context, final int i2) {
        if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) {
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.common.c.1
                @Override // com.tencent.tpns.baseapi.base.util.TTask
                public void TRun() {
                    String str;
                    boolean isBrandHonor = ChannelUtils.isBrandHonor();
                    if (ChannelUtils.isBrandHuaWei()) {
                        TLogger.i("BadgeUtils", "change huawei badge " + i2);
                        str = "content://com.huawei.android.launcher.settings/badge/";
                    } else if (isBrandHonor) {
                        TLogger.i("BadgeUtils", "change honor badge " + i2);
                        str = "content://com.hihonor.android.launcher.settings/badge/";
                    } else {
                        str = "";
                    }
                    try {
                        c.c(context, str, i2);
                    } catch (Throwable th) {
                        TLogger.w("BadgeUtils", "change huawei badge error: " + th.toString());
                        if (isBrandHonor) {
                            try {
                                c.c(context, "content://com.huawei.android.launcher.settings/badge/", i2);
                            } catch (Throwable unused) {
                                TLogger.w("BadgeUtils", "change honor badge with huawei uri error: " + th.toString());
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(final Context context, final int i2) {
        if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) {
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.common.c.2
                @Override // com.tencent.tpns.baseapi.base.util.TTask
                public void TRun() {
                    boolean isBrandHonor = ChannelUtils.isBrandHonor();
                    String str = ChannelUtils.isBrandHuaWei() ? "content://com.huawei.android.launcher.settings/badge/" : isBrandHonor ? "content://com.hihonor.android.launcher.settings/badge/" : "";
                    TLogger.i("BadgeUtils", "set huawei badge " + i2);
                    try {
                        c.d(context, str, i2);
                    } catch (Throwable th) {
                        TLogger.w("BadgeUtils", "set huawei badge error: " + th.toString());
                        if (isBrandHonor) {
                            try {
                                c.d(context, "content://com.huawei.android.launcher.settings/badge/", i2);
                            } catch (Throwable unused) {
                                TLogger.w("BadgeUtils", "set honor badge with huawei uri error: " + th.toString());
                            }
                        }
                    }
                }
            });
        }
    }

    public static /* synthetic */ int a(int i2) {
        int i3 = b - i2;
        b = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        bundle.putString("class", i.p(context));
        Bundle call = context.getContentResolver().call(Uri.parse(str), "getbadgeNumber", (String) null, bundle);
        int i3 = 0;
        int i4 = (call != null ? call.getInt("badgenumber", 0) : 0) + i2;
        if (i4 >= 0) {
            i3 = i4;
        }
        bundle.putInt("badgenumber", i3);
        context.getContentResolver().call(Uri.parse(str), "change_badge", (String) null, bundle);
    }

    public static void a(Context context) {
        b(context, 0);
    }

    public static void b(Context context, int i2) {
        if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) {
            try {
                if (f6088c == null) {
                    f6088c = new a(context.getApplicationContext());
                }
                Message message = new Message();
                message.what = 2;
                message.arg1 = i2;
                f6088c.sendMessage(message);
            } catch (Throwable th) {
                TLogger.w("BadgeUtils", "set huawei badge error: " + th.toString());
            }
        }
    }

    public static void a(Context context, int i2) {
        StringBuilder sb;
        if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) {
            try {
                f6089d.lock();
                if (f6088c == null) {
                    f6088c = new a(context.getApplicationContext());
                }
                b++;
                a += i2;
                Message message = new Message();
                message.what = 1;
                f6088c.sendMessageDelayed(message, 200L);
                try {
                    f6089d.unlock();
                } catch (Throwable th) {
                    th = th;
                    sb = new StringBuilder();
                    sb.append("change huawei badge unlock error: ");
                    sb.append(th.toString());
                    TLogger.e("BadgeUtils", sb.toString());
                }
            } catch (Throwable th2) {
                try {
                    TLogger.w("BadgeUtils", "change huawei badge error: " + th2.toString());
                    try {
                        f6089d.unlock();
                    } catch (Throwable th3) {
                        th = th3;
                        sb = new StringBuilder();
                        sb.append("change huawei badge unlock error: ");
                        sb.append(th.toString());
                        TLogger.e("BadgeUtils", sb.toString());
                    }
                } catch (Throwable th4) {
                    try {
                        f6089d.unlock();
                    } catch (Throwable th5) {
                        TLogger.e("BadgeUtils", "change huawei badge unlock error: " + th5.toString());
                    }
                    throw th4;
                }
            }
        }
    }

    public static void d(final Context context, final int i2) {
        String b2 = i.b();
        if (TextUtils.isEmpty(b2) || !"oppo".equals(b2)) {
            return;
        }
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.common.c.3
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                try {
                    TLogger.i("BadgeUtils", "set oppo badge " + i2);
                    Bundle bundle = new Bundle();
                    bundle.putInt("app_badge_count", i2);
                    context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
                } catch (Throwable th) {
                    TLogger.w("BadgeUtils", "set oppo badge error" + th.toString());
                }
            }
        });
    }

    public static void b(Context context) {
        b(context, 0);
        d(context, 0);
        e(context, 0);
    }

    public static void c(Context context, int i2) {
        if (i2 < 0) {
            return;
        }
        b(context, i2);
        e(context, i2);
        d(context, i2);
    }
}
