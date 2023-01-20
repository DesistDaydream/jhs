package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.push.fn;
import com.xiaomi.push.jm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class ct {
    private static final Map<String, byte[]> a = new HashMap();
    private static ArrayList<Pair<String, byte[]>> b = new ArrayList<>();

    public static void a(Context context, int i2, String str) {
        Map<String, byte[]> map = a;
        synchronized (map) {
            for (String str2 : map.keySet()) {
                com.xiaomi.a.a.a.c.a("notify registration error. " + str2);
                a(context, str2, a.get(str2), i2, str);
            }
            a.clear();
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i2, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i2);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, j.a(str));
    }

    public static void a(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (b) {
                arrayList = b;
                b = new ArrayList<>();
            }
            boolean a2 = jm.a();
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, byte[]> next = it.next();
                j.a(xMPushService, (String) next.first, (byte[]) next.second);
                if (!a2) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (fn e2) {
            com.xiaomi.a.a.a.c.d("meet error when process pending message. " + e2);
            xMPushService.a(10, e2);
        }
    }

    public static void a(XMPushService xMPushService, boolean z) {
        try {
            Map<String, byte[]> map = a;
            synchronized (map) {
                for (String str : map.keySet()) {
                    com.xiaomi.a.a.a.c.a("processing pending registration request. " + str);
                    j.a(xMPushService, str, a.get(str));
                    if (z && !jm.a()) {
                        try {
                            Thread.sleep(200L);
                        } catch (Exception unused) {
                        }
                    }
                }
                a.clear();
            }
        } catch (fn e2) {
            com.xiaomi.a.a.a.c.d("fail to deal with pending register request. " + e2);
            xMPushService.a(10, e2);
        }
    }

    public static void a(String str, byte[] bArr) {
        Map<String, byte[]> map = a;
        synchronized (map) {
            com.xiaomi.a.a.a.c.a("pending registration request. " + str);
            map.put(str, bArr);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (b) {
            b.add(new Pair<>(str, bArr));
            if (b.size() > 50) {
                b.remove(0);
            }
        }
    }
}
