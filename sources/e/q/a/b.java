package e.q.a;

import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import e.q.a.g.r;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\t2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0002\u0010\fJ\u0014\u0010\b\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\rR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/permissionx/guolindev/PermissionMediator;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", TTDelegateActivity.INTENT_PERMISSIONS, "Lcom/permissionx/guolindev/request/PermissionBuilder;", "", "", "([Ljava/lang/String;)Lcom/permissionx/guolindev/request/PermissionBuilder;", "", "permissionx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class b {
    @e
    private FragmentActivity a;
    @e
    private Fragment b;

    public b(@d FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
    }

    @d
    public final r a(@d List<String> list) {
        int i2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        int i3 = Build.VERSION.SDK_INT;
        FragmentActivity fragmentActivity = this.a;
        if (fragmentActivity != null) {
            i2 = fragmentActivity.getApplicationInfo().targetSdkVersion;
        } else {
            i2 = this.b.requireContext().getApplicationInfo().targetSdkVersion;
        }
        for (String str : list) {
            if (e.q.a.f.b.a().contains(str)) {
                linkedHashSet2.add(str);
            } else {
                linkedHashSet.add(str);
            }
        }
        if (linkedHashSet2.contains("android.permission.ACCESS_BACKGROUND_LOCATION") && (i3 == 29 || (i3 == 30 && i2 < 30))) {
            linkedHashSet2.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
            linkedHashSet.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        return new r(this.a, this.b, linkedHashSet, linkedHashSet2);
    }

    @d
    public final r b(@d String... strArr) {
        return a(CollectionsKt__CollectionsKt.L(Arrays.copyOf(strArr, strArr.length)));
    }

    public b(@d Fragment fragment) {
        this.b = fragment;
    }
}
