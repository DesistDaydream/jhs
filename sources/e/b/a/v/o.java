package e.b.a.v;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.g;
import java.util.Arrays;

/* loaded from: classes.dex */
public class o<T> implements g.b<T>, e.b.a.t.k.o {
    private int[] a;
    private a b;

    /* loaded from: classes.dex */
    public static final class a extends e.b.a.t.k.f<View, Object> {
        public a(@NonNull View view) {
            super(view);
        }

        @Override // e.b.a.t.k.f
        public void f(@Nullable Drawable drawable) {
        }

        @Override // e.b.a.t.k.p
        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        @Override // e.b.a.t.k.p
        public void onResourceReady(@NonNull Object obj, @Nullable e.b.a.t.l.f<? super Object> fVar) {
        }
    }

    public o() {
    }

    @Override // e.b.a.g.b
    @Nullable
    public int[] a(@NonNull T t, int i2, int i3) {
        int[] iArr = this.a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public void b(@NonNull View view) {
        if (this.a == null && this.b == null) {
            a aVar = new a(view);
            this.b = aVar;
            aVar.getSize(this);
        }
    }

    @Override // e.b.a.t.k.o
    public void e(int i2, int i3) {
        this.a = new int[]{i2, i3};
        this.b = null;
    }

    public o(@NonNull View view) {
        a aVar = new a(view);
        this.b = aVar;
        aVar.getSize(this);
    }
}
