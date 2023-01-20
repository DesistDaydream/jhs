package com.vector.design.ui.adapter.pager;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.umeng.analytics.pro.am;
import com.vector.ext.AnyKt;
import com.vector.view.pager.ViewPager;
import com.vector.view.pager.ViewPager2;
import e.t.k.a.c.h.a;
import e.t.l.h;
import h.k2.v.f0;
import java.lang.ref.WeakReference;
import java.util.List;
import k.b.a.a.n.n.c;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0002\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ \u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010/\u001a\u00020\u0016H\u0016J\u0010\u00100\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0016H\u0016J\u0010\u00101\u001a\u0002022\u0006\u0010+\u001a\u00020\u0016H\u0016J\u0010\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020-H\u0016J\u0012\u00105\u001a\u0004\u0018\u0001062\u0006\u0010+\u001a\u00020\u0016H\u0016J\u0018\u00107\u001a\u00020-2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0016H\u0016J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u000202H\u0002J\b\u0010<\u001a\u00020(H\u0016J\u0010\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u0016H\u0002J\u0018\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020BH\u0016J \u0010C\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0016R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006D"}, d2 = {"Lcom/vector/design/ui/adapter/pager/FragPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "Lcom/vector/design/ui/adapter/pager/BasePagerAdapter;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "manager", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "currItemRef", "Ljava/lang/ref/WeakReference;", "currTransaction", "Landroidx/fragment/app/FragmentTransaction;", "getCurrTransaction", "()Landroidx/fragment/app/FragmentTransaction;", "dataCount", "", "getDataCount", "()I", "isEmpty", "", "()Z", "isLoop", "isRtl", "getManager", "()Landroidx/fragment/app/FragmentManager;", "modify", "pager", "Lcom/vector/design/ui/adapter/pager/Pager;", "getPager", "()Lcom/vector/design/ui/adapter/pager/Pager;", "setPager", "(Lcom/vector/design/ui/adapter/pager/Pager;)V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", c.b, "", "finishUpdate", "getCount", "getItem", "getItemId", "", "getItemPosition", "object", "getPageTitle", "", "instantiateItem", "makeFragmentName", "", "viewId", "id", "notifyDataSetChanged", "reverse", "pos", "setData", am.ax, "viewPager", "Lcom/vector/view/pager/ViewPager;", "setPrimaryItem", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class FragPagerAdapter extends FragmentPagerAdapter implements a {
    @e
    private WeakReference<Fragment> currItemRef;
    @e
    private FragmentTransaction currTransaction;
    private boolean isRtl;
    @d
    private final FragmentManager manager;
    private boolean modify;
    @e
    private e.t.k.a.c.h.c pager;

    private FragPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager, 1);
        this.manager = fragmentManager;
    }

    private final FragmentTransaction getCurrTransaction() {
        if (this.currTransaction == null) {
            this.currTransaction = this.manager.beginTransaction();
        }
        return this.currTransaction;
    }

    private final int getDataCount() {
        e.t.k.a.c.h.c cVar = this.pager;
        if (cVar == null) {
            return 0;
        }
        return cVar.f();
    }

    private final String makeFragmentName(int i2, long j2) {
        return "android:switcher:" + i2 + ':' + j2;
    }

    private final int reverse(int i2) {
        return this.isRtl ? (getCount() - i2) - 1 : i2;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@d ViewGroup viewGroup, int i2, @d Object obj) {
        FragmentTransaction currTransaction;
        Fragment fragment = (Fragment) obj;
        FragmentTransaction currTransaction2 = getCurrTransaction();
        if (currTransaction2 != null) {
            currTransaction2.detach(fragment);
        }
        if (this.modify && (currTransaction = getCurrTransaction()) != null) {
            currTransaction.remove(fragment);
        }
        WeakReference<Fragment> weakReference = this.currItemRef;
        if (f0.g(weakReference == null ? null : weakReference.get(), obj)) {
            WeakReference<Fragment> weakReference2 = this.currItemRef;
            if (weakReference2 != null) {
                weakReference2.clear();
            }
            this.currItemRef = null;
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@d ViewGroup viewGroup) {
        if (getCurrTransaction() != null) {
            FragmentTransaction currTransaction = getCurrTransaction();
            if (currTransaction != null) {
                currTransaction.commitNowAllowingStateLoss();
            }
            this.currTransaction = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        int dataCount = getDataCount();
        if (!isLoop() || dataCount < 2) {
            return dataCount;
        }
        return Integer.MAX_VALUE;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @d
    public Fragment getItem(int i2) throws NullPointerException {
        int reverse;
        if (isLoop()) {
            reverse = reverse(i2) % getDataCount();
        } else {
            reverse = reverse(i2);
        }
        e.t.k.a.c.h.c cVar = this.pager;
        return (Fragment) AnyKt.I(cVar == null ? null : cVar.b(reverse), "Can not new a Fragment.");
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i2) {
        if (isLoop()) {
            i2 %= getDataCount();
        }
        return i2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@d Object obj) {
        return this.modify ? -2 : -1;
    }

    @d
    public final FragmentManager getManager() {
        return this.manager;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @e
    public CharSequence getPageTitle(int i2) {
        List<String> g2;
        e.t.k.a.c.h.c cVar = this.pager;
        if (cVar == null || (g2 = cVar.g()) == null) {
            return null;
        }
        return g2.get(reverse(i2));
    }

    @e
    public final e.t.k.a.c.h.c getPager() {
        return this.pager;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    @d
    public Object instantiateItem(@d ViewGroup viewGroup, int i2) {
        String makeFragmentName = makeFragmentName(viewGroup.getId(), getItemId(i2));
        Fragment findFragmentByTag = this.manager.findFragmentByTag(makeFragmentName);
        if (findFragmentByTag != null) {
            FragmentTransaction currTransaction = getCurrTransaction();
            if (currTransaction != null) {
                currTransaction.attach(findFragmentByTag);
            }
        } else {
            findFragmentByTag = getItem(i2);
            FragmentTransaction currTransaction2 = getCurrTransaction();
            if (currTransaction2 != null) {
                currTransaction2.add(viewGroup.getId(), findFragmentByTag, makeFragmentName);
            }
        }
        WeakReference<Fragment> weakReference = this.currItemRef;
        if (findFragmentByTag != (weakReference == null ? null : weakReference.get())) {
            findFragmentByTag.setMenuVisibility(false);
            FragmentTransaction currTransaction3 = getCurrTransaction();
            if (currTransaction3 != null) {
                currTransaction3.setMaxLifecycle(findFragmentByTag, Lifecycle.State.STARTED);
            }
        }
        return findFragmentByTag;
    }

    public final boolean isEmpty() {
        return getCount() == 0;
    }

    public boolean isLoop() {
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        this.modify = true;
        super.notifyDataSetChanged();
        this.modify = false;
    }

    @Override // e.t.k.a.c.h.a
    public void setData(@d e.t.k.a.c.h.c cVar, @d ViewPager2 viewPager2) {
        a.C0413a.a(this, cVar, viewPager2);
    }

    public final void setPager(@e e.t.k.a.c.h.c cVar) {
        this.pager = cVar;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@d ViewGroup viewGroup, int i2, @d Object obj) {
        if (obj instanceof Fragment) {
            Fragment fragment = (Fragment) obj;
            WeakReference<Fragment> weakReference = this.currItemRef;
            Fragment fragment2 = weakReference == null ? null : weakReference.get();
            if (!f0.g(fragment2, fragment)) {
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(false);
                    FragmentTransaction currTransaction = getCurrTransaction();
                    if (currTransaction != null) {
                        currTransaction.setMaxLifecycle(fragment2, Lifecycle.State.STARTED);
                    }
                }
                fragment.setMenuVisibility(true);
                FragmentTransaction currTransaction2 = getCurrTransaction();
                if (currTransaction2 != null) {
                    currTransaction2.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
                }
                WeakReference<Fragment> weakReference2 = this.currItemRef;
                if (weakReference2 != null) {
                    weakReference2.clear();
                }
                this.currItemRef = new WeakReference<>(fragment);
            }
        }
        new h();
    }

    @Override // e.t.k.a.c.h.a
    public void setData(@d e.t.k.a.c.h.c cVar, @d ViewPager viewPager) {
        this.pager = cVar;
        this.isRtl = viewPager.isRtl();
    }

    public FragPagerAdapter(@d FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager());
    }

    public FragPagerAdapter(@d Fragment fragment) {
        this(fragment.getChildFragmentManager());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FragPagerAdapter(@k.e.a.d android.content.Context r2) {
        /*
            r1 = this;
            boolean r0 = r2 instanceof androidx.fragment.app.FragmentActivity
            if (r0 == 0) goto L7
            androidx.fragment.app.FragmentActivity r2 = (androidx.fragment.app.FragmentActivity) r2
            goto L8
        L7:
            r2 = 0
        L8:
            if (r2 == 0) goto Le
            r1.<init>(r2)
            return
        Le:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "context is not a activity"
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vector.design.ui.adapter.pager.FragPagerAdapter.<init>(android.content.Context):void");
    }
}
