package com.tencent.android.tpush.d.b;

import com.tencent.android.tpush.common.Constants;
import com.tencent.tpns.baseapi.base.util.CacheHelper;

/* loaded from: classes3.dex */
public class a {
    public static CacheHelper.Key<String> a() {
        return new CacheHelper.Key<>("tpush.vip.shareprefs.sub", "REGISTERED_REQ", "");
    }

    public static CacheHelper.Key<String> b() {
        return new CacheHelper.Key<>("tpush.vip.shareprefs.sub", "REGISTERED_RSP", "");
    }

    public static CacheHelper.Key<Boolean> c(String str) {
        return new CacheHelper.Key<>("tpush.vip.shareprefs.sub", str + "USE_HTTP_ACCOUNT", Boolean.FALSE);
    }

    public static CacheHelper.Key<Integer> d() {
        return new CacheHelper.Key<>("tpush.vip.shareprefs.sub", Constants.SETTINGS_ENABLE_FCM, 0);
    }

    public static CacheHelper.Key<Integer> e() {
        return new CacheHelper.Key<>("tpush.vip.shareprefs.sub", Constants.SETTINGS_ENABLE_FCM_SUCCESS, 0);
    }

    public static CacheHelper.Key<Integer> f() {
        return new CacheHelper.Key<>("tpush.vip.shareprefs.sub", Constants.SETTINGS_USE_FCM_FIRST, 0);
    }

    public static CacheHelper.Key<Boolean> g() {
        return new CacheHelper.Key<>("tpush.vip.shareprefs.sub", Constants.SETTINGS_ENABLE_SHOW_IN_MSG, Boolean.FALSE);
    }

    public static CacheHelper.Key<Boolean> h() {
        return new CacheHelper.Key<>("tpush.vip.shareprefs.sub", "USE_TPNS_CHANNEL_SERVICE", Boolean.TRUE);
    }

    public static CacheHelper.Key<Boolean> i() {
        return new CacheHelper.Key<>("tpush.vip.shareprefs.sub", "ENABLE_NOTIFICATION_SOUND", Boolean.TRUE);
    }

    public static CacheHelper.Key<String> a(String str) {
        return new CacheHelper.Key<>("tpush.vip.shareprefs.sub", str + "otherpush", "");
    }

    public static CacheHelper.Key<Long> b(String str) {
        return new CacheHelper.Key<>("tpush.vip.shareprefs.sub", str + "otherpushts", 0L);
    }

    public static CacheHelper.Key<Integer> c() {
        return new CacheHelper.Key<>("tpush.vip.shareprefs.sub", Constants.SETTINGS_ENABLE_OTHER_PUSH, 0);
    }
}
