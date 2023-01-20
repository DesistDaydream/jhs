package com.bytedance.pangle.e;

import com.bytedance.pangle.util.MethodUtils;

/* loaded from: classes.dex */
public final class b {

    /* loaded from: classes.dex */
    public static class a {
        public static int a = 0;
        public static int b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static int f2243c = 3;
    }

    public static String a() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
