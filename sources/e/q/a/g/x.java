package e.q.a.g;

import android.os.Build;
import android.provider.Settings;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/permissionx/guolindev/request/RequestSystemAlertWindowPermission;", "Lcom/permissionx/guolindev/request/BaseTask;", "permissionBuilder", "Lcom/permissionx/guolindev/request/PermissionBuilder;", "(Lcom/permissionx/guolindev/request/PermissionBuilder;)V", "request", "", "requestAgain", TTDelegateActivity.INTENT_PERMISSIONS, "", "", "permissionx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class x extends m {
    public x(@k.e.a.d r rVar) {
        super(rVar);
    }

    @Override // e.q.a.g.n
    public void request() {
        if (this.a.C()) {
            if (Build.VERSION.SDK_INT >= 23 && this.a.e() >= 23) {
                if (Settings.canDrawOverlays(this.a.getActivity())) {
                    finish();
                    return;
                }
                r rVar = this.a;
                if (rVar.r == null && rVar.s == null) {
                    finish();
                    return;
                }
                List<String> P = CollectionsKt__CollectionsKt.P("android.permission.SYSTEM_ALERT_WINDOW");
                r rVar2 = this.a;
                e.q.a.d.b bVar = rVar2.s;
                if (bVar != null) {
                    bVar.a(getExplainScope(), P, true);
                    return;
                } else {
                    rVar2.r.a(getExplainScope(), P);
                    return;
                }
            }
            this.a.f14424l.add("android.permission.SYSTEM_ALERT_WINDOW");
            this.a.f14420h.remove("android.permission.SYSTEM_ALERT_WINDOW");
            finish();
            return;
        }
        finish();
    }

    @Override // e.q.a.g.n
    public void requestAgain(@k.e.a.d List<String> list) {
        this.a.u(this);
    }
}
