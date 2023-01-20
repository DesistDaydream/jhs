package h.e2.k.a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import h.s0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002\u001a\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\bH\u0001¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\bH\u0001¢\u0006\u0002\b\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class e {
    private static final int a = 1;

    private static final void a(int i2, int i3) {
        if (i3 <= i2) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i2 + ", got " + i3 + ". Please update the Kotlin standard library.").toString());
    }

    private static final d b(BaseContinuationImpl baseContinuationImpl) {
        return (d) baseContinuationImpl.getClass().getAnnotation(d.class);
    }

    private static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField(TTDownloadField.TT_LABEL);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @h.k2.g(name = "getSpilledVariableFieldMapping")
    @k.e.a.e
    @s0(version = "1.3")
    public static final String[] d(@k.e.a.d BaseContinuationImpl baseContinuationImpl) {
        d b = b(baseContinuationImpl);
        if (b != null) {
            a(1, b.v());
            ArrayList arrayList = new ArrayList();
            int c2 = c(baseContinuationImpl);
            int[] i2 = b.i();
            int length = i2.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (i2[i3] == c2) {
                    arrayList.add(b.s()[i3]);
                    arrayList.add(b.n()[i3]);
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (String[]) array;
        }
        return null;
    }

    @h.k2.g(name = "getStackTraceElement")
    @k.e.a.e
    @s0(version = "1.3")
    public static final StackTraceElement e(@k.e.a.d BaseContinuationImpl baseContinuationImpl) {
        String str;
        d b = b(baseContinuationImpl);
        if (b != null) {
            a(1, b.v());
            int c2 = c(baseContinuationImpl);
            int i2 = c2 < 0 ? -1 : b.l()[c2];
            String b2 = g.f14859c.b(baseContinuationImpl);
            if (b2 == null) {
                str = b.c();
            } else {
                str = b2 + Attributes.InternalPrefix + b.c();
            }
            return new StackTraceElement(str, b.m(), b.f(), i2);
        }
        return null;
    }
}
