package e.q.a.g;

import com.bytedance.msdk.api.activity.TTDelegateActivity;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ2\u0010\u0007\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/permissionx/guolindev/request/ExplainScope;", "", "pb", "Lcom/permissionx/guolindev/request/PermissionBuilder;", "chainTask", "Lcom/permissionx/guolindev/request/ChainTask;", "(Lcom/permissionx/guolindev/request/PermissionBuilder;Lcom/permissionx/guolindev/request/ChainTask;)V", "showRequestReasonDialog", "", "dialog", "Lcom/permissionx/guolindev/dialog/RationaleDialog;", "dialogFragment", "Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;", TTDelegateActivity.INTENT_PERMISSIONS, "", "", "message", "positiveText", "negativeText", "permissionx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class o {
    @k.e.a.d
    private final r a;
    @k.e.a.d
    private final n b;

    public o(@k.e.a.d r rVar, @k.e.a.d n nVar) {
        this.a = rVar;
        this.b = nVar;
    }

    public static /* synthetic */ void e(o oVar, List list, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        oVar.d(list, str, str2, str3);
    }

    public final void a(@k.e.a.d e.q.a.f.c cVar) {
        this.a.E(this.b, true, cVar);
    }

    public final void b(@k.e.a.d e.q.a.f.d dVar) {
        this.a.F(this.b, true, dVar);
    }

    @h.k2.h
    public final void c(@k.e.a.d List<String> list, @k.e.a.d String str, @k.e.a.d String str2) {
        e(this, list, str, str2, null, 8, null);
    }

    @h.k2.h
    public final void d(@k.e.a.d List<String> list, @k.e.a.d String str, @k.e.a.d String str2, @k.e.a.e String str3) {
        this.a.G(this.b, true, list, str, str2, str3);
    }
}
