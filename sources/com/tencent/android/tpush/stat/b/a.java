package com.tencent.android.tpush.stat.b;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.bc;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.stat.event.Event;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import com.umeng.analytics.pro.am;
import e.t.u.b0;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    public static C0231a a;

    /* renamed from: d  reason: collision with root package name */
    private static c f6412d = b.b();

    /* renamed from: e  reason: collision with root package name */
    private static JSONObject f6413e = new JSONObject();
    public Integer b;

    /* renamed from: c  reason: collision with root package name */
    public String f6414c;

    /* renamed from: com.tencent.android.tpush.stat.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0231a {
        public String a;
        public DisplayMetrics b;

        /* renamed from: c  reason: collision with root package name */
        public int f6415c;

        /* renamed from: d  reason: collision with root package name */
        public String f6416d;

        /* renamed from: e  reason: collision with root package name */
        public String f6417e;

        /* renamed from: f  reason: collision with root package name */
        public String f6418f;

        /* renamed from: g  reason: collision with root package name */
        public String f6419g;

        /* renamed from: h  reason: collision with root package name */
        public String f6420h;

        /* renamed from: i  reason: collision with root package name */
        public int f6421i;

        /* renamed from: j  reason: collision with root package name */
        public String f6422j;

        /* renamed from: k  reason: collision with root package name */
        public Context f6423k;

        /* renamed from: l  reason: collision with root package name */
        public long f6424l;

        /* renamed from: m  reason: collision with root package name */
        private String f6425m;
        private String n;

        public void a(JSONObject jSONObject, Thread thread) {
            if (thread == null) {
                if (this.b != null) {
                    jSONObject.put("sr", this.b.widthPixels + "*" + this.b.heightPixels);
                    jSONObject.put("dpi", this.b.xdpi + "*" + this.b.ydpi);
                }
                if (com.tencent.android.tpush.stat.b.a(this.f6423k).b()) {
                    JSONObject jSONObject2 = new JSONObject();
                    e.a(jSONObject2, "bs", CustomDeviceInfos.getWiFiBBSID(this.f6423k));
                    e.a(jSONObject2, b0.a.f14656g, CustomDeviceInfos.getWiFiSSID(this.f6423k));
                    if (jSONObject2.length() > 0) {
                        e.a(jSONObject, "wf", jSONObject2.toString());
                    }
                }
                JSONArray wifiTopN = CustomDeviceInfos.getWifiTopN(this.f6423k, 10);
                if (wifiTopN != null && wifiTopN.length() > 0) {
                    e.a(jSONObject, "wflist", wifiTopN.toString());
                }
            } else {
                e.a(jSONObject, "thn", thread.getName());
                if (b.c(this.f6425m) && this.f6425m.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length == 2) {
                    e.a(jSONObject, "fram", this.f6425m.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[0]);
                }
                if (b.c(this.n) && this.n.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length == 2) {
                    e.a(jSONObject, "from", this.n.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[0]);
                }
                jSONObject.put("ui", CustomDeviceInfos.getFacilityIdentity(this.f6423k));
                e.a(jSONObject, "mid", XGPushConfig.getToken(this.f6423k));
            }
            e.a(jSONObject, "pcn", b.d(this.f6423k));
            e.a(jSONObject, "osn", Build.VERSION.RELEASE);
            e.a(jSONObject, "av", this.a);
            e.a(jSONObject, "ch", Event.channel);
            e.a(jSONObject, "mf", this.f6416d);
            long j2 = this.f6424l;
            if (j2 > 0) {
                e.a(jSONObject, "sv", b.a(this.f6423k, j2));
            }
            e.a(jSONObject, "osd", Build.DISPLAY);
            e.a(jSONObject, IAdInterListener.AdReqParam.PROD, Build.PRODUCT);
            e.a(jSONObject, bc.f1477l, Build.TAGS);
            e.a(jSONObject, "id", Build.ID);
            e.a(jSONObject, "fng", Build.FINGERPRINT);
            e.a(jSONObject, "ov", Integer.toString(this.f6415c));
            jSONObject.put(am.x, 1);
            e.a(jSONObject, "op", this.f6418f);
            e.a(jSONObject, "lg", this.f6417e);
            e.a(jSONObject, "tz", this.f6419g);
            int i2 = this.f6421i;
            if (i2 != 0) {
                jSONObject.put("jb", i2);
            }
            e.a(jSONObject, "sd", this.f6420h);
            e.a(jSONObject, "abi", Build.CPU_ABI);
            e.a(jSONObject, "ram", this.f6425m);
            e.a(jSONObject, "rom", this.n);
        }

        private C0231a(Context context, long j2) {
            this.f6415c = Build.VERSION.SDK_INT;
            this.f6416d = Build.MANUFACTURER;
            this.f6417e = Locale.getDefault().getLanguage();
            this.f6421i = 0;
            this.f6422j = null;
            this.f6423k = null;
            this.f6425m = null;
            this.n = null;
            this.f6424l = 0L;
            Context applicationContext = context.getApplicationContext();
            this.f6423k = applicationContext;
            this.b = DeviceInfos.getDisplayMetrics(applicationContext);
            this.a = b.b(this.f6423k, j2);
            this.f6418f = CustomDeviceInfos.getSimOperator(this.f6423k);
            this.f6419g = TimeZone.getDefault().getID();
            this.f6420h = DeviceInfos.getExternalStorageInfo(this.f6423k);
            this.f6422j = this.f6423k.getPackageName();
            this.f6425m = DeviceInfos.getSystemMemory(this.f6423k);
            this.n = DeviceInfos.getRomMemory();
            this.f6424l = j2;
        }
    }

    public a(Context context, long j2) {
        this.b = null;
        this.f6414c = null;
        try {
            a(context, j2);
            this.b = DeviceInfos.getTelephonyNetworkType(context.getApplicationContext());
            this.f6414c = com.tencent.android.tpush.stat.b.a(context).a();
        } catch (Throwable th) {
            f6412d.b(th);
        }
    }

    public static synchronized C0231a a(Context context, long j2) {
        C0231a c0231a;
        synchronized (a.class) {
            if (a == null) {
                a = new C0231a(context.getApplicationContext(), j2);
            }
            c0231a = a;
        }
        return c0231a;
    }

    public void a(JSONObject jSONObject, Thread thread) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            C0231a c0231a = a;
            if (c0231a != null) {
                c0231a.a(jSONObject2, thread);
            }
            e.a(jSONObject2, AdvanceSetting.CLEAR_NOTIFICATION, this.f6414c);
            Integer num = this.b;
            if (num != null) {
                jSONObject2.put("tn", num);
            }
            if (thread == null) {
                jSONObject.put("ev", jSONObject2);
            } else {
                jSONObject.put("errkv", jSONObject2.toString());
            }
            JSONObject jSONObject3 = f6413e;
            if (jSONObject3 == null || jSONObject3.length() <= 0) {
                return;
            }
            jSONObject.put("eva", f6413e);
        } catch (Throwable th) {
            f6412d.b(th);
        }
    }
}
