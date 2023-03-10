package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class e {

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ ArrayList b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f3511c;

        public a(long j2, ArrayList arrayList, JSONArray jSONArray) {
            this.a = j2;
            this.b = arrayList;
            this.f3511c = jSONArray;
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x001a  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r6 = this;
                com.huawei.hms.framework.network.grs.g.k.a r0 = new com.huawei.hms.framework.network.grs.g.k.a
                r0.<init>()
                long r1 = r6.a
                java.lang.String r3 = "total_time"
                r0.put(r3, r1)
                java.util.ArrayList r1 = r6.b
                java.util.Iterator r1 = r1.iterator()
            L12:
                boolean r2 = r1.hasNext()
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L38
                java.lang.Object r2 = r1.next()
                com.huawei.hms.framework.network.grs.g.d r2 = (com.huawei.hms.framework.network.grs.g.d) r2
                boolean r5 = r2.o()
                if (r5 != 0) goto L2c
                boolean r5 = r2.m()
                if (r5 == 0) goto L12
            L2c:
                java.util.LinkedHashMap r2 = com.huawei.hms.framework.network.grs.g.e.a(r2)
                r0.put(r2)
                r1.remove()
                r1 = 1
                goto L39
            L38:
                r1 = 0
            L39:
                if (r1 != 0) goto L5c
                java.util.ArrayList r1 = r6.b
                int r1 = r1.size()
                if (r1 <= 0) goto L5c
                java.util.ArrayList r1 = r6.b
                int r2 = r1.size()
                int r2 = r2 - r4
                java.lang.Object r1 = r1.get(r2)
                com.huawei.hms.framework.network.grs.g.d r1 = (com.huawei.hms.framework.network.grs.g.d) r1
                java.util.LinkedHashMap r2 = com.huawei.hms.framework.network.grs.g.e.a(r1)
                r0.put(r2)
                java.util.ArrayList r2 = r6.b
                r2.remove(r1)
            L5c:
                java.util.ArrayList r1 = r6.b
                int r1 = r1.size()
                if (r1 <= 0) goto L85
                java.util.ArrayList r1 = r6.b
                java.util.Iterator r1 = r1.iterator()
            L6a:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L85
                java.lang.Object r2 = r1.next()
                com.huawei.hms.framework.network.grs.g.d r2 = (com.huawei.hms.framework.network.grs.g.d) r2
                org.json.JSONObject r5 = new org.json.JSONObject
                java.util.LinkedHashMap r2 = com.huawei.hms.framework.network.grs.g.e.a(r2)
                r5.<init>(r2)
                org.json.JSONArray r2 = r6.f3511c
                r2.put(r5)
                goto L6a
            L85:
                org.json.JSONArray r1 = r6.f3511c
                int r1 = r1.length()
                if (r1 <= 0) goto L98
                org.json.JSONArray r1 = r6.f3511c
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "failed_info"
                r0.put(r2, r1)
            L98:
                java.lang.Object[] r1 = new java.lang.Object[r4]
                org.json.JSONObject r2 = new org.json.JSONObject
                java.util.LinkedHashMap r4 = r0.get()
                r2.<init>(r4)
                r1[r3] = r2
                java.lang.String r2 = "HaReportHelper"
                java.lang.String r3 = "grssdk report data to aiops is: %s"
                com.huawei.hms.framework.common.Logger.d(r2, r3, r1)
                com.huawei.hms.framework.common.hianalytics.HianalyticsHelper r1 = com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.getInstance()
                java.util.LinkedHashMap r0 = r0.get()
                java.lang.String r2 = "grs_request"
                r1.onEvent(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.e.a.run():void");
        }
    }

    public static void a(ArrayList<d> arrayList, long j2, JSONArray jSONArray, Context context) {
        if (context == null || arrayList == null || arrayList.size() <= 0 || !HianalyticsHelper.getInstance().isEnableReportNoSeed(context)) {
            return;
        }
        HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j2, arrayList, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedHashMap<String, String> b(d dVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception d2 = dVar.d();
        if (d2 != null) {
            linkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(d2));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, d2.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(d2.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", dVar.b());
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, dVar.c());
        }
        try {
            linkedHashMapPack.put("domain", new URL(dVar.l()).getHost());
        } catch (MalformedURLException e2) {
            Logger.w("HaReportHelper", "report host MalformedURLException", e2);
        }
        linkedHashMapPack.put("req_start_time", dVar.h());
        linkedHashMapPack.put("req_end_time", dVar.g());
        linkedHashMapPack.put("req_total_time", dVar.i());
        return linkedHashMapPack.getAll();
    }
}
