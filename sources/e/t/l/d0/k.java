package e.t.l.d0;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/vector/ext/view/WidthWrapper;", "", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "width", "", "getWidth", "()I", "setWidth", "(I)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class k {
    @k.e.a.d
    private final View a;

    public k(@k.e.a.d View view) {
        this.a = view;
    }

    public final int a() {
        return this.a.getLayoutParams().width;
    }

    public final void b(int i2) {
        this.a.getLayoutParams().width = i2;
        this.a.requestLayout();
    }
}
