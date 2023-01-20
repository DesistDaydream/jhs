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
import com.xres.address_selector.R;
import com.xres.address_selector.db.entity.Area;
import com.xres.address_selector.db.entity.City;
import com.xres.address_selector.db.entity.Province;
import com.xres.address_selector.widget.address_selector.AddressSelectorView2;
import e.i.b.a.i;
import e.j.a.b.c.r.c0;
import e.j.a.c.c0.c;
import e.u.a.g.d.t;
import e.u.a.g.d.v;
import h.k2.h;
import h.k2.u.q;
import h.k2.v.f0;
import h.k2.v.u;
import h.t1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010<\u001a\u0004\u0018\u00010\u000b2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010>\u001a\u000202H\u0002J\b\u0010?\u001a\u000202H\u0002J\b\u0010@\u001a\u000202H\u0002J\b\u0010A\u001a\u000202H\u0002J\b\u0010B\u001a\u000202H\u0002J\b\u0010C\u001a\u000202H\u0014J\b\u0010D\u001a\u000202H\u0014J\b\u0010E\u001a\u000202H\u0002J\u0010\u0010F\u001a\u0002022\u0006\u0010G\u001a\u00020\u000bH\u0002J\u0010\u0010H\u001a\u0002022\u0006\u0010I\u001a\u00020\u000bH\u0002J\b\u0010J\u001a\u000202H\u0002JW\u0010K\u001a\u0002022O\u0010*\u001aK\u0012\u0013\u0012\u00110,¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(1\u0012\u0004\u0012\u0002020+j\u0002`3J \u0010L\u001a\u000202*\u000e\u0012\u0002\b\u00030&j\u0006\u0012\u0002\b\u0003`'2\u0006\u0010M\u001a\u00020\u0007H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00140\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\"0&j\b\u0012\u0004\u0012\u00020\"`'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R[\u0010*\u001aO\u0012\u0013\u0012\u00110,¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010+j\u0004\u0018\u0001`3X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00140\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/xres/address_selector/widget/address_selector/AddressSelectorView2;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_cityCode", "Landroidx/lifecycle/MutableLiveData;", "", "_provinceCode", "_provinceRq", "adapterArea", "Lcom/xres/address_selector/widget/address_selector/AddressAdapter;", "adapterCity", "adapterProvince", "areaLiveData", "Landroidx/lifecycle/LiveData;", "", "Lcom/xres/address_selector/db/entity/Area;", "areaObserver", "Landroidx/lifecycle/Observer;", "cityLiveData", "Lcom/xres/address_selector/db/entity/City;", "cityObserver", "currentArea", "Lcom/xres/address_selector/db/entity/Division;", "currentCity", "currentProvince", "customView", "Landroid/view/View;", "fragmentArea", "Lcom/xres/address_selector/widget/address_selector/AddressFragment;", "fragmentCity", "fragmentProvince", "fragments", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "gson", "Lcom/google/gson/Gson;", c0.a.a, "Lkotlin/Function3;", "Lcom/xres/address_selector/db/entity/Province;", "Lkotlin/ParameterName;", "name", "province", "city", "area", "", "Lcom/xres/address_selector/widget/address_selector/OnSelectListener2;", "mediator", "Lcom/google/android/material/tabs/TabLayoutMediator;", "provinceLiveData", "provinceObserver", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "getJson", "fileName", "initAddressData", "initArea", "initCity", "initListener", "initProvince", "onAttachedToWindow", "onDetachedFromWindow", "onLastSelected", "refreshArea", "cityCode", "refreshCity", "provinceCode", "refreshProvince", "setOnSelectCompletedListener", "removeFromIndex", "index", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AddressSelectorView2 extends LinearLayout {
    @e
    private q<? super Province, ? super City, ? super Area, t1> a;
    @d
    private View b;
    @d

    /* renamed from: c */
    private ViewPager2 f9247c;
    @d

    /* renamed from: d */
    private TabLayout f9248d;
    @d

    /* renamed from: e */
    private c f9249e;
    @d

    /* renamed from: f */
    private final ArrayList<v> f9250f;
    @d

    /* renamed from: g */
    private final Gson f9251g;
    @d

    /* renamed from: h */
    private final t f9252h;
    @d

    /* renamed from: i */
    private final t f9253i;
    @d

    /* renamed from: j */
    private final t f9254j;
    @d

    /* renamed from: k */
    private final v f9255k;
    @d

    /* renamed from: l */
    private final v f9256l;
    @d

    /* renamed from: m */
    private final v f9257m;
    @e
    private e.u.a.d.a.a n;
    @e
    private e.u.a.d.a.a o;
    @e
    private e.u.a.d.a.a p;
    @d
    private final MutableLiveData<String> q;
    @d
    private final LiveData<List<Province>> r;
    @d
    private final MutableLiveData<String> s;
    @d
    private final LiveData<List<City>> t;
    @d
    private final MutableLiveData<String> u;
    @d
    private final LiveData<List<Area>> v;
    @d
    private final Observer<List<Province>> w;
    @d
    private final Observer<List<City>> x;
    @d
    private final Observer<List<Area>> y;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/xres/address_selector/widget/address_selector/AddressSelectorView2$1", "Lcom/github/promeg/pinyinhelper/PinyinMapDict;", "mapping", "", "", "", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/xres/address_selector/widget/address_selector/AddressSelectorView2$provinceLiveData$1$s$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/xres/address_selector/db/entity/Province;", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b extends e.j.e.t.a<List<? extends Province>> {
    }

    @h
    public AddressSelectorView2(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public AddressSelectorView2(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ AddressSelectorView2(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void C() {
        q<? super Province, ? super City, ? super Area, t1> qVar = this.a;
        if (qVar == null) {
            return;
        }
        e.u.a.d.a.a aVar = this.n;
        Objects.requireNonNull(aVar, "null cannot be cast to non-null type com.xres.address_selector.db.entity.Province");
        e.u.a.d.a.a aVar2 = this.o;
        Objects.requireNonNull(aVar2, "null cannot be cast to non-null type com.xres.address_selector.db.entity.City");
        e.u.a.d.a.a aVar3 = this.p;
        Objects.requireNonNull(aVar3, "null cannot be cast to non-null type com.xres.address_selector.db.entity.Area");
        qVar.invoke((Province) aVar, (City) aVar2, (Area) aVar3);
    }

    public static final LiveData D(AddressSelectorView2 addressSelectorView2, Context context, String str) {
        return new MutableLiveData((List) addressSelectorView2.f9251g.o(addressSelectorView2.j("province.json", context), new b().getType()));
    }

    public static final void E(AddressSelectorView2 addressSelectorView2, List list) {
        addressSelectorView2.f9252h.o(list);
    }

    public final void F(String str) {
        this.u.setValue(str);
    }

    public final void G(String str) {
        this.s.setValue(str);
    }

    private final void H() {
        MutableLiveData<String> mutableLiveData = this.q;
        mutableLiveData.setValue(mutableLiveData.getValue());
    }

    private final void I(ArrayList<?> arrayList, int i2) {
        if (arrayList.size() > i2) {
            while (arrayList.size() != i2) {
                arrayList.remove(i2);
            }
        }
    }

    public static final void a(AddressSelectorView2 addressSelectorView2, TabLayout.Tab tab, int i2) {
        String name;
        String name2;
        String name3;
        String str = "请选择";
        if (i2 == 0) {
            e.u.a.d.a.a aVar = addressSelectorView2.n;
            if (aVar != null && (name = aVar.getName()) != null) {
                str = name;
            }
            tab.setText(str);
        } else if (i2 == 1) {
            e.u.a.d.a.a aVar2 = addressSelectorView2.o;
            if (aVar2 != null && (name2 = aVar2.getName()) != null) {
                str = name2;
            }
            tab.setText(str);
        } else if (i2 != 2) {
        } else {
            e.u.a.d.a.a aVar3 = addressSelectorView2.p;
            if (aVar3 != null && (name3 = aVar3.getName()) != null) {
                str = name3;
            }
            tab.setText(str);
        }
    }

    public static final LiveData f(AddressSelectorView2 addressSelectorView2, Context context, String str) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject(addressSelectorView2.j("area.json", context));
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (f0.g(next, str)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                int i2 = 0;
                int length = optJSONArray.length();
                if (length > 0) {
                    while (true) {
                        int i3 = i2 + 1;
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        arrayList.add(new Area(optJSONObject.optString("id"), optJSONObject.optString("name"), next));
                        if (i3 >= length) {
                            break;
                        }
                        i2 = i3;
                    }
                }
            }
        }
        return new MutableLiveData(arrayList);
    }

    public static final void g(AddressSelectorView2 addressSelectorView2, List list) {
        addressSelectorView2.f9254j.o(list);
    }

    public static final LiveData h(AddressSelectorView2 addressSelectorView2, Context context, String str) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject(addressSelectorView2.j("city.json", context));
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (f0.g(next, str)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                int i2 = 0;
                int length = optJSONArray.length();
                if (length > 0) {
                    while (true) {
                        int i3 = i2 + 1;
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        arrayList.add(new City(optJSONObject.optString("id"), optJSONObject.optString("name"), next));
                        if (i3 >= length) {
                            break;
                        }
                        i2 = i3;
                    }
                }
            }
        }
        return new MutableLiveData(arrayList);
    }

    public static final void i(AddressSelectorView2 addressSelectorView2, List list) {
        addressSelectorView2.f9253i.o(list);
    }

    private final void k() {
        this.r.observeForever(this.w);
        this.t.observeForever(this.x);
        this.v.observeForever(this.y);
    }

    private final void l() {
        this.f9254j.n(new View.OnClickListener() { // from class: e.u.a.g.d.j
            {
                AddressSelectorView2.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressSelectorView2.m(AddressSelectorView2.this, view);
            }
        });
    }

    public static final void m(AddressSelectorView2 addressSelectorView2, View view) {
        addressSelectorView2.f9249e.b();
        List<e.u.a.d.a.a> d2 = addressSelectorView2.f9254j.d();
        Object tag = view.getTag();
        Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
        addressSelectorView2.p = d2.get(((Integer) tag).intValue());
        addressSelectorView2.C();
        addressSelectorView2.f9249e.a();
    }

    private final void n() {
        this.f9253i.n(new View.OnClickListener() { // from class: e.u.a.g.d.f
            {
                AddressSelectorView2.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressSelectorView2.o(AddressSelectorView2.this, view);
            }
        });
    }

    public static final void o(AddressSelectorView2 addressSelectorView2, View view) {
        String code;
        addressSelectorView2.f9249e.b();
        List<e.u.a.d.a.a> d2 = addressSelectorView2.f9253i.d();
        Object tag = view.getTag();
        Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
        e.u.a.d.a.a aVar = d2.get(((Integer) tag).intValue());
        addressSelectorView2.o = aVar;
        if (aVar != null && (code = aVar.getCode()) != null) {
            addressSelectorView2.F(code);
        }
        addressSelectorView2.I(addressSelectorView2.f9250f, 2);
        addressSelectorView2.f9257m.q().m();
        addressSelectorView2.f9250f.add(2, addressSelectorView2.f9257m);
        addressSelectorView2.p = null;
        addressSelectorView2.f9249e.a();
        addressSelectorView2.f9247c.setCurrentItem(2);
    }

    private final void p() {
        this.f9256l.q().r(new AddressSelectorView2$initListener$1(this));
        this.f9257m.q().r(new AddressSelectorView2$initListener$2(this));
    }

    private final void q() {
        this.f9250f.add(this.f9255k);
        this.f9252h.n(new View.OnClickListener() { // from class: e.u.a.g.d.c
            {
                AddressSelectorView2.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressSelectorView2.r(AddressSelectorView2.this, view);
            }
        });
    }

    public static final void r(AddressSelectorView2 addressSelectorView2, View view) {
        String code;
        Object tag = view.getTag();
        Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) tag).intValue();
        addressSelectorView2.f9249e.b();
        e.u.a.d.a.a aVar = addressSelectorView2.f9252h.d().get(intValue);
        addressSelectorView2.n = aVar;
        if (aVar != null && (code = aVar.getCode()) != null) {
            addressSelectorView2.G(code);
        }
        addressSelectorView2.I(addressSelectorView2.f9250f, 1);
        addressSelectorView2.f9256l.q().m();
        addressSelectorView2.f9250f.add(1, addressSelectorView2.f9256l);
        addressSelectorView2.o = null;
        addressSelectorView2.f9249e.a();
        addressSelectorView2.f9247c.setCurrentItem(1);
    }

    @e
    public final String j(@e String str, @d Context context) {
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
        k();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r.removeObserver(this.w);
        this.t.removeObserver(this.x);
        this.v.removeObserver(this.y);
    }

    public final void setOnSelectCompletedListener(@d q<? super Province, ? super City, ? super Area, t1> qVar) {
        this.a = qVar;
    }

    @h
    public AddressSelectorView2(@d final Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View inflate = LayoutInflater.from(context).inflate(R.layout.address_select_view, (ViewGroup) this, true);
        this.b = inflate;
        this.f9248d = (TabLayout) inflate.findViewById(R.id.tab_as);
        ArrayList<v> arrayList = new ArrayList<>();
        this.f9250f = arrayList;
        this.f9251g = new Gson();
        t tVar = new t();
        this.f9252h = tVar;
        t tVar2 = new t();
        this.f9253i = tVar2;
        t tVar3 = new t();
        this.f9254j = tVar3;
        this.f9255k = new v(tVar);
        this.f9256l = new v(tVar2);
        this.f9257m = new v(tVar3);
        e.i.b.a.c.d(e.i.b.a.c.f().d(new a()));
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.q = mutableLiveData;
        this.r = Transformations.switchMap(mutableLiveData, new Function() { // from class: e.u.a.g.d.g
            {
                AddressSelectorView2.this = this;
            }

            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                LiveData D;
                D = AddressSelectorView2.D(AddressSelectorView2.this, context, (String) obj);
                return D;
            }
        });
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this.s = mutableLiveData2;
        this.t = Transformations.switchMap(mutableLiveData2, new Function() { // from class: e.u.a.g.d.l
            {
                AddressSelectorView2.this = this;
            }

            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                LiveData h2;
                h2 = AddressSelectorView2.h(AddressSelectorView2.this, context, (String) obj);
                return h2;
            }
        });
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this.u = mutableLiveData3;
        this.v = Transformations.switchMap(mutableLiveData3, new Function() { // from class: e.u.a.g.d.h
            {
                AddressSelectorView2.this = this;
            }

            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                LiveData f2;
                f2 = AddressSelectorView2.f(AddressSelectorView2.this, context, (String) obj);
                return f2;
            }
        });
        this.w = new Observer() { // from class: e.u.a.g.d.k
            {
                AddressSelectorView2.this = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddressSelectorView2.E(AddressSelectorView2.this, (List) obj);
            }
        };
        this.x = new Observer() { // from class: e.u.a.g.d.i
            {
                AddressSelectorView2.this = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddressSelectorView2.i(AddressSelectorView2.this, (List) obj);
            }
        };
        this.y = new Observer() { // from class: e.u.a.g.d.d
            {
                AddressSelectorView2.this = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddressSelectorView2.g(AddressSelectorView2.this, (List) obj);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AddressSelectorView);
        int color = obtainStyledAttributes.getColor(R.styleable.AddressSelectorView_select_color, e.u.a.f.a.g(this));
        int color2 = obtainStyledAttributes.getColor(R.styleable.AddressSelectorView_tabIndicatorColor, -1);
        tVar.q(color);
        tVar2.q(color);
        tVar3.q(color);
        TabLayout tabLayout = this.f9248d;
        tabLayout.setBackgroundColor(Color.parseColor(e.u.a.g.c.a));
        tabLayout.setSelectedTabIndicatorColor(color2);
        tabLayout.R(Color.parseColor("#333333"), color);
        obtainStyledAttributes.recycle();
        p();
        q();
        n();
        l();
        H();
        ViewPager2 viewPager2 = (ViewPager2) this.b.findViewById(R.id.vp2_as);
        this.f9247c = viewPager2;
        e.u.a.f.e.b(viewPager2, e.u.a.f.a.a(context), arrayList, false);
        c cVar = new c(this.f9248d, this.f9247c, true, false, new c.b() { // from class: e.u.a.g.d.e
            {
                AddressSelectorView2.this = this;
            }

            @Override // e.j.a.c.c0.c.b
            public final void a(TabLayout.Tab tab, int i3) {
                AddressSelectorView2.a(AddressSelectorView2.this, tab, i3);
            }
        });
        this.f9249e = cVar;
        cVar.a();
    }
}
