package com.baidu.mobads.sdk.internal;

import com.huawei.hms.framework.common.ContainerUtils;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes.dex */
public class cg {
    private static volatile cg a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1576c;

    private cg() {
    }

    public static cg a() {
        if (a == null) {
            synchronized (cg.class) {
                if (a == null) {
                    a = new cg();
                }
            }
        }
        return a;
    }

    public boolean b() {
        return this.f1576c;
    }

    public String c(String str) {
        return (this.b && a(str).booleanValue()) ? str.replaceFirst("(?i)http", "https") : str;
    }

    public Boolean d(String str) {
        return Boolean.valueOf(a(str, "sms:").booleanValue() || a(str, "smsto:").booleanValue() || a(str, "mms:").booleanValue());
    }

    public String e(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException unused) {
            return "";
        }
    }

    public String f(String str) {
        if (str == null) {
            return null;
        }
        return (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public String g(String str) {
        if (str == null) {
            return null;
        }
        String[] split = (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?") : null;
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public void h(String str) {
        new ak(str).b();
    }

    public void b(boolean z) {
        this.b = z;
    }

    public Boolean b(String str) {
        return a(str, "https:");
    }

    public void a(boolean z) {
        this.f1576c = z;
    }

    public Boolean a(String str) {
        return a(str, "http:");
    }

    private Boolean a(String str, String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public HttpURLConnection a(URL url) {
        if (url.getProtocol().toLowerCase().equals("https")) {
            return (HttpsURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    public String a(String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder(str);
        if (hashMap != null && !hashMap.isEmpty()) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                try {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                } catch (Exception e2) {
                    bj.a().c(e2);
                }
            }
            String sb2 = sb.toString();
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb.toString();
    }

    public void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (Throwable unused) {
            }
            try {
                httpURLConnection.getOutputStream().close();
            } catch (Throwable unused2) {
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
        }
    }
}
