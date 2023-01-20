package e.b.a.t.k;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public interface p<R> extends e.b.a.q.m {
    public static final int n0 = Integer.MIN_VALUE;

    @Nullable
    e.b.a.t.e getRequest();

    void getSize(@NonNull o oVar);

    void onLoadCleared(@Nullable Drawable drawable);

    void onLoadFailed(@Nullable Drawable drawable);

    void onLoadStarted(@Nullable Drawable drawable);

    void onResourceReady(@NonNull R r, @Nullable e.b.a.t.l.f<? super R> fVar);

    void removeCallback(@NonNull o oVar);

    void setRequest(@Nullable e.b.a.t.e eVar);
}
