package e.q.a.g;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 W2\u00020\u0001:\u0001WB5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010\u0015\u001a\u00020\u0000J\u0016\u00102\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\b05H\u0002J\b\u00106\u001a\u000203H\u0003J\u0010\u00107\u001a\u00020\u00002\b\u00108\u001a\u0004\u0018\u00010\u0018J\u0010\u00107\u001a\u00020\u00002\b\u00108\u001a\u0004\u0018\u00010\u001aJ\u0010\u00109\u001a\u00020\u00002\b\u00108\u001a\u0004\u0018\u00010\u001dJ\r\u0010:\u001a\u000203H\u0000¢\u0006\u0002\b;J\u0010\u0010<\u001a\u0002032\b\u00108\u001a\u0004\u0018\u00010,J\u000e\u0010=\u001a\u0002032\u0006\u0010>\u001a\u00020?J\u000e\u0010@\u001a\u0002032\u0006\u0010>\u001a\u00020?J\u000e\u0010A\u001a\u0002032\u0006\u0010>\u001a\u00020?J\u001c\u0010B\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\b0C2\u0006\u0010>\u001a\u00020?J\u000e\u0010D\u001a\u0002032\u0006\u0010>\u001a\u00020?J\u000e\u0010E\u001a\u0002032\u0006\u0010>\u001a\u00020?J\r\u0010F\u001a\u000203H\u0000¢\u0006\u0002\bGJ\u0016\u0010H\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010I\u001a\u00020\u0016J\u0006\u0010J\u001a\u00020\u0016J\u0006\u0010K\u001a\u00020\u0016J\u0006\u0010L\u001a\u00020\u0016J\u0006\u0010M\u001a\u00020\u0016J\u001e\u0010N\u001a\u0002032\u0006\u0010>\u001a\u00020?2\u0006\u0010O\u001a\u00020\u00162\u0006\u0010P\u001a\u00020QJ\u001e\u0010N\u001a\u0002032\u0006\u0010>\u001a\u00020?2\u0006\u0010O\u001a\u00020\u00162\u0006\u0010R\u001a\u00020SJ>\u0010N\u001a\u0002032\u0006\u0010>\u001a\u00020?2\u0006\u0010O\u001a\u00020\u00162\f\u00104\u001a\b\u0012\u0004\u0012\u00020\b052\u0006\u0010T\u001a\u00020\b2\u0006\u0010U\u001a\u00020\b2\b\u0010V\u001a\u0004\u0018\u00010\bR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0018\u00101\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/permissionx/guolindev/request/PermissionBuilder;", "", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "normalPermissions", "", "", "specialPermissions", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;Ljava/util/Set;Ljava/util/Set;)V", "activity", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "currentDialog", "Landroid/app/Dialog;", "darkColor", "", "deniedPermissions", "explainReasonBeforeRequest", "", "explainReasonCallback", "Lcom/permissionx/guolindev/callback/ExplainReasonCallback;", "explainReasonCallbackWithBeforeParam", "Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;", "forwardPermissions", "forwardToSettingsCallback", "Lcom/permissionx/guolindev/callback/ForwardToSettingsCallback;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "grantedPermissions", "invisibleFragment", "Lcom/permissionx/guolindev/request/InvisibleFragment;", "getInvisibleFragment", "()Lcom/permissionx/guolindev/request/InvisibleFragment;", "lightColor", "originRequestOrientation", "permanentDeniedPermissions", "permissionsWontRequest", "requestCallback", "Lcom/permissionx/guolindev/callback/RequestCallback;", "showDialogCalled", "targetSdkVersion", "getTargetSdkVersion", "()I", "tempPermanentDeniedPermissions", "forwardToSettings", "", TTDelegateActivity.INTENT_PERMISSIONS, "", "lockOrientation", "onExplainRequestReason", "callback", "onForwardToSettings", "removeInvisibleFragment", "removeInvisibleFragment$permissionx_release", "request", "requestAccessBackgroundLocationNow", "chainTask", "Lcom/permissionx/guolindev/request/ChainTask;", "requestInstallPackagePermissionNow", "requestManageExternalStoragePermissionNow", "requestNow", "", "requestSystemAlertWindowPermissionNow", "requestWriteSettingsPermissionNow", "restoreOrientation", "restoreOrientation$permissionx_release", "setDialogTintColor", "shouldRequestBackgroundLocationPermission", "shouldRequestInstallPackagesPermission", "shouldRequestManageExternalStoragePermission", "shouldRequestSystemAlertWindowPermission", "shouldRequestWriteSettingsPermission", "showHandlePermissionDialog", "showReasonOrGoSettings", "dialog", "Lcom/permissionx/guolindev/dialog/RationaleDialog;", "dialogFragment", "Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;", "message", "positiveText", "negativeText", "Companion", "permissionx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class r {
    @k.e.a.d
    public static final a u = new a(null);
    @k.e.a.d
    private static final String v = "InvisibleFragment";
    public FragmentActivity a;
    @k.e.a.e
    private Fragment b;
    @h.k2.d
    @k.e.a.e

    /* renamed from: f */
    public Dialog f14418f;
    @h.k2.d
    @k.e.a.d

    /* renamed from: g */
    public Set<String> f14419g;
    @h.k2.d
    @k.e.a.d

    /* renamed from: h */
    public Set<String> f14420h;
    @h.k2.d

    /* renamed from: i */
    public boolean f14421i;
    @h.k2.d

    /* renamed from: j */
    public boolean f14422j;
    @h.k2.d
    @k.e.a.e
    public e.q.a.d.d q;
    @h.k2.d
    @k.e.a.e
    public e.q.a.d.a r;
    @h.k2.d
    @k.e.a.e
    public e.q.a.d.b s;
    @h.k2.d
    @k.e.a.e
    public e.q.a.d.c t;

    /* renamed from: c */
    private int f14415c = -1;

    /* renamed from: d */
    private int f14416d = -1;

    /* renamed from: e */
    private int f14417e = -1;
    @h.k2.d
    @k.e.a.d

    /* renamed from: k */
    public Set<String> f14423k = new LinkedHashSet();
    @h.k2.d
    @k.e.a.d

    /* renamed from: l */
    public Set<String> f14424l = new LinkedHashSet();
    @h.k2.d
    @k.e.a.d

    /* renamed from: m */
    public Set<String> f14425m = new LinkedHashSet();
    @h.k2.d
    @k.e.a.d
    public Set<String> n = new LinkedHashSet();
    @h.k2.d
    @k.e.a.d
    public Set<String> o = new LinkedHashSet();
    @h.k2.d
    @k.e.a.d
    public Set<String> p = new LinkedHashSet();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/permissionx/guolindev/request/PermissionBuilder$Companion;", "", "()V", "FRAGMENT_TAG", "", "permissionx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public r(@k.e.a.e FragmentActivity fragmentActivity, @k.e.a.e Fragment fragment, @k.e.a.d Set<String> set, @k.e.a.d Set<String> set2) {
        if (fragmentActivity != null) {
            x(fragmentActivity);
        }
        if (fragmentActivity == null && fragment != null) {
            x(fragment.requireActivity());
        }
        this.b = fragment;
        this.f14419g = set;
        this.f14420h = set2;
    }

    public static final void H(e.q.a.f.c cVar, boolean z, n nVar, List list, r rVar, View view) {
        cVar.dismiss();
        if (z) {
            nVar.requestAgain(list);
        } else {
            rVar.b(list);
        }
    }

    public static final void I(e.q.a.f.c cVar, n nVar, View view) {
        cVar.dismiss();
        nVar.finish();
    }

    public static final void J(r rVar, DialogInterface dialogInterface) {
        rVar.f14418f = null;
    }

    public static final void K(e.q.a.f.d dVar, boolean z, n nVar, List list, r rVar, View view) {
        dVar.dismiss();
        if (z) {
            nVar.requestAgain(list);
        } else {
            rVar.b(list);
        }
    }

    public static final void L(e.q.a.f.d dVar, n nVar, View view) {
        dVar.dismiss();
        nVar.finish();
    }

    private final void b(List<String> list) {
        this.p.clear();
        this.p.addAll(list);
        d().q();
    }

    private final FragmentManager c() {
        Fragment fragment = this.b;
        FragmentManager childFragmentManager = fragment == null ? null : fragment.getChildFragmentManager();
        return childFragmentManager == null ? getActivity().getSupportFragmentManager() : childFragmentManager;
    }

    private final q d() {
        Fragment findFragmentByTag = c().findFragmentByTag(v);
        if (findFragmentByTag != null) {
            return (q) findFragmentByTag;
        }
        q qVar = new q();
        c().beginTransaction().add(qVar, v).commitNowAllowingStateLoss();
        return qVar;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private final void k() {
        this.f14417e = getActivity().getRequestedOrientation();
        int i2 = getActivity().getResources().getConfiguration().orientation;
        if (i2 == 1) {
            getActivity().setRequestedOrientation(7);
        } else if (i2 != 2) {
        } else {
            getActivity().setRequestedOrientation(6);
        }
    }

    public final boolean A() {
        return this.f14420h.contains(u.f14429f);
    }

    public final boolean B() {
        return this.f14420h.contains(v.f14431f);
    }

    public final boolean C() {
        return this.f14420h.contains("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public final boolean D() {
        return this.f14420h.contains("android.permission.WRITE_SETTINGS");
    }

    public final void E(@k.e.a.d final n nVar, final boolean z, @k.e.a.d final e.q.a.f.c cVar) {
        this.f14422j = true;
        final List<String> b = cVar.b();
        if (b.isEmpty()) {
            nVar.finish();
            return;
        }
        this.f14418f = cVar;
        cVar.show();
        if ((cVar instanceof e.q.a.f.a) && ((e.q.a.f.a) cVar).f()) {
            cVar.dismiss();
            nVar.finish();
        }
        View c2 = cVar.c();
        View a2 = cVar.a();
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        c2.setClickable(true);
        c2.setOnClickListener(new View.OnClickListener() { // from class: e.q.a.g.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.H(cVar, z, nVar, b, this, view);
            }
        });
        if (a2 != null) {
            a2.setClickable(true);
            a2.setOnClickListener(new View.OnClickListener() { // from class: e.q.a.g.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.I(cVar, nVar, view);
                }
            });
        }
        Dialog dialog = this.f14418f;
        if (dialog == null) {
            return;
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: e.q.a.g.k
            {
                r.this = this;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                r.J(r.this, dialogInterface);
            }
        });
    }

    public final void F(@k.e.a.d final n nVar, final boolean z, @k.e.a.d final e.q.a.f.d dVar) {
        this.f14422j = true;
        final List<String> q = dVar.q();
        if (q.isEmpty()) {
            nVar.finish();
            return;
        }
        dVar.showNow(c(), "PermissionXRationaleDialogFragment");
        View r = dVar.r();
        View p = dVar.p();
        dVar.setCancelable(false);
        r.setClickable(true);
        r.setOnClickListener(new View.OnClickListener() { // from class: e.q.a.g.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.K(dVar, z, nVar, q, this, view);
            }
        });
        if (p != null) {
            p.setClickable(true);
            p.setOnClickListener(new View.OnClickListener() { // from class: e.q.a.g.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.L(dVar, nVar, view);
                }
            });
        }
    }

    public final void G(@k.e.a.d n nVar, boolean z, @k.e.a.d List<String> list, @k.e.a.d String str, @k.e.a.d String str2, @k.e.a.e String str3) {
        E(nVar, z, new e.q.a.f.a(getActivity(), list, str, str2, str3, this.f14415c, this.f14416d));
    }

    @k.e.a.d
    public final r a() {
        this.f14421i = true;
        return this;
    }

    public final int e() {
        return getActivity().getApplicationInfo().targetSdkVersion;
    }

    @k.e.a.d
    public final FragmentActivity getActivity() {
        FragmentActivity fragmentActivity = this.a;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        return null;
    }

    @k.e.a.d
    public final r l(@k.e.a.e e.q.a.d.a aVar) {
        this.r = aVar;
        return this;
    }

    @k.e.a.d
    public final r m(@k.e.a.e e.q.a.d.b bVar) {
        this.s = bVar;
        return this;
    }

    @k.e.a.d
    public final r n(@k.e.a.e e.q.a.d.c cVar) {
        this.t = cVar;
        return this;
    }

    public final void o() {
        Fragment findFragmentByTag = c().findFragmentByTag(v);
        if (findFragmentByTag != null) {
            c().beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
    }

    public final void p(@k.e.a.e e.q.a.d.d dVar) {
        this.q = dVar;
        k();
        t tVar = new t();
        tVar.a(new w(this));
        tVar.a(new s(this));
        tVar.a(new x(this));
        tVar.a(new y(this));
        tVar.a(new v(this));
        tVar.a(new u(this));
        tVar.b();
    }

    public final void q(@k.e.a.d n nVar) {
        d().F(this, nVar);
    }

    public final void r(@k.e.a.d n nVar) {
        d().I(this, nVar);
    }

    public final void s(@k.e.a.d n nVar) {
        d().K(this, nVar);
    }

    public final void t(@k.e.a.d Set<String> set, @k.e.a.d n nVar) {
        d().M(this, set, nVar);
    }

    public final void u(@k.e.a.d n nVar) {
        d().O(this, nVar);
    }

    public final void v(@k.e.a.d n nVar) {
        d().Q(this, nVar);
    }

    public final void w() {
        getActivity().setRequestedOrientation(this.f14417e);
    }

    public final void x(@k.e.a.d FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
    }

    @k.e.a.d
    public final r y(int i2, int i3) {
        this.f14415c = i2;
        this.f14416d = i3;
        return this;
    }

    public final boolean z() {
        return this.f14420h.contains("android.permission.ACCESS_BACKGROUND_LOCATION");
    }
}
