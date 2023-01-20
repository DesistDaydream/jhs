package androidx.core.location;

import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.location.LocationManagerCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import c.d.c.i;
import c.d.c.k;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    private static Field sContextField;
    @GuardedBy("sLocationListeners")
    public static final WeakHashMap<LocationListener, List<WeakReference<LocationListenerTransport>>> sLocationListeners = new WeakHashMap<>();
    private static Method sRequestLocationUpdatesExecutorMethod;
    private static Method sRequestLocationUpdatesLooperMethod;

    @RequiresApi(28)
    /* loaded from: classes.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static String getGnssHardwareModelName(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        @DoNotInline
        public static int getGnssYearOfHardware(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        @DoNotInline
        public static boolean isLocationEnabled(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static void getCurrentLocation(LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull final Consumer<Location> consumer) {
            android.os.CancellationSignal cancellationSignal2 = cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null;
            Objects.requireNonNull(consumer);
            locationManager.getCurrentLocation(str, cancellationSignal2, executor, new java.util.function.Consumer() { // from class: c.d.c.t
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Consumer.this.accept((Location) obj);
                }
            });
        }
    }

    @RequiresApi(31)
    /* loaded from: classes.dex */
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static boolean hasProvider(LocationManager locationManager, @NonNull String str) {
            return locationManager.hasProvider(str);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static void requestLocationUpdates(LocationManager locationManager, @NonNull String str, @NonNull LocationRequest locationRequest, @NonNull Executor executor, @NonNull LocationListener locationListener) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        }
    }

    /* loaded from: classes.dex */
    public static final class CancellableLocationListener implements LocationListener {
        private Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler = new Handler(Looper.getMainLooper());
        @Nullable
        public Runnable mTimeoutRunnable;
        @GuardedBy("this")
        private boolean mTriggered;

        public CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer) {
            this.mLocationManager = locationManager;
            this.mExecutor = executor;
            this.mConsumer = consumer;
        }

        public static /* synthetic */ void a(Consumer consumer, Location location) {
            consumer.accept(location);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        private void cleanup() {
            this.mConsumer = null;
            this.mLocationManager.removeUpdates(this);
            Runnable runnable = this.mTimeoutRunnable;
            if (runnable != null) {
                this.mTimeoutHandler.removeCallbacks(runnable);
                this.mTimeoutRunnable = null;
            }
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void cancel() {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                this.mTriggered = true;
                cleanup();
            }
        }

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onLocationChanged(@Nullable final Location location) {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                this.mTriggered = true;
                final Consumer<Location> consumer = this.mConsumer;
                this.mExecutor.execute(new Runnable() { // from class: c.d.c.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationManagerCompat.CancellableLocationListener.a(Consumer.this, location);
                    }
                });
                cleanup();
            }
        }

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onProviderDisabled(@NonNull String str) {
            onLocationChanged((Location) null);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NonNull String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }

        public void startTimeout(long j2) {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                Runnable runnable = new Runnable() { // from class: androidx.core.location.LocationManagerCompat.CancellableLocationListener.1
                    {
                        CancellableLocationListener.this = this;
                    }

                    @Override // java.lang.Runnable
                    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
                    public void run() {
                        CancellableLocationListener cancellableLocationListener = CancellableLocationListener.this;
                        cancellableLocationListener.mTimeoutRunnable = null;
                        cancellableLocationListener.onLocationChanged((Location) null);
                    }
                };
                this.mTimeoutRunnable = runnable;
                this.mTimeoutHandler.postDelayed(runnable, j2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class GnssLazyLoader {
        @GuardedBy("sGnssStatusListeners")
        public static final SimpleArrayMap<Object, Object> sGnssStatusListeners = new SimpleArrayMap<>();

        private GnssLazyLoader() {
        }
    }

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class GnssStatusTransport extends GnssStatus.Callback {
        public final GnssStatusCompat.Callback mCallback;

        public GnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i2) {
            this.mCallback.onFirstFix(i2);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.mCallback.onStarted();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.mCallback.onStopped();
        }
    }

    /* loaded from: classes.dex */
    public static class GpsStatusTransport implements GpsStatus.Listener {
        public final GnssStatusCompat.Callback mCallback;
        @Nullable
        public volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        public GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mLocationManager = locationManager;
            this.mCallback = callback;
        }

        /* renamed from: a */
        public /* synthetic */ void b(Executor executor) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onStarted();
        }

        /* renamed from: c */
        public /* synthetic */ void d(Executor executor) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onStopped();
        }

        /* renamed from: e */
        public /* synthetic */ void f(Executor executor, int i2) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onFirstFix(i2);
        }

        /* renamed from: g */
        public /* synthetic */ void h(Executor executor, GnssStatusCompat gnssStatusCompat) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onSatelliteStatusChanged(gnssStatusCompat);
        }

        @Override // android.location.GpsStatus.Listener
        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int i2) {
            GpsStatus gpsStatus;
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            if (i2 == 1) {
                executor.execute(new Runnable() { // from class: c.d.c.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationManagerCompat.GpsStatusTransport.this.b(executor);
                    }
                });
            } else if (i2 == 2) {
                executor.execute(new Runnable() { // from class: c.d.c.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationManagerCompat.GpsStatusTransport.this.d(executor);
                    }
                });
            } else if (i2 != 3) {
                if (i2 == 4 && (gpsStatus = this.mLocationManager.getGpsStatus(null)) != null) {
                    final GnssStatusCompat wrap = GnssStatusCompat.wrap(gpsStatus);
                    executor.execute(new Runnable() { // from class: c.d.c.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            LocationManagerCompat.GpsStatusTransport.this.h(executor, wrap);
                        }
                    });
                }
            } else {
                GpsStatus gpsStatus2 = this.mLocationManager.getGpsStatus(null);
                if (gpsStatus2 != null) {
                    final int timeToFirstFix = gpsStatus2.getTimeToFirstFix();
                    executor.execute(new Runnable() { // from class: c.d.c.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            LocationManagerCompat.GpsStatusTransport.this.f(executor, timeToFirstFix);
                        }
                    });
                }
            }
        }

        public void register(Executor executor) {
            Preconditions.checkState(this.mExecutor == null);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    /* loaded from: classes.dex */
    public static final class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        public InlineHandlerExecutor(@NonNull Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (Looper.myLooper() == this.mHandler.getLooper()) {
                runnable.run();
            } else if (this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
            } else {
                throw new RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }

    @RequiresApi(24)
    /* loaded from: classes.dex */
    public static class PreRGnssStatusTransport extends GnssStatus.Callback {
        public final GnssStatusCompat.Callback mCallback;
        @Nullable
        public volatile Executor mExecutor;

        public PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        /* renamed from: a */
        public /* synthetic */ void b(Executor executor, int i2) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onFirstFix(i2);
        }

        /* renamed from: c */
        public /* synthetic */ void d(Executor executor, GnssStatus gnssStatus) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        /* renamed from: e */
        public /* synthetic */ void f(Executor executor) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onStarted();
        }

        /* renamed from: g */
        public /* synthetic */ void h(Executor executor) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onStopped();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(final int i2) {
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: c.d.c.r
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.this.b(executor, i2);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: c.d.c.q
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.this.d(executor, gnssStatus);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: c.d.c.s
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.this.f(executor);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: c.d.c.p
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.this.h(executor);
                }
            });
        }

        public void register(Executor executor) {
            Preconditions.checkArgument(executor != null, "invalid null executor");
            Preconditions.checkState(this.mExecutor == null);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    private LocationManagerCompat() {
    }

    public static /* synthetic */ void a(Consumer consumer, Location location) {
        consumer.accept(location);
    }

    public static /* synthetic */ Boolean b(LocationManager locationManager, GpsStatusTransport gpsStatusTransport) throws Exception {
        return Boolean.valueOf(locationManager.addGpsStatusListener(gpsStatusTransport));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void getCurrentLocation(@NonNull LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull final Consumer<Location> consumer) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.getCurrentLocation(locationManager, str, cancellationSignal, executor, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        final Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation != null && SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(lastKnownLocation) < 10000) {
            executor.execute(new Runnable() { // from class: c.d.c.a
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.a(Consumer.this, lastKnownLocation);
                }
            });
            return;
        }
        final CancellableLocationListener cancellableLocationListener = new CancellableLocationListener(locationManager, executor, consumer);
        locationManager.requestLocationUpdates(str, 0L, 0.0f, cancellableLocationListener, Looper.getMainLooper());
        if (cancellationSignal != null) {
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.core.location.LocationManagerCompat.1
                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
                public void onCancel() {
                    cancellableLocationListener.cancel();
                }
            });
        }
        cancellableLocationListener.startTimeout(30000L);
    }

    @Nullable
    public static String getGnssHardwareModelName(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssHardwareModelName(locationManager);
        }
        return null;
    }

    public static int getGnssYearOfHardware(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssYearOfHardware(locationManager);
        }
        return 0;
    }

    public static boolean hasProvider(@NonNull LocationManager locationManager, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.hasProvider(locationManager, str);
        }
        if (locationManager.getAllProviders().contains(str)) {
            return true;
        }
        try {
            return locationManager.getProvider(str) != null;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static boolean isLocationEnabled(@NonNull LocationManager locationManager) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return Api28Impl.isLocationEnabled(locationManager);
        }
        if (i2 <= 19) {
            try {
                if (sContextField == null) {
                    Field declaredField = LocationManager.class.getDeclaredField("mContext");
                    sContextField = declaredField;
                    declaredField.setAccessible(true);
                }
                Context context = (Context) sContextField.get(locationManager);
                if (context != null) {
                    if (i2 == 19) {
                        return Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0;
                    }
                    return !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed"));
                }
            } catch (ClassCastException | IllegalAccessException | NoSuchFieldException | SecurityException unused) {
            }
        }
        return locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback, @NonNull Handler handler) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback);
        }
        return registerGnssStatusCallback(locationManager, new InlineHandlerExecutor(handler), callback);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void removeUpdates(@NonNull LocationManager locationManager, @NonNull LocationListenerCompat locationListenerCompat) {
        WeakHashMap<LocationListener, List<WeakReference<LocationListenerTransport>>> weakHashMap = sLocationListeners;
        synchronized (weakHashMap) {
            List<WeakReference<LocationListenerTransport>> remove = weakHashMap.remove(locationListenerCompat);
            if (remove != null) {
                for (WeakReference<LocationListenerTransport> weakReference : remove) {
                    LocationListenerTransport locationListenerTransport = weakReference.get();
                    if (locationListenerTransport != null && locationListenerTransport.unregister()) {
                        locationManager.removeUpdates(locationListenerTransport);
                    }
                }
            }
        }
        locationManager.removeUpdates(locationListenerCompat);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager locationManager, @NonNull String str, @NonNull LocationRequestCompat locationRequestCompat, @NonNull Executor executor, @NonNull LocationListenerCompat locationListenerCompat) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            Api31Impl.requestLocationUpdates(locationManager, str, locationRequestCompat.toLocationRequest(), executor, locationListenerCompat);
            return;
        }
        if (i2 >= 30) {
            try {
                if (sRequestLocationUpdatesExecutorMethod == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", LocationRequest.class, Executor.class, LocationListener.class);
                    sRequestLocationUpdatesExecutorMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                if (locationRequest != null) {
                    sRequestLocationUpdatesExecutorMethod.invoke(locationManager, locationRequest, executor, locationListenerCompat);
                    return;
                }
            } catch (IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
        }
        LocationListenerTransport locationListenerTransport = new LocationListenerTransport(locationListenerCompat, executor);
        if (i2 >= 19) {
            try {
                if (sRequestLocationUpdatesLooperMethod == null) {
                    Method declaredMethod2 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", LocationRequest.class, LocationListener.class, Looper.class);
                    sRequestLocationUpdatesLooperMethod = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                LocationRequest locationRequest2 = locationRequestCompat.toLocationRequest(str);
                if (locationRequest2 != null) {
                    synchronized (sLocationListeners) {
                        sRequestLocationUpdatesLooperMethod.invoke(locationManager, locationRequest2, locationListenerTransport, Looper.getMainLooper());
                        locationListenerTransport.register();
                    }
                    return;
                }
            } catch (IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused2) {
            }
        }
        synchronized (sLocationListeners) {
            locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), locationListenerTransport, Looper.getMainLooper());
            locationListenerTransport.register();
        }
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            SimpleArrayMap<Object, Object> simpleArrayMap = GnssLazyLoader.sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                GnssStatus.Callback callback2 = (GnssStatusTransport) simpleArrayMap.remove(callback);
                if (callback2 != null) {
                    locationManager.unregisterGnssStatusCallback(callback2);
                }
            }
        } else if (i2 >= 24) {
            SimpleArrayMap<Object, Object> simpleArrayMap2 = GnssLazyLoader.sGnssStatusListeners;
            synchronized (simpleArrayMap2) {
                PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) simpleArrayMap2.remove(callback);
                if (preRGnssStatusTransport != null) {
                    preRGnssStatusTransport.unregister();
                    locationManager.unregisterGnssStatusCallback(preRGnssStatusTransport);
                }
            }
        } else {
            SimpleArrayMap<Object, Object> simpleArrayMap3 = GnssLazyLoader.sGnssStatusListeners;
            synchronized (simpleArrayMap3) {
                GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) simpleArrayMap3.remove(callback);
                if (gpsStatusTransport != null) {
                    gpsStatusTransport.unregister();
                    locationManager.removeGpsStatusListener(gpsStatusTransport);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LocationListenerTransport implements LocationListener {
        public final Executor mExecutor;
        @Nullable
        public volatile LocationListenerCompat mListener;

        public LocationListenerTransport(@Nullable LocationListenerCompat locationListenerCompat, Executor executor) {
            this.mListener = (LocationListenerCompat) ObjectsCompat.requireNonNull(locationListenerCompat, "invalid null listener");
            this.mExecutor = executor;
        }

        /* renamed from: a */
        public /* synthetic */ void b(LocationListenerCompat locationListenerCompat, int i2) {
            if (this.mListener != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onFlushComplete(i2);
        }

        /* renamed from: c */
        public /* synthetic */ void d(LocationListenerCompat locationListenerCompat, Location location) {
            if (this.mListener != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onLocationChanged(location);
        }

        /* renamed from: e */
        public /* synthetic */ void f(LocationListenerCompat locationListenerCompat, List list) {
            if (this.mListener != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onLocationChanged(list);
        }

        /* renamed from: g */
        public /* synthetic */ void h(LocationListenerCompat locationListenerCompat, String str) {
            if (this.mListener != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onProviderDisabled(str);
        }

        /* renamed from: i */
        public /* synthetic */ void j(LocationListenerCompat locationListenerCompat, String str) {
            if (this.mListener != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onProviderEnabled(str);
        }

        /* renamed from: k */
        public /* synthetic */ void l(LocationListenerCompat locationListenerCompat, String str, int i2, Bundle bundle) {
            if (this.mListener != locationListenerCompat) {
                return;
            }
            locationListenerCompat.onStatusChanged(str, i2, bundle);
        }

        public static /* synthetic */ boolean m(WeakReference weakReference) {
            return weakReference.get() == null;
        }

        public static /* synthetic */ boolean n(WeakReference weakReference) {
            return weakReference.get() == null;
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(final int i2) {
            final LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return;
            }
            this.mExecutor.execute(new Runnable() { // from class: c.d.c.o
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.b(locationListenerCompat, i2);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@NonNull final Location location) {
            final LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return;
            }
            this.mExecutor.execute(new Runnable() { // from class: c.d.c.l
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.d(locationListenerCompat, location);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(@NonNull final String str) {
            final LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return;
            }
            this.mExecutor.execute(new Runnable() { // from class: c.d.c.m
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.h(locationListenerCompat, str);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NonNull final String str) {
            final LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return;
            }
            this.mExecutor.execute(new Runnable() { // from class: c.d.c.n
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.j(locationListenerCompat, str);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String str, final int i2, final Bundle bundle) {
            final LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return;
            }
            this.mExecutor.execute(new Runnable() { // from class: c.d.c.j
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.l(locationListenerCompat, str, i2, bundle);
                }
            });
        }

        @GuardedBy("sLocationListeners")
        public void register() {
            WeakHashMap<LocationListener, List<WeakReference<LocationListenerTransport>>> weakHashMap = LocationManagerCompat.sLocationListeners;
            List<WeakReference<LocationListenerTransport>> list = weakHashMap.get(this.mListener);
            if (list == null) {
                list = new ArrayList<>(1);
                weakHashMap.put(this.mListener, list);
            } else if (Build.VERSION.SDK_INT >= 24) {
                list.removeIf(i.a);
            } else {
                Iterator<WeakReference<LocationListenerTransport>> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == null) {
                        it.remove();
                    }
                }
            }
            list.add(new WeakReference<>(this));
        }

        @GuardedBy("sLocationListeners")
        public boolean unregister() {
            LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return false;
            }
            this.mListener = null;
            List<WeakReference<LocationListenerTransport>> list = LocationManagerCompat.sLocationListeners.get(locationListenerCompat);
            if (list != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    list.removeIf(k.a);
                } else {
                    Iterator<WeakReference<LocationListenerTransport>> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().get() == null) {
                            it.remove();
                        }
                    }
                }
                if (list.isEmpty()) {
                    LocationManagerCompat.sLocationListeners.remove(locationListenerCompat);
                    return true;
                }
                return true;
            }
            return true;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@NonNull final List<Location> list) {
            final LocationListenerCompat locationListenerCompat = this.mListener;
            if (locationListenerCompat == null) {
                return;
            }
            this.mExecutor.execute(new Runnable() { // from class: c.d.c.h
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.f(locationListenerCompat, list);
                }
            });
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, null, executor, callback);
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return registerGnssStatusCallback(locationManager, new Handler(myLooper), executor, callback);
    }

    /* JADX WARN: Removed duplicated region for block: B:205:0x010a A[Catch: all -> 0x0126, TryCatch #2 {all -> 0x0126, blocks: (B:199:0x00e9, B:200:0x00ff, B:203:0x0102, B:205:0x010a, B:207:0x0112, B:208:0x0118, B:209:0x0119, B:210:0x011e, B:211:0x011f, B:212:0x0125, B:189:0x00d8), top: B:223:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x011f A[Catch: all -> 0x0126, TryCatch #2 {all -> 0x0126, blocks: (B:199:0x00e9, B:200:0x00ff, B:203:0x0102, B:205:0x010a, B:207:0x0112, B:208:0x0118, B:209:0x0119, B:210:0x011e, B:211:0x011f, B:212:0x0125, B:189:0x00d8), top: B:223:0x0098 }] */
    @androidx.annotation.RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean registerGnssStatusCallback(final android.location.LocationManager r9, android.os.Handler r10, java.util.concurrent.Executor r11, androidx.core.location.GnssStatusCompat.Callback r12) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.location.LocationManagerCompat.registerGnssStatusCallback(android.location.LocationManager, android.os.Handler, java.util.concurrent.Executor, androidx.core.location.GnssStatusCompat$Callback):boolean");
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager locationManager, @NonNull String str, @NonNull LocationRequestCompat locationRequestCompat, @NonNull LocationListenerCompat locationListenerCompat, @NonNull Looper looper) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            Api31Impl.requestLocationUpdates(locationManager, str, locationRequestCompat.toLocationRequest(), ExecutorCompat.create(new Handler(looper)), locationListenerCompat);
            return;
        }
        if (i2 >= 19) {
            try {
                if (sRequestLocationUpdatesLooperMethod == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", LocationRequest.class, LocationListener.class, Looper.class);
                    sRequestLocationUpdatesLooperMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                try {
                    LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                    if (locationRequest != null) {
                        sRequestLocationUpdatesLooperMethod.invoke(locationManager, locationRequest, locationListenerCompat, looper);
                        return;
                    }
                } catch (IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
                }
            } catch (IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused2) {
            }
            locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), locationListenerCompat, looper);
        }
        locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), locationListenerCompat, looper);
    }
}
