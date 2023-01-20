package e.j.a.b.c.n.u;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public final class m2 implements e.j.a.b.j.c<Boolean, Void> {
    @Override // e.j.a.b.j.c
    public final /* synthetic */ Void a(@NonNull e.j.a.b.j.k<Boolean> kVar) throws Exception {
        if (kVar.r().booleanValue()) {
            return null;
        }
        throw new ApiException(new Status(13, "listener already unregistered"));
    }
}
