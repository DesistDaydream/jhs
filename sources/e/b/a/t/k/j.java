package e.b.a.t.k;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.t.l.f;

/* loaded from: classes.dex */
public abstract class j<Z> extends r<ImageView, Z> implements f.a {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Animatable f9915j;

    public j(ImageView imageView) {
        super(imageView);
    }

    private void m(@Nullable Z z) {
        if (z instanceof Animatable) {
            Animatable animatable = (Animatable) z;
            this.f9915j = animatable;
            animatable.start();
            return;
        }
        this.f9915j = null;
    }

    private void o(@Nullable Z z) {
        n(z);
        m(z);
    }

    @Override // e.b.a.t.l.f.a
    public void a(Drawable drawable) {
        ((ImageView) this.b).setImageDrawable(drawable);
    }

    @Override // e.b.a.t.l.f.a
    @Nullable
    public Drawable c() {
        return ((ImageView) this.b).getDrawable();
    }

    public abstract void n(@Nullable Z z);

    @Override // e.b.a.t.k.r, e.b.a.t.k.b, e.b.a.t.k.p
    public void onLoadCleared(@Nullable Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.f9915j;
        if (animatable != null) {
            animatable.stop();
        }
        o(null);
        a(drawable);
    }

    @Override // e.b.a.t.k.b, e.b.a.t.k.p
    public void onLoadFailed(@Nullable Drawable drawable) {
        super.onLoadFailed(drawable);
        o(null);
        a(drawable);
    }

    @Override // e.b.a.t.k.r, e.b.a.t.k.b, e.b.a.t.k.p
    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        o(null);
        a(drawable);
    }

    @Override // e.b.a.t.k.p
    public void onResourceReady(@NonNull Z z, @Nullable e.b.a.t.l.f<? super Z> fVar) {
        if (fVar != null && fVar.a(z, this)) {
            m(z);
        } else {
            o(z);
        }
    }

    @Override // e.b.a.t.k.b, e.b.a.q.m
    public void onStart() {
        Animatable animatable = this.f9915j;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // e.b.a.t.k.b, e.b.a.q.m
    public void onStop() {
        Animatable animatable = this.f9915j;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Deprecated
    public j(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
