package com.vector.fitter;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import h.k2.v.u;
import h.w;
import h.z;
import java.util.WeakHashMap;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u0007H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/vector/fitter/FitResources;", "Landroid/content/res/Resources;", "mode", "Lcom/vector/fitter/Mode;", "res", "(Lcom/vector/fitter/Mode;Landroid/content/res/Resources;)V", "metrics", "Landroid/util/DisplayMetrics;", "getMetrics", "()Landroid/util/DisplayMetrics;", "metrics$delegate", "Lkotlin/Lazy;", "getMode", "()Lcom/vector/fitter/Mode;", "getDisplayMetrics", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FitResources extends Resources {
    @d

    /* renamed from: c  reason: collision with root package name */
    public static final a f7811c = new a(null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final WeakHashMap<Mode, Resources> f7812d = new WeakHashMap<>();
    @d
    private final Mode a;
    @d
    private final w b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/vector/fitter/FitResources$Companion;", "", "()V", "ref", "Ljava/util/WeakHashMap;", "Lcom/vector/fitter/Mode;", "Landroid/content/res/Resources;", "clear", "", "mode", "get", "base", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public final void a(@d Mode mode) {
            FitResources.f7812d.remove(mode);
        }

        @d
        public final Resources b(@d Mode mode, @d Resources resources) {
            Resources resources2 = (Resources) FitResources.f7812d.get(mode);
            if (resources2 == null) {
                FitResources fitResources = new FitResources(mode, resources, null);
                FitResources.f7812d.put(mode, fitResources);
                return fitResources;
            }
            return resources2;
        }
    }

    private FitResources(Mode mode, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = mode;
        this.b = z.c(new FitResources$metrics$2(this));
    }

    public /* synthetic */ FitResources(Mode mode, Resources resources, u uVar) {
        this(mode, resources);
    }

    private final DisplayMetrics c() {
        return (DisplayMetrics) this.b.getValue();
    }

    @d
    public final Mode d() {
        return this.a;
    }

    @Override // android.content.res.Resources
    @d
    public DisplayMetrics getDisplayMetrics() {
        return c();
    }
}
