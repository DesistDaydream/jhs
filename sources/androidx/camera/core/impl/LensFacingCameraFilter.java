package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public class LensFacingCameraFilter implements CameraFilter {
    private int mLensFacing;

    public LensFacingCameraFilter(int i2) {
        this.mLensFacing = i2;
    }

    @Override // androidx.camera.core.CameraFilter
    @NonNull
    public List<CameraInfo> filter(@NonNull List<CameraInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (CameraInfo cameraInfo : list) {
            Preconditions.checkArgument(cameraInfo instanceof CameraInfoInternal, "The camera info doesn't contain internal implementation.");
            Integer lensFacing = ((CameraInfoInternal) cameraInfo).getLensFacing();
            if (lensFacing != null && lensFacing.intValue() == this.mLensFacing) {
                arrayList.add(cameraInfo);
            }
        }
        return arrayList;
    }

    @Override // androidx.camera.core.CameraFilter
    public /* synthetic */ Identifier getIdentifier() {
        Identifier identifier;
        identifier = CameraFilter.DEFAULT_ID;
        return identifier;
    }

    public int getLensFacing() {
        return this.mLensFacing;
    }
}
