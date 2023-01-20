package com.ss.android.socialbase.appdownloader.f;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.i.f;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: classes3.dex */
public class d {
    public static String a = null;
    public static String b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f5494c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f5495d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f5496e;

    /* renamed from: f  reason: collision with root package name */
    private static String f5497f;

    /* renamed from: g  reason: collision with root package name */
    private static String f5498g;

    public static boolean a() {
        return a("EMUI");
    }

    public static boolean b() {
        return a("MIUI");
    }

    public static boolean c() {
        return a("VIVO");
    }

    public static boolean d() {
        o();
        return a(a);
    }

    public static boolean e() {
        return a("FLYME");
    }

    public static boolean f() {
        return a("SAMSUNG");
    }

    public static String g() {
        if (f5496e == null) {
            a("");
        }
        return f5496e;
    }

    public static String h() {
        if (f5497f == null) {
            a("");
        }
        return f5497f;
    }

    public static String i() {
        if (f5494c == null) {
            a("");
        }
        return f5494c;
    }

    @NonNull
    public static String j() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    @NonNull
    public static String k() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static boolean l() {
        p();
        return "V10".equals(f5498g);
    }

    public static boolean m() {
        p();
        return "V11".equals(f5498g);
    }

    public static boolean n() {
        p();
        return "V12".equals(f5498g);
    }

    private static void o() {
        if (TextUtils.isEmpty(a)) {
            com.ss.android.socialbase.downloader.downloader.c.F();
            a = com.ss.android.socialbase.downloader.constants.e.b;
            f5495d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.f5569c + "rom";
            b = "com." + com.ss.android.socialbase.downloader.constants.e.f5569c + ".market";
        }
    }

    private static void p() {
        if (f5498g == null) {
            try {
                f5498g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f5498g;
            if (str == null) {
                str = "";
            }
            f5498g = str;
        }
    }

    public static boolean a(String str) {
        o();
        String str2 = f5496e;
        if (str2 != null) {
            return str2.equals(str);
        }
        String d2 = d("ro.miui.ui.version.name");
        f5497f = d2;
        if (!TextUtils.isEmpty(d2)) {
            f5496e = "MIUI";
            f5494c = "com.xiaomi.market";
            f5498g = f5497f;
        } else {
            String d3 = d("ro.build.version.emui");
            f5497f = d3;
            if (!TextUtils.isEmpty(d3)) {
                f5496e = "EMUI";
                f5494c = "com.huawei.appmarket";
            } else {
                String d4 = d(f5495d);
                f5497f = d4;
                if (!TextUtils.isEmpty(d4)) {
                    f5496e = a;
                    if (g.a(b) > -1) {
                        f5494c = b;
                    } else {
                        f5494c = "com.heytap.market";
                    }
                } else {
                    String d5 = d("ro.vivo.os.version");
                    f5497f = d5;
                    if (!TextUtils.isEmpty(d5)) {
                        f5496e = "VIVO";
                        f5494c = "com.bbk.appstore";
                    } else {
                        String d6 = d("ro.smartisan.version");
                        f5497f = d6;
                        if (!TextUtils.isEmpty(d6)) {
                            f5496e = "SMARTISAN";
                            f5494c = "com.smartisanos.appstore";
                        } else {
                            String d7 = d("ro.gn.sv.version");
                            f5497f = d7;
                            if (!TextUtils.isEmpty(d7)) {
                                f5496e = "QIONEE";
                                f5494c = "com.gionee.aora.market";
                            } else {
                                String d8 = d("ro.lenovo.lvp.version");
                                f5497f = d8;
                                if (!TextUtils.isEmpty(d8)) {
                                    f5496e = "LENOVO";
                                    f5494c = "com.lenovo.leos.appstore";
                                } else if (j().toUpperCase().contains("SAMSUNG")) {
                                    f5496e = "SAMSUNG";
                                    f5494c = "com.sec.android.app.samsungapps";
                                } else if (j().toUpperCase().contains("ZTE")) {
                                    f5496e = "ZTE";
                                    f5494c = "zte.com.market";
                                } else if (j().toUpperCase().contains("NUBIA")) {
                                    f5496e = "NUBIA";
                                    f5494c = "cn.nubia.neostore";
                                } else if (k().toUpperCase().contains("FLYME")) {
                                    f5496e = "FLYME";
                                    f5494c = "com.meizu.mstore";
                                    f5497f = k();
                                } else if (j().toUpperCase().contains("ONEPLUS")) {
                                    f5496e = "ONEPLUS";
                                    f5497f = d("ro.rom.version");
                                    if (g.a(b) > -1) {
                                        f5494c = b;
                                    } else {
                                        f5494c = "com.heytap.market";
                                    }
                                } else {
                                    f5496e = j().toUpperCase();
                                    f5494c = "";
                                    f5497f = "";
                                }
                            }
                        }
                    }
                }
            }
        }
        return f5496e.equals(str);
    }

    public static String b(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                f.a(bufferedReader);
                return readLine;
            } catch (Throwable unused) {
                f.a(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String c(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static String d(String str) {
        if (com.ss.android.socialbase.downloader.g.a.b().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return c(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return b(str);
            }
        }
        return b(str);
    }
}
