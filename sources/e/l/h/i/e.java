package e.l.h.i;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\"\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/jihuanshe/base/model/ListWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "currentPage", "", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "data", "", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "lastPage", "getLastPage", "setLastPage", "total", "getTotal", "()Ljava/lang/Integer;", "setTotal", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class e<T> {
    @e.j.e.r.c("data")
    @k.e.a.e
    private List<? extends T> a;
    @e.j.e.r.c("current_page")
    private int b;
    @e.j.e.r.c("last_page")

    /* renamed from: c  reason: collision with root package name */
    private int f12126c;
    @e.j.e.r.c("total")
    @k.e.a.e

    /* renamed from: d  reason: collision with root package name */
    private Integer f12127d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12128e;

    public final int a() {
        return this.b;
    }

    @k.e.a.e
    public final List<T> b() {
        return (List<? extends T>) this.a;
    }

    public final boolean c() {
        return this.b < this.f12126c;
    }

    public final int d() {
        return this.f12126c;
    }

    @k.e.a.e
    public final Integer e() {
        return this.f12127d;
    }

    public final void f(int i2) {
        this.b = i2;
    }

    public final void g(@k.e.a.e List<? extends T> list) {
        this.a = list;
    }

    public final void h(boolean z) {
        this.f12128e = z;
    }

    public final void i(int i2) {
        this.f12126c = i2;
    }

    public final void j(@k.e.a.e Integer num) {
        this.f12127d = num;
    }
}
