package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.push.gq;
import com.xiaomi.push.gu;
import com.xiaomi.push.hd;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.bc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* loaded from: classes3.dex */
    public static class a {
        private static volatile a a;

        /* renamed from: a  reason: collision with other field name */
        private Context f5a;

        /* renamed from: a  reason: collision with other field name */
        private Boolean f7a;

        /* renamed from: a  reason: collision with other field name */
        private String f8a;

        /* renamed from: a  reason: collision with other field name */
        private C0296a f6a = new C0296a();

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<gu> f9a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0296a {

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f12a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f13a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<gu> f11a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f10a = new ab(this);

            public C0296a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f12a == null) {
                    this.f12a = this.f13a.scheduleAtFixedRate(this.f10a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                gu remove = this.f11a.remove(0);
                for (hq hqVar : bc.a(Arrays.asList(remove), a.this.f5a.getPackageName(), b.m74a(a.this.f5a).m75a(), 30720)) {
                    com.xiaomi.a.a.a.c.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.m());
                    ao.a(a.this.f5a).a((ao) hqVar, gq.Notification, true, (hd) null);
                }
            }

            public void a(gu guVar) {
                this.f13a.execute(new aa(this, guVar));
            }
        }

        public static a a() {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }

        private void a(gu guVar) {
            synchronized (this.f9a) {
                if (!this.f9a.contains(guVar)) {
                    this.f9a.add(guVar);
                    if (this.f9a.size() > 100) {
                        this.f9a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (ao.a(context).m67a()) {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                    if (packageInfo == null) {
                        return false;
                    }
                    return packageInfo.versionCode >= 108;
                } catch (Exception unused) {
                    return false;
                }
            }
            return true;
        }

        private boolean b(Context context) {
            return b.m74a(context).m75a() == null && !a(this.f5a);
        }

        private boolean b(gu guVar) {
            if (bc.a(guVar, false)) {
                return false;
            }
            if (!this.f7a.booleanValue()) {
                this.f6a.a(guVar);
                return true;
            }
            com.xiaomi.a.a.a.c.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + guVar.m());
            ao.a(this.f5a).a(guVar);
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m46a(Context context) {
            if (context == null) {
                com.xiaomi.a.a.a.c.a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f5a = context;
            this.f7a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.a.a.a.c.a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                return;
            }
            this.f8a = str;
            b(MiTinyDataClient.PENDING_REASON_CHANNEL);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m47a() {
            return this.f5a != null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a3, code lost:
            r0 = "MiTinyDataClient Pending " + r6.d() + " reason is " + com.xiaomi.mipush.sdk.MiTinyDataClient.PENDING_REASON_CHANNEL;
         */
        /* renamed from: a  reason: collision with other method in class */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized boolean m48a(com.xiaomi.push.gu r6) {
            /*
                Method dump skipped, instructions count: 274
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiTinyDataClient.a.m48a(com.xiaomi.push.gu):boolean");
        }

        public void b(String str) {
            com.xiaomi.a.a.a.c.c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f9a) {
                arrayList.addAll(this.f9a);
                this.f9a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m48a((gu) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.a.a.a.c.a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m46a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.a.a.a.c.a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, gu guVar) {
        com.xiaomi.a.a.a.c.c("MiTinyDataClient.upload " + guVar.m());
        if (!a.a().m47a()) {
            a.a().m46a(context);
        }
        return a.a().m48a(guVar);
    }

    public static boolean upload(Context context, String str, String str2, long j2, String str3) {
        gu guVar = new gu();
        guVar.d(str);
        guVar.c(str2);
        guVar.a(j2);
        guVar.b(str3);
        guVar.c(true);
        guVar.a("push_sdk_channel");
        return upload(context, guVar);
    }

    public static boolean upload(String str, String str2, long j2, String str3) {
        gu guVar = new gu();
        guVar.d(str);
        guVar.c(str2);
        guVar.a(j2);
        guVar.b(str3);
        return a.a().m48a(guVar);
    }
}
