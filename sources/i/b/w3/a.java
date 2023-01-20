package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0005R\u001e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0013\u0010\u0012\u001a\u00020\u000f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014¨\u0006\u0018"}, d2 = {"Li/b/w3/a;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lh/t1;", "c", "()V", "element", am.av, "(Ljava/lang/Object;)V", com.huawei.hms.push.e.a, "()Ljava/lang/Object;", "b", "", "[Ljava/lang/Object;", MessageKey.CUSTOM_LAYOUT_ELEMENTS, "", e.j.a.b.c.f.f10128d, "()Z", "isEmpty", "", ExpandableTextView.P, "head", "tail", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class a<T> {
    private Object[] a = new Object[16];
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f15876c;

    private final void c() {
        Object[] objArr = this.a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        h.a2.n.l1(objArr, objArr2, 0, this.b, 0, 10, null);
        Object[] objArr3 = this.a;
        int length2 = objArr3.length;
        int i2 = this.b;
        h.a2.n.l1(objArr3, objArr2, length2 - i2, 0, i2, 4, null);
        this.a = objArr2;
        this.b = 0;
        this.f15876c = length;
    }

    public final void a(@k.e.a.d T t) {
        Object[] objArr = this.a;
        int i2 = this.f15876c;
        objArr[i2] = t;
        int length = (objArr.length - 1) & (i2 + 1);
        this.f15876c = length;
        if (length == this.b) {
            c();
        }
    }

    public final void b() {
        this.b = 0;
        this.f15876c = 0;
        this.a = new Object[this.a.length];
    }

    public final boolean d() {
        return this.b == this.f15876c;
    }

    @k.e.a.e
    public final T e() {
        int i2 = this.b;
        if (i2 == this.f15876c) {
            return null;
        }
        Object[] objArr = this.a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.b = (i2 + 1) & (objArr.length - 1);
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }
}
