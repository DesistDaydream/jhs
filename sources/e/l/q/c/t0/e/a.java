package e.l.q.c.t0.e;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.preview.ImagePreviewActivity;
import com.jihuanshe.ui.widget.imagepreview.GPVideoPlayerActivity;
import com.jihuanshe.ui.widget.imagepreview.enitity.IThumbViewInfo;
import com.jihuanshe.ui.widget.imagepreview.wight.SmoothImageView;
import e.l.q.c.t0.d.d;

/* loaded from: classes2.dex */
public class a extends Fragment {

    /* renamed from: h  reason: collision with root package name */
    private static final String f14237h = "is_trans_photo";

    /* renamed from: i  reason: collision with root package name */
    private static final String f14238i = "isSingleFling";

    /* renamed from: j  reason: collision with root package name */
    private static final String f14239j = "key_item";

    /* renamed from: k  reason: collision with root package name */
    private static final String f14240k = "isDrag";

    /* renamed from: l  reason: collision with root package name */
    private static final String f14241l = "sensitivity";

    /* renamed from: m  reason: collision with root package name */
    public static e.l.q.c.t0.c.c f14242m;
    public static final /* synthetic */ boolean n = false;
    private IThumbViewInfo a;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public SmoothImageView f14243c;

    /* renamed from: d  reason: collision with root package name */
    public View f14244d;

    /* renamed from: e  reason: collision with root package name */
    public View f14245e;

    /* renamed from: f  reason: collision with root package name */
    public e.l.q.c.t0.c.a f14246f;

    /* renamed from: g  reason: collision with root package name */
    public View f14247g;

    /* renamed from: e.l.q.c.t0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0399a implements View.OnClickListener {
        public View$OnClickListenerC0399a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String videoUrl = a.this.a.getVideoUrl();
            if (videoUrl == null || videoUrl.isEmpty()) {
                return;
            }
            e.l.q.c.t0.c.c cVar = a.f14242m;
            if (cVar != null) {
                cVar.a(videoUrl);
            } else {
                GPVideoPlayerActivity.startActivity(a.this.getContext(), videoUrl);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements e.l.q.c.t0.c.a {
        public b() {
        }

        @Override // e.l.q.c.t0.c.a
        public void a() {
            a.this.f14245e.setVisibility(8);
            String videoUrl = a.this.a.getVideoUrl();
            if (videoUrl != null && !videoUrl.isEmpty()) {
                a.this.f14247g.setVisibility(0);
                ViewCompat.animate(a.this.f14247g).alpha(1.0f).setDuration(1000L).start();
                return;
            }
            a.this.f14247g.setVisibility(8);
        }

        @Override // e.l.q.c.t0.c.a
        public void onLoadFailed(Drawable drawable) {
            a.this.f14245e.setVisibility(8);
            a.this.f14247g.setVisibility(8);
            if (drawable != null) {
                a.this.f14243c.setImageDrawable(drawable);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.i {
        public c() {
        }

        @Override // e.l.q.c.t0.d.d.i
        public void onViewTap(View view, float f2, float f3) {
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.i {
        public d() {
        }

        @Override // e.l.q.c.t0.d.d.i
        public void onViewTap(View view, float f2, float f3) {
            if (a.this.f14243c.J()) {
                ((ImagePreviewActivity) a.this.getActivity()).i0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.f {
        public e() {
        }

        @Override // e.l.q.c.t0.d.d.f
        public void a() {
        }

        @Override // e.l.q.c.t0.d.d.f
        public void b(View view, float f2, float f3) {
            if (a.this.f14243c.J()) {
                ((ImagePreviewActivity) a.this.getActivity()).i0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements SmoothImageView.g {
        public f() {
        }

        @Override // com.jihuanshe.ui.widget.imagepreview.wight.SmoothImageView.g
        public void a(int i2) {
            if (i2 == 255) {
                String videoUrl = a.this.a.getVideoUrl();
                if (videoUrl != null && !videoUrl.isEmpty()) {
                    a.this.f14247g.setVisibility(0);
                } else {
                    a.this.f14247g.setVisibility(8);
                }
            } else {
                a.this.f14247g.setVisibility(8);
            }
            a.this.f14244d.setBackgroundColor(a.s(i2 / 255.0f, ViewCompat.MEASURED_STATE_MASK));
        }
    }

    /* loaded from: classes2.dex */
    public class g implements SmoothImageView.h {
        public g() {
        }

