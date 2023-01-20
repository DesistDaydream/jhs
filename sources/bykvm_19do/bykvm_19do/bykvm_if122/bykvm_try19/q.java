package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class q {
    private static boolean a = true;
    private static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f1024c = true;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f1025d = true;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f1026e = true;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f1027f;

    /* renamed from: g  reason: collision with root package name */
    private static final Map<Integer, Map<String, List<List<String>>>> f1028g = new HashMap();

    public static void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        if (optJSONArray != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                int optInt = jSONObject2.optInt("rit_type");
                                JSONArray optJSONArray2 = jSONObject2.optJSONArray("adn_features");
                                if (optJSONArray2 != null) {
                                    ArrayList arrayList = new ArrayList();
                                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                        JSONArray jSONArray = optJSONArray2.getJSONArray(i3);
                                        if (jSONArray != null) {
                                            ArrayList arrayList2 = new ArrayList();
                                            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                                String string = jSONArray.getString(i4);
                                                if (!TextUtils.isEmpty(string)) {
                                                    arrayList2.add(string);
                                                }
                                            }
                                            arrayList.add(arrayList2);
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put(next, arrayList);
                                        f1028g.put(Integer.valueOf(optInt), hashMap);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                Logger.d("TMe", "supervisorFeature error: " + e2.toString());
                e2.printStackTrace();
                return;
            }
        }
        Logger.d("TMe", "--==-- adn features:" + f1028g);
    }

    public static void a(boolean z) {
        f1027f = z;
    }

    public static boolean a() {
        return f1027f;
    }

    public static boolean a(StackTraceElement[] stackTraceElementArr) {
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0 || (map = f1028g.get(8)) == null || (list = map.get("pangle")) == null || list.size() <= 1) {
            return true;
        }
        return a(stackTraceElementArr, list);
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr, int i2, List<String> list) {
        int i3;
        for (int i4 = 0; i4 < list.size(); i4++) {
            String str = list.get(i4);
            if (TextUtils.isEmpty(str) || (i3 = i2 + i4) >= stackTraceElementArr.length) {
                return false;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i3];
            if (stackTraceElement != null) {
                String stackTraceElement2 = stackTraceElement.toString();
                if (TextUtils.isEmpty(stackTraceElement2) || !stackTraceElement2.contains(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr, List<List<String>> list) {
        for (List<String> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                for (int i2 = 0; i2 < stackTraceElementArr.length; i2++) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                    if (stackTraceElement != null) {
                        String stackTraceElement2 = stackTraceElement.toString();
                        if (!TextUtils.isEmpty(stackTraceElement2) && stackTraceElement2.contains(list2.get(0)) && (list2.size() == 1 || a(stackTraceElementArr, i2, list2))) {
                            return true;
                        }
                    }
                }
                continue;
            }
        }
        return false;
    }

    public static boolean b() {
        if (f1026e) {
            f1026e = false;
            return true;
        }
        return false;
    }

    public static boolean b(StackTraceElement[] stackTraceElementArr) {
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0 || (map = f1028g.get(7)) == null || (list = map.get("pangle")) == null || list.size() <= 1) {
            return true;
        }
        return a(stackTraceElementArr, list);
    }

    public static boolean c() {
        if (f1025d) {
            f1025d = false;
            return true;
        }
        return false;
    }

    public static boolean d() {
        if (b) {
            b = false;
            return true;
        }
        return false;
    }

    public static boolean e() {
        if (a) {
            a = false;
            return true;
        }
        return false;
    }

    public static boolean f() {
        if (f1024c) {
            f1024c = false;
            return true;
        }
        return false;
    }
}
