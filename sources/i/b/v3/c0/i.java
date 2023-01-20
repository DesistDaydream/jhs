package i.b.v3.c0;

import com.tencent.qcloud.tuicore.TUIConstants;
import com.umeng.analytics.pro.am;
import h.p0;
import kotlin.Metadata;
import kotlinx.coroutines.flow.internal.AbortFlowException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbortFlowException;", "Li/b/v3/f;", TUIConstants.TUIChat.OWNER, "Lh/t1;", "b", "(Lkotlinx/coroutines/flow/internal/AbortFlowException;Li/b/v3/f;)V", "", "index", am.av, "(I)I", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class i {
    @p0
    public static final int a(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    public static final void b(@k.e.a.d AbortFlowException abortFlowException, @k.e.a.d i.b.v3.f<?> fVar) {
        if (abortFlowException.getOwner() != fVar) {
            throw abortFlowException;
        }
    }
}
