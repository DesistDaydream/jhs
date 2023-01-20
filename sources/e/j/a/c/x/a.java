package e.j.a.c.x;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import e.j.a.c.z.j;
import e.j.a.c.z.o;
import e.j.a.c.z.s;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a extends Drawable implements s, TintAwareDrawable {
    private b a;

    @Override // android.graphics.drawable.Drawable
    @NonNull
    /* renamed from: a */
    public a mutate() {
        this.a = new b(this.a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.a;
        if (bVar.b) {
            bVar.a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.a.a.getOpacity();
    }

    @Override // e.j.a.c.z.s
    @NonNull
    public o getShapeAppearanceModel() {
        return this.a.a.getShapeAppearanceModel();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.a.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.a.a.setState(iArr)) {
            onStateChange = true;
        }
        boolean e2 = e.j.a.c.x.b.e(iArr);
        b bVar = this.a;
        if (bVar.b != e2) {
            bVar.b = e2;
            return true;
        }
        return onStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.a.a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.a.a.setColorFilter(colorFilter);
    }

    @Override // e.j.a.c.z.s
    public void setShapeAppearanceModel(@NonNull o oVar) {
        this.a.a.setShapeAppearanceModel(oVar);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i2) {
        this.a.a.setTint(i2);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.a.a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.a.a.setTintMode(mode);
    }

    public a(o oVar) {
        this(new b(new j(oVar)));
    }

    /* loaded from: classes2.dex */
    public static final class b extends Drawable.ConstantState {
        @NonNull
        public j a;
        public boolean b;

        public b(j jVar) {
            this.a = jVar;
            this.b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        /* renamed from: a */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(@NonNull b bVar) {
            this.a = (j) bVar.a.getConstantState().newDrawable();
            this.b = bVar.b;
        }
    }

    private a(b bVar) {
        this.a = bVar;
    }
}
