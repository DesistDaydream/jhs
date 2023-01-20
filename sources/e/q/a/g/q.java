package e.q.a.g;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import h.k2.v.f0;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u001c\u0010\u001c\u001a\u00020\u00162\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00140\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\u0016\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0012J\u0016\u0010$\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0012J\u0016\u0010%\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0012J$\u0010&\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0(2\u0006\u0010#\u001a\u00020\u0012J\u0016\u0010)\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0012J\u0016\u0010*\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0012R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\n0\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R:\u0010\r\u001a.\u0012*\u0012(\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\n0\n \u0006*\u0014\u0012\u000e\b\u0001\u0012\n \u0006*\u0004\u0018\u00010\n0\n\u0018\u00010\u000e0\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/permissionx/guolindev/request/InvisibleFragment;", "Landroidx/fragment/app/Fragment;", "()V", "forwardToSettingsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "pb", "Lcom/permissionx/guolindev/request/PermissionBuilder;", "requestBackgroundLocationLauncher", "", "requestInstallPackagesLauncher", "requestManageExternalStorageLauncher", "requestNormalPermissionLauncher", "", "requestSystemAlertWindowLauncher", "requestWriteSettingsLauncher", "task", "Lcom/permissionx/guolindev/request/ChainTask;", "checkForGC", "", "forwardToSettings", "", "onDestroy", "onRequestBackgroundLocationPermissionResult", "granted", "onRequestInstallPackagesPermissionResult", "onRequestManageExternalStoragePermissionResult", "onRequestNormalPermissionsResult", "grantResults", "", "onRequestSystemAlertWindowPermissionResult", "onRequestWriteSettingsPermissionResult", "requestAccessBackgroundLocationNow", "permissionBuilder", "chainTask", "requestInstallPackagesPermissionNow", "requestManageExternalStoragePermissionNow", "requestNow", TTDelegateActivity.INTENT_PERMISSIONS, "", "requestSystemAlertWindowPermissionNow", "requestWriteSettingsPermissionNow", "permissionx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class q extends Fragment {
    private r a;
    private n b;
    @k.e.a.d

    /* renamed from: c */
    private final ActivityResultLauncher<String[]> f14408c = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: e.q.a.g.b
        {
            q.this = this;
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            q.L(q.this, (Map) obj);
        }
    });
    @k.e.a.d

    /* renamed from: d */
    private final ActivityResultLauncher<String> f14409d = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: e.q.a.g.g
        {
            q.this = this;
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            q.G(q.this, (Boolean) obj);
        }
    });
    @k.e.a.d

    /* renamed from: e */
    private final ActivityResultLauncher<Intent> f14410e = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.q.a.g.d
        {
            q.this = this;
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            q.N(q.this, (ActivityResult) obj);
        }
    });
    @k.e.a.d

    /* renamed from: f */
    private final ActivityResultLauncher<Intent> f14411f = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.q.a.g.c
        {
            q.this = this;
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            q.P(q.this, (ActivityResult) obj);
        }
    });
    @k.e.a.d

    /* renamed from: g */
    private final ActivityResultLauncher<Intent> f14412g = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.q.a.g.e
        {
            q.this = this;
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            q.J(q.this, (ActivityResult) obj);
        }
    });
    @k.e.a.d

    /* renamed from: h */
    private final ActivityResultLauncher<Intent> f14413h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.q.a.g.f
        {
            q.this = this;
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            q.H(q.this, (ActivityResult) obj);
        }
    });
    @k.e.a.d

    /* renamed from: i */
    private final ActivityResultLauncher<Intent> f14414i = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.q.a.g.a
        {
            q.this = this;
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            q.r(q.this, (ActivityResult) obj);
        }
    });

    private final void A() {
        if (p()) {
            if (Build.VERSION.SDK_INT >= 26) {
                if (requireActivity().getPackageManager().canRequestPackageInstalls()) {
                    n nVar = this.b;
                    (nVar != null ? nVar : null).finish();
                    return;
                }
                r rVar = this.a;
                if (rVar == null) {
                    rVar = null;
                }
                if (rVar.r == null) {
                    r rVar2 = this.a;
                    if (rVar2 == null) {
                        rVar2 = null;
                    }
                    if (rVar2.s == null) {
                        return;
                    }
                }
                r rVar3 = this.a;
                if (rVar3 == null) {
                    rVar3 = null;
                }
                if (rVar3.s != null) {
                    r rVar4 = this.a;
                    if (rVar4 == null) {
                        rVar4 = null;
                    }
                    e.q.a.d.b bVar = rVar4.s;
                    n nVar2 = this.b;
                    bVar.a((nVar2 != null ? nVar2 : null).getExplainScope(), h.a2.t.k(u.f14429f), false);
                    return;
                }
                r rVar5 = this.a;
                if (rVar5 == null) {
                    rVar5 = null;
                }
                e.q.a.d.a aVar = rVar5.r;
                n nVar3 = this.b;
                aVar.a((nVar3 != null ? nVar3 : null).getExplainScope(), h.a2.t.k(u.f14429f));
                return;
            }
            n nVar4 = this.b;
            (nVar4 != null ? nVar4 : null).finish();
        }
    }

    private final void B() {
        if (p()) {
            if (Build.VERSION.SDK_INT >= 30) {
                if (Environment.isExternalStorageManager()) {
                    n nVar = this.b;
                    (nVar != null ? nVar : null).finish();
                    return;
                }
                r rVar = this.a;
                if (rVar == null) {
                    rVar = null;
                }
                if (rVar.r == null) {
                    r rVar2 = this.a;
                    if (rVar2 == null) {
                        rVar2 = null;
                    }
                    if (rVar2.s == null) {
                        return;
                    }
                }
                r rVar3 = this.a;
                if (rVar3 == null) {
                    rVar3 = null;
                }
                if (rVar3.s != null) {
                    r rVar4 = this.a;
                    if (rVar4 == null) {
                        rVar4 = null;
                    }
                    e.q.a.d.b bVar = rVar4.s;
                    n nVar2 = this.b;
                    bVar.a((nVar2 != null ? nVar2 : null).getExplainScope(), h.a2.t.k(v.f14431f), false);
                    return;
                }
                r rVar5 = this.a;
                if (rVar5 == null) {
                    rVar5 = null;
                }
                e.q.a.d.a aVar = rVar5.r;
                n nVar3 = this.b;
                aVar.a((nVar3 != null ? nVar3 : null).getExplainScope(), h.a2.t.k(v.f14431f));
                return;
            }
            n nVar4 = this.b;
            (nVar4 != null ? nVar4 : null).finish();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:246:0x010e, code lost:
        if (r7.s != null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0187, code lost:
        if ((!r7.o.isEmpty()) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x01bc, code lost:
        if (r7.f14422j == false) goto L129;
     */
    /* JADX WARN: Removed duplicated region for block: B:305:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x01cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void C(java.util.Map<java.lang.String, java.lang.Boolean> r7) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.q.a.g.q.C(java.util.Map):void");
    }

    private final void D() {
        if (p()) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    n nVar = this.b;
                    (nVar != null ? nVar : null).finish();
                    return;
                }
                r rVar = this.a;
                if (rVar == null) {
                    rVar = null;
                }
                if (rVar.r == null) {
                    r rVar2 = this.a;
                    if (rVar2 == null) {
                        rVar2 = null;
                    }
                    if (rVar2.s == null) {
                        return;
                    }
                }
                r rVar3 = this.a;
                if (rVar3 == null) {
                    rVar3 = null;
                }
                if (rVar3.s != null) {
                    r rVar4 = this.a;
                    if (rVar4 == null) {
                        rVar4 = null;
                    }
                    e.q.a.d.b bVar = rVar4.s;
                    n nVar2 = this.b;
                    bVar.a((nVar2 != null ? nVar2 : null).getExplainScope(), h.a2.t.k("android.permission.SYSTEM_ALERT_WINDOW"), false);
                    return;
                }
                r rVar5 = this.a;
                if (rVar5 == null) {
                    rVar5 = null;
                }
                e.q.a.d.a aVar = rVar5.r;
                n nVar3 = this.b;
                aVar.a((nVar3 != null ? nVar3 : null).getExplainScope(), h.a2.t.k("android.permission.SYSTEM_ALERT_WINDOW"));
                return;
            }
            n nVar4 = this.b;
            (nVar4 != null ? nVar4 : null).finish();
        }
    }

    private final void E() {
        if (p()) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.System.canWrite(getContext())) {
                    n nVar = this.b;
                    (nVar != null ? nVar : null).finish();
                    return;
                }
                r rVar = this.a;
                if (rVar == null) {
                    rVar = null;
                }
                if (rVar.r == null) {
                    r rVar2 = this.a;
                    if (rVar2 == null) {
                        rVar2 = null;
                    }
                    if (rVar2.s == null) {
                        return;
                    }
                }
                r rVar3 = this.a;
                if (rVar3 == null) {
                    rVar3 = null;
                }
                if (rVar3.s != null) {
                    r rVar4 = this.a;
                    if (rVar4 == null) {
                        rVar4 = null;
                    }
                    e.q.a.d.b bVar = rVar4.s;
                    n nVar2 = this.b;
                    bVar.a((nVar2 != null ? nVar2 : null).getExplainScope(), h.a2.t.k("android.permission.WRITE_SETTINGS"), false);
                    return;
                }
                r rVar5 = this.a;
                if (rVar5 == null) {
                    rVar5 = null;
                }
                e.q.a.d.a aVar = rVar5.r;
                n nVar3 = this.b;
                aVar.a((nVar3 != null ? nVar3 : null).getExplainScope(), h.a2.t.k("android.permission.WRITE_SETTINGS"));
                return;
            }
            n nVar4 = this.b;
            (nVar4 != null ? nVar4 : null).finish();
        }
    }

    public static final void G(q qVar, Boolean bool) {
        qVar.z(bool.booleanValue());
    }

    public static final void H(q qVar, ActivityResult activityResult) {
        qVar.A();
    }

    public static final void J(q qVar, ActivityResult activityResult) {
        qVar.B();
    }

    public static final void L(q qVar, Map map) {
        qVar.C(map);
    }

    public static final void N(q qVar, ActivityResult activityResult) {
        qVar.D();
    }

    public static final void P(q qVar, ActivityResult activityResult) {
        qVar.E();
    }

    private final boolean p() {
        if (this.a == null || this.b == null) {
            Log.w("PermissionX", "PermissionBuilder and ChainTask should not be null at this time, so we can do nothing in this case.");
            return false;
        }
        return true;
    }

    public static final void r(q qVar, ActivityResult activityResult) {
        if (qVar.p()) {
            n nVar = qVar.b;
            if (nVar == null) {
                nVar = null;
            }
            r rVar = qVar.a;
            nVar.requestAgain(new ArrayList((rVar != null ? rVar : null).p));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x004a, code lost:
        if (r3.s != null) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void z(boolean r6) {
        /*
            r5 = this;
            boolean r0 = r5.p()
            if (r0 == 0) goto Lc3
            java.lang.String r0 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            r1 = 0
            if (r6 == 0) goto L34
            e.q.a.g.r r6 = r5.a
            if (r6 != 0) goto L10
            r6 = r1
        L10:
            java.util.Set<java.lang.String> r6 = r6.f14424l
            r6.add(r0)
            e.q.a.g.r r6 = r5.a
            if (r6 != 0) goto L1a
            r6 = r1
        L1a:
            java.util.Set<java.lang.String> r6 = r6.f14425m
            r6.remove(r0)
            e.q.a.g.r r6 = r5.a
            if (r6 != 0) goto L24
            r6 = r1
        L24:
            java.util.Set<java.lang.String> r6 = r6.n
            r6.remove(r0)
            e.q.a.g.n r6 = r5.b
            if (r6 != 0) goto L2e
            goto L2f
        L2e:
            r1 = r6
        L2f:
            r1.finish()
            goto Lc3
        L34:
            r6 = 1
            boolean r2 = r5.shouldShowRequestPermissionRationale(r0)
            e.q.a.g.r r3 = r5.a
            if (r3 != 0) goto L3e
            r3 = r1
        L3e:
            e.q.a.d.a r3 = r3.r
            r4 = 0
            if (r3 != 0) goto L4c
            e.q.a.g.r r3 = r5.a
            if (r3 != 0) goto L48
            r3 = r1
        L48:
            e.q.a.d.b r3 = r3.s
            if (r3 == 0) goto L88
        L4c:
            if (r2 == 0) goto L88
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r6.add(r0)
            e.q.a.g.r r0 = r5.a
            if (r0 != 0) goto L5b
            r0 = r1
        L5b:
            e.q.a.d.b r0 = r0.s
            if (r0 == 0) goto L73
            e.q.a.g.r r0 = r5.a
            if (r0 != 0) goto L64
            r0 = r1
        L64:
            e.q.a.d.b r0 = r0.s
            e.q.a.g.n r2 = r5.b
            if (r2 != 0) goto L6b
            r2 = r1
        L6b:
            e.q.a.g.o r2 = r2.getExplainScope()
            r0.a(r2, r6, r4)
            goto L86
        L73:
            e.q.a.g.r r0 = r5.a
            if (r0 != 0) goto L78
            r0 = r1
        L78:
            e.q.a.d.a r0 = r0.r
            e.q.a.g.n r2 = r5.b
            if (r2 != 0) goto L7f
            r2 = r1
        L7f:
            e.q.a.g.o r2 = r2.getExplainScope()
            r0.a(r2, r6)
        L86:
            r6 = 0
            goto Laf
        L88:
            e.q.a.g.r r3 = r5.a
            if (r3 != 0) goto L8d
            r3 = r1
        L8d:
            e.q.a.d.c r3 = r3.t
            if (r3 == 0) goto Laf
            if (r2 != 0) goto Laf
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r6.add(r0)
            e.q.a.g.r r0 = r5.a
            if (r0 != 0) goto La0
            r0 = r1
        La0:
            e.q.a.d.c r0 = r0.t
            e.q.a.g.n r2 = r5.b
            if (r2 != 0) goto La7
            r2 = r1
        La7:
            e.q.a.g.p r2 = r2.getForwardScope()
            r0.a(r2, r6)
            goto L86
        Laf:
            if (r6 != 0) goto Lba
            e.q.a.g.r r6 = r5.a
            if (r6 != 0) goto Lb6
            r6 = r1
        Lb6:
            boolean r6 = r6.f14422j
            if (r6 != 0) goto Lc3
        Lba:
            e.q.a.g.n r6 = r5.b
            if (r6 != 0) goto Lbf
            goto Lc0
        Lbf:
            r1 = r6
        Lc0:
            r1.finish()
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.q.a.g.q.z(boolean):void");
    }

    public final void F(@k.e.a.d r rVar, @k.e.a.d n nVar) {
        this.a = rVar;
        this.b = nVar;
        this.f14409d.launch("android.permission.ACCESS_BACKGROUND_LOCATION");
    }

    public final void I(@k.e.a.d r rVar, @k.e.a.d n nVar) {
        this.a = rVar;
        this.b = nVar;
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            intent.setData(Uri.parse(f0.C("package:", requireActivity().getPackageName())));
            this.f14413h.launch(intent);
            return;
        }
        A();
    }

    public final void K(@k.e.a.d r rVar, @k.e.a.d n nVar) {
        this.a = rVar;
        this.b = nVar;
        if (Build.VERSION.SDK_INT >= 30 && !Environment.isExternalStorageManager()) {
            this.f14412g.launch(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
            return;
        }
        B();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M(@k.e.a.d r rVar, @k.e.a.d Set<String> set, @k.e.a.d n nVar) {
        this.a = rVar;
        this.b = nVar;
        ActivityResultLauncher<String[]> activityResultLauncher = this.f14408c;
        Object[] array = set.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        activityResultLauncher.launch(array);
    }

    public final void O(@k.e.a.d r rVar, @k.e.a.d n nVar) {
        this.a = rVar;
        this.b = nVar;
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(getContext())) {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.parse(f0.C("package:", requireActivity().getPackageName())));
            this.f14410e.launch(intent);
            return;
        }
        D();
    }

    public final void Q(@k.e.a.d r rVar, @k.e.a.d n nVar) {
        this.a = rVar;
        this.b = nVar;
        if (Build.VERSION.SDK_INT >= 23 && !Settings.System.canWrite(getContext())) {
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse(f0.C("package:", requireActivity().getPackageName())));
            this.f14411f.launch(intent);
            return;
        }
        E();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (p()) {
            r rVar = this.a;
            if (rVar == null) {
                rVar = null;
            }
            Dialog dialog = rVar.f14418f;
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

    public final void q() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", requireActivity().getPackageName(), null));
        this.f14414i.launch(intent);
    }
}
