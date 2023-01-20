package d.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import cn.thinkingdata.android.TDPresetProperties;
import cn.thinkingdata.android.ThinkingAnalyticsSDK;
import cn.thinkingdata.android.crash.CrashLogListener;
import cn.thinkingdata.android.utils.TDLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j {

    /* renamed from: c  reason: collision with root package name */
    private static j f9291c;
    private final Context a;
    private boolean b;

    /* loaded from: classes.dex */
    public class a implements CrashLogListener {

        /* renamed from: d.a.a.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0301a implements ThinkingAnalyticsSDK.b {
            public final /* synthetic */ String a;
            public final /* synthetic */ File b;

            public C0301a(a aVar, String str, File file) {
                this.a = str;
                this.b = file;
            }

            @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK.b
            public void a(ThinkingAnalyticsSDK thinkingAnalyticsSDK) {
                if (thinkingAnalyticsSDK.shouldTrackCrash()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (this.a.getBytes("UTF-8").length > 16384) {
                                if (!TDPresetProperties.disableList.contains("#app_crashed_reason")) {
                                    jSONObject.put("#app_crashed_reason", new String(cn.thinkingdata.android.utils.g.c(this.a, 16384), "UTF-8"));
                                }
                            } else if (!TDPresetProperties.disableList.contains("#app_crashed_reason")) {
                                jSONObject.put("#app_crashed_reason", this.a);
                            }
                        } catch (UnsupportedEncodingException unused) {
                            if (this.a.length() > 8192 && !TDPresetProperties.disableList.contains("#app_crashed_reason")) {
                                jSONObject.put("#app_crashed_reason", this.a.substring(0, 8192));
                            }
                        }
                        thinkingAnalyticsSDK.trackAppCrashAndEndEvent(jSONObject);
                        this.b.delete();
                    } catch (JSONException unused2) {
                    }
                }
            }
        }

        public a(j jVar) {
        }

        @Override // cn.thinkingdata.android.crash.CrashLogListener
        public void onFile(File file) {
            ThinkingAnalyticsSDK.allInstances(new C0301a(this, j.b(file), file));
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            jVar.d(jVar.a);
        }
    }

    /* loaded from: classes.dex */
    public class c implements CrashLogListener {

        /* loaded from: classes.dex */
        public class a implements ThinkingAnalyticsSDK.b {
            public final /* synthetic */ String a;
            public final /* synthetic */ File b;

            public a(c cVar, String str, File file) {
                this.a = str;
                this.b = file;
            }

            @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK.b
            public void a(ThinkingAnalyticsSDK thinkingAnalyticsSDK) {
                if (thinkingAnalyticsSDK.shouldTrackCrash()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (this.a.getBytes("UTF-8").length > 16384) {
                                if (!TDPresetProperties.disableList.contains("#app_crashed_reason")) {
                                    jSONObject.put("#app_crashed_reason", new String(cn.thinkingdata.android.utils.g.c(this.a, 16384), "UTF-8"));
                                }
                            } else if (!TDPresetProperties.disableList.contains("#app_crashed_reason")) {
                                jSONObject.put("#app_crashed_reason", this.a);
                            }
                        } catch (UnsupportedEncodingException unused) {
                            if (this.a.length() > 8192 && !TDPresetProperties.disableList.contains("#app_crashed_reason")) {
                                jSONObject.put("#app_crashed_reason", this.a.substring(0, 8192));
                            }
                        }
                        thinkingAnalyticsSDK.autoTrack("ta_app_crash", jSONObject);
                        this.b.delete();
                    } catch (JSONException unused2) {
                    }
                }
            }
        }

        public c(j jVar) {
        }

        @Override // cn.thinkingdata.android.crash.CrashLogListener
        public void onFile(File file) {
            ThinkingAnalyticsSDK.allInstances(new a(this, j.b(file), file));
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Thread.UncaughtExceptionHandler {
        private final Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();

        /* loaded from: classes.dex */
        public class a implements ThinkingAnalyticsSDK.b {
            public final /* synthetic */ String a;

            public a(d dVar, String str) {
                this.a = str;
            }

            @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK.b
            public void a(ThinkingAnalyticsSDK thinkingAnalyticsSDK) {
                if (thinkingAnalyticsSDK.shouldTrackCrash()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (this.a.getBytes("UTF-8").length > 16384) {
                                if (!TDPresetProperties.disableList.contains("#app_crashed_reason")) {
                                    jSONObject.put("#app_crashed_reason", new String(cn.thinkingdata.android.utils.g.c(this.a, 16384), "UTF-8"));
                                }
                            } else if (!TDPresetProperties.disableList.contains("#app_crashed_reason")) {
                                jSONObject.put("#app_crashed_reason", this.a);
                            }
                        } catch (UnsupportedEncodingException unused) {
                            TDLog.d("ThinkingAnalytics.ExceptionHandler", "Exception occurred in getBytes. ");
                            if (this.a.length() > 8192 && !TDPresetProperties.disableList.contains("#app_crashed_reason")) {
                                jSONObject.put("#app_crashed_reason", this.a.substring(0, 8192));
                            }
                        }
                        thinkingAnalyticsSDK.trackAppCrashAndEndEvent(jSONObject);
                    } catch (JSONException unused2) {
                    }
                }
            }
        }

        public d() {
            Thread.setDefaultUncaughtExceptionHandler(this);
        }

        private void a() {
            Process.killProcess(Process.myPid());
            System.exit(10);
        }

        private void b(Throwable th) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            do {
                th.printStackTrace(printWriter);
                th = th.getCause();
            } while (th != null);
            printWriter.close();
            ThinkingAnalyticsSDK.allInstances(new a(this, stringWriter.toString().replaceAll("(\r\n|\n\r|\n|\r)", "<br>")));
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            boolean z;
            Throwable th2 = th;
            while (true) {
                if (th2 == null) {
                    z = true;
                    break;
                } else if (th2 instanceof cn.thinkingdata.android.m) {
                    z = false;
                    break;
                } else {
                    th2 = th2.getCause();
                }
            }
            if (z) {
                b(th);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } else {
                a();
            }
        }
    }

    private j(Context context) {
        this.a = context.getApplicationContext();
    }

    public static String b(File file) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                        stringBuffer.append("\n");
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return stringBuffer.toString();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                String stringBuffer2 = stringBuffer.toString();
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return stringBuffer2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        File[] listFiles;
        c cVar = new c(this);
        File file = new File(context.getCacheDir().getAbsolutePath() + File.separator + "tacrash");
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            cVar.onFile(file2);
        }
    }

    public static j f(Context context) {
        if (f9291c == null) {
            if (context == null) {
                return null;
            }
            synchronized (d.class) {
                if (f9291c == null) {
                    f9291c = new j(context);
                }
            }
        }
        return f9291c;
    }

    public synchronized void c() {
        Boolean bool = Boolean.TRUE;
        Class<?> cls = Boolean.TYPE;
        synchronized (this) {
            if (!this.b) {
                ArrayList arrayList = new ArrayList();
                try {
                    Resources resources = this.a.getResources();
                    arrayList.addAll(Arrays.asList(resources.getStringArray(resources.getIdentifier("TACrashConfig", "array", this.a.getPackageName()))));
                } catch (Exception unused) {
                }
                if (arrayList.isEmpty()) {
                    new d();
                } else {
                    a aVar = new a(this);
                    new Thread(new b()).start();
                    try {
                        Class<?> cls2 = Class.forName("cn.thinkingdata.android.crash.TACrash");
                        Object invoke = cls2.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                        cls2.getMethod("init", Context.class).invoke(invoke, this.a);
                        cls2.getMethod("enableLog", new Class[0]).invoke(invoke, new Object[0]);
                        if (arrayList.contains("java")) {
                            cls2.getMethod("initJavaCrashHandler", cls).invoke(invoke, bool);
                        }
                        if (arrayList.contains("anr") || arrayList.contains("native")) {
                            cls2.getMethod("initNativeCrashHandler", cls, cls, cls, cls).invoke(invoke, bool, bool, bool, bool);
                            if (arrayList.contains("anr")) {
                                cls2.getMethod("initANRHandler", new Class[0]).invoke(invoke, new Object[0]);
                            }
                        }
                        cls2.getMethod("initCrashLogListener", CrashLogListener.class).invoke(invoke, aVar);
                    } catch (Exception unused2) {
                    }
                }
                this.b = true;
            }
        }
    }
}
