package com.tencent.tpns.dataacquisition;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.util.Log;
import com.tencent.tpns.reflecttools.Reflect;
import com.tencent.tpns.reflecttools.ReflectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CustomDeviceInfos {
    private static final String DEVICEINFOS_REAL_CLASSNAME = "com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos";
    private static boolean isWarned = false;
    private static Boolean ismportImplClassFlag;

    public static String getAndroidId(Context context) {
        try {
            return (String) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getAndroidId", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return "";
        }
    }

    public static List<PackageInfo> getAppPackages(Context context) {
        try {
            return (List) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getAppPackages", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return new ArrayList();
        }
    }

    public static String getFacilityIdentity(Context context) {
        try {
            return (String) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getFacilityIdentity", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return "";
        }
    }

    public static String getFacilityMacAddr(Context context) {
        try {
            return (String) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getFacilityMacAddr", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return "";
        }
    }

    public static String getImsi(Context context) {
        try {
            return (String) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getImsi", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return "";
        }
    }

    public static String getIp(Context context) {
        try {
            return (String) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getIp", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return "";
        }
    }

    public static Map<String, Integer> getRecentTasks(Context context) {
        try {
            return (Map) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getRecentTasks", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return new HashMap();
        }
    }

    public static JSONObject getReportLocationJson(Context context) {
        try {
            return (JSONObject) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getReportLocationJson", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return null;
        }
    }

    public static Map<String, ActivityManager.RunningAppProcessInfo> getRunningAppProces(Context context) {
        try {
            return (Map) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getRunningAppProces", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return new HashMap();
        }
    }

    public static Map<String, Integer> getRunningProcess(Context context) {
        try {
            return (Map) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getRunningProcess", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return new HashMap();
        }
    }

    public static String getSimOperator(Context context) {
        try {
            return (String) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getSimOperator", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return "";
        }
    }

    public static String getWiFiBBSID(Context context) {
        try {
            return (String) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getWiFiBBSID", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return "";
        }
    }

    public static String getWiFiSSID(Context context) {
        try {
            return (String) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getWiFiSSID", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return "";
        }
    }

    public static WifiInfo getWifiInfo(Context context) {
        try {
            return (WifiInfo) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getWifiInfo", context).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return null;
        }
    }

    public static JSONArray getWifiTopN(Context context, int i2) {
        try {
            return (JSONArray) Reflect.on(DEVICEINFOS_REAL_CLASSNAME).call("getWifiTopN", context, Integer.valueOf(i2)).get();
        } catch (ReflectException e2) {
            showWarnMessage(e2);
            return null;
        }
    }

    public static boolean isImportImplClass() {
        Boolean bool = ismportImplClassFlag;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Reflect.on(DEVICEINFOS_REAL_CLASSNAME);
            ismportImplClassFlag = Boolean.TRUE;
        } catch (ReflectException unused) {
            Log.w("TPush-DataAcq", "isImportImplClass false");
            ismportImplClassFlag = Boolean.FALSE;
        }
        return ismportImplClassFlag.booleanValue();
    }

    private static void showWarnMessage(ReflectException reflectException) {
        if (isWarned) {
            return;
        }
        isWarned = true;
    }
}
