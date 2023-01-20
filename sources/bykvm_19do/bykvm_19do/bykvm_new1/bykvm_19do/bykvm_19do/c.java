package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.m;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import e.t.u.b0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f1148f = true;
    private a a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f1149c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f1150d = false;

    /* renamed from: e  reason: collision with root package name */
    private final SharedPreferences f1151e;

    public c(Context context) {
        if (context == null || !(context instanceof Application)) {
            throw new IllegalArgumentException("context must not be null or not application");
        }
        this.b = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("anr_monitor_table", 0);
        this.f1151e = sharedPreferences;
        this.f1149c = sharedPreferences.getLong("trace_anr_happen_time", 0L);
        g.a(100, 100);
    }

    private String a(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            sb.append(readLine);
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void a(String str) {
        for (bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.f fVar : i.d().a()) {
            fVar.a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.ANR, str, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
        r0 = new java.lang.Object[2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
        r0[0] = r5;
        r0[1] = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object[] a(java.io.BufferedReader r8, java.util.regex.Pattern... r9) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L2c
            if (r9 == 0) goto L2c
            int r1 = r9.length
            if (r1 > 0) goto L9
            goto L2c
        L9:
            java.lang.String r1 = r8.readLine()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2c
            int r2 = r9.length     // Catch: java.lang.Throwable -> L2c
            r3 = 0
            r4 = 0
        L12:
            if (r4 >= r2) goto L9
            r5 = r9[r4]
            java.util.regex.Matcher r6 = r5.matcher(r1)     // Catch: java.lang.Throwable -> L2c
            boolean r6 = r6.matches()     // Catch: java.lang.Throwable -> L2c
            if (r6 == 0) goto L29
            r8 = 2
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L2c
            r0[r3] = r5
            r8 = 1
            r0[r8] = r1
            goto L2c
        L29:
            int r4 = r4 + 1
            goto L12
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do.c.a(java.io.BufferedReader, java.util.regex.Pattern[]):java.lang.Object[]");
    }

    public JSONObject a(String str, int i2, String str2) {
        BufferedReader bufferedReader;
        int i3;
        BufferedReader bufferedReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.f.a(bufferedReader2);
                throw th;
            }
            try {
                try {
                    Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b0.a.f14658i, Locale.US);
                    boolean z = false;
                    Object[] a = a(bufferedReader, compile);
                    if (a != null) {
                        long parseLong = Long.parseLong(a[1].toString().split("\\s")[2]);
                        long time = simpleDateFormat.parse(a[1].toString().split("\\s")[4] + ExpandableTextView.N + a[1].toString().split("\\s")[5]).getTime();
                        Object[] a2 = a(bufferedReader, compile3);
                        if (a2 != null) {
                            String str3 = a2[1].toString().split("\\s")[2];
                            if (parseLong == i2 && str3.equalsIgnoreCase(str2) && (this.f1149c == 0 || Math.abs(this.f1149c - time) >= 20000)) {
                                this.f1149c = time;
                                SharedPreferences sharedPreferences = this.f1151e;
                                if (sharedPreferences != null) {
                                    sharedPreferences.edit().putLong("trace_anr_happen_time", this.f1149c).apply();
                                }
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("anrTime", time);
                                while (true) {
                                    Object[] a3 = a(bufferedReader, compile2, compile4);
                                    if (a3 == null || a3[0] != compile4) {
                                        break;
                                    }
                                    Matcher matcher = Pattern.compile("\".+\"").matcher(a3[1].toString());
                                    String substring = matcher.find() ? matcher.group().substring(1, matcher.group().length() - 1) : "";
                                    Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(a3[1].toString());
                                    if (matcher2.find()) {
                                        String group = matcher2.group();
                                        i3 = Integer.parseInt(group.substring(group.indexOf("=") + 1));
                                    } else {
                                        i3 = -1;
                                    }
                                    String a4 = a(bufferedReader);
                                    if (i3 != -1 && !TextUtils.isEmpty(substring) && !TextUtils.isEmpty(a4) && substring.equalsIgnoreCase("main")) {
                                        jSONObject.put("mainStackFromTrace", a4);
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    jSONObject.put("thread_number", 1);
                                    bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.f.a(bufferedReader);
                                    return jSONObject;
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.f.a(bufferedReader2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.f.a(bufferedReader);
                return null;
            }
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.f.a(bufferedReader);
            return null;
        }
        return null;
    }

    public void a() {
        if (this.f1150d) {
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            a aVar = new a(this, "/data/anr/", 8);
            this.a = aVar;
            aVar.startWatching();
        } else {
            new d(this);
        }
        this.f1150d = true;
    }

    public boolean a(int i2, String str, int i3) {
        JSONObject jSONObject;
        JSONObject a;
        JSONArray q = g.q();
        long uptimeMillis = SystemClock.uptimeMillis();
        JSONObject c2 = g.c(uptimeMillis);
        JSONArray a2 = g.a(100, uptimeMillis);
        try {
            jSONObject = e.a(f1148f);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONObject = null;
        }
        String a3 = e.a(this.b, i3);
        if (TextUtils.isEmpty(a3)) {
            return false;
        }
        if (i2 == 200 && (a = a(str, Process.myPid(), this.b.getPackageName())) != null && a.length() > 0) {
            jSONObject = a;
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return true;
        }
        try {
            jSONObject.put("pid", Process.myPid());
            jSONObject.put("package", this.b.getPackageName());
            jSONObject.put("is_remote_process", 0);
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a(new JSONObject());
            aVar.a("data", jSONObject.toString());
            aVar.a("is_anr", (Object) 1);
            aVar.a("timestamp", Long.valueOf(System.currentTimeMillis()));
            aVar.a("event_type", "anr");
            aVar.a("history_message", q);
            aVar.a("current_message", c2);
            aVar.a("pending_messages", a2);
            aVar.a("anr_time", Long.valueOf(System.currentTimeMillis()));
            aVar.a("crash_time", Long.valueOf(System.currentTimeMillis()));
            aVar.a("anr_info", a3);
            aVar.a("all_thread_stacks", m.a((String) null));
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do.e a4 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do.e.a();
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c cVar = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.ANR;
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a a5 = a4.a(cVar, aVar);
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.d.a(this.b, cVar.a(), (String) null);
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.a.a().b(a5.a());
            a(a3);
            return true;
        } catch (Throwable th) {
            j.b(th);
            return true;
        }
    }
}
