package bykvm_19do.bykvm_19do.bykvm_19do;

/* loaded from: classes.dex */
public abstract class o0<T> {
    private volatile T a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = a(objArr);
                }
            }
        }
        return this.a;
    }
}
