package e.q.a.f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.permissionx.guolindev.R;
import e.q.a.g.u;
import e.q.a.g.v;
import java.util.HashSet;
import java.util.List;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\r\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0019J\u0012\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/permissionx/guolindev/dialog/DefaultDialog;", "Lcom/permissionx/guolindev/dialog/RationaleDialog;", "context", "Landroid/content/Context;", TTDelegateActivity.INTENT_PERMISSIONS, "", "", "message", "positiveText", "negativeText", "lightColor", "", "darkColor", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "binding", "Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;", "buildPermissionsLayout", "", "getNegativeButton", "Landroid/view/View;", "getPermissionsToRequest", "getPositiveButton", "isDarkTheme", "", "isPermissionLayoutEmpty", "isPermissionLayoutEmpty$permissionx_release", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupText", "setupWindow", "permissionx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class a extends c {
    @k.e.a.d
    private final List<String> a;
    @k.e.a.d
    private final String b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final String f14393c;
    @e

    /* renamed from: d  reason: collision with root package name */
    private final String f14394d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14395e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14396f;

    /* renamed from: g  reason: collision with root package name */
    private e.q.a.e.a f14397g;

    public a(@k.e.a.d Context context, @k.e.a.d List<String> list, @k.e.a.d String str, @k.e.a.d String str2, @e String str3, int i2, int i3) {
        super(context, R.style.PermissionXDefaultDialog);
        this.a = list;
        this.b = str;
        this.f14393c = str2;
        this.f14394d = str3;
        this.f14395e = i2;
        this.f14396f = i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final void d() {
        String str;
        HashSet hashSet = new HashSet();
        int i2 = Build.VERSION.SDK_INT;
        for (String str2 : this.a) {
            if (i2 < 29) {
                try {
                    str = getContext().getPackageManager().getPermissionInfo(str2, 0).group;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                    str = null;
                }
            } else if (i2 == 29) {
                str = b.b().get(str2);
            } else if (i2 == 30) {
                str = b.c().get(str2);
            } else if (i2 == 31) {
                str = b.d().get(str2);
            } else {
                str = b.c().get(str2);
            }
            if ((b.a().contains(str2) && !hashSet.contains(str2)) || (str != null && !hashSet.contains(str))) {
                LayoutInflater layoutInflater = getLayoutInflater();
                e.q.a.e.a aVar = this.f14397g;
                if (aVar == null) {
                    aVar = null;
                }
                e.q.a.e.b d2 = e.q.a.e.b.d(layoutInflater, aVar.f14389e, false);
                switch (str2.hashCode()) {
                    case -2078357533:
                        if (str2.equals("android.permission.WRITE_SETTINGS")) {
                            d2.f14392c.setText(getContext().getString(R.string.permissionx_write_settings));
                            d2.b.setImageResource(R.drawable.permissionx_ic_setting);
                            break;
                        }
                        d2.f14392c.setText(getContext().getString(getContext().getPackageManager().getPermissionGroupInfo(str, 0).labelRes));
                        d2.b.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                        break;
                    case -1813079487:
                        if (str2.equals(v.f14431f)) {
                            d2.f14392c.setText(getContext().getString(R.string.permissionx_manage_external_storage));
                            d2.b.setImageResource(R.drawable.permissionx_ic_storage);
                            break;
                        }
                        d2.f14392c.setText(getContext().getString(getContext().getPackageManager().getPermissionGroupInfo(str, 0).labelRes));
                        d2.b.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                        break;
                    case -1561629405:
                        if (str2.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                            d2.f14392c.setText(getContext().getString(R.string.permissionx_system_alert_window));
                            d2.b.setImageResource(R.drawable.permissionx_ic_alert);
                            break;
                        }
                        d2.f14392c.setText(getContext().getString(getContext().getPackageManager().getPermissionGroupInfo(str, 0).labelRes));
                        d2.b.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                        break;
                    case 1777263169:
                        if (str2.equals(u.f14429f)) {
                            d2.f14392c.setText(getContext().getString(R.string.permissionx_request_install_packages));
                            d2.b.setImageResource(R.drawable.permissionx_ic_install);
                            break;
                        }
                        d2.f14392c.setText(getContext().getString(getContext().getPackageManager().getPermissionGroupInfo(str, 0).labelRes));
                        d2.b.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                        break;
                    case 2024715147:
                        if (str2.equals("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                            d2.f14392c.setText(getContext().getString(R.string.permissionx_access_background_location));
                            d2.b.setImageResource(R.drawable.permissionx_ic_location);
                            break;
                        }
                        d2.f14392c.setText(getContext().getString(getContext().getPackageManager().getPermissionGroupInfo(str, 0).labelRes));
                        d2.b.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                        break;
                    default:
                        d2.f14392c.setText(getContext().getString(getContext().getPackageManager().getPermissionGroupInfo(str, 0).labelRes));
                        d2.b.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                        break;
                }
                if (e()) {
                    int i3 = this.f14396f;
                    if (i3 != -1) {
                        d2.b.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
                    }
                } else {
                    int i4 = this.f14395e;
                    if (i4 != -1) {
                        d2.b.setColorFilter(i4, PorterDuff.Mode.SRC_ATOP);
                    }
                }
                e.q.a.e.a aVar2 = this.f14397g;
                (aVar2 != null ? aVar2 : null).f14389e.addView(d2.getRoot());
                if (str != null) {
                    str2 = str;
                }
                hashSet.add(str2);
            }
        }
    }

    private final boolean e() {
        return (getContext().getResources().getConfiguration().uiMode & 48) == 32;
    }

    private final void g() {
        e.q.a.e.a aVar = this.f14397g;
        if (aVar == null) {
            aVar = null;
        }
        aVar.b.setText(this.b);
        e.q.a.e.a aVar2 = this.f14397g;
        if (aVar2 == null) {
            aVar2 = null;
        }
        aVar2.f14390f.setText(this.f14393c);
        if (this.f14394d != null) {
            e.q.a.e.a aVar3 = this.f14397g;
            if (aVar3 == null) {
                aVar3 = null;
            }
            aVar3.f14388d.setVisibility(0);
            e.q.a.e.a aVar4 = this.f14397g;
            if (aVar4 == null) {
                aVar4 = null;
            }
            aVar4.f14387c.setText(this.f14394d);
        } else {
            e.q.a.e.a aVar5 = this.f14397g;
            if (aVar5 == null) {
                aVar5 = null;
            }
            aVar5.f14388d.setVisibility(8);
        }
        if (e()) {
            if (this.f14396f != -1) {
                e.q.a.e.a aVar6 = this.f14397g;
                if (aVar6 == null) {
                    aVar6 = null;
                }
                aVar6.f14390f.setTextColor(this.f14396f);
                e.q.a.e.a aVar7 = this.f14397g;
                (aVar7 != null ? aVar7 : null).f14387c.setTextColor(this.f14396f);
            }
        } else if (this.f14395e != -1) {
            e.q.a.e.a aVar8 = this.f14397g;
            if (aVar8 == null) {
                aVar8 = null;
            }
            aVar8.f14390f.setTextColor(this.f14395e);
            e.q.a.e.a aVar9 = this.f14397g;
            (aVar9 != null ? aVar9 : null).f14387c.setTextColor(this.f14395e);
        }
    }

    private final void h() {
        int i2 = getContext().getResources().getDisplayMetrics().widthPixels;
        if (i2 < getContext().getResources().getDisplayMetrics().heightPixels) {
            Window window = getWindow();
            if (window == null) {
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setGravity(17);
            attributes.width = (int) (i2 * 0.86d);
            window.setAttributes(attributes);
            return;
        }
        Window window2 = getWindow();
        if (window2 == null) {
            return;
        }
        WindowManager.LayoutParams attributes2 = window2.getAttributes();
        window2.setGravity(17);
        attributes2.width = (int) (i2 * 0.6d);
        window2.setAttributes(attributes2);
    }

    @Override // e.q.a.f.c
    @e
    public View a() {
        if (this.f14394d == null) {
            return null;
        }
        e.q.a.e.a aVar = this.f14397g;
        return (aVar != null ? aVar : null).f14387c;
    }

    @Override // e.q.a.f.c
    @k.e.a.d
    public List<String> b() {
        return this.a;
    }

    @Override // e.q.a.f.c
    @k.e.a.d
    public View c() {
        e.q.a.e.a aVar = this.f14397g;
        if (aVar == null) {
            aVar = null;
        }
        return aVar.f14390f;
    }

    public final boolean f() {
        e.q.a.e.a aVar = this.f14397g;
        if (aVar == null) {
            aVar = null;
        }
        return aVar.f14389e.getChildCount() == 0;
    }

    @Override // android.app.Dialog
    public void onCreate(@e Bundle bundle) {
        super.onCreate(bundle);
        e.q.a.e.a c2 = e.q.a.e.a.c(getLayoutInflater());
        this.f14397g = c2;
        if (c2 == null) {
            c2 = null;
        }
        setContentView(c2.getRoot());
        g();
        d();
        h();
    }
}
