package com.bytedance.pangle.util;

import android.app.Application;
import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusConstants;
import com.bytedance.pangle.log.ZeusLogger;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;

/* loaded from: classes.dex */
public class m {
    private static volatile m b;
    public SharedPreferences a;

    private m() {
        Application appApplication = Zeus.getAppApplication();
        this.a = appApplication.getSharedPreferences(ZeusConstants.BASE_LIB_NAME + "_meta_data_sp", 0);
    }

    public static m a() {
        if (b == null) {
            synchronized (m.class) {
                if (b == null) {
                    b = new m();
                }
            }
        }
        return b;
    }

    public final String b(String str) {
        String string = this.a.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    public final int a(String str) {
        int i2 = this.a.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i2);
        return i2;
    }

    public final void a(String str, int i2, boolean z) {
        SharedPreferences.Editor edit = this.a.edit();
        String str2 = "INSTALLED_" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
        if (z) {
            edit.putBoolean(str2, true);
        } else {
            edit.remove(str2);
        }
        edit.apply();
    }

    public final boolean a(String str, int i2) {
        return this.a.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i2)), false);
    }
}
