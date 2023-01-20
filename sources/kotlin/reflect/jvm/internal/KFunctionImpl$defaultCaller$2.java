package kotlin.reflect.jvm.internal;

import h.a2.u;
import h.k2.u.a;
import h.p2.b0.g.o;
import h.p2.b0.g.q;
import h.p2.b0.g.s.b;
import h.p2.b0.g.s.f;
import h.p2.b0.g.t.c.d;
import h.p2.b0.g.t.c.k;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KFunctionImpl$defaultCaller$2 extends Lambda implements a<b<? extends Member>> {
    public final /* synthetic */ KFunctionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl$defaultCaller$2(KFunctionImpl kFunctionImpl) {
        super(0);
        this.this$0 = kFunctionImpl;
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.reflect.Member] */
    @Override // h.k2.u.a
    @e
    /* renamed from: invoke */
    public final b<? extends Member> invoke2() {
        GenericDeclaration genericDeclaration;
        b bVar;
        JvmFunctionSignature g2 = o.b.g(this.this$0.J());
        if (g2 instanceof JvmFunctionSignature.c) {
            JvmFunctionSignature.c cVar = (JvmFunctionSignature.c) g2;
            genericDeclaration = this.this$0.H().F(cVar.c(), cVar.b(), !Modifier.isStatic(this.this$0.G().b().getModifiers()));
        } else if (g2 instanceof JvmFunctionSignature.b) {
            if (this.this$0.K()) {
                Class<?> d2 = this.this$0.H().d();
                List<KParameter> parameters = this.this$0.getParameters();
                ArrayList arrayList = new ArrayList(u.Y(parameters, 10));
                for (KParameter kParameter : parameters) {
                    arrayList.add(kParameter.getName());
                }
                return new AnnotationConstructorCaller(d2, arrayList, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            genericDeclaration = this.this$0.H().x(((JvmFunctionSignature.b) g2).b());
        } else if (g2 instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
            List<Method> b = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) g2).b();
            Class<?> d3 = this.this$0.H().d();
            ArrayList arrayList2 = new ArrayList(u.Y(b, 10));
            for (Method method : b) {
                arrayList2.add(method.getName());
            }
            return new AnnotationConstructorCaller(d3, arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, b);
        } else {
            genericDeclaration = null;
        }
        if (genericDeclaration instanceof Constructor) {
            KFunctionImpl kFunctionImpl = this.this$0;
            bVar = kFunctionImpl.R((Constructor) genericDeclaration, kFunctionImpl.J());
        } else if (genericDeclaration instanceof Method) {
            if (this.this$0.J().getAnnotations().c(q.i()) != null) {
                k b2 = this.this$0.J().b();
                Objects.requireNonNull(b2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (!((d) b2).a0()) {
                    bVar = this.this$0.T((Method) genericDeclaration);
                }
            }
            bVar = this.this$0.U((Method) genericDeclaration);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return f.b(bVar, this.this$0.J(), true);
        }
        return null;
    }
}
