package com.vivo.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.heytap.mcssdk.constant.b;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.vivo.push.b.x;
import com.vivo.push.c.d;
import com.vivo.push.e;
import com.vivo.push.q;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.p;
import com.vivo.push.util.t;
import com.vivo.push.util.u;
import com.vivo.push.util.z;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public final class a extends q {

    /* renamed from: c */
    private static a f8149c;

    /* renamed from: e */
    private static final List<Integer> f8150e = Arrays.asList(3);

    /* renamed from: d */
    private String f8151d;

    /* renamed from: f */
    private String f8152f = "";

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f8149c == null) {
                f8149c = new a();
            }
            aVar = f8149c;
        }
        return aVar;
    }

    private boolean c(Intent intent) {
        if (Build.VERSION.SDK_INT < 18) {
            return true;
        }
        String c2 = z.c(this.a, "com.vivo.pushservice");
        p.d("CommandWorker", " 配置的验签参数 = ".concat(String.valueOf(c2)));
        if (TextUtils.equals(c2, "1")) {
            String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
            String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                try {
                    if (d.a(this.a).a().a("com.vivo.pushservice".getBytes("UTF-8"), u.a(stringExtra2), Base64.decode(stringExtra, 2))) {
                        p.d("CommandWorker", " RSA验签通过  ");
                        return true;
                    }
                } catch (Exception e2) {
                    p.a("CommandWorker", "checkIntentIsSecurity Exception: " + e2.getMessage());
                }
                p.d("CommandWorker", " RSA验签 不通过  ");
                return false;
            }
            p.a("CommandWorker", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
            return false;
        }
        return true;
    }

    private int d(Intent intent) {
        String stringExtra;
        if (!TextUtils.isEmpty(this.f8152f) && this.f8152f.contains("CommandService")) {
            if (!(intent != null && b(intent) && c(intent))) {
                p.a("CommandWorker", " !checkIntentIsSecurity(intent)");
                return 2151;
            }
        }
        String packageName = this.a.getPackageName();
        try {
            stringExtra = intent.getStringExtra("command_type");
        } catch (Exception e2) {
            p.a("CommandWorker", e2);
        }
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
            int intExtra = intent.getIntExtra(b.y, -1);
            if (intExtra < 0) {
                intExtra = intent.getIntExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD, -1);
            }
            if (f8150e.contains(Integer.valueOf(intExtra)) && t.c(this.a, packageName) && !t.c(this.a)) {
                p.a("CommandWorker", "METHOD_ON_MESSAGE is not support");
                return 2153;
            }
            String action = intent.getAction();
            if (TextUtils.isEmpty(this.f8151d)) {
                String a = a(this.a, packageName, action);
                this.f8151d = a;
                if (TextUtils.isEmpty(a)) {
                    p.d("CommandWorker", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                    intent.setPackage(packageName);
                    this.a.sendBroadcast(intent);
                    return 2152;
                }
            }
            return 0;
        }
        p.a("CommandWorker", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
        return 2151;
    }

    public final void b() {
        this.f8151d = null;
    }

    @Override // com.vivo.push.q
    public final void b(Message message) {
        Context context;
        Intent intent = (Intent) message.obj;
        if (intent != null && (context = this.a) != null) {
            String packageName = context.getPackageName();
            int d2 = d(intent);
            if (d2 > 0) {
                x xVar = new x(d2);
                HashMap<String, String> hashMap = new HashMap<>();
                if (intent != null) {
                    Bundle extras = intent.getExtras();
                    hashMap.put(b.f3335c, String.valueOf(extras != null ? extras.getLong("notify_id", 404000044642424832L) : 404000044642424832L));
                }
                String b = z.b(this.a, packageName);
                if (!TextUtils.isEmpty(b)) {
                    hashMap.put("remoteAppId", b);
                }
                xVar.a(hashMap);
                e.a().a(xVar);
                return;
            }
            try {
                Class<?> cls = Class.forName(this.f8151d);
                Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                Method method = cls.getMethod("onReceive", Context.class, Intent.class);
                intent.setClassName(packageName, this.f8151d);
                method.invoke(newInstance, ContextDelegate.getContext(this.a).getApplicationContext(), intent);
                return;
            } catch (Exception e2) {
                p.b("CommandWorker", "reflect e: ", e2);
                return;
            }
        }
        p.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.a);
    }

    public final void a(String str) {
        this.f8152f = str;
    }

    public final void a(Intent intent) {
        if (intent != null && this.a != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            a(obtain);
            return;
        }
        p.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.a);
    }

    private static String a(Context context, String str, String str2) {
        List<ResolveInfo> queryBroadcastReceivers;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || queryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return queryBroadcastReceivers.get(0).activityInfo.name;
        } catch (Exception e2) {
            p.a("CommandWorker", "error  " + e2.getMessage());
            return null;
        }
    }

    private boolean b(Intent intent) {
        String stringExtra = intent.getStringExtra("security_avoid_pull");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                String b = com.vivo.push.util.a.a(this.a).b(stringExtra);
                if ("com.vivo.pushservice".equals(b)) {
                    return true;
                }
                p.a("CommandWorker", "!decrypt.equals, so decrypt == ".concat(String.valueOf(b)));
                return false;
            } catch (Exception e2) {
                p.a("CommandWorker", "checkIntentIsSecurity Exception: " + e2.getMessage());
                return false;
            }
        }
        p.a("CommandWorker", "checkIntentIsSecurityTextUtils.isEmpty");
        return true;
    }
}
