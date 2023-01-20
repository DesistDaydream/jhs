package androidx.camera.view;

import android.content.Context;
import android.view.OrientationEventListener;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.view.RotationProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class RotationProvider {
    @NonNull
    @GuardedBy("mLock")
    @VisibleForTesting
    public final OrientationEventListener mOrientationListener;
    public final Object mLock = new Object();
    @NonNull
    @GuardedBy("mLock")
    public final Map<Listener, ListenerWrapper> mListeners = new HashMap();
    @VisibleForTesting
    public boolean mIgnoreCanDetectForTest = false;

    /* loaded from: classes.dex */
    public interface Listener {
        void onRotationChanged(int i2);
    }

    /* loaded from: classes.dex */
    public static class ListenerWrapper {
        private final AtomicBoolean mEnabled = new AtomicBoolean(true);
        private final Executor mExecutor;
        private final Listener mListener;

        public ListenerWrapper(Listener listener, Executor executor) {
            this.mListener = listener;
            this.mExecutor = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(int i2) {
            if (this.mEnabled.get()) {
                this.mListener.onRotationChanged(i2);
            }
        }

        public void disable() {
            this.mEnabled.set(false);
        }

        public void onRotationChanged(final int i2) {
            this.mExecutor.execute(new Runnable() { // from class: c.b.d.m
                @Override // java.lang.Runnable
                public final void run() {
                    RotationProvider.ListenerWrapper.this.b(i2);
                }
            });
        }
    }

    public RotationProvider(@NonNull Context context) {
        this.mOrientationListener = new OrientationEventListener(context) { // from class: androidx.camera.view.RotationProvider.1
            private static final int INVALID_SURFACE_ROTATION = -1;
            private int mRotation = -1;

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i2) {
                int orientationToSurfaceRotation;
                ArrayList<ListenerWrapper> arrayList;
                if (i2 == -1 || this.mRotation == (orientationToSurfaceRotation = RotationProvider.orientationToSurfaceRotation(i2))) {
                    return;
                }
                this.mRotation = orientationToSurfaceRotation;
                synchronized (RotationProvider.this.mLock) {
                    arrayList = new ArrayList(RotationProvider.this.mListeners.values());
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                for (ListenerWrapper listenerWrapper : arrayList) {
                    listenerWrapper.onRotationChanged(orientationToSurfaceRotation);
                }
            }
        };
    }

    @VisibleForTesting
    public static int orientationToSurfaceRotation(int i2) {
        if (i2 >= 315 || i2 < 45) {
            return 0;
        }
        if (i2 >= 225) {
            return 1;
        }
        return i2 >= 135 ? 2 : 3;
    }

    @CheckResult
    public boolean addListener(@NonNull Executor executor, @NonNull Listener listener) {
        synchronized (this.mLock) {
            if (this.mOrientationListener.canDetectOrientation() || this.mIgnoreCanDetectForTest) {
                this.mListeners.put(listener, new ListenerWrapper(listener, executor));
                this.mOrientationListener.enable();
                return true;
            }
            return false;
        }
    }

    public void removeListener(@NonNull Listener listener) {
        synchronized (this.mLock) {
            ListenerWrapper listenerWrapper = this.mListeners.get(listener);
            if (listenerWrapper != null) {
                listenerWrapper.disable();
                this.mListeners.remove(listener);
            }
            if (this.mListeners.isEmpty()) {
                this.mOrientationListener.disable();
            }
        }
    }
}
