package i.b;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.TimeoutKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\n\b\u0001\u0010\u0002 \u0000*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005B\u001d\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Li/b/n3;", "U", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/w3/e0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lh/t1;", "run", "()V", "", "N0", "()Ljava/lang/String;", "", com.huawei.hms.push.e.a, "J", "time", "Lh/e2/c;", "uCont", "<init>", "(JLh/e2/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class n3<U, T extends U> extends i.b.w3.e0<T> implements Runnable {
    @h.k2.d

    /* renamed from: e */
    public final long f15772e;

    public n3(long j2, @k.e.a.d h.e2.c<? super U> cVar) {
        super(cVar.getContext(), cVar);
        this.f15772e = j2;
    }

    @Override // i.b.a, kotlinx.coroutines.JobSupport
    @k.e.a.d
    public String N0() {
        return super.N0() + "(timeMillis=" + this.f15772e + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        Z(TimeoutKt.a(this.f15772e, this));
    }
}
