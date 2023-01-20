package e.t.k.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.view.ViewCompat;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00072\b\b\u0001\u0010\u0012\u001a\u00020\u0010H\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/vector/design/ui/UIHost;", "", "hostView", "Landroid/view/View;", "getHostView", "()Landroid/view/View;", "flowOfAppBar", "", "flowOfData", "flowOfSetup", "initializeFlow", "setBackground", "background", "Landroid/graphics/drawable/Drawable;", "setBackgroundColor", "color", "", "setBackgroundResource", "resId", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface a {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: e.t.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0411a {
        public static void a(@d a aVar) {
        }

        public static void b(@d a aVar) {
        }

        public static void c(@d a aVar) {
        }

        public static void d(@d a aVar) {
            aVar.f();
            aVar.j();
            aVar.d();
        }

        public static void e(@d a aVar, @e Drawable drawable) {
            View l2 = aVar.l();
            if (l2 == null) {
                return;
            }
            ViewCompat.setBackground(l2, drawable);
        }

        public static void f(@d a aVar, @ColorInt int i2) {
            View l2 = aVar.l();
            if (l2 == null) {
                return;
            }
            l2.setBackgroundColor(i2);
        }

        public static void g(@d a aVar, @DrawableRes int i2) {
            View l2 = aVar.l();
            if (l2 == null) {
                return;
            }
            l2.setBackgroundResource(i2);
        }
    }

    void b(@ColorInt int i2);

    void d();

    void f();

    void g();

    void j();

    @e
    View l();

    void m(@DrawableRes int i2);

    void o(@e Drawable drawable);
}
