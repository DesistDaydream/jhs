package i.b.w3;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001c\u0010\b\u001a\u00020\u00048\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\t"}, d2 = {"", "propertyName", "b", "(Ljava/lang/String;)Ljava/lang/String;", "", am.av, ExpandableTextView.P, "()I", "AVAILABLE_PROCESSORS", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/internal/SystemPropsKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class l0 {
    private static final int a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return a;
    }

    @k.e.a.e
    public static final String b(@k.e.a.d String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
