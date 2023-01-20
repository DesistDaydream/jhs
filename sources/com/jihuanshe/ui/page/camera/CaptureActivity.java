package com.jihuanshe.ui.page.camera;

import android.content.Intent;
import android.net.Uri;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.page.camera.CaptureActivity;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.Res;
import com.yalantis.ucrop.view.OverlayView;
import e.l.k.o;
import e.l.r.v;
import e.t.j.h.g;
import e.t.o.d;
import e.t.u.b0;
import e.t.u.m;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.t1;
import inject.annotation.creator.Creator;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class CaptureActivity extends BaseActivity<e.l.h.l.b> {
    @d
    public static final String u = "CaptureActivity";
    private ImageCapture n;
    @e
    private Uri r;
    public static final /* synthetic */ n<Object>[] t = {n0.r(new PropertyReference1Impl(n0.d(CaptureActivity.class), "mPreviewView", "getMPreviewView()Landroidx/camera/view/PreviewView;")), n0.r(new PropertyReference1Impl(n0.d(CaptureActivity.class), "mOverlayView", "getMOverlayView()Lcom/yalantis/ucrop/view/OverlayView;"))};
    @d
    public static final a s = new a(null);
    @d
    private static final String v = "result";
    @f.a.a.a
    @e
    private Float ratio = Float.valueOf(1.0f);
    @d
    private final h.m2.e o = BindViewKt.n(this, R.id.previewView);
    @d
    private final h.m2.e p = BindViewKt.n(this, R.id.overlayView);
    @d
    private final g q = e.t.j.h.d.a.a(new CaptureActivity$onClickCapture$1(this));

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final String a() {
            return CaptureActivity.v;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements ImageCapture.OnImageSavedCallback {
        public final /* synthetic */ File b;

        public b(File file) {
            CaptureActivity.this = r1;
            this.b = file;
        }

        @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
        public void onError(@d ImageCaptureException imageCaptureException) {
            e.l.h.j.b.e.f(this, Res.w(Res.a, R.string.capture_error, null, 2, null), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            e.l.h.k.b.a.c(CaptureActivity.u, f0.C("Photo capture failed: ", imageCaptureException.getMessage()), imageCaptureException);
        }

        @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
        public void onImageSaved(@d ImageCapture.OutputFileResults outputFileResults) {
            CaptureActivity captureActivity = CaptureActivity.this;
            captureActivity.r = v.a(captureActivity, this.b);
            CaptureActivity.this.finish();
        }
    }

    private final OverlayView Z() {
        return (OverlayView) this.p.a(this, t[1]);
    }

    private final PreviewView a0() {
        return (PreviewView) this.o.a(this, t[0]);
    }

    private final void f0() {
        final e.j.c.a.a.a<ProcessCameraProvider> processCameraProvider = ProcessCameraProvider.getInstance(this);
        processCameraProvider.addListener(new Runnable() { // from class: e.l.q.b.a.a
            @Override // java.lang.Runnable
            public final void run() {
                CaptureActivity.g0(processCameraProvider, this);
            }
        }, ContextCompat.getMainExecutor(this));
    }

    public static final void g0(e.j.c.a.a.a aVar, CaptureActivity captureActivity) {
        ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) aVar.get();
        Preview build = new Preview.Builder().build();
        captureActivity.n = new ImageCapture.Builder().build();
        CameraSelector build2 = new CameraSelector.Builder().requireLensFacing(1).build();
        try {
            processCameraProvider.unbindAll();
            UseCase[] useCaseArr = new UseCase[2];
            useCaseArr[0] = build;
            ImageCapture imageCapture = captureActivity.n;
            if (imageCapture != null) {
                useCaseArr[1] = imageCapture;
                processCameraProvider.bindToLifecycle(captureActivity, build2, useCaseArr);
                build.setSurfaceProvider(captureActivity.a0().getSurfaceProvider());
                return;
            }
            throw null;
        } catch (Exception e2) {
            e.l.h.k.b.a.c(u, "Use case binding failed", e2);
        }
    }

    public final void h0() {
        File externalCacheDir = getApplicationContext().getExternalCacheDir();
        File file = new File(externalCacheDir == null ? null : externalCacheDir.getPath(), f0.C(new SimpleDateFormat(b0.a.f14658i, Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())), ".jpg"));
        ImageCapture.OutputFileOptions build = new ImageCapture.OutputFileOptions.Builder(file).build();
        ImageCapture imageCapture = this.n;
        Objects.requireNonNull(imageCapture);
        imageCapture.n(build, ContextCompat.getMainExecutor(this), new b(file));
    }

    @Override // com.jihuanshe.ui.BaseActivity
    public void V() {
        e.t.l.d.d(this, new m.a(ViewCompat.MEASURED_STATE_MASK));
    }

    @d
    public final g b0() {
        return this.q;
    }

    @e
    public final Float c0() {
        return this.ratio;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        f0();
        getWindow().setNavigationBarColor(ViewCompat.MEASURED_STATE_MASK);
        Z().setShowCropGrid(false);
        OverlayView Z = Z();
        Float f2 = this.ratio;
        Z.setTargetAspectRatio(f2 == null ? 1.0f : f2.floatValue());
        Z().setCropFrameStrokeWidth(d.a.c(e.t.o.d.a, null, 1, null).d(2));
    }

    public final void e0(@e Float f2) {
        this.ratio = f2;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, android.app.Activity
    public void finish() {
        int i2 = this.r != null ? -1 : 0;
        Intent intent = new Intent();
        intent.putExtra(v, this.r);
        t1 t1Var = t1.a;
        setResult(i2, intent);
        super.finish();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.d(w(), this, 0, null, 6, null);
        w().setBackgroundResource(R.color.black);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        o d2 = o.d(getLayoutInflater());
        d2.h(this);
        return d2;
    }
}
