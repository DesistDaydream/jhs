package com.tencent.tpns.baseapi.base.util;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.android.tpush.XGPushNotificationBuilder;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.umeng.analytics.pro.am;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CloudManager {
    public static final String KEY_CONFIG = "cloud";
    private static Context a;
    private String A;
    private int B;
    private int C;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private long f6860c;

    /* renamed from: d  reason: collision with root package name */
    private int f6861d;

    /* renamed from: e  reason: collision with root package name */
    private int f6862e;

    /* renamed from: f  reason: collision with root package name */
    private int f6863f;

    /* renamed from: g  reason: collision with root package name */
    private int f6864g;

    /* renamed from: h  reason: collision with root package name */
    private int f6865h;

    /* renamed from: i  reason: collision with root package name */
    private long f6866i;

    /* renamed from: j  reason: collision with root package name */
    private long f6867j;

    /* renamed from: k  reason: collision with root package name */
    private int f6868k;

    /* renamed from: l  reason: collision with root package name */
    private int f6869l;

    /* renamed from: m  reason: collision with root package name */
    private int f6870m;
    private int n;
    private int o;
    private int p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private int v;
    private int w;
    private int x;
    private String y;
    private JSONArray z;

    /* loaded from: classes3.dex */
    public static class CloudManagerHolder {
        public static CloudManager instance = new CloudManager();
    }

    public static CloudManager getInstance(Context context) {
        if (a == null) {
            a = context.getApplicationContext();
        }
        return CloudManagerHolder.instance;
    }

    public void clearGuid() {
        this.u = null;
        this.q = null;
        try {
            PushPreferences.remove(a, "cloud_control_addrCfg");
        } catch (Throwable unused) {
            TBaseLogger.w("CloudManager", "unexpected for clearGuid");
        }
    }

    public boolean disableCollData() {
        return i() == 1;
    }

    public boolean disablePullMsg() {
        if (this.v == -1) {
            this.v = a(a, "cloud_control_pullMsg", 0);
        }
        return this.v == 1;
    }

    public boolean disablePullUp() {
        return c() == 10 || h() == 1;
    }

    public boolean disableRepLanuEv() {
        if (this.p == -1) {
            this.p = a(a, "cloud_control_repoLanuEv", 1);
        }
        return this.p == 1;
    }

    public boolean disableReptErrCode() {
        int reptErrCode = getReptErrCode();
        if (reptErrCode == 1) {
            return true;
        }
        return reptErrCode > 0 && new Random().nextInt(100) < reptErrCode;
    }

    public boolean disableReptLog() {
        if (this.w == -1) {
            this.w = a(a, "cloud_control_reptLog", 0);
        }
        return this.w == 1;
    }

    public boolean disableShareBugly() {
        return j() == 1;
    }

    public int getAppClsAlive() {
        if (this.o == -1) {
            this.o = a(a, "cloud_control_appClsAlive", 0);
        }
        return this.o;
    }

    public String getCloud() {
        return this.b;
    }

    public long getCloudVersion() {
        if (this.f6860c == -1) {
            this.f6860c = PushPreferences.getLong(a, "cloud_control_version", 0L);
        }
        return this.f6860c;
    }

    public int getCompressLevel() {
        if (this.x == -1) {
            this.x = a(a, "cloud_control_compress", 0);
        }
        return this.x;
    }

    public String getCustom() {
        if (!Util.isNullOrEmptyString(this.s)) {
            return this.s;
        }
        try {
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getCustom");
        }
        if (Util.isNullOrEmptyString(l())) {
            return this.s;
        }
        this.s = new JSONObject(l()).getString(XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE);
        return this.s;
    }

    public String getGuid() {
        if (!Util.isNullOrEmptyString(this.u)) {
            return this.u;
        }
        try {
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getGuid");
        }
        if (Util.isNullOrEmptyString(l())) {
            return this.u;
        }
        this.u = new JSONObject(l()).getString("guid");
        return this.u;
    }

    public int getInterval() {
        if (this.f6863f == -1) {
            this.f6863f = PushPreferences.getInt(a, "cloud_control_interval", 0);
        }
        return this.f6863f;
    }

    public String getLog() {
        if (!Util.isNullOrEmptyString(this.t)) {
            return this.t;
        }
        try {
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getLog");
        }
        if (Util.isNullOrEmptyString(l())) {
            return this.t;
        }
        this.t = new JSONObject(l()).getString("log");
        return this.t;
    }

    public JSONArray getPullupArrProviderAndActivity() {
        JSONArray jSONArray = this.z;
        if (jSONArray != null) {
            return jSONArray;
        }
        try {
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getPullupJSONArr");
        }
        if (Util.isNullOrEmptyString(k())) {
            return null;
        }
        this.z = new JSONArray(this.y);
        return this.z;
    }

    public String getPullupBlackList() {
        try {
            if (this.A == null) {
                this.A = PushPreferences.getString(a, "cloud_control_conf_pull_black_list", "");
            }
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getPullupBlackList");
        }
        return "";
    }

    public int getRecons() {
        if (this.f6868k == -1) {
            this.f6868k = a(a, "cloud_control_recons", 0);
        }
        return this.f6868k;
    }

    public int getReptErrCode() {
        if (this.f6869l == -1) {
            this.f6869l = a(a, "cloud_control_reptErrCode", 1);
        }
        return this.f6869l;
    }

    public String getStat() {
        if (!Util.isNullOrEmptyString(this.r)) {
            return this.r;
        }
        try {
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getStat");
        }
        if (Util.isNullOrEmptyString(l())) {
            return this.r;
        }
        this.r = new JSONObject(l()).getString("stat");
        return this.r;
    }

    public void parseCloudConfig(final String str, final long j2) {
        if (Util.isNullOrEmptyString(str) || a == null) {
            return;
        }
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.tpns.baseapi.base.util.CloudManager.1
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                try {
                    TBaseLogger.d("CloudManager", "config: " + str);
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("reset")) {
                        ContentValues reset = CloudManager.this.reset();
                        if (reset != null) {
                            PushPreferences.putContentValues(CloudManager.a, reset);
                            return;
                        }
                        return;
                    }
                    CloudManager.this.b = str;
                    CloudManager.this.f6860c = jSONObject.optLong("cloudVersion", 0L);
                    CloudManager.this.f6861d = jSONObject.optInt("keepAlive", 0);
                    CloudManager.this.f6862e = jSONObject.optInt("packetLoss", 0);
                    CloudManager.this.f6863f = jSONObject.optInt(am.aU, 0);
                    CloudManager.this.f6864g = jSONObject.optInt("appAlive", 0);
                    CloudManager.this.f6865h = jSONObject.optInt("losePkt", 0);
                    CloudManager.this.f6866i = jSONObject.optLong("loseStart", 0L) * 1000;
                    CloudManager.this.f6867j = jSONObject.optLong("loseEnd", 0L) * 1000;
                    CloudManager.this.f6868k = jSONObject.optInt("recons", 0);
                    CloudManager.this.f6869l = jSONObject.optInt("reptErrCode", 0);
                    CloudManager.this.f6870m = jSONObject.optInt("collData", 0);
                    CloudManager.this.n = jSONObject.optInt("shrBugly", 0);
                    CloudManager.this.o = jSONObject.optInt("appClsAlive", 0);
                    CloudManager.this.p = jSONObject.optInt("repoLanuEv", 0);
                    CloudManager.this.x = jSONObject.optInt("compress", 0);
                    CloudManager.this.q = jSONObject.optString("addrCfg", "");
                    CloudManager.this.v = jSONObject.optInt("pullMsg", -1);
                    CloudManager.this.w = jSONObject.optInt("reptLog", -1);
                    CloudManager.this.y = jSONObject.optString("conf_pull_arr", "");
                    CloudManager.this.A = jSONObject.optString("conf_pull_black_list", "");
                    CloudManager.this.B = jSONObject.optInt("useHttpAccount", 0);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("cloud_control_keepAlive", Integer.valueOf(CloudManager.this.f6861d));
                    contentValues.put("cloud_control_packetLoss", Integer.valueOf(CloudManager.this.f6862e));
                    contentValues.put("cloud_control_interval", Integer.valueOf(CloudManager.this.f6863f));
                    if (CloudManager.this.f6860c > 0) {
                        contentValues.put("cloud_control_version", Long.valueOf(CloudManager.this.f6860c));
                    }
                    contentValues.put("cloud_control_appAlive", Integer.valueOf(CloudManager.this.f6864g));
                    contentValues.put("cloud_control_losePkt", Integer.valueOf(CloudManager.this.f6865h));
                    contentValues.put("cloud_control_recons", Integer.valueOf(CloudManager.this.f6868k));
                    contentValues.put("cloud_control_reptErrCode", Integer.valueOf(CloudManager.this.f6869l));
                    contentValues.put("cloud_control_collData", Integer.valueOf(CloudManager.this.f6870m));
                    contentValues.put("cloud_control_shrBugly", Integer.valueOf(CloudManager.this.n));
                    contentValues.put("cloud_control_appClsAlive", Integer.valueOf(CloudManager.this.o));
                    contentValues.put("cloud_control_repoLanuEv", Integer.valueOf(CloudManager.this.p));
                    contentValues.put("cloud_control_compress", Integer.valueOf(CloudManager.this.x));
                    contentValues.put("cloud_control_pullMsg", Integer.valueOf(CloudManager.this.v));
                    contentValues.put("cloud_control_reptLog", Integer.valueOf(CloudManager.this.w));
                    contentValues.put("cloud_control_useHttpAccount", Integer.valueOf(CloudManager.this.B));
                    if (!Util.isNullOrEmptyString(CloudManager.this.q)) {
                        contentValues.put("cloud_control_addrCfg", CloudManager.this.q);
                    }
                    if (!Util.isNullOrEmptyString(CloudManager.this.y)) {
                        contentValues.put("cloud_control_conf_pull_arr", CloudManager.this.y);
                    }
                    if (!Util.isNullOrEmptyString(CloudManager.this.A)) {
                        contentValues.put("cloud_control_conf_pull_black_list", CloudManager.this.A);
                    }
                    PushPreferences.putContentValues(CloudManager.a, contentValues);
                    StatHelper.reportCloudControl(CloudManager.a, CloudManager.this.f6860c, 1, str, j2);
                } catch (Throwable th) {
                    TBaseLogger.w("CloudManager", "unexpected for config:" + str, th);
                    StatHelper.reportCloudControl(CloudManager.a, CloudManager.this.getCloudVersion(), 2, str, j2);
                }
            }
        });
    }

    public ContentValues reset() {
        this.b = null;
        this.f6860c = -1L;
        this.f6861d = -1;
        this.f6862e = -1;
        this.f6863f = -1;
        this.f6864g = -1;
        this.f6865h = -1;
        this.f6868k = -1;
        this.f6869l = -1;
        this.f6870m = -1;
        this.n = -1;
        this.o = -1;
        this.x = -1;
        this.v = -1;
        this.w = -1;
        this.B = -1;
        this.q = null;
        this.y = null;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.putNull("cloud_control_keepAlive");
            contentValues.putNull("cloud_control_packetLoss");
            contentValues.putNull("cloud_control_version");
            contentValues.putNull("cloud_control_interval");
            contentValues.putNull("cloud_control_appAlive");
            contentValues.putNull("cloud_control_losePkt");
            contentValues.putNull("cloud_control_recons");
            contentValues.putNull("cloud_control_reptErrCode");
            contentValues.putNull("cloud_control_collData");
            contentValues.putNull("cloud_control_shrBugly");
            contentValues.putNull("cloud_control_appClsAlive");
            contentValues.putNull("cloud_control_repoLanuEv");
            contentValues.putNull("cloud_control_compress");
            contentValues.putNull("cloud_control_pullMsg");
            contentValues.putNull("cloud_control_reptLog");
            contentValues.putNull("cloud_control_addrCfg");
            contentValues.putNull("cloud_control_conf_pull_arr");
            contentValues.putNull("cloud_control_conf_pull_black_list");
            contentValues.putNull("cloud_control_useHttpAccount");
            return contentValues;
        } catch (Throwable th) {
            TBaseLogger.w("CloudManager", "unexpected for reset", th);
            return null;
        }
    }

    public boolean shouldRefuse() {
        if (!b()) {
            TBaseLogger.d("CloudManager", "shouldRefuse | isCloudRefuse : false");
            return false;
        }
        f();
        g();
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f6867j;
        if (currentTimeMillis > j2 || currentTimeMillis < this.f6866i) {
            long j3 = this.f6866i;
            if ((j3 != 0 || j2 != 0) && ((currentTimeMillis > j2 || j3 != 0) && (currentTimeMillis < j3 || j2 != 0))) {
                return false;
            }
        }
        TBaseLogger.d("CloudManager", "shouldRefuse | refuse ");
        return true;
    }

    public int useHttp() {
        if (this.B == -1) {
            this.B = a(a, "cloud_control_useHttpAccount", 0);
        }
        return this.B;
    }

    public int useTpnsChannel() {
        if (this.C == -1) {
            this.C = a(a, "cloud_control_useTpnsChannel", 0);
        }
        return this.C;
    }

    private CloudManager() {
        this.b = null;
        this.f6860c = -1L;
        this.f6861d = -1;
        this.f6862e = -1;
        this.f6863f = -1;
        this.f6864g = -1;
        this.f6865h = -1;
        this.f6866i = 0L;
        this.f6867j = 0L;
        this.f6868k = -1;
        this.f6869l = -1;
        this.f6870m = -1;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = -1;
        this.C = -1;
    }

    private int e() {
        if (this.f6865h == -1) {
            this.f6865h = a(a, "cloud_control_losePkt", 0);
        }
        return this.f6865h;
    }

    private long f() {
        if (this.f6866i == 0) {
            this.f6866i = a(a, "cloud_control_loseStart", 0);
        }
        return this.f6866i;
    }

    private long g() {
        if (this.f6867j == 0) {
            this.f6867j = a(a, "cloud_control_loseStart", 0);
        }
        return this.f6867j;
    }

    private int h() {
        if (this.f6864g == -1) {
            this.f6864g = a(a, "cloud_control_appAlive", 0);
        }
        return this.f6864g;
    }

    private int i() {
        if (this.f6870m == -1) {
            this.f6870m = a(a, "cloud_control_collData", 0);
        }
        return this.f6870m;
    }

    private int j() {
        if (this.n == -1) {
            this.n = a(a, "cloud_control_shrBugly", 0);
        }
        return this.n;
    }

    private String k() {
        if (this.y == null) {
            this.y = PushPreferences.getString(a, "cloud_control_conf_pull_arr", "");
        }
        return this.y;
    }

    private String l() {
        if (this.q == null) {
            this.q = PushPreferences.getString(a, "cloud_control_addrCfg", "");
        }
        return this.q;
    }

    private int d() {
        if (this.f6862e == -1) {
            this.f6862e = a(a, "cloud_control_packetLoss", 0);
        }
        return this.f6862e;
    }

    private boolean b() {
        if (d() == 20 || e() == 1) {
            return true;
        }
        int max = Math.max(d(), e());
        return max > 0 && new Random().nextInt(100) < max;
    }

    private int c() {
        if (this.f6861d == -1) {
            this.f6861d = a(a, "cloud_control_keepAlive", 0);
        }
        return this.f6861d;
    }

    private int a(Context context, String str, int i2) {
        if (context == null) {
            return i2;
        }
        try {
            return PushPreferences.getInt(context, str, i2);
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getCloudConfig:" + str);
            return i2;
        }
    }
}
