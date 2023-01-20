package com.vector.ext.bind;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.k2.u.p;
import h.p2.n;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\b\b\u0001\u0010\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", am.aI, "<anonymous parameter 1>", "Lkotlin/reflect/KProperty;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BindViewKt$optional$2 extends Lambda implements p<T, n<?>, List<? extends V>> {
    public final /* synthetic */ p<T, Integer, View> $finder;
    public final /* synthetic */ int[] $ids;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BindViewKt$optional$2(int[] iArr, p<? super T, ? super Integer, ? extends View> pVar) {
        super(2);
        this.$ids = iArr;
        this.$finder = pVar;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, n<?> nVar) {
        return invoke2((BindViewKt$optional$2) obj, nVar);
    }

    @d
    /* renamed from: invoke */
    public final List<V> invoke2(T t, @d n<?> nVar) {
        int[] iArr = this.$ids;
        p<T, Integer, View> pVar = this.$finder;
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(pVar.invoke(t, Integer.valueOf(i2)));
        }
        return CollectionsKt___CollectionsKt.f2(arrayList);
    }
}
