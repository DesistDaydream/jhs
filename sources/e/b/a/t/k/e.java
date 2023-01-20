package e.b.a.t.k;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class e<T> implements p<T> {
    private final int height;
    @Nullable
    private e.b.a.t.e request;
    private final int width;

    public e() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // e.b.a.t.k.p
    @Nullable
    public final e.b.a.t.e getRequest() {
        return this.request;
    }

    @Override // e.b.a.t.k.p
    public final void getSize(@NonNull o oVar) {
        oVar.e(this.width, this.height);
    }

    @Override // e.b.a.q.m
    public void onDestroy() {
    }

    @Override // e.b.a.t.k.p
    public void onLoadFailed(@Nullable Drawable drawable) {
    }

    @Override // e.b.a.t.k.p
    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    @Override // e.b.a.q.m
    public void onStart() {
    }

    @Override // e.b.a.q.m
    public void onStop() {
    }

    @Override // e.b.a.t.k.p
    public final void removeCallback(@NonNull o oVar) {
    }

    @Override // e.b.a.t.k.p
    public final void setRequest(@Nullable e.b.a.t.e eVar) {
        this.request = eVar;
    }

    public e(int i2, int i3) {
        if (e.b.a.v.n.w(i2, i3)) {
            this.width = i2;
            this.height = i3;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i2 + " and height: " + i3);
    }
}
