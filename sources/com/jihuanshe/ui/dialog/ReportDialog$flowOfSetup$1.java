package com.jihuanshe.ui.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.ui.dialog.ReportDialog$flowOfSetup$1;
import e.t.o.d;
import h.k2.u.l;
import h.q2.m;
import h.t1;
import java.util.List;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReportDialog$flowOfSetup$1 extends Lambda implements l<List<? extends String>, t1> {
    public final /* synthetic */ ReportDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportDialog$flowOfSetup$1(ReportDialog reportDialog) {
        super(1);
        this.this$0 = reportDialog;
    }

    /* renamed from: invoke$lambda-1 */
    public static final void m20invoke$lambda1(ReportDialog reportDialog, List list) {
        m<View> children;
        int measuredHeight;
        View contentView = reportDialog.getContentView();
        ViewGroup.LayoutParams layoutParams = contentView == null ? null : contentView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        int i2 = 0;
        View contentView2 = reportDialog.getContentView();
        ViewGroup viewGroup = contentView2 instanceof ViewGroup ? (ViewGroup) contentView2 : null;
        if (viewGroup != null && (children = ViewGroupKt.getChildren(viewGroup)) != null) {
            for (View view : children) {
                if (view instanceof RecyclerView) {
                    measuredHeight = list.size() * d.a.c(d.a, null, 1, null).d(56);
                } else {
                    measuredHeight = view.getMeasuredHeight();
                }
                i2 += measuredHeight;
            }
        }
        if (layoutParams2 != null) {
            layoutParams2.height = i2;
        }
        reportDialog.getContentView().setLayoutParams(layoutParams2);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends String> list) {
        invoke2((List<String>) list);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@k.e.a.d final List<String> list) {
        View contentView = this.this$0.getContentView();
        if (contentView == null) {
            return;
        }
        final ReportDialog reportDialog = this.this$0;
        contentView.postDelayed(new Runnable() { // from class: e.l.q.a.q
            @Override // java.lang.Runnable
            public final void run() {
                ReportDialog$flowOfSetup$1.m20invoke$lambda1(reportDialog, list);
            }
        }, 50L);
    }
}
