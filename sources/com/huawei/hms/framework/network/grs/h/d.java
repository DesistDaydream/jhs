package com.huawei.hms.framework.network.grs.h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class d {
    private static final Map<String, a> a = new ConcurrentHashMap(16);

    /* loaded from: classes2.dex */
    public static class a {
        private final long a;
        private final long b;

        public a(long j2, long j3) {
            this.a = j2;
            this.b = j3;
        }

        public boolean a() {
            return SystemClock.elapsedRealtime() - this.b <= this.a;
        }
    }

    public static a a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("map size of get is before:");
        Map<String, a> map = a;
        sb.append(map.size());
        Logger.v("RequestUtil", sb.toString());
        a aVar = map.get(str);
        Logger.v("RequestUtil", "map size of get is after:" + map.size());
        return aVar;
    }

    public static void a(String str, a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("map size of put is before:");
        Map<String, a> map = a;
        sb.append(map.size());
        Logger.v("RequestUtil", sb.toString());
        map.put(str, aVar);
        Logger.v("RequestUtil", "map size of put is after:" + map.size());
    }
}
