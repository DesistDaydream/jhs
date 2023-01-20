package com.jihuanshe.ui.page.detail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartFontWeightType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartLineDashStyleType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModelKt;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartStackingType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.github.aachartmodel.aainfographics.aachartcreator.AAOptions;
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AACrosshair;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AALabels;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AATitle;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAXAxis;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAYAxis;
import com.github.aachartmodel.aainfographics.aatools.AABuilder;
import com.github.aachartmodel.aainfographics.aatools.AAGradientColor;
import com.github.aachartmodel.aainfographics.aatools.AALinearGradientDirection;
import com.jihuanshe.R;
import com.jihuanshe.adapter.CommentAdapter;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.model.DatePrice;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.Pack;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.dialog.CardCommentsDialog;
import com.jihuanshe.ui.dialog.CardErrorCorrectionDialog;
import com.jihuanshe.ui.page.detail.CardDetailActivity;
import com.jihuanshe.ui.widget.ConditionFilterBtn;
import com.jihuanshe.ui.widget.imagepreview.enitity.ImageViewInfo;
import com.jihuanshe.utils.ImagePicker;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.network.image.NImageView;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.k.q;
import e.l.r.r;
import e.l.r.s;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.d0;
import e.t.j.h.g;
import e.t.j.h.p;
import e.t.j.h.t;
import e.t.k.a.f.h;
import e.t.o.d;
import h.k2.u.l;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.t1;
import h.w;
import h.z;
import i.b.b1;
import i.b.i;
import inject.annotation.creator.Creator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class CardDetailActivity extends BaseActivity<CardDetailViewModel> {
    public static final /* synthetic */ n<Object>[] Y;
    private int B;
    @d
    private final d0 C;
    @d
    private final l<List<Rarity>, t1> D;
    @d
    private final g E;
    @e
    private CardCommentsDialog F;
    @d
    private final g G;
    @d
    private final g H;
    @d
    private final g I;
    @d
    private final g J;
    @d
    private final g K;
    @d
    private final e.t.j.h.l L;
    @d
    private final g M;
    @d
    private final g N;
    @d
    private final g O;
    @d
    private final e.t.j.h.l P;
    @d
    private final p Q;
    @d
    private final g R;
    @d
    private final g S;
    @d
    private final t T;
    @e
    private TextView U;
    @e
    private ImageView V;
    @e
    private ViewGroup W;
    private boolean X;
    @e
    private h r;
    @e
    private CardErrorCorrectionDialog s;
    @f.a.a.a
    private int versionId;
    @f.a.a.a(true)
    @e
    private Boolean wish;
    private boolean z;
    @f.a.a.a
    @e
    private String gameKey = "";
    @f.a.a.a
    @e
    private String gameSubKey = "";
    @d
    private final h.m2.e n = BindViewKt.n(this, R.id.listView);
    @d
    private final h.m2.e o = BindViewKt.n(this, R.id.conditionFilter);
    @d
    private final h.m2.e p = BindViewKt.n(this, R.id.chartView);
    @d
    private final h.m2.e q = BindViewKt.n(this, R.id.llBot);
    @d
    private final ImagePicker t = new ImagePicker(this, 0, 0.0f, new CardDetailActivity$imagePicker$1(this), 6, (u) null);
    @d
    private final w u = z.c(CardDetailActivity$layoutManager$2.INSTANCE);
    @d
    private final w v = z.c(CardDetailActivity$decoration$2.INSTANCE);
    @d
    private final w w = z.c(CardDetailActivity$adapter$2.INSTANCE);
    @d
    private final w x = z.c(CardDetailActivity$layoutManagerComment$2.INSTANCE);
    @d
    private final w y = z.c(new CardDetailActivity$adapterComment$2(this));
    private boolean A = true;

    /* loaded from: classes2.dex */
    public static final class a implements Animation.AnimationListener {
        public a() {
            CardDetailActivity.this = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@e Animation animation) {
            CardDetailActivity.this.p1(false);
            CardDetailActivity.this.l1(false);
            if (CardDetailActivity.this.T0() == 0) {
                CardDetailActivity cardDetailActivity = CardDetailActivity.this;
                cardDetailActivity.v1(cardDetailActivity.B0());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@e Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@e Animation animation) {
            CardDetailActivity.this.p1(true);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements Animation.AnimationListener {
        public b() {
            CardDetailActivity.this = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@e Animation animation) {
            CardDetailActivity.this.p1(false);
            CardDetailActivity.this.l1(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@e Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@e Animation animation) {
            CardDetailActivity.this.p1(true);
        }
    }

    static {
        n<Object>[] nVarArr = new n[9];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(CardDetailActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(CardDetailActivity.class), "conditionFilter", "getConditionFilter()Lcom/jihuanshe/ui/widget/ConditionFilterBtn;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(CardDetailActivity.class), "chartView", "getChartView()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(CardDetailActivity.class), "llBot", "getLlBot()Landroid/widget/LinearLayout;"));
        Y = nVarArr;
    }

    public CardDetailActivity() {
        d.e eVar = d.e.a;
        this.C = eVar.c(new CardDetailActivity$onViewScroll$1(this));
        this.D = new CardDetailActivity$onFilterRarity$1(this);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.E = dVar.a(new CardDetailActivity$onClickRank$1(this));
        this.G = dVar.a(new CardDetailActivity$onClickGoComment$1(this));
        this.H = dVar.a(new CardDetailActivity$onClickShowDetail$1(this));
        this.I = dVar.a(new CardDetailActivity$onClickGoPack$1(this));
        this.J = dVar.a(new CardDetailActivity$onClickMoreVer$1(this));
        this.K = dVar.a(new CardDetailActivity$onClickLike$1(this));
        this.L = eVar.a(new CardDetailActivity$onCommentItemClick$1(this));
        this.M = dVar.a(new CardDetailActivity$onClickMoreReview$1(this));
        this.N = dVar.a(new CardDetailActivity$onClickScore$1(this));
        this.O = dVar.a(new CardDetailActivity$onClickDesire$1(this));
        this.P = eVar.a(new CardDetailActivity$onItemClick$1(this));
        this.Q = d.g.a.a(new CardDetailActivity$onLoadMore$1(this));
        this.R = dVar.a(new CardDetailActivity$onClickNameCN$1(this));
        this.S = dVar.a(new CardDetailActivity$wantSellOnClick$1(this));
        this.T = d.a.a.a(new CardDetailActivity$onScroll$1(this));
        this.X = true;
    }

    public final ListView A0() {
        return (ListView) this.n.a(this, Y[0]);
    }

    public final LinearLayout B0() {
        return (LinearLayout) this.q.a(this, Y[3]);
    }

    public final void X0() {
        String V0 = ((CardDetailViewModel) L()).V0();
        CardDetailInfo value = ((CardDetailViewModel) L()).C0().getValue();
        ReviewListActivityCreator.create(V0, value == null ? null : value.getId(), null, null, this.gameKey, this.gameSubKey).start(this);
    }

    public final void Y0(Uri uri) {
        if (uri == null) {
            return;
        }
        h hVar = this.r;
        if (hVar != null) {
            hVar.n();
        }
        h hVar2 = new h(this, false, 2, null);
        this.r = hVar2;
        if (hVar2 != null) {
            hVar2.W();
        }
        i.f(LifecycleOwnerKt.getLifecycleScope(this), b1.c(), null, new CardDetailActivity$handleUri$1(uri, this, null), 2, null);
    }

    private final void Z0() {
        f.g(((CardDetailViewModel) L()).K0(), null, new CardDetailActivity$initObserver$1(this), 1, null);
        f.g(((CardDetailViewModel) L()).L0(), null, new CardDetailActivity$initObserver$2(this), 1, null);
        f.g(((CardDetailViewModel) L()).S0(), null, new CardDetailActivity$initObserver$3(this), 1, null);
    }

    private final void g1() {
        BinderKt.p(((CardDetailViewModel) L()).B0(this.versionId, this.gameKey, this.gameSubKey));
        BinderKt.p(((CardDetailViewModel) L()).Z0(this.gameKey, this.gameSubKey));
    }

    public final void i1(List<DatePrice> list) {
        Map<String, Object> linearGradient = AAGradientColor.INSTANCE.linearGradient(AALinearGradientDirection.ToBottom, "rgba(255, 205, 0,0.6)", "rgba(255, 205, 0,0.1)");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        int i2 = 0;
        while (true) {
            String str = "";
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            DatePrice datePrice = (DatePrice) next;
            arrayList.add(Float.valueOf(datePrice.getPrice()));
            String time = datePrice.getTime();
            if (time != null) {
                str = time;
            }
            arrayList2.add(str);
            i2 = i3;
        }
        AABuilder stacking = AAChartModel.Companion.Builder(this).setChartType(AAChartType.Areaspline).setMarkerRadius(0).setBackgroundColor("#00000000").setDataLabelsEnabled(false).setYAxisGridLineWidth(Float.valueOf(0.0f)).setLegendEnabled(false).setTouchEventEnabled(true).setYAxisTitle("").setYAxisAllowDecimals(true).setStacking(AAChartStackingType.Normal);
        AASeriesElement aASeriesElement = new AASeriesElement();
        Object[] array = arrayList.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        AAChartModel build = stacking.setSeries(aASeriesElement.data(array).color("rgba(255, 205, 0,1)").fillColor(linearGradient).lineWidth(1)).build();
        AAOptions aa_toAAOptions = AAChartModelKt.aa_toAAOptions(build);
        AAXAxis lineColor = new AAXAxis().lineWidth(1).lineColor("#99999a");
        Object[] array2 = arrayList2.toArray(new String[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        AAXAxis tickLength = lineColor.categories((String[]) array2).tickPositions(new Object[]{0, Integer.valueOf(arrayList2.size() / 2), Integer.valueOf(arrayList2.size() - 1)}).tickWidth(1).tickColor("#99999a").tickLength(3);
        Boolean bool = Boolean.TRUE;
        aa_toAAOptions.xAxis(tickLength.startOnTick(bool));
        AAXAxis xAxis = aa_toAAOptions.getXAxis();
        if (xAxis != null) {
            xAxis.labels(new AALabels().style(new AAStyle().fontSize(8).fontWeight(AAChartFontWeightType.Bold).color("#99999a")).formatter("function () {\n if (this.value.length >5){\n  var yValue = this.value.substring(0,this.value.length-3);\n    return yValue;\n }else{\n return this.value;\n }\n}"));
        }
        AACrosshair dashStyle = new AACrosshair().color("#B5B5B7").width(1).dashStyle(AAChartLineDashStyleType.ShortDash);
        AAXAxis xAxis2 = aa_toAAOptions.getXAxis();
        if (xAxis2 != null) {
            xAxis2.crosshair(dashStyle);
        }
        Float f2 = (Float) Collections.max(arrayList);
        aa_toAAOptions.yAxis(new AAYAxis().gridLineWidth(0).title(new AATitle().text("")).tickPositions(new Object[]{0, Double.valueOf(f2.floatValue() * 0.25d), Double.valueOf(f2.floatValue() * 0.5d), Double.valueOf(f2.floatValue() * 0.75d), f2}));
        AAYAxis yAxis = aa_toAAOptions.getYAxis();
        if (yAxis != null) {
            yAxis.labels(new AALabels().style(new AAStyle().fontSize(8).fontWeight(AAChartFontWeightType.Bold).color("#99999a")).formatter("function () {\n    var yValue = this.value;\n    if(yValue==0){\n    return \"0.0¥\"\n    }else{\n    return yValue.toFixed(1)+\"¥\"\n    }\n    \n}"));
        }
        if (aa_toAAOptions.getTooltip() != null) {
            aa_toAAOptions.getTooltip().useHTML(bool).shared(Boolean.FALSE).shadow(false).backgroundColor("#B5B5B7").borderColor("#B5B5B7").borderRadius(Integer.valueOf(d.a.c(e.t.o.d.a, null, 1, null).d(6))).padding(0).style(new AAStyle().fontWeight(AAChartFontWeightType.Bold).color("#FFFFFF").fontSize(10)).followTouchMove(true).formatter("  function () {\n   var s = '<div style=\\\"' + 'padding:6px 10px 6px 10px;text-align:center\\\">' \n   + '<b style=\\\"' + 'font-size:10px\\\">' +  this.x + '</b>'\n   +'<br>'\n   + '<b style=\\\"' + 'font-size:12px\\\">' +  this.y +\"¥\" + '</b>'\n   + '</div>';\n   return s;\n}").enabled(bool);
        }
        r0().aa_drawChartWithChartModel(build);
        r0().aa_drawChartWithChartOptions(aa_toAAOptions);
    }

    public final void l0(String str) {
        BinderKt.p(e.g.d.a.j(((CardDetailViewModel) L()).B0(this.versionId, this.gameKey, this.gameSubKey), null, new CardDetailActivity$fetchData$1(this, str), 1, null));
    }

    public static /* synthetic */ void m0(CardDetailActivity cardDetailActivity, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        cardDetailActivity.l0(str);
    }

    public static final boolean n0(CardDetailActivity cardDetailActivity, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            cardDetailActivity.r0().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            cardDetailActivity.r0().requestDisallowInterceptTouchEvent(false);
        }
        return false;
    }

    private final void q1(View view, List<? extends ImageViewInfo> list) {
        for (ImageViewInfo imageViewInfo : list) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            imageViewInfo.setBounds(rect);
        }
    }

    private final AAChartView r0() {
        return (AAChartView) this.p.a(this, Y[2]);
    }

    public final ConditionFilterBtn s0() {
        return (ConditionFilterBtn) this.o.a(this, Y[1]);
    }

    public final void u1(View view) {
        view.setVisibility(8);
        TranslateAnimation e2 = s.e(s.a, 0L, 1, null);
        e2.setInterpolator(new AccelerateDecelerateInterpolator());
        view.setAnimation(e2);
        e2.setAnimationListener(new a());
    }

    public final void v1(View view) {
        view.setVisibility(0);
        TranslateAnimation g2 = s.g(s.a, 0L, 1, null);
        g2.setInterpolator(new AccelerateDecelerateInterpolator());
        view.setAnimation(g2);
        g2.setAnimationListener(new b());
    }

    public final void x1() {
        Pack pack;
        DatePrice datePrice;
        CardDetailInfo value = ((CardDetailViewModel) L()).C0().getValue();
        r rVar = r.a;
        String M = M();
        Game b2 = e.l.l.a.b(this.gameKey, this.gameSubKey);
        String shortName = b2 == null ? null : b2.getShortName();
        String nameCN = (value == null || (pack = value.getPack()) == null) ? null : pack.getNameCN();
        String nameCN2 = value == null ? null : value.getNameCN();
        Integer valueOf = Integer.valueOf(this.versionId);
        String number = value == null ? null : value.getNumber();
        String rarity = value == null ? null : value.getRarity();
        Float scoreNum = value == null ? null : value.getScoreNum();
        List<DatePrice> value2 = ((CardDetailViewModel) L()).S0().getValue();
        rVar.j(M, shortName, nameCN, nameCN2, valueOf, number, rarity, scoreNum, (value2 == null || (datePrice = (DatePrice) CollectionsKt___CollectionsKt.i3(value2)) == null) ? null : Float.valueOf(datePrice.getPrice()), value == null ? null : value.getGradeTotal(), ((CardDetailViewModel) L()).U0(), value == null ? null : value.getLikeCount(), value == null ? null : value.getGradeUserTotal(), value == null ? null : value.getDesireCount());
    }

    @e
    public final TextView C0() {
        return this.U;
    }

    @k.e.a.d
    public final g D0() {
        return this.O;
    }

    @k.e.a.d
    public final g E0() {
        return this.G;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        m0(this, null, 1, null);
    }

    @k.e.a.d
    public final g F0() {
        return this.I;
    }

    @k.e.a.d
    public final g G0() {
        return this.K;
    }

    @k.e.a.d
    public final g H0() {
        return this.M;
    }

    @k.e.a.d
    public final g I0() {
        return this.J;
    }

    @k.e.a.d
    public final g J0() {
        return this.R;
    }

    @k.e.a.d
    public final g K0() {
        return this.E;
    }

    @k.e.a.d
    public final g L0() {
        return this.N;
    }

    @k.e.a.d
    public final g M0() {
        return this.H;
    }

    @k.e.a.d
    public final e.t.j.h.l N0() {
        return this.L;
    }

    @k.e.a.d
    public final l<List<Rarity>, t1> O0() {
        return this.D;
    }

    @k.e.a.d
    public final e.t.j.h.l P0() {
        return this.P;
    }

    @k.e.a.d
    public final p Q0() {
        return this.Q;
    }

    @k.e.a.d
    public final t R0() {
        return this.T;
    }

    @k.e.a.d
    public final d0 S0() {
        return this.C;
    }

    public final int T0() {
        return this.B;
    }

    public final int U0() {
        return this.versionId;
    }

    @k.e.a.d
    public final g V0() {
        return this.S;
    }

    @e
    public final Boolean W0() {
        return this.wish;
    }

    public final boolean a1() {
        return this.A;
    }

    public final boolean b1() {
        return this.z;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    @SuppressLint({"ClickableViewAccessibility"})
    public void d() {
        Z0();
        F();
        r0().setOnTouchListener(new View.OnTouchListener() { // from class: e.l.q.b.d.a
            {
                CardDetailActivity.this = this;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean n0;
                n0 = CardDetailActivity.n0(CardDetailActivity.this, view, motionEvent);
                return n0;
            }
        });
    }

    @k.e.a.d
    public final g d1(int i2) {
        return e.t.j.h.d.a.a(new CardDetailActivity$onChoicePriceType$1(this, i2));
    }

    @k.e.a.d
    public final g e1(@k.e.a.d NImageView nImageView) {
        return e.t.j.h.d.a.a(new CardDetailActivity$onClickPreview$1(this, nImageView));
    }

    @k.e.a.d
    public final g f1(int i2) {
        return e.t.j.h.d.a.a(new CardDetailActivity$onClickTipScore$1(this, i2));
    }

    public final void h1(@e CardCommentsDialog cardCommentsDialog) {
        this.F = cardCommentsDialog;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        this.U = w().getMid().g(CardDetailActivity$flowOfAppBar$1.INSTANCE);
        this.W = (ViewGroup) w().getEnd().d(new CardDetailActivity$flowOfAppBar$2(this));
    }

    public final void j1(@e ImageView imageView) {
        this.V = imageView;
    }

    @k.e.a.d
    public final g k0(int i2) {
        return e.t.j.h.d.a.a(new CardDetailActivity$chooseFilter$1(this, i2));
    }

    public final void k1(@e ViewGroup viewGroup) {
        this.W = viewGroup;
    }

    public final void l1(boolean z) {
        this.A = z;
    }

    public final void m1(@e String str) {
        this.gameKey = str;
    }

    public final void n1(@e String str) {
        this.gameSubKey = str;
    }

    @k.e.a.d
    public final e.l.g.h o0() {
        return (e.l.g.h) this.w.getValue();
    }

    public final void o1(@e TextView textView) {
        this.U = textView;
    }

    @Override // com.vector.design.ui.activity.ActivityEx, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @e Intent intent) {
        CardCommentsDialog cardCommentsDialog;
        CardCommentsDialog cardCommentsDialog2;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10001) {
            if (i3 != -1) {
                if (i3 == 0 && (cardCommentsDialog2 = this.F) != null) {
                    cardCommentsDialog2.D();
                    return;
                }
                return;
            }
            User user = intent == null ? null : (User) intent.getParcelableExtra(AtUserActivity.C);
            if (user == null || (cardCommentsDialog = this.F) == null) {
                return;
            }
            cardCommentsDialog.K(user);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        B0().clearAnimation();
        super.onDestroy();
    }

    @k.e.a.d
    public final CommentAdapter p0() {
        return (CommentAdapter) this.y.getValue();
    }

    public final void p1(boolean z) {
        this.z = z;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        q e2 = q.e(getLayoutInflater());
        e2.i(this);
        e2.j((CardDetailViewModel) L());
        return e2;
    }

    @e
    public final CardCommentsDialog q0() {
        return this.F;
    }

    public final void r1(int i2) {
        this.B = i2;
    }

    public final void s1(int i2) {
        this.versionId = i2;
    }

    @k.e.a.d
    public final e.l.h.j.b.f.a t0() {
        return (e.l.h.j.b.f.a) this.v.getValue();
    }

    public final void t1(@e Boolean bool) {
        this.wish = bool;
    }

    @e
    public final ImageView u0() {
        return this.V;
    }

    @e
    public final ViewGroup v0() {
        return this.W;
    }

    @e
    public final String w0() {
        return this.gameKey;
    }

    public final void w1(@k.e.a.d String str) {
        Pack pack;
        CardDetailInfo value = ((CardDetailViewModel) L()).C0().getValue();
        r rVar = r.a;
        Game b2 = e.l.l.a.b(this.gameKey, this.gameSubKey);
        rVar.e(b2 == null ? null : b2.getShortName(), (value == null || (pack = value.getPack()) == null) ? null : pack.getNameCN(), null, value == null ? null : value.getNameCN(), Integer.valueOf(this.versionId), value == null ? null : value.getNumber(), value == null ? null : value.getRarity(), str);
    }

    @e
    public final String x0() {
        return this.gameSubKey;
    }

    @k.e.a.d
    public final LayoutManagers.a y0() {
        return (LayoutManagers.a) this.u.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a z0() {
        return (LayoutManagers.a) this.x.getValue();
    }
}
