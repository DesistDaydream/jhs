package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.y;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class b {
    private static List<File> a = new ArrayList();

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x006b, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006f, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
        com.tencent.bugly.proguard.y.a(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "reg_record.txt"
            java.io.BufferedReader r9 = com.tencent.bugly.proguard.ab.a(r9, r0)
            r0 = 0
            if (r9 != 0) goto La
            return r0
        La:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r1.<init>()     // Catch: java.lang.Throwable -> L74
            java.lang.String r2 = r9.readLine()     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L69
            boolean r10 = r2.startsWith(r10)     // Catch: java.lang.Throwable -> L74
            if (r10 != 0) goto L1c
            goto L69
        L1c:
            java.lang.String r10 = "                "
            r2 = 18
            r3 = 0
            r4 = 0
            r5 = 0
        L23:
            java.lang.String r6 = r9.readLine()     // Catch: java.lang.Throwable -> L74
            java.lang.String r7 = "\n"
            if (r6 == 0) goto L57
            int r8 = r4 % 4
            if (r8 != 0) goto L3a
            if (r4 <= 0) goto L34
            r1.append(r7)     // Catch: java.lang.Throwable -> L74
        L34:
            java.lang.String r5 = "  "
            r1.append(r5)     // Catch: java.lang.Throwable -> L74
            goto L4d
        L3a:
            int r7 = r6.length()     // Catch: java.lang.Throwable -> L74
            r8 = 16
            if (r7 <= r8) goto L44
            r2 = 28
        L44:
            int r5 = r2 - r5
            java.lang.String r5 = r10.substring(r3, r5)     // Catch: java.lang.Throwable -> L74
            r1.append(r5)     // Catch: java.lang.Throwable -> L74
        L4d:
            int r5 = r6.length()     // Catch: java.lang.Throwable -> L74
            r1.append(r6)     // Catch: java.lang.Throwable -> L74
            int r4 = r4 + 1
            goto L23
        L57:
            r1.append(r7)     // Catch: java.lang.Throwable -> L74
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> L74
            if (r9 == 0) goto L68
            r9.close()     // Catch: java.lang.Exception -> L64
            goto L68
        L64:
            r9 = move-exception
            com.tencent.bugly.proguard.y.a(r9)
        L68:
            return r10
        L69:
            if (r9 == 0) goto L73
            r9.close()     // Catch: java.lang.Exception -> L6f
            goto L73
        L6f:
            r9 = move-exception
            com.tencent.bugly.proguard.y.a(r9)
        L73:
            return r0
        L74:
            r10 = move-exception
            com.tencent.bugly.proguard.y.a(r10)     // Catch: java.lang.Throwable -> L83
            if (r9 == 0) goto L82
            r9.close()     // Catch: java.lang.Exception -> L7e
            goto L82
        L7e:
            r9 = move-exception
            com.tencent.bugly.proguard.y.a(r9)
        L82:
            return r0
        L83:
            r10 = move-exception
            if (r9 == 0) goto L8e
            r9.close()     // Catch: java.lang.Exception -> L8a
            goto L8e
        L8a:
            r9 = move-exception
            com.tencent.bugly.proguard.y.a(r9)
        L8e:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.b.b(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
        com.tencent.bugly.proguard.y.a(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c(java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "map_record.txt"
            java.io.BufferedReader r3 = com.tencent.bugly.proguard.ab.a(r3, r0)
            r0 = 0
            if (r3 != 0) goto La
            return r0
        La:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a
            r1.<init>()     // Catch: java.lang.Throwable -> L4a
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L3f
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Throwable -> L4a
            if (r4 != 0) goto L1c
            goto L3f
        L1c:
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> L4a
            if (r4 == 0) goto L30
            java.lang.String r2 = "  "
            r1.append(r2)     // Catch: java.lang.Throwable -> L4a
            r1.append(r4)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = "\n"
            r1.append(r4)     // Catch: java.lang.Throwable -> L4a
            goto L1c
        L30:
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L4a
            if (r3 == 0) goto L3e
            r3.close()     // Catch: java.lang.Exception -> L3a
            goto L3e
        L3a:
            r3 = move-exception
            com.tencent.bugly.proguard.y.a(r3)
        L3e:
            return r4
        L3f:
            if (r3 == 0) goto L49
            r3.close()     // Catch: java.lang.Exception -> L45
            goto L49
        L45:
            r3 = move-exception
            com.tencent.bugly.proguard.y.a(r3)
        L49:
            return r0
        L4a:
            r4 = move-exception
            com.tencent.bugly.proguard.y.a(r4)     // Catch: java.lang.Throwable -> L59
            if (r3 == 0) goto L58
            r3.close()     // Catch: java.lang.Exception -> L54
            goto L58
        L54:
            r3 = move-exception
            com.tencent.bugly.proguard.y.a(r3)
        L58:
            return r0
        L59:
            r4 = move-exception
            if (r3 == 0) goto L64
            r3.close()     // Catch: java.lang.Exception -> L60
            goto L64
        L60:
            r3 = move-exception
            com.tencent.bugly.proguard.y.a(r3)
        L64:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.b.c(java.lang.String, java.lang.String):java.lang.String");
    }

    private static Map<String, Integer> d(String str) {
        String[] split;
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                String[] split2 = str2.split(Constants.COLON_SEPARATOR);
                if (split2.length != 2) {
                    y.e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
            }
            return hashMap;
        } catch (Exception e2) {
            y.e("error format intStateStr %s", str);
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.tencent.bugly.crashreport.crash.CrashDetailBean a(android.content.Context r25, java.util.Map<java.lang.String, java.lang.String> r26, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler r27) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.b.a(android.content.Context, java.util.Map, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }

    public static void c(String str) {
        File[] listFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        y.c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            y.a(th);
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    private static long b(Map<String, String> map) {
        String str = map.get("launchTime");
        if (str != null) {
            y.c("[Native record info] launchTime: %s", str);
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e2) {
                if (y.a(e2)) {
                    return -1L;
                }
                e2.printStackTrace();
                return -1L;
            }
        }
        return -1L;
    }

    private static <KeyT, ValueT> ValueT a(Map<KeyT, ValueT> map, KeyT keyt, ValueT valuet) {
        ValueT valuet2;
        try {
            valuet2 = map.get(keyt);
        } catch (Exception e2) {
            y.a(e2);
        }
        return valuet2 != null ? valuet2 : valuet;
    }

    private static String a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bufferedInputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int read = bufferedInputStream.read();
                    if (read == -1) {
                        byteArrayOutputStream.close();
                        break;
                    } else if (read == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    } else {
                        byteArrayOutputStream.write(read);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        y.a(th);
                        return null;
                    } finally {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String a2;
        BufferedInputStream bufferedInputStream2 = null;
        if (context != null && str != null && nativeExceptionHandler != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists()) {
                ?? canRead = file.canRead();
                try {
                    if (canRead != 0) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        } catch (IOException e2) {
                            e = e2;
                            bufferedInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                        try {
                            String a3 = a(bufferedInputStream);
                            if (a3 != null && a3.equals("NATIVE_RQD_REPORT")) {
                                HashMap hashMap = new HashMap();
                                loop0: while (true) {
                                    str2 = null;
                                    while (true) {
                                        a2 = a(bufferedInputStream);
                                        if (a2 == null) {
                                            break loop0;
                                        } else if (str2 == null) {
                                            str2 = a2;
                                        }
                                    }
                                    hashMap.put(str2, a2);
                                }
                                if (str2 != null) {
                                    y.e("record not pair! drop! %s", str2);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                    return null;
                                }
                                CrashDetailBean a4 = a(context, hashMap, nativeExceptionHandler);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                                return a4;
                            }
                            y.e("record read fail! %s", a3);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                            return null;
                        } catch (IOException e7) {
                            e = e7;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            return null;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = canRead;
                }
            }
            return null;
        }
        y.e("get eup record file args error", new Object[0]);
        return null;
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String b = b(str, str2);
        if (b != null && !b.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(b);
        }
        String c2 = c(str, str2);
        if (c2 != null && !c2.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(c2);
        }
        return sb.toString();
    }

    public static void a(boolean z, String str) {
        if (str != null) {
            a.add(new File(str, "rqd_record.eup"));
            a.add(new File(str, "reg_record.txt"));
            a.add(new File(str, "map_record.txt"));
            a.add(new File(str, "backup_record.txt"));
            if (z) {
                c(str);
            }
        }
        List<File> list = a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                y.c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    public static String a(String str, int i2, String str2, boolean z) {
        BufferedReader bufferedReader = null;
        if (str != null && i2 > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                y.a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                a.add(file);
                y.c("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return ab.a(new File(str), i2, z);
                }
                String sb = new StringBuilder();
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), com.qiniu.android.common.Constants.UTF_8));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (Pattern.compile(str2 + "[ ]*:").matcher(readLine).find()) {
                                    sb.append(readLine);
                                    sb.append("\n");
                                }
                                if (i2 > 0 && sb.length() > i2) {
                                    if (z) {
                                        sb.delete(i2, sb.length());
                                        break;
                                    }
                                    sb.delete(0, sb.length() - i2);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                try {
                                    y.a(th);
                                    sb.append("\n[error:" + th.toString() + "]");
                                    String sb2 = sb.toString();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                        sb = sb2;
                                        return sb;
                                    }
                                    return sb2;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e2) {
                                            y.a(e2);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        String sb3 = sb.toString();
                        bufferedReader2.close();
                        sb = sb3;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    return sb;
                } catch (Exception e3) {
                    y.a(e3);
                    return sb;
                }
            }
        }
        return null;
    }

    private static Map<String, String> a(Map<String, String> map) {
        String str = map.get("key-value");
        if (str != null) {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split("\n")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
            return hashMap;
        }
        return null;
    }
}
