package e.j.a.c.s;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
/* loaded from: classes2.dex */
public class p implements q {
    private final ViewGroupOverlay a;

    public p(@NonNull ViewGroup viewGroup) {
        this.a = viewGroup.getOverlay();
    }

    @Override // e.j.a.c.s.s
    public void add(@NonNull Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // e.j.a.c.s.s
    public void remove(@NonNull Drawable drawable) {
        this.a.remove(drawable);
    }

    @Override // e.j.a.c.s.q
    public void add(@NonNull View view) {
        this.a.add(view);
    }

    @Override // e.j.a.c.s.q
    public void remove(@NonNull View view) {
        this.a.remove(view);
    }
}
