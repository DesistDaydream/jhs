package e.j.a.b.e;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes2.dex */
public final class g implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.InterfaceC0092a interfaceC0092a) throws DynamiteModule.LoadingException {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int b = interfaceC0092a.b(context, str);
        bVar.a = b;
        if (b != 0) {
            bVar.b = interfaceC0092a.a(context, str, false);
        } else {
            bVar.b = interfaceC0092a.a(context, str, true);
        }
        int i2 = bVar.a;
        if (i2 == 0 && bVar.b == 0) {
            bVar.f2676c = 0;
        } else if (bVar.b >= i2) {
            bVar.f2676c = 1;
        } else {
            bVar.f2676c = -1;
        }
        return bVar;
    }
}
