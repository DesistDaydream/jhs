package h.k2.v;

import java.util.List;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KVariance;

/* loaded from: classes3.dex */
public class o0 {
    private static final String a = "kotlin.jvm.functions.";

    public h.p2.d a(Class cls) {
        return new s(cls);
    }

    public h.p2.d b(Class cls, String str) {
        return new s(cls);
    }

    public h.p2.i c(FunctionReference functionReference) {
        return functionReference;
    }

    public h.p2.d d(Class cls) {
        return new s(cls);
    }

    public h.p2.d e(Class cls, String str) {
        return new s(cls);
    }

    public h.p2.h f(Class cls, String str) {
        return new l0(cls, str);
    }

    public h.p2.k g(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public h.p2.l h(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public h.p2.m i(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public h.p2.o j(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public h.p2.p k(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public h.p2.q l(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    @h.s0(version = "1.3")
    public String m(b0 b0Var) {
        String obj = b0Var.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith(a) ? obj.substring(21) : obj;
    }

    @h.s0(version = "1.1")
    public String n(Lambda lambda) {
        return m(lambda);
    }

    @h.s0(version = "1.4")
    public void o(h.p2.s sVar, List<h.p2.r> list) {
        ((v0) sVar).b(list);
    }

    @h.s0(version = "1.4")
    public h.p2.r p(h.p2.g gVar, List<h.p2.t> list, boolean z) {
        return new TypeReference(gVar, list, z);
    }

    @h.s0(version = "1.4")
    public h.p2.s q(Object obj, String str, KVariance kVariance, boolean z) {
        return new v0(obj, str, kVariance, z);
    }
}
