package com.ss.android.downloadlib.addownload.b;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.effective.android.panel.Constants;
import com.ss.android.downloadlib.addownload.j;
import e.t.u.b0;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class d {
    private static volatile d a;

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f5251c = {"com", Constants.ANDROID, b0.a.f14656g};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f5252d = {3101, 3102, 3103, 3201, 3202, 3203};
    private final LinkedList<a> b = new LinkedList<>();

    /* loaded from: classes3.dex */
    public static class a {
        public final String a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final String f5253c;

        /* renamed from: d  reason: collision with root package name */
        public final String f5254d;

        /* renamed from: e  reason: collision with root package name */
        public final long f5255e;

        private a(String str, int i2, String str2, String str3, long j2) {
            this.a = str;
            this.b = i2;
            this.f5253c = str2 != null ? str2.toLowerCase() : null;
            this.f5254d = str3 != null ? str3.toLowerCase() : null;
            this.f5255e = j2;
        }
    }

    private d() {
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private a c(String str) {
        try {
            PackageManager packageManager = j.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new a(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void b(String str) {
        b();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.b) {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().a)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void a(String str) {
        a c2;
        b();
        if (TextUtils.isEmpty(str) || (c2 = c(str)) == null) {
            return;
        }
        synchronized (this.b) {
            this.b.add(c2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.b.d.a, java.lang.Integer> b(com.ss.android.downloadad.api.a.b r19) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.b.d.b(com.ss.android.downloadad.api.a.b):android.util.Pair");
    }

    public a a(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return null;
        }
        b();
        synchronized (this.b) {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.f5255e > bVar.C()) {
                    return next;
                }
            }
            return null;
        }
    }

    private static boolean a(String str, String str2) {
        String[] split;
        String[] split2;
        boolean z;
        try {
            split = str.split("\\.");
            split2 = str2.split("\\.");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (split.length != 0 && split2.length != 0) {
            int i2 = 0;
            int i3 = 0;
            for (String str3 : split) {
                String[] strArr = f5251c;
                int length = strArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        z = false;
                        break;
                    }
                    String str4 = strArr[i4];
                    if (str4.equals(str3)) {
                        if (i2 < split2.length && str4.equals(split2[i2])) {
                            i2++;
                        }
                        z = true;
                    } else {
                        i4++;
                    }
                }
                if (!z) {
                    int i5 = i3;
                    int i6 = i2;
                    while (i2 < split2.length) {
                        if (str3.equals(split2[i2])) {
                            if (i2 == i6) {
                                i6++;
                            }
                            i5++;
                            if (i5 >= 2) {
                                return true;
                            }
                        }
                        i2++;
                    }
                    i2 = i6;
                    i3 = i5;
                }
            }
            return false;
        }
        return false;
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.b) {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext() && currentTimeMillis - it.next().f5255e > 1800000) {
                it.remove();
            }
        }
    }
}
