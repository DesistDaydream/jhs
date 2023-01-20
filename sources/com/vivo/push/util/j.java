package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class j {

    /* renamed from: e  reason: collision with root package name */
    private static Method f8166e;
    public static final boolean a = b("rom_1.0");
    public static final boolean b = b("rom_2.0");

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8164c = b("rom_2.5");

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f8165d = b("rom_3.0");

    /* renamed from: f  reason: collision with root package name */
    private static String f8167f = null;

    /* renamed from: g  reason: collision with root package name */
    private static String f8168g = null;

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    private static boolean b(String str) {
        String b2 = z.b("ro.vivo.rom", "");
        String b3 = z.b("ro.vivo.rom.version", "");
        p.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
        if (b2 == null || !b2.contains(str)) {
            return b3 != null && b3.contains(str);
        }
        return true;
    }

    public static synchronized String a() {
        synchronized (j.class) {
            if (f8167f == null && f8168g == null) {
                try {
                    Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                    f8166e = declaredMethod;
                    declaredMethod.setAccessible(true);
                    f8167f = (String) f8166e.invoke(null, "ro.vivo.rom", "@><@");
                    f8168g = (String) f8166e.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception unused) {
                    p.b("Device", "getRomCode error");
                }
            }
            p.d("Device", "sRomProperty1 : " + f8167f + " ; sRomProperty2 : " + f8168g);
            String a2 = a(f8167f);
            if (TextUtils.isEmpty(a2)) {
                String a3 = a(f8168g);
                if (TextUtils.isEmpty(a3)) {
                    return null;
                }
                return a3;
            }
            return a2;
        }
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            p.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        p.d("Device", "Build.MANUFACTURER is " + str);
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith("vivo");
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (matcher.find()) {
            StringBuilder sb = new StringBuilder();
            sb.append(matcher.group(1));
            sb.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
            return sb.toString();
        }
        return null;
    }
}
