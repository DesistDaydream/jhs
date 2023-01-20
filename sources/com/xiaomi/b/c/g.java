package com.xiaomi.b.c;

import android.text.TextUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class g {
    private static com.xiaomi.b.a.c a(com.xiaomi.b.a.c cVar, String str) {
        long[] a;
        if (cVar == null || (a = a(str)) == null) {
            return null;
        }
        cVar.b = a[0];
        cVar.f8204c = a[1];
        return cVar;
    }

    public static String a(com.xiaomi.b.a.c cVar) {
        return cVar.f8207e + MqttTopic.MULTI_LEVEL_WILDCARD + cVar.f8208f + MqttTopic.MULTI_LEVEL_WILDCARD + cVar.f8209g + MqttTopic.MULTI_LEVEL_WILDCARD + cVar.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d5, code lost:
        if (r1 != null) goto L50;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f4  */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.Closeable, java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> a(android.content.Context r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.b.c.g.a(android.content.Context, java.lang.String):java.util.List");
    }

    private static void a(String str, HashMap<String, String> hashMap) {
        BufferedWriter bufferedWriter;
        Throwable th;
        Exception e2;
        if (TextUtils.isEmpty(str) || hashMap == null || hashMap.size() == 0) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Exception e3) {
            bufferedWriter = null;
            e2 = e3;
        } catch (Throwable th2) {
            bufferedWriter = null;
            th = th2;
            com.xiaomi.push.c.a(bufferedWriter);
            throw th;
        }
        try {
            try {
                for (String str2 : hashMap.keySet()) {
                    bufferedWriter.write(str2 + "%%%" + hashMap.get(str2));
                    bufferedWriter.newLine();
                }
            } catch (Throwable th3) {
                th = th3;
                com.xiaomi.push.c.a(bufferedWriter);
                throw th;
            }
        } catch (Exception e4) {
            e2 = e4;
            com.xiaomi.a.a.a.c.a(e2);
            com.xiaomi.push.c.a(bufferedWriter);
        }
        com.xiaomi.push.c.a(bufferedWriter);
    }

    public static void a(String str, com.xiaomi.b.a.d[] dVarArr) {
        RandomAccessFile randomAccessFile;
        if (dVarArr == null || dVarArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock = null;
        try {
            File file = new File(str + ".lock");
            com.xiaomi.push.c.b(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                HashMap<String, String> b = b(str);
                for (com.xiaomi.b.a.d dVar : dVarArr) {
                    if (dVar != null) {
                        String a = a((com.xiaomi.b.a.c) dVar);
                        long j2 = ((com.xiaomi.b.a.c) dVar).b;
                        long j3 = ((com.xiaomi.b.a.c) dVar).f8204c;
                        if (!TextUtils.isEmpty(a) && j2 > 0 && j3 >= 0) {
                            a(b, a, j2, j3);
                        }
                    }
                }
                a(str, b);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        e = e2;
                        com.xiaomi.a.a.a.c.a(e);
                        com.xiaomi.push.c.a(randomAccessFile);
                    }
                }
            } catch (Throwable unused) {
                try {
                    com.xiaomi.a.a.a.c.c("failed to write perf to file ");
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            e = e3;
                            com.xiaomi.a.a.a.c.a(e);
                            com.xiaomi.push.c.a(randomAccessFile);
                        }
                    }
                    com.xiaomi.push.c.a(randomAccessFile);
                } catch (Throwable th) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            com.xiaomi.a.a.a.c.a(e4);
                        }
                    }
                    com.xiaomi.push.c.a(randomAccessFile);
                    throw th;
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        com.xiaomi.push.c.a(randomAccessFile);
    }

    private static void a(HashMap<String, String> hashMap, String str, long j2, long j3) {
        StringBuilder sb;
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
        } else {
            long[] a = a(str2);
            if (a == null || a[0] <= 0 || a[1] < 0) {
                sb = new StringBuilder();
            } else {
                j2 += a[0];
                j3 += a[1];
                sb = new StringBuilder();
            }
        }
        sb.append(j2);
        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append(j3);
        hashMap.put(str, sb.toString());
    }

    public static long[] a(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split(MqttTopic.MULTI_LEVEL_WILDCARD);
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    private static HashMap<String, String> b(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return hashMap;
        }
        BufferedReader bufferedReader = 0;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split("%%%");
                        bufferedReader = split.length;
                        if (bufferedReader >= 2) {
                            bufferedReader = 0;
                            bufferedReader = 0;
                            if (!TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                bufferedReader = split[0];
                                hashMap.put(bufferedReader, split[1]);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        com.xiaomi.a.a.a.c.a(e);
                        com.xiaomi.push.c.a(bufferedReader);
                        return hashMap;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.xiaomi.push.c.a(bufferedReader);
                        throw th;
                    }
                }
                com.xiaomi.push.c.a(bufferedReader2);
            } catch (Exception e3) {
                e = e3;
            }
            return hashMap;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String[] c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(MqttTopic.MULTI_LEVEL_WILDCARD);
    }

    private static com.xiaomi.b.a.c d(String str) {
        com.xiaomi.b.a.c cVar = null;
        try {
            String[] c2 = c(str);
            if (c2 == null || c2.length < 4 || TextUtils.isEmpty(c2[0]) || TextUtils.isEmpty(c2[1]) || TextUtils.isEmpty(c2[2]) || TextUtils.isEmpty(c2[3])) {
                return null;
            }
            cVar = com.xiaomi.b.a.c.c();
            cVar.f8207e = Integer.parseInt(c2[0]);
            cVar.f8208f = c2[1];
            cVar.f8209g = Integer.parseInt(c2[2]);
            cVar.a = Integer.parseInt(c2[3]);
            return cVar;
        } catch (Exception unused) {
            com.xiaomi.a.a.a.c.c("parse per key error");
            return cVar;
        }
    }
}
