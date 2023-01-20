package e.t.k.a.c;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/vector/design/ui/adapter/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class b extends RecyclerView.ViewHolder {
    @k.e.a.e
    private ViewDataBinding a;

    public b(@k.e.a.d View view) {
        super(view);
    }

    @k.e.a.e
    public final ViewDataBinding a() {
        return this.a;
    }

    public final void b(@k.e.a.e ViewDataBinding viewDataBinding) {
        this.a = viewDataBinding;
    }

    public b(@k.e.a.d ViewDataBinding viewDataBinding) {
        this(viewDataBinding.getRoot());
        this.a = viewDataBinding;
    }
}
