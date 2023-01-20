package e.q.a.g;

import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import h.t1;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/permissionx/guolindev/request/BaseTask;", "Lcom/permissionx/guolindev/request/ChainTask;", "pb", "Lcom/permissionx/guolindev/request/PermissionBuilder;", "(Lcom/permissionx/guolindev/request/PermissionBuilder;)V", "explainReasonScope", "Lcom/permissionx/guolindev/request/ExplainScope;", "forwardToSettingsScope", "Lcom/permissionx/guolindev/request/ForwardScope;", "next", "finish", "", "getExplainScope", "getForwardScope", "permissionx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class m implements n {
    @h.k2.d
    @k.e.a.d
    public r a;
    @h.k2.d
    @k.e.a.e
    public n b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private o f14406c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private p f14407d;

    public m(@k.e.a.d r rVar) {
        this.a = rVar;
        this.f14406c = new o(rVar, this);
        this.f14407d = new p(this.a, this);
        this.f14406c = new o(this.a, this);
        this.f14407d = new p(this.a, this);
    }

    @Override // e.q.a.g.n
    public void finish() {
        t1 t1Var;
        int i2 = Build.VERSION.SDK_INT;
        n nVar = this.b;
        if (nVar == null) {
            t1Var = null;
        } else {
            nVar.request();
            t1Var = t1.a;
        }
        if (t1Var == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a.f14425m);
            arrayList.addAll(this.a.n);
            arrayList.addAll(this.a.f14423k);
            if (this.a.z()) {
                if (e.q.a.c.c(this.a.getActivity(), "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    this.a.f14424l.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                } else {
                    arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                }
            }
            if (this.a.C() && i2 >= 23 && this.a.e() >= 23) {
                if (Settings.canDrawOverlays(this.a.getActivity())) {
                    this.a.f14424l.add("android.permission.SYSTEM_ALERT_WINDOW");
                } else {
                    arrayList.add("android.permission.SYSTEM_ALERT_WINDOW");
                }
            }
            if (this.a.D() && i2 >= 23 && this.a.e() >= 23) {
                if (Settings.System.canWrite(this.a.getActivity())) {
                    this.a.f14424l.add("android.permission.WRITE_SETTINGS");
                } else {
                    arrayList.add("android.permission.WRITE_SETTINGS");
                }
            }
            if (this.a.B()) {
                if (i2 >= 30 && Environment.isExternalStorageManager()) {
                    this.a.f14424l.add(v.f14431f);
                } else {
                    arrayList.add(v.f14431f);
                }
            }
            if (this.a.A()) {
                if (i2 >= 26 && this.a.e() >= 26) {
                    if (this.a.getActivity().getPackageManager().canRequestPackageInstalls()) {
                        this.a.f14424l.add(u.f14429f);
                    } else {
                        arrayList.add(u.f14429f);
                    }
                } else {
                    arrayList.add(u.f14429f);
                }
            }
            e.q.a.d.d dVar = this.a.q;
            if (dVar != null) {
                dVar.onResult(arrayList.isEmpty(), new ArrayList(this.a.f14424l), arrayList);
            }
            this.a.o();
            this.a.w();
        }
    }

    @Override // e.q.a.g.n
    @k.e.a.d
    public o getExplainScope() {
        return this.f14406c;
    }

    @Override // e.q.a.g.n
    @k.e.a.d
    public p getForwardScope() {
        return this.f14407d;
    }
}
