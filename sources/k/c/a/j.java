package k.c.a;

/* loaded from: classes4.dex */
public final class j {
    private i a;
    private i b;

    public synchronized void a(i iVar) {
        try {
            if (iVar != null) {
                i iVar2 = this.b;
                if (iVar2 != null) {
                    iVar2.f16276c = iVar;
                    this.b = iVar;
                } else if (this.a == null) {
                    this.b = iVar;
                    this.a = iVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized i b() {
        i iVar;
        iVar = this.a;
        if (iVar != null) {
            i iVar2 = iVar.f16276c;
            this.a = iVar2;
            if (iVar2 == null) {
                this.b = null;
            }
        }
        return iVar;
    }

    public synchronized i c(int i2) throws InterruptedException {
        if (this.a == null) {
            wait(i2);
        }
        return b();
    }
}