        @Override // com.jihuanshe.ui.widget.imagepreview.wight.SmoothImageView.h
        public void a() {
            ((ImagePreviewActivity) a.this.getActivity()).i0();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements SmoothImageView.j {
        public h() {
        }

        @Override // com.jihuanshe.ui.widget.imagepreview.wight.SmoothImageView.j
        public void a(SmoothImageView.Status status) {
            a.this.f14244d.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    public static int s(float f2, int i2) {
        return (Math.min(255, Math.max(0, (int) (f2 * 255.0f))) << 24) + (i2 & 16777215);
    }

    public static a t(Class<? extends a> cls, IThumbViewInfo iThumbViewInfo, boolean z, boolean z2, boolean z3, float f2) {
        a aVar;
        try {
            aVar = cls.newInstance();
        } catch (Exception unused) {
            aVar = new a();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(f14239j, iThumbViewInfo);
        bundle.putBoolean(f14237h, z);
        bundle.putBoolean(f14238i, z2);
        bundle.putBoolean(f14240k, z3);
        bundle.putFloat(f14241l, f2);
        aVar.setArguments(bundle);
        return aVar;
    }

    private void u() {
        boolean z;
        Bundle arguments = getArguments();
        if (arguments != null) {
            z = arguments.getBoolean(f14238i);
            this.a = (IThumbViewInfo) arguments.getParcelable(f14239j);
            this.f14243c.O(arguments.getBoolean(f14240k), arguments.getFloat(f14241l));
            this.f14243c.setThumbRect(this.a.getBounds());
            this.f14244d.setTag(this.a.getUrl());
            this.b = arguments.getBoolean(f14237h, false);
            if (this.a.getUrl().toLowerCase().contains(".gif")) {
                this.f14243c.setZoomable(false);
                e.l.q.c.t0.b.a().b().d(this, this.a.getUrl(), this.f14243c, this.f14246f);
            } else {
                e.l.q.c.t0.b.a().b().c(this, this.a.getUrl(), this.f14243c, this.f14246f);
            }
        } else {
            z = true;
        }
        if (!this.b) {
            this.f14244d.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } else {
            this.f14243c.setMinimumScale(0.7f);
        }
        if (z) {
            this.f14243c.setOnViewTapListener(new c());
            this.f14243c.setOnViewTapListener(new d());
        } else {
            this.f14243c.setOnPhotoTapListener(new e());
        }
        this.f14243c.setAlphaChangeListener(new f());
        this.f14243c.setTransformOutListener(new g());
    }

    private void v(View view) {
        this.f14245e = view.findViewById(R.id.loading);
        this.f14243c = (SmoothImageView) view.findViewById(R.id.photoView);
        this.f14247g = view.findViewById(R.id.btnVideo);
        View findViewById = view.findViewById(R.id.rootView);
        this.f14244d = findViewById;
        findViewById.setDrawingCacheEnabled(false);
        this.f14243c.setDrawingCacheEnabled(false);
        this.f14247g.setOnClickListener(new View$OnClickListenerC0399a());
        this.f14246f = new b();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_image_photo_layout, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        e.l.q.c.t0.b.a().b().a(getActivity());
        if (getActivity() == null || !getActivity().isFinishing()) {
            return;
        }
        f14242m = null;
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onDestroyView() {
        super.onDestroyView();
        w();
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onStop() {
        e.l.q.c.t0.b.a().b().b(this);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        v(view);
        u();
    }

    public void q(int i2) {
        ViewCompat.animate(this.f14247g).alpha(0.0f).setDuration(SmoothImageView.getDuration()).start();
        this.f14244d.setBackgroundColor(i2);
    }

    public IThumbViewInfo r() {
        return this.a;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    public void w() {
        this.b = false;
    }

    public void x() {
        this.f14243c.Q(new h());
    }

    public void y(SmoothImageView.j jVar) {
        this.f14243c.R(jVar);
    }
}
