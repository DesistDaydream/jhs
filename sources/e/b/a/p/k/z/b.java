package e.b.a.p.k.z;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class b {
    private static final String a = "GlideRuntimeCompat";
    private static final String b = "cpu[0-9]+";

    /* renamed from: c  reason: collision with root package name */
    private static final String f9682c = "/sys/devices/system/cpu/";

    /* loaded from: classes.dex */
    public class a implements FilenameFilter {
        public final /* synthetic */ Pattern a;

        public a(Pattern pattern) {
            this.a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.a.matcher(str).matches();
        }
    }

    private b() {
    }

    public static int a() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(b(), availableProcessors) : availableProcessors;
    }

    private static int b() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            fileArr = new File(f9682c).listFiles(new a(Pattern.compile(b)));
        } catch (Throwable th) {
            try {
                if (Log.isLoggable(a, 6)) {
                    Log.e(a, "Failed to calculate accurate cpu count", th);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                fileArr = null;
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return Math.max(1, fileArr != null ? fileArr.length : 0);
    }
}
