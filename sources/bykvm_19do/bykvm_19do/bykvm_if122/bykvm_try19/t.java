package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class t {
    private static final HashSet a = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace"));

    public static String a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : map.keySet()) {
            if (a(map.get(str))) {
                jSONArray.put(str);
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray.toString();
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                if (!a.contains(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) {
                    String className = stackTraceElement.getClassName();
                    if (className != null && className.startsWith("android.app")) {
                        break;
                    }
                    jSONArray.put(stackTraceElement.toString());
                } else {
                    continue;
                }
            }
        }
        return jSONArray.toString();
    }

    public static boolean a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar) {
        return jVar != null && jVar.B() && jVar.C();
    }

    public static boolean a(TTBaseAd tTBaseAd) {
        return tTBaseAd != null && tTBaseAd.isClientBiddingAd() && tTBaseAd.isCustomAd();
    }

    private static boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (Class.forName(str) != null) {
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    private static boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (list.get(i2) != null && stackTraceElement.toString().contains(list.get(i2))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static String b(StackTraceElement[] stackTraceElementArr) {
        Map<String, List<String>> g2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().g();
        if (g2 != null && !g2.isEmpty()) {
            for (String str : g2.keySet()) {
                if (a(g2.get(str), stackTraceElementArr)) {
                    return str;
                }
            }
        }
        return null;
    }
}
