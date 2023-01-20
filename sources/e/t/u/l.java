package e.t.u;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.huawei.hms.support.api.entity.core.CommonCode;
import h.k2.v.f0;
import inject.annotation.creator.Creator;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/vector/util/InjectUtil;", "", "()V", "CREATOR", "", "INJECT", "bind", "", "activity", "Landroid/app/Activity;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "service", "Landroid/app/Service;", "i", "frag", "Landroidx/fragment/app/Fragment;", "intentBuilder", "o", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class l {
    @k.e.a.d
    public static final l a = new l();
    @k.e.a.d
    private static final String b = "Creator";
    @k.e.a.d

    /* renamed from: c */
    private static final String f14670c = "inject";

    private l() {
    }

    public static /* synthetic */ void d(l lVar, Activity activity, Intent intent, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            intent = null;
        }
        lVar.a(activity, intent);
    }

    private final void e(Object obj, Intent intent) {
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(Creator.class)) {
            try {
                v.a.a(f0.C(cls.getName(), b), f14670c, cls, Intent.class).invoke(null, obj, intent);
            } catch (Exception e2) {
                Log.e("InjectUtil", f0.C("intentBuilder Exception = ", e2.getMessage()));
            }
        }
    }

    public final void a(@k.e.a.d Activity activity, @k.e.a.e Intent intent) {
        if (intent == null) {
            intent = activity.getIntent();
        }
        e(activity, intent);
    }

    public final void b(@k.e.a.d Service service, @k.e.a.d Intent intent) {
        e(service, intent);
    }

    public final void c(@k.e.a.d Fragment fragment) {
        Class<?> cls = fragment.getClass();
        if (cls.isAnnotationPresent(Creator.class)) {
            try {
                v.a.a(f0.C(cls.getName(), b), f14670c, cls).invoke(null, fragment);
            } catch (Exception unused) {
            }
        }
    }
}
