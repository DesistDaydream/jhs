package e.b.a.t.k;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

@Deprecated
/* loaded from: classes.dex */
public abstract class b<Z> implements p<Z> {
    private e.b.a.t.e a;

    @Override // e.b.a.t.k.p
    @Nullable
    public e.b.a.t.e getRequest() {
        return this.a;
    }

    @Override // e.b.a.q.m
    public void onDestroy() {
    }

    @Override // e.b.a.t.k.p
    public void onLoadCleared(@Nullable Drawable drawable) {
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
    public void setRequest(@Nullable e.b.a.t.e eVar) {
        this.a = eVar;
    }
}
