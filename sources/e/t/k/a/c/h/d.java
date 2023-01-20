package e.t.k.a.c.h;

import androidx.fragment.app.Fragment;
import com.qiniu.android.collect.ReportItem;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a]\u0010\u0000\u001a\u00020\u00012P\u0010\u0002\u001a)\u0012%\b\u0001\u0012!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n0\u0003\"!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n¢\u0006\u0002\u0010\u000b\u001aE\u0010\u0000\u001a\u00020\u00012+\u0010\f\u001a'\u0012#\u0012!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n0\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r\u001aV\u0010\u0000\u001a\u00020\u00012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2<\u0010\u0010\u001a8\u0012)\u0012'\u0012#\u0012!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n0\u0011\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\u0002\b\u0013\u001ao\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052<\u0010\u0010\u001a8\u0012)\u0012'\u0012#\u0012!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n0\u0011\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\u0002\b\u0013¢\u0006\u0002\u0010\u0017\u001aX\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052%\u0010\u0019\u001a!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n¢\u0006\u0002\u0010\u0017*@\u0010\u001a\"\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00042\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¨\u0006\u001b"}, d2 = {"pagerListOf", "Lcom/vector/design/ui/adapter/pager/Pager;", "constructor", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "Landroidx/fragment/app/Fragment;", "Lcom/vector/design/ui/adapter/pager/Constructor;", "([Lkotlin/jvm/functions/Function1;)Lcom/vector/design/ui/adapter/pager/Pager;", "cs", "", "titles", "", ReportItem.LogTypeBlock, "", "", "Lkotlin/ExtensionFunctionType;", "pagerListOfIndex", "count", "requiredCurrentItem", "(ILjava/util/List;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lcom/vector/design/ui/adapter/pager/Pager;", "pagerOfIndex", "c", "Constructor", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    @k.e.a.d
    public static final c a(@k.e.a.d List<? extends l<? super Integer, ? extends Fragment>> list, @e List<String> list2) {
        return c.f14558f.a().g(list2).b(list).a();
    }

    @k.e.a.d
    public static final c b(@e List<String> list, @k.e.a.d l<? super List<l<Integer, Fragment>>, t1> lVar) {
        ArrayList arrayList = new ArrayList();
        lVar.invoke(arrayList);
        return c.f14558f.a().g(list).b(arrayList).a();
    }

    @k.e.a.d
    public static final c c(@k.e.a.d l<? super Integer, ? extends Fragment>... lVarArr) {
        return c.f14558f.a().c((l[]) Arrays.copyOf(lVarArr, lVarArr.length)).a();
    }

    public static /* synthetic */ c d(List list, List list2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            list2 = null;
        }
        return a(list, list2);
    }

    public static /* synthetic */ c e(List list, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = null;
        }
        return b(list, lVar);
    }

    @k.e.a.d
    public static final c f(int i2, @e List<String> list, @e Integer num, @k.e.a.d l<? super List<l<Integer, Fragment>>, t1> lVar) {
        ArrayList arrayList = new ArrayList();
        lVar.invoke(arrayList);
        return c.f14558f.a().f(i2).g(list).b(arrayList).d(num).a();
    }

    public static /* synthetic */ c g(int i2, List list, Integer num, l lVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = null;
        }
        if ((i3 & 4) != 0) {
            num = null;
        }
        return f(i2, list, num, lVar);
    }

    @k.e.a.d
    public static final c h(int i2, @e List<String> list, @e Integer num, @k.e.a.d l<? super Integer, ? extends Fragment> lVar) {
        return c.f14558f.a().f(i2).g(list).d(num).e(lVar).a();
    }

    public static /* synthetic */ c i(int i2, List list, Integer num, l lVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = null;
        }
        if ((i3 & 4) != 0) {
            num = null;
        }
        return h(i2, list, num, lVar);
    }
}
