package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gu;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: classes3.dex */
public final class bf implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ gu b;

    public bf(Context context, gu guVar) {
        this.a = context;
        this.b = guVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        synchronized (be.a) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(this.a.getFilesDir(), "tiny_data.lock");
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
                        be.c(this.a, this.b);
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
}
