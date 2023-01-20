package com.bytedance.pangle.res;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.util.j;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.effective.android.panel.Constants;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {
    private static Map<String, Integer> a = new HashMap();
    private LinkedHashMap<String, Integer> b;

    static {
        List<String> a2 = j.a();
        if (a2 == null || a2.size() <= 0) {
            return;
        }
        for (String str : a2) {
            a.put(str, 0);
        }
    }

    public a() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        this.b = linkedHashMap;
        linkedHashMap.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    private static AssetManager b(AssetManager assetManager, String str, boolean z) {
        int intValue;
        String str2 = "addAssetPath";
        String str3 = z ? "addAssetPathAsSharedLibrary" : "addAssetPath";
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 >= 30 || (i2 == 29 && Build.VERSION.PREVIEW_SDK_INT > 0)) && !z && str.startsWith("/product/overlay/")) {
            str3 = "addOverlayPath";
        }
        Method accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, str3, String.class);
        if (accessibleMethod == null && z) {
            accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, "addAssetPath", String.class);
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
        } else {
            str2 = str3;
        }
        if (accessibleMethod != null) {
            int i3 = 3;
            while (true) {
                int i4 = i3 - 1;
                if (i3 < 0) {
                    break;
                }
                try {
                    intValue = ((Integer) accessibleMethod.invoke(assetManager, str)).intValue();
                } catch (Exception e2) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + z + ", methodName = " + str2, e2);
                }
                if (intValue != 0) {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + intValue + ", path = " + str);
                    break;
                }
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = " + intValue + ExpandableTextView.N + str);
                i3 = i4;
            }
        } else {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = " + z + " methodName:" + str2);
        }
        return assetManager;
    }

    private static AssetManager c(AssetManager assetManager, String str, boolean z) {
        int i2;
        Class cls = Boolean.TYPE;
        int i3 = 3;
        Throwable th = null;
        int i4 = 3;
        while (true) {
            int i5 = i4 - 1;
            if (i4 < 0) {
                break;
            }
            try {
                synchronized (assetManager) {
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        i2 = 1;
                        if (i6 < i3) {
                            if (i.b()) {
                                i7 = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str}, new Class[]{String.class})).intValue();
                            } else {
                                int i8 = Build.VERSION.SDK_INT;
                                if (i8 >= 24 && i8 <= 25) {
                                    i7 = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str, Boolean.valueOf(z)}, new Class[]{String.class, cls})).intValue();
                                }
                            }
                            if (i7 != 0) {
                                break;
                            }
                            i6++;
                        } else {
                            break;
                        }
                    }
                    if (i7 == 0) {
                        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.appendAssetPathSafely() failed, cookie = " + i7 + ExpandableTextView.N + str);
                    } else {
                        Object readField = FieldUtils.readField(assetManager, "mStringBlocks");
                        int length = readField != null ? Array.getLength(readField) : 0;
                        int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                        Object newInstance = Array.newInstance(readField.getClass().getComponentType(), intValue);
                        int i9 = 0;
                        while (i9 < intValue) {
                            if (i9 < length) {
                                Array.set(newInstance, i9, Array.get(readField, i9));
                            } else {
                                Object[] objArr = new Object[i2];
                                objArr[0] = Integer.valueOf(i9);
                                Class[] clsArr = new Class[i2];
                                clsArr[0] = Integer.TYPE;
                                long longValue = ((Long) MethodUtils.invokeMethod(assetManager, "getNativeStringBlock", objArr, clsArr)).longValue();
                                Class<?> componentType = readField.getClass().getComponentType();
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = Long.valueOf(longValue);
                                objArr2[i2] = Boolean.TRUE;
                                Array.set(newInstance, i9, MethodUtils.invokeConstructor(componentType, objArr2, new Class[]{Long.TYPE, cls}));
                            }
                            i9++;
                            i2 = 1;
                        }
                        FieldUtils.writeField(assetManager, "mStringBlocks", newInstance);
                        ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = ".concat(String.valueOf(str)));
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                i4 = i5;
                i3 = 3;
            }
        }
        if (th != null) {
            if (!TextUtils.equals(Build.BRAND.toLowerCase(), "samsung")) {
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
            }
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
        }
        return assetManager;
    }

    public final AssetManager a(AssetManager assetManager, String str, boolean z) {
        AssetManager a2;
        if (str.endsWith(".frro")) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager skip frro. ".concat(String.valueOf(str)));
            return assetManager;
        }
        if (i.a()) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21 && i2 <= 25) {
                a2 = c(assetManager, str, z);
                if (!j.a(a2, str)) {
                    a2 = b(assetManager, str, z);
                }
            } else {
                a2 = b(assetManager, str, z);
            }
        } else {
            a2 = a(assetManager, str);
        }
        synchronized (this.b) {
            this.b.put(str, 0);
        }
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager, newAssetManager=" + a2 + ", assets=" + j.b(a2));
        return a2;
    }

    private AssetManager a(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        List<String> a2 = j.a(assetManager);
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (String str2 : a2) {
            if (!a.containsKey(str2) && !this.b.containsKey(str2) && !str2.equals(str)) {
                arrayList.add(str2);
            }
        }
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager, runtimeAdditionalAssets");
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager = ".concat(String.valueOf(assetManager2)));
            synchronized (this.b) {
                for (Map.Entry<String, Integer> entry : this.b.entrySet()) {
                    if (!a.containsKey(entry.getKey())) {
                        sb.append(entry.getKey());
                        b(assetManager2, entry.getKey(), false);
                    }
                }
            }
            if (!sb.toString().contains(Zeus.getAppApplication().getApplicationInfo().sourceDir)) {
                b(assetManager2, Zeus.getAppApplication().getApplicationInfo().sourceDir, false);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager lost host path : " + a.containsKey(Zeus.getAppApplication().getApplicationInfo().sourceDir));
            }
            sb.append(str);
            b(assetManager2, str, false);
            if (!arrayList.isEmpty()) {
                for (String str3 : arrayList) {
                    sb.append(str3);
                    b(assetManager2, str3, false);
                }
            }
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 >= 21 && i2 < 23) && !sb.toString().toLowerCase().contains("webview")) {
                try {
                    Resources resources = Zeus.getAppApplication().getResources();
                    String str4 = Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", "string", Constants.ANDROID)), 0).getApplicationInfo().sourceDir;
                    if (!TextUtils.isEmpty(str4)) {
                        b(assetManager2, str4, false);
                    }
                } catch (Exception e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager appendAsset webview failed.", e2);
                }
            }
            assetManager = assetManager2;
        } catch (Exception e3) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager failed.", e3);
            b(assetManager, str, false);
        }
        try {
            MethodUtils.invokeMethod(assetManager, "ensureStringBlocks", new Object[0]);
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks");
        } catch (Exception e4) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks failed.", e4);
        }
        return assetManager;
    }
}
