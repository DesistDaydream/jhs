package androidx.core.view;

import android.view.ViewParent;
import h.k2.u.l;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public /* synthetic */ class ViewKt$ancestors$1 extends FunctionReferenceImpl implements l<ViewParent, ViewParent> {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    public ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    @Override // h.k2.u.l
    public final ViewParent invoke(@d ViewParent viewParent) {
        return viewParent.getParent();
    }
}
