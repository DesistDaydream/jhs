package com.moor.imkf.lib.jobqueue.persistentQueue.sqlite;

import android.content.Context;
import androidx.annotation.Nullable;
import com.moor.imkf.lib.jobqueue.log.JqLog;
import j.n;
import j.o;
import j.z;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/* loaded from: classes2.dex */
public class FileStorage {
    private static final String EXT = ".jobs";
    private final File folder;

    public FileStorage(Context context, String str) {
        File dir = context.getDir("com_birbit_jobqueue_jobs", 0);
        File file = new File(dir, "files_" + str);
        this.folder = file;
        file.mkdirs();
    }

    private static void closeQuitely(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    private static String filename(String str) {
        return str + EXT;
    }

    @Nullable
    private static String filenameToId(String str) {
        if (str.length() < 6) {
            return null;
        }
        return str.substring(0, str.length() - 5);
    }

    private File toFile(String str) {
        return new File(this.folder, filename(str));
    }

    public void delete(String str) {
        File file = toFile(str);
        if (file.exists()) {
            file.delete();
        }
    }

    @Nullable
    public byte[] load(String str) throws IOException {
        File file = toFile(str);
        if (file.exists() && file.canRead()) {
            o d2 = z.d(z.l(file));
            try {
                return d2.Z();
            } finally {
                closeQuitely(d2);
            }
        }
        return null;
    }

    public void save(String str, byte[] bArr) throws IOException {
        n c2 = z.c(z.f(toFile(str)));
        try {
            c2.write(bArr).flush();
        } finally {
            closeQuitely(c2);
        }
    }

    public void truncateExcept(Set<String> set) {
        String[] list;
        File file;
        for (String str : this.folder.list()) {
            if (str.endsWith(EXT) && !set.contains(filenameToId(str))) {
                if (!new File(this.folder, str).delete()) {
                    JqLog.d("cannot delete unused job toFile " + file.getAbsolutePath(), new Object[0]);
                }
            }
        }
    }
}
