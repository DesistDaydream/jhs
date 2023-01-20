package e.t.r.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.vector.network.image.ScaleType;
import h.k2.u.l;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0000H&J\b\u0010\u0006\u001a\u00020\u0000H&J\u0012\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0000H&J\u0012\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\fH&J3\u0010\u0018\u001a\u00020\u00002)\u0010\u0019\u001a%\u0012\u001b\u0012\u0019\u0018\u00010\u001bj\u0004\u0018\u0001`\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\f0\u001aH&J+\u0010 \u001a\u00020\u00002!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\f0\u001aH&J\u0012\u0010\"\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\"\u001a\u00020\u00002\b\b\u0001\u0010#\u001a\u00020$H&J\u0012\u0010%\u001a\u00020\u00002\b\b\u0001\u0010#\u001a\u00020$H&J\u0012\u0010&\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010'H&J\u0010\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*H&J\u0012\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010'H&J\u0010\u0010-\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.H&J\u0018\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020$H&J\u0012\u00102\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u00103\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010'H&J\u0012\u00105\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u00010'H&J\u0012\u00107\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u000108H&J\u0012\u00106\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u00010'H&¨\u00069"}, d2 = {"Lcom/vector/network/image/Provider;", "", "addInterceptor", "interceptor", "Lcom/vector/network/image/interceptor/Interceptor;", "asBitmap", "asDrawable", "bitmap", "Landroid/graphics/Bitmap;", "bytes", "", "clear", "", "clearInterceptor", com.umeng.analytics.pro.d.O, "drawable", "Landroid/graphics/drawable/Drawable;", "fadeInEnabled", "enabled", "", "init", "v", "Landroid/widget/ImageView;", "load", "onLoadError", "action", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", com.huawei.hms.push.e.a, "onLoadReady", "b", "placeholder", "id", "", "res", "reserveUrl", "", "scaleType", "type", "Lcom/vector/network/image/ScaleType;", "setSignature", "s", "shaper", "Lcom/vector/network/image/Shaper;", "size", "width", "height", "src", "storage", "path", "thumbnail", "url", "uri", "Landroid/net/Uri;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface f {
    @k.e.a.d
    f a(@k.e.a.e Drawable drawable);

    @k.e.a.d
    f c(int i2, int i3);

    void clear();

    @k.e.a.d
    f d(@k.e.a.e Bitmap bitmap);

    void e();

    @k.e.a.d
    f f(@k.e.a.e String str);

    @k.e.a.d
    f g(@k.e.a.d l<? super Exception, t1> lVar);

    @k.e.a.d
    f h(@k.e.a.d ScaleType scaleType);

    @k.e.a.d
    f i(boolean z);

    @k.e.a.d
    f j(@k.e.a.d h hVar);

    @k.e.a.d
    f k(@k.e.a.d e.t.r.a.n.c cVar);

    @k.e.a.d
    f l(@k.e.a.e String str);

    @k.e.a.d
    f m(@k.e.a.e String str);

    @k.e.a.d
    f n(@k.e.a.e Uri uri);

    @k.e.a.d
    f o(@k.e.a.e Drawable drawable);

    @k.e.a.d
    f p(@k.e.a.d l<? super Bitmap, t1> lVar);

    @k.e.a.d
    f q();

    @k.e.a.d
    f r(@k.e.a.e String str);

    @k.e.a.d
    f s(@DrawableRes int i2);

    @k.e.a.d
    f t(@k.e.a.e byte[] bArr);

    @k.e.a.d
    f u(@k.e.a.e Drawable drawable);

    @k.e.a.d
    f url(@k.e.a.e String str);

    void v(@k.e.a.d ImageView imageView);

    @k.e.a.d
    f w(@DrawableRes int i2);

    @k.e.a.d
    f x();

    @k.e.a.d
    f y();
}
