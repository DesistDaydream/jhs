package e.q.a.g;

import com.bytedance.msdk.api.activity.TTDelegateActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/permissionx/guolindev/request/RequestNormalPermissions;", "Lcom/permissionx/guolindev/request/BaseTask;", "permissionBuilder", "Lcom/permissionx/guolindev/request/PermissionBuilder;", "(Lcom/permissionx/guolindev/request/PermissionBuilder;)V", "request", "", "requestAgain", TTDelegateActivity.INTENT_PERMISSIONS, "", "", "permissionx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class w extends m {
    public w(@k.e.a.d r rVar) {
        super(rVar);
    }

    @Override // e.q.a.g.n
    public void request() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.a.f14419g) {
            if (e.q.a.c.c(this.a.getActivity(), str)) {
                this.a.f14424l.add(str);
            } else {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            finish();
            return;
        }
        r rVar = this.a;
        if (rVar.f14421i && (rVar.r != null || rVar.s != null)) {
            rVar.f14421i = false;
            rVar.f14425m.addAll(arrayList);
            r rVar2 = this.a;
            e.q.a.d.b bVar = rVar2.s;
            if (bVar != null) {
                bVar.a(getExplainScope(), arrayList, true);
                return;
            } else {
                rVar2.r.a(getExplainScope(), arrayList);
                return;
            }
        }
        rVar.t(rVar.f14419g, this);
    }

    @Override // e.q.a.g.n
    public void requestAgain(@k.e.a.d List<String> list) {
        HashSet hashSet = new HashSet(this.a.f14424l);
        hashSet.addAll(list);
        if (!hashSet.isEmpty()) {
            this.a.t(hashSet, this);
        } else {
            finish();
        }
    }
}
