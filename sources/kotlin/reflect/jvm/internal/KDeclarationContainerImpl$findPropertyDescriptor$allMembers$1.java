package kotlin.reflect.jvm.internal;

import h.k2.u.l;
import h.p2.b0.g.o;
import h.p2.b0.g.t.c.j0;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1 extends Lambda implements l<j0, CharSequence> {
    public static final KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1 INSTANCE = new KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1();

    public KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final CharSequence invoke(@d j0 j0Var) {
        return DescriptorRenderer.f16753j.s(j0Var) + " | " + o.b.f(j0Var).a();
    }
}
