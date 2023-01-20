package e.l.q.b.h;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.ViewCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.jihuanshe.R;
import e.l.q.b.h.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class k {
    public Activity a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f14151c;

    /* renamed from: d  reason: collision with root package name */
    public List<ImageView> f14152d;

    /* renamed from: e  reason: collision with root package name */
    public Map<Integer, Bitmap> f14153e;

    /* renamed from: f  reason: collision with root package name */
    public List<Map<String, Integer>> f14154f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f14155g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f14156h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f14157i;

    /* renamed from: j  reason: collision with root package name */
    public Integer f14158j;

    /* renamed from: k  reason: collision with root package name */
    public Boolean f14159k;

    /* renamed from: l  reason: collision with root package name */
    public int f14160l;

    /* renamed from: m  reason: collision with root package name */
    public AlertDialog f14161m;
    public RelativeLayout n;
    public ViewPager2 o;
    public l p;
    public RelativeLayout q;
    public RelativeLayout.LayoutParams r;
    public View s;
    public TextView t;

    /* loaded from: classes2.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        public a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            super.onPageSelected(i2);
            k.this.f14151c = Integer.valueOf(i2);
            k kVar = k.this;
            List<String> list = kVar.f14156h;
            if (list != null) {
                kVar.t.setText(list.get(kVar.f14151c.intValue()));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            k.this.f14161m.dismiss();
        }
    }

    public k(Activity activity, List<String> list) {
        this(activity, list, (List<ImageView>) null);
    }

    private void a() {
        int width;
        int height;
        float f2;
        if (this.f14154f != null) {
            this.p.c();
            Map<String, Integer> map = this.f14154f.get(this.f14151c.intValue());
            int intValue = map.get("left").intValue();
            int intValue2 = map.get("top").intValue();
            int intValue3 = map.get("width").intValue();
            int intValue4 = map.get("height").intValue();
            Bitmap bitmap = this.f14153e.get(this.f14151c);
            float f3 = intValue3;
            float f4 = intValue4;
            if (f3 / f4 >= bitmap.getWidth() / bitmap.getHeight()) {
                f2 = (((height * intValue3) / width) - intValue4) / f4;
            } else {
                f2 = (((width * intValue4) / height) - intValue3) / f3;
            }
            float f5 = f2 + 1.0f;
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f14157i.intValue(), intValue3);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: e.l.q.b.h.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    k.this.d(valueAnimator);
                }
            });
            ofInt.setDuration(this.f14160l).start();
            ValueAnimator ofInt2 = ValueAnimator.ofInt(this.f14158j.intValue(), intValue4);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: e.l.q.b.h.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    k.this.f(valueAnimator);
                }
            });
            ofInt2.setDuration(this.f14160l).start();
            this.q.animate().translationX(intValue).translationY(intValue2).setDuration(this.f14160l).start();
            this.o.animate().scaleX(f5).scaleY(f5).setDuration(this.f14160l).start();
            this.t.animate().alpha(0.0f).setDuration(this.f14160l).start();
            this.s.animate().alpha(0.0f).setDuration(this.f14160l).start();
        } else {
            this.n.animate().alpha(0.0f).setDuration(this.f14160l).start();
        }
        new Timer().schedule(new b(), this.f14160l);
    }

    private void b() {
        e.l.q.c.p0.d dVar = e.l.q.c.p0.d.a;
        this.f14157i = Integer.valueOf(dVar.f(this.a.getApplicationContext()));
        this.f14158j = Integer.valueOf(dVar.e(this.a.getApplicationContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a, R.style.full_screen);
        View inflate = View.inflate(this.a, R.layout.activity_custom_preview, null);
        this.b = inflate;
        builder.setView(inflate);
        AlertDialog create = builder.create();
        this.f14161m = create;
        create.getWindow().setLayout(-1, -1);
        this.f14161m.getWindow().setBackgroundDrawableResource(R.color.transparent);
        this.f14161m.getWindow().addFlags(Integer.MIN_VALUE);
        this.f14161m.getWindow().setNavigationBarColor(ViewCompat.MEASURED_STATE_MASK);
        this.f14161m.setCancelable(false);
        this.f14161m.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: e.l.q.b.h.f
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return k.this.h(dialogInterface, i2, keyEvent);
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.preview_layout);
        this.n = relativeLayout;
        relativeLayout.setAlpha(0.0f);
        this.q = (RelativeLayout) this.b.findViewById(R.id.preview_view_page_layout);
        this.o = (ViewPager2) this.b.findViewById(R.id.preview_view_page);
        if (this.f14155g.size() > 1) {
            this.o.setUserInputEnabled(true);
        } else {
            this.o.setUserInputEnabled(false);
        }
        this.o.registerOnPageChangeCallback(new a());
        l d2 = new l(this.f14155g).f(new View.OnClickListener() { // from class: e.l.q.b.h.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.this.j(view);
            }
        }).e(h.a).d(new l.b() { // from class: e.l.q.b.h.b
            @Override // e.l.q.b.h.l.b
            public final void a(int i2, Bitmap bitmap) {
                k.this.m(i2, bitmap);
            }
        });
        this.p = d2;
        this.o.setAdapter(d2);
        this.t = (TextView) this.b.findViewById(R.id.preview_description);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(ValueAnimator valueAnimator) {
        this.r.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.q.setLayoutParams(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(ValueAnimator valueAnimator) {
        this.r.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.q.setLayoutParams(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ boolean h(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            a();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(View view) {
        a();
    }

    public static /* synthetic */ boolean k(View view) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(int i2, Bitmap bitmap) {
        this.f14153e.put(Integer.valueOf(i2), bitmap);
        if (this.f14159k.booleanValue()) {
            return;
        }
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(ValueAnimator valueAnimator) {
        this.r.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.q.setLayoutParams(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void q(ValueAnimator valueAnimator) {
        this.r.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.q.setLayoutParams(this.r);
    }

    private void u() {
        float f2;
        this.f14159k = Boolean.TRUE;
        List<String> list = this.f14155g;
        if (list == null && list == null) {
            return;
        }
        List<String> list2 = this.f14156h;
        if (list2 == null) {
            this.t.setVisibility(8);
        } else {
            this.t.setText(list2.get(this.f14151c.intValue()));
        }
        if (this.f14152d != null) {
            this.f14154f = new ArrayList();
            int[] iArr = new int[2];
            for (ImageView imageView : this.f14152d) {
                imageView.getLocationInWindow(iArr);
                HashMap hashMap = new HashMap();
                hashMap.put("left", Integer.valueOf(iArr[0]));
                hashMap.put("top", Integer.valueOf(iArr[1]));
                hashMap.put("width", Integer.valueOf(imageView.getWidth()));
                hashMap.put("height", Integer.valueOf(imageView.getHeight()));
                this.f14154f.add(hashMap);
            }
            Map<String, Integer> map = this.f14154f.get(this.f14151c.intValue());
            int intValue = map.get("left").intValue();
            int intValue2 = map.get("top").intValue();
            int intValue3 = map.get("width").intValue();
            int intValue4 = map.get("height").intValue();
            Bitmap bitmap = this.f14153e.get(this.f14151c);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.n.animate().alpha(1.0f).setDuration(1L).start();
            this.q.setTranslationX(intValue);
            this.q.setTranslationY(intValue2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            this.r = layoutParams;
            layoutParams.width = intValue3;
            layoutParams.height = intValue4;
            this.q.setLayoutParams(layoutParams);
            float f3 = intValue3;
            float f4 = intValue4;
            if (f3 / f4 >= width / height) {
                f2 = ((((height * intValue3) / width) - intValue4) / f4) + 1.0f;
            } else {
                f2 = ((((width * intValue4) / height) - intValue3) / f3) + 1.0f;
            }
            this.o.setScaleY(f2);
            this.o.setScaleX(f2);
            ValueAnimator ofInt = ValueAnimator.ofInt(intValue3, this.f14157i.intValue());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: e.l.q.b.h.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    k.this.o(valueAnimator);
                }
            });
            ofInt.setDuration(this.f14160l).start();
            ValueAnimator ofInt2 = ValueAnimator.ofInt(intValue4, this.f14158j.intValue());
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: e.l.q.b.h.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    k.this.q(valueAnimator);
                }
            });
            ofInt2.setDuration(this.f14160l).start();
            this.q.animate().translationX(0.0f).translationY(0.0f).setDuration(this.f14160l).start();
            this.o.animate().scaleX(1.0f).scaleY(1.0f).setDuration(this.f14160l).start();
            this.t.setAlpha(0.0f);
            this.t.animate().alpha(1.0f).setDuration(this.f14160l).start();
            View findViewById = this.b.findViewById(R.id.preview_bg);
            this.s = findViewById;
            findViewById.setAlpha(0.0f);
            this.s.animate().alpha(1.0f).setDuration(this.f14160l).start();
            return;
        }
        this.n.animate().alpha(1.0f).setDuration(this.f14160l).start();
    }

    public k r(Integer num) {
        this.f14151c = num;
        this.o.setCurrentItem(num.intValue(), false);
        return this;
    }

    public k s(List<String> list) {
        this.f14156h = list;
        return this;
    }

    public void t() {
        this.f14161m.show();
    }

    public k(Activity activity, String str, ImageView imageView) {
        this.f14151c = 0;
        this.f14153e = new HashMap();
        this.f14159k = Boolean.FALSE;
        this.f14160l = 300;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(imageView);
        this.a = activity;
        this.f14155g = arrayList;
        this.f14152d = arrayList2;
        b();
    }

    public k(Activity activity, List<String> list, List<ImageView> list2) {
        this.f14151c = 0;
        this.f14153e = new HashMap();
        this.f14159k = Boolean.FALSE;
        this.f14160l = 300;
        this.a = activity;
        this.f14155g = list;
        this.f14152d = list2;
        b();
    }
}
