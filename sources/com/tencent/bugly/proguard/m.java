package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class m {
    public static final long a = System.currentTimeMillis();
    private static m b;

    /* renamed from: c  reason: collision with root package name */
    private Context f6763c;

    /* renamed from: f  reason: collision with root package name */
    private SharedPreferences f6766f;

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, Map<String, l>> f6765e = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private String f6764d = com.tencent.bugly.crashreport.common.info.a.b().f6520d;

    private m(Context context) {
        this.f6763c = context;
        this.f6766f = context.getSharedPreferences("crashrecord", 0);
    }

    public static /* synthetic */ boolean b(l lVar, l lVar2) {
        String str = lVar.f6760e;
        if (str == null || str.equalsIgnoreCase(lVar2.f6760e)) {
            String str2 = lVar.f6761f;
            return !(str2 == null || str2.equalsIgnoreCase(lVar2.f6761f)) || lVar.f6759d <= 0;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r6 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        if (r6 == null) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> T c(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            android.content.Context r3 = r5.f6763c     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r4.<init>()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r4.append(r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            if (r6 != 0) goto L24
            monitor-exit(r5)
            return r0
        L24:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.ClassNotFoundException -> L3d java.io.IOException -> L4b java.lang.Throwable -> L55
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.ClassNotFoundException -> L3d java.io.IOException -> L4b java.lang.Throwable -> L55
            r6.close()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            monitor-exit(r5)
            return r2
        L39:
            r2 = move-exception
            r6 = r0
            goto L56
        L3c:
            r6 = r0
        L3d:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L55
            com.tencent.bugly.proguard.y.a(r2, r3)     // Catch: java.lang.Throwable -> L55
            if (r6 == 0) goto L65
        L46:
            r6.close()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            goto L65
        L4a:
            r6 = r0
        L4b:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L55
            com.tencent.bugly.proguard.y.a(r2, r3)     // Catch: java.lang.Throwable -> L55
            if (r6 == 0) goto L65
            goto L46
        L55:
            r2 = move-exception
        L56:
            if (r6 == 0) goto L5b
            r6.close()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
        L5b:
            throw r2     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
        L5c:
            r6 = move-exception
            goto L67
        L5e:
            java.lang.String r6 = "readCrashRecord error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5c
            com.tencent.bugly.proguard.y.e(r6, r1)     // Catch: java.lang.Throwable -> L5c
        L65:
            monitor-exit(r5)
            return r0
        L67:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.m.c(int):java.util.List");
    }

    public static /* synthetic */ boolean a(l lVar, l lVar2) {
        String str;
        return lVar.f6762g == lVar2.f6762g && (str = lVar.b) != null && str.equalsIgnoreCase(lVar2.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean b(int i2) {
        try {
            List<l> c2 = c(i2);
            if (c2 == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (l lVar : c2) {
                String str = lVar.b;
                if (str != null && str.equalsIgnoreCase(this.f6764d) && lVar.f6759d > 0) {
                    arrayList.add(lVar);
                }
                if (lVar.f6758c + 86400000 < currentTimeMillis) {
                    arrayList2.add(lVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((l) arrayList.get(arrayList.size() - 1)).f6758c + 86400000 >= currentTimeMillis) {
                    return true;
                }
                c2.clear();
                a(i2, (int) c2);
                return false;
            }
            c2.removeAll(arrayList2);
            a(i2, (int) c2);
            return false;
        } catch (Exception unused) {
            y.e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public static synchronized m a(Context context) {
        m mVar;
        synchronized (m.class) {
            if (b == null) {
                b = new m(context);
            }
            mVar = b;
        }
        return mVar;
    }

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            mVar = b;
        }
        return mVar;
    }

    public final void a(int i2, final int i3) {
        x.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.m.1
            @Override // java.lang.Runnable
            public final void run() {
                l lVar;
                try {
                    if (TextUtils.isEmpty(m.this.f6764d)) {
                        return;
                    }
                    List<l> c2 = m.this.c(r2);
                    if (c2 == null) {
                        c2 = new ArrayList();
                    }
                    if (m.this.f6765e.get(Integer.valueOf(r2)) == null) {
                        m.this.f6765e.put(Integer.valueOf(r2), new HashMap());
                    }
                    if (((Map) m.this.f6765e.get(Integer.valueOf(r2))).get(m.this.f6764d) != null) {
                        lVar = (l) ((Map) m.this.f6765e.get(Integer.valueOf(r2))).get(m.this.f6764d);
                        lVar.f6759d = i3;
                    } else {
                        lVar = new l();
                        lVar.a = r2;
                        lVar.f6762g = m.a;
                        lVar.b = m.this.f6764d;
                        lVar.f6761f = com.tencent.bugly.crashreport.common.info.a.b().f6525i;
                        lVar.f6760e = com.tencent.bugly.crashreport.common.info.a.b().f6522f;
                        lVar.f6758c = System.currentTimeMillis();
                        lVar.f6759d = i3;
                        ((Map) m.this.f6765e.get(Integer.valueOf(r2))).put(m.this.f6764d, lVar);
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (l lVar2 : c2) {
                        if (m.a(lVar2, lVar)) {
                            z = true;
                            lVar2.f6759d = lVar.f6759d;
                        }
                        if (m.b(lVar2, lVar)) {
                            arrayList.add(lVar2);
                        }
                    }
                    c2.removeAll(arrayList);
                    if (!z) {
                        c2.add(lVar);
                    }
                    m.this.a(r2, (int) c2);
                } catch (Exception unused) {
                    y.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f A[Catch: all -> 0x0053, Exception -> 0x0055, TRY_ENTER, TryCatch #4 {Exception -> 0x0055, blocks: (B:7:0x0006, B:11:0x002d, B:21:0x0046, B:27:0x004f, B:28:0x0052), top: B:36:0x0006, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> void a(int r5, T r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            android.content.Context r2 = r4.f6763c     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.lang.String r3 = "crashrecord"
            java.io.File r2 = r2.getDir(r3, r0)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r3.<init>()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r3.append(r5)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.lang.String r5 = r3.toString()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r1.<init>(r2, r5)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r5 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L37
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L37
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L37
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L37
            r2.writeObject(r6)     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L4c
            r2.close()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            goto L5c
        L31:
            r5 = move-exception
            goto L3a
        L33:
            r6 = move-exception
            r2 = r5
            r5 = r6
            goto L4d
        L37:
            r6 = move-exception
            r2 = r5
            r5 = r6
        L3a:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L4c
            java.lang.String r5 = "open record file error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4c
            com.tencent.bugly.proguard.y.a(r5, r6)     // Catch: java.lang.Throwable -> L4c
            if (r2 == 0) goto L4a
            r2.close()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            goto L5c
        L4a:
            monitor-exit(r4)
            return
        L4c:
            r5 = move-exception
        L4d:
            if (r2 == 0) goto L52
            r2.close()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
        L52:
            throw r5     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
        L53:
            r5 = move-exception
            goto L5e
        L55:
            java.lang.String r5 = "writeCrashRecord error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L53
            com.tencent.bugly.proguard.y.e(r5, r6)     // Catch: java.lang.Throwable -> L53
        L5c:
            monitor-exit(r4)
            return
        L5e:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.m.a(int, java.util.List):void");
    }

    public final synchronized boolean a(final int i2) {
        boolean z;
        z = true;
        try {
            SharedPreferences sharedPreferences = this.f6766f;
            z = sharedPreferences.getBoolean(i2 + "_" + this.f6764d, true);
            x.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.m.2
                @Override // java.lang.Runnable
                public final void run() {
                    boolean b2 = m.this.b(i2);
                    SharedPreferences.Editor edit = m.this.f6766f.edit();
                    edit.putBoolean(i2 + "_" + m.this.f6764d, !b2).commit();
                }
            });
        } catch (Exception unused) {
            y.e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
