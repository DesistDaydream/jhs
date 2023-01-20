package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.di;
import com.xiaomi.push.dt;
import com.xiaomi.push.dy;
import com.xiaomi.push.em;
import com.xiaomi.push.eo;
import com.xiaomi.push.eq;
import com.xiaomi.push.ex;
import com.xiaomi.push.fb;
import com.xiaomi.push.fc;
import com.xiaomi.push.fe;
import com.xiaomi.push.fh;
import com.xiaomi.push.fi;
import com.xiaomi.push.fn;
import com.xiaomi.push.fs;
import com.xiaomi.push.ft;
import com.xiaomi.push.gg;
import com.xiaomi.push.gi;
import com.xiaomi.push.gk;
import com.xiaomi.push.gn;
import com.xiaomi.push.gq;
import com.xiaomi.push.gv;
import com.xiaomi.push.hn;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.ib;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.jc;
import com.xiaomi.push.jg;
import com.xiaomi.push.jl;
import com.xiaomi.push.jm;
import com.xiaomi.push.m;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.cl;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class XMPushService extends Service implements fe {

    /* renamed from: k */
    private static boolean f9037k = false;

    /* renamed from: d */
    private fc f9039d;

    /* renamed from: e */
    private at f9040e;

    /* renamed from: f */
    private String f9041f;

    /* renamed from: g */
    private f f9042g;

    /* renamed from: h */
    private t f9043h;

    /* renamed from: i */
    private k f9044i;

    /* renamed from: j */
    private a f9045j;

    /* renamed from: l */
    private r f9046l;
    private ex p;
    private fb q;
    private cf r;
    private ContentObserver x;

    /* renamed from: c */
    private boolean f9038c = false;

    /* renamed from: m */
    private int f9047m = 0;
    private int n = 0;
    private long o = 0;
    public Class a = XMJobService.class;
    private ah s = null;
    private cl t = null;
    public Messenger b = null;
    private Collection<com.xiaomi.push.service.t> u = Collections.synchronizedCollection(new ArrayList());
    private ArrayList<n> v = new ArrayList<>();
    private fh w = new bm(this);

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        private final Object b;

        private a() {
            XMPushService.this = r1;
            this.b = new Object();
        }

        public /* synthetic */ a(XMPushService xMPushService, bm bmVar) {
            this();
        }

        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.a.a.a.c.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.b) {
                try {
                    this.b.notifyAll();
                } catch (Exception e2) {
                    com.xiaomi.a.a.a.c.a("[Alarm] notify lock. " + e2);
                }
            }
        }

        private void a(long j2) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.a.a.a.c.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.b) {
                try {
                    this.b.wait(j2);
                } catch (InterruptedException e2) {
                    com.xiaomi.a.a.a.c.a("[Alarm] interrupt from waiting state. " + e2);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            com.xiaomi.a.a.a.c.c("[Alarm] heartbeat alarm has been triggered.");
            if (!an.p.equals(intent.getAction())) {
                com.xiaomi.a.a.a.c.a("[Alarm] cancel the old ping timer");
                dy.a();
            } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                com.xiaomi.a.a.a.c.c("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    com.xiaomi.push.service.a.a(context).a(intent2);
                    a(3000L);
                    com.xiaomi.a.a.a.c.a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends j {
        public aj.b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(aj.b bVar) {
            super(9);
            XMPushService.this = r1;
            this.a = null;
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            String str;
            try {
                if (!XMPushService.this.f()) {
                    com.xiaomi.a.a.a.c.d("trying bind while the connection is not created, quit!");
                    return;
                }
                aj a = aj.a();
                aj.b bVar = this.a;
                aj.b b = a.b(bVar.f9080h, bVar.b);
                if (b == null) {
                    str = "ignore bind because the channel " + this.a.f9080h + " is removed ";
                } else if (b.f9085m == aj.c.unbind) {
                    b.a(aj.c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.this.q.a(b);
                    eo.a(XMPushService.this, b);
                    return;
                } else {
                    str = "trying duplicate bind, ingore! " + b.f9085m;
                }
                com.xiaomi.a.a.a.c.a(str);
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.d("Meet error when trying to bind. " + e2);
                XMPushService.this.a(10, e2);
            } catch (Throwable unused) {
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String b() {
            return "bind the client. " + this.a.f9080h;
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends j {
        private final aj.b a;

        public c(aj.b bVar) {
            super(12);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            this.a.a(aj.c.unbind, 1, 21, (String) null, (String) null);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String b() {
            return "bind time out. chid=" + this.a.f9080h;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return TextUtils.equals(((c) obj).a.f9080h, this.a.f9080h);
            }
            return false;
        }

        public int hashCode() {
            return this.a.f9080h.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends j {
        private eq b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(eq eqVar) {
            super(8);
            XMPushService.this = r1;
            this.b = null;
            this.b = eqVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            com.xiaomi.push.service.q qVar = this.b.f8538c;
            if (qVar != null) {
                qVar.f9191g = System.currentTimeMillis();
            }
            XMPushService.this.s.a(this.b);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String b() {
            return "receive a message.";
        }

        public eq c() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e() {
            super(1);
            XMPushService.this = r1;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            if (XMPushService.this.b()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.t();
                    return;
                }
            }
            com.xiaomi.a.a.a.c.a("should not connect. quit the job.");
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String b() {
            return "do reconnect..";
        }
    }

    /* loaded from: classes3.dex */
    public class f extends BroadcastReceiver {
        public f() {
            XMPushService.this = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.a.a.a.c.a("network changed, " + jc.a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends j {
        public int a;
        public Exception b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i2, Exception exc) {
            super(2);
            XMPushService.this = r1;
            this.a = i2;
            this.b = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            XMPushService.this.a(this.a, this.b);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String b() {
            return "disconnect the connection.";
        }
    }

    /* loaded from: classes3.dex */
    public class h extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h() {
            super(65535);
            XMPushService.this = r1;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            XMPushService.this.n();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String b() {
            return "Init Job";
        }
    }

    /* loaded from: classes3.dex */
    public class i extends j {
        private Intent b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Intent intent) {
            super(15);
            XMPushService.this = r1;
            this.b = null;
            this.b = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            XMPushService.this.d(this.b);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String b() {
            return "Handle intent action = " + this.b.getAction();
        }

        public Intent c() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class j extends cl.b {
        public j(int i2) {
            super(i2);
        }

        public abstract void a();

        public abstract String b();

        @Override // java.lang.Runnable
        public void run() {
            int i2 = this.f9154f;
            if (i2 != 4 && i2 != 8) {
                com.xiaomi.a.a.a.c.a(com.xiaomi.a.a.a.b.a, b());
            }
            a();
        }
    }

    /* loaded from: classes3.dex */
    public class k extends BroadcastReceiver {
        public k() {
            XMPushService.this = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.a.a.a.c.a("[HB] hold short heartbeat, " + jc.a(intent));
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: classes3.dex */
    public class l extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l() {
            super(5);
            XMPushService.this = r1;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            XMPushService.this.t.b();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String b() {
            return "ask the job queue to quit";
        }
    }

    /* loaded from: classes3.dex */
    public class m extends j {
        private ft b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ft ftVar) {
            super(8);
            XMPushService.this = r1;
            this.b = null;
            this.b = ftVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            XMPushService.this.s.a(this.b);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String b() {
            return "receive a message.";
        }
    }

    /* loaded from: classes3.dex */
    public interface n {
        void a();
    }

    /* loaded from: classes3.dex */
    public class o extends j {
        public boolean a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(boolean z) {
            super(4);
            XMPushService.this = r1;
            this.a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            if (XMPushService.this.f()) {
                try {
                    if (!this.a) {
                        eo.a();
                    }
                    XMPushService.this.q.b(this.a);
                } catch (fn e2) {
                    com.xiaomi.a.a.a.c.a(e2);
                    XMPushService.this.a(10, e2);
                }
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String b() {
            return "send ping..";
        }
    }

    /* loaded from: classes3.dex */
    public class p extends j {
        public aj.b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(aj.b bVar) {
            super(4);
            XMPushService.this = r1;
            this.a = null;
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            try {
                this.a.a(aj.c.unbind, 1, 16, (String) null, (String) null);
                fb fbVar = XMPushService.this.q;
                aj.b bVar = this.a;
                fbVar.a(bVar.f9080h, bVar.b);
                XMPushService xMPushService = XMPushService.this;
                xMPushService.a(new b(this.a), 300L);
            } catch (fn e2) {
                com.xiaomi.a.a.a.c.a(e2);
                XMPushService.this.a(10, e2);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String b() {
            return "rebind the client. " + this.a.f9080h;
        }
    }

    /* loaded from: classes3.dex */
    public class q extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q() {
            super(3);
            XMPushService.this = r1;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.b()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.t();
                }
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String b() {
            return "reset the connection.";
        }
    }

    /* loaded from: classes3.dex */
    public class r extends BroadcastReceiver {
        public r() {
            XMPushService.this = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: classes3.dex */
    public class s extends j {
        public aj.b a;
        public int b;

        /* renamed from: c */
        public String f9049c;

        /* renamed from: d */
        public String f9050d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(aj.b bVar, int i2, String str, String str2) {
            super(9);
            XMPushService.this = r1;
            this.a = null;
            this.a = bVar;
            this.b = i2;
            this.f9049c = str;
            this.f9050d = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            if (this.a.f9085m != aj.c.unbind && XMPushService.this.q != null) {
                try {
                    fb fbVar = XMPushService.this.q;
                    aj.b bVar = this.a;
                    fbVar.a(bVar.f9080h, bVar.b);
                } catch (fn e2) {
                    com.xiaomi.a.a.a.c.a(e2);
                    XMPushService.this.a(10, e2);
                }
            }
            this.a.a(aj.c.unbind, this.b, 0, this.f9050d, this.f9049c);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String b() {
            return "unbind the channel. " + this.a.f9080h;
        }
    }

    /* loaded from: classes3.dex */
    public class t extends BroadcastReceiver {
        public t() {
            XMPushService.this = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f9038c) {
                XMPushService.this.f9038c = true;
            }
            com.xiaomi.a.a.a.c.a("[HB] wifi changed, " + jc.a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    private ft a(ft ftVar, String str, String str2) {
        StringBuilder sb;
        String str3;
        aj a2 = aj.a();
        List<String> b2 = a2.b(str);
        if (b2.isEmpty()) {
            sb = new StringBuilder();
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            ftVar.o(str);
            str = ftVar.l();
            if (TextUtils.isEmpty(str)) {
                str = b2.get(0);
                ftVar.l(str);
            }
            aj.b b3 = a2.b(str, ftVar.n());
            if (!f()) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (b3 != null && b3.f9085m == aj.c.binded) {
                if (TextUtils.equals(str2, b3.f9082j)) {
                    return ftVar;
                }
                sb = new StringBuilder();
                sb.append("invalid session. ");
                sb.append(str2);
                com.xiaomi.a.a.a.c.a(sb.toString());
                return null;
            } else {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            }
        }
        sb.append(str3);
        sb.append(str);
        com.xiaomi.a.a.a.c.a(sb.toString());
        return null;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.a.a.a.c.a(e2);
            }
        }
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        ck.a(getApplicationContext()).a(extras.getString("digest"));
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        hq hqVar = new hq();
        try {
            ib.a(hqVar, byteArrayExtra);
            com.xiaomi.push.m.a(getApplicationContext()).a((m.a) new ac(hqVar, new WeakReference(this), booleanExtra), i2);
        } catch (ih unused) {
            com.xiaomi.a.a.a.c.d("aw_ping : send help app ping  error");
        }
    }

    private void a(com.xiaomi.push.service.b bVar) {
        String str;
        String str2;
        if (bVar == null || !TextUtils.isEmpty(bVar.b()) || TextUtils.isEmpty(bVar.a())) {
            str = "no need to check country code";
        } else {
            String l2 = "com.xiaomi.xmsf".equals(getPackageName()) ? l() : jc.f();
            if (!TextUtils.isEmpty(l2)) {
                String name = jc.c(l2).name();
                if (TextUtils.equals(name, bVar.a())) {
                    bVar.b(l2);
                    str2 = "update country code";
                } else {
                    str2 = "not update country code, because not equals " + name;
                }
                com.xiaomi.a.a.a.c.a(str2);
                return;
            }
            str = "check no country code";
        }
        com.xiaomi.a.a.a.c.b(str);
    }

    private static void a(String str) {
        String str2;
        String str3;
        if (jg.China.name().equals(str)) {
            com.xiaomi.push.by.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            com.xiaomi.push.by.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            com.xiaomi.push.by.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            com.xiaomi.push.by.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            com.xiaomi.push.by.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            str2 = "resolver.msg.xiaomi.net";
            com.xiaomi.push.by.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            str3 = "111.202.1.252:443";
        } else {
            com.xiaomi.push.by.a("app.chat.global.xiaomi.net", "app.chat.global.xiaomi.net");
            str2 = "resolver.msg.global.xiaomi.net";
            com.xiaomi.push.by.a("resolver.msg.global.xiaomi.net", "161.117.97.14:443");
            str3 = "161.117.180.178:443";
        }
        com.xiaomi.push.by.a(str2, str3);
    }

    private void a(String str, int i2) {
        Collection<aj.b> c2 = aj.a().c(str);
        if (c2 != null) {
            for (aj.b bVar : c2) {
                if (bVar != null) {
                    a(new s(bVar, i2, null, null));
                }
            }
        }
        aj.a().a(str);
    }

    public boolean a(Context context) {
        try {
            com.xiaomi.push.s.a();
            for (int i2 = 100; i2 > 0; i2--) {
                if (com.xiaomi.push.al.d(context)) {
                    com.xiaomi.a.a.a.c.a("network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100L);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    private boolean a(String str, Intent intent) {
        aj.b b2 = aj.a().b(str, intent.getStringExtra(an.q));
        boolean z = false;
        if (b2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(an.F);
        String stringExtra2 = intent.getStringExtra(an.x);
        if (!TextUtils.isEmpty(b2.f9082j) && !TextUtils.equals(stringExtra, b2.f9082j)) {
            com.xiaomi.a.a.a.c.a("session changed. old session=" + b2.f9082j + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(b2.f9081i)) {
            return z;
        }
        com.xiaomi.a.a.a.c.a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.aq.a(stringExtra2));
        return true;
    }

    private aj.b b(String str, Intent intent) {
        aj.b b2 = aj.a().b(str, intent.getStringExtra(an.q));
        if (b2 == null) {
            b2 = new aj.b(this);
        }
        b2.f9080h = intent.getStringExtra(an.t);
        b2.b = intent.getStringExtra(an.q);
        b2.f9075c = intent.getStringExtra(an.v);
        b2.a = intent.getStringExtra(an.B);
        b2.f9078f = intent.getStringExtra(an.z);
        b2.f9079g = intent.getStringExtra(an.A);
        b2.f9077e = intent.getBooleanExtra(an.y, false);
        b2.f9081i = intent.getStringExtra(an.x);
        b2.f9082j = intent.getStringExtra(an.F);
        b2.f9076d = intent.getStringExtra(an.w);
        b2.f9083k = this.r;
        b2.a((Messenger) intent.getParcelableExtra(an.J));
        b2.f9084l = getApplicationContext();
        aj.a().a(b2);
        return b2;
    }

    private void b(Intent intent) {
        long j2;
        String str;
        eq eqVar;
        String stringExtra = intent.getStringExtra(an.B);
        String stringExtra2 = intent.getStringExtra(an.F);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        aj a2 = aj.a();
        if (bundleExtra != null) {
            fs fsVar = (fs) a(new fs(bundleExtra), stringExtra, stringExtra2);
            if (fsVar == null) {
                return;
            }
            eqVar = eq.a(fsVar, a2.b(fsVar.l(), fsVar.n()).f9081i);
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(an.q));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(an.r);
                String stringExtra4 = intent.getStringExtra(an.s);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                aj.b b2 = a2.b(stringExtra5, String.valueOf(j2));
                if (b2 != null) {
                    eq eqVar2 = new eq();
                    if ("10".equals(stringExtra5)) {
                        eqVar2.b(Integer.parseInt("10"));
                        eqVar2.f8538c.f9187c = intent.getBooleanExtra("screen_on", true);
                        eqVar2.f8538c.f9188d = intent.getBooleanExtra("wifi", true);
                        str = stringExtra3;
                        eqVar2.f8538c.f9189e = intent.getLongExtra("rx_msg", -1L);
                        eqVar2.f8538c.f9190f = intent.getLongExtra("enqueue", -1L);
                        eqVar2.f8538c.b = intent.getIntExtra("num", -1);
                        eqVar2.f8538c.f9191g = intent.getLongExtra("run", -1L);
                    } else {
                        str = stringExtra3;
                    }
                    try {
                        eqVar2.a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    eqVar2.a("SECMSG", (String) null);
                    eqVar2.a(j2, TextUtils.isEmpty(str) ? "xiaomi.com" : str, stringExtra4);
                    eqVar2.a(intent.getStringExtra("ext_pkt_id"));
                    eqVar2.a(byteArrayExtra, b2.f9081i);
                    com.xiaomi.a.a.a.c.a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    eqVar = eqVar2;
                }
            }
            eqVar = null;
        }
        if (eqVar != null) {
            c(new aw(this, eqVar));
        }
    }

    private void b(boolean z) {
        this.o = SystemClock.elapsedRealtime();
        if (f()) {
            if (com.xiaomi.push.al.c(this)) {
                c(new o(z));
                return;
            }
            c(new g(17, null));
        }
        a(true);
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(an.B);
        String stringExtra2 = intent.getStringExtra(an.F);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        fs[] fsVarArr = new fs[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            fsVarArr[i2] = new fs((Bundle) parcelableArrayExtra[i2]);
            fsVarArr[i2] = (fs) a(fsVarArr[i2], stringExtra, stringExtra2);
            if (fsVarArr[i2] == null) {
                return;
            }
        }
        aj a2 = aj.a();
        eq[] eqVarArr = new eq[length];
        for (int i3 = 0; i3 < length; i3++) {
            fs fsVar = fsVarArr[i3];
            eqVarArr[i3] = eq.a(fsVar, a2.b(fsVar.l(), fsVar.n()).f9081i);
        }
        c(new bd(this, eqVarArr));
    }

    private void c(j jVar) {
        this.t.a(jVar);
    }

    private void c(boolean z) {
        try {
            if (jl.c()) {
                if (!z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                    return;
                }
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (com.xiaomi.push.service.t tVar : (com.xiaomi.push.service.t[]) this.u.toArray(new com.xiaomi.push.service.t[0])) {
                    tVar.a();
                }
            }
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:1018:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:1024:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:1238:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(android.content.Intent r12) {
        /*
            Method dump skipped, instructions count: 2306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.d(android.content.Intent):void");
    }

    private void e(Intent intent) {
        int i2;
        try {
            di.a(getApplicationContext()).a(new ap());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra == null) {
                return;
            }
            hq hqVar = new hq();
            ib.a(hqVar, byteArrayExtra);
            String f2 = hqVar.f();
            Map<String, String> k2 = hqVar.k();
            if (k2 != null) {
                String str = k2.get("extra_help_aw_info");
                String str2 = k2.get("extra_aw_app_online_cmd");
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    i2 = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    i2 = 0;
                }
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(f2) || TextUtils.isEmpty(str)) {
                    return;
                }
                di.a(getApplicationContext()).a(this, str, i2, stringExtra, f2);
            }
        } catch (ih e2) {
            com.xiaomi.a.a.a.c.d("aw_logic: translate fail. " + e2.getMessage());
        }
    }

    public static boolean j() {
        return f9037k;
    }

    private int[] k() {
        String[] split;
        String a2 = ad.a(getApplicationContext()).a(gv.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(a2) && (split = a2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                if (iArr[0] >= 0 && iArr[0] <= 23 && iArr[1] >= 0 && iArr[1] <= 23) {
                    if (iArr[0] != iArr[1]) {
                        return iArr;
                    }
                }
            } catch (NumberFormatException e2) {
                com.xiaomi.a.a.a.c.d("parse falldown time range failure: " + e2);
            }
        }
        return null;
    }

    private String l() {
        String a2 = jc.a("ro.miui.region");
        return TextUtils.isEmpty(a2) ? jc.a("ro.product.locale.region") : a2;
    }

    private String m() {
        String f2;
        com.xiaomi.push.s.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        String str = null;
        int i2 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            aq a2 = aq.a(this);
            String str2 = null;
            while (true) {
                if (!TextUtils.isEmpty(str2) && a2.b() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = l();
                }
                try {
                    synchronized (obj) {
                        if (i2 < 30) {
                            obj.wait(1000L);
                        } else {
                            obj.wait(JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS);
                        }
                    }
                } catch (InterruptedException unused) {
                }
                i2++;
            }
            f2 = l();
        } else {
            f2 = jc.f();
        }
        if (!TextUtils.isEmpty(f2)) {
            com.xiaomi.push.service.b.a(getApplicationContext()).b(f2);
            str = jc.c(f2).name();
        }
        com.xiaomi.a.a.a.c.a("wait region :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " , count = " + i2);
        return str;
    }

    public void n() {
        String str;
        com.xiaomi.push.service.b a2 = com.xiaomi.push.service.b.a(getApplicationContext());
        String a3 = a2.a();
        com.xiaomi.a.a.a.c.a("region of cache is " + a3);
        if (TextUtils.isEmpty(a3)) {
            a3 = m();
        } else {
            a(a2);
        }
        if (TextUtils.isEmpty(a3)) {
            this.f9041f = jg.China.name();
        } else {
            this.f9041f = a3;
            a2.a(a3);
            if (jg.Global.name().equals(this.f9041f)) {
                str = "app.chat.global.xiaomi.net";
            } else if (jg.Europe.name().equals(this.f9041f)) {
                str = "fr.app.chat.global.xiaomi.net";
            } else if (jg.Russia.name().equals(this.f9041f)) {
                str = "ru.app.chat.global.xiaomi.net";
            } else if (jg.India.name().equals(this.f9041f)) {
                str = "idmb.app.chat.global.xiaomi.net";
            }
            fc.a(str);
        }
        if (jg.China.name().equals(this.f9041f)) {
            fc.a("cn.app.chat.xiaomi.net");
        }
        a(this.f9041f);
        if (r()) {
            bw bwVar = new bw(this, 11);
            a(bwVar);
            cq.a(new bx(this, bwVar));
        }
        try {
            if (jl.c()) {
                this.r.a(this);
            }
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
        }
    }

    private void o() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
            networkInfo = null;
        }
        ck.a(getApplicationContext()).a(networkInfo);
        if (networkInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append("[type: " + networkInfo.getTypeName() + "[" + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + MqttTopic.TOPIC_LEVEL_SEPARATOR + networkInfo.getDetailedState());
            com.xiaomi.a.a.a.c.a(sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.a.a.a.c.a("network changed, no active network");
        }
        if (em.b() != null) {
            em.b().b();
        }
        gi.a(this);
        this.p.o();
        if (com.xiaomi.push.al.c(this)) {
            if (f() && p()) {
                b(false);
            }
            if (!f() && !g()) {
                this.t.b(1);
                a(new e());
            }
            com.xiaomi.push.cj.a(this).a();
        } else {
            a(new g(2, null));
        }
        s();
    }

    private boolean p() {
        if (SystemClock.elapsedRealtime() - this.o < JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS) {
            return false;
        }
        return com.xiaomi.push.al.e(this);
    }

    public boolean q() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private boolean r() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !cr.a(this).b(getPackageName());
    }

    public void s() {
        if (!b()) {
            dy.a();
        } else if (dy.b()) {
        } else {
            dy.a(true);
        }
    }

    public void t() {
        String str;
        fb fbVar = this.q;
        if (fbVar == null || !fbVar.j()) {
            fb fbVar2 = this.q;
            if (fbVar2 == null || !fbVar2.k()) {
                this.f9039d.b(com.xiaomi.push.al.l(this));
                u();
                if (this.q == null) {
                    aj.a().a(this);
                    c(false);
                    return;
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        com.xiaomi.a.a.a.c.d(str);
    }

    private void u() {
        try {
            this.p.a(this.w, new bp(this));
            this.p.q();
            this.q = this.p;
        } catch (fn e2) {
            com.xiaomi.a.a.a.c.a("fail to create Slim connection", e2);
            this.p.b(3, e2);
        }
    }

    private boolean v() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && w() && !ii.m(this) && !ii.l(getApplicationContext());
    }

    private boolean w() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.f9047m;
        int i3 = this.n;
        if (i2 > i3) {
            if (intValue >= i2 || intValue < i3) {
                return true;
            }
        } else if (i2 < i3 && intValue >= i2 && intValue < i3) {
            return true;
        }
        return false;
    }

    private boolean x() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ad.a(this).a(gv.ForegroundServiceSwitch.a(), false);
    }

    private void y() {
    }

    private void z() {
        synchronized (this.v) {
            this.v.clear();
        }
    }

    public void a() {
        if (SystemClock.elapsedRealtime() - this.o >= fi.b() && com.xiaomi.push.al.e(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.t.b(i2);
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        fb fbVar = this.q;
        sb.append(fbVar == null ? null : Integer.valueOf(fbVar.hashCode()));
        com.xiaomi.a.a.a.c.a(sb.toString());
        fb fbVar2 = this.q;
        if (fbVar2 != null) {
            fbVar2.b(i2, exc);
            this.q = null;
        }
        a(7);
        a(4);
        aj.a().a(this, i2);
    }

    public void a(eq eqVar) {
        fb fbVar = this.q;
        if (fbVar == null) {
            throw new fn("try send msg while connection is null.");
        }
        fbVar.b(eqVar);
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar) {
        com.xiaomi.a.a.a.c.c("begin to connect...");
        em.b().a(fbVar);
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar, int i2, Exception exc) {
        em.b().a(fbVar, i2, exc);
        if (v()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar, Exception exc) {
        em.b().a(fbVar, exc);
        c(false);
        if (v()) {
            return;
        }
        a(false);
    }

    public void a(j jVar) {
        a(jVar, 0L);
    }

    public void a(j jVar, long j2) {
        try {
            this.t.a(jVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.a.a.a.c.a("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(n nVar) {
        synchronized (this.v) {
            this.v.add(nVar);
        }
    }

    public void a(aj.b bVar) {
        if (bVar != null) {
            long b2 = bVar.b();
            com.xiaomi.a.a.a.c.a("schedule rebind job in " + (b2 / 1000));
            a(new b(bVar), b2);
        }
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        aj.b b2 = aj.a().b(str, str2);
        if (b2 != null) {
            a(new s(b2, i2, str4, str3));
        }
        aj.a().a(str, str2);
    }

    public void a(String str, byte[] bArr, boolean z) {
        Collection<aj.b> c2 = aj.a().c("5");
        if (c2.isEmpty()) {
            if (!z) {
                return;
            }
        } else if (c2.iterator().next().f9085m == aj.c.binded) {
            a(new bn(this, 4, str, bArr));
            return;
        } else if (!z) {
            return;
        }
        ct.b(str, bArr);
    }

    public void a(boolean z) {
        this.f9040e.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            ct.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.a.a.a.c.a("register request without payload");
            return;
        }
        hn hnVar = new hn();
        try {
            ib.a(hnVar, bArr);
            if (hnVar.a == gq.Registration) {
                hr hrVar = new hr();
                try {
                    ib.a(hrVar, hnVar.f());
                    a(new cs(this, hnVar.j(), hrVar.e(), hrVar.i(), bArr));
                    dt.a(getApplicationContext()).a(hnVar.j(), "E100003", hrVar.c(), 6002, null);
                } catch (ih e2) {
                    com.xiaomi.a.a.a.c.d("app register error. " + e2);
                    ct.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                ct.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.a.a.a.c.a("register request with invalid payload");
            }
        } catch (ih e3) {
            com.xiaomi.a.a.a.c.d("app register fail. " + e3);
            ct.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(eq[] eqVarArr) {
        fb fbVar = this.q;
        if (fbVar == null) {
            throw new fn("try send msg while connection is null.");
        }
        fbVar.a(eqVarArr);
    }

    @Override // com.xiaomi.push.fe
    public void b(fb fbVar) {
        em.b().b(fbVar);
        c(true);
        this.f9040e.a();
        if (!dy.b() && !v()) {
            com.xiaomi.a.a.a.c.a("reconnection successful, reactivate alarm.");
            dy.a(true);
        }
        Iterator<aj.b> it = aj.a().b().iterator();
        while (it.hasNext()) {
            a(new b(it.next()));
        }
        if (this.f9038c || !jc.a(getApplicationContext())) {
            return;
        }
        com.xiaomi.push.m.a(getApplicationContext()).a(new bq(this));
    }

    public void b(j jVar) {
        this.t.a(jVar.f9154f, jVar);
    }

    public boolean b() {
        boolean c2 = com.xiaomi.push.al.c(this);
        boolean z = aj.a().c() > 0;
        boolean z2 = !c();
        boolean r2 = r();
        boolean z3 = !q();
        boolean z4 = c2 && z && z2 && r2 && z3;
        if (!z4) {
            com.xiaomi.a.a.a.c.f(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(c2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(r2), Boolean.valueOf(z3)));
        }
        return z4;
    }

    public boolean b(int i2) {
        return this.t.a(i2);
    }

    public boolean c() {
        try {
            Class<?> a2 = jl.a(this, "miui.os.Build");
            Field field = a2.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = a2.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = a2.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public cf d() {
        return new cf();
    }

    public cf e() {
        return this.r;
    }

    public boolean f() {
        fb fbVar = this.q;
        return fbVar != null && fbVar.k();
    }

    public boolean g() {
        fb fbVar = this.q;
        return fbVar != null && fbVar.j();
    }

    public fb h() {
        return this.q;
    }

    public void i() {
        ck.a(getApplicationContext()).d();
        Iterator it = new ArrayList(this.v).iterator();
        while (it.hasNext()) {
            ((n) it.next()).a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.b.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] split;
        super.onCreate();
        com.xiaomi.a.a.a.c.a(getApplicationContext());
        jl.a(this);
        cp a2 = cq.a(this);
        if (a2 != null) {
            com.xiaomi.push.f.a(a2.f9171g);
        }
        if (jc.a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f9045j = new a(this, null);
            registerReceiver(this.f9045j, new IntentFilter(an.p), null, handler);
            f9037k = true;
            handler.post(new br(this));
        }
        this.b = new Messenger(new bs(this));
        ao.a(this);
        bt btVar = new bt(this, null, 5222, "xiaomi.com", null);
        this.f9039d = btVar;
        btVar.a(true);
        this.p = new ex(this, this.f9039d);
        this.r = d();
        dy.a(this);
        this.p.a(this);
        this.s = new ah(this);
        this.f9040e = new at(this);
        new cg().a();
        em.a().a(this);
        this.t = new cl("Connection Controller Thread");
        aj a3 = aj.a();
        a3.e();
        a3.a(new bu(this));
        if (x()) {
            y();
        }
        gn.a(this).a(new cn(this), "UPLOADER_PUSH_CHANNEL");
        a(new gk(this));
        a(new bk(this));
        if (jc.a(this)) {
            a(new ai());
        }
        a(new h());
        this.u.add(ba.a(this));
        if (r()) {
            this.f9042g = new f();
            registerReceiver(this.f9042g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (jc.a(getApplicationContext())) {
            this.f9043h = new t();
            registerReceiver(this.f9043h, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null);
            k kVar = new k();
            this.f9044i = kVar;
            registerReceiver(kVar, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null);
        }
        ck.a(getApplicationContext()).a();
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.x = new bv(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.x);
                } catch (Throwable th) {
                    com.xiaomi.a.a.a.c.d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] k2 = k();
            if (k2 != null) {
                this.f9046l = new r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f9046l, intentFilter);
                this.f9047m = k2[0];
                this.n = k2[1];
                com.xiaomi.a.a.a.c.a("falldown initialized: " + this.f9047m + Constants.ACCEPT_TIME_SEPARATOR_SP + this.n);
            }
        }
        String str = "";
        if (a2 != null) {
            try {
                if (!TextUtils.isEmpty(a2.a) && (split = a2.a.split(TIMMentionEditText.TIM_MENTION_TAG)) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (Exception unused) {
            }
        }
        com.xiaomi.push.ch.a(this);
        com.xiaomi.a.a.a.c.f("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + gg.b(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        f fVar = this.f9042g;
        if (fVar != null) {
            a(fVar);
            this.f9042g = null;
        }
        t tVar = this.f9043h;
        if (tVar != null) {
            a(tVar);
            this.f9043h = null;
        }
        k kVar = this.f9044i;
        if (kVar != null) {
            a(kVar);
            this.f9044i = null;
        }
        r rVar = this.f9046l;
        if (rVar != null) {
            a(rVar);
            this.f9046l = null;
        }
        a aVar = this.f9045j;
        if (aVar != null) {
            a(aVar);
            this.f9045j = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.x != null) {
            try {
                getContentResolver().unregisterContentObserver(this.x);
            } catch (Throwable th) {
                com.xiaomi.a.a.a.c.d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.u.clear();
        this.t.c();
        a(new bo(this, 2));
        a(new l());
        aj.a().e();
        aj.a().a(this, 15);
        aj.a().d();
        this.p.b(this);
        ay.a().b();
        dy.a();
        z();
        super.onDestroy();
        com.xiaomi.a.a.a.c.a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        i iVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.a.a.a.c.d("onStart() with intent NULL");
        } else {
            com.xiaomi.a.a.a.c.a(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(an.t), intent.getStringExtra(an.B), intent.getStringExtra("mipush_app_package")));
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.t.d()) {
                    com.xiaomi.a.a.a.c.d("ERROR, the job controller is blocked.");
                    aj.a().a(this, 14);
                    stopSelf();
                } else {
                    iVar = new i(intent);
                    a(iVar);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                if ("10".equals(intent.getStringExtra("ext_chid"))) {
                    intent.putExtra("rx_msg", System.currentTimeMillis());
                    intent.putExtra("screen_on", jm.a(getApplicationContext()));
                    intent.putExtra("wifi", com.xiaomi.push.al.f(getApplicationContext()));
                }
                iVar = new i(intent);
                a(iVar);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            com.xiaomi.a.a.a.c.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return 1;
    }
}
