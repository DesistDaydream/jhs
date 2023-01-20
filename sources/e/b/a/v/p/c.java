package e.b.a.v.p;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class c {
    private static final boolean a = false;

    /* loaded from: classes.dex */
    public static class b extends c {
        private volatile RuntimeException b;

        public b() {
            super();
        }

        @Override // e.b.a.v.p.c
        public void b(boolean z) {
            if (z) {
                this.b = new RuntimeException("Released");
            } else {
                this.b = null;
            }
        }

        @Override // e.b.a.v.p.c
        public void c() {
            if (this.b != null) {
                throw new IllegalStateException("Already released", this.b);
            }
        }
    }

    /* renamed from: e.b.a.v.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0327c extends c {
        private volatile boolean b;

        public C0327c() {
            super();
        }

        @Override // e.b.a.v.p.c
        public void b(boolean z) {
            this.b = z;
        }

        @Override // e.b.a.v.p.c
        public void c() {
            if (this.b) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    @NonNull
    public static c a() {
        return new C0327c();
    }

    public abstract void b(boolean z);

    public abstract void c();

    private c() {
    }
}
