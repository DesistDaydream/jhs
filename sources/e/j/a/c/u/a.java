package e.j.a.c.u;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class a extends MenuBuilder {
    @NonNull
    private final Class<?> a;
    private final int b;

    public a(@NonNull Context context, @NonNull Class<?> cls, int i2) {
        super(context);
        this.a = cls;
        this.b = i2;
    }

    public int a() {
        return this.b;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    @NonNull
    public MenuItem addInternal(int i2, int i3, int i4, @NonNull CharSequence charSequence) {
        if (size() + 1 <= this.b) {
            stopDispatchingItemsChanged();
            MenuItem addInternal = super.addInternal(i2, i3, i4, charSequence);
            if (addInternal instanceof MenuItemImpl) {
                ((MenuItemImpl) addInternal).setExclusiveCheckable(true);
            }
            startDispatchingItemsChanged();
            return addInternal;
        }
        String simpleName = this.a.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.b + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int i2, int i3, int i4, @NonNull CharSequence charSequence) {
        throw new UnsupportedOperationException(this.a.getSimpleName() + " does not support submenus");
    }
}
