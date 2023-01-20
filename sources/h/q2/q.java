package h.q2;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.internal.bp;
import com.qiniu.android.collect.ReportItem;
import h.q0;
import h.s0;
import h.t1;
import java.util.Iterator;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aN\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2/\b\t\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aN\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\n0\u0014\"\u0004\b\u0000\u0010\n2/\b\t\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aM\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2/\b\u0001\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aM\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\n0\u0014\"\u0004\b\u0000\u0010\n2/\b\u0001\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0007\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000*V\b\u0007\u0010\u0019\u001a\u0004\b\u0000\u0010\n\"\b\u0012\u0004\u0012\u0002H\n0\r2\b\u0012\u0004\u0012\u0002H\n0\rB6\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u001c\b\u001d\u0012\u0018\b\u000bB\u0014\b\u001e\u0012\u0006\b\u001f\u0012\u0002\b\f\u0012\b\b \u0012\u0004\b\b(!\u0012\n\b\"\u0012\u0006\b\n0#8$*\f\b\u0002\u0010%\"\u00020\u00012\u00020\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"State_Done", "", "Lkotlin/sequences/State;", "State_Failed", "State_ManyNotReady", "State_ManyReady", "State_NotReady", "State_Ready", "buildIterator", "", ExifInterface.GPS_DIRECTION_TRUE, "builderAction", "Lkotlin/Function2;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "buildSequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "iterator", ReportItem.LogTypeBlock, "sequence", "SequenceBuilder", "Lkotlin/Deprecated;", "message", "Use SequenceScope class instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "SequenceScope<T>", "level", "Lkotlin/DeprecationLevel;", bp.f1533l, "State", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes4.dex */
public class q {
    private static final int a = 0;
    private static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f15661c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f15662d = 3;

    /* renamed from: e  reason: collision with root package name */
    private static final int f15663e = 4;

    /* renamed from: f  reason: collision with root package name */
    private static final int f15664f = 5;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class a implements m<T> {
        public final /* synthetic */ h.k2.u.p a;

        public a(h.k2.u.p pVar) {
            this.a = pVar;
        }

        @Override // h.q2.m
        @k.e.a.d
        public Iterator<T> iterator() {
            return q.d(this.a);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class b implements m<T> {
        public final /* synthetic */ h.k2.u.p a;

        public b(h.k2.u.p pVar) {
            this.a = pVar;
        }

        @Override // h.q2.m
        @k.e.a.d
        public Iterator<T> iterator() {
            return q.d(this.a);
        }
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Use SequenceScope class instead.", replaceWith = @q0(expression = "SequenceScope<T>", imports = {}))
    public static /* synthetic */ void a() {
    }

    @h.g2.f
    @h.i(level = DeprecationLevel.ERROR, message = "Use 'iterator { }' function instead.", replaceWith = @q0(expression = "iterator(builderAction)", imports = {}))
    @s0(version = "1.3")
    private static final <T> Iterator<T> b(@h.b h.k2.u.p<? super o<? super T>, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        return d(pVar);
    }

    @h.g2.f
    @h.i(level = DeprecationLevel.ERROR, message = "Use 'sequence { }' function instead.", replaceWith = @q0(expression = "sequence(builderAction)", imports = {}))
    @s0(version = "1.3")
    private static final <T> m<T> c(@h.b h.k2.u.p<? super o<? super T>, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        return new a(pVar);
    }

    @s0(version = "1.3")
    @k.e.a.d
    public static final <T> Iterator<T> d(@h.b @k.e.a.d h.k2.u.p<? super o<? super T>, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        n nVar = new n();
        nVar.r(IntrinsicsKt__IntrinsicsJvmKt.c(pVar, nVar, nVar));
        return nVar;
    }

    @s0(version = "1.3")
    @k.e.a.d
    public static final <T> m<T> e(@h.b @k.e.a.d h.k2.u.p<? super o<? super T>, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        return new b(pVar);
    }
}
