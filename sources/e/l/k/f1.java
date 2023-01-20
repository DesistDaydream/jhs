package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.InteractNewCount;
import com.jihuanshe.ui.page.im.InteractMessageActivity;
import com.jihuanshe.viewmodel.im.InteractMessageViewModel;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public class f1 extends e1 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p = null;
    @Nullable
    private static final SparseIntArray q;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f12608h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final LinearLayout f12609i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final TextView f12610j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final LinearLayout f12611k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final TextView f12612l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final LinearLayout f12613m;
    @NonNull
    private final TextView n;
    private long o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.put(R.id.indicator, 8);
        sparseIntArray.put(R.id.replyTv, 9);
        sparseIntArray.put(R.id.atTv, 10);
        sparseIntArray.put(R.id.likeTv, 11);
    }

    public f1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, p, q));
    }

    private boolean k(NLive<InteractNewCount> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.o |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v5 */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        e.t.j.h.y yVar;
        e.t.j.h.g gVar2;
        e.t.j.h.g gVar3;
        FragPagerAdapter fragPagerAdapter;
        e.t.k.a.c.h.c cVar;
        String str;
        String str2;
        String str3;
        int i2;
        int i3;
        int i4;
        ?? r7;
        Integer num;
        Integer num2;
        String str4;
        String str5;
        Integer num3;
        synchronized (this) {
            j2 = this.o;
            this.o = 0L;
        }
        InteractMessageActivity interactMessageActivity = this.f12546f;
        InteractMessageViewModel interactMessageViewModel = this.f12547g;
        if ((j2 & 10) == 0 || interactMessageActivity == null) {
            gVar = null;
            yVar = null;
            gVar2 = null;
            gVar3 = null;
            fragPagerAdapter = null;
            cVar = null;
        } else {
            FragPagerAdapter b0 = interactMessageActivity.b0();
            gVar2 = interactMessageActivity.e0();
            e.t.j.h.y h0 = interactMessageActivity.h0();
            e.t.k.a.c.h.c i0 = interactMessageActivity.i0();
            e.t.j.h.g f0 = interactMessageActivity.f0();
            gVar = interactMessageActivity.g0();
            cVar = i0;
            fragPagerAdapter = b0;
            yVar = h0;
            gVar3 = f0;
        }
        int i5 = ((j2 & 13) > 0L ? 1 : ((j2 & 13) == 0L ? 0 : -1));
        if (i5 != 0) {
            NLive<InteractNewCount> q0 = interactMessageViewModel != null ? interactMessageViewModel.q0() : null;
            updateLiveDataRegistration(0, q0);
            InteractNewCount value = q0 != null ? q0.getValue() : null;
            if (value != null) {
                num = value.getNewReply();
                num2 = value.getNewAt();
                str4 = value.getReplyNumStr();
                str5 = value.getAtNumStr();
                num3 = value.getNewLike();
                str = value.getLikeNumStr();
            } else {
                str = null;
                num = null;
                num2 = null;
                str4 = null;
                str5 = null;
                num3 = null;
            }
            int safeUnbox = ViewDataBinding.safeUnbox(num);
            int safeUnbox2 = ViewDataBinding.safeUnbox(num2);
            int safeUnbox3 = ViewDataBinding.safeUnbox(num3);
            boolean z = safeUnbox == 0;
            boolean z2 = safeUnbox2 == 0;
            boolean z3 = safeUnbox3 == 0;
            if (i5 != 0) {
                j2 |= z ? 512L : 256L;
            }
            if ((j2 & 13) != 0) {
                j2 |= z2 ? 128L : 64L;
            }
            if ((j2 & 13) != 0) {
                j2 |= z3 ? 32L : 16L;
            }
            i2 = z ? 8 : 0;
            i3 = z2 ? 8 : 0;
            i4 = z3 ? 8 : 0;
            str2 = str4;
            str3 = str5;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        if ((10 & j2) != 0) {
            e.t.j.g.e0.F(this.f12609i, gVar);
            e.t.j.g.e0.F(this.f12611k, gVar2);
            e.t.j.g.e0.F(this.f12613m, gVar3);
            r7 = 0;
            e.t.j.g.f0.j(this.f12545e, null, fragPagerAdapter, cVar, null, null);
            e.t.j.g.f0.p(this.f12545e, null, null, yVar, null);
        } else {
            r7 = 0;
        }
        if ((j2 & 13) != 0) {
            this.f12610j.setVisibility(i2);
            TextViewBindingAdapter.setText(this.f12610j, str2);
            this.f12612l.setVisibility(i3);
            TextViewBindingAdapter.setText(this.f12612l, str3);
            this.n.setVisibility(i4);
            TextViewBindingAdapter.setText(this.n, str);
        }
        if ((j2 & 8) != 0) {
            e.t.j.g.f0.r(this.f12545e, r7);
            e.t.j.g.f0.i(this.f12545e, r7);
            e.t.j.g.f0.h(this.f12545e, r7, Boolean.FALSE);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // e.l.k.e1
    public void i(@Nullable InteractMessageActivity interactMessageActivity) {
        this.f12546f = interactMessageActivity;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.e1
    public void j(@Nullable InteractMessageViewModel interactMessageViewModel) {
        this.f12547g = interactMessageViewModel;
        synchronized (this) {
            this.o |= 4;
        }
        notifyPropertyChanged(20);
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
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((InteractMessageActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((InteractMessageViewModel) obj);
        }
        return true;
    }

    private f1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[10], (LinearLayout) objArr[8], (TextView) objArr[11], (TextView) objArr[9], (ViewPager) objArr[1]);
        this.o = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12608h = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.f12609i = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f12610j = textView;
        textView.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[4];
        this.f12611k = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.f12612l = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[6];
        this.f12613m = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView3 = (TextView) objArr[7];
        this.n = textView3;
        textView3.setTag(null);
        this.f12545e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
