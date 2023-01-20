package h;

import androidx.exifinterface.media.ExifInterface;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@h.e2.g
@o
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J5\u0010\u0005\u001a\u0002H\b\"\u0004\b\u0002\u0010\t\"\u0004\b\u0003\u0010\b*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\n2\u0006\u0010\u0006\u001a\u0002H\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\u00020\r*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0087\u0002\u0082\u0001\u0001\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lkotlin/DeepRecursiveScope;", ExifInterface.GPS_DIRECTION_TRUE, "R", "", "()V", "callRecursive", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ExifInterface.LATITUDE_SOUTH, "U", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "", "Lkotlin/DeepRecursiveScopeImpl;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.4")
/* loaded from: classes3.dex */
public abstract class g<T, R> {
    private g() {
    }

    @k.e.a.e
    public abstract Object b(T t, @k.e.a.d h.e2.c<? super R> cVar);

    @k.e.a.e
    public abstract <U, S> Object c(@k.e.a.d e<U, S> eVar, U u, @k.e.a.d h.e2.c<? super S> cVar);

    @i(level = DeprecationLevel.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @q0(expression = "this.callRecursive(value)", imports = {}))
    @k.e.a.d
    public final Void d(@k.e.a.d e<?, ?> eVar, @k.e.a.e Object obj) {
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }

    public /* synthetic */ g(h.k2.v.u uVar) {
        this();
    }
}
