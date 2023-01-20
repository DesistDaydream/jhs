package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class gl {
    private static boolean a = false;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private Context a;
        private go b;

        public a(Context context, go goVar) {
            this.b = goVar;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            gl.c(this.a, this.b);
        }
    }

    private static void a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static void a(Context context, go goVar) {
        m.a(context).a(new a(context, goVar));
    }

    private static void a(Context context, go goVar, File file, byte[] bArr) {
        String str;
        int a2;
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                loop0: while (true) {
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        try {
                            int read = bufferedInputStream2.read(bArr2);
                            if (read == -1) {
                                break loop0;
                            } else if (read == 4) {
                                a2 = g.a(bArr2);
                                if (a2 < 1 || a2 > 10240) {
                                    break loop0;
                                }
                                byte[] bArr3 = new byte[a2];
                                int read2 = bufferedInputStream2.read(bArr3);
                                if (read2 != a2) {
                                    str = "TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + a2;
                                    break loop0;
                                }
                                byte[] a3 = hh.a(bArr, bArr3);
                                if (a3 != null && a3.length != 0) {
                                    gu guVar = new gu();
                                    ib.a(guVar, a3);
                                    guVar.a("item_size", String.valueOf(a3.length));
                                    arrayList.add(guVar);
                                    i2++;
                                    i3 += a3.length;
                                    if (i2 >= 8 || i3 >= 10240) {
                                    }
                                }
                                com.xiaomi.a.a.a.c.d("TinyData read from cache file failed cause decrypt fail");
                            } else {
                                str = "TinyData read from cache file failed cause lengthBuffer error. size:" + read;
                                break loop0;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            bufferedInputStream = bufferedInputStream2;
                            com.xiaomi.a.a.a.c.a(e);
                            c.a(bufferedInputStream);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            c.a(bufferedInputStream);
                            throw th;
                        }
                    }
                    gm.a(context, goVar, arrayList);
                    arrayList.clear();
                }
                str = "TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + a2;
                com.xiaomi.a.a.a.c.d(str);
                gm.a(context, goVar, arrayList);
                if (file != null && file.exists() && !file.delete()) {
                    com.xiaomi.a.a.a.c.a("TinyData delete reading temp file failed");
                }
                c.a(bufferedInputStream2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static void b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r11, com.xiaomi.push.go r12) {
        /*
            java.lang.String r0 = "/"
            java.lang.String r1 = "/tdReadTemp"
            boolean r2 = com.xiaomi.push.gl.a
            if (r2 != 0) goto Ldd
            r2 = 1
            com.xiaomi.push.gl.a = r2
            java.io.File r2 = new java.io.File
            java.io.File r3 = r11.getFilesDir()
            java.lang.String r4 = "tiny_data.data"
            r2.<init>(r3, r4)
            boolean r3 = r2.exists()
            java.lang.String r5 = "TinyData no ready file to get data."
            if (r3 != 0) goto L22
            com.xiaomi.a.a.a.c.a(r5)
            return
        L22:
            a(r11)
            byte[] r3 = com.xiaomi.push.service.be.a(r11)
            r6 = 0
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            java.io.File r8 = r11.getFilesDir()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            java.lang.String r9 = "tiny_data.lock"
            r7.<init>(r8, r9)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            com.xiaomi.push.c.b(r7)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            java.lang.String r9 = "rw"
            r8.<init>(r7, r9)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            java.nio.channels.FileChannel r7 = r8.getChannel()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            java.nio.channels.FileLock r6 = r7.lock()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            java.io.File r7 = new java.io.File     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r9.<init>()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            java.io.File r10 = r11.getFilesDir()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r9.append(r10)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r9.append(r1)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r9.append(r0)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r9.append(r4)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r7.<init>(r9)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r2.renameTo(r7)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            if (r6 == 0) goto L90
            boolean r2 = r6.isValid()
            if (r2 == 0) goto L90
            r6.release()     // Catch: java.io.IOException -> L74
            goto L90
        L74:
            r2 = move-exception
            goto L8d
        L76:
            r2 = move-exception
            goto L7d
        L78:
            r11 = move-exception
            r8 = r6
            goto Lc9
        L7b:
            r2 = move-exception
            r8 = r6
        L7d:
            com.xiaomi.a.a.a.c.a(r2)     // Catch: java.lang.Throwable -> Lc8
            if (r6 == 0) goto L90
            boolean r2 = r6.isValid()
            if (r2 == 0) goto L90
            r6.release()     // Catch: java.io.IOException -> L8c
            goto L90
        L8c:
            r2 = move-exception
        L8d:
            com.xiaomi.a.a.a.c.a(r2)
        L90:
            com.xiaomi.push.c.a(r8)
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.io.File r7 = r11.getFilesDir()
            r6.append(r7)
            r6.append(r1)
            r6.append(r0)
            r6.append(r4)
            java.lang.String r0 = r6.toString()
            r2.<init>(r0)
            boolean r0 = r2.exists()
            if (r0 != 0) goto Lbb
            com.xiaomi.a.a.a.c.a(r5)
            return
        Lbb:
            a(r11, r12, r2, r3)
            r12 = 0
            com.xiaomi.push.gk.a(r12)
            b(r11)
            com.xiaomi.push.gl.a = r12
            return
        Lc8:
            r11 = move-exception
        Lc9:
            if (r6 == 0) goto Ld9
            boolean r12 = r6.isValid()
            if (r12 == 0) goto Ld9
            r6.release()     // Catch: java.io.IOException -> Ld5
            goto Ld9
        Ld5:
            r12 = move-exception
            com.xiaomi.a.a.a.c.a(r12)
        Ld9:
            com.xiaomi.push.c.a(r8)
            throw r11
        Ldd:
            java.lang.String r11 = "TinyData extractTinyData is running"
            com.xiaomi.a.a.a.c.a(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.gl.c(android.content.Context, com.xiaomi.push.go):void");
    }
}
