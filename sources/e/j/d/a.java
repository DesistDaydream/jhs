package e.j.d;

import android.content.Context;
import com.google.firebase.FirebaseApp;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements e.j.d.g.a {
    private final FirebaseApp a;
    private final Context b;

    private a(FirebaseApp firebaseApp, Context context) {
        this.a = firebaseApp;
        this.b = context;
    }

    public static e.j.d.g.a a(FirebaseApp firebaseApp, Context context) {
        return new a(firebaseApp, context);
    }

    @Override // e.j.d.g.a
    public Object get() {
        return FirebaseApp.lambda$new$0(this.a, this.b);
    }
}
