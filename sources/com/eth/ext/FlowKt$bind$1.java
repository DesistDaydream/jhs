package com.eth.ext;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.p;
import java.util.ArrayList;
import java.util.List;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00012\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0001H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_EAST, "", "old", "new"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FlowKt$bind$1 extends Lambda implements p<T, T, T> {
    public final /* synthetic */ boolean $refresh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt$bind$1(boolean z) {
        super(2);
        this.$refresh = z;
    }

    /* JADX WARN: Incorrect return type in method signature: (TT;TT;)TT; */
    @Override // h.k2.u.p
    @e
    public final List invoke(@e List list, @e List list2) {
        if (this.$refresh) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            list = CollectionsKt__CollectionsKt.E();
        }
        arrayList.addAll(list);
        if (list2 == null) {
            return arrayList;
        }
        arrayList.addAll(list2);
        return arrayList;
    }
}
