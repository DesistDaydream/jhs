package e.g.e;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/eth/model/PackList;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "list", "", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class d<T> {
    @k.e.a.d
    private List<? extends T> a = CollectionsKt__CollectionsKt.E();

    @k.e.a.d
    public final List<T> a() {
        return (List<? extends T>) this.a;
    }

    public final void b(@k.e.a.d List<? extends T> list) {
        this.a = list;
    }
}
