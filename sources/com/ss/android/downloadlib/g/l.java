package com.ss.android.downloadlib.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.n;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class l {
    private static Object[] b = new Object[0];

    /* renamed from: c  reason: collision with root package name */
    private static Object[] f5410c = new Object[73];
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: d  reason: collision with root package name */
    private static String f5411d = null;

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int min = Math.min(split.length, split2.length);
                int i2 = 0;
                int i3 = 0;
                while (i2 < min) {
                    i3 = Integer.parseInt(split[i2]) - Integer.parseInt(split2[i2]);
                    if (i3 != 0) {
                        break;
                    }
                    i2++;
                }
                if (i3 != 0) {
                    return i3 > 0 ? 1 : -1;
                }
                for (int i4 = i2; i4 < split.length; i4++) {
                    if (Integer.parseInt(split[i4]) > 0) {
                        return 1;
                    }
                }
                while (i2 < split2.length) {
                    if (Integer.parseInt(split2[i2]) > 0) {
                        return -1;
                    }
                    i2++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static long a(long j2) {
        try {
            return a(Environment.getExternalStorageDirectory(), j2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return j2;
        }
    }

    public static long a(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getTotalBytes();
            }
            return -1L;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public static long a(File file, long j2) {
        if (file == null) {
            return j2;
        }
        try {
            return com.ss.android.socialbase.downloader.i.f.d(file.getAbsolutePath());
        } catch (Exception e2) {
            e2.printStackTrace();
            return j2;
        }
    }

    public static long a(JSONObject jSONObject, String str) {
        return com.ss.android.download.api.c.b.a(jSONObject, str);
    }

    public static PackageInfo a(com.ss.android.downloadad.api.a.b bVar) {
        DownloadInfo downloadInfo;
        if (bVar == null || (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.j.getContext()).getDownloadInfo(bVar.s())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.c.a(com.ss.android.downloadlib.addownload.j.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Drawable a(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static com.ss.android.downloadlib.addownload.b.c a(String str, int i2, String str2) {
        com.ss.android.downloadlib.addownload.b.c cVar = new com.ss.android.downloadlib.addownload.b.c();
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        try {
            PackageInfo packageInfo = com.ss.android.downloadlib.addownload.j.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                cVar.b(packageInfo.versionCode);
                cVar.a(com.ss.android.downloadlib.addownload.b.c.b);
                n g2 = com.ss.android.downloadlib.addownload.j.g();
                if (g2 != null && g2.a() && !a(packageInfo.versionCode, i2, packageInfo.versionName, str2)) {
                    cVar.a(com.ss.android.downloadlib.addownload.b.c.f5244c);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return cVar;
    }

    @NonNull
    public static <T> T a(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (t != null) {
                    return t;
                }
            }
            throw new IllegalArgumentException("args is null");
        }
        throw new IllegalArgumentException("args is null");
    }

    public static String a(String str, int i2) {
        return i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public static String a(String... strArr) {
        return com.ss.android.download.api.c.b.a(strArr);
    }

    @NonNull
    public static JSONObject a(JSONObject jSONObject) {
        return com.ss.android.download.api.c.b.a(jSONObject);
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.ss.android.download.api.c.b.a(jSONObject, jSONObject2);
    }

    @NonNull
    public static JSONObject a(JSONObject... jSONObjectArr) {
        return com.ss.android.download.api.c.b.a(jSONObjectArr);
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean a(int i2, int i3, String str, String str2) {
        if (i3 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i3 > 0 && i2 >= i3) || a(str, str2) >= 0;
    }

    public static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                return !queryIntentActivities.isEmpty();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) != null && packageArchiveInfo.packageName.equals(str2)) {
                int i2 = packageArchiveInfo.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    return false;
                }
                return i2 == packageInfo.versionCode;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return a(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).a();
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < signatureArr.length; i2++) {
            if ((signatureArr[i2] == null && signatureArr2[i2] != null) || (signatureArr[i2] != null && !signatureArr[i2].equals(signatureArr2[i2]))) {
                return false;
            }
        }
        return true;
    }

    public static int b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @NonNull
    public static HashMap<String, String> b(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                return hashMap;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return hashMap;
    }

    @SuppressLint({"MissingPermission"})
    public static void b() {
        try {
            if (com.ss.android.downloadlib.addownload.j.e().a(com.ss.android.downloadlib.addownload.j.getContext(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.j.getContext().getSystemService("activity");
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    if (com.ss.android.downloadlib.addownload.j.getContext().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean b(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.j.getContext();
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static boolean b(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return false;
        }
        return a(bVar.e(), bVar.I(), bVar.J()).a();
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static Drawable c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075 A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:17:0x0039, B:19:0x0041, B:21:0x004b, B:23:0x006e, B:26:0x0075, B:28:0x0083, B:22:0x0050), top: B:36:0x0039 }] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(java.lang.String r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            android.content.Context r1 = com.ss.android.downloadlib.addownload.j.getContext()
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            boolean r2 = d(r1, r8)
            if (r2 != 0) goto L15
            return r3
        L15:
            android.content.pm.ApplicationInfo r2 = r1.getApplicationInfo()
            int r2 = r2.targetSdkVersion
            org.json.JSONObject r4 = com.ss.android.downloadlib.addownload.j.i()
            java.lang.String r5 = "get_ext_dir_mode"
            int r4 = r4.optInt(r5)
            r6 = 1
            r7 = 29
            if (r4 != 0) goto L37
            if (r0 < r7) goto L37
            if (r2 != r7) goto L34
            boolean r4 = android.os.Environment.isExternalStorageLegacy()
            if (r4 == 0) goto L36
        L34:
            if (r2 <= r7) goto L37
        L36:
            return r6
        L37:
            if (r0 < r7) goto L50
            android.content.pm.ApplicationInfo r0 = r1.getApplicationInfo()     // Catch: java.lang.Exception -> L8b
            int r0 = r0.targetSdkVersion     // Catch: java.lang.Exception -> L8b
            if (r0 < r7) goto L50
            org.json.JSONObject r0 = com.ss.android.downloadlib.addownload.j.i()     // Catch: java.lang.Exception -> L8b
            int r0 = r0.optInt(r5)     // Catch: java.lang.Exception -> L8b
            if (r0 != r6) goto L50
            java.io.File r0 = i(r1, r8)     // Catch: java.lang.Exception -> L8b
            goto L6e
        L50:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L8b
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Exception -> L8b
            java.lang.String r2 = r2.getPath()     // Catch: java.lang.Exception -> L8b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L8b
            r4.<init>()     // Catch: java.lang.Exception -> L8b
            java.lang.String r5 = "android/data/"
            r4.append(r5)     // Catch: java.lang.Exception -> L8b
            r4.append(r8)     // Catch: java.lang.Exception -> L8b
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L8b
            r0.<init>(r2, r4)     // Catch: java.lang.Exception -> L8b
        L6e:
            boolean r2 = r0.exists()     // Catch: java.lang.Exception -> L8b
            if (r2 != 0) goto L75
            return r3
        L75:
            long r4 = com.ss.android.downloadlib.g.g.a(r0)     // Catch: java.lang.Exception -> L8b
            android.content.pm.PackageManager r0 = r1.getPackageManager()     // Catch: java.lang.Exception -> L8b
            android.content.pm.PackageInfo r8 = r0.getPackageInfo(r8, r3)     // Catch: java.lang.Exception -> L8b
            if (r8 == 0) goto L8a
            long r0 = r8.lastUpdateTime     // Catch: java.lang.Exception -> L8b
            int r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r8 >= 0) goto L8a
            return r6
        L8a:
            return r3
        L8b:
            r8 = move-exception
            r8.printStackTrace()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.g.l.c(java.lang.String):boolean");
    }

    public static boolean d(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.j.getContext();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean e(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i2 = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i2 <= packageInfo.versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static Intent f(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static Signature[] g(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Signature[] h(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static File i(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        String parent = parentFile != null ? parentFile.getParent() : null;
        File file = new File(parent + File.separator + str);
        StringBuilder sb = new StringBuilder();
        sb.append("getExtDir: file.toString()-->");
        sb.append(file.toString());
        com.ss.android.socialbase.downloader.c.a.b("ToolUtils", sb.toString());
        return file;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0000, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String l1663646904319dc(java.lang.String r2) {
        /*
        L0:
            r0 = 73
            r1 = 96
        L4:
            switch(r0) {
                case 72: goto L26;
                case 73: goto L8;
                case 74: goto Lb;
                default: goto L7;
            }
        L7:
            goto L2b
        L8:
            switch(r1) {
                case 94: goto L0;
                case 95: goto L26;
                case 96: goto L26;
                default: goto Lb;
            }
        Lb:
            switch(r1) {
                case 55: goto Lf;
                case 56: goto L26;
                case 57: goto L26;
                default: goto Le;
            }
        Le:
            goto L0
        Lf:
            char[] r2 = r2.toCharArray()
            r0 = 0
        L14:
            int r1 = r2.length
            if (r0 >= r1) goto L20
            char r1 = r2[r0]
            r1 = r1 ^ r0
            char r1 = (char) r1
            r2[r0] = r1
            int r0 = r0 + 1
            goto L14
        L20:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            return r0
        L26:
            r0 = 74
            r1 = 55
            goto L4
        L2b:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.g.l.l1663646904319dc(java.lang.String):java.lang.String");
    }
}
