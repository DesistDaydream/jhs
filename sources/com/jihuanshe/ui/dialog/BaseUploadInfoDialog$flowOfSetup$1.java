package com.jihuanshe.ui.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.jihuanshe.ui.dialog.BaseUploadInfoDialog;
import com.jihuanshe.ui.dialog.BaseUploadInfoDialog$flowOfSetup$1;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BaseUploadInfoDialog$flowOfSetup$1 extends Lambda implements l<List<? extends String>, t1> {
    public final /* synthetic */ BaseUploadInfoDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseUploadInfoDialog$flowOfSetup$1(BaseUploadInfoDialog baseUploadInfoDialog) {
        super(1);
        this.this$0 = baseUploadInfoDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m16invoke$lambda0(BaseUploadInfoDialog baseUploadInfoDialog) {
        View contentView = baseUploadInfoDialog.getContentView();
        ViewGroup.LayoutParams layoutParams = contentView == null ? null : contentView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            View contentView2 = baseUploadInfoDialog.getContentView();
            layoutParams2.height = contentView2 == null ? -2 : contentView2.getMeasuredHeight();
        }
        View contentView3 = baseUploadInfoDialog.getContentView();
        if (contentView3 == null) {
            return;
        }
        contentView3.setLayoutParams(layoutParams2);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends String> list) {
        invoke2((List<String>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d List<String> list) {
        View contentView = this.this$0.getContentView();
        ViewGroup.LayoutParams layoutParams = contentView == null ? null : contentView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.height = -2;
        }
        View contentView2 = this.this$0.getContentView();
        if (contentView2 != null) {
            contentView2.requestLayout();
        }
        View contentView3 = this.this$0.getContentView();
        if (contentView3 == null) {
            return;
        }
        final BaseUploadInfoDialog baseUploadInfoDialog = this.this$0;
        contentView3.postDelayed(new Runnable() { // from class: e.l.q.a.h
            @Override // java.lang.Runnable
            public final void run() {
                BaseUploadInfoDialog$flowOfSetup$1.m16invoke$lambda0(BaseUploadInfoDialog.this);
            }
        }, 50L);
    }
}
