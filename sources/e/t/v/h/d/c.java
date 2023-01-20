package e.t.v.h.d;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.vector.view.pager.ViewPager2;

/* loaded from: classes3.dex */
public interface c extends ViewPager.OnPageChangeListener {
    void a(ViewPager2 viewPager2, int i2);

    void b(ViewPager viewPager, int i2);

    void e();

    void setCurrentItem(int i2);

    void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback);

    void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener);

    void setViewPager(ViewPager viewPager);

    void setViewPager2(com.vector.view.pager.ViewPager2 viewPager2);
}
