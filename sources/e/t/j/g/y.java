package e.t.j.g;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.databinding.BindingAdapter;
import com.baidu.mobads.sdk.internal.bp;
import com.vector.ext.view.ViewKt;
import com.vector.network.image.NImageView;
import com.vector.network.image.ScaleType;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J¿\u0001\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010!2\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010%\u001a\u0004\u0018\u00010!2\b\u0010&\u001a\u0004\u0018\u00010'2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u00010\u00042\b\u00103\u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0002\u00104J\u0018\u00105\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00106\u001a\u000207H\u0007J\u0018\u00108\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u001fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/vector/databinding/adapter/NImageViewBinding;", "", "()V", "AS_BITMAP", "", "AS_SVG", "BITMAP", bp.f1533l, "FADE_IN", "FOREGROUND", "HEIGHT", "INTERCEPTORS", "PLACEHOLDER", "PLACEHOLDER_ID", "RES", "RESIZE", "SCALE_TYPE", "SHAPE", "SIGNATURE", "SRC", "STORAGE", "URI", "URL", "load", "", "view", "Lcom/vector/network/image/NImageView;", "url", "uri", "Landroid/net/Uri;", "res", "", "src", "Landroid/graphics/drawable/Drawable;", "path", "placeholder", "placeholderId", "foreground", "scaleType", "Lcom/vector/network/image/ScaleType;", "interceptors", "", "Lcom/vector/network/image/interceptor/Interceptor;", "shape", "Lcom/vector/network/image/Shaper;", "resize", "Lcom/vector/model/Size;", "fadeIn", "", "asBitmap", "signature", com.umeng.analytics.pro.d.O, "(Lcom/vector/network/image/NImageView;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcom/vector/network/image/ScaleType;Ljava/util/List;Lcom/vector/network/image/Shaper;Lcom/vector/model/Size;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V", "setBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setHeight", "height", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class y {
    @k.e.a.d
    public static final y a = new y();
    @k.e.a.d
    private static final String b = "android:niv_url";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f14536c = "android:niv_uri";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f14537d = "android:niv_res";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f14538e = "android:niv_storage";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final String f14539f = "android:niv_src";
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final String f14540g = "android:niv_placeholder";
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private static final String f14541h = "android:niv_placeholderId";
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    private static final String f14542i = "android:niv_foreground";
    @k.e.a.d

    /* renamed from: j  reason: collision with root package name */
    private static final String f14543j = "android:niv_scaleType";
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    private static final String f14544k = "android:niv_shape";
    @k.e.a.d

    /* renamed from: l  reason: collision with root package name */
    private static final String f14545l = "android:niv_interceptors";
    @k.e.a.d

    /* renamed from: m  reason: collision with root package name */
    private static final String f14546m = "android:niv_resize";
    @k.e.a.d
    private static final String n = "android:niv_fadeIn";
    @k.e.a.d
    private static final String o = "android:niv_height";
    @k.e.a.d
    private static final String p = "android:niv_bitmap";
    @k.e.a.d
    private static final String q = "android:niv_asBitmap";
    @k.e.a.d
    private static final String r = "android:niv_asBitmap";
    @k.e.a.d
    private static final String s = "android:niv_error";
    @k.e.a.d
    private static final String t = "android:niv_signature";

    private y() {
    }

    @BindingAdapter(requireAll = false, value = {b, f14536c, f14537d, f14539f, f14538e, f14540g, f14541h, f14542i, f14543j, f14545l, f14544k, f14546m, n, "android:niv_asBitmap", t, s})
    @h.k2.k
    public static final void a(@k.e.a.d NImageView nImageView, @k.e.a.e String str, @k.e.a.e Uri uri, @DrawableRes @k.e.a.e Integer num, @k.e.a.e Drawable drawable, @k.e.a.e String str2, @k.e.a.e Drawable drawable2, @DrawableRes @k.e.a.e Integer num2, @k.e.a.e Drawable drawable3, @k.e.a.e ScaleType scaleType, @k.e.a.e List<? extends e.t.r.a.n.c> list, @k.e.a.e e.t.r.a.h hVar, @k.e.a.e e.t.q.c cVar, @k.e.a.e Boolean bool, @k.e.a.e Boolean bool2, @k.e.a.e String str3, @k.e.a.e Drawable drawable4) {
        if (num != null && num.intValue() != 0) {
            nImageView.w(num.intValue());
        } else if (drawable != null) {
            nImageView.a(drawable);
        } else if (str2 != null) {
            nImageView.r(str2);
        } else if (uri != null) {
            nImageView.n(uri);
        } else if (str != null) {
            nImageView.url(str);
        }
        if (drawable2 != null) {
            nImageView.o(drawable2);
        } else if (num2 != null) {
            nImageView.s(num2.intValue());
        }
        nImageView.setForeground(drawable3);
        if (bool != null) {
            nImageView.i(bool.booleanValue());
        }
        if (scaleType != null) {
            nImageView.h(scaleType);
        }
        if (hVar != null) {
            nImageView.j(hVar);
        }
        nImageView.q();
        if (list != null) {
            for (e.t.r.a.n.c cVar2 : list) {
                nImageView.k(cVar2);
            }
        }
        nImageView.u(drawable4);
        if (cVar != null) {
            nImageView.c(cVar.f(), cVar.e());
        }
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                nImageView.y();
            } else {
                nImageView.x();
            }
        }
        nImageView.m(str3);
        Context context = nImageView.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            nImageView.e();
            return;
        }
        nImageView.e();
    }

    @BindingAdapter({p})
    @h.k2.k
    public static final void b(@k.e.a.d NImageView nImageView, @k.e.a.d Bitmap bitmap) {
        nImageView.setImageBitmap(bitmap);
    }

    @BindingAdapter({o})
    @h.k2.k
    public static final void c(@k.e.a.d NImageView nImageView, int i2) {
        ViewKt.F(nImageView, i2);
    }
}
