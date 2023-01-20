package com.bytedance.pangle.transform;

import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;

@Keep
/* loaded from: classes.dex */
public class HostPartUtils {
    private Class fragmentActivityClazz;

    /* loaded from: classes.dex */
    public static class a {
        private static final HostPartUtils a;

        static {
            System.out.println("HostPartUtils SingletonHolder");
            a = new HostPartUtils();
        }
    }

    public HostPartUtils() {
        try {
            this.fragmentActivityClazz = FragmentActivity.class;
        } catch (Throwable unused) {
        }
    }

    public static FragmentActivity getFragmentActivity(Object obj, String str) {
        return (FragmentActivity) ZeusTransformUtils._getActivity(obj, str);
    }

    public static final Class getFragmentActivityClass() {
        System.out.println("HostPartUtils getFragmentActivityClass");
        return a.a.fragmentActivityClazz;
    }
}
