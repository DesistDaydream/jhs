package com.vector.view.scrollable;

import android.database.DataSetObserver;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0007\n\u0000\n\u0000*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "com/vector/view/scrollable/GroupListView$dataSetObserver$2$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupListView$dataSetObserver$2 extends Lambda implements h.k2.u.a<a> {
    public final /* synthetic */ GroupListView this$0;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/vector/view/scrollable/GroupListView$dataSetObserver$2$1", "Landroid/database/DataSetObserver;", "onChanged", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a extends DataSetObserver {
        public final /* synthetic */ GroupListView a;

        public a(GroupListView groupListView) {
            this.a = groupListView;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (this.a.getAutoExpandCollapse()) {
                if (this.a.getExpandAll()) {
                    this.a.k();
                } else {
                    this.a.j();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupListView$dataSetObserver$2(GroupListView groupListView) {
        super(0);
        this.this$0 = groupListView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final a invoke() {
        return new a(this.this$0);
    }
}
