package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.y;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a implements NativeExceptionHandler {
    private final Context a;
    private final com.tencent.bugly.crashreport.crash.b b;

    /* renamed from: c  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f6653c;

    /* renamed from: d  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.a f6654d;

    public a(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        this.a = context;
        this.b = bVar;
        this.f6653c = aVar;
        this.f6654d = aVar2;
    }

    private static Map<String, String> a(String[] strArr) {
        HashMap hashMap = new HashMap(strArr == null ? 1 : strArr.length);
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                if (str != null) {
                    y.a("Extra message[%d]: %s", Integer.valueOf(i2), str);
                    String[] split = str.split("=");
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    } else {
                        y.d("bad extraMsg %s", str);
                    }
                }
            }
        } else {
            y.c("not found extraMsg", new Object[0]);
        }
        return hashMap;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i2, int i3, long j2, long j3, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7) {
        y.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i2, i3, j2, j3, str, str2, str3, str4, i4, str5, i5, i6, i7, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009c A[Catch: all -> 0x0224, TryCatch #1 {all -> 0x0224, blocks: (B:4:0x0016, B:6:0x0036, B:8:0x0049, B:10:0x0051, B:12:0x005d, B:14:0x0069, B:17:0x0070, B:19:0x007c, B:21:0x009c, B:22:0x00b5, B:24:0x00cc, B:26:0x00ef, B:27:0x00f6, B:30:0x0102, B:32:0x010a, B:40:0x0152, B:41:0x0156, B:43:0x0160, B:23:0x00ba, B:18:0x007a), top: B:79:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ba A[Catch: all -> 0x0224, TryCatch #1 {all -> 0x0224, blocks: (B:4:0x0016, B:6:0x0036, B:8:0x0049, B:10:0x0051, B:12:0x005d, B:14:0x0069, B:17:0x0070, B:19:0x007c, B:21:0x009c, B:22:0x00b5, B:24:0x00cc, B:26:0x00ef, B:27:0x00f6, B:30:0x0102, B:32:0x010a, B:40:0x0152, B:41:0x0156, B:43:0x0160, B:23:0x00ba, B:18:0x007a), top: B:79:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ef A[Catch: all -> 0x0224, TryCatch #1 {all -> 0x0224, blocks: (B:4:0x0016, B:6:0x0036, B:8:0x0049, B:10:0x0051, B:12:0x005d, B:14:0x0069, B:17:0x0070, B:19:0x007c, B:21:0x009c, B:22:0x00b5, B:24:0x00cc, B:26:0x00ef, B:27:0x00f6, B:30:0x0102, B:32:0x010a, B:40:0x0152, B:41:0x0156, B:43:0x0160, B:23:0x00ba, B:18:0x007a), top: B:79:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a3 A[Catch: all -> 0x0220, TryCatch #0 {all -> 0x0220, blocks: (B:47:0x019d, B:49:0x01a3, B:51:0x01ac), top: B:78:0x019d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ac A[Catch: all -> 0x0220, TRY_LEAVE, TryCatch #0 {all -> 0x0220, blocks: (B:47:0x019d, B:49:0x01a3, B:51:0x01ac), top: B:78:0x019d }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleNativeException2(int r28, int r29, long r30, long r32, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, java.lang.String r39, int r40, int r41, int r42, java.lang.String r43, java.lang.String r44, java.lang.String[] r45) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.a.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i2;
        String str12;
        int indexOf;
        boolean m2 = c.a().m();
        if (m2) {
            y.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.f6553e = this.f6653c.k();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f6653c;
        crashDetailBean.f6554f = aVar.f6525i;
        crashDetailBean.f6555g = aVar.u();
        crashDetailBean.f6561m = this.f6653c.g();
        crashDetailBean.n = str3;
        crashDetailBean.o = m2 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.q = str13;
        crashDetailBean.r = j2;
        crashDetailBean.u = ab.a(str13.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.L = this.f6653c.w();
        crashDetailBean.f6556h = this.f6653c.t();
        crashDetailBean.f6557i = this.f6653c.F();
        crashDetailBean.v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String a = b.a(dumpFilePath, str8);
        if (!ab.a(a)) {
            crashDetailBean.Y = a;
        }
        crashDetailBean.Z = b.b(dumpFilePath);
        crashDetailBean.w = b.a(str9, c.f6600e, null, false);
        crashDetailBean.x = b.a(str10, c.f6600e, null, true);
        crashDetailBean.M = str7;
        crashDetailBean.N = str6;
        crashDetailBean.O = str11;
        crashDetailBean.F = this.f6653c.o();
        crashDetailBean.G = this.f6653c.n();
        crashDetailBean.H = this.f6653c.p();
        crashDetailBean.I = com.tencent.bugly.crashreport.common.info.b.f();
        crashDetailBean.J = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.K = com.tencent.bugly.crashreport.common.info.b.h();
        if (z) {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.j();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.l();
            if (crashDetailBean.w == null) {
                crashDetailBean.w = ab.a(c.f6600e, (String) null);
            }
            crashDetailBean.y = aa.a();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f6653c;
            crashDetailBean.P = aVar2.a;
            crashDetailBean.Q = aVar2.a();
            crashDetailBean.z = ab.a(this.f6653c.h(), c.f6601f, false);
            int indexOf2 = crashDetailBean.q.indexOf("java:\n");
            if (indexOf2 > 0 && (i2 = indexOf2 + 6) < crashDetailBean.q.length()) {
                String str14 = crashDetailBean.q;
                String substring = str14.substring(i2, str14.length() - 1);
                if (substring.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.z.put(crashDetailBean.B, substring2);
                    crashDetailBean.q = crashDetailBean.q.substring(0, i2);
                    crashDetailBean.q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.f6653c.f6520d;
            }
            this.b.d(crashDetailBean);
            crashDetailBean.T = this.f6653c.D();
            crashDetailBean.U = this.f6653c.E();
            crashDetailBean.V = this.f6653c.x();
            crashDetailBean.W = this.f6653c.C();
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.P = -1L;
            crashDetailBean.T = -1;
            crashDetailBean.U = -1;
            crashDetailBean.V = map;
            crashDetailBean.W = this.f6653c.C();
            crashDetailBean.z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.y = bArr;
            }
        }
        return crashDetailBean;
    }
}
