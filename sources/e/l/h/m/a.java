package e.l.h.m;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH$J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/jihuanshe/base/viewpager/BaseTransformer;", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "()V", "isPagingEnabled", "", "()Z", "hideOffscreenPages", "onPostTransform", "", "page", "Landroid/view/View;", "position", "", "onPreTransform", "onTransform", "transformPage", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class a implements ViewPager.PageTransformer {
    public boolean a() {
        return true;
    }

    public boolean b() {
        return false;
    }

    public void c(@k.e.a.e View view, float f2) {
    }

    public void d(@k.e.a.d View view, float f2) {
        float width = view.getWidth();
        float f3 = 0.0f;
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationY(0.0f);
        view.setTranslationX(b() ? 0.0f : (-width) * f2);
        if (a()) {
            if (f2 > -1.0f && f2 < 1.0f) {
                f3 = 1.0f;
            }
            view.setAlpha(f3);
            view.setEnabled(false);
            return;
        }
        view.setEnabled(true);
        view.setAlpha(1.0f);
    }

    public abstract void e(@k.e.a.d View view, float f2);

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(@k.e.a.d View view, float f2) {
        d(view, f2);
        e(view, f2);
        c(view, f2);
    }
}
