package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.f0;
import h.q2.m;
import h.t1;
import java.util.Iterator;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0002\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\u0002\u001a3\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\bø\u0001\u0000\u001aH\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\bø\u0001\u0000\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\n\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/Menu;)I", "contains", "", "item", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "core-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class MenuKt {
    public static final boolean contains(@d Menu menu, @d MenuItem menuItem) {
        int size = menu.size();
        if (size > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (f0.g(menu.getItem(i2), menuItem)) {
                    return true;
                }
                if (i3 >= size) {
                    break;
                }
                i2 = i3;
            }
        }
        return false;
    }

    public static final void forEach(@d Menu menu, @d l<? super MenuItem, t1> lVar) {
        int size = menu.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            lVar.invoke(menu.getItem(i2));
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    public static final void forEachIndexed(@d Menu menu, @d p<? super Integer, ? super MenuItem, t1> pVar) {
        int size = menu.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            pVar.invoke(Integer.valueOf(i2), menu.getItem(i2));
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    @d
    public static final MenuItem get(@d Menu menu, int i2) {
        return menu.getItem(i2);
    }

    @d
    public static final m<MenuItem> getChildren(@d final Menu menu) {
        return new m<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // h.q2.m
            @d
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(@d Menu menu) {
        return menu.size();
    }

    public static final boolean isEmpty(@d Menu menu) {
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(@d Menu menu) {
        return menu.size() != 0;
    }

    @d
    public static final Iterator<MenuItem> iterator(@d Menu menu) {
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(@d Menu menu, @d MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }
}
