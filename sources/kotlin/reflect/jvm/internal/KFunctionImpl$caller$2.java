package kotlin.reflect.jvm.internal;

import h.a2.u;
import h.k2.u.a;
import h.p2.b0.g.o;
import h.p2.b0.g.q;
import h.p2.b0.g.s.b;
import h.p2.b0.g.s.f;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KFunctionImpl$caller$2 extends Lambda implements a<b<? extends Member>> {
    public final /* synthetic */ KFunctionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl$caller$2(KFunctionImpl kFunctionImpl) {
        super(0);
        this.this$0 = kFunctionImpl;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke */
    public final b<? extends Member> invoke2() {
        Object b;
        b S;
        JvmFunctionSignature g2 = o.b.g(this.this$0.J());
        if (g2 instanceof JvmFunctionSignature.b) {
            if (this.this$0.K()) {
                Class<?> d2 = this.this$0.H().d();
                List<KParameter> parameters = this.this$0.getParameters();
                ArrayList arrayList = new ArrayList(u.Y(parameters, 10));
                for (KParameter kParameter : parameters) {
                    arrayList.add(kParameter.getName());
                }
                return new AnnotationConstructorCaller(d2, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            b = this.this$0.H().t(((JvmFunctionSignature.b) g2).b());
        } else if (g2 instanceof JvmFunctionSignature.c) {
            JvmFunctionSignature.c cVar = (JvmFunctionSignature.c) g2;
            b = this.this$0.H().H(cVar.c(), cVar.b());
        } else if (g2 instanceof JvmFunctionSignature.a) {
            b = ((JvmFunctionSignature.a) g2).b();
        } else if (!(g2 instanceof JvmFunctionSignature.JavaConstructor)) {
            if (g2 instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                List<Method> b2 = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) g2).b();
                Class<?> d3 = this.this$0.H().d();
                ArrayList arrayList2 = new ArrayList(u.Y(b2, 10));
                for (Method method : b2) {
                    arrayList2.add(method.getName());
                }
                return new AnnotationConstructorCaller(d3, arrayList2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, b2);
            }
            throw new NoWhenBranchMatchedException();
        } else {
            b = ((JvmFunctionSignature.JavaConstructor) g2).b();
        }
        if (b instanceof Constructor) {
            KFunctionImpl kFunctionImpl = this.this$0;
            S = kFunctionImpl.R((Constructor) b, kFunctionImpl.J());
        } else if (b instanceof Method) {
            Method method2 = (Method) b;
            S = !Modifier.isStatic(method2.getModifiers()) ? this.this$0.S(method2) : this.this$0.J().getAnnotations().c(q.i()) != null ? this.this$0.T(method2) : this.this$0.U(method2);
        } else {
            throw new KotlinReflectionInternalError("Could not compute caller for function: " + this.this$0.J() + " (member = " + b + ')');
        }
        return f.c(S, this.this$0.J(), false, 2, null);
    }
}
