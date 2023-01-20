package com.bytedance.pangle.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.effective.android.panel.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class j {
    private static String a;

    public static List<String> a() {
        AssetManager assetManager;
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e2);
            assetManager = null;
        }
        return a(assetManager);
    }

    public static String b(AssetManager assetManager) {
        List<String> a2 = a(assetManager);
        StringBuilder sb = new StringBuilder("[");
        if (a2.size() > 0) {
            for (String str : a2) {
                sb.append(str);
                sb.append(" , ");
            }
            sb.delete(sb.lastIndexOf(" , "), sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    public static List<String> a(AssetManager assetManager) {
        ArrayList arrayList = new ArrayList();
        if (assetManager == null) {
            return arrayList;
        }
        try {
            if (i.d()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        arrayList.add((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
                    }
                }
            } else {
                int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                for (int i2 = 0; i2 < intValue; i2++) {
                    try {
                        String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i2 + 1));
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    } catch (IndexOutOfBoundsException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "ResUtils GetAssetsPaths error. ", th);
        }
        return arrayList;
    }

    public static List<String> b() {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (i.b()) {
            try {
                Resources resources = Zeus.getAppApplication().getResources();
                arrayList.add(Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", "string", Constants.ANDROID)), 0).getApplicationInfo().sourceDir);
            } catch (Exception e2) {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths1 failed.", e2);
            }
        } else if (i.c()) {
            try {
                Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.webkit.WebViewFactory"), "getWebViewContextAndSetProvider", new Object[0]);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 29 || (i2 == 28 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                    z = true;
                }
                if (z) {
                    Collections.addAll(arrayList, a(((Context) invokeStaticMethod).getApplicationInfo()));
                } else {
                    arrayList.add(((Context) invokeStaticMethod).getApplicationInfo().sourceDir);
                }
            } catch (Exception e3) {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths2 failed.", e3);
            }
        }
        return arrayList;
    }

    public static boolean a(AssetManager assetManager, String str) {
        try {
            if (i.d()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        if (TextUtils.equals((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]), str)) {
                            return true;
                        }
                    }
                }
            } else {
                int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                int i2 = 0;
                while (i2 < intValue) {
                    i2++;
                    if (TextUtils.equals((String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i2)), str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "containsPath error. ", th);
        }
        return false;
    }

    @RequiresApi(api = 21)
    private static String[] a(ApplicationInfo applicationInfo) {
        String[] strArr;
        try {
            strArr = (String[]) com.bytedance.pangle.a.b.a.a(ApplicationInfo.class, "resourceDirs").get(applicationInfo);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "get resourceDirs failed.", th);
            strArr = new String[0];
        }
        String[][] strArr2 = {applicationInfo.splitSourceDirs, applicationInfo.sharedLibraryFiles, strArr};
        ArrayList arrayList = new ArrayList(10);
        String str = applicationInfo.sourceDir;
        if (str != null) {
            arrayList.add(str);
        }
        for (int i2 = 0; i2 < 3; i2++) {
            String[] strArr3 = strArr2[i2];
            if (strArr3 != null) {
                arrayList.addAll(Arrays.asList(strArr3));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
