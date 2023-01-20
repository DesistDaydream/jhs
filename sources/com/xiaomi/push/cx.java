package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.m;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: classes3.dex */
public abstract class cx extends m.a {
    public int a;
    public Context b;

    public cx(Context context, int i2) {
        this.a = i2;
        this.b = context;
    }

    public static void a(Context context, gy gyVar) {
        cq b = cr.a().b();
        String a = b == null ? "" : b.a();
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(gyVar.c())) {
            return;
        }
        a(context, gyVar, a);
    }

    private static void a(Context context, gy gyVar, String str) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        byte[] b = ct.b(str, ib.a(gyVar));
        if (b == null || b.length == 0) {
            return;
        }
        synchronized (cu.a) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                    c.b(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        FileLock lock = randomAccessFile.getChannel().lock();
                        try {
                            File file2 = new File(context.getExternalFilesDir(null), "push_cdata.data");
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, true));
                            try {
                                bufferedOutputStream.write(g.a(b.length));
                                bufferedOutputStream.write(b);
                                bufferedOutputStream.flush();
                                file2.setLastModified(0L);
                                if (lock != null && lock.isValid()) {
                                    try {
                                        lock.release();
                                    } catch (IOException unused) {
                                    }
                                }
                                c.a(bufferedOutputStream);
                            } catch (IOException e2) {
                                e = e2;
                                fileLock = lock;
                                try {
                                    e.printStackTrace();
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    c.a(bufferedOutputStream);
                                    c.a(randomAccessFile);
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    c.a(bufferedOutputStream);
                                    c.a(randomAccessFile);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileLock = lock;
                                if (fileLock != null) {
                                    fileLock.release();
                                }
                                c.a(bufferedOutputStream);
                                c.a(randomAccessFile);
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            bufferedOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedOutputStream = null;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        bufferedOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                }
                c.a(randomAccessFile);
            } catch (Throwable th6) {
                throw th6;
            }
        }
    }

    private String g() {
        return "dc_job_result_time_" + a();
    }

    private String h() {
        return "dc_job_result_" + a();
    }

    public abstract String b();

    public abstract gs c();

    public boolean d() {
        return ct.a(this.b, String.valueOf(a()), this.a);
    }

    public boolean e() {
        return true;
    }

    public boolean f() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        String b = b();
        if (TextUtils.isEmpty(b)) {
            return;
        }
        if (d()) {
            com.xiaomi.a.a.a.c.a("DC run job mutual: " + a());
            return;
        }
        cq b2 = cr.a().b();
        String a = b2 == null ? "" : b2.a();
        if (!TextUtils.isEmpty(a) && e()) {
            if (f()) {
                SharedPreferences sharedPreferences = this.b.getSharedPreferences("mipush_extra", 0);
                if (ar.a(b).equals(sharedPreferences.getString(h(), null))) {
                    long j2 = sharedPreferences.getLong(g(), 0L);
                    int a2 = com.xiaomi.push.service.ad.a(this.b).a(gv.DCJobUploadRepeatedInterval.a(), 604800);
                    if ((System.currentTimeMillis() - j2) / 1000 < this.a) {
                        return;
                    }
                    if ((System.currentTimeMillis() - j2) / 1000 < a2) {
                        b = "same_" + j2;
                    }
                }
            }
            gy gyVar = new gy();
            gyVar.a(b);
            gyVar.a(System.currentTimeMillis());
            gyVar.a(c());
            a(this.b, gyVar, a);
        }
    }
}
