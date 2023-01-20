package androidx.camera.view;

import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewStreamStateObserver;
import androidx.camera.view.PreviewView;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class PreviewStreamStateObserver implements Observable.Observer<CameraInternal.State> {
    private static final String TAG = "StreamStateObserver";
    private final CameraInfoInternal mCameraInfoInternal;
    public a<Void> mFlowFuture;
    private boolean mHasStartedPreviewStreamFlow = false;
    @GuardedBy("this")
    private PreviewView.StreamState mPreviewStreamState;
    private final MutableLiveData<PreviewView.StreamState> mPreviewStreamStateLiveData;
    private final PreviewViewImplementation mPreviewViewImplementation;

    public PreviewStreamStateObserver(CameraInfoInternal cameraInfoInternal, MutableLiveData<PreviewView.StreamState> mutableLiveData, PreviewViewImplementation previewViewImplementation) {
        this.mCameraInfoInternal = cameraInfoInternal;
        this.mPreviewStreamStateLiveData = mutableLiveData;
        this.mPreviewViewImplementation = previewViewImplementation;
        synchronized (this) {
            this.mPreviewStreamState = mutableLiveData.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ a b(Void r1) throws Exception {
        return this.mPreviewViewImplementation.waitForNextFrame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ Void d(Void r1) {
        updatePreviewStreamState(PreviewView.StreamState.STREAMING);
        return null;
    }

    private void cancelFlow() {
        a<Void> aVar = this.mFlowFuture;
        if (aVar != null) {
            aVar.cancel(false);
            this.mFlowFuture = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ Object f(final CameraInfo cameraInfo, List list, final CallbackToFutureAdapter.Completer completer) throws Exception {
        CameraCaptureCallback cameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.view.PreviewStreamStateObserver.2
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                completer.set(null);
                ((CameraInfoInternal) cameraInfo).removeSessionCaptureCallback(this);
            }
        };
        list.add(cameraCaptureCallback);
        ((CameraInfoInternal) cameraInfo).addSessionCaptureCallback(CameraXExecutors.directExecutor(), cameraCaptureCallback);
        return "waitForCaptureResult";
    }

    @MainThread
    private void startPreviewStreamStateFlow(final CameraInfo cameraInfo) {
        updatePreviewStreamState(PreviewView.StreamState.IDLE);
        final ArrayList arrayList = new ArrayList();
        FutureChain transform = FutureChain.from(waitForCaptureResult(cameraInfo, arrayList)).transformAsync(new AsyncFunction() { // from class: c.b.d.h
            {
                PreviewStreamStateObserver.this = this;
            }

            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final e.j.c.a.a.a apply(Object obj) {
                return PreviewStreamStateObserver.this.b((Void) obj);
            }
        }, CameraXExecutors.directExecutor()).transform(new Function() { // from class: c.b.d.f
            {
                PreviewStreamStateObserver.this = this;
            }

            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PreviewStreamStateObserver.this.d((Void) obj);
            }
        }, CameraXExecutors.directExecutor());
        this.mFlowFuture = transform;
        Futures.addCallback(transform, new FutureCallback<Void>() { // from class: androidx.camera.view.PreviewStreamStateObserver.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                PreviewStreamStateObserver.this.mFlowFuture = null;
                if (arrayList.isEmpty()) {
                    return;
                }
                for (CameraCaptureCallback cameraCaptureCallback : arrayList) {
                    ((CameraInfoInternal) cameraInfo).removeSessionCaptureCallback(cameraCaptureCallback);
                }
                arrayList.clear();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r2) {
                PreviewStreamStateObserver.this.mFlowFuture = null;
            }
        }, CameraXExecutors.directExecutor());
    }

    private a<Void> waitForCaptureResult(final CameraInfo cameraInfo, final List<CameraCaptureCallback> list) {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.d.g
            {
                PreviewStreamStateObserver.this = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return PreviewStreamStateObserver.this.f(cameraInfo, list, completer);
            }
        });
    }

    public void clear() {
        cancelFlow();
    }

    @Override // androidx.camera.core.impl.Observable.Observer
    @MainThread
    public void onError(@NonNull Throwable th) {
        clear();
        updatePreviewStreamState(PreviewView.StreamState.IDLE);
    }

    public void updatePreviewStreamState(PreviewView.StreamState streamState) {
        synchronized (this) {
            if (this.mPreviewStreamState.equals(streamState)) {
                return;
            }
            this.mPreviewStreamState = streamState;
            Logger.d(TAG, "Update Preview stream state to " + streamState);
            this.mPreviewStreamStateLiveData.postValue(streamState);
        }
    }

    @Override // androidx.camera.core.impl.Observable.Observer
    @MainThread
    public void onNewData(@Nullable CameraInternal.State state) {
        if (state != CameraInternal.State.CLOSING && state != CameraInternal.State.CLOSED && state != CameraInternal.State.RELEASING && state != CameraInternal.State.RELEASED) {
            if ((state == CameraInternal.State.OPENING || state == CameraInternal.State.OPEN || state == CameraInternal.State.PENDING_OPEN) && !this.mHasStartedPreviewStreamFlow) {
                startPreviewStreamStateFlow(this.mCameraInfoInternal);
                this.mHasStartedPreviewStreamFlow = true;
                return;
            }
            return;
        }
        updatePreviewStreamState(PreviewView.StreamState.IDLE);
        if (this.mHasStartedPreviewStreamFlow) {
            this.mHasStartedPreviewStreamFlow = false;
            cancelFlow();
        }
    }
}
