package kotlin.reflect.jvm.internal;

import h.k2.u.l;
import h.p2.b0.g.s.c;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"computeFieldCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KPropertyImplKt$computeCallerForAccessor$3 extends Lambda implements l<Field, c<? extends Field>> {
    public final /* synthetic */ boolean $isGetter;
    public final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$1 $isJvmStaticProperty$1;
    public final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$2 $isNotNullProperty$2;
    public final /* synthetic */ KPropertyImpl.a $this_computeCallerForAccessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImplKt$computeCallerForAccessor$3(KPropertyImpl.a aVar, boolean z, KPropertyImplKt$computeCallerForAccessor$2 kPropertyImplKt$computeCallerForAccessor$2, KPropertyImplKt$computeCallerForAccessor$1 kPropertyImplKt$computeCallerForAccessor$1) {
        super(1);
        this.$this_computeCallerForAccessor = aVar;
        this.$isGetter = z;
        this.$isNotNullProperty$2 = kPropertyImplKt$computeCallerForAccessor$2;
        this.$isJvmStaticProperty$1 = kPropertyImplKt$computeCallerForAccessor$1;
    }

    @Override // h.k2.u.l
    @d
    public final c<Field> invoke(@d Field field) {
        boolean e2;
        e2 = KPropertyImplKt.e(this.$this_computeCallerForAccessor.N().J());
        return (e2 || !Modifier.isStatic(field.getModifiers())) ? this.$isGetter ? this.$this_computeCallerForAccessor.L() ? new c.f.a(field, KPropertyImplKt.d(this.$this_computeCallerForAccessor)) : new c.f.C0429c(field) : this.$this_computeCallerForAccessor.L() ? new c.g.a(field, this.$isNotNullProperty$2.invoke2(), KPropertyImplKt.d(this.$this_computeCallerForAccessor)) : new c.g.C0430c(field, this.$isNotNullProperty$2.invoke2()) : this.$isJvmStaticProperty$1.invoke2() ? this.$isGetter ? this.$this_computeCallerForAccessor.L() ? new c.f.b(field) : new c.f.d(field) : this.$this_computeCallerForAccessor.L() ? new c.g.b(field, this.$isNotNullProperty$2.invoke2()) : new c.g.d(field, this.$isNotNullProperty$2.invoke2()) : this.$isGetter ? new c.f.e(field) : new c.g.e(field, this.$isNotNullProperty$2.invoke2());
    }
}
