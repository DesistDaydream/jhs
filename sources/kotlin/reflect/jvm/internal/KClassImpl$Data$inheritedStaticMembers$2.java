package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$Data$inheritedStaticMembers$2 extends Lambda implements a<Collection<? extends KCallableImpl<?>>> {
    public final /* synthetic */ KClassImpl.Data this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$inheritedStaticMembers$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // h.k2.u.a
    public final Collection<? extends KCallableImpl<?>> invoke() {
        KClassImpl kClassImpl = KClassImpl.this;
        return kClassImpl.M(kClassImpl.b0(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
    }
}
