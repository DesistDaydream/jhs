package e.j.a.b.f.a;

import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public final class i extends Drawable.ConstantState {
    public int a;
    public int b;

    public i(i iVar) {
        if (iVar != null) {
            this.a = iVar.a;
            this.b = iVar.b;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new e(this);
    }
}
