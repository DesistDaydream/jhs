package c.b.b.b2;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.Identifier;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements CameraFilter {
    public static final /* synthetic */ c a = new c();

    @Override // androidx.camera.core.CameraFilter
    public final List filter(List list) {
        List emptyList;
        emptyList = Collections.emptyList();
        return emptyList;
    }

    @Override // androidx.camera.core.CameraFilter
    public /* synthetic */ Identifier getIdentifier() {
        Identifier identifier;
        identifier = CameraFilter.DEFAULT_ID;
        return identifier;
    }
}
