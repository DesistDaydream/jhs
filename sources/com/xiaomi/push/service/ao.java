package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.by;
import com.xiaomi.push.da;
import com.xiaomi.push.db;
import com.xiaomi.push.ed;
import com.xiaomi.push.em;
import com.xiaomi.push.eo;
import com.xiaomi.push.fb;
import com.xiaomi.push.ge;
import com.xiaomi.push.jl;
import com.xiaomi.push.service.ay;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ao extends ay.a implements by.a {
    private XMPushService a;
    private long b;

    /* loaded from: classes3.dex */
    public static class a implements by.b {
        @Override // com.xiaomi.push.by.b
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(48));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter(com.umeng.analytics.pro.am.x, ge.a(Build.MODEL + Constants.COLON_SEPARATOR + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(jl.b()));
            String builder = buildUpon.toString();
            com.xiaomi.a.a.a.c.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = com.xiaomi.push.al.a(jl.a(), url);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                eo.a(url.getHost() + Constants.COLON_SEPARATOR + port, (int) currentTimeMillis2, null);
                return a;
            } catch (IOException e2) {
                eo.a(url.getHost() + Constants.COLON_SEPARATOR + port, -1, e2);
                throw e2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends com.xiaomi.push.by {
        public b(Context context, com.xiaomi.push.bx bxVar, by.b bVar, String str) {
            super(context, bxVar, bVar, str);
        }

        @Override // com.xiaomi.push.by
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (em.a().c()) {
                    str2 = ay.e();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e2) {
                eo.a(0, ed.GSLB_ERR.a(), 1, null, com.xiaomi.push.al.d(com.xiaomi.push.by.f8310c) ? 1 : 0);
                throw e2;
            }
        }
    }

    public ao(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        ao aoVar = new ao(xMPushService);
        ay.a().a(aoVar);
        synchronized (com.xiaomi.push.by.class) {
            com.xiaomi.push.by.a(aoVar);
            com.xiaomi.push.by.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.by.a
    public com.xiaomi.push.by a(Context context, com.xiaomi.push.bx bxVar, by.b bVar, String str) {
        return new b(context, bxVar, bVar, str);
    }

    @Override // com.xiaomi.push.service.ay.a
    public void a(da.a aVar) {
    }

    @Override // com.xiaomi.push.service.ay.a
    public void a(db.b bVar) {
        com.xiaomi.push.bu b2;
        if (bVar.b() && bVar.a() && System.currentTimeMillis() - this.b > com.heytap.mcssdk.constant.a.f3315e) {
            com.xiaomi.a.a.a.c.a("fetch bucket :" + bVar.a());
            this.b = System.currentTimeMillis();
            com.xiaomi.push.by a2 = com.xiaomi.push.by.a();
            a2.d();
            a2.f();
            fb h2 = this.a.h();
            if (h2 == null || (b2 = a2.b(h2.d().e())) == null) {
                return;
            }
            ArrayList<String> d2 = b2.d();
            boolean z = true;
            Iterator<String> it = d2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(h2.e())) {
                    z = false;
                    break;
                }
            }
            if (!z || d2.isEmpty()) {
                return;
            }
            com.xiaomi.a.a.a.c.a("bucket changed, force reconnect");
            this.a.a(0, (Exception) null);
            this.a.a(false);
        }
    }
}
