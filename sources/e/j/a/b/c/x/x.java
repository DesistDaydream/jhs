package e.j.a.b.c.x;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class x {
    private static String a;
    private static int b;

    private x() {
    }

    @e.j.a.b.c.m.a
    @Nullable
    public static String a() {
        if (a == null) {
            if (b == 0) {
                b = Process.myPid();
            }
            a = b(b);
        }
        return a;
    }

    @Nullable
    private static String b(int i2) {
        Throwable th;
        BufferedReader bufferedReader;
        String str = null;
        if (i2 <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i2);
            sb.append("/cmdline");
            bufferedReader = c(sb.toString());
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            str = bufferedReader.readLine().trim();
            q.b(bufferedReader);
        } catch (IOException unused2) {
            q.b(bufferedReader);
            return str;
        } catch (Throwable th3) {
            th = th3;
            q.b(bufferedReader);
            throw th;
        }
        return str;
    }

    private static BufferedReader c(String str) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
