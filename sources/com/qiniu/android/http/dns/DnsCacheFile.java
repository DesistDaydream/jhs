package com.qiniu.android.http.dns;

import com.qiniu.android.storage.Recorder;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DnsCacheFile implements Recorder {
    public String directory;

    /* renamed from: f  reason: collision with root package name */
    public File f4971f;

    public DnsCacheFile(String str) throws IOException {
        if (str != null) {
            this.directory = str;
            File file = new File(str);
            this.f4971f = file;
            if (!file.exists() && !this.f4971f.mkdirs()) {
                throw new IOException("mkdir failed");
            }
            if (!this.f4971f.isDirectory()) {
                throw new IOException("does not mkdir");
            }
            return;
        }
        throw new IOException("directory invalid");
    }

    public synchronized void clearCache() throws IOException {
        File file = this.f4971f;
        if (file != null) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        } else {
            throw new IOException("directory invalid");
        }
    }

    @Override // com.qiniu.android.storage.Recorder
    public synchronized void del(String str) {
        if (str != null) {
            new File(this.directory, str).delete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003a A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.qiniu.android.storage.Recorder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized byte[] get(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = r4.directory     // Catch: java.lang.Throwable -> L3e
            r0.<init>(r1, r5)     // Catch: java.lang.Throwable -> L3e
            boolean r5 = r0.exists()     // Catch: java.lang.Throwable -> L3e
            r1 = 0
            if (r5 != 0) goto L11
            monitor-exit(r4)
            return r1
        L11:
            r5 = 0
            long r2 = r0.length()     // Catch: java.io.IOException -> L28 java.lang.Throwable -> L3e
            int r3 = (int) r2     // Catch: java.io.IOException -> L28 java.lang.Throwable -> L3e
            byte[] r2 = new byte[r3]     // Catch: java.io.IOException -> L28 java.lang.Throwable -> L3e
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L3e
            r3.<init>(r0)     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L3e
            int r5 = r3.read(r2)     // Catch: java.io.IOException -> L23 java.lang.Throwable -> L3e
            goto L2e
        L23:
            r0 = move-exception
            goto L2b
        L25:
            r0 = move-exception
            r3 = r1
            goto L2b
        L28:
            r0 = move-exception
            r2 = r1
            r3 = r2
        L2b:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L3e
        L2e:
            if (r3 == 0) goto L38
            r3.close()     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L3e
            goto L38
        L34:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L3e
        L38:
            if (r5 != 0) goto L3c
            monitor-exit(r4)
            return r1
        L3c:
            monitor-exit(r4)
            return r2
        L3e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.http.dns.DnsCacheFile.get(java.lang.String):byte[]");
    }

    @Override // com.qiniu.android.storage.Recorder
    public String getFileName() {
        return "dnsCache";
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.qiniu.android.storage.Recorder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void set(java.lang.String r3, byte[] r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L2f
            java.lang.String r1 = r2.directory     // Catch: java.lang.Throwable -> L2f
            r0.<init>(r1, r3)     // Catch: java.lang.Throwable -> L2f
            boolean r3 = r0.exists()     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L11
            r0.delete()     // Catch: java.lang.Throwable -> L2f
        L11:
            r3 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L1d java.lang.Throwable -> L2f
            r1.<init>(r0)     // Catch: java.io.IOException -> L1d java.lang.Throwable -> L2f
            r1.write(r4)     // Catch: java.io.IOException -> L1b java.lang.Throwable -> L2f
            goto L23
        L1b:
            r3 = move-exception
            goto L20
        L1d:
            r4 = move-exception
            r1 = r3
            r3 = r4
        L20:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L2f
        L23:
            if (r1 == 0) goto L2d
            r1.close()     // Catch: java.io.IOException -> L29 java.lang.Throwable -> L2f
            goto L2d
        L29:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L2f
        L2d:
            monitor-exit(r2)
            return
        L2f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.http.dns.DnsCacheFile.set(java.lang.String, byte[]):void");
    }
}
