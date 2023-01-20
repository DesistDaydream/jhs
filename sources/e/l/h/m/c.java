package e.l.h.m;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/jihuanshe/base/viewpager/LeftTransformer;", "Lcom/jihuanshe/base/viewpager/BaseTransformer;", "()V", "isPagingEnabled", "", "()Z", "onTransform", "", "page", "Landroid/view/View;", "position", "", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class c extends a {
    @k.e.a.d
    public static final c a = new c();

    private c() {
    }

    @Override // e.l.h.m.a
    public boolean b() {
        return true;
    }

    @Override // e.l.h.m.a
    public void e(@k.e.a.d View view, float f2) {
        view.setElevation(f2 < 0.0f ? 0.0f : 1.0f);
        view.setTranslationX(f2 <= 0.0f ? (-view.getWidth()) * f2 : 0.0f);
    }
}
