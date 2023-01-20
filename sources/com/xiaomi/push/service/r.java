package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.push.da;
import com.xiaomi.push.em;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class r {
    private static final Pattern a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
    private static long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static ThreadPoolExecutor f9193c = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static void a() {
        da.a d2;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f9193c.getActiveCount() <= 0 || currentTimeMillis - b >= 1800000) && em.a().c() && (d2 = ay.a().d()) != null && d2.j() > 0) {
            b = currentTimeMillis;
            a(d2.i(), true);
        }
    }

    public static void a(List<String> list, boolean z) {
        f9193c.execute(new s(list, z));
    }

    public static void b() {
        String c2 = c("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(c2)) {
            com.xiaomi.a.a.a.c.a("dump tcp for uid = " + Process.myUid());
            com.xiaomi.a.a.a.c.a(c2);
        }
        String c3 = c("/proc/self/net/tcp6");
        if (TextUtils.isEmpty(c3)) {
            return;
        }
        com.xiaomi.a.a.a.c.a("dump tcp6 for uid = " + Process.myUid());
        com.xiaomi.a.a.a.c.a(c3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            com.xiaomi.a.a.a.c.a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(com.xiaomi.push.bw.b(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.xiaomi.a.a.a.c.a("ConnectivityTest: connect to " + str + " in " + currentTimeMillis2);
            socket.close();
            return true;
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }

    private static String c(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    String sb2 = sb.toString();
                    com.xiaomi.push.c.a(bufferedReader);
                    return sb2;
                }
                sb.append("\n");
                sb.append(readLine);
            }
        } catch (Exception unused2) {
            com.xiaomi.push.c.a(bufferedReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            com.xiaomi.push.c.a(bufferedReader);
            throw th;
        }
    }
}
