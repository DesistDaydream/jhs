package com.xiaomi.b.c;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.qq.e.comm.constants.ErrorCode;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ar;
import com.xiaomi.push.av;
import com.xiaomi.push.hh;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes3.dex */
public class c implements a {
    public Context a;
    private HashMap<String, ArrayList<com.xiaomi.b.a.d>> b;

    public c(Context context) {
        a(context);
    }

    public static String a(com.xiaomi.b.a.d dVar) {
        return String.valueOf(dVar.f8207e);
    }

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e2) {
                com.xiaomi.a.a.a.c.a(e2);
            }
        }
        com.xiaomi.push.c.a(randomAccessFile);
    }

    private void a(String str, String str2) {
        com.xiaomi.b.b.b a = com.xiaomi.b.b.b.a(this.a);
        com.xiaomi.b.a.b a2 = a.a(ErrorCode.SERVER_JSON_PARSE_ERROR, "24:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2.b());
        a(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        com.xiaomi.a.a.a.c.d(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
        r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K";
        r4 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<java.lang.String> b(java.lang.String r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 4
            byte[] r2 = new byte[r1]
            byte[] r3 = new byte[r1]
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
        L15:
            int r9 = r5.read(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r4 = -1
            if (r9 != r4) goto L1d
            goto L66
        L1d:
            java.lang.String r6 = "eventData read from cache file failed because magicNumber error"
            if (r9 == r1) goto L25
        L21:
            com.xiaomi.a.a.a.c.d(r6)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            goto L66
        L25:
            int r9 = com.xiaomi.push.g.a(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r7 = -573785174(0xffffffffddccbbaa, float:-1.84407149E18)
            if (r9 == r7) goto L2f
            goto L21
        L2f:
            int r9 = r5.read(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r9 != r4) goto L36
            goto L66
        L36:
            if (r9 == r1) goto L3e
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer error"
        L3a:
            com.xiaomi.a.a.a.c.d(r9)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            goto L66
        L3e:
            int r9 = com.xiaomi.push.g.a(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r4 = 1
            if (r9 < r4) goto L63
            r4 = 4096(0x1000, float:5.74E-42)
            if (r9 <= r4) goto L4a
            goto L63
        L4a:
            byte[] r4 = new byte[r9]     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            int r6 = r5.read(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r6 == r9) goto L55
            java.lang.String r9 = "eventData read from cache file failed cause buffer size not equal length"
            goto L3a
        L55:
            java.lang.String r9 = r8.a(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r4 != 0) goto L15
            r0.add(r9)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            goto L15
        L63:
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K"
            goto L3a
        L66:
            com.xiaomi.push.c.a(r5)
            goto L79
        L6a:
            r9 = move-exception
            r4 = r5
            goto L7a
        L6d:
            r9 = move-exception
            r4 = r5
            goto L73
        L70:
            r9 = move-exception
            goto L7a
        L72:
            r9 = move-exception
        L73:
            com.xiaomi.a.a.a.c.a(r9)     // Catch: java.lang.Throwable -> L70
            com.xiaomi.push.c.a(r4)
        L79:
            return r0
        L7a:
            com.xiaomi.push.c.a(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.b.c.c.b(java.lang.String):java.util.List");
    }

    private com.xiaomi.b.a.d[] b(com.xiaomi.b.a.d[] dVarArr) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        String c2 = c(dVarArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        try {
            File file = new File(c2 + ".lock");
            com.xiaomi.push.c.b(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(c2), true));
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    com.xiaomi.push.c.a(bufferedOutputStream2);
                    a(randomAccessFile, fileLock);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileLock = null;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileLock = null;
            }
        } catch (Exception e4) {
            e = e4;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileLock = null;
            randomAccessFile = null;
        }
        try {
            try {
                int i2 = 0;
                for (com.xiaomi.b.a.d dVar : dVarArr) {
                    if (dVar != null) {
                        byte[] a = a(dVar.b());
                        if (a != null && a.length >= 1 && a.length <= 4096) {
                            if (!av.b(this.a, c2)) {
                                int length = dVarArr.length - i2;
                                com.xiaomi.b.a.d[] dVarArr2 = new com.xiaomi.b.a.d[length];
                                System.arraycopy(dVarArr, i2, dVarArr2, 0, length);
                                com.xiaomi.push.c.a(bufferedOutputStream);
                                a(randomAccessFile, fileLock);
                                return dVarArr2;
                            }
                            bufferedOutputStream.write(com.xiaomi.push.g.a(-573785174));
                            bufferedOutputStream.write(com.xiaomi.push.g.a(a.length));
                            bufferedOutputStream.write(a);
                            bufferedOutputStream.flush();
                            i2++;
                        }
                        com.xiaomi.a.a.a.c.d("event data throw a invalid item ");
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream2 = bufferedOutputStream;
                com.xiaomi.push.c.a(bufferedOutputStream2);
                a(randomAccessFile, fileLock);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            com.xiaomi.a.a.a.c.a("event data write to cache file failed cause exception", e);
            com.xiaomi.push.c.a(bufferedOutputStream);
            a(randomAccessFile, fileLock);
            return null;
        }
        com.xiaomi.push.c.a(bufferedOutputStream);
        a(randomAccessFile, fileLock);
        return null;
    }

    private String c(com.xiaomi.b.a.d dVar) {
        File externalFilesDir = this.a.getExternalFilesDir("event");
        String a = a(dVar);
        if (externalFilesDir == null) {
            return null;
        }
        String str = externalFilesDir.getAbsolutePath() + File.separator + a;
        for (int i2 = 0; i2 < 100; i2++) {
            String str2 = str + i2;
            if (av.b(this.a, str2)) {
                return str2;
            }
        }
        return null;
    }

    public String a(byte[] bArr) {
        byte[] a;
        if (bArr != null && bArr.length >= 1) {
            if (!com.xiaomi.b.b.b.a(this.a).a().b()) {
                return ar.b(bArr);
            }
            String a2 = av.a(this.a);
            if (!TextUtils.isEmpty(a2) && (a = av.a(a2)) != null && a.length > 0) {
                try {
                    return ar.b(Base64.decode(hh.a(a, bArr), 2));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
                    com.xiaomi.a.a.a.c.a(e2);
                }
            }
        }
        return null;
    }

    @Override // com.xiaomi.b.c.e
    public void a() {
        int i2;
        RandomAccessFile randomAccessFile;
        av.a(this.a, "event", "eventUploading");
        File[] c2 = av.c(this.a, "eventUploading");
        if (c2 == null || c2.length <= 0) {
            return;
        }
        int length = c2.length;
        FileLock fileLock = null;
        RandomAccessFile randomAccessFile2 = null;
        File file = null;
        while (i2 < length) {
            File file2 = c2[i2];
            if (file2 == null) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        com.xiaomi.a.a.a.c.a(e2);
                    }
                }
                com.xiaomi.push.c.a(randomAccessFile2);
                i2 = file == null ? i2 + 1 : 0;
                file.delete();
            } else {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                if (file2.length() > 5242880) {
                    com.xiaomi.a.a.a.c.d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                    a(file2.getName(), Formatter.formatFileSize(this.a, file2.length()));
                    file2.delete();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            com.xiaomi.a.a.a.c.a(e4);
                        }
                    }
                    com.xiaomi.push.c.a(randomAccessFile2);
                    if (file == null) {
                    }
                    file.delete();
                } else {
                    String absolutePath = file2.getAbsolutePath();
                    File file3 = new File(absolutePath + ".lock");
                    try {
                        com.xiaomi.push.c.b(file3);
                        randomAccessFile = new RandomAccessFile(file3, "rw");
                    } catch (Exception e5) {
                        e = e5;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        a(b(absolutePath));
                        file2.delete();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e6) {
                                com.xiaomi.a.a.a.c.a(e6);
                            }
                        }
                        com.xiaomi.push.c.a(randomAccessFile);
                        file3.delete();
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                    } catch (Exception e7) {
                        e = e7;
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                        com.xiaomi.a.a.a.c.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e8) {
                                com.xiaomi.a.a.a.c.a(e8);
                            }
                        }
                        com.xiaomi.push.c.a(randomAccessFile2);
                        if (file == null) {
                        }
                        file.delete();
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e9) {
                                com.xiaomi.a.a.a.c.a(e9);
                            }
                        }
                        com.xiaomi.push.c.a(randomAccessFile2);
                        if (file != null) {
                            file.delete();
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public void a(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.b.c.a
    public void a(HashMap<String, ArrayList<com.xiaomi.b.a.d>> hashMap) {
        this.b = hashMap;
    }

    public void a(List<String> list) {
        av.a(this.a, list);
    }

    public void a(com.xiaomi.b.a.d[] dVarArr) {
        if (dVarArr == null || dVarArr.length == 0 || dVarArr[0] == null) {
            com.xiaomi.a.a.a.c.a("event data write to cache file failed because data null");
            return;
        }
        do {
            dVarArr = b(dVarArr);
            if (dVarArr == null || dVarArr.length <= 0) {
                return;
            }
        } while (dVarArr[0] != null);
    }

    public byte[] a(String str) {
        byte[] a;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.xiaomi.b.b.b.a(this.a).a().b()) {
            String a2 = av.a(this.a);
            byte[] c2 = ar.c(str);
            if (!TextUtils.isEmpty(a2) && c2 != null && c2.length > 1 && (a = av.a(a2)) != null) {
                try {
                    if (a.length > 1) {
                        return hh.b(a, Base64.encode(c2, 2));
                    }
                } catch (Exception e2) {
                    com.xiaomi.a.a.a.c.a(e2);
                }
            }
            return null;
        }
        return ar.c(str);
    }

    @Override // com.xiaomi.b.c.f
    public void b() {
        HashMap<String, ArrayList<com.xiaomi.b.a.d>> hashMap = this.b;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            for (String str : this.b.keySet()) {
                ArrayList<com.xiaomi.b.a.d> arrayList = this.b.get(str);
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.b.a.d[] dVarArr = new com.xiaomi.b.a.d[arrayList.size()];
                    arrayList.toArray(dVarArr);
                    a(dVarArr);
                }
            }
        }
        this.b.clear();
    }

    @Override // com.xiaomi.b.c.f
    public void b(com.xiaomi.b.a.d dVar) {
        if ((dVar instanceof com.xiaomi.b.a.b) && this.b != null) {
            com.xiaomi.b.a.b bVar = (com.xiaomi.b.a.b) dVar;
            String a = a(bVar);
            ArrayList<com.xiaomi.b.a.d> arrayList = this.b.get(a);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(bVar);
            this.b.put(a, arrayList);
        }
    }
}
