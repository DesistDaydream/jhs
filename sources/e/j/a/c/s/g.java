package e.j.a.c.s;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ParcelableSparseArray;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class g implements MenuPresenter {
    private static final String w = "android:menu:list";
    private static final String x = "android:menu:adapter";
    private static final String y = "android:menu:header";
    private NavigationMenuView a;
    public LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private MenuPresenter.Callback f10977c;

    /* renamed from: d  reason: collision with root package name */
    public MenuBuilder f10978d;

    /* renamed from: e  reason: collision with root package name */
    private int f10979e;

    /* renamed from: f  reason: collision with root package name */
    public c f10980f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f10981g;

    /* renamed from: h  reason: collision with root package name */
    public int f10982h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10983i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f10984j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f10985k;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f10986l;

    /* renamed from: m  reason: collision with root package name */
    public int f10987m;
    public int n;
    public int o;
    public boolean p;
    private int r;
    private int s;
    public int t;
    public boolean q = true;
    private int u = -1;
    public final View.OnClickListener v = new a();

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            g.this.B(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            g gVar = g.this;
            boolean performItemAction = gVar.f10978d.performItemAction(itemData, gVar, 0);
            if (itemData != null && itemData.isCheckable() && performItemAction) {
                g.this.f10980f.j(itemData);
            } else {
                z = false;
            }
            g.this.B(false);
            if (z) {
                g.this.updateMenuView(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends RecyclerView.Adapter<l> {

        /* renamed from: e  reason: collision with root package name */
        private static final String f10988e = "android:menu:checked";

        /* renamed from: f  reason: collision with root package name */
        private static final String f10989f = "android:menu:action_views";

        /* renamed from: g  reason: collision with root package name */
        private static final int f10990g = 0;

        /* renamed from: h  reason: collision with root package name */
        private static final int f10991h = 1;

        /* renamed from: i  reason: collision with root package name */
        private static final int f10992i = 2;

        /* renamed from: j  reason: collision with root package name */
        private static final int f10993j = 3;
        private final ArrayList<e> a = new ArrayList<>();
        private MenuItemImpl b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10994c;

        public c() {
            h();
        }

        private void a(int i2, int i3) {
            while (i2 < i3) {
                ((C0371g) this.a.get(i2)).b = true;
                i2++;
            }
        }

        private void h() {
            if (this.f10994c) {
                return;
            }
            this.f10994c = true;
            this.a.clear();
            this.a.add(new d());
            int i2 = -1;
            int size = g.this.f10978d.getVisibleItems().size();
            boolean z = false;
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                MenuItemImpl menuItemImpl = g.this.f10978d.getVisibleItems().get(i4);
                if (menuItemImpl.isChecked()) {
                    j(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.setExclusiveCheckable(false);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i4 != 0) {
                            this.a.add(new f(g.this.t, 0));
                        }
                        this.a.add(new C0371g(menuItemImpl));
                        int size2 = this.a.size();
                        int size3 = subMenu.size();
                        boolean z2 = false;
                        for (int i5 = 0; i5 < size3; i5++) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i5);
                            if (menuItemImpl2.isVisible()) {
                                if (!z2 && menuItemImpl2.getIcon() != null) {
                                    z2 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.setExclusiveCheckable(false);
                                }
                                if (menuItemImpl.isChecked()) {
                                    j(menuItemImpl);
                                }
                                this.a.add(new C0371g(menuItemImpl2));
                            }
                        }
                        if (z2) {
                            a(size2, this.a.size());
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i2) {
                        i3 = this.a.size();
                        z = menuItemImpl.getIcon() != null;
                        if (i4 != 0) {
                            i3++;
                            ArrayList<e> arrayList = this.a;
                            int i6 = g.this.t;
                            arrayList.add(new f(i6, i6));
                        }
                    } else if (!z && menuItemImpl.getIcon() != null) {
                        a(i3, this.a.size());
                        z = true;
                    }
                    C0371g c0371g = new C0371g(menuItemImpl);
                    c0371g.b = z;
                    this.a.add(c0371g);
                    i2 = groupId;
                }
            }
            this.f10994c = false;
        }

        @NonNull
        public Bundle b() {
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.b;
            if (menuItemImpl != null) {
                bundle.putInt(f10988e, menuItemImpl.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = this.a.get(i2);
                if (eVar instanceof C0371g) {
                    MenuItemImpl a = ((C0371g) eVar).a();
                    View actionView = a != null ? a.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray(f10989f, sparseArray);
            return bundle;
        }

        public MenuItemImpl c() {
            return this.b;
        }

        public int d() {
            int i2 = g.this.b.getChildCount() == 0 ? 0 : 1;
            for (int i3 = 0; i3 < g.this.f10980f.getItemCount(); i3++) {
                if (g.this.f10980f.getItemViewType(i3) == 0) {
                    i2++;
                }
            }
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public void onBindViewHolder(@NonNull l lVar, int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((TextView) lVar.itemView).setText(((C0371g) this.a.get(i2)).a().getTitle());
                    return;
                } else if (itemViewType != 2) {
                    return;
                } else {
                    f fVar = (f) this.a.get(i2);
                    lVar.itemView.setPadding(0, fVar.b(), 0, fVar.a());
                    return;
                }
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.itemView;
            navigationMenuItemView.setIconTintList(g.this.f10985k);
            g gVar = g.this;
            if (gVar.f10983i) {
                navigationMenuItemView.setTextAppearance(gVar.f10982h);
            }
            ColorStateList colorStateList = g.this.f10984j;
            if (colorStateList != null) {
                navigationMenuItemView.setTextColor(colorStateList);
            }
            Drawable drawable = g.this.f10986l;
            ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            C0371g c0371g = (C0371g) this.a.get(i2);
            navigationMenuItemView.setNeedsEmptyIcon(c0371g.b);
            navigationMenuItemView.setHorizontalPadding(g.this.f10987m);
            navigationMenuItemView.setIconPadding(g.this.n);
            g gVar2 = g.this;
            if (gVar2.p) {
                navigationMenuItemView.setIconSize(gVar2.o);
            }
            navigationMenuItemView.setMaxLines(g.this.r);
            navigationMenuItemView.initialize(c0371g.a(), 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        /* renamed from: f */
        public l onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                g gVar = g.this;
                return new i(gVar.f10981g, viewGroup, gVar.v);
            } else if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return new b(g.this.b);
                }
                return new j(g.this.f10981g, viewGroup);
            } else {
                return new k(g.this.f10981g, viewGroup);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g */
        public void onViewRecycled(l lVar) {
            if (lVar instanceof i) {
                ((NavigationMenuItemView) lVar.itemView).c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            e eVar = this.a.get(i2);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof C0371g) {
                return ((C0371g) eVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public void i(@NonNull Bundle bundle) {
            MenuItemImpl a;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl a2;
            int i2 = bundle.getInt(f10988e, 0);
            if (i2 != 0) {
                this.f10994c = true;
                int size = this.a.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    e eVar = this.a.get(i3);
                    if ((eVar instanceof C0371g) && (a2 = ((C0371g) eVar).a()) != null && a2.getItemId() == i2) {
                        j(a2);
                        break;
                    }
                    i3++;
                }
                this.f10994c = false;
                h();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(f10989f);
            if (sparseParcelableArray != null) {
                int size2 = this.a.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    e eVar2 = this.a.get(i4);
                    if ((eVar2 instanceof C0371g) && (a = ((C0371g) eVar2).a()) != null && (actionView = a.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void j(@NonNull MenuItemImpl menuItemImpl) {
            if (this.b == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            MenuItemImpl menuItemImpl2 = this.b;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.b = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        public void k(boolean z) {
            this.f10994c = z;
        }

        public void update() {
            h();
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements e {
    }

    /* loaded from: classes2.dex */
    public interface e {
    }

    /* loaded from: classes2.dex */
    public static class f implements e {
        private final int a;
        private final int b;

        public f(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    /* renamed from: e.j.a.c.s.g$g  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0371g implements e {
        private final MenuItemImpl a;
        public boolean b;

        public C0371g(MenuItemImpl menuItemImpl) {
            this.a = menuItemImpl;
        }

        public MenuItemImpl a() {
            return this.a;
        }
    }

    /* loaded from: classes2.dex */
    public class h extends RecyclerViewAccessibilityDelegate {
        public h(@NonNull RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(g.this.f10980f.d(), 0, false));
        }
    }

    /* loaded from: classes2.dex */
    public static class i extends l {
        public i(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* loaded from: classes2.dex */
    public static class j extends l {
        public j(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* loaded from: classes2.dex */
    public static class k extends l {
        public k(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class l extends RecyclerView.ViewHolder {
        public l(View view) {
            super(view);
        }
    }

    private void C() {
        int i2 = (this.b.getChildCount() == 0 && this.q) ? this.s : 0;
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    public void A(int i2) {
        this.u = i2;
        NavigationMenuView navigationMenuView = this.a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i2);
        }
    }

    public void B(boolean z) {
        c cVar = this.f10980f;
        if (cVar != null) {
            cVar.k(z);
        }
    }

    public void b(@NonNull View view) {
        this.b.addView(view);
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void c(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.s != systemWindowInsetTop) {
            this.s = systemWindowInsetTop;
            C();
        }
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.b, windowInsetsCompat);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Nullable
    public MenuItemImpl d() {
        return this.f10980f.c();
    }

    public int e() {
        return this.b.getChildCount();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public View f(int i2) {
        return this.b.getChildAt(i2);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Nullable
    public Drawable g() {
        return this.f10986l;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f10979e;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f10981g.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.a));
            if (this.f10980f == null) {
                this.f10980f = new c();
            }
            int i2 = this.u;
            if (i2 != -1) {
                this.a.setOverScrollMode(i2);
            }
            this.b = (LinearLayout) this.f10981g.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.a, false);
            this.a.setAdapter(this.f10980f);
        }
        return this.a;
    }

    public int h() {
        return this.f10987m;
    }

    public int i() {
        return this.n;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.f10981g = LayoutInflater.from(context);
        this.f10978d = menuBuilder;
        this.t = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public int j() {
        return this.r;
    }

    @Nullable
    public ColorStateList k() {
        return this.f10984j;
    }

    @Nullable
    public ColorStateList l() {
        return this.f10985k;
    }

    public View m(@LayoutRes int i2) {
        View inflate = this.f10981g.inflate(i2, (ViewGroup) this.b, false);
        b(inflate);
        return inflate;
    }

    public boolean n() {
        return this.q;
    }

    public void o(@NonNull View view) {
        this.b.removeView(view);
        if (this.b.getChildCount() == 0) {
            NavigationMenuView navigationMenuView = this.a;
            navigationMenuView.setPadding(0, this.s, 0, navigationMenuView.getPaddingBottom());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.f10977c;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle(x);
            if (bundle2 != null) {
                this.f10980f.i(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray(y);
            if (sparseParcelableArray2 != null) {
                this.b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f10980f;
        if (cVar != null) {
            bundle.putBundle(x, cVar.b());
        }
        if (this.b != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray(y, sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void p(boolean z) {
        if (this.q != z) {
            this.q = z;
            C();
        }
    }

    public void q(@NonNull MenuItemImpl menuItemImpl) {
        this.f10980f.j(menuItemImpl);
    }

    public void r(int i2) {
        this.f10979e = i2;
    }

    public void s(@Nullable Drawable drawable) {
        this.f10986l = drawable;
        updateMenuView(false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.f10977c = callback;
    }

    public void t(int i2) {
        this.f10987m = i2;
        updateMenuView(false);
    }

    public void u(int i2) {
        this.n = i2;
        updateMenuView(false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        c cVar = this.f10980f;
        if (cVar != null) {
            cVar.update();
        }
    }

    public void v(@Dimension int i2) {
        if (this.o != i2) {
            this.o = i2;
            this.p = true;
            updateMenuView(false);
        }
    }

    public void w(@Nullable ColorStateList colorStateList) {
        this.f10985k = colorStateList;
        updateMenuView(false);
    }

    public void x(int i2) {
        this.r = i2;
        updateMenuView(false);
    }

    public void y(@StyleRes int i2) {
        this.f10982h = i2;
        this.f10983i = true;
        updateMenuView(false);
    }

    public void z(@Nullable ColorStateList colorStateList) {
        this.f10984j = colorStateList;
        updateMenuView(false);
    }
}
