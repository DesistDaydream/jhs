package e.l.h.h.g.a;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* loaded from: classes2.dex */
public abstract class a {
    private final DataSetObservable a = new DataSetObservable();

    public abstract int a();

    public abstract int b();

    public abstract c c(Context context);

    public abstract d d(Context context, int i2);

    public float e(Context context, int i2) {
        return 1.0f;
    }

    public final void f() {
        this.a.notifyChanged();
    }

    public final void g() {
        this.a.notifyInvalidated();
    }

    public final void h(DataSetObserver dataSetObserver) {
        this.a.registerObserver(dataSetObserver);
    }

    public final void i(DataSetObserver dataSetObserver) {
        this.a.unregisterObserver(dataSetObserver);
    }
}
