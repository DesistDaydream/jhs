package e.j.a.c.s;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewOverlayApi14;

/* loaded from: classes2.dex */
public class o extends ViewOverlayApi14 implements q {
    public o(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    public static o b(ViewGroup viewGroup) {
        return (o) ViewOverlayApi14.a(viewGroup);
    }

    @Override // e.j.a.c.s.q
    public void add(@NonNull View view) {
        this.a.b(view);
    }

    @Override // e.j.a.c.s.q
    public void remove(@NonNull View view) {
        this.a.h(view);
    }
}
