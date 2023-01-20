package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: j  reason: collision with root package name */
    private static volatile b f9114j;
    private final Object a = new Object();
    private final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final String f9115c = "mipush_region";

    /* renamed from: d  reason: collision with root package name */
    private final String f9116d = "mipush_country_code";

    /* renamed from: e  reason: collision with root package name */
    private final String f9117e = "mipush_region.lock";

    /* renamed from: f  reason: collision with root package name */
    private final String f9118f = "mipush_country_code.lock";

    /* renamed from: g  reason: collision with root package name */
    private volatile String f9119g;

    /* renamed from: h  reason: collision with root package name */
    private volatile String f9120h;

    /* renamed from: i  reason: collision with root package name */
    private Context f9121i;

    public b(Context context) {
        this.f9121i = context;
    }

    public static b a(Context context) {
        if (f9114j == null) {
            synchronized (b.class) {
                if (f9114j == null) {
                    f9114j = new b(context);
                }
            }
        }
        return f9114j;
    }

    private String a(Context context, String str, String str2, Object obj) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock2 = null;
        if (!file.exists()) {
            com.xiaomi.a.a.a.c.a("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                com.xiaomi.push.c.b(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                } catch (Exception e2) {
                    e = e2;
                    fileLock = null;
                } catch (Throwable th) {
                    th = th;
                    if (fileLock2 != null) {
                        try {
                            fileLock2.release();
                        } catch (IOException e3) {
                            com.xiaomi.a.a.a.c.a(e3);
                        }
                    }
                    com.xiaomi.push.c.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
                fileLock = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
            }
            try {
                try {
                    String a = com.xiaomi.push.c.a(file);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            com.xiaomi.a.a.a.c.a(e5);
                        }
                    }
                    com.xiaomi.push.c.a(randomAccessFile);
                    return a;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock2 = fileLock;
                    if (fileLock2 != null && fileLock2.isValid()) {
                        fileLock2.release();
                    }
                    com.xiaomi.push.c.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                com.xiaomi.a.a.a.c.a(e);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e7) {
                        com.xiaomi.a.a.a.c.a(e7);
                    }
                }
                com.xiaomi.push.c.a(randomAccessFile);
                return null;
            }
        }
    }

    private void a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getFilesDir(), str3);
                    com.xiaomi.push.c.b(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (Exception e2) {
                    e = e2;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = null;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            com.xiaomi.a.a.a.c.a(e3);
                        }
                    }
                    com.xiaomi.push.c.a(randomAccessFile);
                    throw th;
                }
                try {
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        com.xiaomi.push.c.a(new File(context.getFilesDir(), str2), str);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                com.xiaomi.a.a.a.c.a(e4);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileLock != null && fileLock.isValid()) {
                            fileLock.release();
                        }
                        com.xiaomi.push.c.a(randomAccessFile);
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    com.xiaomi.a.a.a.c.a(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e6) {
                            com.xiaomi.a.a.a.c.a(e6);
                        }
                    }
                    com.xiaomi.push.c.a(randomAccessFile);
                }
                com.xiaomi.push.c.a(randomAccessFile);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f9119g)) {
            this.f9119g = a(this.f9121i, "mipush_region", "mipush_region.lock", this.a);
        }
        return this.f9119g;
    }

    public void a(String str) {
        if (TextUtils.equals(str, this.f9119g)) {
            return;
        }
        this.f9119g = str;
        a(this.f9121i, this.f9119g, "mipush_region", "mipush_region.lock", this.a);
    }

    public String b() {
        if (TextUtils.isEmpty(this.f9120h)) {
            this.f9120h = a(this.f9121i, "mipush_country_code", "mipush_country_code.lock", this.b);
        }
        return this.f9120h;
    }

    public void b(String str) {
        if (TextUtils.equals(str, this.f9120h)) {
            return;
        }
        this.f9120h = str;
        a(this.f9121i, this.f9120h, "mipush_country_code", "mipush_country_code.lock", this.b);
    }
}
