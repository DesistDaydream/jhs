package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import e.j.a.b.c.n.u.c;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.y;
import e.j.a.b.c.x.v;
import e.j.a.b.c.x.x;
import e.j.d.d.e;
import e.j.d.d.g;
import e.j.d.d.m;
import e.j.d.d.r;
import e.j.d.j.f;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

@e.j.d.c.a
/* loaded from: classes2.dex */
public class FirebaseApp {
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    private static final String FIREBASE_ANDROID = "fire-android";
    private static final String FIREBASE_COMMON = "fire-core";
    private static final String LOG_TAG = "FirebaseApp";
    private final Context applicationContext;
    private final m componentRuntime;
    private final r<e.j.d.h.a> dataCollectionConfigStorage;
    private final String name;
    private final FirebaseOptions options;
    private static final Object LOCK = new Object();
    private static final Executor UI_EXECUTOR = new c();
    @GuardedBy("LOCK")
    public static final Map<String, FirebaseApp> INSTANCES = new ArrayMap();
    private final AtomicBoolean automaticResourceManagementEnabled = new AtomicBoolean(false);
    private final AtomicBoolean deleted = new AtomicBoolean();
    private final List<BackgroundStateChangeListener> backgroundStateChangeListeners = new CopyOnWriteArrayList();
    private final List<FirebaseAppLifecycleListener> lifecycleListeners = new CopyOnWriteArrayList();

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public interface BackgroundStateChangeListener {
        @e.j.a.b.c.m.a
        void onBackgroundStateChanged(boolean z);
    }

    @TargetApi(14)
    /* loaded from: classes2.dex */
    public static class b implements c.a {
        private static AtomicReference<b> a = new AtomicReference<>();

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (v.c() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (a.get() == null) {
                    b bVar = new b();
                    if (a.compareAndSet(null, bVar)) {
                        e.j.a.b.c.n.u.c.c(application);
                        e.j.a.b.c.n.u.c.b().a(bVar);
                    }
                }
            }
        }

