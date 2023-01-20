package com.meizu.cloud.pushsdk.c.c;

import android.net.TrafficStats;
import com.meizu.cloud.pushsdk.c.c.k;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.qiniu.android.http.request.Request;
import com.ss.android.download.api.constant.BaseConstants;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes2.dex */
public class e implements a {
    private static l a(final HttpURLConnection httpURLConnection) {
        if (httpURLConnection.getDoInput()) {
            final com.meizu.cloud.pushsdk.c.g.d a = com.meizu.cloud.pushsdk.c.g.g.a(com.meizu.cloud.pushsdk.c.g.g.a(a(httpURLConnection.getResponseCode()) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()));
            return new l() { // from class: com.meizu.cloud.pushsdk.c.c.e.1
                @Override // com.meizu.cloud.pushsdk.c.c.l
                public com.meizu.cloud.pushsdk.c.g.d a() {
                    return a;
                }
            };
        }
        return null;
    }

    private static void a(HttpURLConnection httpURLConnection, i iVar) {
        String str;
        String str2;
        int c2 = iVar.c();
        if (c2 != 0) {
            if (c2 == 1) {
                str2 = "POST";
            } else if (c2 == 2) {
                str2 = Request.HttpMethodPUT;
            } else if (c2 == 3) {
                str = "DELETE";
            } else if (c2 == 4) {
                str = Request.HttpMethodHEAD;
            } else if (c2 != 5) {
                throw new IllegalStateException("Unknown method type.");
            } else {
                str2 = "PATCH";
            }
            httpURLConnection.setRequestMethod(str2);
            b(httpURLConnection, iVar);
            return;
        }
        str = "GET";
        httpURLConnection.setRequestMethod(str);
    }

    public static boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    private HttpURLConnection b(i iVar) {
        URL url = new URL(iVar.a().toString());
        if (MinSdkChecker.isSupportNotificationChannel()) {
            TrafficStats.setThreadStatsTag(2006537699);
        }
        HttpURLConnection a = a(url);
        a.setConnectTimeout(BaseConstants.Time.MINUTE);
        a.setReadTimeout(BaseConstants.Time.MINUTE);
        a.setUseCaches(false);
        a.setDoInput(true);
        return a;
    }

    private static void b(HttpURLConnection httpURLConnection, i iVar) {
        j e2 = iVar.e();
        if (e2 != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", e2.a().toString());
            com.meizu.cloud.pushsdk.c.g.c a = com.meizu.cloud.pushsdk.c.g.g.a(com.meizu.cloud.pushsdk.c.g.g.a(httpURLConnection.getOutputStream()));
            e2.a(a);
            a.close();
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.c.a
    public k a(i iVar) {
        HttpURLConnection b = b(iVar);
        for (String str : iVar.d().b()) {
            String a = iVar.a(str);
            com.meizu.cloud.pushsdk.c.a.a.b("current header name " + str + " value " + a);
            b.addRequestProperty(str, a);
        }
        a(b, iVar);
        int responseCode = b.getResponseCode();
        return new k.a().a(responseCode).a(iVar.d()).a(b.getResponseMessage()).a(iVar).a(a(b)).a();
    }

    public HttpURLConnection a(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }
}
