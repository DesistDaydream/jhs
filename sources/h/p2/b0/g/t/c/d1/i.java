package h.p2.b0.g.t.c.d1;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

/* loaded from: classes3.dex */
public abstract class i extends h.p2.b0.g.t.c.b1.b implements h.p2.b0.g.t.c.k {
    @k.e.a.d
    private final h.p2.b0.g.t.g.f b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.g.f fVar) {
        super(eVar);
        if (eVar == null) {
            A(0);
        }
        if (fVar == null) {
            A(1);
        }
        this.b = fVar;
    }

    private static /* synthetic */ void A(int i2) {
        String str = (i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i2 == 2) {
            objArr[1] = "getName";
        } else if (i2 == 3) {
            objArr[1] = "getOriginal";
        } else if (i2 == 5 || i2 == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i2 != 2 && i2 != 3) {
            if (i2 == 4) {
                objArr[2] = "toString";
            } else if (i2 != 5 && i2 != 6) {
                objArr[2] = "<init>";
            }
        }
        String format = String.format(str, objArr);
        if (i2 != 2 && i2 != 3 && i2 != 5 && i2 != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @k.e.a.d
    public static String f0(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar == null) {
            A(4);
        }
        try {
            String str = DescriptorRenderer.f16753j.s(kVar) + "[" + kVar.getClass().getSimpleName() + TIMMentionEditText.TIM_MENTION_TAG + Integer.toHexString(System.identityHashCode(kVar)) + "]";
            if (str == null) {
                A(5);
            }
            return str;
        } catch (Throwable unused) {
            String str2 = kVar.getClass().getSimpleName() + ExpandableTextView.N + kVar.getName();
            if (str2 == null) {
                A(6);
            }
            return str2;
        }
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.k a() {
        return this;
    }

    @Override // h.p2.b0.g.t.c.a0
    @k.e.a.d
    public h.p2.b0.g.t.g.f getName() {
        h.p2.b0.g.t.g.f fVar = this.b;
        if (fVar == null) {
            A(2);
        }
        return fVar;
    }

    public String toString() {
        return f0(this);
    }
}
