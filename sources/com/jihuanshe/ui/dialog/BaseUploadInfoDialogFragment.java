package com.jihuanshe.ui.dialog;

import android.net.Uri;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.donkingliang.labels.LabelsView;
import com.jihuanshe.R;
import com.jihuanshe.model.ImageErrorInfo;
import com.jihuanshe.net.api.FileInfo;
import com.jihuanshe.utils.ImagePicker;
import com.jihuanshe.viewmodel.UploadViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.ext.view.ViewKt;
import com.vector.network.image.NImageView;
import e.l.k.c5;
import e.l.q.a.w;
import e.n.f;
import e.t.j.h.g;
import e.t.k.a.f.h;
import e.t.o.d;
import e.t.r.a.b;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.z;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public abstract class BaseUploadInfoDialogFragment extends w {
    public static final /* synthetic */ n<Object>[] t;
    @e

    /* renamed from: f  reason: collision with root package name */
    private h f3942f;
    @d
    private final g q;
    @d
    private final g r;
    @d
    private final g s;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final h.w f3941e = z.c(new BaseUploadInfoDialogFragment$viewModel$2(this));
    @d

    /* renamed from: g  reason: collision with root package name */
    private final ImagePicker f3943g = new ImagePicker(this, 0, 0.0f, new BaseUploadInfoDialogFragment$imagePicker$1(this), 6, (u) null);

    /* renamed from: h  reason: collision with root package name */
    private final int f3944h = 1;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final List<FileInfo> f3945i = new ArrayList();
    @d

    /* renamed from: j  reason: collision with root package name */
    private final f<Uri> f3946j = new f<>(null);
    @d

    /* renamed from: k  reason: collision with root package name */
    private final f<Uri> f3947k = new f<>(null);
    @d

    /* renamed from: l  reason: collision with root package name */
    private final f<Uri> f3948l = new f<>(null);
    @d

    /* renamed from: m  reason: collision with root package name */
    private final b f3949m = new b(d.a.c(e.t.o.d.a, null, 1, null).d(9));
    @k.e.a.d
    private final h.m2.e n = BindViewKt.r(this, R.id.editText);
    @k.e.a.d
    private final h.m2.e o = BindViewKt.r(this, R.id.tvUpLoad);
    @k.e.a.d
    private final h.m2.e p = BindViewKt.r(this, R.id.labelsView);

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(BaseUploadInfoDialogFragment.class), "mEditText", "getMEditText()Landroid/widget/EditText;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(BaseUploadInfoDialogFragment.class), "tvUpLoad", "getTvUpLoad()Landroid/widget/TextView;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(BaseUploadInfoDialogFragment.class), "labelsView", "getLabelsView()Lcom/donkingliang/labels/LabelsView;"));
        t = nVarArr;
    }

    public BaseUploadInfoDialogFragment() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.q = dVar.a(new BaseUploadInfoDialogFragment$onClickUpLoad$1(this));
        this.r = dVar.a(new BaseUploadInfoDialogFragment$onClickClose$1(this));
        this.s = dVar.a(new BaseUploadInfoDialogFragment$onClickSubmit$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LabelsView M() {
        return (LabelsView) this.p.a(this, t[3]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText O() {
        return (EditText) this.n.a(this, t[1]);
    }

    private final TextView W() {
        return (TextView) this.o.a(this, t[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UploadViewModel Z() {
        return (UploadViewModel) this.f3941e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        int size = this.f3945i.size();
        if (size == 0) {
            ViewKt.I(W());
            this.f3946j.setValue(null);
            this.f3947k.setValue(null);
            this.f3948l.setValue(null);
        } else if (size == 1) {
            ViewKt.I(W());
            this.f3946j.setValue(this.f3945i.get(0).getUri());
            this.f3947k.setValue(null);
            this.f3948l.setValue(null);
        } else if (size == 2) {
            ViewKt.I(W());
            this.f3946j.setValue(this.f3945i.get(0).getUri());
            this.f3947k.setValue(this.f3945i.get(1).getUri());
            this.f3948l.setValue(null);
        } else if (size != 3) {
        } else {
            ViewKt.n(W());
            this.f3946j.setValue(this.f3945i.get(0).getUri());
            this.f3947k.setValue(this.f3945i.get(1).getUri());
            this.f3948l.setValue(this.f3945i.get(2).getUri());
        }
    }

    public final void I(@k.e.a.d FileInfo fileInfo) {
        this.f3945i.add(fileInfo);
        c0();
    }

    @k.e.a.d
    public final f<Uri> J() {
        return this.f3947k;
    }

    @k.e.a.d
    public abstract f<List<String>> K();

    @k.e.a.d
    public abstract String L();

    @k.e.a.d
    public final f<Uri> N() {
        return this.f3946j;
    }

    @k.e.a.d
    public final g P() {
        return this.r;
    }

    @k.e.a.d
    public final g Q() {
        return this.s;
    }

    @k.e.a.d
    public final g R() {
        return this.q;
    }

    @k.e.a.d
    public final f<Uri> S() {
        return this.f3948l;
    }

    public final int T() {
        return this.f3944h;
    }

    @k.e.a.d
    public final b U() {
        return this.f3949m;
    }

    @k.e.a.d
    public abstract String V();

    @k.e.a.d
    public final List<FileInfo> X() {
        return this.f3945i;
    }

    @k.e.a.d
    public abstract String Y();

    @k.e.a.d
    public final g a0(int i2) {
        return e.t.j.h.d.a.a(new BaseUploadInfoDialogFragment$onClickDel$1(this, i2));
    }

    @k.e.a.d
    public final g b0(@k.e.a.d NImageView nImageView, int i2) {
        return e.t.j.h.d.a.a(BaseUploadInfoDialogFragment$onClickPreview$1.INSTANCE);
    }

    @Override // e.l.q.a.w
    public void d() {
    }

    public abstract void d0(@k.e.a.d ImageErrorInfo imageErrorInfo);

    @Override // e.l.q.a.w
    @k.e.a.d
    public ViewDataBinding p(@e ViewGroup viewGroup) {
        c5 e2 = c5.e(getLayoutInflater(), viewGroup, false);
        e2.h(this);
        return e2;
    }

    @Override // e.l.q.a.w
    public int u() {
        return 80;
    }
}
