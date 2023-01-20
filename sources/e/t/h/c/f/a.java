package e.t.h.c.f;

import android.view.Window;
import androidx.annotation.ColorInt;
import e.t.l.j;
import e.t.u.y;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/vector/compat/window/status/StatusBarOpt;", "", "adaptTextColorByBackground", "", "window", "Landroid/view/Window;", "bgColor", "", "flat", "setColor", "color", "setTextColorDark", "setTextColorLight", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface a {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: e.t.h.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0406a {
        public static void a(@d a aVar, @d Window window, @ColorInt int i2) {
            if (y.a(23)) {
                if (j.e(i2)) {
                    aVar.e(window);
                } else {
                    aVar.c(window);
                }
            }
        }

        public static void b(@d a aVar, @d Window window, @ColorInt int i2) {
            window.setStatusBarColor(i2);
        }
    }

    void a(@d Window window, @ColorInt int i2);

    void b(@d Window window);

    void c(@d Window window);

    void d(@d Window window, @ColorInt int i2);

    void e(@d Window window);
}
