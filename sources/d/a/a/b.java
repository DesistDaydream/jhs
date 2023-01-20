package d.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import cn.thinkingdata.android.TDConfig;
import cn.thinkingdata.android.TDPresetProperties;
import cn.thinkingdata.android.ThinkingAnalyticsSDK;
import cn.thinkingdata.android.c;
import cn.thinkingdata.android.utils.TDLog;
import d.a.a.o.n;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    private static final Map<Context, b> f9276g = new HashMap();
    private final C0300b a;
    private final a b;

    /* renamed from: c  reason: collision with root package name */
    private final cn.thinkingdata.android.j f9277c;

    /* renamed from: d  reason: collision with root package name */
    private final cn.thinkingdata.android.c f9278d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f9279e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Boolean> f9280f = new ConcurrentHashMap();

    /* loaded from: classes.dex */
    public class a {
        private final Handler a;

        /* renamed from: d.a.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class HandlerC0299a extends Handler {
            private final List<String> a;

            public HandlerC0299a(Looper looper) {
                super(looper);
                this.a = new ArrayList();
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int b;
                int i2 = message.what;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            b.this.a.r((String) message.obj);
                            return;
                        } else if (i2 == 3) {
                            this.a.remove((String) message.obj);
                            return;
                        } else {
                            return;
                        }
                    }
                    String str = (String) message.obj;
                    if (str == null) {
                        return;
                    }
                    b.this.a.j(str);
                    synchronized (a.this.a) {
                        a.this.a.removeMessages(2, str);
                        this.a.add(str);
                    }
                    synchronized (b.this.f9278d) {
                        b.this.f9278d.e(c.EnumC0056c.EVENTS, (String) message.obj);
                    }
                    return;
                }
                try {
                    d.a.a.a aVar = (d.a.a.a) message.obj;
                    if (aVar == null) {
                        return;
                    }
                    String str2 = aVar.f9275i;
                    if (this.a.contains(str2)) {
                        return;
                    }
                    JSONObject a = aVar.a();
                    try {
                        a.put("#uuid", UUID.randomUUID().toString());
                    } catch (JSONException unused) {
                    }
                    synchronized (b.this.f9278d) {
                        b = b.this.f9278d.b(a, c.EnumC0056c.EVENTS, str2);
                    }
                    if (b < 0) {
                        TDLog.w("ThinkingAnalytics.DataHandle", "Saving data to database failed.");
                    } else {
                        TDLog.i("ThinkingAnalytics.DataHandle", "Data enqueued(" + n.m(str2, 4) + "):\n" + a.toString(4));
                    }
                    a.this.e(str2, b);
                } catch (Exception e2) {
                    TDLog.w("ThinkingAnalytics.DataHandle", "Exception occurred while saving data to database: " + e2.getMessage());
                    e2.printStackTrace();
                }
            }
        }

        public a() {
            HandlerThread handlerThread = new HandlerThread("thinkingData.sdk.saveMessageWorker", 1);
            handlerThread.start();
            this.a = new HandlerC0299a(handlerThread.getLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(String str, int i2) {
            if (i2 >= b.this.p(str)) {
                b.this.a.r(str);
            } else {
                b.this.a.k(str, b.this.r(str));
            }
        }

        public void b(d.a.a.a aVar) {
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.obj = aVar;
            Handler handler = this.a;
            if (handler != null) {
                handler.sendMessage(obtain);
            }
        }

        public void d(String str) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = str;
            Handler handler = this.a;
            if (handler != null) {
                handler.sendMessageAtFrontOfQueue(obtain);
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 3;
            obtain2.obj = str;
            Handler handler2 = this.a;
            if (handler2 != null) {
                handler2.sendMessage(obtain2);
            }
        }

        public void f(String str) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = str;
            this.a.sendMessage(obtain);
        }
    }

    /* renamed from: d.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0300b {
        private final Handler b;

        /* renamed from: c  reason: collision with root package name */
        private final cn.thinkingdata.android.utils.h f9281c;
        private final Object a = new Object();

        /* renamed from: d  reason: collision with root package name */
        private final Map<String, Boolean> f9282d = new HashMap();

        /* renamed from: d.a.a.b$b$a */
        /* loaded from: classes.dex */
        public class a extends Handler {
            public a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                C0300b c0300b;
                int i2 = message.what;
                if (i2 == 0) {
                    String str = (String) message.obj;
                    TDConfig n = b.this.n(str);
                    if (n != null) {
                        synchronized (C0300b.this.a) {
                            Message obtain = Message.obtain();
                            obtain.what = 1;
                            obtain.obj = str;
                            C0300b.this.b.sendMessage(obtain);
                            removeMessages(0, str);
                        }
                        try {
                            C0300b.this.d(n);
                        } catch (RuntimeException e2) {
                            TDLog.w("ThinkingAnalytics.DataHandle", "Sending data to server failed due to unexpected exception: " + e2.getMessage());
                            e2.printStackTrace();
                        }
                        synchronized (C0300b.this.a) {
                            removeMessages(1, str);
                            C0300b c0300b2 = C0300b.this;
                            c0300b2.k(str, b.this.r(str));
                        }
                        return;
                    }
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        if (((String) message.obj) == null) {
                            return;
                        }
                        synchronized (C0300b.this.a) {
                            removeMessages(0, message.obj);
                        }
                        return;
                    } else if (i2 == 4) {
                        try {
                            d.a.a.a aVar = (d.a.a.a) message.obj;
                            if (aVar == null) {
                                return;
                            }
                            JSONObject a = aVar.a();
                            C0300b c0300b3 = C0300b.this;
                            c0300b3.e(b.this.n(aVar.f9275i), a);
                            return;
                        } catch (Exception e3) {
                            TDLog.e("ThinkingAnalytics.DataHandle", "Exception occurred while sending message to Server: " + e3.getMessage());
                            return;
                        }
                    } else if (i2 != 5) {
                        if (i2 != 6) {
                            return;
                        }
                        k b = k.b(b.this.f9279e);
                        synchronized (b.this.f9278d) {
                            b.this.f9278d.d(System.currentTimeMillis() - b.a(), c.EnumC0056c.EVENTS);
                        }
                        return;
                    } else {
                        try {
                            d.a.a.a aVar2 = (d.a.a.a) message.obj;
                            if (aVar2 == null) {
                                return;
                            }
                            TDConfig n2 = b.this.n(aVar2.f9275i);
                            if (n2.isNormal()) {
                                c0300b = C0300b.this;
                            } else {
                                try {
                                    C0300b.this.n(n2, aVar2.a());
                                    return;
                                } catch (Exception e4) {
                                    TDLog.e("ThinkingAnalytics.DataHandle", "Exception occurred while sending message to Server: " + e4.getMessage());
                                    if (n2.shouldThrowException()) {
                                        throw new cn.thinkingdata.android.m(e4);
                                    }
                                    if (n2.isDebugOnly()) {
                                        return;
                                    }
                                    c0300b = C0300b.this;
                                }
                            }
                            b.this.l(aVar2);
                            return;
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            return;
                        }
                    }
                } else {
                    TDConfig n3 = b.this.n((String) message.obj);
                    if (n3 != null) {
                        try {
                            C0300b.this.l("", n3);
                            return;
                        } catch (RuntimeException e6) {
                            TDLog.w("ThinkingAnalytics.DataHandle", "Sending old data failed due to unexpected exception: " + e6.getMessage());
                            e6.printStackTrace();
                            return;
                        }
                    }
                }
                TDLog.w("ThinkingAnalytics.DataHandle", "Could found config object for token. Canceling...");
            }
        }

        public C0300b() {
            HandlerThread handlerThread = new HandlerThread("thinkingData.sdk.sendMessageWorker", 1);
            handlerThread.start();
            this.b = new a(handlerThread.getLooper());
            this.f9281c = b.this.c();
        }

        private Map<String, String> b(JSONArray jSONArray) {
            HashMap hashMap = new HashMap();
            hashMap.put("TA-Integration-Type", cn.thinkingdata.android.j.u());
            hashMap.put("TA-Integration-Version", cn.thinkingdata.android.j.v());
            hashMap.put("TA-Integration-Count", String.valueOf(jSONArray.length()));
            hashMap.put("TA-Integration-Extra", "Android");
            hashMap.put("TA-Datas-Type", d.a.a.e.c.c(jSONArray) ? "1" : "0");
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(TDConfig tDConfig) {
            l(tDConfig.getName(), tDConfig);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(TDConfig tDConfig, JSONObject jSONObject) {
            if (TextUtils.isEmpty(tDConfig.mToken)) {
                return;
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", jSONArray);
            jSONObject2.put("#app_id", tDConfig.mToken);
            jSONObject2.put("#flush_time", System.currentTimeMillis());
            String string = new JSONObject(this.f9281c.a(tDConfig.getServerUrl(), jSONObject2.toString(), false, tDConfig.getSSLSocketFactory(), s("1"))).getString("code");
            TDLog.i("ThinkingAnalytics.DataHandle", "ret code: " + string + ", upload message:\n" + jSONObject2.toString(4));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:107:0x023a  */
        /* JADX WARN: Removed duplicated region for block: B:109:0x0241  */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0233 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void l(java.lang.String r20, cn.thinkingdata.android.TDConfig r21) {
            /*
                Method dump skipped, instructions count: 626
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: d.a.a.b.C0300b.l(java.lang.String, cn.thinkingdata.android.TDConfig):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(TDConfig tDConfig, JSONObject jSONObject) {
            StringBuilder sb = new StringBuilder();
            sb.append("appid=");
            sb.append(tDConfig.mToken);
            if (jSONObject.optJSONObject("properties") != null) {
                TDPresetProperties presetProperties = ThinkingAnalyticsSDK.sharedInstance(tDConfig).getPresetProperties();
                String str = (presetProperties == null || TDPresetProperties.disableList.contains("#device_id")) ? "" : presetProperties.deviceId;
                if (TextUtils.isEmpty(str) && !TDPresetProperties.disableList.contains("#device_id")) {
                    str = cn.thinkingdata.android.j.q(tDConfig.mContext).c(tDConfig.mContext);
                }
                if (!TextUtils.isEmpty(str)) {
                    sb.append("&deviceId=");
                    sb.append(str);
                }
            }
            sb.append("&source=client&data=");
            sb.append(URLEncoder.encode(jSONObject.toString()));
            if (tDConfig.isDebugOnly()) {
                sb.append("&dryRun=1");
            }
            String m2 = n.m(tDConfig.getName(), 4);
            TDLog.d("ThinkingAnalytics.DataHandle", "uploading message(" + m2 + "):\n" + jSONObject.toString(4));
            JSONObject jSONObject2 = new JSONObject(this.f9281c.a(tDConfig.getDebugUrl(), sb.toString(), true, tDConfig.getSSLSocketFactory(), s("1")));
            int i2 = jSONObject2.getInt("errorLevel");
            if (i2 == -1) {
                if (tDConfig.isDebugOnly()) {
                    TDLog.w("ThinkingAnalytics.DataHandle", "The data will be discarded due to this device is not allowed to debug for: " + m2);
                    return;
                }
                tDConfig.setMode(TDConfig.ModeEnum.NORMAL);
                throw new cn.thinkingdata.android.m("Fallback to normal mode due to the device is not allowed to debug for: " + m2);
            }
            Boolean bool = this.f9282d.get(tDConfig.getName());
            if (bool == null || !bool.booleanValue()) {
                Context context = b.this.f9279e;
                Toast.makeText(context, "Debug Mode enabled for: " + m2, 1).show();
                this.f9282d.put(tDConfig.getName(), Boolean.TRUE);
                tDConfig.setAllowDebug();
            }
            if (i2 == 0) {
                TDLog.d("ThinkingAnalytics.DataHandle", "Upload debug data successfully for " + m2);
                return;
            }
            if (jSONObject2.has("errorProperties")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("errorProperties");
                TDLog.d("ThinkingAnalytics.DataHandle", " Error Properties: \n" + jSONArray.toString(4));
            }
            if (jSONObject2.has("errorReasons")) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("errorReasons");
                TDLog.d("ThinkingAnalytics.DataHandle", "Error Reasons: \n" + jSONArray2.toString(4));
            }
            if (tDConfig.shouldThrowException()) {
                if (1 == i2) {
                    throw new cn.thinkingdata.android.m("Invalid properties. Please refer to the logcat log for detail info.");
                }
                if (2 == i2) {
                    throw new cn.thinkingdata.android.m("Invalid data format. Please refer to the logcat log for detail info.");
                }
                throw new cn.thinkingdata.android.m("Unknown error level: " + i2);
            }
        }

        private Map<String, String> s(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("TA-Integration-Type", cn.thinkingdata.android.j.u());
            hashMap.put("TA-Integration-Version", cn.thinkingdata.android.j.v());
            hashMap.put("TA-Integration-Count", str);
            hashMap.put("TA-Integration-Extra", "Android");
            return hashMap;
        }

        public void c() {
            Message obtain = Message.obtain();
            obtain.what = 6;
            this.b.sendMessage(obtain);
        }

        public void f(d.a.a.a aVar) {
            if (aVar == null) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 5;
            obtain.obj = aVar;
            this.b.sendMessage(obtain);
        }

        public void j(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = str;
            this.b.sendMessageAtFrontOfQueue(obtain);
        }

        public void k(String str, long j2) {
            synchronized (this.a) {
                Handler handler = this.b;
                if (handler != null && !handler.hasMessages(0, str) && !this.b.hasMessages(1, str)) {
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = str;
                    try {
                        this.b.sendMessageDelayed(obtain, j2);
                    } catch (IllegalStateException e2) {
                        TDLog.w("ThinkingAnalytics.DataHandle", "The app might be quiting: " + e2.getMessage());
                    }
                }
            }
        }

        public void o(d.a.a.a aVar) {
            if (aVar == null) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = aVar;
            this.b.sendMessage(obtain);
        }

        public void q(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = str;
            this.b.sendMessage(obtain);
        }

        public void r(String str) {
            synchronized (this.a) {
                Handler handler = this.b;
                if (handler != null && !handler.hasMessages(1, str)) {
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = str;
                    this.b.sendMessage(obtain);
                }
            }
        }
    }

    public b(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f9279e = applicationContext;
        this.f9277c = cn.thinkingdata.android.j.q(applicationContext);
        this.f9278d = b(applicationContext);
        C0300b c0300b = new C0300b();
        this.a = c0300b;
        this.b = new a();
        c0300b.c();
    }

    public static b g(Context context) {
        b bVar;
        Map<Context, b> map = f9276g;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (map.containsKey(applicationContext)) {
                bVar = map.get(applicationContext);
            } else {
                bVar = new b(applicationContext);
                map.put(applicationContext, bVar);
            }
        }
        return bVar;
    }

    public cn.thinkingdata.android.c b(Context context) {
        return cn.thinkingdata.android.c.h(context);
    }

    public cn.thinkingdata.android.utils.h c() {
        return new d.a.a.o.c();
    }

    public void d(d.a.a.a aVar) {
        this.a.o(aVar);
    }

    public void e(String str) {
        this.b.d(str);
    }

    public void f(String str, boolean z) {
        if (z) {
            this.f9280f.put(str, Boolean.TRUE);
        } else {
            this.f9280f.remove(str);
        }
    }

    public void i(d.a.a.a aVar) {
        this.a.f(aVar);
    }

    public void j(String str) {
        this.b.f(str);
    }

    public void l(d.a.a.a aVar) {
        this.b.b(aVar);
    }

    public void m(String str) {
        this.a.q(str);
    }

    public TDConfig n(String str) {
        return TDConfig.getInstance(this.f9279e, str);
    }

    public int p(String str) {
        TDConfig n = n(str);
        if (n == null) {
            return 20;
        }
        return n.getFlushBulkSize();
    }

    public int r(String str) {
        TDConfig n = n(str);
        return n == null ? TDConfig.DEFAULT_FLUSH_INTERVAL : n.getFlushInterval();
    }
}
