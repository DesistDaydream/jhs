package e.l.h.i;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/jihuanshe/base/model/ListModel;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "data", "", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "hasMore", "", "getHasMore", "()I", "setHasMore", "(I)V", "lastId", "", "getLastId", "()Ljava/lang/String;", "setLastId", "(Ljava/lang/String;)V", "total", "getTotal", "setTotal", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class d<T> {
    private int a;
    @e.j.e.r.c("isLoadMore")
    private int b;
    @e.j.e.r.c("last_id")
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private String f12124c = "";
    @e.j.e.r.c("content")
    @k.e.a.e

    /* renamed from: d  reason: collision with root package name */
    private List<? extends T> f12125d;

    @k.e.a.e
    public final List<T> a() {
        return (List<? extends T>) this.f12125d;
    }

    public final int b() {
        return this.b;
    }

    @k.e.a.d
    public final String c() {
        return this.f12124c;
    }

    public final int d() {
        return this.a;
    }

    public final void e(@k.e.a.e List<? extends T> list) {
        this.f12125d = list;
    }

    public final void f(int i2) {
        this.b = i2;
    }

    public final void g(@k.e.a.d String str) {
        this.f12124c = str;
    }

    public final void h(int i2) {
        this.a = i2;
    }
}
