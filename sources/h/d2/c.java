package h.d2;

import h.r;
import h.s0;
import kotlin.Metadata;
import kotlin.contracts.InvocationKind;

@h.g2.b
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\nH'J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'J\b\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lkotlin/contracts/ContractBuilder;", "", "callsInPlace", "Lkotlin/contracts/CallsInPlace;", "R", "lambda", "Lkotlin/Function;", "kind", "Lkotlin/contracts/InvocationKind;", "returns", "Lkotlin/contracts/Returns;", "value", "returnsNotNull", "Lkotlin/contracts/ReturnsNotNull;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.3")
@f
/* loaded from: classes3.dex */
public interface c {

    @Metadata(k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ h.d2.a a(c cVar, r rVar, InvocationKind invocationKind, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    invocationKind = InvocationKind.UNKNOWN;
                }
                return cVar.d(rVar, invocationKind);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
        }
    }

    @h.g2.b
    @k.e.a.d
    g a();

    @h.g2.b
    @k.e.a.d
    g b(@k.e.a.e Object obj);

    @h.g2.b
    @k.e.a.d
    h c();

    @h.g2.b
    @k.e.a.d
    <R> h.d2.a d(@k.e.a.d r<? extends R> rVar, @k.e.a.d InvocationKind invocationKind);
}
