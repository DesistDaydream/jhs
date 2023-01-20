package com.vector;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tencent.qcloud.tuicore.TUIConstants;
import e.t.j.c;
import e.t.j.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final int a = 1;
    private static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f7636c;

    /* loaded from: classes3.dex */
    public static class a {
        public static final SparseArray<String> a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(2);
            a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, TUIConstants.TUIChat.OWNER);
        }

        private a() {
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static final HashMap<String, Integer> a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(2);
            a = hashMap;
            hashMap.put("layout/layout_dialog_loading_0", Integer.valueOf(R.layout.layout_dialog_loading));
            hashMap.put("layout/layout_side_bar_pop_0", Integer.valueOf(R.layout.layout_side_bar_pop));
        }

        private b() {
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        f7636c = sparseIntArray;
        sparseIntArray.put(R.layout.layout_dialog_loading, 1);
        sparseIntArray.put(R.layout.layout_side_bar_pop, 2);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i2) {
        return a.a.get(i2);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = f7636c.get(i2);
        if (i3 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                if (i3 == 1) {
                    if ("layout/layout_dialog_loading_0".equals(tag)) {
                        return new c(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_dialog_loading is invalid. Received: " + tag);
                } else if (i3 != 2) {
                    return null;
                } else {
                    if ("layout/layout_side_bar_pop_0".equals(tag)) {
                        return new e(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_side_bar_pop is invalid. Received: " + tag);
                }
            }
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f7636c.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
