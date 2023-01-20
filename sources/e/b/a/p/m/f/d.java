package e.b.a.p.m.f;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.p.k.s;

/* loaded from: classes.dex */
public final class d extends b<Drawable> {
    private d(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    public static s<Drawable> d(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new d(drawable);
        }
        return null;
    }

    @Override // e.b.a.p.k.s
    @NonNull
    public Class<Drawable> b() {
        return this.a.getClass();
    }

    @Override // e.b.a.p.k.s
    public int getSize() {
        return Math.max(1, this.a.getIntrinsicWidth() * this.a.getIntrinsicHeight() * 4);
    }

    @Override // e.b.a.p.k.s
    public void recycle() {
    }
}
