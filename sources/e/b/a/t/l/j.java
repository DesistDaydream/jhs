package e.b.a.t.l;

import android.view.View;
import e.b.a.t.l.f;

/* loaded from: classes.dex */
public class j<R> implements f<R> {
    private final a a;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view);
    }

    public j(a aVar) {
        this.a = aVar;
    }

    @Override // e.b.a.t.l.f
    public boolean a(R r, f.a aVar) {
        if (aVar.b() != null) {
            this.a.a(aVar.b());
            return false;
        }
        return false;
    }
}