        @Override // e.j.a.b.c.n.u.c.a
        public void onBackgroundStateChanged(boolean z) {
            synchronized (FirebaseApp.LOCK) {
                Iterator it = new ArrayList(FirebaseApp.INSTANCES.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.automaticResourceManagementEnabled.get()) {
                        firebaseApp.notifyBackgroundStateChangeListeners(z);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Executor {
        private static final Handler a = new Handler(Looper.getMainLooper());

        private c() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            a.post(runnable);
        }
    }

    @TargetApi(24)
    /* loaded from: classes2.dex */
    public static class d extends BroadcastReceiver {
        private static AtomicReference<d> b = new AtomicReference<>();
        private final Context a;

        public d(Context context) {
            this.a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (b.get() == null) {
                d dVar = new d(context);
                if (b.compareAndSet(null, dVar)) {
                    context.registerReceiver(dVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.LOCK) {
                for (FirebaseApp firebaseApp : FirebaseApp.INSTANCES.values()) {
                    firebaseApp.initializeAllApis();
                }
            }
            c();
        }
    }

    public FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.applicationContext = (Context) a0.k(context);
        this.name = a0.g(str);
        this.options = (FirebaseOptions) a0.k(firebaseOptions);
        this.componentRuntime = new m(UI_EXECUTOR, g.b(context).a(), e.q(context, Context.class, new Class[0]), e.q(this, FirebaseApp.class, new Class[0]), e.q(firebaseOptions, FirebaseOptions.class, new Class[0]), f.a(FIREBASE_ANDROID, ""), f.a(FIREBASE_COMMON, BuildConfig.VERSION_NAME), e.j.d.j.c.b());
        this.dataCollectionConfigStorage = new r<>(e.j.d.a.a(this, context));
    }

    private void checkNotDeleted() {
        a0.r(!this.deleted.get(), "FirebaseApp was deleted");
    }

    @VisibleForTesting
    public static void clearInstancesForTest() {
        synchronized (LOCK) {
            INSTANCES.clear();
        }
    }

    private static List<String> getAllAppNames() {
        ArrayList arrayList = new ArrayList();
        synchronized (LOCK) {
            for (FirebaseApp firebaseApp : INSTANCES.values()) {
                arrayList.add(firebaseApp.getName());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @e.j.d.c.a
    public static List<FirebaseApp> getApps(Context context) {
        ArrayList arrayList;
        synchronized (LOCK) {
            arrayList = new ArrayList(INSTANCES.values());
        }
        return arrayList;
    }

    @NonNull
    @e.j.d.c.a
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (LOCK) {
            firebaseApp = INSTANCES.get(DEFAULT_APP_NAME);
            if (firebaseApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + x.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeAllApis() {
        if (!UserManagerCompat.isUserUnlocked(this.applicationContext)) {
            d.b(this.applicationContext);
        } else {
            this.componentRuntime.e(isDefaultApp());
        }
    }

    @Nullable
    @e.j.d.c.a
    public static FirebaseApp initializeApp(@NonNull Context context) {
        synchronized (LOCK) {
            if (INSTANCES.containsKey(DEFAULT_APP_NAME)) {
                return getInstance();
            }
            FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
            if (fromResource == null) {
                Log.w(LOG_TAG, "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return initializeApp(context, fromResource);
        }
    }

    public static /* synthetic */ e.j.d.h.a lambda$new$0(FirebaseApp firebaseApp, Context context) {
        return new e.j.d.h.a(context, firebaseApp.getPersistenceKey(), (e.j.d.e.c) firebaseApp.componentRuntime.a(e.j.d.e.c.class));
    }

    private static String normalize(@NonNull String str) {
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBackgroundStateChangeListeners(boolean z) {
        Log.d(LOG_TAG, "Notifying background state change listeners.");
        for (BackgroundStateChangeListener backgroundStateChangeListener : this.backgroundStateChangeListeners) {
            backgroundStateChangeListener.onBackgroundStateChanged(z);
        }
    }

    private void notifyOnAppDeleted() {
        for (FirebaseAppLifecycleListener firebaseAppLifecycleListener : this.lifecycleListeners) {
            firebaseAppLifecycleListener.onDeleted(this.name, this.options);
        }
    }

    @e.j.a.b.c.m.a
    public void addBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        checkNotDeleted();
        if (this.automaticResourceManagementEnabled.get() && e.j.a.b.c.n.u.c.b().d()) {
            backgroundStateChangeListener.onBackgroundStateChanged(true);
        }
        this.backgroundStateChangeListeners.add(backgroundStateChangeListener);
    }

    @e.j.a.b.c.m.a
    public void addLifecycleEventListener(@NonNull FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        checkNotDeleted();
        a0.k(firebaseAppLifecycleListener);
        this.lifecycleListeners.add(firebaseAppLifecycleListener);
    }

    @e.j.d.c.a
    public void delete() {
        if (this.deleted.compareAndSet(false, true)) {
            synchronized (LOCK) {
                INSTANCES.remove(this.name);
            }
            notifyOnAppDeleted();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof FirebaseApp) {
            return this.name.equals(((FirebaseApp) obj).getName());
        }
        return false;
    }

    @e.j.a.b.c.m.a
    public <T> T get(Class<T> cls) {
        checkNotDeleted();
        return (T) this.componentRuntime.a(cls);
    }

    @NonNull
    @e.j.d.c.a
    public Context getApplicationContext() {
        checkNotDeleted();
        return this.applicationContext;
    }

    @NonNull
    @e.j.d.c.a
    public String getName() {
        checkNotDeleted();
        return this.name;
    }

    @NonNull
    @e.j.d.c.a
    public FirebaseOptions getOptions() {
        checkNotDeleted();
        return this.options;
    }

    @e.j.a.b.c.m.a
    public String getPersistenceKey() {
        return e.j.a.b.c.x.c.f(getName().getBytes(Charset.defaultCharset())) + "+" + e.j.a.b.c.x.c.f(getOptions().getApplicationId().getBytes(Charset.defaultCharset()));
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    @e.j.a.b.c.m.a
    public boolean isDataCollectionDefaultEnabled() {
        checkNotDeleted();
        return this.dataCollectionConfigStorage.get().b();
    }

    @e.j.a.b.c.m.a
    @VisibleForTesting
    public boolean isDefaultApp() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    @e.j.a.b.c.m.a
    public void removeBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        checkNotDeleted();
        this.backgroundStateChangeListeners.remove(backgroundStateChangeListener);
    }

    @e.j.a.b.c.m.a
    public void removeLifecycleEventListener(@NonNull FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        checkNotDeleted();
        a0.k(firebaseAppLifecycleListener);
        this.lifecycleListeners.remove(firebaseAppLifecycleListener);
    }

    @e.j.d.c.a
    public void setAutomaticResourceManagementEnabled(boolean z) {
        checkNotDeleted();
        if (this.automaticResourceManagementEnabled.compareAndSet(!z, z)) {
            boolean d2 = e.j.a.b.c.n.u.c.b().d();
            if (z && d2) {
                notifyBackgroundStateChangeListeners(true);
            } else if (z || !d2) {
            } else {
                notifyBackgroundStateChangeListeners(false);
            }
        }
    }

    @e.j.a.b.c.m.a
    public void setDataCollectionDefaultEnabled(boolean z) {
        checkNotDeleted();
        this.dataCollectionConfigStorage.get().d(z);
    }

    public String toString() {
        return y.c(this).a("name", this.name).a("options", this.options).toString();
    }

    @e.j.a.b.c.m.a
    public static String getPersistenceKey(String str, FirebaseOptions firebaseOptions) {
        return e.j.a.b.c.x.c.f(str.getBytes(Charset.defaultCharset())) + "+" + e.j.a.b.c.x.c.f(firebaseOptions.getApplicationId().getBytes(Charset.defaultCharset()));
    }

    @NonNull
    @e.j.d.c.a
    public static FirebaseApp getInstance(@NonNull String str) {
        FirebaseApp firebaseApp;
        List<String> allAppNames;
        String str2;
        synchronized (LOCK) {
            firebaseApp = INSTANCES.get(normalize(str));
            if (firebaseApp == null) {
                if (getAllAppNames().isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", allAppNames);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", str, str2));
            }
        }
        return firebaseApp;
    }

    @NonNull
    @e.j.d.c.a
    public static FirebaseApp initializeApp(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    @NonNull
    @e.j.d.c.a
    public static FirebaseApp initializeApp(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions, @NonNull String str) {
        FirebaseApp firebaseApp;
        b.b(context);
        String normalize = normalize(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (LOCK) {
            Map<String, FirebaseApp> map = INSTANCES;
            boolean z = !map.containsKey(normalize);
            a0.r(z, "FirebaseApp name " + normalize + " already exists!");
            a0.l(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, normalize, firebaseOptions);
            map.put(normalize, firebaseApp);
        }
        firebaseApp.initializeAllApis();
        return firebaseApp;
    }
}
