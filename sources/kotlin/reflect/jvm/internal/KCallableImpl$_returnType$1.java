package kotlin.reflect.jvm.internal;

import h.k2.u.a;
import java.lang.reflect.Type;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KCallableImpl$_returnType$1 extends Lambda implements a<KTypeImpl> {
    public final /* synthetic */ KCallableImpl this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "R", "invoke"}, k = 3, mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements a<Type> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // h.k2.u.a
        @d
        public final Type invoke() {
            Type F;
            F = KCallableImpl$_returnType$1.this.this$0.F();
            return F != null ? F : KCallableImpl$_returnType$1.this.this$0.G().getReturnType();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KCallableImpl$_returnType$1(KCallableImpl kCallableImpl) {
        super(0);
        this.this$0 = kCallableImpl;
    }

    @Override // h.k2.u.a
    public final KTypeImpl invoke() {
        return new KTypeImpl(this.this$0.J().getReturnType(), new AnonymousClass1());
    }
}
