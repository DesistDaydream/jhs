package h.p2.b0.g.t.j;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat;

/* loaded from: classes3.dex */
public interface b {

    /* loaded from: classes3.dex */
    public static final class a {
        public static boolean a(@k.e.a.d b bVar) {
            return bVar.k().getIncludeAnnotationArguments();
        }

        public static boolean b(@k.e.a.d b bVar) {
            return bVar.k().getIncludeEmptyAnnotationArguments();
        }
    }

    void a(boolean z);

    void b(@k.e.a.d ParameterNameRenderingPolicy parameterNameRenderingPolicy);

    void c(boolean z);

    boolean d();

    void e(boolean z);

    void f(boolean z);

    void g(@k.e.a.d RenderingFormat renderingFormat);

    void h(@k.e.a.d AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy);

    @k.e.a.d
    Set<h.p2.b0.g.t.g.c> i();

    boolean j();

    @k.e.a.d
    AnnotationArgumentsRenderingPolicy k();

    void l(@k.e.a.d Set<h.p2.b0.g.t.g.c> set);

    void m(@k.e.a.d Set<? extends DescriptorRendererModifier> set);

    void n(boolean z);

    void o(@k.e.a.d h.p2.b0.g.t.j.a aVar);

    void p(boolean z);

    void q(boolean z);

    void r(boolean z);
}
