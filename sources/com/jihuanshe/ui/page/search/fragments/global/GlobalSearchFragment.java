package com.jihuanshe.ui.page.search.fragments.global;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.SuperscriptSpan;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.ui.page.search.DefaultSearchHistoryViewImpl;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.util.Res;
import e.l.k.s6;
import e.l.s.m.d.b;
import e.n.f;
import e.t.j.h.g;
import e.t.k.a.c.h.c;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Creator
/* loaded from: classes2.dex */
public final class GlobalSearchFragment extends BaseFragment<b> {
    @d
    private final w r = z.c(new GlobalSearchFragment$parentViewModel$2(this));
    @d
    private final w s = z.c(new GlobalSearchFragment$searchHistoryViewImpl$2(this));
    @d
    private final List<String> t;
    @d
    private final f<List<CharSequence>> u;
    @d
    private final c v;
    @d
    private final w w;
    @d
    private final g x;

    public GlobalSearchFragment() {
        Res res = Res.a;
        List<String> P = CollectionsKt__CollectionsKt.P(Res.w(res, R.string.common_tab_product, null, 2, null), Res.w(res, R.string.common_tab_user, null, 2, null));
        this.t = P;
        this.u = new f<>(P);
        this.v = e.t.k.a.c.h.d.a(CollectionsKt__CollectionsKt.P(GlobalSearchFragment$pagers$1.INSTANCE, GlobalSearchFragment$pagers$2.INSTANCE), P);
        this.w = z.c(new GlobalSearchFragment$adapter$2(this));
        this.x = e.t.j.h.d.a.a(new GlobalSearchFragment$onClickWantBug$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CharSequence h0(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(8, true), 2, spannableString.length(), 18);
        spannableString.setSpan(new SuperscriptSpan() { // from class: com.jihuanshe.ui.page.search.fragments.global.GlobalSearchFragment$getNumberText$superScriptTextSpan$1
            @Override // android.text.style.SuperscriptSpan, android.text.style.CharacterStyle
            public void updateDrawState(@d TextPaint textPaint) {
                textPaint.baselineShift += (int) ((textPaint.ascent() / 3) * 2);
            }

            @Override // android.text.style.SuperscriptSpan, android.text.style.MetricAffectingSpan
            public void updateMeasureState(@d TextPaint textPaint) {
                textPaint.baselineShift += (int) ((textPaint.ascent() / 3) * 2);
            }
        }, 2, spannableString.length(), 17);
        return spannableString;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        ((b) T()).p0().f(this, new GlobalSearchFragment$flowOfSetup$1(this));
        k0().s0().f(this, new GlobalSearchFragment$flowOfSetup$2(this));
        ((b) T()).E().f(this, new GlobalSearchFragment$flowOfSetup$3(this));
    }

    @d
    public final FragPagerAdapter g0() {
        return (FragPagerAdapter) this.w.getValue();
    }

    @d
    public final g i0() {
        return this.x;
    }

    @d
    public final c j0() {
        return this.v;
    }

    @d
    public final e.l.s.m.c k0() {
        return (e.l.s.m.c) this.r.getValue();
    }

    @d
    public final DefaultSearchHistoryViewImpl l0() {
        return (DefaultSearchHistoryViewImpl) this.s.getValue();
    }

    @d
    public final f<List<CharSequence>> m0() {
        return this.u;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @d
    public ViewDataBinding s() {
        s6 e2 = s6.e(getLayoutInflater());
        e2.i(this);
        e2.j((b) T());
        return e2;
    }
}
