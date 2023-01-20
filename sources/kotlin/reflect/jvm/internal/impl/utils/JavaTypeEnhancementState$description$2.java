package kotlin.reflect.jvm.internal.impl.utils;

import h.k2.u.a;
import h.k2.v.f0;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class JavaTypeEnhancementState$description$2 extends Lambda implements a<String[]> {
    public final /* synthetic */ JavaTypeEnhancementState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaTypeEnhancementState$description$2(JavaTypeEnhancementState javaTypeEnhancementState) {
        super(0);
        this.this$0 = javaTypeEnhancementState;
    }

    @Override // h.k2.u.a
    @d
    public final String[] invoke() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.this$0.d().getDescription());
        ReportLevel f2 = this.this$0.f();
        if (f2 != null) {
            arrayList.add(f0.C("under-migration:", f2.getDescription()));
        }
        for (Map.Entry<String, ReportLevel> entry : this.this$0.g().entrySet()) {
            arrayList.add('@' + entry.getKey() + ':' + entry.getValue().getDescription());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }
}
