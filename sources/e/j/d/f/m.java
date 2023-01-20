package e.j.d.f;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.Registrar;

/* loaded from: classes2.dex */
public final /* synthetic */ class m implements e.j.d.d.h {
    public static final e.j.d.d.h a = new m();

    private m() {
    }

    @Override // e.j.d.d.h
    public final Object a(e.j.d.d.f fVar) {
        return new Registrar.a((FirebaseInstanceId) fVar.a(FirebaseInstanceId.class));
    }
}
