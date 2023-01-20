package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class aj {
    private static aj a;
    private ConcurrentHashMap<String, HashMap<String, b>> b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private List<a> f9074c = new ArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes3.dex */
    public static class b {
        public String a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f9075c;

        /* renamed from: d  reason: collision with root package name */
        public String f9076d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9077e;

        /* renamed from: f  reason: collision with root package name */
        public String f9078f;

        /* renamed from: g  reason: collision with root package name */
        public String f9079g;

        /* renamed from: h  reason: collision with root package name */
        public String f9080h;

        /* renamed from: i  reason: collision with root package name */
        public String f9081i;

        /* renamed from: j  reason: collision with root package name */
        public String f9082j;

        /* renamed from: k  reason: collision with root package name */
        public cf f9083k;

        /* renamed from: l  reason: collision with root package name */
        public Context f9084l;
        public Messenger o;
        private XMPushService t;

        /* renamed from: m  reason: collision with root package name */
        public c f9085m = c.unbind;
        private int r = 0;
        private List<a> s = new ArrayList();
        public c n = null;
        private boolean u = false;
        private XMPushService.c v = new XMPushService.c(this);
        public IBinder.DeathRecipient p = null;
        public final C0298b q = new C0298b();

        /* loaded from: classes3.dex */
        public interface a {
            void a(c cVar, c cVar2, int i2);
        }

        /* renamed from: com.xiaomi.push.service.aj$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0298b extends XMPushService.j {
            public int a;
            public int b;

            /* renamed from: c  reason: collision with root package name */
            public String f9086c;

            /* renamed from: d  reason: collision with root package name */
            public String f9087d;

            public C0298b() {
                super(0);
            }

            public XMPushService.j a(int i2, int i3, String str, String str2) {
                this.a = i2;
                this.b = i3;
                this.f9087d = str2;
                this.f9086c = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public void a() {
                if (b.this.a(this.a, this.b, this.f9087d)) {
                    b.this.a(this.a, this.b, this.f9086c, this.f9087d);
                    return;
                }
                com.xiaomi.a.a.a.c.b(" ignore notify client :" + b.this.f9080h);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String b() {
                return "notify job";
            }
        }

        /* loaded from: classes3.dex */
        public class c implements IBinder.DeathRecipient {
            public final b a;
            public final Messenger b;

            public c(b bVar, Messenger messenger) {
                this.a = bVar;
                this.b = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.a.a.a.c.b("peer died, chid = " + this.a.f9080h);
                b.this.t.a(new al(this, 0), 0L);
                if ("9".equals(this.a.f9080h) && "com.xiaomi.xmsf".equals(b.this.t.getPackageName())) {
                    b.this.t.a(new am(this, 0), com.heytap.mcssdk.constant.a.f3314d);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.t = xMPushService;
            a(new ak(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR)) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, int i3, String str, String str2) {
            c cVar = this.f9085m;
            this.n = cVar;
            if (i2 == 2) {
                this.f9083k.a(this.f9084l, this, i3);
            } else if (i2 == 3) {
                this.f9083k.a(this.f9084l, this, str2, str);
            } else if (i2 == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.r++;
                } else if (z) {
                    this.r = 0;
                    if (this.o != null) {
                        try {
                            this.o.send(Message.obtain(null, 16, this.t.b));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f9083k.a(this.t, this, z, i3, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i2, int i3, String str) {
            boolean z;
            StringBuilder sb;
            String str2;
            c cVar = this.n;
            if (cVar == null || !(z = this.u)) {
                return true;
            }
            if (cVar == this.f9085m) {
                sb = new StringBuilder();
                str2 = " status recovered, don't notify client:";
            } else if (this.o != null && z) {
                com.xiaomi.a.a.a.c.b("Peer alive notify status to client:" + this.f9080h);
                return true;
            } else {
                sb = new StringBuilder();
                str2 = "peer died, ignore notify ";
            }
            sb.append(str2);
            sb.append(this.f9080h);
            com.xiaomi.a.a.a.c.b(sb.toString());
            return false;
        }

        private boolean b(int i2, int i3, String str) {
            if (i2 == 1) {
                return (this.f9085m == c.binded || !this.t.f() || i3 == 21 || (i3 == 7 && "wait".equals(str))) ? false : true;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return false;
                }
                return !"wait".equals(str);
            } else {
                return this.t.f();
            }
        }

        public String a(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        public void a() {
            try {
                Messenger messenger = this.o;
                if (messenger != null && this.p != null) {
                    messenger.getBinder().unlinkToDeath(this.p, 0);
                }
            } catch (Exception unused) {
            }
            this.n = null;
        }

        public void a(Messenger messenger) {
            a();
            try {
                if (messenger != null) {
                    this.o = messenger;
                    this.u = true;
                    this.p = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.p, 0);
                } else {
                    com.xiaomi.a.a.a.c.b("peer linked with old sdk chid = " + this.f9080h);
                }
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.b("peer linkToDeath err: " + e2.getMessage());
                this.o = null;
                this.u = false;
            }
        }

        public void a(a aVar) {
            synchronized (this.s) {
                this.s.add(aVar);
            }
        }

        public void a(c cVar, int i2, int i3, String str, String str2) {
            boolean z;
            synchronized (this.s) {
                for (a aVar : this.s) {
                    aVar.a(this.f9085m, cVar, i3);
                }
            }
            c cVar2 = this.f9085m;
            int i4 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.a.a.a.c.a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i2), an.a(i3), str, str2, this.f9080h));
                this.f9085m = cVar;
            }
            if (this.f9083k == null) {
                com.xiaomi.a.a.a.c.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                if (this.n != null && (z = this.u)) {
                    i4 = (this.o == null || !z) ? 10100 : 1000;
                }
                this.t.b(this.q);
                if (b(i2, i3, str2)) {
                    a(i2, i3, str, str2);
                } else {
                    this.t.a(this.q.a(i2, i3, str, str2), i4);
                }
            }
        }

        public long b() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.r + 1) * 15)) * 1000;
        }

        public void b(a aVar) {
            synchronized (this.s) {
                this.s.remove(aVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum c {
        unbind,
        binding,
        binded
    }

    private aj() {
    }

    public static synchronized aj a() {
        aj ajVar;
        synchronized (aj.class) {
            if (a == null) {
                a = new aj();
            }
            ajVar = a;
        }
        return ajVar;
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(TIMMentionEditText.TIM_MENTION_TAG);
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.b.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i2) {
        for (HashMap<String, b> hashMap : this.b.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i2, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f9074c.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.b.get(bVar.f9080h);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.b.put(bVar.f9080h, hashMap);
        }
        hashMap.put(d(bVar.b), bVar);
        com.xiaomi.a.a.a.c.a("add active client. " + bVar.a);
        for (a aVar : this.f9074c) {
            aVar.a();
        }
    }

    public synchronized void a(String str) {
        HashMap<String, b> hashMap = this.b.get(str);
        if (hashMap != null) {
            for (b bVar : hashMap.values()) {
                bVar.a();
            }
            hashMap.clear();
            this.b.remove(str);
        }
        for (a aVar : this.f9074c) {
            aVar.a();
        }
    }

    public synchronized void a(String str, String str2) {
        HashMap<String, b> hashMap = this.b.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(d(str2));
            if (bVar != null) {
                bVar.a();
            }
            hashMap.remove(d(str2));
            if (hashMap.isEmpty()) {
                this.b.remove(str);
            }
        }
        for (a aVar : this.f9074c) {
            aVar.a();
        }
    }

    public synchronized b b(String str, String str2) {
        HashMap<String, b> hashMap = this.b.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(d(str2));
    }

    public synchronized ArrayList<b> b() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.b.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    public synchronized List<String> b(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.b.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.a)) {
                    arrayList.add(bVar.f9080h);
                }
            }
        }
        return arrayList;
    }

    public synchronized int c() {
        return this.b.size();
    }

    public synchronized Collection<b> c(String str) {
        if (this.b.containsKey(str)) {
            return ((HashMap) this.b.get(str).clone()).values();
        }
        return new ArrayList();
    }

    public synchronized void d() {
        Iterator<b> it = b().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.b.clear();
    }

    public synchronized void e() {
        this.f9074c.clear();
    }
}
