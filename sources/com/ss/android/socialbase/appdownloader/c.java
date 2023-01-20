package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.caverock.androidsvg.SVG;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c {
    private static int a;
    private static NotificationChannel b;

    public static int d(Context context, int i2, boolean z) {
        if (com.ss.android.socialbase.downloader.g.a.a(i2).b("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.b.a().f(i2);
        }
        a((Activity) h.a().b());
        if (com.ss.android.socialbase.downloader.g.a.a(i2).a("install_queue_enable", 0) == 1) {
            return h.a().a(context, i2, z);
        }
        return b(context, i2, z);
    }

    private static String a(long j2, long j3, String str, boolean z) {
        double d2 = j2;
        if (j3 > 1) {
            d2 /= j3;
        }
        if (!z && !"GB".equals(str) && !"TB".equals(str)) {
            return new DecimalFormat(MqttTopic.MULTI_LEVEL_WILDCARD).format(d2) + ExpandableTextView.N + str;
        }
        return new DecimalFormat("#.##").format(d2) + ExpandableTextView.N + str;
    }

    public static String b(long j2) {
        long[] jArr = {1099511627776L, SVG.R, SVG.H, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j2 < 1) {
            return "0 " + strArr[4];
        }
        for (int i2 = 0; i2 < 5; i2++) {
            long j3 = jArr[i2];
            if (j2 >= j3) {
                return a(j2, j3, strArr[i2]);
            }
        }
        return null;
    }

    public static boolean c(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return b(context, downloadInfo, a(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    public static String a(long j2) {
        return a(j2, true);
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.equals(AdBaseConstants.MIME_APK);
    }

    public static String a(long j2, boolean z) {
        long[] jArr = {1099511627776L, SVG.R, SVG.H, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j2 < 1) {
            return "0 " + strArr[4];
        }
        for (int i2 = 0; i2 < 5; i2++) {
            long j3 = jArr[i2];
            if (j2 >= j3) {
                return a(j2, j3, strArr[i2], z);
            }
        }
        return null;
    }

    public static List<String> c() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(AdBaseConstants.MIME_APK);
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static int b(final Context context, final int i2, final boolean z) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
        if (downloadInfo != null && AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                com.ss.android.socialbase.downloader.downloader.c.a(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int a2 = c.a(context, i2, z, downloadInfo, file);
                        if (a2 == 1 && d.j().o() != null) {
                            d.j().o().a(downloadInfo, null);
                        }
                        c.b(downloadInfo, z, a2);
                    }
                });
                return 1;
            }
        }
        b(downloadInfo, z, 2);
        return 2;
    }

    private static JSONObject d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(long j2, long j3, String str) {
        double d2 = j2;
        if (j3 > 1) {
            d2 /= j3;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat(MqttTopic.MULTI_LEVEL_WILDCARD).format(d2) + str;
        }
        return new DecimalFormat("#.##").format(d2) + str;
    }

    public static void b(DownloadInfo downloadInfo, boolean z, int i2) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i2);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), "install_view_result", jSONObject);
    }

    public static int a(final Context context, final int i2, final boolean z) {
        j g2 = d.j().g();
        if (g2 == null) {
            return d(context, i2, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
        a = 1;
        g2.a(downloadInfo, new com.ss.android.socialbase.appdownloader.c.i() { // from class: com.ss.android.socialbase.appdownloader.c.1
            @Override // com.ss.android.socialbase.appdownloader.c.i
            public void a() {
                int unused = c.a = c.d(context, i2, z);
            }
        });
        return a;
    }

    public static boolean b(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return a(context, downloadInfo, packageInfo, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x003d, code lost:
        if (r0 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r5, int r6, boolean r7, com.ss.android.socialbase.downloader.model.DownloadInfo r8, java.io.File r9) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.c.a(android.content.Context, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo, java.io.File):int");
    }

    public static int b(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo a2 = a(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (a2 != null) {
                    int i2 = a2.versionCode;
                    downloadInfo.setAppVersionCode(i2);
                    return i2;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static String b() {
        return com.ss.android.socialbase.downloader.i.f.e();
    }

    public static boolean b(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(26)
    public static String b(@NonNull Context context) {
        try {
            if (b == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                b = notificationChannel;
                notificationChannel.setSound(null, null);
                b.setShowBadge(false);
                ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).createNotificationChannel(b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "111111";
    }

    public static int a(Context context, Intent intent) {
        try {
            if (d.j().n() != null) {
                if (d.j().n().a(intent)) {
                    return 1;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.c.d b2 = d.j().b();
        if (b2 != null) {
            b2.a(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (b2.a()) {
                return true;
            }
        }
        z downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.a(8, downloadInfo, packageInfo.packageName, "");
            com.ss.android.socialbase.appdownloader.c.c a2 = d.j().a();
            return (a2 instanceof com.ss.android.socialbase.appdownloader.c.a) && ((com.ss.android.socialbase.appdownloader.c.a) a2).c();
        }
        return false;
    }

    public static boolean a(Context context, int i2, File file) {
        if (com.ss.android.socialbase.downloader.g.a.a(i2).a("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.f.d.l() || com.ss.android.socialbase.appdownloader.f.d.m()) && com.ss.android.socialbase.downloader.i.j.a(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt(TUIConstants.TUILive.USER_ID, 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static int a() {
        return d.j().f() ? 16384 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri a(int r1, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider r2, android.content.Context r3, java.lang.String r4, java.io.File r5) {
        /*
            if (r2 == 0) goto Lb
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.getUriForFile(r4, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        Lb:
            com.ss.android.socialbase.appdownloader.d r2 = com.ss.android.socialbase.appdownloader.d.j()
            com.ss.android.socialbase.appdownloader.c.f r2 = r2.e()
            if (r2 == 0) goto L1e
            java.lang.String r0 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.a(r1, r4, r0)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L3b
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L37
            r0 = 24
            if (r2 < r0) goto L32
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L37
            if (r2 != 0) goto L32
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r3, r4, r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L32:
            android.net.Uri r1 = android.net.Uri.fromFile(r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L37:
            r2 = move-exception
            r2.printStackTrace()
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.c.a(int, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    private static Intent a(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z, int[] iArr) {
        Uri a2 = a(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, d.j().d(), file);
        if (a2 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(a2, AdBaseConstants.MIME_APK);
        com.ss.android.socialbase.appdownloader.c.d b2 = d.j().b();
        boolean a3 = b2 != null ? b2.a(downloadInfo.getId(), z) : 0;
        z downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        int i2 = a3;
        if (downloadNotificationEventListener != null) {
            i2 = downloadNotificationEventListener.a(z);
        }
        iArr[0] = i2;
        if (i2 != 0) {
            return null;
        }
        return intent;
    }

    public static boolean a(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && a(com.ss.android.socialbase.downloader.downloader.c.N(), downloadInfo, str);
        }
        return true;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                Log.e("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
                PackageInfo a2 = a(downloadInfo, file);
                if (a2 == null || !a2.packageName.equals(str)) {
                    return false;
                }
                int i2 = a2.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, a());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i2 != packageInfo.versionCode) {
                    return false;
                }
            } else if (!com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_callback_error")) {
                return false;
            } else {
                String a3 = com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getTempCacheData().get("extra_apk_package_name"), (String) null);
                int a4 = com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (a3 == null || TextUtils.isEmpty(a3) || !a3.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, a());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || a4 != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i2 = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i2);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, a());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i3 = packageInfo2.versionCode;
        return z ? i2 < i3 : (downloadInfo == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_with_same_version_code", 0) != 1) ? i2 <= i3 : i2 < i3;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo) {
        return a(context, downloadInfo, true);
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z) {
            return c(context, downloadInfo);
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, a());
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        return com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
    }

    public static PackageInfo a(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            Log.e("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
            return a(downloadInfo, file);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0034, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r1, java.lang.String r2, java.lang.String r3, boolean r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L9
            java.lang.String r1 = ""
            return r1
        L9:
            android.net.Uri r1 = android.net.Uri.parse(r1)
            java.lang.String r0 = "default.apk"
            if (r4 == 0) goto L26
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 == 0) goto L3a
            java.lang.String r2 = r1.getLastPathSegment()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L37
            java.lang.String r2 = r1.getLastPathSegment()
            goto L3a
        L26:
            java.lang.String r1 = r1.getLastPathSegment()
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L39
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L37
            goto L3a
        L37:
            r2 = r0
            goto L3a
        L39:
            r2 = r1
        L3a:
            boolean r1 = c(r3)
            if (r1 == 0) goto L57
            java.lang.String r1 = ".apk"
            boolean r3 = r2.endsWith(r1)
            if (r3 != 0) goto L57
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r1)
            java.lang.String r2 = r3.toString()
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.c.a(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static String a(String str, com.ss.android.socialbase.downloader.g.a aVar) {
        JSONObject d2;
        String format;
        if (aVar == null || (d2 = aVar.d("download_dir")) == null) {
            return "";
        }
        String optString = d2.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (!optString.contains("%s")) {
            format = optString + str;
        } else {
            try {
                format = String.format(optString, str);
            } catch (Throwable unused) {
            }
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static int a(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == -2) {
            return 2;
        }
        if (i2 == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i2) || i2 == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i2) ? 3 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x003b, code lost:
        if (r0 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x003d, code lost:
        r0.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0041, code lost:
        if (r0 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 20
            if (r0 <= r2) goto L44
            if (r6 != 0) goto La
            goto L44
        La:
            r0 = 0
            int r2 = com.ss.android.socialbase.appdownloader.e.b()     // Catch: java.lang.Throwable -> L41
            android.content.res.Resources r3 = r6.getResources()     // Catch: java.lang.Throwable -> L41
            int r2 = r3.getColor(r2)     // Catch: java.lang.Throwable -> L41
            int r3 = com.ss.android.socialbase.appdownloader.e.c()     // Catch: java.lang.Throwable -> L41
            int r4 = com.ss.android.socialbase.appdownloader.e.d()     // Catch: java.lang.Throwable -> L41
            r5 = 2
            int[] r5 = new int[r5]     // Catch: java.lang.Throwable -> L41
            r5[r1] = r3     // Catch: java.lang.Throwable -> L41
            r3 = 1
            r5[r3] = r4     // Catch: java.lang.Throwable -> L41
            int r4 = com.ss.android.socialbase.appdownloader.e.e()     // Catch: java.lang.Throwable -> L41
            android.content.res.TypedArray r0 = r6.obtainStyledAttributes(r4, r5)     // Catch: java.lang.Throwable -> L41
            int r6 = r0.getColor(r1, r1)     // Catch: java.lang.Throwable -> L41
            if (r2 != r6) goto L3b
            if (r0 == 0) goto L3a
            r0.recycle()     // Catch: java.lang.Throwable -> L3a
        L3a:
            return r3
        L3b:
            if (r0 == 0) goto L44
        L3d:
            r0.recycle()     // Catch: java.lang.Throwable -> L44
            goto L44
        L41:
            if (r0 == 0) goto L44
            goto L3d
        L44:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.c.a(android.content.Context):boolean");
    }

    public static void a(DownloadInfo downloadInfo, boolean z, boolean z2) {
        d.j().a(new f(com.ss.android.socialbase.downloader.downloader.c.N(), downloadInfo.getUrl()).a(downloadInfo.getTitle()).b(downloadInfo.getName()).c(downloadInfo.getSavePath()).a(downloadInfo.isShowNotification()).b(downloadInfo.isAutoInstallWithoutNotification()).c(downloadInfo.isOnlyWifi() || z2).d(downloadInfo.getExtra()).e(downloadInfo.getMimeType()).a(downloadInfo.getExtraHeaders()).e(true).b(downloadInfo.getRetryCount()).c(downloadInfo.getBackUpUrlRetryCount()).b(downloadInfo.getBackUpUrls()).d(downloadInfo.getMinProgressTimeMsInterval()).e(downloadInfo.getMaxProgressCount()).f(z).d(downloadInfo.isNeedHttpsToHttpRetry()).f(downloadInfo.getPackageName()).g(downloadInfo.getMd5()).a(downloadInfo.getExpectFileLength()).i(downloadInfo.isNeedDefaultHttpServiceBackUp()).j(downloadInfo.isNeedReuseFirstConnection()).l(downloadInfo.isNeedIndependentProcess()).a(downloadInfo.getEnqueueType()).n(downloadInfo.isForce()).m(downloadInfo.isHeadConnectionAvailable()).g(downloadInfo.isNeedRetryDelay()).h(downloadInfo.getRetryDelayTimeArray()).a(d(downloadInfo.getDownloadSettingString())).j(downloadInfo.getIconUrl()).f(downloadInfo.getExecutorGroup()).p(downloadInfo.isAutoInstall()));
    }

    public static void a(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static PackageInfo a(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.f.a.e.a(com.ss.android.socialbase.downloader.downloader.c.N(), file, a());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo == null) {
            PackageInfo a2 = com.ss.android.socialbase.appdownloader.f.a.e.a(com.ss.android.socialbase.downloader.downloader.c.N(), file, a());
            downloadInfo.setPackageInfo(a2);
            return a2;
        }
        return packageInfo;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
