package k.c.a;

import android.os.Looper;

/* loaded from: classes4.dex */
public interface g {

    /* loaded from: classes4.dex */
    public static class a implements g {
        private final Looper a;

        public a(Looper looper) {
            this.a = looper;
        }

        @Override // k.c.a.g
        public k a(c cVar) {
            return new e(cVar, this.a, 10);
        }

        @Override // k.c.a.g
        public boolean b() {
            return this.a == Looper.myLooper();
        }
    }

    k a(c cVar);

    boolean b();
}
