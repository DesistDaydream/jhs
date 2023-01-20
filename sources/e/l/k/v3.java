package e.l.k;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.caverock.androidsvg.SVG;
import com.jihuanshe.R;
import com.jihuanshe.model.CardBaseInfo;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.dialog.CardDetailDialog;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.FlexLayout;
import com.vector.databinding.adapter.TextViewBinding;
import java.util.List;

/* loaded from: classes2.dex */
public class v3 extends u3 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts u = null;
    @Nullable
    private static final SparseIntArray v;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ConstraintLayout f13734j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final TextView f13735k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final TextView f13736l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final TextView f13737m;
    @NonNull
    private final TextView n;
    @NonNull
    private final TextView o;
    @NonNull
    private final TextView p;
    @NonNull
    private final TextView q;
    @NonNull
    private final TextView r;
    @NonNull
    private final LinearLayout s;
    private long t;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v = sparseIntArray;
        sparseIntArray.put(R.id.sl, 17);
    }

    public v3(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, u, v));
    }

    private boolean i(e.n.f<CardBaseInfo> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.t |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        boolean z;
        e.l.g.x0 x0Var;
        e.t.j.h.g gVar;
        int i2;
        int i3;
        List<Integer> list;
        String str3;
        Drawable drawable;
        e.t.j.h.g gVar2;
        String str4;
        e.t.j.h.g gVar3;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        CharSequence charSequence;
        Drawable drawable2;
        Drawable drawable3;
        boolean z2;
        boolean z3;
        boolean z4;
        String str11;
        Game game;
        int i4;
        int i5;
        String str12;
        int i6;
        int i7;
        long j3;
        int i8;
        int i9;
        e.n.f<CardBaseInfo> fVar;
        String str13;
        Game game2;
        e.l.g.x0 x0Var2;
        String str14;
        String str15;
        String str16;
        CharSequence charSequence2;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        List<Integer> list2;
        int i10;
        boolean z5;
        synchronized (this) {
            j2 = this.t;
            this.t = 0L;
        }
        CardDetailDialog cardDetailDialog = this.f13690i;
        int i11 = ((j2 & 7) > 0L ? 1 : ((j2 & 7) == 0L ? 0 : -1));
        if (i11 != 0) {
            if (cardDetailDialog != null) {
                fVar = cardDetailDialog.getCardInfo();
                str13 = cardDetailDialog.getGameKey();
                game2 = cardDetailDialog.getGame();
                x0Var2 = cardDetailDialog.getStarAdapter();
            } else {
                fVar = null;
                str13 = null;
                game2 = null;
                x0Var2 = null;
            }
            updateLiveDataRegistration(0, fVar);
            CardBaseInfo value = fVar != null ? fVar.getValue() : null;
            if (value != null) {
                str18 = value.getImage();
                String attr = value.getAttr();
                charSequence2 = value.getGameDesc(str13);
                String nameCN = value.getNameCN();
                str19 = value.getNameOri();
                str20 = value.getPackRelease();
                str21 = value.getRarity();
                str22 = value.getPackName();
                list2 = value.getStar();
                String monsterType = value.getMonsterType();
                String number = value.getNumber();
                str16 = value.getType();
                str4 = attr;
                str17 = nameCN;
                str14 = monsterType;
                str15 = number;
            } else {
                str14 = null;
                str15 = null;
                str16 = null;
                charSequence2 = null;
                str4 = null;
                str17 = null;
                str18 = null;
                str19 = null;
                str20 = null;
                str21 = null;
                str22 = null;
                list2 = null;
            }
            e.l.r.t tVar = e.l.r.t.a;
            Drawable a = tVar.a(str4);
            z2 = str4 == null;
            int b = tVar.b(str4);
            z3 = str21 == null;
            Drawable a2 = tVar.a(str14);
            z4 = str14 == null;
            int b2 = tVar.b(str14);
            String str23 = str14;
            String string = this.f13688g.getResources().getString(R.string.common_no, str15);
            z = str16 == null;
            int b3 = tVar.b(str16);
            Drawable a3 = tVar.a(str16);
            if (i11 != 0) {
                j2 = z2 ? j2 | 64 : j2 | 32;
            }
            if ((j2 & 7) != 0) {
                j2 = z3 ? j2 | 4096 : j2 | 2048;
            }
            if ((j2 & 7) != 0) {
                j2 = z4 ? j2 | 1024 : j2 | 512;
            }
            if ((j2 & 7) != 0) {
                j2 = z ? j2 | 16384 : j2 | SVG.A;
            }
            if (list2 != null) {
                i10 = list2.size();
                z5 = list2.isEmpty();
            } else {
                i10 = 0;
                z5 = false;
            }
            if ((j2 & 7) != 0) {
                j2 |= z5 ? 16L : 8L;
            }
            String string2 = this.f13689h.getResources().getString(R.string.card_star_num, Integer.valueOf(i10));
            int i12 = z5 ? 8 : 0;
            if ((j2 & 6) == 0 || cardDetailDialog == null) {
                str5 = string2;
                game = game2;
                str11 = str18;
                str2 = str21;
                list = list2;
                i4 = b;
                i5 = b2;
                str = str23;
                str6 = string;
                gVar2 = null;
                drawable3 = a;
                charSequence = charSequence2;
                i3 = b3;
                str8 = str17;
                gVar = null;
                gVar3 = null;
                drawable = a3;
                x0Var = x0Var2;
                str7 = str19;
                str9 = str20;
                str10 = str22;
                drawable2 = a2;
            } else {
                gVar2 = cardDetailDialog.getOnClickError();
                str5 = string2;
                game = game2;
                str11 = str18;
                str2 = str21;
                list = list2;
                i4 = b;
                i5 = b2;
                str6 = string;
                drawable3 = a;
                charSequence = charSequence2;
                i3 = b3;
                str8 = str17;
                gVar3 = cardDetailDialog.getOnClickPreview();
                gVar = cardDetailDialog.getOnClickClose();
                drawable = a3;
                x0Var = x0Var2;
                str7 = str19;
                str9 = str20;
                str10 = str22;
                drawable2 = a2;
                str = str23;
            }
            int i13 = i12;
            str3 = str16;
            i2 = i13;
        } else {
            str = null;
            str2 = null;
            z = false;
            x0Var = null;
            gVar = null;
            i2 = 0;
            i3 = 0;
            list = null;
            str3 = null;
            drawable = null;
            gVar2 = null;
            str4 = null;
            gVar3 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            charSequence = null;
            drawable2 = null;
            drawable3 = null;
            z2 = false;
            z3 = false;
            z4 = false;
            str11 = null;
            game = null;
            i4 = 0;
            i5 = 0;
        }
        boolean isEmpty = ((j2 & SVG.A) == 0 || str3 == null) ? false : str3.isEmpty();
        boolean isEmpty2 = ((j2 & 512) == 0 || str == null) ? false : str.isEmpty();
        boolean isEmpty3 = ((j2 & 2048) == 0 || str2 == null) ? false : str2.isEmpty();
        boolean isEmpty4 = ((j2 & 32) == 0 || str4 == null) ? false : str4.isEmpty();
        int i14 = ((j2 & 7) > 0L ? 1 : ((j2 & 7) == 0L ? 0 : -1));
        if (i14 != 0) {
            if (z2) {
                isEmpty4 = true;
            }
            if (z4) {
                isEmpty2 = true;
            }
            if (z3) {
                isEmpty3 = true;
            }
            if (z) {
                isEmpty = true;
            }
            if (i14 != 0) {
                j2 |= isEmpty4 ? SVG.D : SVG.C;
            }
            if ((j2 & 7) != 0) {
                j2 |= isEmpty2 ? SVG.H : SVG.G;
            }
            if ((j2 & 7) != 0) {
                j2 |= isEmpty3 ? SVG.F : SVG.E;
            }
            if ((j2 & 7) != 0) {
                j2 |= isEmpty ? 256L : 128L;
            }
            int i15 = isEmpty4 ? 8 : 0;
            int i16 = isEmpty2 ? 8 : 0;
            i8 = i16;
            i9 = isEmpty3 ? 8 : 0;
            j3 = 6;
            str12 = str2;
            i6 = i15;
            i7 = isEmpty ? 8 : 0;
        } else {
            str12 = str2;
            i6 = 0;
            i7 = 0;
            j3 = 6;
            i8 = 0;
            i9 = 0;
        }
        int i17 = ((j2 & j3) > 0L ? 1 : ((j2 & j3) == 0L ? 0 : -1));
        String str24 = str;
        if (i17 != 0) {
            e.t.j.g.e0.F(this.a, gVar);
            e.t.j.g.e0.F(this.f13684c, gVar3);
            e.t.j.g.e0.F(this.q, gVar2);
        }
        if ((j2 & 7) != 0) {
            this.b.setVisibility(i2);
            e.l.i.m.a(this.b, x0Var, list);
            CardImageView cardImageView = this.f13684c;
            e.l.i.e.b(cardImageView, str11, null, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_err_image), game, null, null, null);
            ViewBindingAdapter.setBackground(this.f13735k, drawable);
            TextViewBindingAdapter.setText(this.f13735k, str3);
            TextViewBinding.j(this.f13735k, i3);
            this.f13735k.setVisibility(i7);
            ViewBindingAdapter.setBackground(this.f13736l, drawable3);
            TextViewBindingAdapter.setText(this.f13736l, str4);
            TextViewBinding.j(this.f13736l, i4);
            this.f13736l.setVisibility(i6);
            ViewBindingAdapter.setBackground(this.f13737m, drawable2);
            TextViewBindingAdapter.setText(this.f13737m, str24);
            TextViewBinding.j(this.f13737m, i5);
            this.f13737m.setVisibility(i8);
            TextViewBindingAdapter.setText(this.n, charSequence);
            TextViewBindingAdapter.setText(this.o, str10);
            TextViewBindingAdapter.setText(this.p, str9);
            this.r.setVisibility(i9);
            TextViewBindingAdapter.setText(this.r, str12);
            this.s.setVisibility(i2);
            TextViewBindingAdapter.setText(this.f13685d, str8);
            TextViewBindingAdapter.setText(this.f13687f, str7);
            TextViewBindingAdapter.setText(this.f13688g, str6);
            TextViewBindingAdapter.setText(this.f13689h, str5);
        }
    }

    @Override // e.l.k.u3
    public void h(@Nullable CardDetailDialog cardDetailDialog) {
        this.f13690i = cardDetailDialog;
        synchronized (this) {
            this.t |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.t != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.t = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return i((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((CardDetailDialog) obj);
            return true;
        }
        return false;
    }

    private v3(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[1], (FlexLayout) objArr[9], (CardImageView) objArr[3], (TextView) objArr[4], (ScrollView) objArr[17], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[10]);
        this.t = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13684c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13734j = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.f13735k = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[12];
        this.f13736l = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[13];
        this.f13737m = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[14];
        this.n = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[15];
        this.o = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[16];
        this.p = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[2];
        this.q = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[7];
        this.r = textView8;
        textView8.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[8];
        this.s = linearLayout;
        linearLayout.setTag(null);
        this.f13685d.setTag(null);
        this.f13687f.setTag(null);
        this.f13688g.setTag(null);
        this.f13689h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
