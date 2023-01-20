package com.vector.ext.bind;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.k2.u.p;
import h.p2.n;
import k.e.a.d;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", am.aI, "desc", "Lkotlin/reflect/KProperty;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BindViewKt$required$1 extends Lambda implements p<T, n<?>, V> {
    public final /* synthetic */ p<T, Integer, View> $finder;
    public final /* synthetic */ int $id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BindViewKt$required$1(p<? super T, ? super Integer, ? extends View> pVar, int i2) {
        super(2);
        this.$finder = pVar;
        this.$id = i2;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, n<?> nVar) {
        return invoke2(obj, (n) nVar);
    }

    /* JADX WARN: Incorrect return type in method signature: (TT;Lh/p2/n<*>;)TV; */
    @d
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final View invoke2(Object obj, @d n nVar) {
        View invoke = this.$finder.invoke(obj, Integer.valueOf(this.$id));
        if (invoke != null) {
            return invoke;
        }
        BindViewKt.R(this.$id, nVar);
        throw new KotlinNothingValueException();
    }
}
