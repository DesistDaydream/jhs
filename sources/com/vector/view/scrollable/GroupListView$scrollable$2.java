package com.vector.view.scrollable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.vector.view.ExpandableListViewEx;
import e.t.u.p;
import h.k2.u.a;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/vector/view/ExpandableListViewEx;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupListView$scrollable$2 extends Lambda implements a<ExpandableListViewEx> {
    public final /* synthetic */ AttributeSet $attrs;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ GroupListView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupListView$scrollable$2(Context context, AttributeSet attributeSet, GroupListView groupListView) {
        super(0);
        this.$context = context;
        this.$attrs = attributeSet;
        this.this$0 = groupListView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @e
    public final ExpandableListViewEx invoke() {
        ExpandableListViewEx expandableListViewEx;
        try {
            try {
                expandableListViewEx = new ExpandableListViewEx(this.$context, this.$attrs);
                GroupListView groupListView = this.this$0;
                expandableListViewEx.setId(View.generateViewId());
                GroupListView.r(groupListView, expandableListViewEx, null, 2, null);
                groupListView.addView(expandableListViewEx, p.l(-1, -1));
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
            expandableListViewEx = new ExpandableListViewEx(this.$context);
            GroupListView groupListView2 = this.this$0;
            expandableListViewEx.setId(View.generateViewId());
            GroupListView.r(groupListView2, expandableListViewEx, null, 2, null);
            groupListView2.addView(expandableListViewEx, p.l(-1, -1));
        }
        return expandableListViewEx;
    }
}
