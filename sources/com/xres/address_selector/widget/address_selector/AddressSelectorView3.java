package com.xres.address_selector.widget.address_selector;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.umeng.analytics.pro.am;
import com.xres.address_selector.R;
import com.xres.address_selector.db.entity.City;
import com.xres.address_selector.db.entity.Province;
import com.xres.address_selector.widget.address_selector.AddressSelectorView3;
import e.i.b.a.i;
import e.j.a.b.c.r.c0;
import e.j.a.c.c0.c;
import e.u.a.g.d.t;
import e.u.a.g.d.v;
import h.k2.h;
import h.k2.u.p;
import h.k2.v.u;
import h.t1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u00106\u001a\u0004\u0018\u00010\f2\b\u00107\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0002\u001a\u00020\u0003J\b\u00108\u001a\u00020*H\u0002J\b\u00109\u001a\u00020*H\u0002J\b\u0010:\u001a\u00020*H\u0002J\b\u0010;\u001a\u00020*H\u0002J\b\u0010<\u001a\u00020*H\u0014J\b\u0010=\u001a\u00020*H\u0014J\b\u0010>\u001a\u00020*H\u0002J\u0010\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020\u0007H\u0002J\b\u0010A\u001a\u00020*H\u0002J(\u0010B\u001a\u00020*2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020%0\u00122\u0012\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0012JB\u0010E\u001a\u00020*2:\u0010#\u001a6\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0$j\u0002`+J \u0010F\u001a\u00020**\u000e\u0012\u0002\b\u00030\u001fj\u0006\u0012\u0002\b\u0003` 2\u0006\u0010G\u001a\u00020\u0007H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001fj\b\u0012\u0004\u0012\u00020\u001c` X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000RF\u0010#\u001a:\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*\u0018\u00010$j\u0004\u0018\u0001`+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00120\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/xres/address_selector/widget/address_selector/AddressSelectorView3;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_provinceCode", "Landroidx/lifecycle/MutableLiveData;", "_provinceRq", "", "adapterCity", "Lcom/xres/address_selector/widget/address_selector/AddressAdapter;", "adapterProvince", "cityLiveData", "Landroidx/lifecycle/LiveData;", "", "Lcom/xres/address_selector/db/entity/City;", "cityObserver", "Landroidx/lifecycle/Observer;", "currentCity", "Lcom/xres/address_selector/db/entity/Division;", "currentProvince", "customView", "Landroid/view/View;", "fragmentCity", "Lcom/xres/address_selector/widget/address_selector/AddressFragment;", "fragmentProvince", "fragments", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "gson", "Lcom/google/gson/Gson;", c0.a.a, "Lkotlin/Function2;", "Lcom/xres/address_selector/db/entity/Province;", "Lkotlin/ParameterName;", "name", "province", "city", "", "Lcom/xres/address_selector/widget/address_selector/OnSelectListener3;", "mediator", "Lcom/google/android/material/tabs/TabLayoutMediator;", "provinceLiveData", "provinceObserver", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "wrapCity", "wrapProvince", "getJson", "fileName", "initAddressData", "initCity", "initListener", "initProvince", "onAttachedToWindow", "onDetachedFromWindow", "onLastSelected", "refreshCity", "provinceCode", "refreshProvince", "setData", am.ax, "c", "setOnSelectCompletedListener", "removeFromIndex", "index", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AddressSelectorView3 extends LinearLayout {
    @e
    private List<Province> a;
    @e
    private List<? extends List<City>> b;
    @e

    /* renamed from: c */
    private p<? super Province, ? super City, t1> f9258c;
    @d

    /* renamed from: d */
    private View f9259d;
    @d

    /* renamed from: e */
    private ViewPager2 f9260e;
    @d

    /* renamed from: f */
    private TabLayout f9261f;
    @d

    /* renamed from: g */
    private c f9262g;
    @d

    /* renamed from: h */
    private final ArrayList<v> f9263h;
    @d

    /* renamed from: i */
    private final Gson f9264i;
    @d

    /* renamed from: j */
    private final t f9265j;
    @d

    /* renamed from: k */
    private final t f9266k;
    @d

    /* renamed from: l */
    private final v f9267l;
    @d

    /* renamed from: m */
    private final v f9268m;
    @e
    private e.u.a.d.a.a n;
    @e
    private e.u.a.d.a.a o;
    @d
    private final MutableLiveData<String> p;
    @d
    private final LiveData<List<Province>> q;
    @d
    private final MutableLiveData<Integer> r;
    @d
    private final LiveData<List<City>> s;
    @d
    private final Observer<List<Province>> t;
    @d
    private final Observer<List<City>> u;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/xres/address_selector/widget/address_selector/AddressSelectorView3$1", "Lcom/github/promeg/pinyinhelper/PinyinMapDict;", "mapping", "", "", "", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a extends i {
        @Override // e.i.b.a.i
        @d
        public Map<String, String[]> c() {
            HashMap hashMap = new HashMap();
            hashMap.put("重", new String[]{"CHONG"});
            hashMap.put("长", new String[]{"CHANG"});
            return hashMap;
        }
    }

    @h
    public AddressSelectorView3(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public AddressSelectorView3(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ AddressSelectorView3(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static final void a(AddressSelectorView3 addressSelectorView3, TabLayout.Tab tab, int i2) {
        String name;
        String name2;
        String str = "请选择";
        if (i2 == 0) {
            e.u.a.d.a.a aVar = addressSelectorView3.n;
            if (aVar != null && (name = aVar.getName()) != null) {
                str = name;
            }
            tab.setText(str);
        } else if (i2 != 1) {
        } else {
            e.u.a.d.a.a aVar2 = addressSelectorView3.o;
            if (aVar2 != null && (name2 = aVar2.getName()) != null) {
                str = name2;
            }
            tab.setText(str);
        }
    }

    public static final LiveData d(AddressSelectorView3 addressSelectorView3, Integer num) {
        List<? extends List<City>> list = addressSelectorView3.b;
        return new MutableLiveData(list == null ? null : list.get(num.intValue()));
    }

    public static final void e(AddressSelectorView3 addressSelectorView3, List list) {
        addressSelectorView3.f9266k.o(list);
    }

    private final void g() {
        this.q.observeForever(this.t);
        this.s.observeForever(this.u);
    }

    private final void h() {
        this.f9266k.n(new View.OnClickListener() { // from class: e.u.a.g.d.q
            {
                AddressSelectorView3.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressSelectorView3.i(AddressSelectorView3.this, view);
            }
        });
    }

    public static final void i(AddressSelectorView3 addressSelectorView3, View view) {
        addressSelectorView3.f9262g.b();
        List<e.u.a.d.a.a> d2 = addressSelectorView3.f9266k.d();
        Object tag = view.getTag();
        Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
        addressSelectorView3.o = d2.get(((Integer) tag).intValue());
        addressSelectorView3.t();
        addressSelectorView3.f9262g.a();
    }

    private final void j() {
        this.f9268m.q().r(new AddressSelectorView3$initListener$1(this));
    }

    private final void k() {
        this.f9263h.add(this.f9267l);
        this.f9265j.n(new View.OnClickListener() { // from class: e.u.a.g.d.r
            {
                AddressSelectorView3.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressSelectorView3.l(AddressSelectorView3.this, view);
            }
        });
    }

    public static final void l(AddressSelectorView3 addressSelectorView3, View view) {
        String code;
        Object tag = view.getTag();
        Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) tag).intValue();
        addressSelectorView3.f9262g.b();
        e.u.a.d.a.a aVar = addressSelectorView3.f9265j.d().get(intValue);
        addressSelectorView3.n = aVar;
        if (aVar != null && (code = aVar.getCode()) != null) {
            addressSelectorView3.w(Integer.parseInt(code));
        }
        addressSelectorView3.y(addressSelectorView3.f9263h, 1);
        addressSelectorView3.f9268m.q().m();
        addressSelectorView3.f9263h.add(1, addressSelectorView3.f9268m);
        addressSelectorView3.o = null;
        addressSelectorView3.f9262g.a();
        addressSelectorView3.f9260e.setCurrentItem(1);
    }

    private final void t() {
        p<? super Province, ? super City, t1> pVar = this.f9258c;
        if (pVar == null) {
            return;
        }
        e.u.a.d.a.a aVar = this.n;
        Objects.requireNonNull(aVar, "null cannot be cast to non-null type com.xres.address_selector.db.entity.Province");
        e.u.a.d.a.a aVar2 = this.o;
        Objects.requireNonNull(aVar2, "null cannot be cast to non-null type com.xres.address_selector.db.entity.City");
        pVar.invoke((Province) aVar, (City) aVar2);
    }

    public static final LiveData u(AddressSelectorView3 addressSelectorView3, String str) {
        return new MutableLiveData(addressSelectorView3.a);
    }

    public static final void v(AddressSelectorView3 addressSelectorView3, List list) {
        addressSelectorView3.f9265j.o(list);
    }

    public final void w(int i2) {
        this.r.setValue(Integer.valueOf(i2));
    }

    private final void x() {
        MutableLiveData<String> mutableLiveData = this.p;
        mutableLiveData.setValue(mutableLiveData.getValue());
    }

    private final void y(ArrayList<?> arrayList, int i2) {
        if (arrayList.size() > i2) {
            while (arrayList.size() != i2) {
                arrayList.remove(i2);
            }
        }
    }

    @e
    public final String f(@e String str, @d Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q.removeObserver(this.t);
        this.s.removeObserver(this.u);
    }

    public final void setOnSelectCompletedListener(@d p<? super Province, ? super City, t1> pVar) {
        this.f9258c = pVar;
    }

    public final void z(@d List<Province> list, @d List<? extends List<City>> list2) {
        this.a = list;
        this.b = list2;
        x();
    }

    @h
    public AddressSelectorView3(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View inflate = LayoutInflater.from(context).inflate(R.layout.address_select_view, (ViewGroup) this, true);
        this.f9259d = inflate;
        this.f9261f = (TabLayout) inflate.findViewById(R.id.tab_as);
        ArrayList<v> arrayList = new ArrayList<>();
        this.f9263h = arrayList;
        this.f9264i = new Gson();
        t tVar = new t();
        this.f9265j = tVar;
        t tVar2 = new t();
        this.f9266k = tVar2;
        this.f9267l = new v(tVar);
        this.f9268m = new v(tVar2);
        e.i.b.a.c.d(e.i.b.a.c.f().d(new a()));
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.p = mutableLiveData;
        this.q = Transformations.switchMap(mutableLiveData, new Function() { // from class: e.u.a.g.d.p
            {
                AddressSelectorView3.this = this;
            }

            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                LiveData u;
                u = AddressSelectorView3.u(AddressSelectorView3.this, (String) obj);
                return u;
            }
        });
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this.r = mutableLiveData2;
        this.s = Transformations.switchMap(mutableLiveData2, new Function() { // from class: e.u.a.g.d.s
            {
                AddressSelectorView3.this = this;
            }

            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                LiveData d2;
                d2 = AddressSelectorView3.d(AddressSelectorView3.this, (Integer) obj);
                return d2;
            }
        });
        this.t = new Observer() { // from class: e.u.a.g.d.n
            {
                AddressSelectorView3.this = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddressSelectorView3.v(AddressSelectorView3.this, (List) obj);
            }
        };
        this.u = new Observer() { // from class: e.u.a.g.d.o
            {
                AddressSelectorView3.this = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddressSelectorView3.e(AddressSelectorView3.this, (List) obj);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AddressSelectorView);
        int color = obtainStyledAttributes.getColor(R.styleable.AddressSelectorView_select_color, e.u.a.f.a.g(this));
        int color2 = obtainStyledAttributes.getColor(R.styleable.AddressSelectorView_tabIndicatorColor, -1);
        tVar.q(color);
        tVar2.q(color);
        TabLayout tabLayout = this.f9261f;
        tabLayout.setBackgroundColor(Color.parseColor(e.u.a.g.c.a));
        tabLayout.setSelectedTabIndicatorColor(color2);
        tabLayout.R(Color.parseColor("#333333"), color);
        obtainStyledAttributes.recycle();
        j();
        k();
        h();
        x();
        ViewPager2 viewPager2 = (ViewPager2) this.f9259d.findViewById(R.id.vp2_as);
        this.f9260e = viewPager2;
        e.u.a.f.e.b(viewPager2, e.u.a.f.a.a(context), arrayList, false);
        c cVar = new c(this.f9261f, this.f9260e, true, false, new c.b() { // from class: e.u.a.g.d.m
            {
                AddressSelectorView3.this = this;
            }

            @Override // e.j.a.c.c0.c.b
            public final void a(TabLayout.Tab tab, int i3) {
                AddressSelectorView3.a(AddressSelectorView3.this, tab, i3);
            }
        });
        this.f9262g = cVar;
        cVar.a();
    }
}
