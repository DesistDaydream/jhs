package com.vector.network.image;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.d;
import com.vector.ext.view.ViewKt;
import com.vector.network.image.glide.GlideProvider;
import com.vector.util.Res;
import e.t.r.a.f;
import e.t.r.a.n.c;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.u;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0002H\u0096\u0001J\u0013\u0010\u0011\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u0013\u0010\u0013\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0002H\u0096\u0001J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\u0013\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0096\u0001J\b\u0010!\u001a\u00020\u0016H\u0016J\u0011\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0096\u0001J\b\u0010%\u001a\u00020\u0016H\u0016J\t\u0010&\u001a\u00020\u0016H\u0096\u0001J4\u0010'\u001a\u00020\u00022)\u0010(\u001a%\u0012\u001b\u0012\u0019\u0018\u00010*j\u0004\u0018\u0001`+¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00160)H\u0096\u0001J,\u0010/\u001a\u00020\u00022!\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00160)H\u0096\u0001J\u0018\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0014J\u0010\u00104\u001a\u00020 2\u0006\u00105\u001a\u000206H\u0017J\u0013\u00107\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u0013\u00107\u001a\u00020\u00022\b\b\u0001\u00108\u001a\u00020\bH\u0096\u0001J\u0013\u00109\u001a\u00020\u00022\b\b\u0001\u00108\u001a\u00020\bH\u0096\u0001J\u0013\u0010:\u001a\u00020\u00022\b\u0010:\u001a\u0004\u0018\u00010;H\u0096\u0001J\u0011\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020>H\u0096\u0001J\u0012\u0010?\u001a\u00020\u00162\b\u0010@\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010?\u001a\u00020\u00162\b\b\u0001\u00108\u001a\u00020\bJ\u0013\u0010A\u001a\u00020\u00022\b\u0010B\u001a\u0004\u0018\u00010;H\u0096\u0001J\u0011\u0010C\u001a\u00020\u00022\u0006\u0010C\u001a\u00020DH\u0096\u0001J\u0019\u0010E\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\u0096\u0001J\u0013\u0010H\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u0013\u0010I\u001a\u00020\u00022\b\u0010J\u001a\u0004\u0018\u00010;H\u0096\u0001J\u0013\u0010K\u001a\u00020\u00022\b\u0010L\u001a\u0004\u0018\u00010;H\u0096\u0001J\u0013\u0010M\u001a\u00020\u00022\b\u0010M\u001a\u0004\u0018\u00010NH\u0096\u0001J\u0013\u0010L\u001a\u00020\u00022\b\u0010L\u001a\u0004\u0018\u00010;H\u0096\u0001J\u0010\u0010O\u001a\u00020 2\u0006\u0010P\u001a\u00020\u000bH\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/vector/network/image/NImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/vector/network/image/Provider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cacheForeground", "Landroid/graphics/drawable/Drawable;", "addInterceptor", "interceptor", "Lcom/vector/network/image/interceptor/Interceptor;", "asBitmap", "asDrawable", "bitmap", "Landroid/graphics/Bitmap;", "bytes", "", "clear", "", "clearInterceptor", "draw", "canvas", "Landroid/graphics/Canvas;", "drawableStateChanged", d.O, "drawable", "fadeInEnabled", "enabled", "", "handleMeasure", "init", "v", "Landroid/widget/ImageView;", "jumpDrawablesToCurrentState", "load", "onLoadError", "action", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", e.a, "onLoadReady", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "placeholder", "id", "res", "reserveUrl", "", "scaleType", "type", "Lcom/vector/network/image/ScaleType;", "setForeground", "foreground", "setSignature", "s", "shaper", "Lcom/vector/network/image/Shaper;", "size", "width", "height", "src", "storage", "path", "thumbnail", "url", "uri", "Landroid/net/Uri;", "verifyDrawable", "dr", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class NImageView extends AppCompatImageView implements f {
    private final /* synthetic */ GlideProvider a;
    @k.e.a.e
    private Drawable b;

    @h
    public NImageView(@k.e.a.d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public NImageView(@k.e.a.d Context context, @k.e.a.e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ NImageView(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f a(@k.e.a.e Drawable drawable) {
        return this.a.a(drawable);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f c(int i2, int i3) {
        return this.a.c(i2, i3);
    }

    @Override // e.t.r.a.f
    public void clear() {
        this.a.clear();
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f d(@k.e.a.e Bitmap bitmap) {
        return this.a.d(bitmap);
    }

    @Override // android.view.View
    public void draw(@k.e.a.d Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.b;
        if (drawable == null) {
            return;
        }
        drawable.draw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.b;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    @Override // e.t.r.a.f
    public void e() {
        this.a.e();
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f f(@k.e.a.e String str) {
        return this.a.f(str);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f g(@k.e.a.d l<? super Exception, t1> lVar) {
        return this.a.g(lVar);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f h(@k.e.a.d ScaleType scaleType) {
        return this.a.h(scaleType);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f i(boolean z) {
        return this.a.i(z);
    }

    @k.e.a.d
    public f j(@k.e.a.d e.t.r.a.h hVar) {
        return this.a.j(hVar);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.b;
        if (drawable == null) {
            return;
        }
        drawable.jumpToCurrentState();
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f k(@k.e.a.d c cVar) {
        return this.a.k(cVar);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f l(@k.e.a.e String str) {
        return this.a.l(str);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f m(@k.e.a.e String str) {
        return this.a.m(str);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f n(@k.e.a.e Uri uri) {
        return this.a.n(uri);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f o(@k.e.a.e Drawable drawable) {
        return this.a.o(drawable);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        z();
        Drawable drawable = this.b;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    @TargetApi(21)
    public boolean onTouchEvent(@k.e.a.d MotionEvent motionEvent) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= 21 && motionEvent.getActionMasked() == 0 && (drawable = this.b) != null) {
            drawable.setHotspot(motionEvent.getX(), motionEvent.getY());
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f p(@k.e.a.d l<? super Bitmap, t1> lVar) {
        return this.a.p(lVar);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f q() {
        return this.a.q();
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f r(@k.e.a.e String str) {
        return this.a.r(str);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f s(@DrawableRes int i2) {
        return this.a.s(i2);
    }

    @Override // android.view.View
    public void setForeground(@k.e.a.e Drawable drawable) {
        if (ViewKt.c(this, this.b, drawable)) {
            this.b = drawable;
        }
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f t(@k.e.a.e byte[] bArr) {
        return this.a.t(bArr);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f u(@k.e.a.e Drawable drawable) {
        return this.a.u(drawable);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f url(@k.e.a.e String str) {
        return this.a.url(str);
    }

    @Override // e.t.r.a.f
    public void v(@k.e.a.d ImageView imageView) {
        this.a.v(imageView);
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean verifyDrawable(@k.e.a.d Drawable drawable) {
        return super.verifyDrawable(drawable) || f0.g(drawable, this.b);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f w(@DrawableRes int i2) {
        return this.a.w(i2);
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f x() {
        return this.a.x();
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f y() {
        return this.a.y();
    }

    public void z() {
    }

    @h
    public NImageView(@k.e.a.d Context context, @k.e.a.e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new GlideProvider();
        if (isInEditMode()) {
            setBackgroundColor(-16776961);
        }
        v(this);
    }

    public final void setForeground(@DrawableRes int i2) {
        setForeground(Res.a.p(getContext(), i2));
    }
}
