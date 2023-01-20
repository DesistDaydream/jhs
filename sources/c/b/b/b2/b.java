package c.b.b.b2;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.CameraFilters;
import androidx.camera.core.impl.Identifier;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements CameraFilter {
    public static final /* synthetic */ b a = new b();

    @Override // androidx.camera.core.CameraFilter
    public final List filter(List list) {
        CameraFilters.a(list);
        return list;
    }

    @Override // androidx.camera.core.CameraFilter
    public /* synthetic */ Identifier getIdentifier() {
        Identifier identifier;
        identifier = CameraFilter.DEFAULT_ID;
        return identifier;
    }
}
