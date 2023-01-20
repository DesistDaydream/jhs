package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.u.l;
import h.k2.u.p;
import h.q2.m;
import h.q2.q;
import h.t1;
import java.util.Iterator;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010\f\u001a\u00020\r*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\n\u001a3\u0010\u000f\u001a\u00020\u0010*\u00020\u00032!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00100\u0012H\u0086\bø\u0001\u0000\u001aH\u0010\u0015\u001a\u00020\u0010*\u00020\u000326\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00100\u0016H\u0086\bø\u0001\u0000\u001a\u0015\u0010\u0018\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH\u0086\u0002\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u0003H\u0086\b\u001a\r\u0010\u001a\u001a\u00020\r*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001d\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u001e\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\n\u001a\u0017\u0010\u001f\u001a\u00020\u0010*\u00020 2\b\b\u0001\u0010\b\u001a\u00020\tH\u0086\b\u001a5\u0010!\u001a\u00020\u0010*\u00020 2\b\b\u0003\u0010\"\u001a\u00020\t2\b\b\u0003\u0010#\u001a\u00020\t2\b\b\u0003\u0010$\u001a\u00020\t2\b\b\u0003\u0010%\u001a\u00020\tH\u0086\b\u001a5\u0010&\u001a\u00020\u0010*\u00020 2\b\b\u0003\u0010'\u001a\u00020\t2\b\b\u0003\u0010#\u001a\u00020\t2\b\b\u0003\u0010(\u001a\u00020\t2\b\b\u0003\u0010%\u001a\u00020\tH\u0087\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u0016\u0010\b\u001a\u00020\t*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "descendants", "getDescendants", "size", "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", "view", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", "left", "top", "right", "bottom", "updateMarginsRelative", MessageKey.MSG_ACCEPT_TIME_START, MessageKey.MSG_ACCEPT_TIME_END, "core-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ViewGroupKt {
    public static final boolean contains(@d ViewGroup viewGroup, @d View view) {
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(@d ViewGroup viewGroup, @d l<? super View, t1> lVar) {
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            lVar.invoke(viewGroup.getChildAt(i2));
            if (i3 >= childCount) {
                return;
            }
            i2 = i3;
        }
    }

    public static final void forEachIndexed(@d ViewGroup viewGroup, @d p<? super Integer, ? super View, t1> pVar) {
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            pVar.invoke(Integer.valueOf(i2), viewGroup.getChildAt(i2));
            if (i3 >= childCount) {
                return;
            }
            i2 = i3;
        }
    }

    @d
    public static final View get(@d ViewGroup viewGroup, int i2) {
        View childAt = viewGroup.getChildAt(i2);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + viewGroup.getChildCount());
    }

    @d
    public static final m<View> getChildren(@d final ViewGroup viewGroup) {
        return new m<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // h.q2.m
            @d
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    @d
    public static final m<View> getDescendants(@d ViewGroup viewGroup) {
        return q.e(new ViewGroupKt$descendants$1(viewGroup, null));
    }

    public static final int getSize(@d ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(@d ViewGroup viewGroup) {
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(@d ViewGroup viewGroup) {
        return viewGroup.getChildCount() != 0;
    }

    @d
    public static final Iterator<View> iterator(@d ViewGroup viewGroup) {
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void minusAssign(@d ViewGroup viewGroup, @d View view) {
        viewGroup.removeView(view);
    }

    public static final void plusAssign(@d ViewGroup viewGroup, @d View view) {
        viewGroup.addView(view);
    }

    public static final void setMargins(@d ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2) {
        marginLayoutParams.setMargins(i2, i2, i2, i2);
    }

    public static final void updateMargins(@d ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        marginLayoutParams.setMargins(i2, i3, i4, i5);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.leftMargin;
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.rightMargin;
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMargins(i2, i3, i4, i5);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(@d ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.getMarginStart();
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.getMarginEnd();
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }
}
