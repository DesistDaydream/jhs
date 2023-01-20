package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface RequestProcessor {

    /* loaded from: classes.dex */
    public interface Callback {
        void onCaptureBufferLost(@NonNull Request request, long j2, int i2);

        void onCaptureCompleted(@NonNull Request request, @NonNull CameraCaptureResult cameraCaptureResult);

        void onCaptureFailed(@NonNull Request request, @NonNull CameraCaptureFailure cameraCaptureFailure);

        void onCaptureProgressed(@NonNull Request request, @NonNull CameraCaptureResult cameraCaptureResult);

        void onCaptureSequenceAborted(int i2);

        void onCaptureSequenceCompleted(int i2, long j2);

        void onCaptureStarted(@NonNull Request request, long j2, long j3);
    }

    /* loaded from: classes.dex */
    public interface Request {
        @NonNull
        Config getParameters();

        @NonNull
        List<Integer> getTargetOutputConfigIds();

        int getTemplateId();
    }

    void abortCaptures();

    int setRepeating(@NonNull Request request, @NonNull Callback callback);

    void stopRepeating();

    int submit(@NonNull Request request, @NonNull Callback callback);

    int submit(@NonNull List<Request> list, @NonNull Callback callback);
}
