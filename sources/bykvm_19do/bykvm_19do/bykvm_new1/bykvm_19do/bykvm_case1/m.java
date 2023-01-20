package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaomi.mipush.sdk.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: classes.dex */
public final class m {

    /* loaded from: classes.dex */
    public static class a {
        private final PrintWriter a;

        public a(PrintWriter printWriter) {
            this.a = printWriter;
        }

        public Object a() {
            return this.a;
        }

        public void a(Object obj) {
            this.a.println(obj);
        }
    }

    @NonNull
    public static String a(@NonNull Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            if (c(th)) {
                a(th, printWriter);
            } else {
                th.printStackTrace(printWriter);
            }
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            return stringWriter2;
        } catch (Exception unused) {
            printWriter.close();
            return "";
        } catch (Throwable th2) {
            printWriter.close();
            throw th2;
        }
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            a(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StringBuilder a(StackTraceElement stackTraceElement, StringBuilder sb) {
        String className = stackTraceElement.getClassName();
        sb.append("  at ");
        sb.append(className);
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        sb.append("(");
        sb.append(stackTraceElement.getFileName());
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")\n");
        return sb;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00cd, code lost:
        if (r11.length() > 0) goto L40;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(java.lang.String r16) {
        /*
            r0 = r16
            java.lang.String r1 = ")"
            java.lang.String r2 = "("
            java.util.Map r4 = java.lang.Thread.getAllStackTraces()     // Catch: java.lang.Throwable -> Lde
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lde
            r5.<init>()     // Catch: java.lang.Throwable -> Lde
            if (r4 != 0) goto L13
            goto Lde
        L13:
            java.lang.String r6 = "thread_all_count"
            int r7 = r4.size()     // Catch: java.lang.Throwable -> Lde
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> Lde
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Lde
            r6.<init>()     // Catch: java.lang.Throwable -> Lde
            java.util.Set r4 = r4.entrySet()     // Catch: java.lang.Throwable -> Lde
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> Lde
        L29:
            boolean r7 = r4.hasNext()     // Catch: java.lang.Throwable -> Lde
            if (r7 == 0) goto Ld7
            java.lang.Object r7 = r4.next()     // Catch: java.lang.Throwable -> Lde
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch: java.lang.Throwable -> Lde
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lde
            r8.<init>()     // Catch: java.lang.Throwable -> Lde
            java.lang.Object r9 = r7.getKey()     // Catch: java.lang.Throwable -> Lde
            java.lang.Thread r9 = (java.lang.Thread) r9     // Catch: java.lang.Throwable -> Lde
            java.lang.String r10 = r9.getName()     // Catch: java.lang.Throwable -> Lde
            boolean r11 = b(r10)     // Catch: java.lang.Throwable -> Lde
            if (r11 != 0) goto L29
            if (r0 == 0) goto L5e
            boolean r11 = r0.equals(r10)     // Catch: java.lang.Throwable -> Lde
            if (r11 != 0) goto L29
            boolean r11 = r10.startsWith(r0)     // Catch: java.lang.Throwable -> Lde
            if (r11 != 0) goto L29
            boolean r10 = r10.endsWith(r0)     // Catch: java.lang.Throwable -> Lde
            if (r10 != 0) goto L29
        L5e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lde
            r10.<init>()     // Catch: java.lang.Throwable -> Lde
            java.lang.String r11 = "thread_name"
            java.lang.String r12 = r9.getName()     // Catch: java.lang.Throwable -> Lde
            r10.append(r12)     // Catch: java.lang.Throwable -> Lde
            r10.append(r2)     // Catch: java.lang.Throwable -> Lde
            long r12 = r9.getId()     // Catch: java.lang.Throwable -> Lde
            r10.append(r12)     // Catch: java.lang.Throwable -> Lde
            r10.append(r1)     // Catch: java.lang.Throwable -> Lde
            java.lang.String r9 = r10.toString()     // Catch: java.lang.Throwable -> Lde
            r8.put(r11, r9)     // Catch: java.lang.Throwable -> Lde
            java.lang.Object r7 = r7.getValue()     // Catch: java.lang.Throwable -> Lde
            java.lang.StackTraceElement[] r7 = (java.lang.StackTraceElement[]) r7     // Catch: java.lang.Throwable -> Lde
            r9 = 0
            r10 = 1
            if (r7 == 0) goto Lcf
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Lde
            r11.<init>()     // Catch: java.lang.Throwable -> Lde
            int r12 = r7.length     // Catch: java.lang.Throwable -> Lde
            r13 = 0
        L91:
            if (r13 >= r12) goto Lc4
            r14 = r7[r13]
            java.lang.String r15 = r14.getClassName()     // Catch: java.lang.Throwable -> Lde
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lde
            r3.<init>()     // Catch: java.lang.Throwable -> Lde
            r3.append(r15)     // Catch: java.lang.Throwable -> Lde
            java.lang.String r15 = "."
            r3.append(r15)     // Catch: java.lang.Throwable -> Lde
            java.lang.String r15 = r14.getMethodName()     // Catch: java.lang.Throwable -> Lde
            r3.append(r15)     // Catch: java.lang.Throwable -> Lde
            r3.append(r2)     // Catch: java.lang.Throwable -> Lde
            int r14 = r14.getLineNumber()     // Catch: java.lang.Throwable -> Lde
            r3.append(r14)     // Catch: java.lang.Throwable -> Lde
            r3.append(r1)     // Catch: java.lang.Throwable -> Lde
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lde
            r11.put(r3)     // Catch: java.lang.Throwable -> Lde
            int r13 = r13 + 1
            goto L91
        Lc4:
            java.lang.String r3 = "thread_stack"
            r8.put(r3, r11)     // Catch: java.lang.Throwable -> Lde
            int r3 = r11.length()     // Catch: java.lang.Throwable -> Lde
            if (r3 <= 0) goto Ld0
        Lcf:
            r9 = 1
        Ld0:
            if (r9 == 0) goto L29
            r6.put(r8)     // Catch: java.lang.Throwable -> Lde
            goto L29
        Ld7:
            java.lang.String r0 = "thread_stacks"
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> Lde
            r3 = r5
            goto Ldf
        Lde:
            r3 = 0
        Ldf:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.m.a(java.lang.String):org.json.JSONObject");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(Throwable th, a aVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            aVar.a("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int min = Math.min(stackTrace.length, 256);
        int i2 = min - 1;
        int i3 = i2;
        for (int min2 = Math.min(stackTraceElementArr.length, 256) - 1; i3 >= 0 && min2 >= 0 && stackTrace[i3].equals(stackTraceElementArr[min2]); min2--) {
            i3--;
        }
        int i4 = i2 - i3;
        aVar.a(str2 + str + th);
        for (int i5 = 0; i5 <= i3; i5++) {
            aVar.a(str2 + "\tat " + stackTrace[i5]);
        }
        if (min < stackTrace.length) {
            aVar.a("\t... skip " + (stackTrace.length - min) + " lines");
        }
        if (i4 != 0) {
            aVar.a(str2 + "\t... " + i4 + " more");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, aVar, stackTrace, "Suppressed: ", str2 + "\t", set);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, aVar, stackTrace, "Caused by: ", str2, set);
        }
    }

    private static void a(Throwable th, PrintWriter printWriter) {
        if (th == null || printWriter == null) {
            return;
        }
        a aVar = new a(printWriter);
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        synchronized (aVar.a()) {
            aVar.a(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (i3 > 256) {
                    aVar.a("\t... skip " + (stackTrace.length - i3) + " lines");
                    break;
                }
                aVar.a("\tat " + stackTraceElement);
                i3++;
                i2++;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable th2 : th.getSuppressed()) {
                    a(th2, aVar, stackTrace, "Suppressed: ", "\t", newSetFromMap);
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, aVar, stackTrace, "Caused by: ", "", newSetFromMap);
            }
        }
    }

    private static boolean b(String str) {
        Set<String> a2 = e.a();
        if (!a2.contains(str)) {
            for (String str2 : a2) {
                if (TextUtils.isEmpty(str) || !str.startsWith(str2)) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean b(Throwable th) {
        if (th == null) {
            return false;
        }
        int i2 = 0;
        while (th != null) {
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                if (i2 > 20) {
                    return false;
                }
                i2++;
                th = th.getCause();
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    private static boolean c(Throwable th) {
        int i2 = 0;
        while (th != null) {
            if (th instanceof StackOverflowError) {
                return true;
            }
            if (i2 > 20) {
                return false;
            }
            th = th.getCause();
            i2++;
        }
        return false;
    }
}
