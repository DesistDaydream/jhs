package com.bytedance.pangle.transform;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Keep;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.FileProvider;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.activity.GenerateProxyActivity;
import com.bytedance.pangle.activity.GenerateProxyAppCompatActivity;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.service.PluginIntentService;
import com.bytedance.pangle.service.PluginService;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper;
import com.effective.android.panel.Constants;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParser;

@Keep
/* loaded from: classes.dex */
public class ZeusTransformUtils {
    private static final String TAG = "PluginContextUtils";
    public static Class fragmentClazz;
    public static HashMap<String, WeakReference<Context>> contextCache = new HashMap<>();
    public static boolean hasEnsure = false;
    public static HashMap<String, Constructor<View>> sConstructorMap = null;

    public static Activity _getActivity(Object obj, String str) {
        try {
            Activity activity = (Activity) MethodUtils.invokeMethod(obj, "getActivity", new Object[0]);
            Activity activity2 = (Activity) wrapperContext(activity, str);
            if (activity2 instanceof GenerateProxyActivity) {
                return ((GenerateProxyActivity) activity2).mTargetActivity;
            }
            if (!isSupportLibIso(str) && (activity2 instanceof GenerateProxyAppCompatActivity)) {
                return ((GenerateProxyAppCompatActivity) activity2).mTargetActivity;
            }
            return (Activity) wrapperContext(activity, str);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static boolean bindService(Object obj, Intent intent, ServiceConnection serviceConnection, int i2, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().bindServiceNative((Context) obj, intent, serviceConnection, i2, str);
        }
        try {
            return ((Boolean) MethodUtils.invokeMethod(obj, "bindService", new Object[]{intent, serviceConnection, Integer.valueOf(i2)}, new Class[]{Intent.class, ServiceConnection.class, Integer.TYPE})).booleanValue();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void clearConstructorCache() {
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                if (sConstructorMap == null) {
                    sConstructorMap = (HashMap) FieldUtils.readStaticField(LayoutInflater.class, "sConstructorMap");
                }
                for (String str : new HashSet(sConstructorMap.keySet())) {
                    if (!str.startsWith("android.view.") && !str.startsWith("android.widget.") && !str.startsWith("android.webkit.") && str.contains(".")) {
                        sConstructorMap.remove(str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void ensureFragmentActivity() {
        if (hasEnsure) {
            return;
        }
        try {
            try {
                fragmentClazz = Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fragmentClazz = Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
        }
        hasEnsure = true;
    }

    private static boolean equalsFragmentActivity(Class cls) {
        ensureFragmentActivity();
        Class cls2 = fragmentClazz;
        return cls2 != null && cls == cls2;
    }

    public static Class forName(String str, String str2) {
        return Zeus.getPlugin(str2).mClassLoader.loadClass(str);
    }

    public static Activity getActivity(Object obj, String str) {
        return _getActivity(obj, str);
    }

    public static String getAssetPaths(AssetManager assetManager) {
        int i2;
        StringBuilder sb = new StringBuilder();
        if (assetManager == null) {
            return "";
        }
        try {
            i2 = Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "TransformUtils GetAssetsPaths error. ", th);
        }
        if (i2 < 28 && (i2 != 27 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
            for (int i3 = 0; i3 < intValue; i3++) {
                try {
                    String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i3 + 1));
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            return sb.toString();
        }
        Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
            }
        }
        return sb.toString();
    }

    public static Context getContext(Object obj, String str) {
        try {
            Context context = (Context) MethodUtils.invokeMethod(obj, "getContext", new Object[0]);
            if (!isSupportLibIso(str) && instanceOfFragmentActivity(context)) {
                return wrapperContext(context, str);
            }
            if (context instanceof Activity) {
                return wrapperContext(context, str);
            }
            if (context instanceof Application) {
                return wrapperContext(context, str);
            }
            return context instanceof PluginContext ? context : wrapperContext(context, str);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Context getContextIfNeedWrap(Context context, Context context2, String str) {
        Object readField;
        while (context2 != null) {
            if (context2 instanceof IPluginActivity) {
                if (TextUtils.equals(((IPluginActivity) context2).getPluginPkgName(), str)) {
                    return null;
                }
                return context;
            } else if (context2 instanceof PluginContext) {
                PluginContext pluginContext = (PluginContext) context2;
                if (TextUtils.equals(pluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                return pluginContext.mOriginContext;
            } else if (context2 instanceof PluginActivityWrapper) {
                PluginActivityWrapper pluginActivityWrapper = (PluginActivityWrapper) context2;
                if (TextUtils.equals(pluginActivityWrapper.pluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                return pluginActivityWrapper.mOriginActivity;
            } else if (!isSupportLibIso(str) && (context2 instanceof PluginFragmentActivityWrapper)) {
                if (TextUtils.equals(((PluginFragmentActivityWrapper) context2).pluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                try {
                    try {
                        readField = ((PluginFragmentActivityWrapper) context2).getOriginActivity();
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                } catch (Throwable unused) {
                    readField = FieldUtils.readField(context2, "mOriginActivity");
                }
                return (Context) readField;
            } else if (context2 instanceof PluginApplicationWrapper) {
                PluginApplicationWrapper pluginApplicationWrapper = (PluginApplicationWrapper) context2;
                if (TextUtils.equals(pluginApplicationWrapper.mPluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                return pluginApplicationWrapper.mOriginApplication;
            } else if (context2.getResources() instanceof PluginResources) {
                PluginResources pluginResources = (PluginResources) context2.getResources();
                try {
                    String str2 = (String) FieldUtils.readField(pluginResources, "pluginPkg");
                    if (TextUtils.isEmpty(str2)) {
                        String assetPaths = getAssetPaths(pluginResources.getAssets());
                        if (!assetPaths.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR + str + "/version")) {
                            return context;
                        }
                    } else if (!TextUtils.equals(str2, str)) {
                        return context;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return null;
            } else if (!(context2 instanceof ContextWrapper)) {
                return context;
            } else {
                try {
                    context2 = (Context) FieldUtils.readField(context2, "mBase");
                } catch (Throwable unused2) {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
        }
        return null;
    }

    public static int getIdentifier(Object obj, String str, String str2, String str3, String str4) {
        if (obj instanceof Resources) {
            Resources resources = (Resources) obj;
            if (!TextUtils.equals(Constants.ANDROID, str3)) {
                str3 = str4;
            }
            return resources.getIdentifier(str, str2, str3);
        }
        try {
            return ((Integer) MethodUtils.invokeMethod(obj, "getIdentifier", str, str2, str3)).intValue();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Resources getResources(Object obj, String str) {
        try {
            Resources resources = (Resources) MethodUtils.invokeMethod(obj, "getResources", new Object[0]);
            if (resources == null) {
                return null;
            }
            if (resources instanceof PluginResources) {
                String str2 = (String) FieldUtils.readField(resources, "pluginPkg");
                if (TextUtils.isEmpty(str2)) {
                    String assetPaths = getAssetPaths(resources.getAssets());
                    if (assetPaths.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR + str + "/version")) {
                        return resources;
                    }
                } else if (TextUtils.equals(str2, str)) {
                    return resources;
                }
            }
            return PluginManager.getInstance().getPlugin(str).mResources;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Uri getUriForFile(Context context, String str, File file, String str2) {
        try {
            return FileProvider.getUriForFile(file);
        } catch (NoClassDefFoundError unused) {
            return Uri.parse("");
        }
    }

    public static Window getWindow(Activity activity, String str) {
        Window window = activity.getWindow();
        if (window == null) {
            try {
                return (Window) MethodUtils.invokeMethod(activity, "getWindow", new Object[0]);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
        return window;
    }

    private static Context getWrapperFromCache(Object obj, String str) {
        HashMap<String, WeakReference<Context>> hashMap = contextCache;
        WeakReference<Context> weakReference = hashMap.get(str + System.identityHashCode(obj));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static void handleAttrAfter(TypedArray typedArray, int[] iArr, int[] iArr2) {
        if (Arrays.equals(iArr, iArr2)) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            hashMap.put(Integer.valueOf(iArr[i2]), Integer.valueOf(i2));
        }
        HashMap hashMap2 = new HashMap();
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            hashMap2.put((Integer) hashMap.get(Integer.valueOf(iArr2[i3])), Integer.valueOf(i3));
        }
        try {
            int[] iArr3 = (int[]) FieldUtils.readField(typedArray, "mData");
            int[] copyOf = Arrays.copyOf(iArr3, iArr3.length);
            for (Integer num : hashMap2.keySet()) {
                Integer num2 = (Integer) hashMap2.get(num);
                if (!num.equals(num2)) {
                    System.arraycopy(iArr3, num.intValue() * 7, copyOf, num2.intValue() * 7, 7);
                }
            }
            System.arraycopy(copyOf, 0, iArr3, 0, iArr3.length);
        } catch (IllegalAccessException unused) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "read mData failed.");
        }
    }

    private static int[] handleAttrBefore(int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(copyOf);
        return copyOf;
    }

    public static View inflate(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup, boolean z, String str) {
        Context context = layoutInflater.getContext();
        if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && ((isSupportLibIso(str) || !(context instanceof PluginFragmentActivityWrapper)) && !(context instanceof PluginApplicationWrapper))) {
            Context wrapperContext = wrapperContext(context, str);
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            LayoutInflater.Factory2 factory2 = layoutInflater.getFactory2();
            LayoutInflater layoutInflater2 = (LayoutInflater) wrapperContext.getSystemService("layout_inflater");
            if (isSupportLibIso(str)) {
                if (factory != null) {
                    try {
                        FieldUtils.writeField(layoutInflater2, "mFactory", factory);
                    } catch (Throwable unused) {
                        ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "set Factory failed.");
                    }
                }
                if (factory2 != null) {
                    try {
                        FieldUtils.writeField(layoutInflater2, "mFactory2", factory2);
                    } catch (Throwable unused2) {
                        ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "set Factory2 failed.");
                    }
                }
            }
            layoutInflater = layoutInflater2;
        }
        clearConstructorCache();
        View inflate = layoutInflater.inflate(i2, viewGroup, z);
        clearConstructorCache();
        return inflate;
    }

    public static boolean instanceOf(Class cls, Object obj) {
        return instanceOf(obj, cls);
    }

    private static boolean instanceOfFragmentActivity(Object obj) {
        ensureFragmentActivity();
        Class cls = fragmentClazz;
        if (cls == null) {
            return false;
        }
        return cls.isInstance(obj);
    }

    private static boolean isSupportLibIso(String str) {
        try {
            return PluginManager.getInstance().getPlugin(str).mIsSupportLibIso;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int mapRes(int i2, String str, String str2) {
        if (i2 < 2130706432) {
            return i2;
        }
        int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2, str, Zeus.getAppApplication().getPackageName());
        if (identifier == 0) {
            identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.replace("_", "."), str, Zeus.getAppApplication().getPackageName());
        }
        if (identifier == 0) {
            ZeusLogger.d(ZeusLogger.TAG_RESOURCES, "Cant find res, resName = " + str2 + ", pluginResId = " + i2);
        }
        return identifier;
    }

    public static TypedArray obtainAttributes(Object obj, AttributeSet attributeSet, int[] iArr, String str) {
        if (obj instanceof Resources) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainAttributes = ((Resources) obj).obtainAttributes(attributeSet, handleAttrBefore);
            handleAttrAfter(obtainAttributes, handleAttrBefore, iArr);
            return obtainAttributes;
        }
        try {
            return (TypedArray) MethodUtils.invokeMethod(obj, "obtainAttributes", attributeSet, iArr);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static TypedArray obtainStyledAttributes(Object obj, AttributeSet attributeSet, int[] iArr, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(attributeSet, handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        }
        try {
            return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", attributeSet, iArr);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Object preCheckCast(Object obj, Class cls, String str) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Context) {
            boolean z = !cls.isInstance(obj);
            if (equalsFragmentActivity(cls)) {
                return wrapperContext2FragmentActivity(obj, str);
            }
            if (cls == Activity.class) {
                return wrapperContext2Activity(obj, str);
            }
            if (cls == Application.class) {
                return wrapperContext2Application(obj, str);
            }
            if ((obj instanceof PluginContext) && z) {
                return ((PluginContext) obj).mOriginContext;
            }
            if ((obj instanceof PluginFragmentActivityWrapper) && z) {
                try {
                    try {
                        return ((PluginFragmentActivityWrapper) obj).getOriginActivity();
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                } catch (Throwable unused) {
                    return FieldUtils.readField(obj, "mOriginActivity");
                }
            } else if ((obj instanceof PluginActivityWrapper) && z) {
                return ((PluginActivityWrapper) obj).mOriginActivity;
            } else {
                if ((obj instanceof PluginApplicationWrapper) && z) {
                    return ((PluginApplicationWrapper) obj).mOriginApplication;
                }
                return ((obj instanceof GenerateProxyActivity) && z) ? ((GenerateProxyActivity) obj).mTargetActivity : obj;
            }
        }
        return obj;
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str) {
        if (obj instanceof Context) {
            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void registerZeusActivityStub(String str, String[] strArr, String str2) {
        ComponentManager.registerActivity(str2, str, strArr);
    }

    public static void requestPermissions(Object obj, String[] strArr, int i2, String str) {
        if (obj instanceof IPluginActivity) {
            ((IPluginActivity) obj)._requestPermissions(strArr, i2);
            return;
        }
        if (obj instanceof Activity) {
            Object obj2 = null;
            try {
                obj2 = FieldUtils.readField(obj, "mOriginActivity");
            } catch (IllegalAccessException unused) {
            }
            if (obj2 != null) {
                obj = obj2;
            }
        }
        try {
            MethodUtils.invokeMethod(obj, "requestPermissions", strArr, Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void setComponentEnabledSetting(PackageManager packageManager, ComponentName componentName, int i2, int i3) {
        try {
            packageManager.setComponentEnabledSetting(componentName, i2, i3);
        } catch (Throwable unused) {
        }
    }

    public static void setResult(Object obj, int i2, Intent intent, String str) {
        if (obj instanceof Activity) {
            try {
                Object readField = FieldUtils.readField(obj, "mProxyActivity");
                if (readField == null) {
                    readField = FieldUtils.readField(obj, "mOriginActivity");
                }
                if (readField != null) {
                    MethodUtils.invokeMethod(readField, "setResult", Integer.valueOf(i2), intent);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        try {
            MethodUtils.invokeMethod(obj, "setResult", Integer.valueOf(i2), intent);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void startActivity(Object obj, Intent intent, String str) {
        startActivity(obj, intent, null, str);
    }

    public static void startActivityForResult(Object obj, Intent intent, int i2, String str) {
        startActivityForResult(obj, intent, i2, null, str);
    }

    public static ComponentName startService(Object obj, Intent intent, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().startServiceNative((Context) obj, intent, str);
        }
        try {
            return (ComponentName) MethodUtils.invokeMethod(obj, "startService", intent);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean stopService(Object obj, Intent intent, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().stopServiceNative((Context) obj, intent, str);
        }
        try {
            return ((Boolean) MethodUtils.invokeMethod(obj, "stopService", intent)).booleanValue();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void unbindService(Object obj, ServiceConnection serviceConnection, String str) {
        if (obj instanceof Context) {
            ServiceManagerNative.getInstance().unbindServiceNative(serviceConnection);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "unbindService", serviceConnection);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void unregisterReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, String str) {
        if (obj instanceof Context) {
            ComponentManager.unregisterReceiver((Context) obj, pluginBroadcastReceiver);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "unregisterReceiver", pluginBroadcastReceiver);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Context wrapperContext(Object obj, String str) {
        Context pluginContext;
        Application application;
        if (Zeus.getAppApplication() == null && (application = (Application) ((Context) obj).getApplicationContext()) != null) {
            Zeus.setAppContext(application);
        }
        if (obj == null) {
            return null;
        }
        Context wrapperFromCache = getWrapperFromCache(obj, str);
        if (wrapperFromCache != null) {
            return wrapperFromCache;
        }
        Context context = (Context) obj;
        Context contextIfNeedWrap = getContextIfNeedWrap(context, context, str);
        if (contextIfNeedWrap == null) {
            return context;
        }
        if (!isSupportLibIso(str) && instanceOfFragmentActivity(contextIfNeedWrap)) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            try {
                try {
                    pluginContext = new PluginFragmentActivityWrapper((Activity) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false));
                } catch (Throwable unused) {
                    return contextIfNeedWrap;
                }
            } catch (Throwable unused2) {
                pluginContext = (Context) MethodUtils.invokeConstructor(PluginFragmentActivityWrapper.class, new Object[]{contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false)}, new Class[]{fragmentClazz, PluginContext.class});
            }
        } else if (contextIfNeedWrap instanceof Activity) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            pluginContext = new PluginActivityWrapper((Activity) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false));
        } else if (contextIfNeedWrap instanceof Application) {
            pluginContext = new PluginApplicationWrapper((Application) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), true));
        } else {
            pluginContext = new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false);
        }
        if (pluginContext != null) {
            HashMap<String, WeakReference<Context>> hashMap = contextCache;
            hashMap.put(str + System.identityHashCode(contextIfNeedWrap), new WeakReference<>(pluginContext));
        }
        return pluginContext;
    }

    public static Activity wrapperContext2Activity(Object obj, String str) {
        while (obj != null) {
            Context wrapperContext = wrapperContext(obj, str);
            if (wrapperContext instanceof Activity) {
                return (Activity) wrapperContext;
            }
            if (wrapperContext instanceof PluginContext) {
                obj = ((PluginContext) wrapperContext).mOriginContext;
            } else {
                throw new RuntimeException("强转失败");
            }
        }
        return null;
    }

    public static Application wrapperContext2Application(Object obj, String str) {
        while (obj != null) {
            Context wrapperContext = wrapperContext(obj, str);
            if (wrapperContext instanceof Application) {
                return (Application) wrapperContext;
            }
            if (wrapperContext instanceof PluginContext) {
                obj = ((PluginContext) wrapperContext).mOriginContext;
            } else {
                throw new RuntimeException("强转失败");
            }
        }
        return null;
    }

    private static Object wrapperContext2FragmentActivity(Object obj, String str) {
        while (obj != null) {
            Context wrapperContext = wrapperContext(obj, str);
            if (!isSupportLibIso(str) && instanceOfFragmentActivity(wrapperContext)) {
                return wrapperContext;
            }
            if (wrapperContext instanceof PluginContext) {
                obj = ((PluginContext) wrapperContext).mOriginContext;
            } else {
                throw new RuntimeException("强转失败");
            }
        }
        return null;
    }

    public static Object wrapperContextForParams(Object obj, Class cls, String str) {
        if (!(obj instanceof PluginService) && !(obj instanceof PluginIntentService) && (obj instanceof Context)) {
            Context wrapperContext = wrapperContext(obj, str);
            if (cls.isInstance(wrapperContext)) {
                return wrapperContext;
            }
        }
        return obj;
    }

    public static boolean instanceOf(Object obj, Class cls) {
        Object readField;
        if (obj instanceof PluginContext) {
            return cls.isInstance(((PluginContext) obj).mOriginContext);
        }
        if (obj instanceof PluginActivityWrapper) {
            return cls.isInstance(((PluginActivityWrapper) obj).mOriginActivity);
        }
        if (obj instanceof PluginFragmentActivityWrapper) {
            try {
                try {
                    readField = ((PluginFragmentActivityWrapper) obj).getOriginActivity();
                } catch (Throwable unused) {
                    readField = FieldUtils.readField(obj, "mOriginActivity");
                }
                return cls.isInstance(readField);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        } else if (obj instanceof PluginApplicationWrapper) {
            return cls.isInstance(((PluginApplicationWrapper) obj).mOriginApplication);
        } else {
            if (obj instanceof GenerateProxyActivity) {
                return cls.isInstance(((GenerateProxyActivity) obj).mTargetActivity);
            }
            return cls.isInstance(obj);
        }
    }

    public static void startActivity(Object obj, Intent intent, Bundle bundle, String str) {
        try {
            ComponentManager.startActivity(obj, intent, bundle, str);
        } catch (Throwable th) {
            if (obj instanceof Context) {
                ComponentManager.startActivity((Context) obj, intent, bundle, str);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "startActivity", new Object[]{intent, bundle}, new Class[]{Intent.class, Bundle.class});
            } catch (Throwable th2) {
                th2.addSuppressed(th);
                throw new RuntimeException(th2);
            }
        }
    }

    public static void startActivityForResult(Object obj, Intent intent, int i2, Bundle bundle, String str) {
        try {
            ComponentManager.startActivityForResult(obj, intent, i2, bundle, str);
        } catch (Throwable th) {
            if (obj instanceof Activity) {
                ComponentManager.startActivityForResult((Activity) obj, intent, i2, bundle, str);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "startActivityForResult", new Object[]{intent, Integer.valueOf(i2), bundle}, new Class[]{Intent.class, Integer.TYPE, Bundle.class});
            } catch (Throwable th2) {
                th2.addSuppressed(th);
                throw new RuntimeException(th2);
            }
        }
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, String str2) {
        if (obj instanceof Context) {
            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[4 params]");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, str2);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static TypedArray obtainStyledAttributes(Object obj, AttributeSet attributeSet, int[] iArr, int i2, int i3, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(attributeSet, handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        } else if (obj instanceof Resources.Theme) {
            int[] handleAttrBefore2 = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes2 = ((Resources.Theme) obj).obtainStyledAttributes(attributeSet, handleAttrBefore2, i2, i3);
            handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
            return obtainStyledAttributes2;
        } else {
            try {
                return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", attributeSet, iArr, Integer.valueOf(i2), Integer.valueOf(i3));
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static void setResult(Object obj, int i2, String str) {
        if (obj instanceof Activity) {
            try {
                Object readField = FieldUtils.readField(obj, "mProxyActivity");
                if (readField != null) {
                    MethodUtils.invokeMethod(readField, "setResult", Integer.valueOf(i2));
                    return;
                }
            } catch (Exception unused) {
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "Cant find mProxyActivity, obj = ".concat(String.valueOf(obj)));
            }
        }
        try {
            MethodUtils.invokeMethod(obj, "setResult", Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i2, String str) {
        if (obj instanceof Context) {
            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[3 params]");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, i2, str);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static View inflate(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup, String str) {
        return inflate(layoutInflater, i2, viewGroup, viewGroup != null, str);
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i2, String str2) {
        if (obj instanceof Context) {
            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[5 params]");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, i2, str2);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler, Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, String str) {
        return inflate(layoutInflater, xmlPullParser, viewGroup, viewGroup != null, str);
    }

    public static TypedArray obtainStyledAttributes(Object obj, int i2, int[] iArr, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(i2, handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        } else if (obj instanceof Resources.Theme) {
            int[] handleAttrBefore2 = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes2 = ((Resources.Theme) obj).obtainStyledAttributes(i2, handleAttrBefore2);
            handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
            return obtainStyledAttributes2;
        } else {
            try {
                return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", Integer.valueOf(i2), iArr);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z, String str) {
        Context context = layoutInflater.getContext();
        if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && ((isSupportLibIso(str) || !(context instanceof PluginFragmentActivityWrapper)) && !(context instanceof PluginApplicationWrapper))) {
            context = wrapperContext(context, str);
        }
        clearConstructorCache();
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(xmlPullParser, viewGroup, z);
        clearConstructorCache();
        return inflate;
    }

    public static View inflate(Context context, int i2, ViewGroup viewGroup, String str) {
        if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && ((isSupportLibIso(str) || !(context instanceof PluginFragmentActivityWrapper)) && !(context instanceof PluginApplicationWrapper))) {
            context = wrapperContext(context, str);
        }
        clearConstructorCache();
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i2, viewGroup);
        clearConstructorCache();
        return inflate;
    }

    public static TypedArray obtainStyledAttributes(Object obj, int[] iArr, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        } else if (obj instanceof Resources.Theme) {
            int[] handleAttrBefore2 = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes2 = ((Resources.Theme) obj).obtainStyledAttributes(handleAttrBefore2);
            handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
            return obtainStyledAttributes2;
        } else {
            try {
                return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", iArr, new Class[]{int[].class});
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}
