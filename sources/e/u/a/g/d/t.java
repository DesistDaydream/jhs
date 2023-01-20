package e.u.a.g.d;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import com.xres.address_selector.R;
import h.k2.v.f0;
import h.t1;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010)\u001a\u00020#H\u0002J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140+J\b\u0010,\u001a\u00020\u0007H\u0016J\u0018\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0007H\u0016J\u0018\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0007H\u0016J\u0006\u00104\u001a\u00020#J\u0014\u00105\u001a\u00020#2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00140+J\u0016\u00107\u001a\u00020#2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020#\u0018\u00010\"j\u0004\u0018\u0001`$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00069"}, d2 = {"Lcom/xres/address_selector/widget/address_selector/AddressAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/xres/address_selector/widget/address_selector/AddressAdapter$MyViewHolder;", "()V", "capIndexMap", "", "", "", "getCapIndexMap", "()Ljava/util/Map;", "clickListener", "Landroid/view/View$OnClickListener;", "Lcom/xres/address_selector/ext/ClickCallback;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "currentClickPosition", "dataList", "", "Lcom/xres/address_selector/db/entity/Division;", "value", "Lcom/xres/address_selector/widget/address_selector/DataPreparedListener;", "preparedListener", "getPreparedListener", "()Lcom/xres/address_selector/widget/address_selector/DataPreparedListener;", "setPreparedListener", "(Lcom/xres/address_selector/widget/address_selector/DataPreparedListener;)V", "selectedColor", "getSelectedColor", "()I", "setSelectedColor", "(I)V", "visibleListener", "Lkotlin/Function0;", "", "Lcom/xres/address_selector/widget/address_selector/HostVisibleListener;", "getVisibleListener", "()Lkotlin/jvm/functions/Function0;", "setVisibleListener", "(Lkotlin/jvm/functions/Function0;)V", "computeCapIndex", "getDataList", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetClickPosition", "setDataList", "list", "sortAddressName", "MyViewHolder", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public final class t extends RecyclerView.Adapter<a> {
    @k.e.a.e
    private View.OnClickListener a;
    @k.e.a.e
    private y b;
    @k.e.a.e

    /* renamed from: c */
    private h.k2.u.a<t1> f14726c;

    /* renamed from: d */
    private int f14727d = -1;

    /* renamed from: e */
    private int f14728e = -16776961;
    @k.e.a.d

    /* renamed from: f */
    private final Map<String, Integer> f14729f = new LinkedHashMap();
    @k.e.a.d

    /* renamed from: g */
    private List<e.u.a.d.a.a> f14730g = new ArrayList();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/xres/address_selector/widget/address_selector/AddressAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "root", "Landroid/view/View;", "(Landroid/view/View;)V", "nameView", "Landroid/widget/TextView;", "getNameView", "()Landroid/widget/TextView;", "getRoot", "()Landroid/view/View;", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a extends RecyclerView.ViewHolder {
        @k.e.a.d
        private final View a;
        @k.e.a.d
        private final TextView b;

        public a(@k.e.a.d View view) {
            super(view);
            this.a = view;
            this.b = (TextView) view.findViewById(R.id.tvAddressName);
        }

        @k.e.a.d
        public final TextView a() {
            return this.b;
        }

        @k.e.a.d
        public final View b() {
            return this.a;
        }
    }

    private final void a() {
        this.f14729f.clear();
        List<e.u.a.d.a.a> list = this.f14730g;
        ArrayList arrayList = new ArrayList(h.a2.u.Y(list, 10));
        for (e.u.a.d.a.a aVar : list) {
            arrayList.add(u.a(aVar.getName()));
        }
        int i2 = 0;
        String str = "";
        for (Object obj : arrayList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            String str2 = (String) obj;
            if (!f0.g(str2, str)) {
                b().put(str2, Integer.valueOf(i2));
                str = str2;
            }
            i2 = i3;
        }
    }

    public static /* synthetic */ void h(t tVar, a aVar, View view) {
        l(tVar, aVar, view);
    }

    public static final void l(t tVar, a aVar, View view) {
        tVar.f14727d = aVar.getAdapterPosition();
        tVar.notifyDataSetChanged();
        View.OnClickListener c2 = tVar.c();
        if (c2 == null) {
            return;
        }
        c2.onClick(aVar.a());
    }

    private final void s(List<e.u.a.d.a.a> list) {
        h.a2.x.p0(list, b.a);
    }

    public static final int t(e.u.a.d.a.a aVar, e.u.a.d.a.a aVar2) {
        return u.a(aVar.getName()).compareTo(u.a(aVar2.getName()));
    }

    @k.e.a.d
    public final Map<String, Integer> b() {
        return this.f14729f;
    }

    @k.e.a.e
    public final View.OnClickListener c() {
        return this.a;
    }

    @k.e.a.d
    public final List<e.u.a.d.a.a> d() {
        return this.f14730g;
    }

    @k.e.a.e
    public final y e() {
        return this.b;
    }

    public final int f() {
        return this.f14728e;
    }

    @k.e.a.e
    public final h.k2.u.a<t1> g() {
        return this.f14726c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f14730g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(@k.e.a.d a aVar, int i2) {
        TextView a2 = aVar.a();
        a2.setTextColor(this.f14727d == i2 ? f() : Color.parseColor("#333333"));
        a2.setText(this.f14730g.get(i2).getName());
        a2.setTag(Integer.valueOf(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k.e.a.d
    /* renamed from: k */
    public a onCreateViewHolder(@k.e.a.d ViewGroup viewGroup, int i2) {
        final a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.division_name_item_layout, viewGroup, false));
        aVar.a().setOnClickListener(new View.OnClickListener() { // from class: e.u.a.g.d.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.h(t.this, aVar, view);
            }
        });
        return aVar;
    }

    public final void m() {
        this.f14727d = -1;
    }

    public final void n(@k.e.a.e View.OnClickListener onClickListener) {
        this.a = onClickListener;
    }

    public final void o(@k.e.a.d List<? extends e.u.a.d.a.a> list) {
        y yVar;
        this.f14730g.clear();
        this.f14730g.addAll(list);
        s(this.f14730g);
        a();
        if ((!this.f14729f.isEmpty()) && (yVar = this.b) != null) {
            yVar.a(this.f14729f);
        }
        notifyDataSetChanged();
    }

    public final void p(@k.e.a.e y yVar) {
        if ((!this.f14729f.isEmpty()) && yVar != null) {
            yVar.a(this.f14729f);
        }
        this.b = yVar;
    }

    public final void q(int i2) {
        this.f14728e = i2;
    }

    public final void r(@k.e.a.e h.k2.u.a<t1> aVar) {
        this.f14726c = aVar;
    }
}
