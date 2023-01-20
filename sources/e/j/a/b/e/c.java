package e.j.a.b.e;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes2.dex */
public final class c implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.InterfaceC0092a interfaceC0092a) throws DynamiteModule.LoadingException {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int b = interfaceC0092a.b(context, str);
        bVar.a = b;
        if (b != 0) {
            bVar.f2676c = -1;
        } else {
            int a = interfaceC0092a.a(context, str, true);
            bVar.b = a;
            if (a != 0) {
                bVar.f2676c = 1;
            }
        }
        return bVar;
    }
}
