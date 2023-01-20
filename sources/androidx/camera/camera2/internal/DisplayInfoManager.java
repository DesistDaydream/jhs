package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.util.Size;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.workaround.MaxPreviewSize;
import e.l.r.g0;

@RequiresApi(21)
/* loaded from: classes.dex */
public class DisplayInfoManager {
    private static volatile DisplayInfoManager sInstance;
    @NonNull
    private final DisplayManager mDisplayManager;
    private static final Size MAX_PREVIEW_SIZE = new Size(g0.b.f14278i, g0.b.f14277h);
    private static final Object INSTANCE_LOCK = new Object();
    private volatile Size mPreviewSize = null;
    private final MaxPreviewSize mMaxPreviewSize = new MaxPreviewSize();

    private DisplayInfoManager(@NonNull Context context) {
        this.mDisplayManager = (DisplayManager) context.getSystemService("display");
    }

    private Size calculatePreviewSize() {
        Size size;
        Point point = new Point();
        getMaxSizeDisplay().getRealSize(point);
        if (point.x > point.y) {
            size = new Size(point.x, point.y);
        } else {
            size = new Size(point.y, point.x);
        }
        int width = size.getWidth() * size.getHeight();
        Size size2 = MAX_PREVIEW_SIZE;
        if (width > size2.getWidth() * size2.getHeight()) {
            size = size2;
        }
        return this.mMaxPreviewSize.getMaxPreviewResolution(size);
    }

    @NonNull
    public static DisplayInfoManager getInstance(@NonNull Context context) {
        if (sInstance == null) {
            synchronized (INSTANCE_LOCK) {
                if (sInstance == null) {
                    sInstance = new DisplayInfoManager(context);
                }
            }
        }
        return sInstance;
    }

    @VisibleForTesting
    public static void releaseInstance() {
        sInstance = null;
    }

    @NonNull
    public Display getMaxSizeDisplay() {
        Display[] displays = this.mDisplayManager.getDisplays();
        if (displays.length == 1) {
            return displays[0];
        }
        Display display = null;
        int i2 = -1;
        for (Display display2 : displays) {
            if (display2.getState() != 1) {
                Point point = new Point();
                display2.getRealSize(point);
                int i3 = point.x;
                int i4 = point.y;
                if (i3 * i4 > i2) {
                    display = display2;
                    i2 = i3 * i4;
                }
            }
        }
        if (display != null) {
            return display;
        }
        throw new IllegalArgumentException("No display can be found from the input display manager!");
    }

    @NonNull
    public Size getPreviewSize() {
        if (this.mPreviewSize != null) {
            return this.mPreviewSize;
        }
        this.mPreviewSize = calculatePreviewSize();
        return this.mPreviewSize;
    }

    public void refresh() {
        this.mPreviewSize = calculatePreviewSize();
    }
}
