package androidx.camera.lifecycle;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ProcessCameraProvider implements LifecycleCameraProvider {
    private static final ProcessCameraProvider sAppInstance = new ProcessCameraProvider();
    private CameraX mCameraX;
    @GuardedBy("mLock")
    private a<CameraX> mCameraXInitializeFuture;
    private Context mContext;
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private CameraXConfig.Provider mCameraXConfigProvider = null;
    @GuardedBy("mLock")
    private a<Void> mCameraXShutdownFuture = Futures.immediateFuture(null);
    private final LifecycleCameraRepository mLifecycleCameraRepository = new LifecycleCameraRepository();

    private ProcessCameraProvider() {
    }

    public static /* synthetic */ CameraXConfig a(CameraXConfig cameraXConfig) {
        return cameraXConfig;
    }

    public static /* synthetic */ ProcessCameraProvider b(Context context, CameraX cameraX) {
        ProcessCameraProvider processCameraProvider = sAppInstance;
        processCameraProvider.setCameraX(cameraX);
        processCameraProvider.setContext(ContextUtil.getApplicationContext(context));
        return processCameraProvider;
    }

    @ExperimentalCameraProviderConfiguration
    public static void configureInstance(@NonNull CameraXConfig cameraXConfig) {
        sAppInstance.configureInstanceInternal(cameraXConfig);
    }

    private void configureInstanceInternal(@NonNull final CameraXConfig cameraXConfig) {
        synchronized (this.mLock) {
            Preconditions.checkNotNull(cameraXConfig);
            Preconditions.checkState(this.mCameraXConfigProvider == null, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");
            this.mCameraXConfigProvider = new CameraXConfig.Provider() { // from class: c.b.c.b
                @Override // androidx.camera.core.CameraXConfig.Provider
                public final CameraXConfig getCameraXConfig() {
                    CameraXConfig cameraXConfig2 = cameraXConfig;
                    ProcessCameraProvider.a(cameraXConfig2);
                    return cameraXConfig2;
                }
            };
        }
    }

    /* renamed from: d */
    public /* synthetic */ Object e(final CameraX cameraX, final CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            Futures.addCallback(FutureChain.from(this.mCameraXShutdownFuture).transformAsync(new AsyncFunction() { // from class: c.b.c.a
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final e.j.c.a.a.a apply(Object obj) {
                    e.j.c.a.a.a initializeFuture;
                    Void r2 = (Void) obj;
                    initializeFuture = cameraX.getInitializeFuture();
                    return initializeFuture;
                }
            }, CameraXExecutors.directExecutor()), new FutureCallback<Void>() { // from class: androidx.camera.lifecycle.ProcessCameraProvider.1
                {
                    ProcessCameraProvider.this = this;
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    completer.setException(th);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r2) {
                    completer.set(cameraX);
                }
            }, CameraXExecutors.directExecutor());
        }
        return "ProcessCameraProvider-initializeCameraX";
    }

    @NonNull
    public static a<ProcessCameraProvider> getInstance(@NonNull final Context context) {
        Preconditions.checkNotNull(context);
        return Futures.transform(sAppInstance.getOrCreateCameraXInstance(context), new Function() { // from class: c.b.c.d
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ProcessCameraProvider.b(context, (CameraX) obj);
            }
        }, CameraXExecutors.directExecutor());
    }

    private a<CameraX> getOrCreateCameraXInstance(@NonNull Context context) {
        synchronized (this.mLock) {
            a<CameraX> aVar = this.mCameraXInitializeFuture;
            if (aVar != null) {
                return aVar;
            }
            final CameraX cameraX = new CameraX(context, this.mCameraXConfigProvider);
            a<CameraX> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.c.c
                {
                    ProcessCameraProvider.this = this;
                }

                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return ProcessCameraProvider.this.e(cameraX, completer);
                }
            });
            this.mCameraXInitializeFuture = future;
            return future;
        }
    }

    private void setCameraX(CameraX cameraX) {
        this.mCameraX = cameraX;
    }

    private void setContext(Context context) {
        this.mContext = context;
    }

    @NonNull
    @MainThread
    public Camera bindToLifecycle(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraSelector cameraSelector, @NonNull UseCase... useCaseArr) {
        return bindToLifecycle(lifecycleOwner, cameraSelector, null, useCaseArr);
    }

    @Override // androidx.camera.core.CameraProvider
    @NonNull
    public List<CameraInfo> getAvailableCameraInfos() {
        ArrayList arrayList = new ArrayList();
        for (CameraInternal cameraInternal : this.mCameraX.getCameraRepository().getCameras()) {
            arrayList.add(cameraInternal.getCameraInfo());
        }
        return arrayList;
    }

    @Override // androidx.camera.core.CameraProvider
    public boolean hasCamera(@NonNull CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        try {
            cameraSelector.select(this.mCameraX.getCameraRepository().getCameras());
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public boolean isBound(@NonNull UseCase useCase) {
        for (LifecycleCamera lifecycleCamera : this.mLifecycleCameraRepository.getLifecycleCameras()) {
            if (lifecycleCamera.isBound(useCase)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.TESTS})
    public a<Void> shutdown() {
        this.mLifecycleCameraRepository.clear();
        CameraX cameraX = this.mCameraX;
        a<Void> shutdown = cameraX != null ? cameraX.shutdown() : Futures.immediateFuture(null);
        synchronized (this.mLock) {
            this.mCameraXConfigProvider = null;
            this.mCameraXInitializeFuture = null;
            this.mCameraXShutdownFuture = shutdown;
        }
        this.mCameraX = null;
        this.mContext = null;
        return shutdown;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    @MainThread
    public void unbind(@NonNull UseCase... useCaseArr) {
        Threads.checkMainThread();
        this.mLifecycleCameraRepository.unbind(Arrays.asList(useCaseArr));
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    @MainThread
    public void unbindAll() {
        Threads.checkMainThread();
        this.mLifecycleCameraRepository.unbindAll();
    }

    @NonNull
    @MainThread
    public Camera bindToLifecycle(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraSelector cameraSelector, @NonNull UseCaseGroup useCaseGroup) {
        return bindToLifecycle(lifecycleOwner, cameraSelector, useCaseGroup.getViewPort(), (UseCase[]) useCaseGroup.getUseCases().toArray(new UseCase[0]));
    }

    @NonNull
    public Camera bindToLifecycle(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraSelector cameraSelector, @Nullable ViewPort viewPort, @NonNull UseCase... useCaseArr) {
        CameraConfig cameraConfig;
        CameraConfig config;
        Threads.checkMainThread();
        CameraSelector.Builder fromSelector = CameraSelector.Builder.fromSelector(cameraSelector);
        int length = useCaseArr.length;
        int i2 = 0;
        while (true) {
            cameraConfig = null;
            if (i2 >= length) {
                break;
            }
            CameraSelector cameraSelector2 = useCaseArr[i2].getCurrentConfig().getCameraSelector(null);
            if (cameraSelector2 != null) {
                Iterator<CameraFilter> it = cameraSelector2.getCameraFilterSet().iterator();
                while (it.hasNext()) {
                    fromSelector.addCameraFilter(it.next());
                }
            }
            i2++;
        }
        LinkedHashSet<CameraInternal> filter = fromSelector.build().filter(this.mCameraX.getCameraRepository().getCameras());
        if (!filter.isEmpty()) {
            LifecycleCamera lifecycleCamera = this.mLifecycleCameraRepository.getLifecycleCamera(lifecycleOwner, CameraUseCaseAdapter.generateCameraId(filter));
            Collection<LifecycleCamera> lifecycleCameras = this.mLifecycleCameraRepository.getLifecycleCameras();
            for (UseCase useCase : useCaseArr) {
                for (LifecycleCamera lifecycleCamera2 : lifecycleCameras) {
                    if (lifecycleCamera2.isBound(useCase) && lifecycleCamera2 != lifecycleCamera) {
                        throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", useCase));
                    }
                }
            }
            if (lifecycleCamera == null) {
                lifecycleCamera = this.mLifecycleCameraRepository.createLifecycleCamera(lifecycleOwner, new CameraUseCaseAdapter(filter, this.mCameraX.getCameraDeviceSurfaceManager(), this.mCameraX.getDefaultConfigFactory()));
            }
            Iterator<CameraFilter> it2 = cameraSelector.getCameraFilterSet().iterator();
            while (it2.hasNext()) {
                CameraFilter next = it2.next();
                if (next.getIdentifier() != CameraFilter.DEFAULT_ID && (config = ExtendedCameraConfigProviderStore.getConfigProvider(next.getIdentifier()).getConfig(lifecycleCamera.getCameraInfo(), this.mContext)) != null) {
                    if (cameraConfig != null) {
                        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                    }
                    cameraConfig = config;
                }
            }
            lifecycleCamera.setExtendedConfig(cameraConfig);
            if (useCaseArr.length == 0) {
                return lifecycleCamera;
            }
            this.mLifecycleCameraRepository.bindToLifecycleCamera(lifecycleCamera, viewPort, Arrays.asList(useCaseArr));
            return lifecycleCamera;
        }
        throw new IllegalArgumentException("Provided camera selector unable to resolve a camera for the given use case");
    }
}
