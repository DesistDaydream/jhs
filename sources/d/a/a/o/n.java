package d.a.a.o;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import cn.thinkingdata.android.R;
import cn.thinkingdata.android.ScreenAutoTracker;
import cn.thinkingdata.android.TDPresetProperties;
import cn.thinkingdata.android.ThinkingDataFragmentTitle;
import cn.thinkingdata.android.utils.TDLog;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class n {
    public static long a;
    public static long b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile int f9308c;

    /* loaded from: classes.dex */
    public static class a implements Choreographer.FrameCallback {
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            int i2;
            n.b = j2;
            if (j2 > n.a) {
                long j3 = 1000000000 / (n.b - n.a);
                if (j3 <= 70) {
                    i2 = (int) j3;
                    n.f9308c = i2;
                }
            }
            i2 = 60;
            n.f9308c = i2;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Choreographer.FrameCallback {
        public final /* synthetic */ Choreographer.FrameCallback a;

        public b(Choreographer.FrameCallback frameCallback) {
            this.a = frameCallback;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            n.a = j2;
            Choreographer.getInstance().postFrameCallback(this.a);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ Choreographer.FrameCallback b;

        public c(Handler handler, Choreographer.FrameCallback frameCallback) {
            this.a = handler;
            this.b = frameCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.postDelayed(this, 500L);
            Choreographer.getInstance().postFrameCallback(this.b);
        }
    }

    public static void A(JSONObject jSONObject, JSONObject jSONObject2, TimeZone timeZone) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            JSONObject optJSONObject2 = jSONObject2.optJSONObject(next);
            if (optJSONObject != null) {
                if (optJSONObject2 == null) {
                    JSONObject jSONObject3 = new JSONObject();
                    v(optJSONObject, jSONObject3, timeZone);
                    jSONObject2.put(next, jSONObject3);
                } else {
                    v(optJSONObject, optJSONObject2, timeZone);
                }
            }
        }
    }

    public static String B(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) < 3 ? "Phone" : "Tablet";
    }

    public static boolean C() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Object invoke = cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
            if (invoke == null) {
                return false;
            }
            return "harmony".equalsIgnoreCase(invoke.toString());
        } catch (Throwable th) {
            TDLog.i("HasHarmonyOS", th.getMessage());
            return false;
        }
    }

    public static String D(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            str = context.getApplicationInfo().processName;
        } catch (Exception unused) {
        }
        return str.length() == 0 ? d.a.a.k.b(context).c() : str;
    }

    public static void E() {
        if (Build.VERSION.SDK_INT >= 16) {
            b bVar = new b(new a());
            Handler handler = new Handler();
            handler.postDelayed(new c(handler, bVar), 500L);
        }
    }

    public static boolean F(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (f.b == null) {
            f.b = activityManager.getRunningAppProcesses();
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : f.b) {
            String str = runningAppProcessInfo.processName;
            int indexOf = str.indexOf(Constants.COLON_SEPARATOR);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            if (str.equals(context.getPackageName())) {
                int i2 = runningAppProcessInfo.importance;
                return i2 == 100 || i2 == 200;
            }
        }
        return false;
    }

    public static boolean G(Context context) {
        if (context == null) {
            return true;
        }
        String y = y(context.getApplicationContext());
        return !TextUtils.isEmpty(y) && D(context).equals(y);
    }

    public static double a(double d2) {
        return Math.round(d2 * 10.0d) / 10.0d;
    }

    public static double b(long j2, TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        return timeZone.getOffset(j2) / 3600000.0d;
    }

    public static int c() {
        if (f9308c == 0) {
            f9308c = 60;
        }
        return f9308c;
    }

    private static int d(ViewParent viewParent, View view) {
        try {
            if (viewParent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) viewParent;
                String j2 = j(view);
                String canonicalName = view.getClass().getCanonicalName();
                int i2 = 0;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (d.a.a.g.a(childAt, canonicalName)) {
                        String j3 = j(childAt);
                        if ((j2 == null || j2.equals(j3)) && childAt == view) {
                            return i2;
                        }
                        i2++;
                    }
                }
                return -1;
            }
            return -1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static int e(String str) {
        if ("NULL".equals(str)) {
            return 255;
        }
        if ("WIFI".equals(str)) {
            return 8;
        }
        if ("2G".equals(str)) {
            return 1;
        }
        if ("3G".equals(str)) {
            return 2;
        }
        if ("4G".equals(str)) {
            return 4;
        }
        return "5G".equals(str) ? 16 : 255;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:
        if ((r1 instanceof android.app.Activity) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.app.Activity f(android.content.Context r1) {
        /*
            if (r1 == 0) goto L25
            boolean r0 = r1 instanceof android.app.Activity     // Catch: java.lang.Exception -> L21
            if (r0 == 0) goto L7
            goto L1e
        L7:
            boolean r0 = r1 instanceof android.content.ContextWrapper     // Catch: java.lang.Exception -> L21
            if (r0 == 0) goto L25
        Lb:
            boolean r0 = r1 instanceof android.app.Activity     // Catch: java.lang.Exception -> L21
            if (r0 != 0) goto L1a
            boolean r0 = r1 instanceof android.content.ContextWrapper     // Catch: java.lang.Exception -> L21
            if (r0 == 0) goto L1a
            android.content.ContextWrapper r1 = (android.content.ContextWrapper) r1     // Catch: java.lang.Exception -> L21
            android.content.Context r1 = r1.getBaseContext()     // Catch: java.lang.Exception -> L21
            goto Lb
        L1a:
            boolean r0 = r1 instanceof android.app.Activity     // Catch: java.lang.Exception -> L21
            if (r0 == 0) goto L25
        L1e:
            android.app.Activity r1 = (android.app.Activity) r1     // Catch: java.lang.Exception -> L21
            goto L26
        L21:
            r1 = move-exception
            r1.printStackTrace()
        L25:
            r1 = 0
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.o.n.f(android.content.Context):android.app.Activity");
    }

    public static synchronized Object g(String str, View view, int i2) {
        synchronized (n.class) {
            HashMap hashMap = (HashMap) view.getTag(i2);
            if (hashMap == null) {
                return null;
            }
            return hashMap.get(str);
        }
    }

    public static String h(int i2) {
        double random;
        double d2;
        char c2;
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int random2 = (int) (Math.random() * 2.0d);
            if (random2 == 0) {
                random = Math.random() * 10.0d;
                d2 = 48.0d;
            } else if (random2 != 1) {
                c2 = 0;
                sb.append(c2);
            } else {
                random = Math.random() * 6.0d;
                d2 = 97.0d;
            }
            c2 = (char) (random + d2);
            sb.append(c2);
        }
        return sb.toString();
    }

    public static String i(Activity activity) {
        PackageManager packageManager;
        if (activity != null) {
            try {
                String charSequence = !TextUtils.isEmpty(activity.getTitle()) ? activity.getTitle().toString() : null;
                if (Build.VERSION.SDK_INT >= 11) {
                    String x = x(activity);
                    if (!TextUtils.isEmpty(x)) {
                        charSequence = x;
                    }
                }
                if (!TextUtils.isEmpty(charSequence) || (packageManager = activity.getPackageManager()) == null) {
                    return charSequence;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(activity.getComponentName(), 0);
                return !TextUtils.isEmpty(activityInfo.loadLabel(packageManager)) ? activityInfo.loadLabel(packageManager).toString() : charSequence;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String j(View view) {
        return k(view, null);
    }

    public static String k(View view, String str) {
        String str2;
        try {
            String str3 = (String) g(str, view, R.id.thinking_analytics_tag_view_id);
            try {
                return (!TextUtils.isEmpty(str3) || view.getId() == -1) ? str3 : view.getContext().getResources().getResourceEntryName(view.getId());
            } catch (Exception unused) {
                return str2;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String l(Object obj, String str) {
        ThinkingDataFragmentTitle thinkingDataFragmentTitle;
        JSONObject trackProperties;
        String str2 = null;
        try {
            if ((obj instanceof ScreenAutoTracker) && (trackProperties = ((ScreenAutoTracker) obj).getTrackProperties()) != null && trackProperties.has("#title")) {
                str2 = trackProperties.optString("#title");
            }
            return (TextUtils.isEmpty(str2) && obj.getClass().isAnnotationPresent(ThinkingDataFragmentTitle.class) && (thinkingDataFragmentTitle = (ThinkingDataFragmentTitle) obj.getClass().getAnnotation(ThinkingDataFragmentTitle.class)) != null) ? (TextUtils.isEmpty(thinkingDataFragmentTitle.appId()) || str.equals(thinkingDataFragmentTitle.appId())) ? thinkingDataFragmentTitle.title() : str2 : str2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String m(String str, int i2) {
        return (!TextUtils.isEmpty(str) && str.length() > i2) ? str.substring(str.length() - 4) : str;
    }

    private static String n(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            TDLog.i("TA.SystemProperties", th.getMessage());
            return str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d8 A[Catch: Exception -> 0x00ed, TryCatch #1 {Exception -> 0x00ed, blocks: (B:4:0x0004, B:6:0x0009, B:8:0x0011, B:64:0x00e4, B:11:0x001d, B:13:0x0021, B:21:0x0035, B:23:0x0039, B:61:0x00d2, B:63:0x00d8, B:26:0x0044, B:28:0x004a, B:30:0x0053, B:32:0x0059, B:36:0x006c, B:33:0x0060, B:35:0x0066, B:37:0x0076, B:39:0x007a, B:40:0x0081, B:42:0x0085, B:44:0x008d, B:45:0x0092, B:46:0x0097, B:48:0x009b, B:49:0x00a2, B:51:0x00a6, B:52:0x00ad, B:54:0x00b1, B:55:0x00b8, B:57:0x00bc, B:59:0x00c8, B:65:0x00e8), top: B:73:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e4 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String o(java.lang.StringBuilder r8, android.view.ViewGroup r9) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.o.n.o(java.lang.StringBuilder, android.view.ViewGroup):java.lang.String");
    }

    public static JSONArray p(JSONArray jSONArray, TimeZone timeZone) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            Object opt = jSONArray.opt(i2);
            if (opt != null) {
                if (opt instanceof Date) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
                    if (timeZone != null) {
                        simpleDateFormat.setTimeZone(timeZone);
                    }
                    opt = simpleDateFormat.format((Date) opt);
                } else if (opt instanceof JSONArray) {
                    opt = p((JSONArray) opt, timeZone);
                } else if (opt instanceof JSONObject) {
                    opt = q((JSONObject) opt, timeZone);
                }
                jSONArray2.put(opt);
            }
        }
        return jSONArray2;
    }

    public static JSONObject q(JSONObject jSONObject, TimeZone timeZone) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof Date) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
                    if (timeZone != null) {
                        simpleDateFormat.setTimeZone(timeZone);
                    }
                    obj = simpleDateFormat.format((Date) obj);
                } else if (obj instanceof JSONArray) {
                    obj = p((JSONArray) obj, timeZone);
                } else if (obj instanceof JSONObject) {
                    obj = q((JSONObject) obj, timeZone);
                }
                jSONObject2.put(next, obj);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject2;
    }

    public static void r(Activity activity, View view, JSONObject jSONObject) {
        ViewParent parent;
        if (view == null) {
            return;
        }
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        do {
            parent = view.getParent();
            int d2 = d(parent, view);
            arrayList.add(view.getClass().getCanonicalName() + "[" + d2 + "]");
            if (parent instanceof ViewGroup) {
                view = (ViewGroup) parent;
            }
        } while (parent instanceof ViewGroup);
        Collections.reverse(arrayList);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 < arrayList.size(); i2++) {
            sb.append((String) arrayList.get(i2));
            if (i2 != arrayList.size() - 1) {
                sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            }
        }
        if (TDPresetProperties.disableList.contains("#element_selector")) {
            return;
        }
        jSONObject.put("#element_selector", sb.toString());
    }

    public static void s(View view, JSONObject jSONObject) {
        if (view != null) {
            try {
                int i2 = R.id.thinking_analytics_tag_view_fragment_name;
                String str = (String) view.getTag(i2);
                if (TextUtils.isEmpty(str) && view.getParent() != null && (view.getParent() instanceof View)) {
                    str = (String) ((View) view.getParent()).getTag(i2);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String optString = jSONObject.optString("#screen_name");
                if (TextUtils.isEmpty(str)) {
                    if (TDPresetProperties.disableList.contains("#screen_name")) {
                        return;
                    }
                    jSONObject.put("#screen_name", str);
                } else if (TDPresetProperties.disableList.contains("#screen_name")) {
                } else {
                    jSONObject.put("#screen_name", String.format(Locale.CHINA, "%s|%s", optString, str));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static synchronized void t(String str, View view, int i2, Object obj) {
        synchronized (n.class) {
            if (str == null) {
                return;
            }
            HashMap hashMap = (HashMap) view.getTag(i2);
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            hashMap.put(str, obj);
            view.setTag(i2, hashMap);
        }
    }

    public static void u(JSONObject jSONObject, Activity activity) {
        PackageManager packageManager;
        if (activity == null || jSONObject == null) {
            return;
        }
        try {
            List<String> list = TDPresetProperties.disableList;
            if (!list.contains("#screen_name")) {
                jSONObject.put("#screen_name", activity.getClass().getCanonicalName());
            }
            String charSequence = activity.getTitle().toString();
            if (Build.VERSION.SDK_INT >= 11) {
                String x = x(activity);
                if (!TextUtils.isEmpty(x)) {
                    charSequence = x;
                }
            }
            if (TextUtils.isEmpty(charSequence) && (packageManager = activity.getPackageManager()) != null) {
                charSequence = packageManager.getActivityInfo(activity.getComponentName(), 0).loadLabel(packageManager).toString();
            }
            if (TextUtils.isEmpty(charSequence) || list.contains("#title")) {
                return;
            }
            jSONObject.put("#title", charSequence);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void v(JSONObject jSONObject, JSONObject jSONObject2, TimeZone timeZone) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof Date) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
                if (timeZone != null) {
                    simpleDateFormat.setTimeZone(timeZone);
                }
                obj = simpleDateFormat.format((Date) obj);
            } else if (obj instanceof JSONArray) {
                obj = p((JSONArray) obj, timeZone);
            } else if (obj instanceof JSONObject) {
                obj = q((JSONObject) obj, timeZone);
            }
            jSONObject2.put(next, obj);
        }
    }

    public static String w() {
        if (C()) {
            String n = n("hw_sc.build.platform.version", "");
            return TextUtils.isEmpty(n) ? z("getprop hw_sc.build.platform.version") : n;
        }
        return null;
    }

    @TargetApi(11)
    public static String x(Activity activity) {
        Class<?> cls;
        Object invoke;
        CharSequence charSequence;
        ActionBar actionBar = activity.getActionBar();
        if (actionBar == null) {
            try {
                cls = Class.forName("androidx.appcompat.app.AppCompatActivity");
            } catch (Exception unused) {
                cls = null;
            }
            if (cls == null) {
                try {
                    cls = Class.forName("androidx.appcompat.app.AppCompatActivity");
                } catch (Exception unused2) {
                }
            }
            if (cls != null) {
                try {
                    if (cls.isInstance(activity) && (invoke = activity.getClass().getMethod("getSupportActionBar", new Class[0]).invoke(activity, new Object[0])) != null && (charSequence = (CharSequence) invoke.getClass().getMethod("getTitle", new Class[0]).invoke(invoke, new Object[0])) != null) {
                        return charSequence.toString();
                    }
                } catch (Exception unused3) {
                }
            }
        } else if (!TextUtils.isEmpty(actionBar.getTitle())) {
            return actionBar.getTitle().toString();
        }
        return null;
    }

    public static String y(Context context) {
        try {
            return f.b(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String z(String str) {
        Throwable th;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream());
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            inputStreamReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Throwable th4) {
                TDLog.i("TDExec", th4.getMessage());
            }
            try {
                inputStreamReader.close();
            } catch (IOException e2) {
                TDLog.i("TDExec", e2.getMessage());
            }
            return sb2;
        } catch (Throwable th5) {
            th = th5;
            try {
                TDLog.i("TDExec", th.getMessage());
                return null;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th6) {
                        TDLog.i("TDExec", th6.getMessage());
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e3) {
                        TDLog.i("TDExec", e3.getMessage());
                    }
                }
            }
        }
    }
}
