package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import i.b.h;
import i.b.t3.c0;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.LONGITUDE_EAST, "Li/b/t3/c0;", "element", "Lh/t1;", am.av, "(Li/b/t3/c0;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class ChannelsKt__ChannelsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> void a(@d c0<? super E> c0Var, E e2) {
        if (c0Var.offer(e2)) {
            return;
        }
        h.b(null, new ChannelsKt__ChannelsKt$sendBlocking$1(c0Var, e2, null), 1, null);
    }
}
