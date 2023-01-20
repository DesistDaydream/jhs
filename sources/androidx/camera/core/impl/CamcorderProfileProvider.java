package androidx.camera.core.impl;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CamcorderProfileProvider {
    public static final CamcorderProfileProvider EMPTY = new CamcorderProfileProvider() { // from class: androidx.camera.core.impl.CamcorderProfileProvider.1
        @Override // androidx.camera.core.impl.CamcorderProfileProvider
        @Nullable
        public CamcorderProfileProxy get(int i2) {
            return null;
        }

        @Override // androidx.camera.core.impl.CamcorderProfileProvider
        public boolean hasProfile(int i2) {
            return false;
        }
    };

    @Nullable
    CamcorderProfileProxy get(int i2);

    boolean hasProfile(int i2);
}
