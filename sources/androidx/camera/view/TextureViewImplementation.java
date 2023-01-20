package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.TextureViewImplementation;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import e.j.c.a.a.a;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class TextureViewImplementation extends PreviewViewImplementation {
    private static final String TAG = "TextureViewImpl";
    public SurfaceTexture mDetachedSurfaceTexture;
    public boolean mIsSurfaceTextureDetachedFromView;
    public AtomicReference<CallbackToFutureAdapter.Completer<Void>> mNextFrameCompleter;
    @Nullable
    public PreviewViewImplementation.OnSurfaceNotInUseListener mOnSurfaceNotInUseListener;
    public a<SurfaceRequest.Result> mSurfaceReleaseFuture;
    public SurfaceRequest mSurfaceRequest;
    public SurfaceTexture mSurfaceTexture;
    public TextureView mTextureView;

    public TextureViewImplementation(@NonNull FrameLayout frameLayout, @NonNull PreviewTransformation previewTransformation) {
        super(frameLayout, previewTransformation);
        this.mIsSurfaceTextureDetachedFromView = false;
        this.mNextFrameCompleter = new AtomicReference<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(SurfaceRequest surfaceRequest) {
        SurfaceRequest surfaceRequest2 = this.mSurfaceRequest;
        if (surfaceRequest2 != null && surfaceRequest2 == surfaceRequest) {
            this.mSurfaceRequest = null;
            this.mSurfaceReleaseFuture = null;
        }
        notifySurfaceNotInUse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ Object d(Surface surface, final CallbackToFutureAdapter.Completer completer) throws Exception {
        Logger.d(TAG, "Surface set on Preview.");
        SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        Executor directExecutor = CameraXExecutors.directExecutor();
        Objects.requireNonNull(completer);
        surfaceRequest.provideSurface(surface, directExecutor, new Consumer() { // from class: c.b.d.v
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                completer.set((SurfaceRequest.Result) obj);
            }
        });
        return "provideSurface[request=" + this.mSurfaceRequest + " surface=" + surface + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(Surface surface, a aVar, SurfaceRequest surfaceRequest) {
        Logger.d(TAG, "Safe to release surface.");
        notifySurfaceNotInUse();
        surface.release();
        if (this.mSurfaceReleaseFuture == aVar) {
            this.mSurfaceReleaseFuture = null;
        }
        if (this.mSurfaceRequest == surfaceRequest) {
            this.mSurfaceRequest = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ Object h(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mNextFrameCompleter.set(completer);
        return "textureViewImpl_waitForNextFrame";
    }

    private void notifySurfaceNotInUse() {
        PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener = this.mOnSurfaceNotInUseListener;
        if (onSurfaceNotInUseListener != null) {
            onSurfaceNotInUseListener.onSurfaceNotInUse();
            this.mOnSurfaceNotInUseListener = null;
        }
    }

    private void reattachSurfaceTexture() {
        if (!this.mIsSurfaceTextureDetachedFromView || this.mDetachedSurfaceTexture == null) {
            return;
        }
        SurfaceTexture surfaceTexture = this.mTextureView.getSurfaceTexture();
        SurfaceTexture surfaceTexture2 = this.mDetachedSurfaceTexture;
        if (surfaceTexture != surfaceTexture2) {
            this.mTextureView.setSurfaceTexture(surfaceTexture2);
            this.mDetachedSurfaceTexture = null;
            this.mIsSurfaceTextureDetachedFromView = false;
        }
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    @Nullable
    public View getPreview() {
        return this.mTextureView;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    @Nullable
    public Bitmap getPreviewBitmap() {
        TextureView textureView = this.mTextureView;
        if (textureView == null || !textureView.isAvailable()) {
            return null;
        }
        return this.mTextureView.getBitmap();
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void initializePreview() {
        Preconditions.checkNotNull(this.mParent);
        Preconditions.checkNotNull(this.mResolution);
        TextureView textureView = new TextureView(this.mParent.getContext());
        this.mTextureView = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(this.mResolution.getWidth(), this.mResolution.getHeight()));
        this.mTextureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: androidx.camera.view.TextureViewImplementation.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surfaceTexture, int i2, int i3) {
                Logger.d(TextureViewImplementation.TAG, "SurfaceTexture available. Size: " + i2 + "x" + i3);
                TextureViewImplementation textureViewImplementation = TextureViewImplementation.this;
                textureViewImplementation.mSurfaceTexture = surfaceTexture;
                if (textureViewImplementation.mSurfaceReleaseFuture != null) {
                    Preconditions.checkNotNull(textureViewImplementation.mSurfaceRequest);
                    Logger.d(TextureViewImplementation.TAG, "Surface invalidated " + TextureViewImplementation.this.mSurfaceRequest);
                    TextureViewImplementation.this.mSurfaceRequest.getDeferrableSurface().close();
                    return;
                }
                textureViewImplementation.tryToProvidePreviewSurface();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(@NonNull final SurfaceTexture surfaceTexture) {
                TextureViewImplementation textureViewImplementation = TextureViewImplementation.this;
                textureViewImplementation.mSurfaceTexture = null;
                a<SurfaceRequest.Result> aVar = textureViewImplementation.mSurfaceReleaseFuture;
                if (aVar != null) {
                    Futures.addCallback(aVar, new FutureCallback<SurfaceRequest.Result>() { // from class: androidx.camera.view.TextureViewImplementation.1.1
                        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                        public void onFailure(Throwable th) {
                            throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th);
                        }

                        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                        public void onSuccess(SurfaceRequest.Result result) {
                            Preconditions.checkState(result.getResultCode() != 3, "Unexpected result from SurfaceRequest. Surface was provided twice.");
                            Logger.d(TextureViewImplementation.TAG, "SurfaceTexture about to manually be destroyed");
                            surfaceTexture.release();
                            TextureViewImplementation textureViewImplementation2 = TextureViewImplementation.this;
                            if (textureViewImplementation2.mDetachedSurfaceTexture != null) {
                                textureViewImplementation2.mDetachedSurfaceTexture = null;
                            }
                        }
                    }, ContextCompat.getMainExecutor(TextureViewImplementation.this.mTextureView.getContext()));
                    TextureViewImplementation.this.mDetachedSurfaceTexture = surfaceTexture;
                    return false;
                }
                Logger.d(TextureViewImplementation.TAG, "SurfaceTexture about to be destroyed");
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i2, int i3) {
                Logger.d(TextureViewImplementation.TAG, "SurfaceTexture size changed: " + i2 + "x" + i3);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {
                CallbackToFutureAdapter.Completer<Void> andSet = TextureViewImplementation.this.mNextFrameCompleter.getAndSet(null);
                if (andSet != null) {
                    andSet.set(null);
                }
            }
        });
        this.mParent.removeAllViews();
        this.mParent.addView(this.mTextureView);
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void onAttachedToWindow() {
        reattachSurfaceTexture();
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void onDetachedFromWindow() {
        this.mIsSurfaceTextureDetachedFromView = true;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void onSurfaceRequested(@NonNull final SurfaceRequest surfaceRequest, @Nullable PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener) {
        this.mResolution = surfaceRequest.getResolution();
        this.mOnSurfaceNotInUseListener = onSurfaceNotInUseListener;
        initializePreview();
        SurfaceRequest surfaceRequest2 = this.mSurfaceRequest;
        if (surfaceRequest2 != null) {
            surfaceRequest2.willNotProvideSurface();
        }
        this.mSurfaceRequest = surfaceRequest;
        surfaceRequest.addRequestCancellationListener(ContextCompat.getMainExecutor(this.mTextureView.getContext()), new Runnable() { // from class: c.b.d.r
            {
                TextureViewImplementation.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TextureViewImplementation.this.b(surfaceRequest);
            }
        });
        tryToProvidePreviewSurface();
    }

    public void tryToProvidePreviewSurface() {
        SurfaceTexture surfaceTexture;
        Size size = this.mResolution;
        if (size == null || (surfaceTexture = this.mSurfaceTexture) == null || this.mSurfaceRequest == null) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(size.getWidth(), this.mResolution.getHeight());
        final Surface surface = new Surface(this.mSurfaceTexture);
        final SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        final a<SurfaceRequest.Result> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.d.t
            {
                TextureViewImplementation.this = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return TextureViewImplementation.this.d(surface, completer);
            }
        });
        this.mSurfaceReleaseFuture = future;
        future.addListener(new Runnable() { // from class: c.b.d.s
            {
                TextureViewImplementation.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TextureViewImplementation.this.f(surface, future, surfaceRequest);
            }
        }, ContextCompat.getMainExecutor(this.mTextureView.getContext()));
        onSurfaceProvided();
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    @NonNull
    public a<Void> waitForNextFrame() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.d.q
            {
                TextureViewImplementation.this = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return TextureViewImplementation.this.h(completer);
            }
        });
    }
}
