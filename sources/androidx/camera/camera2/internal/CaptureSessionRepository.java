package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.CaptureSessionRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public class CaptureSessionRepository {
    @NonNull
    public final Executor mExecutor;
    public final Object mLock = new Object();
    @GuardedBy("mLock")
    public final Set<SynchronizedCaptureSession> mCaptureSessions = new LinkedHashSet();
    @GuardedBy("mLock")
    public final Set<SynchronizedCaptureSession> mClosingCaptureSession = new LinkedHashSet();
    @GuardedBy("mLock")
    public final Set<SynchronizedCaptureSession> mCreatingCaptureSessions = new LinkedHashSet();
    private final CameraDevice.StateCallback mCameraStateCallback = new AnonymousClass1();

    /* renamed from: androidx.camera.camera2.internal.CaptureSessionRepository$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends CameraDevice.StateCallback {
        public AnonymousClass1() {
            CaptureSessionRepository.this = r1;
        }

        public static /* synthetic */ void a(LinkedHashSet linkedHashSet) {
            CaptureSessionRepository.forceOnClosed(linkedHashSet);
        }

        private void cameraClosed() {
            List<SynchronizedCaptureSession> sessionsInOrder;
            synchronized (CaptureSessionRepository.this.mLock) {
                sessionsInOrder = CaptureSessionRepository.this.getSessionsInOrder();
                CaptureSessionRepository.this.mCreatingCaptureSessions.clear();
                CaptureSessionRepository.this.mCaptureSessions.clear();
                CaptureSessionRepository.this.mClosingCaptureSession.clear();
            }
            for (SynchronizedCaptureSession synchronizedCaptureSession : sessionsInOrder) {
                synchronizedCaptureSession.finishClose();
            }
        }

        private void forceOnClosedCaptureSessions() {
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            synchronized (CaptureSessionRepository.this.mLock) {
                linkedHashSet.addAll(CaptureSessionRepository.this.mCreatingCaptureSessions);
                linkedHashSet.addAll(CaptureSessionRepository.this.mCaptureSessions);
            }
            CaptureSessionRepository.this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.v0
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureSessionRepository.AnonymousClass1.a(linkedHashSet);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(@NonNull CameraDevice cameraDevice) {
            cameraClosed();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            forceOnClosedCaptureSessions();
            cameraClosed();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i2) {
            forceOnClosedCaptureSessions();
            cameraClosed();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
        }
    }

    public CaptureSessionRepository(@NonNull Executor executor) {
        this.mExecutor = executor;
    }

    private void forceFinishCloseStaleSessions(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        SynchronizedCaptureSession next;
        Iterator<SynchronizedCaptureSession> it = getSessionsInOrder().iterator();
        while (it.hasNext() && (next = it.next()) != synchronizedCaptureSession) {
            next.finishClose();
        }
    }

    public static void forceOnClosed(@NonNull Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : set) {
            synchronizedCaptureSession.getStateCallback().onClosed(synchronizedCaptureSession);
        }
    }

    @NonNull
    public CameraDevice.StateCallback getCameraStateCallback() {
        return this.mCameraStateCallback;
    }

    @NonNull
    public List<SynchronizedCaptureSession> getCaptureSessions() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mCaptureSessions);
        }
        return arrayList;
    }

    @NonNull
    public List<SynchronizedCaptureSession> getClosingCaptureSession() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mClosingCaptureSession);
        }
        return arrayList;
    }

    @NonNull
    public List<SynchronizedCaptureSession> getCreatingCaptureSessions() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mCreatingCaptureSessions);
        }
        return arrayList;
    }

    @NonNull
    public List<SynchronizedCaptureSession> getSessionsInOrder() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList();
            arrayList.addAll(getCaptureSessions());
            arrayList.addAll(getCreatingCaptureSessions());
        }
        return arrayList;
    }

    public void onCaptureSessionClosed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mCaptureSessions.remove(synchronizedCaptureSession);
            this.mClosingCaptureSession.remove(synchronizedCaptureSession);
        }
    }

    public void onCaptureSessionClosing(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mClosingCaptureSession.add(synchronizedCaptureSession);
        }
    }

    public void onCaptureSessionConfigureFail(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        forceFinishCloseStaleSessions(synchronizedCaptureSession);
        synchronized (this.mLock) {
            this.mCreatingCaptureSessions.remove(synchronizedCaptureSession);
        }
    }

    public void onCaptureSessionCreated(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mCaptureSessions.add(synchronizedCaptureSession);
            this.mCreatingCaptureSessions.remove(synchronizedCaptureSession);
        }
        forceFinishCloseStaleSessions(synchronizedCaptureSession);
    }

    public void onCreateCaptureSession(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mCreatingCaptureSessions.add(synchronizedCaptureSession);
        }
    }
}
