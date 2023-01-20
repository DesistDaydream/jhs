package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final class jn {

    /* renamed from: e  reason: collision with root package name */
    private static final Set<String> f9024e = Collections.synchronizedSet(new HashSet());
    private Context a;
    private FileLock b;

    /* renamed from: c  reason: collision with root package name */
    private String f9025c;

    /* renamed from: d  reason: collision with root package name */
    private RandomAccessFile f9026d;

    private jn(Context context) {
        this.a = context;
    }

    public static jn a(Context context, File file) {
        com.xiaomi.a.a.a.c.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        Set<String> set = f9024e;
        if (set.add(str)) {
            jn jnVar = new jn(context);
            jnVar.f9025c = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                jnVar.f9026d = randomAccessFile;
                jnVar.b = randomAccessFile.getChannel().lock();
                com.xiaomi.a.a.a.c.c("Locked: " + str + " :" + jnVar.b);
                if (jnVar.b == null) {
                    RandomAccessFile randomAccessFile2 = jnVar.f9026d;
                    if (randomAccessFile2 != null) {
                        c.a(randomAccessFile2);
                    }
                    set.remove(jnVar.f9025c);
                }
                return jnVar;
            } catch (Throwable th) {
                if (jnVar.b == null) {
                    RandomAccessFile randomAccessFile3 = jnVar.f9026d;
                    if (randomAccessFile3 != null) {
                        c.a(randomAccessFile3);
                    }
                    f9024e.remove(jnVar.f9025c);
                }
                throw th;
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.a.a.a.c.c("unLock: " + this.b);
        FileLock fileLock = this.b;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.b.release();
            } catch (IOException unused) {
            }
            this.b = null;
        }
        RandomAccessFile randomAccessFile = this.f9026d;
        if (randomAccessFile != null) {
            c.a(randomAccessFile);
        }
        f9024e.remove(this.f9025c);
    }
}
