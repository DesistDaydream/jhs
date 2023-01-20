package e.t.k.a.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.qcloud.tuicore.TUIConstants;
import e.t.l.h;
import e.t.q.a;
import h.k2.v.u;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u0011\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001f\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H&J4\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0017\u0010 \u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0011H\u0016J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H&J,\u0010%\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J%\u0010)\u001a\u00020*2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010+\u001a\u00028\u00012\u0006\u0010,\u001a\u00020-H&¢\u0006\u0002\u0010.J%\u0010/\u001a\u00020*2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010+\u001a\u00028\u00002\u0006\u0010,\u001a\u00020-H&¢\u0006\u0002\u00100R4\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/vector/design/ui/adapter/GroupMultiAdapterEx;", "GROUP", "Lcom/vector/model/Group;", "CHILD", "Landroid/widget/BaseExpandableListAdapter;", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "value", "", "data", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getChild", "groupPosition", "", "childPosition", "(II)Ljava/lang/Object;", "getChildId", "", "getChildLayoutId", "viewType", "getChildView", "Landroid/view/View;", "isLastChild", "", "convertView", "parent", "Landroid/view/ViewGroup;", "getChildrenCount", "getGroup", "(I)Lcom/vector/model/Group;", "getGroupCount", "getGroupId", "getGroupLayoutId", "getGroupView", "isExpanded", "hasStableIds", "isChildSelectable", "onBindChildBinding", "", "item", "binding", "Landroidx/databinding/ViewDataBinding;", "(ILjava/lang/Object;Landroidx/databinding/ViewDataBinding;)V", "onBindGroupBinding", "(ILcom/vector/model/Group;Landroidx/databinding/ViewDataBinding;)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class e<GROUP extends e.t.q.a<CHILD>, CHILD> extends BaseExpandableListAdapter {
    @k.e.a.e
    private final LifecycleOwner a;
    @k.e.a.e
    private List<? extends GROUP> b;

    public e() {
        this(null, 1, null);
    }

    public /* synthetic */ e(LifecycleOwner lifecycleOwner, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : lifecycleOwner);
    }

    public abstract int a(int i2);

    @k.e.a.e
    public final List<GROUP> b() {
        return (List<? extends GROUP>) this.b;
    }

    @Override // android.widget.ExpandableListAdapter
    @k.e.a.e
    /* renamed from: c */
    public GROUP getGroup(int i2) {
        List<? extends GROUP> list = this.b;
        if (list == null) {
            return null;
        }
        return list.get(i2);
    }

    public abstract int d(int i2);

    public abstract void e(int i2, CHILD child, @k.e.a.d ViewDataBinding viewDataBinding);

    public abstract void f(int i2, @k.e.a.d GROUP group, @k.e.a.d ViewDataBinding viewDataBinding);

    public final void g(@k.e.a.e List<? extends GROUP> list) {
        this.b = list;
        if (list == null) {
            return;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    @k.e.a.e
    public CHILD getChild(int i2, int i3) {
        GROUP group;
        List<? extends GROUP> list = this.b;
        if (list == null || (group = list.get(i2)) == null) {
            return null;
        }
        return (CHILD) group.b(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i2, int i3) {
        return i3;
    }

    @Override // android.widget.ExpandableListAdapter
    @k.e.a.d
    public View getChildView(int i2, int i3, boolean z, @k.e.a.e View view, @k.e.a.e ViewGroup viewGroup) {
        ViewDataBinding a;
        CHILD child;
        int childType = getChildType(i2, i3);
        if (view == null) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup == null ? null : viewGroup.getContext()), a(childType), viewGroup, false);
            View root = inflate.getRoot();
            inflate.setLifecycleOwner(this.a);
            root.setTag(new b(inflate));
            view = root;
        }
        Object tag = view.getTag();
        if (tag != null && (tag instanceof b) && (a = ((b) tag).a()) != null && (child = getChild(i2, i3)) != null) {
            e(childType, child, a);
            a.executePendingBindings();
        }
        new h();
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i2) {
        GROUP group = getGroup(i2);
        if (group == null) {
            return 0;
        }
        return group.d();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        List<? extends GROUP> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    @k.e.a.d
    public View getGroupView(int i2, boolean z, @k.e.a.e View view, @k.e.a.e ViewGroup viewGroup) {
        ViewDataBinding a;
        GROUP group;
        int groupType = getGroupType(i2);
        if (view == null) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup == null ? null : viewGroup.getContext()), d(groupType), viewGroup, false);
            View root = inflate.getRoot();
            inflate.setLifecycleOwner(this.a);
            root.setTag(new b(inflate));
            view = root;
        }
        Object tag = view.getTag();
        if (tag != null && (tag instanceof b) && (a = ((b) tag).a()) != null && (group = getGroup(i2)) != null) {
            f(groupType, group, a);
            a.executePendingBindings();
        }
        new h();
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i2, int i3) {
        return true;
    }

    public e(@k.e.a.e LifecycleOwner lifecycleOwner) {
        this.a = lifecycleOwner;
    }
}
