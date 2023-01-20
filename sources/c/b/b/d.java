package c.b.b;

import androidx.camera.core.CameraExecutor;
import androidx.camera.core.Logger;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements RejectedExecutionHandler {
    public static final /* synthetic */ d a = new d();

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        Logger.e(CameraExecutor.TAG, "A rejected execution occurred in CameraExecutor!");
    }
}
