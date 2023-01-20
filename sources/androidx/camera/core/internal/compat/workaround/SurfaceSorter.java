package androidx.camera.core.internal.compat.workaround;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Preview;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import androidx.camera.core.internal.compat.workaround.SurfaceSorter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public class SurfaceSorter {
    private static final int PRIORITY_MEDIA_CODEC_SURFACE = 2;
    private static final int PRIORITY_OTHERS = 1;
    private static final int PRIORITY_PREVIEW_SURFACE = 0;
    private final boolean mHasQuirk;

    public SurfaceSorter() {
        this.mHasQuirk = DeviceQuirks.get(SurfaceOrderQuirk.class) != null;
    }

    /* renamed from: a */
    public /* synthetic */ int b(DeferrableSurface deferrableSurface, DeferrableSurface deferrableSurface2) {
        return getSurfacePriority(deferrableSurface) - getSurfacePriority(deferrableSurface2);
    }

    private int getSurfacePriority(@NonNull DeferrableSurface deferrableSurface) {
        if (deferrableSurface.getContainerClass() == MediaCodec.class || deferrableSurface.getContainerClass() == VideoCapture.class) {
            return 2;
        }
        return deferrableSurface.getContainerClass() == Preview.class ? 0 : 1;
    }

    public void sort(@NonNull List<DeferrableSurface> list) {
        if (this.mHasQuirk) {
            Collections.sort(list, new Comparator() { // from class: c.b.b.c2.h.a.a
                {
                    SurfaceSorter.this = this;
                }

                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return SurfaceSorter.this.b((DeferrableSurface) obj, (DeferrableSurface) obj2);
                }
            });
        }
    }
}
