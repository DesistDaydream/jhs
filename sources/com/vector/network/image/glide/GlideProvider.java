package com.vector.network.image.glide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.baidu.mobads.sdk.internal.bc;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.huawei.hms.push.e;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.analytics.pro.d;
import com.vector.ext.AnyKt;
import com.vector.network.image.ScaleType;
import com.vector.network.image.glide.transformation.CircleCrop;
import com.vector.network.image.glide.transformation.IrregularCrop;
import e.b.a.p.m.d.b0;
import e.b.a.p.m.d.i;
import e.b.a.p.m.d.m;
import e.b.a.p.m.d.s;
import e.b.a.t.g;
import e.b.a.t.k.p;
import e.b.a.t.l.c;
import e.t.l.r;
import e.t.r.a.f;
import e.t.r.a.h;
import e.t.r.a.k;
import e.t.r.a.n.c;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0003FGHB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0010H\u0016J\b\u0010\u0003\u001a\u00020\u0001H\u0016J\b\u00101\u001a\u00020\u0001H\u0016J\u0012\u0010\u0005\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u00102\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u00020\u001aH\u0016J\b\u00106\u001a\u00020\u0001H\u0016J\u0012\u0010\t\u001a\u00020\u00012\b\u00107\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u0004H\u0016J\u0010\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\u001aH\u0016J\b\u0010=\u001a\u00020\u001aH\u0003J\b\u0010>\u001a\u00020\u001aH\u0003J3\u0010\u0013\u001a\u00020\u00012)\u0010?\u001a%\u0012\u001b\u0012\u0019\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0014H\u0016J+\u0010\u001b\u001a\u00020\u00012!\u0010?\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001a0\u0014H\u0016J\u0012\u0010\u001f\u001a\u00020\u00012\b\u00107\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010@\u001a\u00020\rH\u0016J\u0012\u0010!\u001a\u00020\u00012\b\b\u0001\u0010@\u001a\u00020\rH\u0016J\u0012\u0010\"\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00012\u0006\u0010A\u001a\u00020$H\u0016J\u0012\u0010B\u001a\u00020\u00012\b\u0010C\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010%\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010D\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010)\u001a\u00020\u00012\b\u00107\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010E\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010*\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010+\u001a\u00020\u00012\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R3\u0010\u0013\u001a'\u0012\u001b\u0012\u0019\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/vector/network/image/glide/GlideProvider;", "Lcom/vector/network/image/Provider;", "()V", "asBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "bytes", "", d.O, "Landroid/graphics/drawable/Drawable;", "fadeIn", "height", "", "interceptors", "", "Lcom/vector/network/image/interceptor/Interceptor;", "iv", "Landroid/widget/ImageView;", "onLoadError", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", e.a, "", "onLoadReady", "b", "path", "", "placeholder", "placeholderDrawable", "res", "reserveUrl", "scaleType", "Lcom/vector/network/image/ScaleType;", "shaper", "Lcom/vector/network/image/Shaper;", "signature", "Lcom/bumptech/glide/signature/ObjectKey;", "src", "thumbnail", "uri", "Landroid/net/Uri;", "url", "width", "addInterceptor", "interceptor", "asDrawable", "checkNotNull", "context", "Landroid/content/Context;", "clear", "clearInterceptor", "drawable", "fadeInEnabled", "enabled", "init", "v", "load", "loadBitmap", "loadDrawable", "action", "id", "type", "setSignature", "s", "size", "storage", "BitmapLoader", "DrawableLoader", "GlideLoader", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GlideProvider implements f {
    private ImageView a;
    @k.e.a.e
    private String b;
    @k.e.a.e

    /* renamed from: c */
    private Uri f7813c;
    @k.e.a.e

    /* renamed from: d */
    private Drawable f7814d;
    @k.e.a.e

    /* renamed from: e */
    private String f7815e;
    @k.e.a.e

    /* renamed from: f */
    private String f7816f;
    @k.e.a.e

    /* renamed from: g */
    private byte[] f7817g;
    @k.e.a.e

    /* renamed from: h */
    private Bitmap f7818h;
    @k.e.a.e

    /* renamed from: i */
    private String f7819i;
    @k.e.a.e

    /* renamed from: j */
    private Drawable f7820j;
    @DrawableRes

    /* renamed from: k */
    private int f7821k;
    @k.e.a.e

    /* renamed from: l */
    private h f7822l;
    @k.e.a.e

    /* renamed from: m */
    private List<c> f7823m;
    private int n;
    private int o;
    @k.e.a.d
    private ScaleType p = ScaleType.CENTER_CROP;
    private int q;
    @k.e.a.e
    private Drawable r;
    private boolean s;
    private boolean t;
    @k.e.a.e
    private l<? super Bitmap, t1> u;
    @k.e.a.e
    private l<? super Exception, t1> v;
    @k.e.a.e
    private e.b.a.u.e w;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b¦\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\u000bH&J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH&R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/vector/network/image/glide/GlideProvider$GlideLoader;", ExifInterface.GPS_DIRECTION_TRUE, "", HiAnalyticsConstant.Direction.REQUEST, "Lcom/vector/network/image/glide/GlideRequest;", "(Lcom/vector/network/image/glide/GlideProvider;Lcom/vector/network/image/glide/GlideRequest;)V", "getReq", "()Lcom/vector/network/image/glide/GlideRequest;", "isActivityDestroy", "", "load", "", "onError", "requestListener", "Lcom/bumptech/glide/request/RequestListener;", "setFadeIn", "setShaper", "setThumbnail", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public abstract class GlideLoader<T> {
        @k.e.a.d
        private final e.t.r.a.l.d<T> a;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[ScaleType.values().length];
                iArr[ScaleType.CENTER_CROP.ordinal()] = 1;
                iArr[ScaleType.FIT_CENTER.ordinal()] = 2;
                iArr[ScaleType.CENTER_INSIDE.ordinal()] = 3;
                a = iArr;
            }
        }

        @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J4\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016JA\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00028\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"com/vector/network/image/glide/GlideProvider$GlideLoader$load$2", "Lcom/bumptech/glide/request/RequestListener;", "onLoadFailed", "", e.a, "Lcom/bumptech/glide/load/engine/GlideException;", bc.f1474i, "", TypedValues.Attributes.S_TARGET, "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Lcom/bumptech/glide/load/DataSource;Z)Z", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class b implements g<T> {
            public final /* synthetic */ GlideProvider a;

            public b(GlideProvider glideProvider) {
                this.a = glideProvider;
            }

            @Override // e.b.a.t.g
            public boolean onLoadFailed(@k.e.a.e GlideException glideException, @k.e.a.e Object obj, @k.e.a.e p<T> pVar, boolean z) {
                l lVar = this.a.v;
                if (lVar == null) {
                    return false;
                }
                lVar.invoke(glideException);
                return false;
            }

            @Override // e.b.a.t.g
            public boolean onResourceReady(T t, @k.e.a.e Object obj, @k.e.a.e p<T> pVar, @k.e.a.e DataSource dataSource, boolean z) {
                if (t instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) t;
                    bitmap.getWidth();
                    bitmap.getHeight();
                    l lVar = this.a.u;
                    if (lVar == null) {
                        return false;
                    }
                    lVar.invoke(t);
                    return false;
                } else if (t instanceof Drawable) {
                    Drawable drawable = (Drawable) t;
                    drawable.getIntrinsicWidth();
                    drawable.getIntrinsicHeight();
                    return false;
                } else {
                    return false;
                }
            }
        }

        public GlideLoader(@k.e.a.d e.t.r.a.l.d<T> dVar) {
            GlideProvider.this = r1;
            this.a = dVar;
        }

        private final boolean b() {
            ImageView imageView = GlideProvider.this.a;
            Objects.requireNonNull(imageView);
            Context context = imageView.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                return activity.isFinishing() || activity.isDestroyed();
            }
            return false;
        }

        private final void f() {
            ArrayList arrayList = new ArrayList();
            List list = GlideProvider.this.f7823m;
            if (list != null) {
                arrayList.add(new e.t.r.a.l.f.c(list));
            }
            if (GlideProvider.this.f7822l == null || (GlideProvider.this.f7822l instanceof e.t.r.a.b)) {
                int i2 = a.a[GlideProvider.this.p.ordinal()];
                if (i2 == 1) {
                    arrayList.add(new e.b.a.p.m.d.l());
                } else if (i2 == 2) {
                    arrayList.add(new s());
                } else if (i2 == 3) {
                    arrayList.add(new m());
                }
            }
            h hVar = GlideProvider.this.f7822l;
            if (hVar instanceof e.t.r.a.a) {
                h hVar2 = GlideProvider.this.f7822l;
                Objects.requireNonNull(hVar2, "null cannot be cast to non-null type com.vector.network.image.CircleShaper");
                e.t.r.a.a aVar = (e.t.r.a.a) hVar2;
                arrayList.add(new CircleCrop(aVar.f(), aVar.e()));
            } else if (hVar instanceof e.t.r.a.b) {
                h hVar3 = GlideProvider.this.f7822l;
                Objects.requireNonNull(hVar3, "null cannot be cast to non-null type com.vector.network.image.CornerShaper");
                arrayList.add(new b0(((e.t.r.a.b) hVar3).d()));
            } else if (hVar instanceof e.t.r.a.e) {
                h hVar4 = GlideProvider.this.f7822l;
                Objects.requireNonNull(hVar4, "null cannot be cast to non-null type com.vector.network.image.IrregularShaper");
                arrayList.add(new IrregularCrop(((e.t.r.a.e) hVar4).d()));
            } else if (hVar instanceof e.t.r.a.g) {
                h hVar5 = GlideProvider.this.f7822l;
                Objects.requireNonNull(hVar5, "null cannot be cast to non-null type com.vector.network.image.RoundCornersShaper");
                e.t.r.a.g gVar = (e.t.r.a.g) hVar5;
                arrayList.add(new e.t.r.a.l.f.b(gVar.h(), gVar.j(), gVar.i(), gVar.g()));
            }
            if (!arrayList.isEmpty()) {
                this.a.L0(new e.b.a.p.d(arrayList));
            }
        }

        @k.e.a.d
        public final e.t.r.a.l.d<T> a() {
            return this.a;
        }

        @SuppressLint({"CheckResult"})
        public final void c() {
            Object obj;
            if (b()) {
                return;
            }
            b bVar = null;
            if (GlideProvider.this.f7821k != 0) {
                this.a.t1(Integer.valueOf(GlideProvider.this.f7821k));
            } else {
                String str = GlideProvider.this.b;
                if (!(str == null || str.length() == 0)) {
                    obj = GlideProvider.this.b;
                } else if (AnyKt.k(GlideProvider.this.f7813c)) {
                    obj = GlideProvider.this.f7813c;
                } else {
                    String str2 = GlideProvider.this.f7819i;
                    if (!(str2 == null || str2.length() == 0)) {
                        obj = GlideProvider.this.f7819i;
                    } else {
                        byte[] bArr = GlideProvider.this.f7817g;
                        if (bArr != null) {
                            r2 = !(bArr.length == 0);
                        }
                        obj = r2 ? GlideProvider.this.f7817g : GlideProvider.this.f7818h != null ? GlideProvider.this.f7818h : AnyKt.k(GlideProvider.this.f7814d) ? GlideProvider.this.f7814d : null;
                    }
                }
                this.a.u1(obj);
            }
            if (GlideProvider.this.s) {
                e();
            }
            if (GlideProvider.this.f7816f != null) {
                g();
            }
            if (GlideProvider.this.q > 0) {
                this.a.y0(GlideProvider.this.q);
            } else if (GlideProvider.this.r != null) {
                this.a.z0(GlideProvider.this.r);
            }
            r.b(Integer.valueOf(GlideProvider.this.n), Integer.valueOf(GlideProvider.this.o), new GlideProvider$GlideLoader$load$1(this));
            if (GlideProvider.this.v != null || GlideProvider.this.u != null) {
                bVar = new b(GlideProvider.this);
                this.a.o1(bVar);
            }
            if (GlideProvider.this.f7815e != null) {
                d(bVar);
            }
            if (GlideProvider.this.f7820j != null) {
                this.a.A(GlideProvider.this.f7820j);
            }
            f();
            if (GlideProvider.this.w != null) {
                this.a.G0(GlideProvider.this.w);
            }
            e.t.r.a.l.d<T> dVar = this.a;
            ImageView imageView = GlideProvider.this.a;
            Objects.requireNonNull(imageView);
            dVar.m1(imageView);
        }

        public abstract void d(@k.e.a.e g<T> gVar);

        public abstract void e();

        public abstract void g();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0004\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001R\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lcom/vector/network/image/glide/GlideProvider$BitmapLoader;", "Lcom/vector/network/image/glide/GlideProvider$GlideLoader;", "Landroid/graphics/Bitmap;", "Lcom/vector/network/image/glide/GlideProvider;", HiAnalyticsConstant.Direction.REQUEST, "Lcom/vector/network/image/glide/GlideRequest;", "(Lcom/vector/network/image/glide/GlideProvider;Lcom/vector/network/image/glide/GlideRequest;)V", "onError", "", "requestListener", "Lcom/bumptech/glide/request/RequestListener;", "setFadeIn", "setThumbnail", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @SuppressLint({"CheckResult"})
    /* loaded from: classes3.dex */
    public final class a extends GlideLoader<Bitmap> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k.e.a.d e.t.r.a.l.d<Bitmap> dVar) {
            super(dVar);
            GlideProvider.this = r1;
        }

        @Override // com.vector.network.image.glide.GlideProvider.GlideLoader
        public void d(@k.e.a.e g<Bitmap> gVar) {
            e.t.r.a.l.d<Bitmap> a = a();
            ImageView imageView = GlideProvider.this.a;
            Objects.requireNonNull(imageView);
            a.d1(e.t.r.a.l.a.k(imageView).m().v1(GlideProvider.this.f7815e).o1(gVar));
        }

        @Override // com.vector.network.image.glide.GlideProvider.GlideLoader
        public void e() {
            a().I1(i.s(new c.a().b(true).a()));
        }

        @Override // com.vector.network.image.glide.GlideProvider.GlideLoader
        public void g() {
            e.t.r.a.l.d<Bitmap> a = a();
            ImageView imageView = GlideProvider.this.a;
            Objects.requireNonNull(imageView);
            a.F1(e.t.r.a.l.a.k(imageView).m().v1(GlideProvider.this.f7816f));
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0004\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001R\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lcom/vector/network/image/glide/GlideProvider$DrawableLoader;", "Lcom/vector/network/image/glide/GlideProvider$GlideLoader;", "Landroid/graphics/drawable/Drawable;", "Lcom/vector/network/image/glide/GlideProvider;", HiAnalyticsConstant.Direction.REQUEST, "Lcom/vector/network/image/glide/GlideRequest;", "(Lcom/vector/network/image/glide/GlideProvider;Lcom/vector/network/image/glide/GlideRequest;)V", "onError", "", "requestListener", "Lcom/bumptech/glide/request/RequestListener;", "setFadeIn", "setThumbnail", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @SuppressLint({"CheckResult"})
    /* loaded from: classes3.dex */
    public final class b extends GlideLoader<Drawable> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@k.e.a.d e.t.r.a.l.d<Drawable> dVar) {
            super(dVar);
            GlideProvider.this = r1;
        }

        @Override // com.vector.network.image.glide.GlideProvider.GlideLoader
        public void d(@k.e.a.e g<Drawable> gVar) {
            e.t.r.a.l.d<Drawable> a = a();
            ImageView imageView = GlideProvider.this.a;
            Objects.requireNonNull(imageView);
            a.d1(e.t.r.a.l.a.k(imageView).k(GlideProvider.this.f7815e).o1(gVar));
        }

        @Override // com.vector.network.image.glide.GlideProvider.GlideLoader
        public void e() {
            a().I1(e.b.a.p.m.f.c.r(new c.a().b(true).a()));
        }

        @Override // com.vector.network.image.glide.GlideProvider.GlideLoader
        public void g() {
            e.t.r.a.l.d<Drawable> a = a();
            ImageView imageView = GlideProvider.this.a;
            Objects.requireNonNull(imageView);
            a.F1(e.t.r.a.l.a.k(imageView).k(GlideProvider.this.f7816f));
        }
    }

    private final boolean U(Context context) {
        if (context != null) {
            if (!(context instanceof FragmentActivity)) {
                if (context instanceof ContextThemeWrapper) {
                    return U(((ContextThemeWrapper) context).getBaseContext());
                }
                return true;
            }
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            if (!fragmentActivity.isDestroyed() && !fragmentActivity.isFinishing()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"CheckResult"})
    private final void V() {
        ImageView imageView = this.a;
        Objects.requireNonNull(imageView);
        new a(e.t.r.a.l.a.k(imageView).m()).c();
    }

    @SuppressLint({"CheckResult"})
    private final void W() {
        ImageView imageView = this.a;
        Objects.requireNonNull(imageView);
        new b(e.t.r.a.l.a.k(imageView).n().o1(new k())).c();
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f a(@k.e.a.e Drawable drawable) {
        this.f7821k = 0;
        this.f7813c = null;
        this.f7817g = null;
        this.f7819i = null;
        this.b = null;
        this.f7818h = null;
        this.f7814d = drawable;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f c(int i2, int i3) {
        this.n = i2;
        this.o = i3;
        return this;
    }

    @Override // e.t.r.a.f
    public void clear() {
        ImageView imageView = this.a;
        Objects.requireNonNull(imageView);
        if (U(imageView.getContext())) {
            ImageView imageView2 = this.a;
            Objects.requireNonNull(imageView2);
            e.t.r.a.l.e k2 = e.t.r.a.l.a.k(imageView2);
            ImageView imageView3 = this.a;
            Objects.requireNonNull(imageView3);
            k2.q(imageView3);
        }
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f d(@k.e.a.e Bitmap bitmap) {
        this.f7818h = bitmap;
        this.f7813c = null;
        this.b = null;
        this.f7817g = null;
        this.f7819i = null;
        this.f7821k = 0;
        this.f7814d = null;
        return this;
    }

    @Override // e.t.r.a.f
    public void e() {
        ImageView imageView = this.a;
        Objects.requireNonNull(imageView);
        if (U(imageView.getContext())) {
            if (this.t) {
                V();
            } else {
                W();
            }
        }
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f f(@k.e.a.e String str) {
        this.f7815e = str;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f g(@k.e.a.d l<? super Exception, t1> lVar) {
        this.v = lVar;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f h(@k.e.a.d ScaleType scaleType) {
        this.p = scaleType;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f i(boolean z) {
        this.s = z;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f j(@k.e.a.d h hVar) {
        this.f7822l = hVar;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f k(@k.e.a.d e.t.r.a.n.c cVar) {
        if (this.f7823m == null) {
            this.f7823m = new ArrayList();
        }
        List<e.t.r.a.n.c> list = this.f7823m;
        if (list != null) {
            list.add(cVar);
        }
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f l(@k.e.a.e String str) {
        this.f7816f = str;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f m(@k.e.a.e String str) {
        this.w = str == null || str.length() == 0 ? null : new e.b.a.u.e(str);
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f n(@k.e.a.e Uri uri) {
        this.f7813c = uri;
        this.b = null;
        this.f7817g = null;
        this.f7819i = null;
        this.f7821k = 0;
        this.f7814d = null;
        this.f7818h = null;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f o(@k.e.a.e Drawable drawable) {
        this.r = drawable;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f p(@k.e.a.d l<? super Bitmap, t1> lVar) {
        this.u = lVar;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f q() {
        List<e.t.r.a.n.c> list = this.f7823m;
        if (list != null) {
            list.clear();
        }
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f r(@k.e.a.e String str) {
        this.f7819i = str;
        this.f7813c = null;
        this.f7817g = null;
        this.f7821k = 0;
        this.b = null;
        this.f7818h = null;
        this.f7814d = null;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f s(int i2) {
        if (i2 != 0) {
            this.q = i2;
        }
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f t(@k.e.a.e byte[] bArr) {
        this.f7817g = bArr;
        this.f7813c = null;
        this.f7821k = 0;
        this.f7819i = null;
        this.b = null;
        this.f7818h = null;
        this.f7814d = null;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f u(@k.e.a.e Drawable drawable) {
        this.f7820j = drawable;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f url(@k.e.a.e String str) {
        this.b = str;
        this.f7813c = null;
        this.f7817g = null;
        this.f7819i = null;
        this.f7821k = 0;
        this.f7814d = null;
        this.f7818h = null;
        return this;
    }

    @Override // e.t.r.a.f
    public void v(@k.e.a.d ImageView imageView) {
        this.a = imageView;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f w(@DrawableRes int i2) {
        this.f7821k = i2;
        this.f7813c = null;
        this.f7817g = null;
        this.f7819i = null;
        this.b = null;
        this.f7818h = null;
        this.f7814d = null;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f x() {
        this.t = false;
        return this;
    }

    @Override // e.t.r.a.f
    @k.e.a.d
    public f y() {
        this.t = true;
        return this;
    }
}
