package com.jihuanshe.ui.page.main;

import android.content.Intent;
import android.net.Uri;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.jihuanshe.R;
import com.jihuanshe.model.RouterInfo;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.page.im.ImConversationFragment;
import com.jihuanshe.ui.page.main.MainActivity;
import com.jihuanshe.ui.page.main.me.MeFragment;
import com.jihuanshe.ui.page.main.shop.ShopFragment;
import com.jihuanshe.ui.widget.bottomtab.BottomTabLayout;
import com.jihuanshe.utils.UpdateManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.ext.bind.BindViewKt;
import e.l.k.i1;
import e.l.p.a.a;
import e.l.r.r0;
import e.l.r.s0;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.y;
import e.t.k.a.c.h.c;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import inject.annotation.creator.Creator;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class MainActivity extends BaseActivity<e.l.s.i.a> {
    private static final int A = 1;
    private static final int B = 2;
    @d
    private static final String y = "MainActivity";
    private static final int z = 0;
    @e
    private ShopFragment q;
    @e
    private ImConversationFragment r;
    @f.a.a.a(true)
    @e
    private String routeUrl;
    @e
    private MeFragment s;
    public static final /* synthetic */ n<Object>[] x = {n0.r(new PropertyReference1Impl(n0.d(MainActivity.class), "bottomTab", "getBottomTab()Lcom/jihuanshe/ui/widget/bottomtab/BottomTabLayout;"))};
    @d
    public static final a w = new a(null);
    @d
    private final f<c> n = new f<>(c0());
    @d
    private final FragPagerAdapter o = new FragPagerAdapter((FragmentActivity) this);
    @d
    private final h.m2.e p = BindViewKt.n(this, R.id.bottomTab);
    @d
    private final BottomTabLayout.a t = new BottomTabLayout.a() { // from class: com.jihuanshe.ui.page.main.MainActivity$onTabSelect$1
        @Override // com.jihuanshe.ui.widget.bottomtab.BottomTabLayout.a
        public boolean a(@d e.l.q.c.p0.c cVar) {
            s0.c(MainActivity.this, 2);
            String g2 = cVar.g();
            int hashCode = g2.hashCode();
            if (hashCode != 3480) {
                if (hashCode != 3052376) {
                    if (hashCode == 3529462 && g2.equals(a.f14121c)) {
                        ((e.l.s.i.a) MainActivity.this.L()).p0().setValue(0);
                        return true;
                    }
                } else if (g2.equals(a.f14122d)) {
                    return e.l.l.a.d(new MainActivity$onTabSelect$1$onTabSelected$1(MainActivity.this));
                }
            } else if (g2.equals(a.f14123e)) {
                return e.l.l.a.d(new MainActivity$onTabSelect$1$onTabSelected$2(MainActivity.this));
            }
            return true;
        }
    };
    @d
    private final y u = d.j.a.c(new MainActivity$onPageSelected$1(this));
    @k.e.a.d
    private final g v = e.t.j.h.d.a.a(new MainActivity$wantSellOnClick$1(this));

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    private final c c0() {
        return e.t.k.a.c.h.d.i(3, null, null, new MainActivity$bindPager$1(this), 6, null);
    }

    public static final void d0(MainActivity mainActivity, String str, String str2, Map map) {
        Long l2 = (Long) map.get(TUIConstants.TUIConversation.TOTAL_UNREAD_COUNT);
        ((e.l.s.i.a) mainActivity.L()).q0().a().get(1).q((int) (l2 == null ? 0L : l2.longValue()));
    }

    private final BottomTabLayout f0() {
        return (BottomTabLayout) this.p.a(this, x[0]);
    }

    private final boolean m0() {
        String str = this.routeUrl;
        if (str == null || str.length() == 0) {
            return false;
        }
        r0 r0Var = r0.a;
        RouterInfo b = r0Var.b(Uri.parse(this.routeUrl));
        this.routeUrl = null;
        r0Var.d(this, b);
        return true;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        m0();
        UpdateManager updateManager = UpdateManager.a;
        if (!updateManager.e(getSupportFragmentManager(), MainActivity$flowOfSetup$1.INSTANCE)) {
            UpdateManager.d(updateManager, getSupportFragmentManager(), null, 2, null);
        }
        TUICore.registerEvent(TUIConstants.TUIConversation.EVENT_UNREAD, TUIConstants.TUIConversation.EVENT_SUB_KEY_UNREAD_CHANGED, new ITUINotification() { // from class: e.l.q.b.g.a
            {
                MainActivity.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.interfaces.ITUINotification
            public final void onNotifyEvent(String str, String str2, Map map) {
                MainActivity.d0(MainActivity.this, str, str2, map);
            }
        });
        e.l.h.d.f.b.e(this).g(e.l.h.d.g.b, MainActivity$flowOfSetup$3.INSTANCE);
    }

    @k.e.a.d
    public final FragPagerAdapter e0() {
        return this.o;
    }

    @k.e.a.d
    public final y g0() {
        return this.u;
    }

    @k.e.a.d
    public final BottomTabLayout.a h0() {
        return this.t;
    }

    @k.e.a.d
    public final f<c> i0() {
        return this.n;
    }

    @e
    public final String j0() {
        return this.routeUrl;
    }

    @k.e.a.d
    public final g k0() {
        return this.v;
    }

    public final void n0(@e String str) {
        this.routeUrl = str;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Integer value = ((e.l.s.i.a) L()).p0().getValue();
        if (value == null || value.intValue() != 0) {
            f0().f(0);
        } else {
            moveTaskToBack(false);
        }
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@e Intent intent) {
        super.onNewIntent(intent);
        m0();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        i1 e2 = i1.e(getLayoutInflater());
        e2.i(this);
        e2.j((e.l.s.i.a) L());
        return e2;
    }
}
