package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.handler.a.c.e;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class a<T> implements com.meizu.cloud.pushsdk.handler.c {
    private com.meizu.cloud.pushsdk.handler.a a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private SparseArray<String> f4892c;

    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.b = context.getApplicationContext();
        this.a = aVar;
        SparseArray<String> sparseArray = new SparseArray<>();
        this.f4892c = sparseArray;
        sparseArray.put(2, "MESSAGE_TYPE_PUSH_SERVICE_V2");
        this.f4892c.put(4, "MESSAGE_TYPE_PUSH_SERVICE_V3");
        this.f4892c.put(16, "MESSAGE_TYPE_REGISTER");
        this.f4892c.put(32, "MESSAGE_TYPE_UNREGISTER");
        this.f4892c.put(8, "MESSAGE_TYPE_THROUGH");
        this.f4892c.put(64, "MESSAGE_TYPE_NOTIFICATION_CLICK");
        this.f4892c.put(128, "MESSAGE_TYPE_NOTIFICATION_DELETE");
        this.f4892c.put(256, "MESSAGE_TYPE_PUSH_SWITCH_STATUS");
        this.f4892c.put(512, "MESSAGE_TYPE_PUSH_REGISTER_STATUS");
        this.f4892c.put(2048, "MESSAGE_TYPE_PUSH_SUBTAGS_STATUS");
        this.f4892c.put(1024, "MESSAGE_TYPE_PUSH_UNREGISTER_STATUS");
        this.f4892c.put(4096, "MESSAGE_TYPE_PUSH_SUBALIAS_STATUS");
        this.f4892c.put(8192, "MESSAGE_TYPE_SCHEDULE_NOTIFICATION");
        this.f4892c.put(16384, "MESSAGE_TYPE_RECEIVE_NOTIFY_MESSAGE");
        this.f4892c.put(32768, "MESSAGE_TYPE_NOTIFICATION_STATE");
        this.f4892c.put(65536, "MESSAGE_TYPE_UPLOAD_FILE_LOG");
        this.f4892c.put(131072, "MESSAGE_TYPE_NOTIFICATION_ARRIVED");
        this.f4892c.put(262144, "MESSAGE_TYPE_NOTIFICATION_WITHDRAW");
        this.f4892c.put(524288, "MESSAGE_TYPE_BRIGHT_NOTIFICATION");
        this.f4892c.put(1048576, "MESSAGE_TYPE_NOTIFICATION_CLOSE");
    }

    private String a(int i2) {
        return this.f4892c.get(i2);
    }

    private boolean a(String str, MessageV3 messageV3, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            str3 = "sa, public key not empty";
        } else if (!PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(str2)) {
            str3 = "sa, message not click method";
        } else if (com.meizu.cloud.pushsdk.util.b.l(d(), messageV3.getPackageName())) {
            com.meizu.cloud.pushsdk.util.b.c(d(), messageV3.getPackageName(), false);
            return true;
        } else {
            str3 = "sa, not first request";
        }
        e.p.a.a.a.c("AbstractMessageHandler", str3);
        return false;
    }

    private boolean b(String str, MessageV3 messageV3, String str2) {
        if (TextUtils.isEmpty(str)) {
            e.p.a.a.a.f("AbstractMessageHandler", "security check fail, public key is null");
            return false;
        }
        String a = com.meizu.cloud.pushsdk.util.c.a(str, str2);
        e.p.a.a.a.c("AbstractMessageHandler", "decrypt sign: " + a);
        boolean a2 = com.meizu.cloud.pushsdk.handler.a.c.e.a(a, messageV3);
        e.p.a.a.a.c("AbstractMessageHandler", "check public key result: " + a2);
        return a2;
    }

    private String e() {
        String str = null;
        for (int i2 = 0; i2 < 2; i2++) {
            str = b();
            if (!TextUtils.isEmpty(str)) {
                break;
            }
        }
        return str;
    }

    public com.meizu.cloud.pushsdk.notification.c a(T t) {
        return null;
    }

    public void a(Context context, MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.handler.a.a.a b;
        com.meizu.cloud.pushsdk.notification.model.a a;
        if (messageV3.getAdvertisementOption() == null || TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage()) || (b = com.meizu.cloud.pushsdk.b.a(context).b()) == null || (a = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3)) == null) {
            return;
        }
        b.a(a.a());
    }

    public void a(MessageV3 messageV3) {
        if (messageV3 == null || messageV3.getAdvertisementOption() == null || TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage())) {
            if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
                c().b(d(), MzPushMessage.fromMessageV3(messageV3));
            } else if (MzSystemUtils.isRunningProcess(d(), messageV3.getUploadDataPackageName())) {
                e.p.a.a.a.c("AbstractMessageHandler", "send notification arrived message to " + messageV3.getUploadDataPackageName());
                Intent intent = new Intent();
                if (MinSdkChecker.isSupportTransmitMessageValue(this.b, messageV3.getUploadDataPackageName())) {
                    intent.putExtra(PushConstants.MZ_MESSAGE_VALUE, com.meizu.cloud.pushsdk.handler.d.a(messageV3));
                } else {
                    intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
                }
                intent.putExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_ARRIVED);
                MzSystemUtils.sendMessageFromBroadcast(d(), intent, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getUploadDataPackageName());
            }
        }
    }

    public abstract void a(T t, com.meizu.cloud.pushsdk.notification.c cVar);

    public boolean a(int i2, String str) {
        boolean z = true;
        if (i2 == 0) {
            z = com.meizu.cloud.pushsdk.util.b.e(d(), str);
        } else if (i2 == 1) {
            z = com.meizu.cloud.pushsdk.util.b.h(d(), str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i2 == 0 ? " canNotificationMessage " : " canThroughMessage ");
        sb.append(z);
        e.p.a.a.a.c("AbstractMessageHandler", sb.toString());
        return z;
    }

    public final boolean a(MessageV3 messageV3, String str) {
        String a = com.meizu.cloud.pushsdk.handler.a.c.e.a(messageV3);
        if (TextUtils.isEmpty(a)) {
            e.p.a.a.a.c("AbstractMessageHandler", "message does not contain signature field");
            return false;
        }
        String k2 = com.meizu.cloud.pushsdk.util.b.k(d(), messageV3.getPackageName());
        e.p.a.a.a.c("AbstractMessageHandler", "local public key is: " + k2);
        if (a(k2, messageV3, str)) {
            e.p.a.a.a.c("AbstractMessageHandler", "message special approval no check");
            return true;
        } else if (b(k2, messageV3, a)) {
            e.p.a.a.a.c("AbstractMessageHandler", "security check passed");
            return true;
        } else {
            String e2 = e();
            e.p.a.a.a.c("AbstractMessageHandler", "network request public key: " + e2);
            if (!b(e2, messageV3, a)) {
                e.p.a.a.a.f("AbstractMessageHandler", "security check fail");
                return false;
            }
            com.meizu.cloud.pushsdk.util.b.k(d(), messageV3.getPackageName(), e2);
            e.p.a.a.a.c("AbstractMessageHandler", "security check passed");
            return true;
        }
    }

    public boolean a(T t, String str) {
        return true;
    }

    public boolean a(String str) {
        try {
            return d().getPackageName().equals(new JSONObject(str).getString("appId"));
        } catch (Exception unused) {
            e.p.a.a.a.f("AbstractMessageHandler", "parse notification error");
            return false;
        }
    }

    public String b() {
        return new e.a((String) com.meizu.cloud.pushsdk.c.a.a(PushConstants.GET_PUBLIC_KEY).a().a().a()).a();
    }

    public String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("launcher");
            return (!jSONObject.has("pkg") || TextUtils.isEmpty(jSONObject.getString("pkg"))) ? "" : jSONObject.getString("pkg");
        } catch (Exception unused) {
            e.p.a.a.a.f("AbstractMessageHandler", "parse desk top json error");
            return "";
        }
    }

    public void b(MessageV3 messageV3) {
        if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            c(messageV3);
            return;
        }
        com.meizu.cloud.pushsdk.notification.model.a a = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a != null) {
            e.p.a.a.a.f("AbstractMessageHandler", "delete notifyId " + a.a() + " notifyKey " + a.b());
            if (TextUtils.isEmpty(a.b())) {
                com.meizu.cloud.pushsdk.platform.a.b.a(d()).a(messageV3.getUploadDataPackageName(), a.a());
            } else {
                com.meizu.cloud.pushsdk.platform.a.b.a(d()).a(messageV3.getUploadDataPackageName(), a.b());
            }
        }
    }

    public void b(T t) {
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a7 A[ADDED_TO_REGION] */
    @Override // com.meizu.cloud.pushsdk.handler.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(android.content.Intent r7) {
        /*
            r6 = this;
            boolean r0 = r6.a(r7)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "current message Type "
            r0.append(r2)
            int r2 = r6.a()
            java.lang.String r2 = r6.a(r2)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "AbstractMessageHandler"
            e.p.a.a.a.c(r2, r0)
            java.lang.Object r0 = r6.c(r7)
            java.lang.String r7 = r6.k(r7)
            boolean r7 = r6.a(r0, r7)
            if (r7 != 0) goto L3a
            java.lang.String r7 = "invalid push message"
            e.p.a.a.a.f(r2, r7)
            return r1
        L3a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r3 = "current Handler message "
            r7.append(r3)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            e.p.a.a.a.c(r2, r7)
            r6.b(r0)
            int r7 = r6.d(r0)
            r3 = 1
            if (r7 == 0) goto L87
            if (r7 == r3) goto L81
            r4 = 2
            if (r7 == r4) goto L7e
            r4 = 3
            if (r7 == r4) goto L74
            r4 = 4
            if (r7 == r4) goto L6b
            r3 = 5
            if (r7 == r3) goto L68
        L66:
            r3 = 0
            goto L8d
        L68:
            java.lang.String r7 = "ad cannot show message"
            goto L83
        L6b:
            java.lang.String r7 = "bright notification"
            e.p.a.a.a.c(r2, r7)
            r6.f(r0)
            goto L7c
        L74:
            java.lang.String r7 = "schedule notification"
            e.p.a.a.a.c(r2, r7)
            r6.e(r0)
        L7c:
            r1 = 1
            goto L66
        L7e:
            java.lang.String r7 = "notification on time ,show message"
            goto L89
        L81:
            java.lang.String r7 = "expire notification, don't show message"
        L83:
            e.p.a.a.a.c(r2, r7)
            goto L66
        L87:
            java.lang.String r7 = "schedule send message off, send message directly"
        L89:
            e.p.a.a.a.c(r2, r7)
            r1 = 1
        L8d:
            boolean r7 = r6.g(r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "can send message "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            e.p.a.a.a.c(r2, r4)
            if (r1 == 0) goto Lba
            if (r3 == 0) goto Lba
            if (r7 == 0) goto Lba
            com.meizu.cloud.pushsdk.notification.c r7 = r6.a(r0)
            r6.a(r0, r7)
            r6.c(r0)
            java.lang.String r7 = "send message end "
            e.p.a.a.a.c(r2, r7)
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.handler.a.a.b(android.content.Intent):boolean");
    }

    public com.meizu.cloud.pushsdk.handler.a c() {
        return this.a;
    }

    public abstract T c(Intent intent);

    public void c(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.model.a a = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a != null) {
            e.p.a.a.a.c("AbstractMessageHandler", "delete notifyKey " + a.b() + " notifyId " + a.a());
            if (TextUtils.isEmpty(a.b())) {
                com.meizu.cloud.pushsdk.notification.c.b.c(d(), messageV3.getUploadDataPackageName(), a.a());
            } else {
                com.meizu.cloud.pushsdk.notification.c.b.a(d(), messageV3.getUploadDataPackageName(), a.b());
            }
        }
    }

    public void c(T t) {
    }

    public int d(T t) {
        return 0;
    }

    public Context d() {
        return this.b;
    }

    public String d(Intent intent) {
        String stringExtra = intent != null ? intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY) : null;
        if (TextUtils.isEmpty(stringExtra)) {
            String a = com.meizu.cloud.pushsdk.b.c.a(d());
            e.p.a.a.a.f("AbstractMessageHandler", "force get deviceId " + a);
            return a;
        }
        return stringExtra;
    }

    public String e(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID);
    }

    public void e(T t) {
    }

    public String f(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
    }

    public void f(T t) {
    }

    public String g(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SERVICE_DEFAULT_PACKAGE_NAME);
        return TextUtils.isEmpty(stringExtra) ? d().getPackageName() : stringExtra;
    }

    public boolean g(T t) {
        return true;
    }

    public String h(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_TIMES_TAMP);
        e.p.a.a.a.c("AbstractMessageHandler", "receive push timestamp from pushservice " + stringExtra);
        return TextUtils.isEmpty(stringExtra) ? String.valueOf(System.currentTimeMillis() / 1000) : stringExtra;
    }

    public boolean i(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(PushConstants.MZ_PUSH_WHITE_LIST, false);
        e.p.a.a.a.c("AbstractMessageHandler", "receive push whiteList from pushservice " + booleanExtra);
        return booleanExtra;
    }

    public long j(Intent intent) {
        long longExtra = intent.getLongExtra(PushConstants.MZ_PUSH_DELAYED_REPORT_MILLIS, 0L);
        e.p.a.a.a.c("AbstractMessageHandler", "receive push delayedReportMillis from pushservice " + longExtra);
        return longExtra;
    }

    public String k(Intent intent) {
        return intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD);
    }
}
