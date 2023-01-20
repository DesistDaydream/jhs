package e.j.a.c.m;

import androidx.fragment.app.Fragment;
import com.google.android.material.datepicker.DateSelector;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public abstract class l<S> extends Fragment {
    public final LinkedHashSet<k<S>> a = new LinkedHashSet<>();

    public boolean p(k<S> kVar) {
        return this.a.add(kVar);
    }

    public void q() {
        this.a.clear();
    }

    public abstract DateSelector<S> r();

    public boolean s(k<S> kVar) {
        return this.a.remove(kVar);
    }
}
