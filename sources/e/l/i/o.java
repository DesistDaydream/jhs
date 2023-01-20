package e.l.i;

import androidx.databinding.BindingAdapter;
import com.donkingliang.labels.LabelsView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class o {
    @k.e.a.d
    public static final o a = new o();
    @k.e.a.d
    private static final String b = "android:labels_data";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12184c = "android:labels_click";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12185d = "android:labels_state_change";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f12186e = "android:labels_maxLines";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final String f12187f = "android:labels_selects";
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final String f12188g = "android:labels_type";
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private static final String f12189h = "android:labels_limit";

    private o() {
    }

    @BindingAdapter(requireAll = false, value = {b, f12186e, f12184c, f12185d, f12187f, f12188g, f12189h})
    @h.k2.k
    public static final void a(@k.e.a.d LabelsView labelsView, @k.e.a.e List<String> list, @k.e.a.e Integer num, @k.e.a.e LabelsView.c cVar, @k.e.a.e LabelsView.e eVar, @k.e.a.e List<Integer> list2, @k.e.a.e Integer num2, @k.e.a.e Integer num3) {
        ArrayList arrayList;
        int intValue;
        if (list == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(h.a2.u.Y(list, 10));
            for (String str : list) {
                if (num3 != null && str.length() > (intValue = num3.intValue())) {
                    Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                    str = h.k2.v.f0.C(str.substring(0, intValue), "...");
                }
                arrayList2.add(str);
            }
            arrayList = arrayList2;
        }
        labelsView.setLabels(arrayList);
        if (num != null) {
            labelsView.setMaxLines(num.intValue());
        }
        labelsView.setOnLabelClickListener(cVar);
        labelsView.setOnLabelSelectChangeListener(eVar);
        labelsView.setSelectType(LabelsView.SelectType.valueOf((num2 != null && num2.intValue() == 2) ? "MULTI" : "SINGLE"));
        if (list2 == null) {
            return;
        }
        labelsView.setSelects(list2);
    }
}
