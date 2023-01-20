package e.l.k;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.caverock.androidsvg.SVG;
import com.jihuanshe.R;
import com.jihuanshe.model.CardBaseInfo;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.dialog.CardBaseInfoDetailDialog;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.CopyTextView;
import com.jihuanshe.ui.widget.FlexLayout;
import com.vector.databinding.adapter.TextViewBinding;
import java.util.List;

/* loaded from: classes2.dex */
public class r3 extends q3 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts u = null;
    @Nullable
    private static final SparseIntArray v;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final FrameLayout f13452j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final TextView f13453k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final TextView f13454l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final TextView f13455m;
    @NonNull
    private final TextView n;
    @NonNull
    private final CopyTextView o;
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

    public r3(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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
        int i2;
        Drawable drawable;
        e.l.g.x0 x0Var;
        String str3;
        String str4;
        List<Integer> list;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.t.j.h.g gVar3;
        String str5;
        String str6;
        String str7;
        String str8;
        CharSequence charSequence;
        Drawable drawable2;
        Drawable drawable3;
        Game game;
        boolean z;
        String str9;
        boolean z2;
        boolean z3;
        boolean z4;
        String str10;
        String str11;
        int i3;
        int i4;
        int i5;
        String str12;
        String str13;
        int i6;
        int i7;
        long j3;
        int i8;
        int i9;
        e.n.f<CardBaseInfo> fVar;
        String str14;
        Game game2;
        e.l.g.x0 x0Var2;
        String str15;
        CharSequence charSequence2;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        List<Integer> list2;
        int i10;
        boolean z5;
        synchronized (this) {
            j2 = this.t;
            this.t = 0L;
        }
        CardBaseInfoDetailDialog cardBaseInfoDetailDialog = this.f13414i;
        int i11 = ((j2 & 7) > 0L ? 1 : ((j2 & 7) == 0L ? 0 : -1));
        if (i11 != 0) {
            if (cardBaseInfoDetailDialog != null) {
                fVar = cardBaseInfoDetailDialog.C();
                str14 = cardBaseInfoDetailDialog.F();
                game2 = cardBaseInfoDetailDialog.E();
                x0Var2 = cardBaseInfoDetailDialog.I();
            } else {
                fVar = null;
                str14 = null;
                game2 = null;
                x0Var2 = null;
            }
            updateLiveDataRegistration(0, fVar);
            CardBaseInfo value = fVar != null ? fVar.getValue() : null;
            if (value != null) {
                str17 = value.getNumberStr();
                str18 = value.getImage();
                String attr = value.getAttr();
                charSequence2 = value.getGameDesc(str14);
                str19 = value.getNameCN();
                str20 = value.getNameOri();
                str21 = value.getPackRelease();
                str22 = value.getRarity();
                str23 = value.getPackName();
                list2 = value.getStar();
                String monsterType = value.getMonsterType();
                str15 = value.getType();
                str16 = attr;
                str3 = monsterType;
            } else {
                str15 = null;
                charSequence2 = null;
                str3 = null;
                str16 = null;
                str17 = null;
                str18 = null;
                str19 = null;
                str20 = null;
                str21 = null;
                str22 = null;
                str23 = null;
                list2 = null;
            }
            e.l.r.t tVar = e.l.r.t.a;
            Drawable a = tVar.a(str16);
            z = str16 == null;
            int b = tVar.b(str16);
            z2 = str22 == null;
            Drawable a2 = tVar.a(str3);
            z3 = str3 == null;
            int b2 = tVar.b(str3);
            z4 = str15 == null;
            int b3 = tVar.b(str15);
            Drawable a3 = tVar.a(str15);
            if (i11 != 0) {
                j2 = z ? j2 | 64 : j2 | 32;
            }
            if ((j2 & 7) != 0) {
                j2 = z2 ? j2 | 4096 : j2 | 2048;
            }
            if ((j2 & 7) != 0) {
                j2 = z3 ? j2 | 1024 : j2 | 512;
            }
            if ((j2 & 7) != 0) {
                j2 = z4 ? j2 | 16384 : j2 | SVG.A;
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
            String string = this.f13413h.getResources().getString(R.string.card_star_num, Integer.valueOf(i10));
            i2 = z5 ? 8 : 0;
            if ((j2 & 6) == 0 || cardBaseInfoDetailDialog == null) {
                str10 = string;
                str2 = str16;
                str5 = str17;
                str6 = str19;
                str11 = str20;
                str = str22;
                list = list2;
                i3 = b;
                i4 = b2;
                i5 = b3;
                gVar = null;
                str4 = str15;
                charSequence = charSequence2;
                drawable = a3;
                drawable3 = a;
                game = game2;
                x0Var = x0Var2;
                str9 = str18;
                str7 = str21;
                str8 = str23;
                drawable2 = a2;
                gVar2 = null;
                gVar3 = null;
            } else {
                gVar = cardBaseInfoDetailDialog.H();
                e.t.j.h.g J = cardBaseInfoDetailDialog.J(this.f13408c);
                str10 = string;
                str2 = str16;
                str5 = str17;
                str6 = str19;
                str11 = str20;
                i3 = b;
                i4 = b2;
                i5 = b3;
                str4 = str15;
                charSequence = charSequence2;
                drawable = a3;
                drawable3 = a;
                game = game2;
                x0Var = x0Var2;
                str9 = str18;
                str7 = str21;
                str8 = str23;
                drawable2 = a2;
                gVar3 = cardBaseInfoDetailDialog.G();
                gVar2 = J;
                str = str22;
                list = list2;
            }
        } else {
            str = null;
            str2 = null;
            i2 = 0;
            drawable = null;
            x0Var = null;
            str3 = null;
            str4 = null;
            list = null;
            gVar = null;
            gVar2 = null;
            gVar3 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            charSequence = null;
            drawable2 = null;
            drawable3 = null;
            game = null;
            z = false;
            str9 = null;
            z2 = false;
            z3 = false;
            z4 = false;
            str10 = null;
            str11 = null;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        boolean isEmpty = ((j2 & SVG.A) == 0 || str4 == null) ? false : str4.isEmpty();
        boolean isEmpty2 = ((j2 & 512) == 0 || str3 == null) ? false : str3.isEmpty();
        boolean isEmpty3 = ((j2 & 2048) == 0 || str == null) ? false : str.isEmpty();
        boolean isEmpty4 = ((j2 & 32) == 0 || str2 == null) ? false : str2.isEmpty();
        int i12 = ((j2 & 7) > 0L ? 1 : ((j2 & 7) == 0L ? 0 : -1));
        if (i12 != 0) {
            if (z) {
                isEmpty4 = true;
            }
            if (z3) {
                isEmpty2 = true;
            }
            if (z2) {
                isEmpty3 = true;
            }
            if (z4) {
                isEmpty = true;
            }
            if (i12 != 0) {
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
            int i13 = isEmpty4 ? 8 : 0;
            int i14 = isEmpty2 ? 8 : 0;
            i8 = i14;
            i9 = isEmpty3 ? 8 : 0;
            str12 = str;
            str13 = str3;
            i7 = i13;
            i6 = isEmpty ? 8 : 0;
            j3 = 6;
        } else {
            str12 = str;
            str13 = str3;
            i6 = 0;
            i7 = 0;
            j3 = 6;
            i8 = 0;
            i9 = 0;
        }
        if ((j2 & j3) != 0) {
            e.t.j.g.e0.F(this.a, gVar3);
            e.t.j.g.e0.F(this.f13408c, gVar2);
            e.t.j.g.e0.F(this.q, gVar);
        }
        if ((7 & j2) != 0) {
            this.b.setVisibility(i2);
            e.l.i.m.a(this.b, x0Var, list);
            CardImageView cardImageView = this.f13408c;
            e.l.i.e.b(cardImageView, str9, null, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_err_image), game, null, null, null);
            ViewBindingAdapter.setBackground(this.f13453k, drawable);
            TextViewBindingAdapter.setText(this.f13453k, str4);
            TextViewBinding.j(this.f13453k, i5);
            this.f13453k.setVisibility(i6);
            ViewBindingAdapter.setBackground(this.f13454l, drawable3);
            TextViewBindingAdapter.setText(this.f13454l, str2);
            TextViewBinding.j(this.f13454l, i3);
            this.f13454l.setVisibility(i7);
            ViewBindingAdapter.setBackground(this.f13455m, drawable2);
            TextViewBindingAdapter.setText(this.f13455m, str13);
            TextViewBinding.j(this.f13455m, i4);
            this.f13455m.setVisibility(i8);
            TextViewBindingAdapter.setText(this.n, charSequence);
            TextViewBindingAdapter.setText(this.o, str8);
            TextViewBindingAdapter.setText(this.p, str7);
            this.r.setVisibility(i9);
            TextViewBindingAdapter.setText(this.r, str12);
            this.s.setVisibility(i2);
            TextViewBindingAdapter.setText(this.f13409d, str6);
            TextViewBindingAdapter.setText(this.f13411f, str11);
            TextViewBindingAdapter.setText(this.f13412g, str5);
            TextViewBindingAdapter.setText(this.f13413h, str10);
        }
        if ((j2 & 4) != 0) {
            com.jihuanshe.binding.TextViewBinding.c(this.n, Boolean.TRUE);
        }
    }

    @Override // e.l.k.q3
    public void h(@Nullable CardBaseInfoDetailDialog cardBaseInfoDetailDialog) {
        this.f13414i = cardBaseInfoDetailDialog;
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
            h((CardBaseInfoDetailDialog) obj);
            return true;
        }
        return false;
    }

    private r3(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[1], (FlexLayout) objArr[9], (CardImageView) objArr[3], (CopyTextView) objArr[4], (ScrollView) objArr[17], (CopyTextView) objArr[5], (CopyTextView) objArr[6], (TextView) objArr[10]);
        this.t = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13408c.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13452j = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.f13453k = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[12];
        this.f13454l = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[13];
        this.f13455m = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[14];
        this.n = textView4;
        textView4.setTag(null);
        CopyTextView copyTextView = (CopyTextView) objArr[15];
        this.o = copyTextView;
        copyTextView.setTag(null);
        TextView textView5 = (TextView) objArr[16];
        this.p = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[2];
        this.q = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[7];
        this.r = textView7;
        textView7.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[8];
        this.s = linearLayout;
        linearLayout.setTag(null);
        this.f13409d.setTag(null);
        this.f13411f.setTag(null);
        this.f13412g.setTag(null);
        this.f13413h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
