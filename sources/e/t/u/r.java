package e.t.u;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.qiniu.android.collect.ReportItem;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\nJ)\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0007¢\u0006\u0002\u0010\nJ-\u0010\u000b\u001a\u00020\u00042\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0007¢\u0006\u0002\u0010\u000eJ1\u0010\u000b\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\u0010J5\u0010\u000b\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00112\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\u0012J+\u0010\u000b\u001a\u00020\u00042\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00112\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\u0013J9\u0010\u0014\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\u0017J?\u0010\u0014\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0007¢\u0006\u0002\u0010\u0018J=\u0010\u0014\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/vector/util/LaunchUtil;", "", "()V", "putExtras", "", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, "", "Landroid/os/Bundle;", "(Landroid/content/Intent;[Landroid/os/Bundle;)V", "startActivity", "clz", "Ljava/lang/Class;", "(Ljava/lang/Class;[Landroid/os/Bundle;)V", ReportItem.RequestKeyHost, "(Ljava/lang/Object;Landroid/content/Intent;[Landroid/os/Bundle;)V", "Lkotlin/reflect/KClass;", "(Ljava/lang/Object;Lkotlin/reflect/KClass;[Landroid/os/Bundle;)V", "(Lkotlin/reflect/KClass;[Landroid/os/Bundle;)V", "startActivityForResult", "code", "", "(Ljava/lang/Object;Landroid/content/Intent;I[Landroid/os/Bundle;)V", "(Ljava/lang/Object;Ljava/lang/Class;I[Landroid/os/Bundle;)V", "(Ljava/lang/Object;Lkotlin/reflect/KClass;I[Landroid/os/Bundle;)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class r {
    @k.e.a.d
    public static final r a = new r();

    private r() {
    }

    @h.k2.k
    public static final void startActivity(@k.e.a.d Class<?> cls, @k.e.a.d Bundle... bundleArr) {
        startActivity(new Intent(e.t.a.b(), cls), (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
    }

    public final void a(@k.e.a.d Intent intent, @k.e.a.d Bundle... bundleArr) {
        if (!(bundleArr.length == 0)) {
            for (Bundle bundle : bundleArr) {
                intent.putExtras(bundle);
            }
        }
    }

    public final void startActivityForResult(@k.e.a.e Object obj, @k.e.a.d Intent intent, int i2, @k.e.a.d Bundle... bundleArr) {
        a(intent, (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
        if (obj instanceof Activity) {
            ((Activity) obj).startActivityForResult(intent, i2);
        } else if (!(obj instanceof Fragment)) {
            throw new IllegalArgumentException("host can only be activity or fragment");
        } else {
            ((Fragment) obj).startActivityForResult(intent, i2);
        }
    }

    public final void startActivity(@k.e.a.d h.p2.d<?> dVar, @k.e.a.d Bundle... bundleArr) {
        startActivity(new Intent(e.t.a.b(), h.k2.a.c(dVar)), (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
    }

    @h.k2.k
    public static final void startActivity(@k.e.a.d Intent intent, @k.e.a.d Bundle... bundleArr) {
        a.a(intent, (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
        intent.addFlags(268435456);
        e.t.a.b().startActivity(intent);
    }

    public final void startActivityForResult(@k.e.a.e Object obj, @k.e.a.d h.p2.d<?> dVar, int i2, @k.e.a.d Bundle... bundleArr) {
        startActivityForResult(obj, h.k2.a.c(dVar), i2, (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
    }

    @h.k2.k
    public static final void startActivityForResult(@k.e.a.e Object obj, @k.e.a.d Class<?> cls, int i2, @k.e.a.d Bundle... bundleArr) {
        a.startActivityForResult(obj, new Intent(e.t.a.b(), cls), i2, (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
    }

    public final void startActivity(@k.e.a.e Object obj, @k.e.a.d Intent intent, @k.e.a.d Bundle... bundleArr) {
        a(intent, (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
        if (obj instanceof Activity) {
            ((Activity) obj).startActivity(intent);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).startActivity(intent);
        } else if (obj instanceof Context) {
            intent.addFlags(268435456);
            ((Context) obj).startActivity(intent);
        } else {
            intent.addFlags(268435456);
            e.t.a.b().startActivity(intent);
        }
    }

    public final void startActivity(@k.e.a.e Object obj, @k.e.a.d h.p2.d<?> dVar, @k.e.a.d Bundle... bundleArr) {
        startActivity(obj, new Intent(e.t.a.b(), h.k2.a.c(dVar)), (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
    }
}
