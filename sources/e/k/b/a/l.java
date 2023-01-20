package e.k.b.a;

/* loaded from: classes2.dex */
public class l<TResult> {
    private final e.k.b.a.o.i<TResult> a = new e.k.b.a.o.i<>();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.a.B();
        }
    }

    public l() {
    }

    public l(b bVar) {
        bVar.b(new a());
    }

    public k<TResult> b() {
        return this.a;
    }

    public void c(Exception exc) {
        this.a.z(exc);
    }

    public void setResult(TResult tresult) {
        this.a.A(tresult);
    }
}
