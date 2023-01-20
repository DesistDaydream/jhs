package com.umeng.commonsdk.internal.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public static class a {
        public String a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public int f7419c;

        /* renamed from: d  reason: collision with root package name */
        public String f7420d;

        /* renamed from: e  reason: collision with root package name */
        public String f7421e;

        /* renamed from: f  reason: collision with root package name */
        public String f7422f;

        /* renamed from: g  reason: collision with root package name */
        public String f7423g;

        /* renamed from: h  reason: collision with root package name */
        public String f7424h;

        /* renamed from: i  reason: collision with root package name */
        public String f7425i;

        /* renamed from: j  reason: collision with root package name */
        public String f7426j;

        /* renamed from: k  reason: collision with root package name */
        public String f7427k;

        /* renamed from: l  reason: collision with root package name */
        public String f7428l;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.umeng.commonsdk.internal.utils.d.a a() {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.d.a():com.umeng.commonsdk.internal.utils.d$a");
    }

    public static String b() {
        byte[] bArr;
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            while (inputStream.read(new byte[24]) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String c() {
        byte[] bArr;
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            while (inputStream.read(new byte[24]) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String d() {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
        } catch (Exception unused) {
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            String trim = bufferedReader.readLine().trim();
            try {
                bufferedReader.close();
                return trim;
            } catch (Throwable unused2) {
                return trim;
            }
        } catch (Exception unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused4) {
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused5) {
                }
            }
            throw th;
        }
    }
}
