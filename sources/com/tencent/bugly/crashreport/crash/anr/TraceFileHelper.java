package com.tencent.bugly.crashreport.crash.anr;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.bugly.proguard.y;
import e.t.u.b0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class TraceFileHelper {

    /* loaded from: classes3.dex */
    public static class a {
        public long a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public long f6567c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String[]> f6568d;
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(long j2);

        boolean a(long j2, long j3, String str);

        boolean a(String str, int i2, String str2, String str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
        r5 = r8[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r5.matcher(r1).matches() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        return new java.lang.Object[]{r5, r1};
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0003, code lost:
        if (r8 != null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0006, code lost:
        r1 = r7.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
        r2 = r8.length;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000f, code lost:
        if (r4 >= r2) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object[] a(java.io.BufferedReader r7, java.util.regex.Pattern... r8) throws java.io.IOException {
        /*
            r0 = 0
            if (r7 == 0) goto L29
            if (r8 != 0) goto L6
            goto L29
        L6:
            java.lang.String r1 = r7.readLine()
            if (r1 == 0) goto L29
            int r2 = r8.length
            r3 = 0
            r4 = 0
        Lf:
            if (r4 >= r2) goto L6
            r5 = r8[r4]
            java.util.regex.Matcher r6 = r5.matcher(r1)
            boolean r6 = r6.matches()
            if (r6 == 0) goto L26
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r3] = r5
            r8 = 1
            r7[r8] = r1
            return r7
        L26:
            int r4 = r4 + 1
            goto Lf
        L29:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.a(java.io.BufferedReader, java.util.regex.Pattern[]):java.lang.Object[]");
    }

    private static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    public static a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            y.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(String str2, int i2, String str3, String str4) {
                y.c("new thread %s", str2);
                a aVar2 = a.this;
                if (aVar2.f6568d == null) {
                    aVar2.f6568d = new HashMap();
                }
                Map<String, String[]> map = a.this.f6568d;
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                map.put(str2, new String[]{str3, str4, sb.toString()});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j2, long j3, String str2) {
                y.c("new process %s", str2);
                a aVar2 = a.this;
                aVar2.a = j2;
                aVar2.b = str2;
                aVar2.f6567c = j3;
                return z;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j2) {
                y.c("process end %d", Long.valueOf(j2));
                return false;
            }
        });
        if (aVar.a <= 0 || aVar.f6567c <= 0 || aVar.b == null) {
            y.e("first dump error %s", aVar.a + ExpandableTextView.N + aVar.f6567c + ExpandableTextView.N + aVar.b);
            return null;
        }
        return aVar;
    }

    public static a readTargetDumpInfo(final String str, String str2, final boolean z) {
        if (str != null && str2 != null) {
            final a aVar = new a();
            readTraceFile(str2, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.1
                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(String str3, int i2, String str4, String str5) {
                    y.c("new thread %s", str3);
                    a aVar2 = a.this;
                    if (aVar2.a > 0 && aVar2.f6567c > 0 && aVar2.b != null) {
                        if (aVar2.f6568d == null) {
                            aVar2.f6568d = new HashMap();
                        }
                        Map<String, String[]> map = a.this.f6568d;
                        StringBuilder sb = new StringBuilder();
                        sb.append(i2);
                        map.put(str3, new String[]{str4, str5, sb.toString()});
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j2, long j3, String str3) {
                    y.c("new process %s", str3);
                    if (str3.equals(str)) {
                        a aVar2 = a.this;
                        aVar2.a = j2;
                        aVar2.b = str3;
                        aVar2.f6567c = j3;
                        return z;
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j2) {
                    y.c("process end %d", Long.valueOf(j2));
                    a aVar2 = a.this;
                    return aVar2.a <= 0 || aVar2.f6567c <= 0 || aVar2.b == null;
                }
            });
            if (aVar.a > 0 && aVar.f6567c > 0 && aVar.b != null) {
                return aVar;
            }
        }
        return null;
    }

    public static void readTraceFile(String str, b bVar) {
        Throwable th;
        if (str == null || bVar == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        file.lastModified();
        file.length();
        BufferedReader bufferedReader = null;
        int i2 = 0;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                try {
                    Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b0.a.f14658i, Locale.US);
                    while (true) {
                        Pattern[] patternArr = new Pattern[1];
                        patternArr[i2] = compile;
                        Object[] a2 = a(bufferedReader2, patternArr);
                        if (a2 != null) {
                            Pattern[] patternArr2 = new Pattern[1];
                            patternArr2[i2] = compile3;
                            Object[] a3 = a(bufferedReader2, patternArr2);
                            if (a3 == null) {
                                y.d("Failed to find process name.", new Object[i2]);
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e2) {
                                    if (y.a(e2)) {
                                        return;
                                    }
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            String[] split = a2[1].toString().split("\\s");
                            long parseLong = Long.parseLong(split[2]);
                            long time = simpleDateFormat.parse(split[4] + ExpandableTextView.N + split[5]).getTime();
                            Matcher matcher = compile3.matcher(a3[1].toString());
                            matcher.find();
                            matcher.group(1);
                            SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                            if (!bVar.a(parseLong, time, matcher.group(1))) {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e3) {
                                    if (y.a(e3)) {
                                        return;
                                    }
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            while (true) {
                                Object[] a4 = a(bufferedReader2, compile4, compile2);
                                if (a4 == null) {
                                    break;
                                } else if (a4[0] == compile4) {
                                    String obj = a4[1].toString();
                                    Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                    matcher2.find();
                                    String group = matcher2.group();
                                    String substring = group.substring(1, group.length() - 1);
                                    obj.contains("NATIVE");
                                    Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                                    matcher3.find();
                                    String group2 = matcher3.group();
                                    bVar.a(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), a(bufferedReader2), b(bufferedReader2));
                                } else if (!bVar.a(Long.parseLong(a4[1].toString().split("\\s")[2]))) {
                                    try {
                                        bufferedReader2.close();
                                        return;
                                    } catch (IOException e4) {
                                        if (y.a(e4)) {
                                            return;
                                        }
                                        e4.printStackTrace();
                                        return;
                                    }
                                }
                            }
                            simpleDateFormat = simpleDateFormat2;
                            i2 = 0;
                        } else {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e5) {
                                if (y.a(e5)) {
                                    return;
                                }
                                e5.printStackTrace();
                                return;
                            }
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    bufferedReader = bufferedReader2;
                    if (!y.a(e)) {
                        e.printStackTrace();
                    }
                    y.d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                            if (y.a(e7)) {
                                return;
                            }
                            e7.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e8) {
                            if (!y.a(e8)) {
                                e8.printStackTrace();
                            }
                        }
                    }
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 3; i2++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }
}
