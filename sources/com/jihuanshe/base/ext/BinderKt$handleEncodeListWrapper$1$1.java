package com.jihuanshe.base.ext;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import e.l.h.i.b;
import e.n.f;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0016\b\u0001\u0010\u0003*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u0001H\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_DIRECTION_TRUE, "Lcom/jihuanshe/base/model/EncodeData;", "Lcom/jihuanshe/base/model/ListWrapper;", AdvanceSetting.NETWORK_TYPE}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BinderKt$handleEncodeListWrapper$1$1 extends Lambda implements l<T, t1> {
    public final /* synthetic */ f<List<E>> $live;
    public final /* synthetic */ boolean $refresh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderKt$handleEncodeListWrapper$1$1(boolean z, f<List<E>> fVar) {
        super(1);
        this.$refresh = z;
        this.$live = fVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Object obj) {
        invoke((b) obj);
        return t1.a;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    public final void invoke(@e b bVar) {
        e.l.h.i.e eVar;
        e.l.h.i.e eVar2;
        List list = null;
        if (this.$refresh) {
            MutableLiveData mutableLiveData = this.$live;
            if (bVar != null && (eVar2 = (e.l.h.i.e) bVar.a()) != null) {
                list = eVar2.b();
            }
            mutableLiveData.setValue(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        List list2 = (List) this.$live.getValue();
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.E();
        }
        arrayList.addAll(list2);
        if (bVar != null && (eVar = (e.l.h.i.e) bVar.a()) != null) {
            list = eVar.b();
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.E();
        }
        arrayList.addAll(list);
        this.$live.setValue(arrayList);
    }
}
