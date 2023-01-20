package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import e.t.u.b0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final class aa {
    public static boolean a = true;
    private static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static SimpleDateFormat f6658c = null;

    /* renamed from: d  reason: collision with root package name */
    private static int f6659d = 30720;

    /* renamed from: e  reason: collision with root package name */
    private static StringBuilder f6660e = null;

    /* renamed from: f  reason: collision with root package name */
    private static StringBuilder f6661f = null;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f6662g = false;

    /* renamed from: h  reason: collision with root package name */
    private static a f6663h = null;

    /* renamed from: i  reason: collision with root package name */
    private static String f6664i = null;

    /* renamed from: j  reason: collision with root package name */
    private static String f6665j = null;

    /* renamed from: k  reason: collision with root package name */
    private static Context f6666k = null;

    /* renamed from: l  reason: collision with root package name */
    private static String f6667l = null;

    /* renamed from: m  reason: collision with root package name */
    private static boolean f6668m = false;
    private static boolean n = false;
    private static ExecutorService o;
    private static int p;
    private static final Object q = new Object();

    /* loaded from: classes3.dex */
    public static class a {
        private boolean a;
        private File b;

        /* renamed from: c  reason: collision with root package name */
        private String f6670c;

        /* renamed from: d  reason: collision with root package name */
        private long f6671d;

        /* renamed from: e  reason: collision with root package name */
        private long f6672e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f6670c = str;
            this.a = a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            try {
                File file = new File(this.f6670c);
                this.b = file;
                if (file.exists() && !this.b.delete()) {
                    this.a = false;
                    return false;
                } else if (this.b.createNewFile()) {
                    return true;
                } else {
                    this.a = false;
                    return false;
                }
            } catch (Throwable th) {
                y.a(th);
                this.a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            FileOutputStream fileOutputStream;
            byte[] bytes;
            if (this.a) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    fileOutputStream = new FileOutputStream(this.b, true);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(str.getBytes("UTF-8"));
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    this.f6671d += bytes.length;
                    this.a = true;
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        y.a(th);
                        this.a = false;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    } catch (Throwable th3) {
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th3;
                    }
                }
            }
            return false;
        }
    }

    static {
        try {
            f6658c = new SimpleDateFormat(b0.a.r);
        } catch (Throwable th) {
            y.b(th.getCause());
        }
    }

    public static synchronized void a(Context context) {
        synchronized (aa.class) {
            if (f6668m || context == null || !a) {
                return;
            }
            try {
                o = Executors.newSingleThreadExecutor();
                f6661f = new StringBuilder(0);
                f6660e = new StringBuilder(0);
                f6666k = context;
                com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
                f6664i = a2.f6520d;
                a2.getClass();
                f6665j = "";
                f6667l = f6666k.getFilesDir().getPath() + "/buglylog_" + f6664i + "_" + f6665j + ".txt";
                p = Process.myPid();
            } catch (Throwable unused) {
            }
            f6668m = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(String str, String str2, String str3) {
        synchronized (aa.class) {
            if (b) {
                d(str, str2, str3);
            } else {
                e(str, str2, str3);
            }
        }
    }

    private static synchronized void d(String str, String str2, String str3) {
        synchronized (aa.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                f6661f.append(a2);
                if (f6661f.length() >= f6659d) {
                    StringBuilder sb = f6661f;
                    f6661f = sb.delete(0, sb.indexOf("\u0001\r\n") + 1);
                }
            }
        }
    }

    private static synchronized void e(String str, String str2, String str3) {
        synchronized (aa.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                try {
                    f6661f.append(a2);
                } catch (Throwable unused) {
                }
                if (f6661f.length() <= f6659d) {
                    return;
                }
                if (f6662g) {
                    return;
                }
                f6662g = true;
                a aVar = f6663h;
                if (aVar != null) {
                    if (aVar.b == null || f6663h.b.length() + f6661f.length() > f6663h.f6672e) {
                        f6663h.a();
                    }
                } else {
                    f6663h = new a(f6667l);
                }
                if (f6663h.a(f6661f.toString())) {
                    f6661f.setLength(0);
                    f6662g = false;
                }
            }
        }
    }

    private static byte[] b() {
        if (a) {
            StringBuilder sb = new StringBuilder();
            synchronized (q) {
                a aVar = f6663h;
                if (aVar != null && aVar.a && f6663h.b != null && f6663h.b.length() > 0) {
                    sb.append(ab.a(f6663h.b, 30720, true));
                }
                StringBuilder sb2 = f6661f;
                if (sb2 != null && sb2.length() > 0) {
                    sb.append(f6661f.toString());
                }
            }
            return ab.a((File) null, sb.toString(), "BuglyLog.txt");
        }
        return null;
    }

    public static void a(int i2) {
        synchronized (q) {
            f6659d = i2;
            if (i2 < 0) {
                f6659d = 0;
            } else if (i2 > 30720) {
                f6659d = 30720;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + ab.b(th));
    }

    public static synchronized void a(final String str, final String str2, final String str3) {
        synchronized (aa.class) {
            if (f6668m && a) {
                try {
                    o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.aa.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            aa.c(str, str2, str3);
                        }
                    });
                } catch (Exception e2) {
                    y.b(e2);
                }
            }
        }
    }

    private static String a(String str, String str2, String str3, long j2) {
        String date;
        f6660e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = f6658c;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb = f6660e;
        sb.append(date);
        sb.append(ExpandableTextView.N);
        sb.append(p);
        sb.append(ExpandableTextView.N);
        sb.append(j2);
        sb.append(ExpandableTextView.N);
        sb.append(str);
        sb.append(ExpandableTextView.N);
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f6660e.toString();
    }

    public static byte[] a() {
        if (b) {
            if (a) {
                return ab.a((File) null, f6661f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return b();
    }
}
