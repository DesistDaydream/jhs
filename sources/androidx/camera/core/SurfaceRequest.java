package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import e.j.b.a.c;
import e.j.c.a.a.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class SurfaceRequest {
    private final CameraInternal mCamera;
    private final DeferrableSurface mInternalDeferrableSurface;
    private final Object mLock = new Object();
    private final boolean mRGBA8888Required;
    private final CallbackToFutureAdapter.Completer<Void> mRequestCancellationCompleter;
    private final Size mResolution;
    private final a<Void> mSessionStatusFuture;
    private final CallbackToFutureAdapter.Completer<Surface> mSurfaceCompleter;
    public final a<Surface> mSurfaceFuture;
    @Nullable
    @GuardedBy("mLock")
    private TransformationInfo mTransformationInfo;
    @Nullable
    @GuardedBy("mLock")
    private Executor mTransformationInfoExecutor;
    @Nullable
    @GuardedBy("mLock")
    private TransformationInfoListener mTransformationInfoListener;

    /* loaded from: classes.dex */
    public static final class RequestCancelledException extends RuntimeException {
        public RequestCancelledException(@NonNull String str, @NonNull Throwable th) {
            super(str, th);
        }
    }

    @c
    /* loaded from: classes.dex */
    public static abstract class Result {
        public static final int RESULT_INVALID_SURFACE = 2;
        public static final int RESULT_REQUEST_CANCELLED = 1;
        public static final int RESULT_SURFACE_ALREADY_PROVIDED = 3;
        public static final int RESULT_SURFACE_USED_SUCCESSFULLY = 0;
        public static final int RESULT_WILL_NOT_PROVIDE_SURFACE = 4;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes.dex */
        public @interface ResultCode {
        }

        @NonNull
        public static Result of(int i2, @NonNull Surface surface) {
            return new AutoValue_SurfaceRequest_Result(i2, surface);
        }

        public abstract int getResultCode();

        @NonNull
        public abstract Surface getSurface();
    }

    @c
    /* loaded from: classes.dex */
    public static abstract class TransformationInfo {
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static TransformationInfo of(@NonNull Rect rect, int i2, int i3) {
            return new AutoValue_SurfaceRequest_TransformationInfo(rect, i2, i3);
        }

        @NonNull
        public abstract Rect getCropRect();

        public abstract int getRotationDegrees();

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public abstract int getTargetRotation();
    }

    /* loaded from: classes.dex */
    public interface TransformationInfoListener {
        void onTransformationInfoUpdate(@NonNull TransformationInfo transformationInfo);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SurfaceRequest(@NonNull Size size, @NonNull CameraInternal cameraInternal, boolean z) {
        this.mResolution = size;
        this.mCamera = cameraInternal;
        this.mRGBA8888Required = z;
        final String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + "]";
        final AtomicReference atomicReference = new AtomicReference(null);
        final a future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.b.j1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return SurfaceRequest.a(atomicReference, str, completer);
            }
        });
        final CallbackToFutureAdapter.Completer<Void> completer = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
        this.mRequestCancellationCompleter = completer;
        final AtomicReference atomicReference2 = new AtomicReference(null);
        a<Void> future2 = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.b.k1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer2) {
                return SurfaceRequest.b(atomicReference2, str, completer2);
            }
        });
        this.mSessionStatusFuture = future2;
        Futures.addCallback(future2, new FutureCallback<Void>() { // from class: androidx.camera.core.SurfaceRequest.1
            {
                SurfaceRequest.this = this;
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                if (th instanceof RequestCancelledException) {
                    Preconditions.checkState(future.cancel(false));
                } else {
                    Preconditions.checkState(completer.set(null));
                }
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r2) {
                Preconditions.checkState(completer.set(null));
            }
        }, CameraXExecutors.directExecutor());
        final CallbackToFutureAdapter.Completer completer2 = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference2.get());
        final AtomicReference atomicReference3 = new AtomicReference(null);
        a<Surface> future3 = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.b.i1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer3) {
                return SurfaceRequest.c(atomicReference3, str, completer3);
            }
        });
        this.mSurfaceFuture = future3;
        this.mSurfaceCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference3.get());
        DeferrableSurface deferrableSurface = new DeferrableSurface(size, 34) { // from class: androidx.camera.core.SurfaceRequest.2
            {
                SurfaceRequest.this = this;
            }

            @Override // androidx.camera.core.impl.DeferrableSurface
            @NonNull
            public a<Surface> provideSurface() {
                return SurfaceRequest.this.mSurfaceFuture;
            }
        };
        this.mInternalDeferrableSurface = deferrableSurface;
        final a<Void> terminationFuture = deferrableSurface.getTerminationFuture();
        Futures.addCallback(future3, new FutureCallback<Surface>() { // from class: androidx.camera.core.SurfaceRequest.3
            {
                SurfaceRequest.this = this;
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                if (th instanceof CancellationException) {
                    CallbackToFutureAdapter.Completer completer3 = completer2;
                    Preconditions.checkState(completer3.setException(new RequestCancelledException(str + " cancelled.", th)));
                    return;
                }
                completer2.set(null);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Surface surface) {
                Futures.propagate(terminationFuture, completer2);
            }
        }, CameraXExecutors.directExecutor());
        terminationFuture.addListener(new Runnable() { // from class: c.b.b.h1
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceRequest.this.e();
            }
        }, CameraXExecutors.directExecutor());
    }

    public static /* synthetic */ Object a(AtomicReference atomicReference, String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return str + "-cancellation";
    }

    public static /* synthetic */ Object b(AtomicReference atomicReference, String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return str + "-status";
    }

    public static /* synthetic */ Object c(AtomicReference atomicReference, String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return str + "-Surface";
    }

    /* renamed from: d */
    public /* synthetic */ void e() {
        this.mSurfaceFuture.cancel(true);
    }

    public static /* synthetic */ void f(Consumer consumer, Surface surface) {
        consumer.accept(Result.of(3, surface));
    }

    public static /* synthetic */ void g(Consumer consumer, Surface surface) {
        consumer.accept(Result.of(4, surface));
    }

    public static /* synthetic */ void h(TransformationInfoListener transformationInfoListener, TransformationInfo transformationInfo) {
        transformationInfoListener.onTransformationInfoUpdate(transformationInfo);
    }

    public static /* synthetic */ void i(TransformationInfoListener transformationInfoListener, TransformationInfo transformationInfo) {
        transformationInfoListener.onTransformationInfoUpdate(transformationInfo);
    }

    @SuppressLint({"PairedRegistration"})
    public void addRequestCancellationListener(@NonNull Executor executor, @NonNull Runnable runnable) {
        this.mRequestCancellationCompleter.addCancellationListener(runnable, executor);
    }

    public void clearTransformationInfoListener() {
        synchronized (this.mLock) {
            this.mTransformationInfoListener = null;
            this.mTransformationInfoExecutor = null;
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInternal getCamera() {
        return this.mCamera;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DeferrableSurface getDeferrableSurface() {
        return this.mInternalDeferrableSurface;
    }

    @NonNull
    public Size getResolution() {
        return this.mResolution;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRGBA8888Required() {
        return this.mRGBA8888Required;
    }

    public void provideSurface(@NonNull final Surface surface, @NonNull Executor executor, @NonNull final Consumer<Result> consumer) {
        if (!this.mSurfaceCompleter.set(surface) && !this.mSurfaceFuture.isCancelled()) {
            Preconditions.checkState(this.mSurfaceFuture.isDone());
            try {
                this.mSurfaceFuture.get();
                executor.execute(new Runnable() { // from class: c.b.b.d1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SurfaceRequest.f(Consumer.this, surface);
                    }
                });
                return;
            } catch (InterruptedException | ExecutionException unused) {
                executor.execute(new Runnable() { // from class: c.b.b.e1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SurfaceRequest.g(Consumer.this, surface);
                    }
                });
                return;
            }
        }
        Futures.addCallback(this.mSessionStatusFuture, new FutureCallback<Void>() { // from class: androidx.camera.core.SurfaceRequest.4
            {
                SurfaceRequest.this = this;
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                Preconditions.checkState(th instanceof RequestCancelledException, "Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th);
                consumer.accept(Result.of(1, surface));
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r3) {
                consumer.accept(Result.of(0, surface));
            }
        }, executor);
    }

    public void setTransformationInfoListener(@NonNull Executor executor, @NonNull final TransformationInfoListener transformationInfoListener) {
        final TransformationInfo transformationInfo;
        synchronized (this.mLock) {
            this.mTransformationInfoListener = transformationInfoListener;
            this.mTransformationInfoExecutor = executor;
            transformationInfo = this.mTransformationInfo;
        }
        if (transformationInfo != null) {
            executor.execute(new Runnable() { // from class: c.b.b.f1
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceRequest.h(SurfaceRequest.TransformationInfoListener.this, transformationInfo);
                }
            });
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void updateTransformationInfo(@NonNull final TransformationInfo transformationInfo) {
        final TransformationInfoListener transformationInfoListener;
        Executor executor;
        synchronized (this.mLock) {
            this.mTransformationInfo = transformationInfo;
            transformationInfoListener = this.mTransformationInfoListener;
            executor = this.mTransformationInfoExecutor;
        }
        if (transformationInfoListener == null || executor == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: c.b.b.g1
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceRequest.i(SurfaceRequest.TransformationInfoListener.this, transformationInfo);
            }
        });
    }

    public boolean willNotProvideSurface() {
        return this.mSurfaceCompleter.setException(new DeferrableSurface.SurfaceUnavailableException("Surface request will not complete."));
    }
}
