package com.jihuanshe.ui.page.common.card;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.Game;
import com.jihuanshe.net.api.FileInfo;
import com.jihuanshe.ui.page.common.card.ProductManagerHeaderImpl;
import com.jihuanshe.ui.widget.GameBar;
import e.l.q.b.b.a.e;
import e.l.r.z;
import e.t.j.h.g;
import e.t.k.a.f.h;
import h.t2.u;
import i.b.b1;
import i.b.i;
import java.io.File;
import k.e.a.d;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public abstract class ProductManagerHeaderImpl implements e {
    @k.e.a.e
    private final AppCompatActivity a;
    @k.e.a.e
    private final Fragment b;
    @k.e.a.e

    /* renamed from: c */
    private ActivityResultLauncher<Integer> f4008c;
    @d

    /* renamed from: d */
    private FragmentManager f4009d;
    @d

    /* renamed from: e */
    private LifecycleCoroutineScope f4010e;
    @k.e.a.e

    /* renamed from: f */
    private h f4011f;
    @k.e.a.e

    /* renamed from: g */
    private CardProductNew f4012g;

    public ProductManagerHeaderImpl(@k.e.a.e AppCompatActivity appCompatActivity, @k.e.a.e Fragment fragment) {
        this.a = appCompatActivity;
        this.b = fragment;
        if (appCompatActivity == null) {
            this.f4009d = fragment.getChildFragmentManager();
            this.f4010e = LifecycleOwnerKt.getLifecycleScope(fragment);
            this.f4008c = fragment.registerForActivityResult(new z(), new ActivityResultCallback() { // from class: e.l.q.b.b.a.a
                {
                    ProductManagerHeaderImpl.this = this;
                }

                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    ProductManagerHeaderImpl.g(ProductManagerHeaderImpl.this, (Uri) obj);
                }
            });
            return;
        }
        this.f4009d = appCompatActivity.getSupportFragmentManager();
        this.f4010e = LifecycleOwnerKt.getLifecycleScope(appCompatActivity);
        this.f4008c = appCompatActivity.registerForActivityResult(new z(), new ActivityResultCallback() { // from class: e.l.q.b.b.a.b
            {
                ProductManagerHeaderImpl.this = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ProductManagerHeaderImpl.h(ProductManagerHeaderImpl.this, (Uri) obj);
            }
        });
    }

    public static final void g(ProductManagerHeaderImpl productManagerHeaderImpl, Uri uri) {
        productManagerHeaderImpl.p(uri);
    }

    public static final void h(ProductManagerHeaderImpl productManagerHeaderImpl, Uri uri) {
        productManagerHeaderImpl.p(uri);
    }

    private final void p(Uri uri) {
        if (uri == null || this.f4012g == null) {
            return;
        }
        String uri2 = uri.toString();
        if (u.u2(uri2, "http", false, 2, null)) {
            this.f4012g.setUserUploadPhotoPath(uri2);
            s(this.f4012g);
            return;
        }
        h hVar = this.f4011f;
        if (hVar != null) {
            hVar.n();
        }
        FragmentActivity fragmentActivity = this.a;
        if (fragmentActivity == null) {
            Fragment fragment = this.b;
            fragmentActivity = fragment == null ? null : fragment.getActivity();
        }
        h hVar2 = new h(fragmentActivity, false, 2, null);
        this.f4011f = hVar2;
        if (hVar2 != null) {
            hVar2.W();
        }
        i.f(this.f4010e, b1.c(), null, new ProductManagerHeaderImpl$handleUri$1(uri, this, null), 2, null);
    }

    @Override // e.l.q.b.b.a.e
    public boolean a() {
        return true;
    }

    @Override // e.l.q.b.b.a.e
    @d
    public g b(@k.e.a.e CardProductNew cardProductNew) {
        return e.t.j.h.d.a.a(new ProductManagerHeaderImpl$clickProductDetail$1(cardProductNew, this));
    }

    @Override // e.l.q.b.b.a.e
    @d
    public g c(@k.e.a.e CardProductNew cardProductNew) {
        return e.t.j.h.d.a.a(new ProductManagerHeaderImpl$clickDeleteImage$1(cardProductNew, this));
    }

    @Override // e.l.q.b.b.a.e
    @d
    public String d() {
        Game value = GameBar.b.a().getValue();
        String name = value == null ? null : value.getName();
        return name != null ? name : "";
    }

    @Override // e.l.q.b.b.a.e
    @d
    public g e(@k.e.a.e CardProductNew cardProductNew) {
        return e.t.j.h.d.a.a(new ProductManagerHeaderImpl$clickProductCover$1(cardProductNew, this));
    }

    @Override // e.l.q.b.b.a.e
    @d
    public g f(@k.e.a.e CardProductNew cardProductNew) {
        return e.t.j.h.d.a.a(new ProductManagerHeaderImpl$clickProductDefaultCover$1(cardProductNew, this));
    }

    @k.e.a.e
    public final AppCompatActivity getActivity() {
        return this.a;
    }

    @d
    public final FragmentManager l() {
        return this.f4009d;
    }

    @k.e.a.e
    public final Fragment m() {
        return this.b;
    }

    @k.e.a.e
    public final ActivityResultLauncher<Integer> n() {
        return this.f4008c;
    }

    @d
    public final LifecycleCoroutineScope o() {
        return this.f4010e;
    }

    public abstract void s(@d CardProductNew cardProductNew);

    public final void t(@d FragmentManager fragmentManager) {
        this.f4009d = fragmentManager;
    }

    public final void u(@k.e.a.e ActivityResultLauncher<Integer> activityResultLauncher) {
        this.f4008c = activityResultLauncher;
    }

    public final void v(@d LifecycleCoroutineScope lifecycleCoroutineScope) {
        this.f4010e = lifecycleCoroutineScope;
    }

    @k.e.a.e
    public Flow<FileInfo> w(@d File file) {
        return null;
    }
}
