package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface;
import h.a2.y;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.q2.m;
import h.q2.o;
import h.r0;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.random.Random;

@d(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {}, l = {CameraInterface.TYPE_CAPTURE}, m = "invokeSuspend", n = {}, s = {})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class SequencesKt__SequencesKt$shuffled$1 extends RestrictedSuspendLambda implements p<o<? super T>, c<? super t1>, Object> {
    public final /* synthetic */ Random $random;
    public final /* synthetic */ m $this_shuffled;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$shuffled$1(m mVar, Random random, c cVar) {
        super(2, cVar);
        this.$this_shuffled = mVar;
        this.$random = random;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.$this_shuffled, this.$random, cVar);
        sequencesKt__SequencesKt$shuffled$1.L$0 = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((SequencesKt__SequencesKt$shuffled$1) create(obj, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        List W2;
        o oVar;
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            W2 = SequencesKt___SequencesKt.W2(this.$this_shuffled);
            oVar = (o) this.L$0;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            W2 = (List) this.L$1;
            oVar = (o) this.L$0;
            r0.n(obj);
        }
        while (!W2.isEmpty()) {
            int nextInt = this.$random.nextInt(W2.size());
            Object N0 = y.N0(W2);
            if (nextInt < W2.size()) {
                N0 = W2.set(nextInt, N0);
            }
            this.L$0 = oVar;
            this.L$1 = W2;
            this.label = 1;
            if (oVar.d(N0, this) == h2) {
                return h2;
            }
        }
        return t1.a;
    }
}
