package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.b.c.r.a0;
import e.j.a.b.e.d;
import e.j.a.b.e.e;
import e.j.a.b.e.f;
import e.j.a.b.e.g;
import e.j.a.b.e.h;
import e.j.a.b.e.i;
import e.j.a.b.e.j;
import e.j.a.b.e.k;
import e.j.a.b.e.l;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class DynamiteModule {
    @GuardedBy("DynamiteModule.class")
    private static Boolean b = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: c  reason: collision with root package name */
    private static i f2665c = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: d  reason: collision with root package name */
    private static k f2666d = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: e  reason: collision with root package name */
    private static String f2667e = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: f  reason: collision with root package name */
    private static int f2668f = -1;

    /* renamed from: g  reason: collision with root package name */
    private static final ThreadLocal<b> f2669g = new ThreadLocal<>();

    /* renamed from: h  reason: collision with root package name */
    private static final a.InterfaceC0092a f2670h = new e.j.a.b.e.a();
    @e.j.a.b.c.m.a

    /* renamed from: i  reason: collision with root package name */
    public static final a f2671i = new e.j.a.b.e.b();
    @e.j.a.b.c.m.a

    /* renamed from: j  reason: collision with root package name */
    public static final a f2672j = new e.j.a.b.e.c();
    @e.j.a.b.c.m.a

    /* renamed from: k  reason: collision with root package name */
    public static final a f2673k = new d();
    @e.j.a.b.c.m.a

    /* renamed from: l  reason: collision with root package name */
    public static final a f2674l = new e();
    @e.j.a.b.c.m.a

    /* renamed from: m  reason: collision with root package name */
    public static final a f2675m = new f();
    private static final a n = new g();
    private final Context a;

    @DynamiteApi
    /* loaded from: classes2.dex */
    public static class DynamiteLoaderClassLoader {
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        public /* synthetic */ LoadingException(String str, e.j.a.b.e.a aVar) {
            this(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th, e.j.a.b.e.a aVar) {
            this(str, th);
        }
    }

    /* loaded from: classes2.dex */
    public interface a {

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public interface InterfaceC0092a {
            int a(Context context, String str, boolean z) throws LoadingException;

            int b(Context context, String str);
        }

        /* loaded from: classes2.dex */
        public static class b {
            public int a = 0;
            public int b = 0;

            /* renamed from: c  reason: collision with root package name */
            public int f2676c = 0;
        }

        b a(Context context, String str, InterfaceC0092a interfaceC0092a) throws LoadingException;
    }

    /* loaded from: classes2.dex */
    public static class b {
        public Cursor a;

        private b() {
        }

        public /* synthetic */ b(e.j.a.b.e.a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements a.InterfaceC0092a {
        private final int a;
        private final int b = 0;

        public c(int i2, int i3) {
            this.a = i2;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.InterfaceC0092a
        public final int a(Context context, String str, boolean z) {
            return 0;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.InterfaceC0092a
        public final int b(Context context, String str) {
            return this.a;
        }
    }

    private DynamiteModule(Context context) {
        this.a = (Context) a0.k(context);
    }

    @e.j.a.b.c.m.a
    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!declaredField.get(null).equals(str)) {
                String valueOf = String.valueOf(declaredField.get(null));
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
                sb2.append("Module descriptor id '");
                sb2.append(valueOf);
                sb2.append("' didn't match expected id '");
                sb2.append(str);
                sb2.append("'");
                Log.e("DynamiteModule", sb2.toString());
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    @e.j.a.b.c.m.a
    public static int c(Context context, String str) {
        return f(context, str, false);
    }

    @e.j.a.b.c.m.a
    public static DynamiteModule e(Context context, a aVar, String str) throws LoadingException {
        ThreadLocal<b> threadLocal = f2669g;
        b bVar = threadLocal.get();
        b bVar2 = new b(null);
        threadLocal.set(bVar2);
        try {
            a.b a2 = aVar.a(context, str, f2670h);
            int i2 = a2.a;
            int i3 = a2.b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(i3);
            Log.i("DynamiteModule", sb.toString());
            int i4 = a2.f2676c;
            if (i4 == 0 || ((i4 == -1 && a2.a == 0) || (i4 == 1 && a2.b == 0))) {
                int i5 = a2.a;
                int i6 = a2.b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i5);
                sb2.append(" and remote version is ");
                sb2.append(i6);
                sb2.append(".");
                throw new LoadingException(sb2.toString(), (e.j.a.b.e.a) null);
            } else if (i4 == -1) {
                DynamiteModule m2 = m(context, str);
                Cursor cursor = bVar2.a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(bVar);
                return m2;
            } else if (i4 == 1) {
                try {
                    DynamiteModule g2 = g(context, str, a2.b);
                    Cursor cursor2 = bVar2.a;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    threadLocal.set(bVar);
                    return g2;
                } catch (LoadingException e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                    int i7 = a2.a;
                    if (i7 != 0 && aVar.a(context, str, new c(i7, 0)).f2676c == -1) {
                        DynamiteModule m3 = m(context, str);
                        Cursor cursor3 = bVar2.a;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        f2669g.set(bVar);
                        return m3;
                    }
                    throw new LoadingException("Remote load failed. No local fallback found.", e2, null);
                }
            } else {
                int i8 = a2.f2676c;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i8);
                throw new LoadingException(sb3.toString(), (e.j.a.b.e.a) null);
            }
        } catch (Throwable th) {
            Cursor cursor4 = bVar2.a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f2669g.set(bVar);
            throw th;
        }
    }

    public static int f(Context context, String str, boolean z) {
        Class<?> loadClass;
        Field declaredField;
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool3 = b;
                if (bool3 == null) {
                    try {
                        loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                        declaredField = loadClass.getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String valueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(valueOf);
                        Log.w("DynamiteModule", sb.toString());
                    }
                    synchronized (loadClass) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader != ClassLoader.getSystemClassLoader()) {
                                try {
                                    h(classLoader);
                                } catch (LoadingException unused) {
                                }
                                bool2 = bool;
                                b = bool2;
                                bool3 = bool2;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                        } else {
                            try {
                                int l2 = l(context, str, z);
                                String str2 = f2667e;
                                if (str2 != null && !str2.isEmpty()) {
                                    h hVar = new h(f2667e, ClassLoader.getSystemClassLoader());
                                    h(hVar);
                                    declaredField.set(null, hVar);
                                    b = bool;
                                    return l2;
                                }
                                return l2;
                            } catch (LoadingException unused2) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                            }
                        }
                        bool = bool2;
                        bool2 = bool;
                        b = bool2;
                        bool3 = bool2;
                    }
                }
                if (bool3.booleanValue()) {
                    try {
                        return l(context, str, z);
                    } catch (LoadingException e3) {
                        String valueOf2 = String.valueOf(e3.getMessage());
                        Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                        return 0;
                    }
                }
                return j(context, str, z);
            }
        } catch (Throwable th) {
            e.j.a.b.c.x.i.a(context, th);
            throw th;
        }
    }

    private static DynamiteModule g(Context context, String str, int i2) throws LoadingException {
        Boolean bool;
        e.j.a.b.d.d Q;
        try {
            synchronized (DynamiteModule.class) {
                bool = b;
            }
            if (bool != null) {
                if (bool.booleanValue()) {
                    return k(context, str, i2);
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i2);
                Log.i("DynamiteModule", sb.toString());
                i n2 = n(context);
                if (n2 != null) {
                    if (n2.L() >= 2) {
                        Q = n2.X(e.j.a.b.d.f.b0(context), str, i2);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        Q = n2.Q(e.j.a.b.d.f.b0(context), str, i2);
                    }
                    if (e.j.a.b.d.f.c(Q) != null) {
                        return new DynamiteModule((Context) e.j.a.b.d.f.c(Q));
                    }
                    throw new LoadingException("Failed to load remote module.", (e.j.a.b.e.a) null);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", (e.j.a.b.e.a) null);
            }
            throw new LoadingException("Failed to determine which loading route to use.", (e.j.a.b.e.a) null);
        } catch (RemoteException e2) {
            throw new LoadingException("Failed to load remote module.", e2, null);
        } catch (LoadingException e3) {
            throw e3;
        } catch (Throwable th) {
            e.j.a.b.c.x.i.a(context, th);
            throw new LoadingException("Failed to load remote module.", th, null);
        }
    }

    @GuardedBy("DynamiteModule.class")
    private static void h(ClassLoader classLoader) throws LoadingException {
        k lVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                lVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof k) {
                    lVar = (k) queryLocalInterface;
                } else {
                    lVar = new l(iBinder);
                }
            }
            f2666d = lVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, null);
        }
    }

    private static Boolean i() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(f2668f >= 2);
        }
        return valueOf;
    }

    private static int j(Context context, String str, boolean z) {
        i n2 = n(context);
        if (n2 == null) {
            return 0;
        }
        try {
            if (n2.L() >= 2) {
                return n2.T(e.j.a.b.d.f.b0(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return n2.W(e.j.a.b.d.f.b0(context), str, z);
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    private static DynamiteModule k(Context context, String str, int i2) throws LoadingException, RemoteException {
        k kVar;
        e.j.a.b.d.d j2;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            kVar = f2666d;
        }
        if (kVar != null) {
            b bVar = f2669g.get();
            if (bVar != null && bVar.a != null) {
                Context applicationContext = context.getApplicationContext();
                Cursor cursor = bVar.a;
                e.j.a.b.d.f.b0(null);
                if (i().booleanValue()) {
                    Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                    j2 = kVar.k(e.j.a.b.d.f.b0(applicationContext), str, i2, e.j.a.b.d.f.b0(cursor));
                } else {
                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                    j2 = kVar.j(e.j.a.b.d.f.b0(applicationContext), str, i2, e.j.a.b.d.f.b0(cursor));
                }
                Context context2 = (Context) e.j.a.b.d.f.c(j2);
                if (context2 != null) {
                    return new DynamiteModule(context2);
                }
                throw new LoadingException("Failed to get module context", (e.j.a.b.e.a) null);
            }
            throw new LoadingException("No result cursor", (e.j.a.b.e.a) null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", (e.j.a.b.e.a) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int l(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r10 == 0) goto La
            java.lang.String r8 = "api_force_staging"
            goto Lc
        La:
            java.lang.String r8 = "api"
        Lc:
            int r10 = r8.length()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.append(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.append(r9)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r8 == 0) goto L83
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r9 == 0) goto L83
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r9 <= 0) goto L7c
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> L79
            com.google.android.gms.dynamite.DynamiteModule.f2667e = r1     // Catch: java.lang.Throwable -> L79
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L79
            if (r1 < 0) goto L67
            int r1 = r8.getInt(r1)     // Catch: java.lang.Throwable -> L79
            com.google.android.gms.dynamite.DynamiteModule.f2668f = r1     // Catch: java.lang.Throwable -> L79
        L67:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L79
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$b> r10 = com.google.android.gms.dynamite.DynamiteModule.f2669g     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.lang.Object r10 = r10.get()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            com.google.android.gms.dynamite.DynamiteModule$b r10 = (com.google.android.gms.dynamite.DynamiteModule.b) r10     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r10 == 0) goto L7c
            android.database.Cursor r1 = r10.a     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r1 != 0) goto L7c
            r10.a = r8     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            goto L7d
        L79:
            r9 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L79
            throw r9     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
        L7c:
            r0 = r8
        L7d:
            if (r0 == 0) goto L82
            r0.close()
        L82:
            return r9
        L83:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            throw r9     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
        L92:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Lae
        L96:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L9f
        L9b:
            r8 = move-exception
            goto Lae
        L9d:
            r8 = move-exception
            r9 = r0
        L9f:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch: java.lang.Throwable -> Lac
            if (r10 == 0) goto La4
            throw r8     // Catch: java.lang.Throwable -> Lac
        La4:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> Lac
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch: java.lang.Throwable -> Lac
            throw r10     // Catch: java.lang.Throwable -> Lac
        Lac:
            r8 = move-exception
            r0 = r9
        Lae:
            if (r0 == 0) goto Lb3
            r0.close()
        Lb3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.l(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule m(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static i n(Context context) {
        i jVar;
        synchronized (DynamiteModule.class) {
            i iVar = f2665c;
            if (iVar != null) {
                return iVar;
            }
            if (e.j.a.b.c.f.i().j(context) != 0) {
                return null;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    jVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof i) {
                        jVar = (i) queryLocalInterface;
                    } else {
                        jVar = new j(iBinder);
                    }
                }
                if (jVar != null) {
                    f2665c = jVar;
                    return jVar;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    @e.j.a.b.c.m.a
    public final Context b() {
        return this.a;
    }

    @e.j.a.b.c.m.a
    public final IBinder d(String str) throws LoadingException {
        try {
            return (IBinder) this.a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e2, null);
        }
    }
}
