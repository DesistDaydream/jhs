package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/* loaded from: classes.dex */
public class e {

    /* loaded from: classes.dex */
    public static class a extends Thread {
        private InputStream a;
        private List<String> b;

        public a(InputStream inputStream, List<String> list) {
            this.a = inputStream;
            this.b = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a));
            int i2 = 32768;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!readLine.startsWith("---------")) {
                        i2 -= readLine.getBytes("UTF-8").length;
                        if (i2 < 0) {
                            break;
                        }
                        this.b.add(readLine);
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.f.a(bufferedReader);
                    throw th;
                }
            }
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.f.a(bufferedReader);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Thread {
        private Process a;
        private long b;

        public b(Process process, long j2) {
            this.a = process;
            this.b = j2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(this.b);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            Process process = this.a;
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static String a(int i2) {
        return (i2 < 0 || i2 >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i2];
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0059, code lost:
        if (r5 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> a(int r5, int r6) {
        /*
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            java.lang.String r6 = a(r6)
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L5e
            r2 = 4
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L5e
            r3 = 0
            java.lang.String r4 = "logcat"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L5e
            r3 = 1
            java.lang.String r4 = "-t"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L5e
            r3 = 2
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L5e
            r2[r3] = r5     // Catch: java.lang.Throwable -> L5e
            r5 = 3
            r2[r5] = r6     // Catch: java.lang.Throwable -> L5e
            java.lang.Process r5 = r1.exec(r2)     // Catch: java.lang.Throwable -> L5e
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.e$a r6 = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.e$a     // Catch: java.lang.Throwable -> L5c
            java.io.InputStream r1 = r5.getInputStream()     // Catch: java.lang.Throwable -> L5c
            r6.<init>(r1, r0)     // Catch: java.lang.Throwable -> L5c
            r6.start()     // Catch: java.lang.Throwable -> L5c
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.e$a r6 = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.e$a     // Catch: java.lang.Throwable -> L5c
            java.io.InputStream r1 = r5.getErrorStream()     // Catch: java.lang.Throwable -> L5c
            r6.<init>(r1, r0)     // Catch: java.lang.Throwable -> L5c
            r6.start()     // Catch: java.lang.Throwable -> L5c
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.e$b r6 = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.e$b     // Catch: java.lang.Throwable -> L5c
            r1 = 3000(0xbb8, double:1.482E-320)
            r6.<init>(r5, r1)     // Catch: java.lang.Throwable -> L5c
            r6.start()     // Catch: java.lang.Throwable -> L5c
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L5c
            r3 = 26
            if (r6 < r3) goto L56
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L5c
            r5.waitFor(r1, r6)     // Catch: java.lang.Throwable -> L5c
            goto L59
        L56:
            r5.waitFor()     // Catch: java.lang.Throwable -> L5c
        L59:
            if (r5 == 0) goto L69
            goto L66
        L5c:
            r6 = move-exception
            goto L61
        L5e:
            r5 = move-exception
            r6 = r5
            r5 = 0
        L61:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L6a
            if (r5 == 0) goto L69
        L66:
            r5.destroy()
        L69:
            return r0
        L6a:
            r6 = move-exception
            if (r5 == 0) goto L70
            r5.destroy()
        L70:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.e.a(int, int):java.util.List");
    }
}
