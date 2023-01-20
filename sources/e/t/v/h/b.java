package e.t.v.h;

import com.google.android.material.tabs.TabLayout;
import com.vector.view.pager.ViewPager2;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"setupWithViewPager", "", "Lcom/google/android/material/tabs/TabLayout;", "viewPager", "Lcom/vector/view/pager/ViewPager2;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final void a(@d TabLayout tabLayout, @d ViewPager2 viewPager2) {
        viewPager2.setMediator(new a(tabLayout, viewPager2));
    }
}
