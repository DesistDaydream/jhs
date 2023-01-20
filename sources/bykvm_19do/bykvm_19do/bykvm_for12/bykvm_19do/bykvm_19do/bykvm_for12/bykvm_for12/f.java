package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class f implements c {
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f249c;

    /* renamed from: d  reason: collision with root package name */
    private b f250d;

    /* renamed from: f  reason: collision with root package name */
    private Context f252f;

    /* renamed from: g  reason: collision with root package name */
    private e f253g;
    private int r;
    private long a = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f251e = false;

    /* renamed from: h  reason: collision with root package name */
    private int f254h = 0;

    /* renamed from: i  reason: collision with root package name */
    private long f255i = 19700101000L;

    /* renamed from: j  reason: collision with root package name */
    private int f256j = 0;

    /* renamed from: k  reason: collision with root package name */
    private HashMap<String, Integer> f257k = new HashMap<>();

    /* renamed from: l  reason: collision with root package name */
    private HashMap<String, Integer> f258l = new HashMap<>();

    /* renamed from: m  reason: collision with root package name */
    private int f259m = 0;
    private HashMap<String, Integer> n = new HashMap<>();
    private HashMap<String, Integer> o = new HashMap<>();
    private boolean p = true;
    private Map<String, Integer> q = new HashMap();
    public Handler s = new a(Looper.getMainLooper());

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            f.this.b(message.arg1 != 0);
        }
    }

    private f() {
    }

    public f(int i2) {
        this.r = i2;
    }

    private String a(y yVar) {
        if (yVar == null || yVar.g() == null) {
            return "";
        }
        if (yVar.g().o() != null) {
            try {
            } catch (Exception unused) {
                return "";
            }
        }
        return InetAddress.getByName(yVar.g().o().getHost()).getHostAddress();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0 r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.f.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0, java.lang.String):void");
    }

    private void a(boolean z, long j2) {
        if (this.s.hasMessages(10000)) {
            return;
        }
        Message obtainMessage = this.s.obtainMessage();
        obtainMessage.what = 10000;
        obtainMessage.arg1 = z ? 1 : 0;
        if (j2 > 0) {
            this.s.sendMessageDelayed(obtainMessage, j2);
        } else {
            this.s.sendMessage(obtainMessage);
        }
    }

    private boolean a(int i2) {
        if (i2 >= 100 && i2 < 1000) {
            d c2 = c();
            if (c2 != null && !TextUtils.isEmpty(c2.f245m)) {
                String str = c2.f245m;
                if (!str.contains("" + i2)) {
                }
            }
            return false;
        }
        return true;
    }

    private void b(String str) {
        Map<String, String> e2;
        if (TextUtils.isEmpty(str) || (e2 = e()) == null || !e2.containsValue(str)) {
            return;
        }
        if (this.q.get(str) == null) {
            this.q.put(str, 1);
        } else {
            this.q.put(str, Integer.valueOf(this.q.get(str).intValue() + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        d c2 = c();
        if (c2 == null) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doUpdateRemote, " + z);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!z) {
            if ((c2.f243k * 1000) + this.a > elapsedRealtime) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doUpdateRemote, time limit");
                return;
            }
        }
        this.a = elapsedRealtime;
        h.a().a(this.r, this.f252f).a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.e.a(this.f252f));
    }

    private boolean b(int i2) {
        return i2 >= 200 && i2 < 400;
    }

    private boolean c(String str) {
        Map<String, String> e2 = e();
        if (e2 == null) {
            return false;
        }
        String str2 = e2.get(str);
        if (TextUtils.isEmpty(str2) || this.q.get(str2) == null || this.q.get(str2).intValue() < 3) {
            return false;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str);
        return true;
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str) && this.q.containsKey(str)) {
            this.q.put(str, 0);
        }
    }

    private void i() {
        SharedPreferences sharedPreferences = this.f252f.getSharedPreferences(f(), 0);
        this.f254h = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.f255i = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    private void j() {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "resetTNCControlState");
        this.f256j = 0;
        this.f257k.clear();
        this.f258l.clear();
        this.f259m = 0;
        this.n.clear();
        this.o.clear();
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a a() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r7) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto Le7
            java.lang.String r0 = "/network/get_network"
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto Le7
            java.lang.String r0 = "/get_domains/v4"
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto Le7
            java.lang.String r0 = "/ies/speed"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L20
            goto Le7
        L20:
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L31
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = r1.getProtocol()     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r1.getHost()     // Catch: java.lang.Throwable -> L2f
            goto L36
        L2f:
            r1 = move-exception
            goto L33
        L31:
            r1 = move-exception
            r2 = r0
        L33:
            r1.printStackTrace()
        L36:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto Le7
            java.lang.String r1 = "http"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L4c
            java.lang.String r1 = "https"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto Le7
        L4c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto Le7
            boolean r1 = r6.c(r0)
            java.lang.String r3 = "TNCManager"
            if (r1 == 0) goto L6c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleHostMapping, TNC host faild num over limit: "
        L61:
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto Lda
        L6c:
            java.util.Map r1 = r6.e()
            if (r1 == 0) goto Lde
            boolean r4 = r1.containsKey(r0)
            if (r4 != 0) goto L79
            goto Lde
        L79:
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto Le7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "handleHostMapping, match, origin: "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r5 = "://"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            boolean r2 = r7.startsWith(r0)
            if (r2 == 0) goto Lc9
            java.lang.String r7 = r7.replaceFirst(r0, r1)
        Lc9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handleHostMapping, target: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
        Lda:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a(r3, r0)
            goto Le7
        Lde:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleHostMapping, nomatch: "
            goto L61
        Le7:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.f.a(java.lang.String):java.lang.String");
    }

    public void a(Context context, boolean z) {
        synchronized (this) {
            if (!this.f251e) {
                this.f252f = context;
                this.p = z;
                this.f253g = new e(context, z, this.r);
                if (z) {
                    i();
                }
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.f254h + " probeVersion: " + this.f255i);
                this.b = h.a().a(this.r, this.f252f);
                this.f251e = true;
            }
        }
    }

    public void a(b bVar) {
        this.f250d = bVar;
    }

    public void a(y yVar, a0 a0Var) {
        synchronized (this) {
            if (yVar != null && a0Var != null) {
                if (this.p && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.e.a(this.f252f)) {
                    URL url = null;
                    try {
                        url = yVar.g().o();
                    } catch (Exception unused) {
                    }
                    if (url != null) {
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String a2 = a(yVar);
                        int k2 = a0Var.k();
                        if (("http".equals(protocol) || "https".equals(protocol)) && !TextUtils.isEmpty(a2)) {
                            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "onResponse, url: " + protocol + "://" + host + MqttTopic.MULTI_LEVEL_WILDCARD + a2 + MqttTopic.MULTI_LEVEL_WILDCARD + k2);
                            d c2 = c();
                            if (c2 != null && c2.b) {
                                a(a0Var, host);
                            }
                            if (c2 != null) {
                                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "onResponse, url matched: " + protocol + "://" + host + MqttTopic.MULTI_LEVEL_WILDCARD + a2 + MqttTopic.MULTI_LEVEL_WILDCARD + k2 + ExpandableTextView.N + this.f256j + MqttTopic.MULTI_LEVEL_WILDCARD + this.f257k.size() + MqttTopic.MULTI_LEVEL_WILDCARD + this.f258l.size() + ExpandableTextView.N + this.f259m + MqttTopic.MULTI_LEVEL_WILDCARD + this.n.size() + MqttTopic.MULTI_LEVEL_WILDCARD + this.o.size());
                                if (k2 > 0) {
                                    if (b(k2)) {
                                        if (this.f256j > 0 || this.f259m > 0) {
                                            j();
                                        }
                                        d(host);
                                    } else if (!a(k2)) {
                                        this.f259m++;
                                        this.n.put(path, 0);
                                        this.o.put(a2, 0);
                                        if (this.f259m >= c2.f240h && this.n.size() >= c2.f241i && this.o.size() >= c2.f242j) {
                                            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + MqttTopic.MULTI_LEVEL_WILDCARD + a2 + MqttTopic.MULTI_LEVEL_WILDCARD + k2);
                                            a(false, 0L);
                                            j();
                                        }
                                        b(host);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(y yVar, Exception exc) {
        d c2;
        synchronized (this) {
            if (yVar != null) {
                if (yVar.g() != null && exc != null && this.p && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.e.a(this.f252f)) {
                    URL url = null;
                    try {
                        url = yVar.g().o();
                    } catch (Exception unused) {
                    }
                    if (url != null) {
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String a2 = a(yVar);
                        if (("http".equals(protocol) || "https".equals(protocol)) && (c2 = c()) != null) {
                            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "onError, url matched: " + protocol + "://" + host + MqttTopic.MULTI_LEVEL_WILDCARD + a2 + "# " + this.f256j + MqttTopic.MULTI_LEVEL_WILDCARD + this.f257k.size() + MqttTopic.MULTI_LEVEL_WILDCARD + this.f258l.size() + ExpandableTextView.N + this.f259m + MqttTopic.MULTI_LEVEL_WILDCARD + this.n.size() + MqttTopic.MULTI_LEVEL_WILDCARD + this.o.size());
                            this.f256j = this.f256j + 1;
                            this.f257k.put(path, 0);
                            this.f258l.put(a2, 0);
                            if (this.f256j >= c2.f237e && this.f257k.size() >= c2.f238f && this.f258l.size() >= c2.f239g) {
                                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "onError, url doUpate: " + protocol + "://" + host + MqttTopic.MULTI_LEVEL_WILDCARD + a2);
                                a(false, 0L);
                                j();
                            }
                            b(host);
                        }
                    }
                }
            }
        }
    }

    public void a(boolean z) {
        this.f249c = z;
    }

    public b b() {
        return this.f250d;
    }

    public d c() {
        e eVar = this.f253g;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public e d() {
        return this.f253g;
    }

    public Map<String, String> e() {
        d c2 = c();
        if (c2 != null) {
            return c2.f236d;
        }
        return null;
    }

    public String f() {
        return "ttnet_tnc_config" + this.r;
    }

    public boolean g() {
        return this.f249c;
    }

    public void h() {
        this.q.clear();
    }
}
