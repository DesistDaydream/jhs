package com.bytedance.msdk.adapter.config;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class DefaultAdapterClasses {
    private static final Set<String> a;

    static {
        HashSet hashSet = new HashSet();
        a = hashSet;
        hashSet.add("com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.unity.UnityAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.baidu.BaiduAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.sigmob.SigmobAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.admob.AdmobAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.gdt.GdtAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.ks.KsAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.mintegral.MintegralAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.klevin.KlevinAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.panglecustom.PangleCustomAdapterConfiguration");
    }

    public static Class<?> getClass(String str) {
        String classNameByAdnName = getClassNameByAdnName(str);
        if (!TextUtils.isEmpty(classNameByAdnName)) {
            try {
                return Class.forName(classNameByAdnName);
            } catch (Throwable th) {
                th.printStackTrace();
                Logger.e("TTMediationSDK_ADAPTER", "DefaultAdapterClasses#getClass error:" + th.toString());
            }
        }
        return null;
    }

    public static String getClassNameByAdnName(String str) {
        if ("pangle".equals(str)) {
            if (!b.I().z()) {
                return "com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration";
            }
        } else if (!"pangle_custom".equals(str)) {
            return "unity".equals(str) ? "com.bytedance.msdk.adapter.unity.UnityAdapterConfiguration" : "baidu".equals(str) ? "com.bytedance.msdk.adapter.baidu.BaiduAdapterConfiguration" : "admob".equals(str) ? "com.bytedance.msdk.adapter.admob.AdmobAdapterConfiguration" : "gdt".equals(str) ? "com.bytedance.msdk.adapter.gdt.GdtAdapterConfiguration" : "ks".equals(str) ? "com.bytedance.msdk.adapter.ks.KsAdapterConfiguration" : "sigmob".equals(str) ? "com.bytedance.msdk.adapter.sigmob.SigmobAdapterConfiguration" : "mintegral".equals(str) ? "com.bytedance.msdk.adapter.mintegral.MintegralAdapterConfiguration" : "klevin".equals(str) ? "com.bytedance.msdk.adapter.klevin.KlevinAdapterConfiguration" : "";
        }
        return "com.bytedance.msdk.adapter.panglecustom.PangleCustomAdapterConfiguration";
    }

    public static Set<String> getClassNamesSet() {
        return a;
    }
}
