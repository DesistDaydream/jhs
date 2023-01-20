package e.b.a.v;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.g;

/* loaded from: classes.dex */
public class g<T> implements g.b<T> {
    private final int[] a;

    public g(int i2, int i3) {
        this.a = new int[]{i2, i3};
    }

    @Override // e.b.a.g.b
    @Nullable
    public int[] a(@NonNull T t, int i2, int i3) {
        return this.a;
    }
}
