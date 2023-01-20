package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.model.Ranking;
import com.jihuanshe.ui.page.detail.CardPackListActivity;
import com.jihuanshe.viewmodel.detail.CardPackListViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.network.image.NImageView;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class v extends u {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts s;
    @Nullable
    private static final SparseIntArray t;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final LinearLayout f13726m;
    @NonNull
    private final LinearLayout n;
    @Nullable
    private final cf o;
    @NonNull
    private final TextView p;
    @NonNull
    private final TextView q;
    private long r;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(15);
        s = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"view_filter_bar_card_pack"}, new int[]{13}, new int[]{R.layout.view_filter_bar_card_pack});
        SparseIntArray sparseIntArray = new SparseIntArray();
        t = sparseIntArray;
        sparseIntArray.put(R.id.coverIv, 14);
    }

    public v(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, s, t));
    }

    private boolean k(NLive<List<GameCard>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.r |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        CardPackListViewModel cardPackListViewModel;
        long j3;
        int i2;
        String str;
        String str2;
        int i3;
        String str3;
        LayoutManagers.a aVar;
        e.t.j.h.l lVar;
        String str4;
        e.t.j.h.p pVar;
        e.t.j.h.g gVar;
        String str5;
        e.t.j.h.g gVar2;
        String str6;
        int i4;
        int i5;
        e.t.j.h.g gVar3;
        String str7;
        List<GameCard> list;
        e.l.g.g gVar4;
        String str8;
        String str9;
        String str10;
        e.t.j.h.g gVar5;
        LayoutManagers.a aVar2;
        String str11;
        String str12;
        int i6;
        int i7;
        e.t.j.h.g gVar6;
        e.t.j.h.p pVar2;
        e.t.j.h.g gVar7;
        int i8;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        int i9;
        PackDetailResult packDetailResult;
        String str18;
        Integer num;
        String str19;
        Ranking ranking;
        String str20;
        Integer num2;
        synchronized (this) {
            j2 = this.r;
            this.r = 0L;
        }
        CardPackListActivity cardPackListActivity = this.f13662k;
        CardPackListViewModel cardPackListViewModel2 = this.f13663l;
        if ((j2 & 15) != 0) {
            int i10 = ((j2 & 10) > 0L ? 1 : ((j2 & 10) == 0L ? 0 : -1));
            if (i10 != 0) {
                if (cardPackListActivity != null) {
                    packDetailResult = cardPackListActivity.l0();
                    lVar = cardPackListActivity.j0();
                    gVar5 = cardPackListActivity.o0(this.b);
                    aVar2 = cardPackListActivity.d0();
                    gVar6 = cardPackListActivity.h0();
                    pVar2 = cardPackListActivity.k0();
                    gVar7 = cardPackListActivity.g0();
                } else {
                    gVar5 = null;
                    aVar2 = null;
                    packDetailResult = null;
                    lVar = null;
                    gVar6 = null;
                    pVar2 = null;
                    gVar7 = null;
                }
                if (packDetailResult != null) {
                    str18 = packDetailResult.getSpecs();
                    str13 = packDetailResult.getImg();
                    num = packDetailResult.getCardVersionCount();
                    str19 = packDetailResult.getReleasedAt();
                    ranking = packDetailResult.getRanking();
                    str20 = packDetailResult.getNumber();
                    str15 = packDetailResult.getSpecsStr();
                    str16 = packDetailResult.getNameCN();
                    str11 = packDetailResult.getNameOrigin();
                } else {
                    str11 = null;
                    str18 = null;
                    str13 = null;
                    num = null;
                    str19 = null;
                    ranking = null;
                    str20 = null;
                    str15 = null;
                    str16 = null;
                }
                boolean z = str18 == null;
                String string = this.f13656e.getResources().getString(R.string.pack_card_num, num);
                boolean z2 = str19 == null;
                str12 = this.f13661j.getResources().getString(R.string.common_no, str19);
                boolean z3 = str20 == null;
                str14 = string;
                String string2 = this.f13660i.getResources().getString(R.string.common_no, str20);
                if (i10 != 0) {
                    j2 |= z ? 128L : 64L;
                }
                if ((j2 & 10) != 0) {
                    j2 |= z2 ? 2048L : 1024L;
                }
                if ((j2 & 10) != 0) {
                    j2 |= z3 ? 512L : 256L;
                }
                if (ranking != null) {
                    num2 = ranking.getRank();
                    str5 = ranking.getRankTypeName();
                } else {
                    num2 = null;
                    str5 = null;
                }
                i7 = 8;
                i8 = z ? 8 : 0;
                int i11 = z2 ? 8 : 0;
                i6 = z3 ? 8 : 0;
                boolean z4 = num2 == null;
                str17 = string2;
                i9 = i11;
                str10 = this.p.getResources().getString(R.string.card_rank_num, num2);
                if ((j2 & 10) != 0) {
                    j2 |= z4 ? 32L : 16L;
                }
                if (!z4) {
                    i7 = 0;
                }
            } else {
                str10 = null;
                gVar5 = null;
                aVar2 = null;
                str11 = null;
                lVar = null;
                str12 = null;
                str5 = null;
                i6 = 0;
                i7 = 0;
                gVar6 = null;
                pVar2 = null;
                gVar7 = null;
                i8 = 0;
                str13 = null;
                str14 = null;
                str15 = null;
                str16 = null;
                str17 = null;
                i9 = 0;
            }
            e.l.g.g X = cardPackListActivity != null ? cardPackListActivity.X() : null;
            NLive<List<GameCard>> t0 = cardPackListViewModel2 != null ? cardPackListViewModel2.t0() : null;
            updateLiveDataRegistration(0, t0);
            if (t0 != null) {
                gVar4 = X;
                list = t0.getValue();
                pVar = pVar2;
                gVar = gVar7;
                str8 = str13;
                str9 = str17;
                i4 = i9;
            } else {
                gVar4 = X;
                pVar = pVar2;
                gVar = gVar7;
                str8 = str13;
                str9 = str17;
                i4 = i9;
                list = null;
            }
            str = str10;
            str7 = str11;
            i5 = i6;
            i2 = i7;
            cardPackListViewModel = cardPackListViewModel2;
            gVar2 = gVar5;
            aVar = aVar2;
            i3 = i8;
            str2 = str14;
            str3 = str16;
            gVar3 = gVar6;
            str6 = str12;
            str4 = str15;
            j3 = 10;
        } else {
            cardPackListViewModel = cardPackListViewModel2;
            j3 = 10;
            i2 = 0;
            str = null;
            str2 = null;
            i3 = 0;
            str3 = null;
            aVar = null;
            lVar = null;
            str4 = null;
            pVar = null;
            gVar = null;
            str5 = null;
            gVar2 = null;
            str6 = null;
            i4 = 0;
            i5 = 0;
            gVar3 = null;
            str7 = null;
            list = null;
            gVar4 = null;
            str8 = null;
            str9 = null;
        }
        int i12 = ((j2 & j3) > 0L ? 1 : ((j2 & j3) == 0L ? 0 : -1));
        long j4 = j2;
        if (i12 != 0) {
            e.t.j.g.e0.F(this.b, gVar2);
            NImageView nImageView = this.b;
            e.t.j.g.y.a(nImageView, str8, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_err_image), null, null, null, null, null, null, null, null, null, null);
            ListViewBinding.m(this.f13654c, pVar);
            ListViewBinding.l(this.f13654c, lVar, null, null);
            ListViewBinding.g(this.f13654c, aVar, false);
            this.f13655d.setVisibility(i2);
            this.o.j(cardPackListActivity);
            TextViewBindingAdapter.setText(this.p, str);
            TextViewBindingAdapter.setText(this.q, str5);
            TextViewBindingAdapter.setText(this.f13656e, str2);
            TextViewBindingAdapter.setText(this.f13657f, str4);
            this.f13657f.setVisibility(i3);
            TextViewBindingAdapter.setText(this.f13658g, str3);
            e.t.j.g.e0.F(this.f13658g, gVar);
            TextViewBindingAdapter.setText(this.f13659h, str7);
            e.t.j.g.e0.F(this.f13659h, gVar3);
            this.f13660i.setVisibility(i5);
            TextViewBindingAdapter.setText(this.f13660i, str9);
            this.f13661j.setVisibility(i4);
            TextViewBindingAdapter.setText(this.f13661j, str6);
        }
        if ((j4 & 8) != 0) {
            ListViewBinding.e(this.f13654c, null);
            ListViewBinding.d(this.f13654c, false);
            ListViewBinding.y(this.f13654c, true);
            e.l.i.f0.j(this.f13654c, 12, null);
        }
        if ((j4 & 15) != 0) {
            ListViewBinding.a(this.f13654c, gVar4, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
        if ((j4 & 12) != 0) {
            this.o.i(cardPackListViewModel);
        }
        ViewDataBinding.executeBindingsOn(this.o);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.r != 0) {
                return true;
            }
            return this.o.hasPendingBindings();
        }
    }

    @Override // e.l.k.u
    public void i(@Nullable CardPackListActivity cardPackListActivity) {
        this.f13662k = cardPackListActivity;
        synchronized (this) {
            this.r |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.r = 8L;
        }
        this.o.invalidateAll();
        requestRebind();
    }

    @Override // e.l.k.u
    public void j(@Nullable CardPackListViewModel cardPackListViewModel) {
        this.f13663l = cardPackListViewModel;
        synchronized (this) {
            this.r |= 4;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return k((NLive) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.o.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((CardPackListActivity) obj);
        } else if (21 != i2) {
            return false;
        } else {
            j((CardPackListViewModel) obj);
        }
        return true;
    }

    private v(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ConstraintLayout) objArr[14], (NImageView) objArr[2], (ListView) objArr[12], (LinearLayout) objArr[5], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[8], (TextView) objArr[9]);
        this.r = -1L;
        this.b.setTag(null);
        this.f13654c.setTag(null);
        this.f13655d.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13726m = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[1];
        this.n = linearLayout2;
        linearLayout2.setTag(null);
        cf cfVar = (cf) objArr[13];
        this.o = cfVar;
        setContainedBinding(cfVar);
        TextView textView = (TextView) objArr[6];
        this.p = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.q = textView2;
        textView2.setTag(null);
        this.f13656e.setTag(null);
        this.f13657f.setTag(null);
        this.f13658g.setTag(null);
        this.f13659h.setTag(null);
        this.f13660i.setTag(null);
        this.f13661j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
