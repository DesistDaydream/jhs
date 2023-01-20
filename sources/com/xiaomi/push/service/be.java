package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.gu;
import com.xiaomi.push.hh;
import com.xiaomi.push.ib;
import com.xiaomi.push.jh;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class be {
    public static final Object a = new Object();
    public static ArrayList<gu> b = new ArrayList<>();

    public static void a() {
        b.clear();
    }

    public static void a(Context context, gu guVar) {
        if (bc.a(guVar.q())) {
            com.xiaomi.push.m.a(context).a(new bf(context, guVar));
        }
    }

    public static void a(gu guVar) {
        if (b.size() > 10) {
            b.remove(0);
        }
        b.add(guVar);
    }

    public static byte[] a(Context context) {
        String b2 = jh.a(context).b("mipush", "td_key", "");
        if (TextUtils.isEmpty(b2)) {
            b2 = com.xiaomi.push.ar.a(20);
            jh.a(context).a("mipush", "td_key", b2);
        }
        return a(b2);
    }

    private static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(com.xiaomi.push.ao.b(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    public static void c(Context context, gu guVar) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        String str;
        String str2;
        BufferedOutputStream a2 = a(context);
        try {
            try {
                byte[] b2 = hh.b(a2, ib.a(guVar));
                if (b2 != null && b2.length >= 1) {
                    if (b2.length > 10240) {
                        str2 = "TinyData write to cache file failed case too much data content item:" + guVar.m() + "  ts:" + System.currentTimeMillis();
                        com.xiaomi.a.a.a.c.a(str2);
                        com.xiaomi.push.c.a((Closeable) null);
                        com.xiaomi.push.c.a((Closeable) null);
                    }
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream3.write(com.xiaomi.push.g.a(b2.length));
                        bufferedOutputStream3.write(b2);
                        bufferedOutputStream3.flush();
                        com.xiaomi.push.c.a((Closeable) null);
                        com.xiaomi.push.c.a(bufferedOutputStream3);
                        return;
                    } catch (IOException e2) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        e = e2;
                        str = "TinyData write to cache file failed cause io exception item:" + guVar.m();
                        a2 = bufferedOutputStream2;
                        com.xiaomi.a.a.a.c.a(str, e);
                        com.xiaomi.push.c.a((Closeable) null);
                        com.xiaomi.push.c.a((Closeable) a2);
                        return;
                    } catch (Exception e3) {
                        bufferedOutputStream = bufferedOutputStream3;
                        e = e3;
                        str = "TinyData write to cache file  failed item:" + guVar.m();
                        a2 = bufferedOutputStream;
                        com.xiaomi.a.a.a.c.a(str, e);
                        com.xiaomi.push.c.a((Closeable) null);
                        com.xiaomi.push.c.a((Closeable) a2);
                        return;
                    } catch (Throwable th) {
                        a2 = bufferedOutputStream3;
                        th = th;
                        com.xiaomi.push.c.a((Closeable) null);
                        com.xiaomi.push.c.a(a2);
                        throw th;
                    }
                }
                str2 = "TinyData write to cache file failed case encryption fail item:" + guVar.m() + "  ts:" + System.currentTimeMillis();
                com.xiaomi.a.a.a.c.a(str2);
                com.xiaomi.push.c.a((Closeable) null);
                com.xiaomi.push.c.a((Closeable) null);
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream2 = null;
            } catch (Exception e5) {
                e = e5;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                a2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
