package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.be;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {
    public static String a = null;
    public static String b = "";

    /* renamed from: c */
    private static final String f7455c = "EnvelopeManager";

    /* renamed from: d */
    private static final String f7456d = "debug.umeng.umTaskId";

    /* renamed from: e */
    private static final String f7457e = "debug.umeng.umCaseId";

    /* renamed from: f */
    private static final String f7458f = "empty";

    /* renamed from: g */
    private static String f7459g = "";

    /* renamed from: h */
    private static String f7460h = "";

    /* renamed from: i */
    private static String f7461i;

    /* renamed from: j */
    private static Map<String, String> f7462j;

    /* renamed from: l */
    private static boolean f7463l;

    /* renamed from: k */
    private int f7464k = 0;

    static {
        HashMap hashMap = new HashMap();
        f7462j = hashMap;
        hashMap.put("header", "#h");
        f7462j.put("sdk_type", "#sdt");
        f7462j.put(am.Q, "#ac");
        f7462j.put("device_model", "#dm");
        f7462j.put(am.f7002g, "#umid");
        f7462j.put(am.x, am.x);
        f7462j.put(am.N, "#lang");
        f7462j.put(am.ai, "#dt");
        f7462j.put("resolution", "#rl");
        f7462j.put(am.H, "#dmf");
        f7462j.put(am.J, "#dn");
        f7462j.put("platform_version", "#pv");
        f7462j.put("font_size_setting", "#fss");
        f7462j.put("os_version", "#ov");
        f7462j.put(am.I, "#did");
        f7462j.put("platform_sdk_version", "#psv");
        f7462j.put(am.F, "#db");
        f7462j.put("appkey", "#ak");
        f7462j.put(am.Y, "#itr");
        f7462j.put("id_type", "#it");
        f7462j.put("uuid", "#ud");
        f7462j.put("device_id", "#dd");
        f7462j.put(am.X, "#imp");
        f7462j.put("sdk_version", "#sv");
        f7462j.put("st", "#st");
        f7462j.put("analytics", "#a");
        f7462j.put("package_name", "#pkg");
        f7462j.put(am.p, "#sig");
        f7462j.put(am.q, "#sis1");
        f7462j.put(am.r, "#sis");
        f7462j.put("app_version", "#av");
        f7462j.put("version_code", "#vc");
        f7462j.put(am.v, "#imd");
        f7462j.put(am.B, "#mnc");
        f7462j.put(am.E, "#boa");
        f7462j.put(am.G, "#mant");
        f7462j.put(am.M, "#tz");
        f7462j.put(am.O, "#ct");
        f7462j.put(am.P, "#car");
        f7462j.put(am.s, "#disn");
        f7462j.put("network_type", "#nt");
        f7462j.put(am.b, "#cv");
        f7462j.put(am.f6999d, "#mv");
        f7462j.put(am.f6998c, "#cot");
        f7462j.put(am.f7000e, "#mod");
        f7462j.put(am.aj, "#al");
        f7462j.put("session_id", "#sid");
        f7462j.put(am.S, "#ip");
        f7462j.put(am.U, "#sre");
        f7462j.put(am.V, "#fre");
        f7462j.put(am.W, "#ret");
        f7462j.put("channel", "#chn");
        f7462j.put("wrapper_type", "#wt");
        f7462j.put("wrapper_version", "#wv");
        f7462j.put(am.aV, "#tsv");
        f7462j.put(am.aW, "#rps");
        f7462j.put(am.aZ, "#mov");
        f7462j.put(d.f7137i, "#vt");
        f7462j.put("secret", "#sec");
        f7462j.put(d.ah, "#prv");
        f7462j.put(d.f7140l, "#$prv");
        f7462j.put(d.f7141m, "#uda");
        f7462j.put(am.a, "#tok");
        f7462j.put(am.aN, "#iv");
        f7462j.put(am.R, "#ast");
        f7462j.put("backstate", "#bst");
        f7462j.put("zdata_ver", "#zv");
        f7462j.put("zdata_req_ts", "#zrt");
        f7462j.put("app_b_v", "#bv");
        f7462j.put("zdata", "#zta");
        f7462j.put(am.ap, "#mt");
        f7462j.put(am.am, "#zsv");
        f7462j.put(am.ao, "#oos");
    }

    public static String a(String str) {
        return f7462j.containsKey(str) ? f7462j.get(str) : str;
    }

    private static boolean b() {
        f7459g = UMUtils.getSystemProperty(f7456d, "");
        f7460h = UMUtils.getSystemProperty(f7457e, "");
        return (!TextUtils.isEmpty(f7459g) && !f7458f.equals(f7459g)) && (!TextUtils.isEmpty(f7460h) && !f7458f.equals(f7460h));
    }

    public static void a() {
        if (f7461i != null) {
            f7461i = null;
            e.a();
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", f7459g);
                    jSONObject.put("umCaseId", f7460h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            Envelope envelope = null;
            if (jSONObject3 != null && (envelope = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a2 = a(context, envelope2, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
            if (a2 != 0) {
                return a(a2, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(f7455c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    public static long a(Context context) {
        long j2 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            Log.i(f7455c, "free size is " + j2);
        }
        return j2;
    }

    private JSONObject a(int i2, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i2);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i2);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        String str4;
        String str5;
        boolean z;
        String str6;
        Envelope envelope;
        String str7;
        JSONObject optJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i(f7455c, "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i(f7455c, "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        if (context != null && jSONObject2 != null) {
            try {
                if (jSONObject2.has("analytics") && (optJSONObject = jSONObject2.optJSONObject("analytics")) != null && optJSONObject.has(d.n)) {
                    str5 = str2;
                    z = true;
                } else {
                    str5 = str2;
                    z = false;
                }
                JSONObject a2 = a(context, str5, z);
                if (a2 != null && jSONObject != null) {
                    a2 = a(a2, jSONObject);
                }
                JSONObject jSONObject4 = a2;
                if (jSONObject4 != null && jSONObject2 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null && (next instanceof String) && (str7 = next) != null && jSONObject2.opt(str7) != null) {
                            try {
                                jSONObject4.put(a(str7), jSONObject2.opt(str7));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    str5 = am.aH;
                }
                String str8 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
                if (jSONObject4 != null) {
                    String str9 = str5 + "==" + str8 + "&=";
                    if (TextUtils.isEmpty(str9)) {
                        return a(101, jSONObject4);
                    }
                    if (str9.endsWith("&=")) {
                        str9 = str9.substring(0, str9.length() - 2);
                    }
                    str6 = str9;
                } else {
                    str6 = null;
                }
                if (jSONObject4 != null) {
                    try {
                        e a3 = e.a(context);
                        if (a3 != null) {
                            a3.b();
                            String encodeToString = Base64.encodeToString(new be().a(a3.c()), 0);
                            if (!TextUtils.isEmpty(encodeToString)) {
                                JSONObject jSONObject5 = jSONObject4.getJSONObject(a("header"));
                                jSONObject5.put(a(am.Y), encodeToString);
                                jSONObject4.put(a("header"), jSONObject5);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (jSONObject4 != null && DataHelper.largeThanMaxSize(jSONObject4.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, jSONObject4);
                }
                if (jSONObject4 != null) {
                    Envelope a4 = a(context, jSONObject4.toString().getBytes());
                    if (a4 == null) {
                        return a(111, jSONObject4);
                    }
                    envelope = a4;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, jSONObject4);
                }
                int a5 = a(context, envelope, str6, jSONObject4 != null ? jSONObject4.optJSONObject(a("header")).optString(a("app_version")) : null, str);
                if (a5 != 0) {
                    return a(a5, jSONObject4);
                }
                if (ULog.DEBUG) {
                    Log.i(f7455c, "constructHeader size is " + jSONObject4.toString().getBytes().length);
                }
                if (!str6.startsWith(am.aD) && !str6.startsWith("i") && !str6.startsWith(am.aI) && !str6.startsWith(am.av) && !com.umeng.commonsdk.stateless.b.a()) {
                    new com.umeng.commonsdk.stateless.b(context);
                    com.umeng.commonsdk.stateless.b.b();
                }
                return jSONObject4;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
                if (jSONObject != null) {
                    try {
                        JSONObject jSONObject6 = new JSONObject();
                        try {
                            jSONObject6.put("header", jSONObject);
                        } catch (JSONException unused3) {
                        } catch (Exception e2) {
                            e = e2;
                            jSONObject3 = jSONObject6;
                            UMCrashManager.reportCrash(context, e);
                            return a(110, jSONObject3);
                        }
                        jSONObject3 = jSONObject6;
                    } catch (Exception e3) {
                        e = e3;
                        jSONObject3 = null;
                    }
                } else {
                    jSONObject3 = null;
                }
                if (jSONObject2 != null) {
                    if (jSONObject3 == null) {
                        try {
                            jSONObject3 = new JSONObject();
                        } catch (Exception e4) {
                            e = e4;
                            UMCrashManager.reportCrash(context, e);
                            return a(110, jSONObject3);
                        }
                    }
                    if (jSONObject2 != null) {
                        Iterator<String> keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            if (next2 != null && (next2 instanceof String) && (str4 = next2) != null && jSONObject2.opt(str4) != null) {
                                try {
                                    jSONObject3.put(str4, jSONObject2.opt(str4));
                                } catch (Exception unused4) {
                                }
                            }
                        }
                    }
                }
                return a(110, jSONObject3);
            }
        }
        return a(110, (JSONObject) null);
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(com.umeng.commonsdk.internal.c.a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f7402c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            Envelope envelope = null;
            if (jSONObject3 != null && (envelope = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a2 = a(context, envelope2, "h==1.2.0", "", str);
            if (a2 != 0) {
                return a(a2, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(f7455c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:571:0x03ad -> B:583:0x03ad). Please submit an issue!!! */
    private static JSONObject a(Context context, String str, boolean z) {
        SharedPreferences sharedPreferences;
        JSONObject jSONObject;
        int[] resolutionArray;
        try {
            sharedPreferences = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(f7461i)) {
                try {
                    jSONObject = new JSONObject(f7461i);
                } catch (Exception unused) {
                    jSONObject = null;
                }
            } else {
                UMUtils.saveSDKComponent();
                jSONObject = new JSONObject();
                jSONObject.put(a(am.p), DeviceConfig.getAppMD5Signature(context));
                jSONObject.put(a(am.q), DeviceConfig.getAppSHA1Key(context));
                jSONObject.put(a(am.r), DeviceConfig.getAppHashKey(context));
                jSONObject.put(a("app_version"), DeviceConfig.getAppVersionName(context));
                jSONObject.put(a("version_code"), Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject.put(a(am.v), DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject.put(a("cpu"), DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject.put(a(am.B), mccmnc);
                    b = mccmnc;
                } else {
                    jSONObject.put(a(am.B), "");
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.I)) {
                    String subOSName = DeviceConfig.getSubOSName(context);
                    if (!TextUtils.isEmpty(subOSName)) {
                        jSONObject.put(a(am.K), subOSName);
                    }
                    String subOSVersion = DeviceConfig.getSubOSVersion(context);
                    if (!TextUtils.isEmpty(subOSVersion)) {
                        jSONObject.put(a(am.L), subOSVersion);
                    }
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject.put(a(am.ai), deviceType);
                }
                jSONObject.put(a("package_name"), DeviceConfig.getPackageName(context));
                jSONObject.put(a("sdk_type"), "Android");
                jSONObject.put(a("device_id"), DeviceConfig.getDeviceId(context));
                jSONObject.put(a("device_model"), Build.MODEL);
                jSONObject.put(a(am.E), Build.BOARD);
                jSONObject.put(a(am.F), Build.BRAND);
                jSONObject.put(a(am.G), Build.TIME);
                jSONObject.put(a(am.H), Build.MANUFACTURER);
                jSONObject.put(a(am.I), Build.ID);
                jSONObject.put(a(am.J), Build.DEVICE);
                jSONObject.put(a("os_version"), Build.VERSION.RELEASE);
                jSONObject.put(a(am.x), "Android");
                if (DeviceConfig.getResolutionArray(context) != null) {
                    jSONObject.put(a("resolution"), resolutionArray[1] + "*" + resolutionArray[0]);
                }
                jSONObject.put(a(am.A), DeviceConfig.getMac(context));
                jSONObject.put(a(am.M), DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject.put(a(am.O), localeInfo[0]);
                jSONObject.put(a(am.N), localeInfo[1]);
                jSONObject.put(a(am.P), DeviceConfig.getNetworkOperatorName(context));
                jSONObject.put(a(am.s), DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject.put(a(am.Q), "wifi");
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject.put(a(am.Q), "2G/3G");
                } else {
                    jSONObject.put(a(am.Q), "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject.put(a(am.R), networkAccessMode[1]);
                }
                if (DeviceConfig.isHarmony(context)) {
                    jSONObject.put(a(am.ao), "harmony");
                } else {
                    jSONObject.put(a(am.ao), "Android");
                }
                jSONObject.put(a("network_type"), DeviceConfig.getNetworkType(context));
                jSONObject.put(a(am.b), "9.5.2");
                jSONObject.put(a(am.f6998c), SdkVersion.SDK_TYPE);
                jSONObject.put(a(am.f6999d), "1");
                if (!TextUtils.isEmpty(a)) {
                    jSONObject.put(a(am.f7000e), a);
                }
                jSONObject.put(a(am.aj), Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject.put(a(am.af), UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        uUIDForZid = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject.put(a("session_id"), uUIDForZid);
                } catch (Throwable unused2) {
                }
                f7461i = jSONObject.toString();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONObject.put(a(am.ak), UMUtils.getOaidRequiredTime(context));
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put(a(am.U), sharedPreferences.getInt("successful_request", 0));
            jSONObject.put(a(am.V), sharedPreferences.getInt(am.V, 0));
            jSONObject.put(a(am.W), sharedPreferences.getInt("last_request_spent_ms", 0));
            String zid = UMUtils.getZid(context);
            if (!TextUtils.isEmpty(zid)) {
                jSONObject.put(a(am.al), zid);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                jSONObject.put(a(am.am), UMUtils.VALUE_ASMS_VERSION);
            }
        } catch (Exception unused4) {
        }
        jSONObject.put(a("channel"), UMUtils.getChannel(context));
        jSONObject.put(a("appkey"), UMUtils.getAppkey(context));
        try {
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject.put(a(am.a), deviceToken);
            }
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, am.f7002g, null);
            if (!TextUtils.isEmpty(imprintProperty)) {
                jSONObject.put(a(am.f7002g), imprintProperty);
            }
        } catch (Exception e3) {
            UMCrashManager.reportCrash(context, e3);
        }
        try {
            jSONObject.put(a("wrapper_type"), a.a);
            jSONObject.put(a("wrapper_version"), a.b);
        } catch (Exception unused5) {
        }
        try {
            int targetSdkVersion = UMUtils.getTargetSdkVersion(context);
            boolean checkPermission = UMUtils.checkPermission(context, PermissionConstants.PHONE_STATE);
            jSONObject.put(a(am.aV), targetSdkVersion);
            if (checkPermission) {
                jSONObject.put(a(am.aW), "yes");
            } else {
                jSONObject.put(a(am.aW), "no");
            }
        } catch (Throwable unused6) {
        }
        try {
            if (b()) {
                jSONObject.put("umTaskId", f7459g);
                jSONObject.put("umCaseId", f7460h);
            }
        } catch (Throwable unused7) {
        }
        if ((am.aI.equals(str) || am.av.equals(str)) && z) {
            try {
                int[] b2 = b(context);
                jSONObject.put(a(am.bp), String.valueOf(b2[0]) + String.valueOf(b2[1]) + String.valueOf(b2[2]));
            } catch (Throwable unused8) {
            }
        }
        try {
            Map<String, String> moduleTags = TagHelper.getModuleTags();
            if (moduleTags != null && moduleTags.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put(a(am.ap), jSONObject2);
            }
        } catch (Throwable unused9) {
        }
        try {
            String realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
            if (!TextUtils.isEmpty(realTimeDebugKey)) {
                jSONObject.put(a(am.bo), realTimeDebugKey);
            }
        } catch (Throwable unused10) {
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a(am.ba), com.umeng.commonsdk.internal.a.f7392e);
            if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
                jSONObject3.put(a(am.bb), UMUtils.VALUE_ANALYTICS_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
                jSONObject3.put(a(am.bc), UMUtils.VALUE_GAME_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
                jSONObject3.put(a(am.bd), UMUtils.VALUE_PUSH_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
                jSONObject3.put(a(am.be), UMUtils.VALUE_SHARE_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
                jSONObject3.put(a(am.bf), UMUtils.VALUE_APM_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
                jSONObject3.put(a(am.bg), UMUtils.VALUE_VERIFY_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
                jSONObject3.put(a(am.bh), UMUtils.VALUE_SMS_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                jSONObject3.put(a(am.bi), UMUtils.VALUE_REC_VERSION_NAME);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
                jSONObject3.put(a(am.bj), UMUtils.VALUE_VISUAL_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                jSONObject3.put(a(am.bk), UMUtils.VALUE_ASMS_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
                jSONObject3.put(a(am.bl), UMUtils.VALUE_LINK_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
                jSONObject3.put(a(am.bm), UMUtils.VALUE_ABTEST_VERSION);
            }
            jSONObject.put(a(am.aZ), jSONObject3);
        } catch (Throwable unused11) {
        }
        try {
            String apmFlag = UMUtils.getApmFlag();
            if (!TextUtils.isEmpty(apmFlag)) {
                jSONObject.put(a(am.bn), apmFlag);
            }
        } catch (Throwable unused12) {
        }
        byte[] a2 = ImprintHandler.getImprintService(context).a();
        if (a2 != null && a2.length > 0) {
            try {
                jSONObject.put(a(am.X), Base64.encodeToString(a2, 0));
            } catch (JSONException e4) {
                UMCrashManager.reportCrash(context, e4);
            }
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            return new JSONObject().put(a("header"), jSONObject);
        }
        return null;
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(a("header")) != null && (jSONObject.opt(a("header")) instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(a("header"));
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && (next instanceof String) && (str = next) != null && jSONObject2.opt(str) != null) {
                    try {
                        jSONObject3.put(str, jSONObject2.opt(str));
                        if (str.equals(a(d.f7137i)) && (jSONObject2.opt(str) instanceof Integer)) {
                            this.f7464k = ((Integer) jSONObject2.opt(str)).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i2 = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i2 = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (i2 == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (i2 == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (f7463l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String b2 = com.umeng.commonsdk.stateless.d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(b2);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith("h")) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        } else if (str.startsWith("h")) {
            return 122;
        } else {
            if (!str.startsWith(am.aD) && !str.startsWith("i") && !str.startsWith(am.av) && !str.startsWith(am.aI)) {
                return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f7437f, sb.toString(), binary);
            }
            return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
        }
    }

    public static void a(boolean z) {
        f7463l = z;
    }
}
