package e.j.d.f;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import e.j.d.e.d;

/* loaded from: classes2.dex */
public final /* synthetic */ class l implements e.j.d.d.h {
    public static final e.j.d.d.h a = new l();

    private l() {
    }

    @Override // e.j.d.d.h
    public final Object a(e.j.d.d.f fVar) {
        return new FirebaseInstanceId((FirebaseApp) fVar.a(FirebaseApp.class), (d) fVar.a(d.class), (e.j.d.j.g) fVar.a(e.j.d.j.g.class));
    }
}
