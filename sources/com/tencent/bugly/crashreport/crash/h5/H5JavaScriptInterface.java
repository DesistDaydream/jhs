package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.y;
import com.umeng.analytics.pro.am;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class H5JavaScriptInterface {
    private static HashSet<Integer> a = new HashSet<>();
    private String b = null;

    /* renamed from: c  reason: collision with root package name */
    private Thread f6630c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f6631d = null;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f6632e = null;

    private H5JavaScriptInterface() {
    }

    private static a a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a();
                String string2 = jSONObject.getString("projectRoot");
                aVar.a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString("context");
                aVar.b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("url");
                aVar.f6633c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString(TTDownloadField.TT_USERAGENT);
                aVar.f6634d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString(am.N);
                aVar.f6635e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                aVar.f6636f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf("\n");
                if (indexOf < 0) {
                    y.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                aVar.f6638h = string.substring(indexOf + 1);
                String substring = string.substring(0, indexOf);
                aVar.f6637g = substring;
                int indexOf2 = substring.indexOf(Constants.COLON_SEPARATOR);
                if (indexOf2 > 0) {
                    aVar.f6637g = aVar.f6637g.substring(indexOf2 + 1);
                }
                aVar.f6639i = jSONObject.getString("file");
                if (aVar.f6636f == null) {
                    return null;
                }
                long j2 = jSONObject.getLong("lineNumber");
                aVar.f6640j = j2;
                if (j2 < 0) {
                    return null;
                }
                long j3 = jSONObject.getLong("columnNumber");
                aVar.f6641k = j3;
                if (j3 < 0) {
                    return null;
                }
                y.a("H5 crash information is following: ", new Object[0]);
                y.a("[projectRoot]: " + aVar.a, new Object[0]);
                y.a("[context]: " + aVar.b, new Object[0]);
                y.a("[url]: " + aVar.f6633c, new Object[0]);
                y.a("[userAgent]: " + aVar.f6634d, new Object[0]);
                y.a("[language]: " + aVar.f6635e, new Object[0]);
                y.a("[name]: " + aVar.f6636f, new Object[0]);
                y.a("[message]: " + aVar.f6637g, new Object[0]);
                y.a("[stacktrace]: \n" + aVar.f6638h, new Object[0]);
                y.a("[file]: " + aVar.f6639i, new Object[0]);
                y.a("[lineNumber]: " + aVar.f6640j, new Object[0]);
                y.a("[columnNumber]: " + aVar.f6641k, new Object[0]);
                return aVar;
            } catch (Throwable th) {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        String str = null;
        if (webViewInterface == null || a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        a.add(Integer.valueOf(webViewInterface.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.f6630c = currentThread;
        if (currentThread != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (int i2 = 2; i2 < currentThread.getStackTrace().length; i2++) {
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[i2];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
            str = sb.toString();
        }
        h5JavaScriptInterface.f6631d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) webViewInterface.getContentDescription());
        hashMap.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.f6632e = hashMap;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        y.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            y.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String a2 = ab.a(str.getBytes());
        String str2 = this.b;
        if (str2 != null && str2.equals(a2)) {
            y.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.b = a2;
        y.d("Handling JS exception ...", new Object[0]);
        a a3 = a(str);
        if (a3 == null) {
            y.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str3 = a3.a;
        if (str3 != null) {
            linkedHashMap2.put("[JS] projectRoot", str3);
        }
        String str4 = a3.b;
        if (str4 != null) {
            linkedHashMap2.put("[JS] context", str4);
        }
        String str5 = a3.f6633c;
        if (str5 != null) {
            linkedHashMap2.put("[JS] url", str5);
        }
        String str6 = a3.f6634d;
        if (str6 != null) {
            linkedHashMap2.put("[JS] userAgent", str6);
        }
        String str7 = a3.f6639i;
        if (str7 != null) {
            linkedHashMap2.put("[JS] file", str7);
        }
        long j2 = a3.f6640j;
        if (j2 != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(j2));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f6632e);
        linkedHashMap.put("Java Stack", this.f6631d);
        Thread thread = this.f6630c;
        if (a3 != null) {
            InnerApi.postH5CrashAsync(thread, a3.f6636f, a3.f6637g, a3.f6638h, linkedHashMap);
        }
    }
}
