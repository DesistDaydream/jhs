package c.b.b.b2;

import androidx.camera.core.impl.UseCaseAttachState;

/* loaded from: classes.dex */
public final /* synthetic */ class t implements UseCaseAttachState.AttachStateFilter {
    public static final /* synthetic */ t a = new t();

    @Override // androidx.camera.core.impl.UseCaseAttachState.AttachStateFilter
    public final boolean filter(UseCaseAttachState.UseCaseAttachInfo useCaseAttachInfo) {
        boolean attached;
        attached = useCaseAttachInfo.getAttached();
        return attached;
    }
}
