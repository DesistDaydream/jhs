package e.j.a.c.s;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
/* loaded from: classes2.dex */
public class r implements s {
    private final ViewOverlay a;

    public r(@NonNull View view) {
        this.a = view.getOverlay();
    }

    @Override // e.j.a.c.s.s
    public void add(@NonNull Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // e.j.a.c.s.s
    public void remove(@NonNull Drawable drawable) {
        this.a.remove(drawable);
    }
}
