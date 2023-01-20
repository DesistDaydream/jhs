package e.l.k;

import android.net.Uri;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.caverock.androidsvg.SVG;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.CopyTextView;

/* loaded from: classes2.dex */
public class hg extends gg {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts s = null;
    @Nullable
    private static final SparseIntArray t;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final ConstraintLayout f12819m;
    @NonNull
    private final TextView n;
    @NonNull
    private final ImageView o;
    @NonNull
    private final CardImageView p;
    @NonNull
    private final ImageView q;
    private long r;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t = sparseIntArray;
        sparseIntArray.put(R.id.guideline1, 13);
    }

    public hg(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, s, t));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        Uri uri;
        Game game;
        String str4;
        String str5;
        String str6;
        int i2;
        boolean z;
        int i3;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.t.j.h.g gVar3;
        e.t.j.h.g gVar4;
        String str7;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        int i6;
        e.t.j.h.g gVar5;
        e.t.j.h.g gVar6;
        e.t.j.h.g gVar7;
        e.t.j.h.g gVar8;
        Uri uri2;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        int i7;
        boolean z4;
        int i8;
        synchronized (this) {
            j2 = this.r;
            this.r = 0L;
        }
        String str13 = this.f12759k;
        CardProductNew cardProductNew = this.f12758j;
        e.l.q.b.b.a.e eVar = this.f12760l;
        String str14 = null;
        if ((15 & j2) != 0) {
            int i9 = ((j2 & 10) > 0L ? 1 : ((j2 & 10) == 0L ? 0 : -1));
            if (i9 != 0) {
                if (cardProductNew != null) {
                    uri2 = cardProductNew.getLocalPhoto();
                    str = cardProductNew.getCardVersionRarity();
                    str8 = cardProductNew.getProductLan();
                    z4 = cardProductNew.showDefaultImage();
                    str9 = cardProductNew.getCardNameCn();
                    str10 = cardProductNew.getCardVersionNumber();
                    str11 = cardProductNew.getUserUploadPhotoPath();
                    str12 = cardProductNew.getCardSubName();
                } else {
                    uri2 = null;
                    str = null;
                    str8 = null;
                    str9 = null;
                    str10 = null;
                    str11 = null;
                    str12 = null;
                    z4 = false;
                }
                if (i9 != 0) {
                    j2 = z4 ? j2 | 2048 : j2 | 1024;
                }
                boolean z5 = str8 == null;
                i8 = z4 ? 0 : 8;
                if ((j2 & 10) != 0) {
                    j2 |= z5 ? SVG.C : 16384L;
                }
                i7 = z5 ? 8 : 0;
            } else {
                uri2 = null;
                str = null;
                str8 = null;
                str9 = null;
                str10 = null;
                str11 = null;
                str12 = null;
                i7 = 0;
                z4 = false;
                i8 = 0;
            }
            game = ((j2 & 11) == 0 || cardProductNew == null) ? null : cardProductNew.getGame();
            str2 = str8;
            z = z4;
            str4 = str9;
            str5 = str10;
            str3 = str11;
            str6 = str12;
            i3 = i8;
            uri = uri2;
            i2 = i7;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            uri = null;
            game = null;
            str4 = null;
            str5 = null;
            str6 = null;
            i2 = 0;
            z = false;
            i3 = 0;
        }
        int i10 = ((j2 & 14) > 0L ? 1 : ((j2 & 14) == 0L ? 0 : -1));
        if (i10 != 0) {
            if (eVar != null) {
                gVar5 = eVar.e(cardProductNew);
                gVar6 = eVar.f(cardProductNew);
                gVar7 = eVar.c(cardProductNew);
                z3 = eVar.a();
                gVar8 = eVar.b(cardProductNew);
            } else {
                gVar5 = null;
                gVar6 = null;
                gVar7 = null;
                gVar8 = null;
                z3 = false;
            }
            if (i10 != 0) {
                j2 = z3 ? j2 | SVG.A | SVG.E : j2 | 4096 | SVG.D;
            }
            z2 = !z3;
            if ((j2 & 14) != 0) {
                j2 |= z2 ? 128L : 64L;
            }
            if ((j2 & 12) != 0 && eVar != null) {
                str14 = eVar.d();
            }
            str7 = str14;
            gVar = gVar5;
            gVar2 = gVar6;
            gVar3 = gVar7;
            gVar4 = gVar8;
        } else {
            gVar = null;
            gVar2 = null;
            gVar3 = null;
            gVar4 = null;
            str7 = null;
            z2 = false;
            z3 = false;
        }
        if ((j2 & SVG.E) != 0) {
            if (cardProductNew != null) {
                z = cardProductNew.showDefaultImage();
            }
            if ((j2 & 10) != 0) {
                j2 = z ? j2 | 2048 : j2 | 1024;
            }
        }
        boolean hasImage = ((8256 & j2) == 0 || cardProductNew == null) ? false : cardProductNew.hasImage();
        int i11 = ((j2 & 14) > 0L ? 1 : ((j2 & 14) == 0L ? 0 : -1));
        if (i11 != 0) {
            boolean z6 = z2 ? true : hasImage;
            if (!z3) {
                hasImage = false;
            }
            if (!z3) {
                z = false;
            }
            if (i11 != 0) {
                j2 |= z6 ? 512L : 256L;
            }
            if ((j2 & 14) != 0) {
                j2 |= hasImage ? SVG.G : SVG.F;
            }
            if ((j2 & 14) != 0) {
                j2 |= z ? 32L : 16L;
            }
            int i12 = z6 ? 8 : 0;
            i4 = hasImage ? 0 : 8;
            i6 = i12;
            i5 = z ? 0 : 8;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if ((j2 & 14) != 0) {
            e.t.j.g.e0.F(this.a, gVar4);
            this.o.setVisibility(i4);
            e.t.j.h.g gVar9 = gVar3;
            e.t.j.g.e0.F(this.o, gVar9);
            e.t.j.g.e0.F(this.p, gVar2);
            this.q.setVisibility(i5);
            e.t.j.g.e0.F(this.q, gVar9);
            this.f12751c.setVisibility(i6);
            e.t.j.g.e0.F(this.f12753e, gVar);
        }
        if ((j2 & 12) != 0) {
            TextViewBindingAdapter.setText(this.n, str7);
        }
        if ((j2 & 10) != 0) {
            this.p.setVisibility(i3);
            TextViewBindingAdapter.setText(this.f12752d, str6);
            CardImageView cardImageView = this.f12753e;
            e.l.i.e.b(cardImageView, str3, uri, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_err_image), game, null, null, null);
            TextViewBindingAdapter.setText(this.f12754f, str4);
            TextViewBindingAdapter.setText(this.f12755g, str5);
            TextViewBindingAdapter.setText(this.f12756h, str);
            TextViewBindingAdapter.setText(this.f12757i, str2);
            this.f12757i.setVisibility(i2);
        }
        if ((j2 & 11) != 0) {
            e.l.i.e.b(this.p, str13, null, null, game, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.r != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.r = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.gg
    public void j(@Nullable String str) {
        this.f12759k = str;
        synchronized (this) {
            this.r |= 1;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // e.l.k.gg
    public void k(@Nullable e.l.q.b.b.a.e eVar) {
        this.f12760l = eVar;
        synchronized (this) {
            this.r |= 4;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // e.l.k.gg
    public void l(@Nullable CardProductNew cardProductNew) {
        this.f12758j = cardProductNew;
        synchronized (this) {
            this.r |= 2;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (3 == i2) {
            j((String) obj);
        } else if (12 == i2) {
            l((CardProductNew) obj);
        } else if (6 != i2) {
            return false;
        } else {
            k((e.l.q.b.b.a.e) obj);
        }
        return true;
    }

    private hg(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[12], (View) objArr[13], (ImageView) objArr[2], (CopyTextView) objArr[7], (CardImageView) objArr[1], (CopyTextView) objArr[6], (CopyTextView) objArr[8], (TextView) objArr[9], (TextView) objArr[10]);
        this.r = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12819m = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.n = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.o = imageView;
        imageView.setTag(null);
        CardImageView cardImageView = (CardImageView) objArr[4];
        this.p = cardImageView;
        cardImageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[5];
        this.q = imageView2;
        imageView2.setTag(null);
        this.f12751c.setTag(null);
        this.f12752d.setTag(null);
        this.f12753e.setTag(null);
        this.f12754f.setTag(null);
        this.f12755g.setTag(null);
        this.f12756h.setTag(null);
        this.f12757i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
