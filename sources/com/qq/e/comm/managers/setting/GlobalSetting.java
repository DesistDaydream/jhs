package com.qq.e.comm.managers.setting;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class GlobalSetting {
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String TT_SDK_WRAPPER = "TT";
    private static volatile Integer a = null;
    private static volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f5094c = true;

    /* renamed from: d  reason: collision with root package name */
    private static volatile Integer f5095d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile Boolean f5096e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile Boolean f5097f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile Boolean f5098g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile Map<String, String> f5099h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private static volatile Map<String, String> f5100i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private static final Map<String, String> f5101j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private static final JSONObject f5102k = new JSONObject();

    /* renamed from: l  reason: collision with root package name */
    private static volatile String f5103l = null;

    /* renamed from: m  reason: collision with root package name */
    private static volatile String f5104m = null;
    private static volatile String n = null;
    private static volatile String o = null;
    private static volatile String p = null;

    public static Boolean getAgreeReadAndroidId() {
        return f5098g;
    }

    public static Boolean getAgreeReadDeviceId() {
        return f5097f;
    }

    public static Integer getChannel() {
        return a;
    }

    public static String getCustomADActivityClassName() {
        return f5103l;
    }

    public static String getCustomLandscapeActivityClassName() {
        return o;
    }

    public static String getCustomPortraitActivityClassName() {
        return f5104m;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return p;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return n;
    }

    public static Map<String, String> getExtraUserData() {
        return Collections.unmodifiableMap(f5099h);
    }

    public static Integer getPersonalizedState() {
        return f5095d;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        return f5101j;
    }

    public static JSONObject getSettings() {
        return f5102k;
    }

    public static boolean isAgreePrivacyStrategy() {
        return f5096e == null || f5096e.booleanValue();
    }

    public static boolean isAgreeReadAndroidId() {
        if (f5098g == null) {
            return true;
        }
        return f5098g.booleanValue();
    }

    public static boolean isAgreeReadDeviceId() {
        if (f5097f == null) {
            return true;
        }
        return f5097f.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return b;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f5094c;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f5096e == null) {
            f5096e = Boolean.valueOf(z);
        }
    }

    public static void setAgreeReadAndroidId(boolean z) {
        f5098g = Boolean.valueOf(z);
    }

    public static void setAgreeReadDeviceId(boolean z) {
        f5097f = Boolean.valueOf(z);
    }

    public static void setChannel(int i2) {
        if (a == null) {
            a = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f5103l = str;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        o = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f5104m = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        p = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        n = str;
    }

    public static void setEnableCollectAppInstallStatus(boolean z) {
        try {
            f5102k.putOpt("ecais", Boolean.valueOf(z));
        } catch (JSONException unused) {
        }
    }

    public static void setEnableMediationTool(boolean z) {
        b = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f5094c = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void setExtraUserData(java.util.Map<java.lang.String, java.lang.String> r3) {
        /*
            if (r3 != 0) goto L3
            return
        L3:
            java.util.Set r0 = r3.entrySet()
            java.util.Iterator r0 = r0.iterator()
        Lb:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L35
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L2f
            java.lang.Object r1 = r1.getValue()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto Lb
        L2f:
            java.lang.String r3 = "参数key和value不能为空！"
            com.qq.e.comm.util.GDTLogger.e(r3)
            return
        L35:
            com.qq.e.comm.managers.setting.GlobalSetting.f5099h = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.setting.GlobalSetting.setExtraUserData(java.util.Map):void");
    }

    public static void setMediaExtData(Map<String, String> map, boolean z) {
        if (map == null) {
            return;
        }
        if (z) {
            f5100i = new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                f5100i.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            f5102k.putOpt("media_ext", new JSONObject(f5100i));
        } catch (JSONException unused) {
            GDTLogger.e("setMediaExtData失败，请检查");
        }
    }

    public static void setPersonalizedState(int i2) {
        f5095d = Integer.valueOf(i2);
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        f5101j.putAll(map);
    }
}
