package e.t.j.g;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.databinding.BindingAdapter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J!\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014J\u001f\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/vector/databinding/adapter/ImageViewBinding;", "", "()V", "ANDROID_AUTO_MIRROR_SRC", "", "ANDROID_BITMAP", "ANDROID_DRAWABLE", "ANDROID_SRC", "AUTO_MIRROR", "TINT", "autoMirror", "", "view", "Landroid/widget/ImageView;", "mirror", "", "(Landroid/widget/ImageView;Ljava/lang/Boolean;)V", "setAutoMirrorImageSrc", "resId", "", "(Landroid/widget/ImageView;Ljava/lang/Integer;)V", "setImageBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setImageSrc", "drawable", "Landroid/graphics/drawable/Drawable;", "setImageTint", "color", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class x {
    @k.e.a.d
    public static final x a = new x();
    @k.e.a.d
    private static final String b = "android:imageView_bitmap";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f14531c = "android:imageView_src";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f14532d = "android:imageView_autoMirrorSrc";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f14533e = "android:imageview_drawable";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final String f14534f = "android:imageView_autoMirror";
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final String f14535g = "android:imageView_tint";

    private x() {
    }

    @BindingAdapter({f14534f})
    @h.k2.k
    public static final void a(@k.e.a.d ImageView imageView, @k.e.a.e Boolean bool) {
        if (bool == null) {
            return;
        }
        boolean booleanValue = bool.booleanValue();
        Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            return;
        }
        drawable.setAutoMirrored(booleanValue);
    }

    @BindingAdapter({f14532d})
    @h.k2.k
    public static final void b(@k.e.a.d ImageView imageView, @DrawableRes @k.e.a.e Integer num) {
        if (num == null) {
            return;
        }
        imageView.setImageResource(num.intValue());
        imageView.getDrawable().setAutoMirrored(true);
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void c(@k.e.a.d ImageView imageView, @k.e.a.e Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    @BindingAdapter({f14533e})
    @h.k2.k
    public static final void d(@k.e.a.d ImageView imageView, @k.e.a.e Drawable drawable) {
        if (drawable == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    @BindingAdapter({f14531c})
    @h.k2.k
    public static final void e(@k.e.a.d ImageView imageView, @DrawableRes @k.e.a.e Integer num) {
        if (num == null) {
            return;
        }
        imageView.setImageResource(num.intValue());
    }

    @BindingAdapter({f14535g})
    @h.k2.k
    public static final void f(@k.e.a.d ImageView imageView, @k.e.a.e Integer num) {
        if (num == null) {
            imageView.setImageTintList(null);
        } else {
            imageView.setImageTintList(ColorStateList.valueOf(num.intValue()));
        }
    }
}
