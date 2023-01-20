package e.t.r.a;

import android.graphics.drawable.Drawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.internal.bc;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import e.b.a.t.k.p;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J>\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/vector/network/image/SvgSoftwareLayerSetter;", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "()V", "onLoadFailed", "", com.huawei.hms.push.e.a, "Lcom/bumptech/glide/load/engine/GlideException;", bc.f1474i, "", TypedValues.Attributes.S_TARGET, "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class k implements e.b.a.t.g<Drawable> {
    @Override // e.b.a.t.g
    /* renamed from: a */
    public boolean onResourceReady(@k.e.a.e Drawable drawable, @k.e.a.e Object obj, @k.e.a.d p<Drawable> pVar, @k.e.a.e DataSource dataSource, boolean z) {
        ((e.b.a.t.k.j) pVar).b().setLayerType(1, null);
        return false;
    }

    @Override // e.b.a.t.g
    public boolean onLoadFailed(@k.e.a.e GlideException glideException, @k.e.a.e Object obj, @k.e.a.d p<Drawable> pVar, boolean z) {
        ((e.b.a.t.k.j) pVar).b().setLayerType(0, null);
        return false;
    }
}
