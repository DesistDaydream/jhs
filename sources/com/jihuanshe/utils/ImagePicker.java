package com.jihuanshe.utils;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.jihuanshe.R;
import com.jihuanshe.utils.ImagePicker;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.PictureDialog;
import e.l.r.a0;
import e.l.r.k0;
import e.l.r.x;
import e.l.r.y;
import e.q.a.c;
import e.q.a.g.p;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ImagePicker {
    @d

    /* renamed from: i */
    public static final a f4334i = new a(null);

    /* renamed from: j */
    public static final int f4335j = 0;

    /* renamed from: k */
    public static final int f4336k = 1;
    @e
    private FragmentActivity a;
    @e
    private Fragment b;
    @e

    /* renamed from: c */
    private l<? super Uri, t1> f4337c;

    /* renamed from: d */
    private float f4338d;
    @e

    /* renamed from: e */
    private ActivityResultLauncher<String> f4339e;
    @e

    /* renamed from: f */
    private ActivityResultLauncher<String> f4340f;
    @e

    /* renamed from: g */
    private ActivityResultLauncher<ClipInfo> f4341g;
    @d

    /* renamed from: h */
    private final w f4342h;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public ImagePicker(@d AppCompatActivity appCompatActivity, final int i2, float f2, @d final l<? super Uri, t1> lVar) {
        ActivityResultLauncher<String> registerForActivityResult;
        this.f4338d = 1.0f;
        this.f4342h = z.c(new ImagePicker$dialog$2(this));
        this.a = appCompatActivity;
        this.f4338d = f2;
        this.f4339e = appCompatActivity.registerForActivityResult(new k0(), new ActivityResultCallback() { // from class: e.l.r.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ImagePicker.a(i2, lVar, this, (Uri) obj);
            }
        });
        if (i2 == 1) {
            registerForActivityResult = appCompatActivity.registerForActivityResult(new x(f2), new ActivityResultCallback() { // from class: e.l.r.a
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    ImagePicker.b(lVar, this, (Uri) obj);
                }
            });
        } else {
            registerForActivityResult = appCompatActivity.registerForActivityResult(new y(), new ActivityResultCallback() { // from class: e.l.r.c
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    ImagePicker.c(lVar, (Uri) obj);
                }
            });
        }
        this.f4340f = registerForActivityResult;
        this.f4341g = appCompatActivity.registerForActivityResult(new a0(f2), new ActivityResultCallback() { // from class: e.l.r.f
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ImagePicker.d(lVar, (Uri) obj);
            }
        });
    }

    public static final void G(boolean z, FragmentActivity fragmentActivity, p pVar, List list) {
        if (z) {
            return;
        }
        ImagePickerKt.e(fragmentActivity, R.string.common_camera, R.string.permission_camera_desc, R.drawable.ic_svg_me);
    }

    public static final void H(ImagePicker imagePicker, boolean z, List list, List list2) {
        ActivityResultLauncher<String> activityResultLauncher;
        if (!z || (activityResultLauncher = imagePicker.f4340f) == null) {
            return;
        }
        activityResultLauncher.launch("");
    }

    public static final void J(boolean z, FragmentActivity fragmentActivity, p pVar, List list) {
        if (z) {
            return;
        }
        ImagePickerKt.e(fragmentActivity, R.string.common_album, R.string.permission_album_desc, R.drawable.ic_svg_me);
    }

    public static final void K(ImagePicker imagePicker, boolean z, List list, List list2) {
        ActivityResultLauncher<String> activityResultLauncher;
        if (!z || (activityResultLauncher = imagePicker.f4339e) == null) {
            return;
        }
        activityResultLauncher.launch("");
    }

    public static final void a(int i2, l lVar, ImagePicker imagePicker, Uri uri) {
        if (i2 != 1) {
            lVar.invoke(uri);
        } else if (uri == null) {
            lVar.invoke(uri);
        } else {
            ActivityResultLauncher<ClipInfo> activityResultLauncher = imagePicker.f4341g;
            if (activityResultLauncher == null) {
                return;
            }
            activityResultLauncher.launch(new ClipInfo(uri, true));
        }
    }

    public static final void b(l lVar, ImagePicker imagePicker, Uri uri) {
        if (uri == null) {
            lVar.invoke(uri);
            return;
        }
        ActivityResultLauncher<ClipInfo> activityResultLauncher = imagePicker.f4341g;
        if (activityResultLauncher == null) {
            return;
        }
        activityResultLauncher.launch(new ClipInfo(uri, false, 2, null));
    }

    public static final void c(l lVar, Uri uri) {
        lVar.invoke(uri);
    }

    public static final void d(l lVar, Uri uri) {
        lVar.invoke(uri);
    }

    public static final void e(int i2, l lVar, ImagePicker imagePicker, Uri uri) {
        if (i2 != 1) {
            lVar.invoke(uri);
        } else if (uri == null) {
            lVar.invoke(uri);
        } else {
            ActivityResultLauncher<ClipInfo> activityResultLauncher = imagePicker.f4341g;
            if (activityResultLauncher == null) {
                return;
            }
            activityResultLauncher.launch(new ClipInfo(uri, true));
        }
    }

    public static final void f(l lVar, ImagePicker imagePicker, Uri uri) {
        if (uri == null) {
            lVar.invoke(uri);
            return;
        }
        ActivityResultLauncher<ClipInfo> activityResultLauncher = imagePicker.f4341g;
        if (activityResultLauncher == null) {
            return;
        }
        activityResultLauncher.launch(new ClipInfo(uri, false, 2, null));
    }

    public static final void g(l lVar, Uri uri) {
        lVar.invoke(uri);
    }

    public static final void h(l lVar, Uri uri) {
        lVar.invoke(uri);
    }

    public final FragmentActivity n() {
        FragmentActivity fragmentActivity = this.a;
        if (fragmentActivity == null) {
            Fragment fragment = this.b;
            if (fragment == null) {
                return null;
            }
            return fragment.getActivity();
        }
        return fragmentActivity;
    }

    public final void A(@e FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
    }

    public final void B(@e Fragment fragment) {
        this.b = fragment;
    }

    public final void C(@e l<? super Uri, t1> lVar) {
        this.f4337c = lVar;
    }

    public final void D(float f2) {
        this.f4338d = f2;
    }

    public final void E() {
        PictureDialog j2 = j();
        if (j2 == null) {
            return;
        }
        j2.show();
    }

    public final void F() {
        final FragmentActivity n = n();
        if (n == null) {
            return;
        }
        final boolean shouldShowRequestPermissionRationale = ActivityCompat.shouldShowRequestPermissionRationale(n, PermissionConstants.CAMERA);
        c.b(n).b(PermissionConstants.CAMERA, "android.permission.READ_EXTERNAL_STORAGE", PermissionConstants.STORE).n(new e.q.a.d.c() { // from class: e.l.r.j
            @Override // e.q.a.d.c
            public final void a(e.q.a.g.p pVar, List list) {
                ImagePicker.G(shouldShowRequestPermissionRationale, n, pVar, list);
            }
        }).p(new e.q.a.d.d() { // from class: e.l.r.k
            {
                ImagePicker.this = this;
            }

            @Override // e.q.a.d.d
            public final void onResult(boolean z, List list, List list2) {
                ImagePicker.H(ImagePicker.this, z, list, list2);
            }
        });
    }

    public final void I() {
        final FragmentActivity n = n();
        if (n == null) {
            return;
        }
        final boolean shouldShowRequestPermissionRationale = ActivityCompat.shouldShowRequestPermissionRationale(n, "android.permission.READ_EXTERNAL_STORAGE");
        c.b(n).b("android.permission.READ_EXTERNAL_STORAGE", PermissionConstants.STORE).n(new e.q.a.d.c() { // from class: e.l.r.e
            @Override // e.q.a.d.c
            public final void a(e.q.a.g.p pVar, List list) {
                ImagePicker.J(shouldShowRequestPermissionRationale, n, pVar, list);
            }
        }).p(new e.q.a.d.d() { // from class: e.l.r.d
            {
                ImagePicker.this = this;
            }

            @Override // e.q.a.d.d
            public final void onResult(boolean z, List list, List list2) {
                ImagePicker.K(ImagePicker.this, z, list, list2);
            }
        });
    }

    @e
    public final FragmentActivity getContext() {
        return this.a;
    }

    @e
    public final PictureDialog j() {
        return (PictureDialog) this.f4342h.getValue();
    }

    @e
    public final Fragment k() {
        return this.b;
    }

    @e
    public final l<Uri, t1> l() {
        return this.f4337c;
    }

    public final float m() {
        return this.f4338d;
    }

    public /* synthetic */ ImagePicker(AppCompatActivity appCompatActivity, int i2, float f2, l lVar, int i3, u uVar) {
        this(appCompatActivity, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? 1.0f : f2, lVar);
    }

    public ImagePicker(@d Fragment fragment, final int i2, float f2, @d final l<? super Uri, t1> lVar) {
        ActivityResultLauncher<String> registerForActivityResult;
        this.f4338d = 1.0f;
        this.f4342h = z.c(new ImagePicker$dialog$2(this));
        this.b = fragment;
        this.f4338d = f2;
        this.f4339e = fragment.registerForActivityResult(new k0(), new ActivityResultCallback() { // from class: e.l.r.i
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ImagePicker.e(i2, lVar, this, (Uri) obj);
            }
        });
        if (i2 == 1) {
            registerForActivityResult = fragment.registerForActivityResult(new x(f2), new ActivityResultCallback() { // from class: e.l.r.l
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    ImagePicker.f(lVar, this, (Uri) obj);
                }
            });
        } else {
            registerForActivityResult = fragment.registerForActivityResult(new y(), new ActivityResultCallback() { // from class: e.l.r.h
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    ImagePicker.g(lVar, (Uri) obj);
                }
            });
        }
        this.f4340f = registerForActivityResult;
        this.f4341g = fragment.registerForActivityResult(new a0(f2), new ActivityResultCallback() { // from class: e.l.r.g
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ImagePicker.h(lVar, (Uri) obj);
            }
        });
    }

    public /* synthetic */ ImagePicker(Fragment fragment, int i2, float f2, l lVar, int i3, u uVar) {
        this(fragment, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? 1.0f : f2, lVar);
    }
}
