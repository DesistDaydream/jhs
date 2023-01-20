package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CaptureBundles {

    /* loaded from: classes.dex */
    public static final class CaptureBundleImpl implements CaptureBundle {
        public final List<CaptureStage> mCaptureStageList;

        public CaptureBundleImpl(List<CaptureStage> list) {
            if (list != null && !list.isEmpty()) {
                this.mCaptureStageList = Collections.unmodifiableList(new ArrayList(list));
                return;
            }
            throw new IllegalArgumentException("Cannot set an empty CaptureStage list.");
        }

        @Override // androidx.camera.core.impl.CaptureBundle
        public List<CaptureStage> getCaptureStages() {
            return this.mCaptureStageList;
        }
    }

    private CaptureBundles() {
    }

    @NonNull
    public static CaptureBundle createCaptureBundle(@NonNull CaptureStage... captureStageArr) {
        return new CaptureBundleImpl(Arrays.asList(captureStageArr));
    }

    @NonNull
    public static CaptureBundle singleDefaultCaptureBundle() {
        return createCaptureBundle(new CaptureStage.DefaultCaptureStage());
    }

    @NonNull
    public static CaptureBundle createCaptureBundle(@NonNull List<CaptureStage> list) {
        return new CaptureBundleImpl(list);
    }
}
