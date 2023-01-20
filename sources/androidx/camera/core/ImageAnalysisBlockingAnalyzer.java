package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ImageAnalysisBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    @Nullable
    public ImageProxy acquireImage(@NonNull ImageReaderProxy imageReaderProxy) {
        return imageReaderProxy.acquireNextImage();
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public void clearCache() {
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public void onValidImageAvailable(@NonNull final ImageProxy imageProxy) {
        Futures.addCallback(analyzeImage(imageProxy), new FutureCallback<Void>() { // from class: androidx.camera.core.ImageAnalysisBlockingAnalyzer.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                imageProxy.close();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void r1) {
            }
        }, CameraXExecutors.directExecutor());
    }
}
