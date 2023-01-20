package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class SurfaceCombination {
    private final List<SurfaceConfig> mSurfaceConfigList = new ArrayList();

    private static void generateArrangements(List<int[]> list, int i2, int[] iArr, int i3) {
        boolean z;
        if (i3 >= iArr.length) {
            list.add((int[]) iArr.clone());
            return;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = 0;
            while (true) {
                if (i5 >= i3) {
                    z = false;
                    break;
                } else if (i4 == iArr[i5]) {
                    z = true;
                    break;
                } else {
                    i5++;
                }
            }
            if (!z) {
                iArr[i3] = i4;
                generateArrangements(list, i2, iArr, i3 + 1);
            }
        }
    }

    private List<int[]> getElementsArrangements(int i2) {
        ArrayList arrayList = new ArrayList();
        generateArrangements(arrayList, i2, new int[i2], 0);
        return arrayList;
    }

    public boolean addSurfaceConfig(@NonNull SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.add(surfaceConfig);
    }

    @NonNull
    public List<SurfaceConfig> getSurfaceConfigList() {
        return this.mSurfaceConfigList;
    }

    public boolean isSupported(@NonNull List<SurfaceConfig> list) {
        if (list.isEmpty()) {
            return true;
        }
        if (list.size() > this.mSurfaceConfigList.size()) {
            return false;
        }
        for (int[] iArr : getElementsArrangements(this.mSurfaceConfigList.size())) {
            boolean z = true;
            for (int i2 = 0; i2 < this.mSurfaceConfigList.size() && (iArr[i2] >= list.size() || ((z = z & this.mSurfaceConfigList.get(i2).isSupported(list.get(iArr[i2]))))); i2++) {
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public boolean removeSurfaceConfig(@NonNull SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.remove(surfaceConfig);
    }
}
