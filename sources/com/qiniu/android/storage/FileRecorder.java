package com.qiniu.android.storage;

import com.baidu.mobads.sdk.internal.bc;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Date;

/* loaded from: classes3.dex */
public final class FileRecorder implements Recorder {
    public String directory;

    public FileRecorder(String str) throws IOException {
        this.directory = str;
        File file = new File(str);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new IOException("mkdir failed");
            }
        } else if (!file.isDirectory()) {
            throw new IOException("does not mkdir");
        }
    }

    private static String hash(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA-1").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private boolean outOfDate(File file) {
        return file.lastModified() + bc.f1470e < new Date().getTime();
    }

    @Override // com.qiniu.android.storage.Recorder
    public void del(String str) {
        new File(this.directory, hash(str)).delete();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0040 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.qiniu.android.storage.Recorder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] get(java.lang.String r4) {
        /*
            r3 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r3.directory
            java.lang.String r4 = hash(r4)
            r0.<init>(r1, r4)
            r4 = 0
            boolean r1 = r3.outOfDate(r0)     // Catch: java.io.IOException -> L2c
            if (r1 == 0) goto L16
            r0.delete()     // Catch: java.io.IOException -> L2c
            return r4
        L16:
            long r1 = r0.length()     // Catch: java.io.IOException -> L2c
            int r2 = (int) r1     // Catch: java.io.IOException -> L2c
            byte[] r1 = new byte[r2]     // Catch: java.io.IOException -> L2c
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.io.IOException -> L29
            r2.<init>(r0)     // Catch: java.io.IOException -> L29
            int r0 = r2.read(r1)     // Catch: java.io.IOException -> L27
            goto L33
        L27:
            r0 = move-exception
            goto L2f
        L29:
            r0 = move-exception
            r2 = r4
            goto L2f
        L2c:
            r0 = move-exception
            r1 = r4
            r2 = r1
        L2f:
            r0.printStackTrace()
            r0 = 0
        L33:
            if (r2 == 0) goto L3d
            r2.close()     // Catch: java.io.IOException -> L39
            goto L3d
        L39:
            r2 = move-exception
            r2.printStackTrace()
        L3d:
            if (r0 != 0) goto L40
            return r4
        L40:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.storage.FileRecorder.get(java.lang.String):byte[]");
    }

    @Override // com.qiniu.android.storage.Recorder
    public String getFileName() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // com.qiniu.android.storage.Recorder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void set(java.lang.String r3, byte[] r4) {
        /*
            r2 = this;
            if (r3 != 0) goto L3
            return
        L3:
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r2.directory
            java.lang.String r3 = hash(r3)
            r0.<init>(r1, r3)
            r3 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L1a
            r1.<init>(r0)     // Catch: java.io.IOException -> L1a
            r1.write(r4)     // Catch: java.io.IOException -> L18
            goto L20
        L18:
            r3 = move-exception
            goto L1d
        L1a:
            r4 = move-exception
            r1 = r3
            r3 = r4
        L1d:
            r3.printStackTrace()
        L20:
            if (r1 == 0) goto L2a
            r1.close()     // Catch: java.io.IOException -> L26
            goto L2a
        L26:
            r3 = move-exception
            r3.printStackTrace()
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.storage.FileRecorder.set(java.lang.String, byte[]):void");
    }
}
