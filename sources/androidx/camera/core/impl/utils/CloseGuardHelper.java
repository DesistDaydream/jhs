package androidx.camera.core.impl.utils;

import android.os.Build;
import android.util.CloseGuard;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CloseGuardHelper {
    private final CloseGuardImpl mImpl;

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static final class CloseGuardApi30Impl implements CloseGuardImpl {
        private final CloseGuard mPlatformImpl = new CloseGuard();

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void close() {
            this.mPlatformImpl.close();
        }

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void open(@NonNull String str) {
            this.mPlatformImpl.open(str);
        }

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void warnIfOpen() {
            this.mPlatformImpl.warnIfOpen();
        }
    }

    /* loaded from: classes.dex */
    public interface CloseGuardImpl {
        void close();

        void open(@NonNull String str);

        void warnIfOpen();
    }

    /* loaded from: classes.dex */
    public static final class CloseGuardNoOpImpl implements CloseGuardImpl {
        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void close() {
        }

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void open(@NonNull String str) {
            Preconditions.checkNotNull(str, "CloseMethodName must not be null.");
        }

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void warnIfOpen() {
        }
    }

    private CloseGuardHelper(CloseGuardImpl closeGuardImpl) {
        this.mImpl = closeGuardImpl;
    }

    @NonNull
    public static CloseGuardHelper create() {
        if (Build.VERSION.SDK_INT >= 30) {
            return new CloseGuardHelper(new CloseGuardApi30Impl());
        }
        return new CloseGuardHelper(new CloseGuardNoOpImpl());
    }

    public void close() {
        this.mImpl.close();
    }

    public void open(@NonNull String str) {
        this.mImpl.open(str);
    }

    public void warnIfOpen() {
        this.mImpl.warnIfOpen();
    }
}
