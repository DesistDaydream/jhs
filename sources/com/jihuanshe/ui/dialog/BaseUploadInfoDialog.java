package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.donkingliang.labels.LabelsView;
import com.jihuanshe.R;
import com.jihuanshe.model.ImageErrorInfo;
import com.jihuanshe.net.api.FileInfo;
import com.jihuanshe.utils.ImagePicker;
import com.vector.ext.bind.BindViewKt;
import com.vector.ext.view.ViewKt;
import com.vector.network.image.NImageView;
import e.l.k.w3;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.n.f;
import e.t.j.h.g;
import e.t.o.d;
import e.t.r.a.b;
import h.k2.u.l;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public abstract class BaseUploadInfoDialog extends BaseDialog {
    public static final /* synthetic */ n<Object>[] I = {n0.r(new PropertyReference1Impl(n0.d(BaseUploadInfoDialog.class), "mEditText", "getMEditText()Landroid/widget/EditText;")), n0.r(new PropertyReference1Impl(n0.d(BaseUploadInfoDialog.class), "tvUpLoad", "getTvUpLoad()Landroid/widget/TextView;")), n0.r(new PropertyReference1Impl(n0.d(BaseUploadInfoDialog.class), "labelsView", "getLabelsView()Lcom/donkingliang/labels/LabelsView;"))};
    @d
    private final f<Uri> A;
    @d
    private final b B;
    @d
    private final e C;
    @d
    private final e D;
    @d
    private final e E;
    @d
    private final g F;
    @d
    private final g G;
    @d
    private final g H;
    @d
    private final f<List<String>> t;
    @d
    private final ImagePicker u;
    @d
    private final l<ImageErrorInfo, t1> v;
    private final int w;
    @d
    private final List<FileInfo> x;
    @d
    private final f<Uri> y;
    @d
    private final f<Uri> z;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseUploadInfoDialog(@d Context context, @d f<List<String>> fVar, @d ImagePicker imagePicker, @d l<? super ImageErrorInfo, t1> lVar) {
        super(context);
        this.t = fVar;
        this.u = imagePicker;
        this.v = lVar;
        this.w = 1;
        this.x = new ArrayList();
        this.y = new f<>(null);
        this.z = new f<>(null);
        this.A = new f<>(null);
        this.B = new b(d.a.c(e.t.o.d.a, null, 1, null).d(9));
        this.C = BindViewKt.p(this, R.id.editText);
        this.D = BindViewKt.p(this, R.id.tvUpLoad);
        this.E = BindViewKt.p(this, R.id.labelsView);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.F = dVar.a(new BaseUploadInfoDialog$onClickUpLoad$1(this));
        this.G = dVar.a(new BaseUploadInfoDialog$onClickClose$1(this));
        this.H = dVar.a(new BaseUploadInfoDialog$onClickSubmit$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        int size = this.x.size();
        if (size == 0) {
            ViewKt.I(getTvUpLoad());
            this.y.setValue(null);
            this.z.setValue(null);
            this.A.setValue(null);
        } else if (size == 1) {
            ViewKt.I(getTvUpLoad());
            this.y.setValue(this.x.get(0).getUri());
            this.z.setValue(null);
            this.A.setValue(null);
        } else if (size == 2) {
            ViewKt.I(getTvUpLoad());
            this.y.setValue(this.x.get(0).getUri());
            this.z.setValue(this.x.get(1).getUri());
            this.A.setValue(null);
        } else if (size != 3) {
        } else {
            ViewKt.n(getTvUpLoad());
            this.y.setValue(this.x.get(0).getUri());
            this.z.setValue(this.x.get(1).getUri());
            this.A.setValue(this.x.get(2).getUri());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LabelsView getLabelsView() {
        return (LabelsView) this.E.a(this, I[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText getMEditText() {
        return (EditText) this.C.a(this, I[0]);
    }

    private final TextView getTvUpLoad() {
        return (TextView) this.D.a(this, I[1]);
    }

    public final void F(@k.e.a.d FileInfo fileInfo) {
        this.x.add(fileInfo);
        I();
    }

    @k.e.a.d
    public final g G(int i2) {
        return e.t.j.h.d.a.a(new BaseUploadInfoDialog$onClickDel$1(this, i2));
    }

    @k.e.a.d
    public final g H(@k.e.a.d NImageView nImageView, int i2) {
        return e.t.j.h.d.a.a(BaseUploadInfoDialog$onClickPreview$1.INSTANCE);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public ViewDataBinding d() {
        w3 e2 = w3.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @k.e.a.d
    public final f<Uri> getCenterUrl() {
        return this.z;
    }

    @k.e.a.d
    public final f<List<String>> getData() {
        return this.t;
    }

    @k.e.a.d
    public abstract String getEditHint();

    @k.e.a.d
    public final ImagePicker getImagePicker() {
        return this.u;
    }

    @k.e.a.d
    public final f<Uri> getLeftUrl() {
        return this.y;
    }

    @k.e.a.d
    public final g getOnClickClose() {
        return this.G;
    }

    @k.e.a.d
    public final g getOnClickSubmit() {
        return this.H;
    }

    @k.e.a.d
    public final g getOnClickUpLoad() {
        return this.F;
    }

    @k.e.a.d
    public final f<Uri> getRightUrl() {
        return this.A;
    }

    public final int getSelectType() {
        return this.w;
    }

    @k.e.a.d
    public final b getShape() {
        return this.B;
    }

    @k.e.a.d
    public final l<ImageErrorInfo, t1> getSubmit() {
        return this.v;
    }

    @k.e.a.d
    public abstract String getTitleText();

    @k.e.a.d
    public final List<FileInfo> getUpLoadData() {
        return this.x;
    }

    @k.e.a.d
    public abstract String getUploadTips();

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setMoveWithKeyboard(true);
        setGravity(80);
        this.t.f(this, new BaseUploadInfoDialog$flowOfSetup$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public k l(@k.e.a.d View view) {
        return new r(view);
    }
}
