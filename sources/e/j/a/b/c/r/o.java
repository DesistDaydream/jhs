package e.j.a.b.c.r;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import e.j.a.b.c.n.a;

/* loaded from: classes2.dex */
public class o {
    private final SparseIntArray a;
    private e.j.a.b.c.f b;

    public o() {
        this(e.j.a.b.c.e.v());
    }

    public void a() {
        this.a.clear();
    }

    public int b(@NonNull Context context, @NonNull a.f fVar) {
        a0.k(context);
        a0.k(fVar);
        int i2 = 0;
        if (fVar.i()) {
            int s = fVar.s();
            int i3 = this.a.get(s, -1);
            if (i3 != -1) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= this.a.size()) {
                    i2 = i3;
                    break;
                }
                int keyAt = this.a.keyAt(i4);
                if (keyAt > s && this.a.get(keyAt) == 0) {
                    break;
                }
                i4++;
            }
            if (i2 == -1) {
                i2 = this.b.k(context, s);
            }
            this.a.put(s, i2);
            return i2;
        }
        return 0;
    }

    public o(@NonNull e.j.a.b.c.f fVar) {
        this.a = new SparseIntArray();
        a0.k(fVar);
        this.b = fVar;
    }
}
