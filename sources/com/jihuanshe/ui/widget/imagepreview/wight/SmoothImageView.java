package com.jihuanshe.ui.widget.imagepreview.wight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.imagepreview.photoview2.PhotoView;

/* loaded from: classes2.dex */
public class SmoothImageView extends PhotoView {
    private static boolean A = false;
    private static final int B = 5;
    private static int y = 400;
    private static boolean z = false;

    /* renamed from: c  reason: collision with root package name */
    private Status f4306c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f4307d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f4308e;

    /* renamed from: f  reason: collision with root package name */
    private i f4309f;

    /* renamed from: g  reason: collision with root package name */
    private i f4310g;

    /* renamed from: h  reason: collision with root package name */
    private i f4311h;

    /* renamed from: i  reason: collision with root package name */
    private Rect f4312i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4313j;

    /* renamed from: k  reason: collision with root package name */
    private int f4314k;

    /* renamed from: l  reason: collision with root package name */
    private int f4315l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f4316m;
    public ValueAnimator n;
    private float o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private int t;
    private g u;
    private h v;
    private i w;
    private j x;

    /* loaded from: classes2.dex */
    public enum Status {
        STATE_NORMAL,
        STATE_IN,
        STATE_OUT,
        STATE_MOVE
    }

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public int a = 0;

        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            int i2 = this.a;
            if (i2 != 0) {
                SmoothImageView.this.offsetTopAndBottom(intValue - i2);
            }
            this.a = intValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public int a = 0;

        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            int i2 = this.a;
            if (i2 != 0) {
                SmoothImageView.this.offsetLeftAndRight(intValue - i2);
            }
            this.a = intValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (SmoothImageView.this.u != null) {
                SmoothImageView.this.u.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SmoothImageView.this.setScaleX(floatValue);
            SmoothImageView.this.setScaleY(floatValue);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmoothImageView.this.f4311h.f4319e = ((Integer) valueAnimator.getAnimatedValue("animAlpha")).intValue();
            SmoothImageView.this.f4311h.f4320f = ((Float) valueAnimator.getAnimatedValue("animScale")).floatValue();
            SmoothImageView.this.f4311h.a = ((Float) valueAnimator.getAnimatedValue("animLeft")).floatValue();
            SmoothImageView.this.f4311h.b = ((Float) valueAnimator.getAnimatedValue("animTop")).floatValue();
            SmoothImageView.this.f4311h.f4317c = ((Float) valueAnimator.getAnimatedValue("animWidth")).floatValue();
            SmoothImageView.this.f4311h.f4318d = ((Float) valueAnimator.getAnimatedValue("animHeight")).floatValue();
            SmoothImageView.this.invalidate();
        }
    }

    /* loaded from: classes2.dex */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (SmoothImageView.this.x != null) {
                SmoothImageView.this.x.a(SmoothImageView.this.f4306c);
            }
            if (SmoothImageView.this.f4306c == Status.STATE_IN) {
                SmoothImageView.this.f4306c = Status.STATE_NORMAL;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (SmoothImageView.this.getTag(R.id.item_image_key) != null) {
                SmoothImageView.this.setTag(R.id.item_image_key, null);
                SmoothImageView.this.setOnLongClickListener(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface g {
        void a(int i2);
    }

    /* loaded from: classes2.dex */
    public interface h {
        void a();
    }

    /* loaded from: classes2.dex */
    public class i implements Cloneable {
        public float a;
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public float f4317c;

        /* renamed from: d  reason: collision with root package name */
        public float f4318d;

        /* renamed from: e  reason: collision with root package name */
        public int f4319e;

        /* renamed from: f  reason: collision with root package name */
        public float f4320f;

        private i() {
        }

        /* renamed from: a */
        public i clone() {
            try {
                return (i) super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public /* synthetic */ i(SmoothImageView smoothImageView, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface j {
        void a(Status status);
    }

    public SmoothImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4306c = Status.STATE_NORMAL;
        this.o = 0.8f;
        this.r = false;
        this.s = false;
        this.t = 0;
        K();
    }

    private boolean F() {
        if (M() <= this.o) {
            N();
            return true;
        }
        I();
        setTag(R.id.item_image_key, Boolean.TRUE);
        h hVar = this.v;
        if (hVar != null) {
            hVar.a();
            return true;
        }
        return true;
    }

    private void G(MotionEvent motionEvent) {
        this.p = (int) motionEvent.getX();
        this.q = (int) motionEvent.getY();
        if (this.w == null) {
            L();
        }
        this.s = false;
        i iVar = this.w;
        if (iVar != null) {
            float f2 = iVar.b;
            int i2 = (int) f2;
            int i3 = (int) (iVar.f4318d + f2);
            int i4 = this.q;
            if (i4 >= i2 && i3 >= i4) {
                this.s = true;
            }
        }
        this.r = false;
    }

    private boolean H(MotionEvent motionEvent) {
        if (!this.s && motionEvent.getPointerCount() == 1) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int x = ((int) motionEvent.getX()) - this.p;
        int y2 = ((int) motionEvent.getY()) - this.q;
        if (!this.r && (Math.abs(x) > Math.abs(y2) || Math.abs(y2) < 5)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.f4316m) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() == 1) {
            this.f4306c = Status.STATE_MOVE;
            offsetLeftAndRight(x);
            offsetTopAndBottom(y2);
            float M = M();
            float f2 = 1.0f - (0.1f * M);
            setScaleY(f2);
            setScaleX(f2);
            this.r = true;
            this.t = (int) ((1.0f - (M * 0.5f)) * 255.0f);
            invalidate();
            if (this.t < 0) {
                this.t = 0;
            }
            g gVar = this.u;
            if (gVar != null) {
                gVar.a(this.t);
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void I() {
        i iVar = this.w;
        if (iVar != null) {
            i clone = iVar.clone();
            clone.b = this.w.b + getTop();
            clone.a = this.w.a + getLeft();
            clone.f4319e = this.t;
            clone.f4320f = this.w.f4320f - ((1.0f - getScaleX()) * this.w.f4320f);
            this.f4311h = clone.clone();
            this.f4310g = clone.clone();
        }
    }

    private void K() {
        Paint paint = new Paint();
        this.f4307d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f4307d.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4308e = new Matrix();
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private void L() {
        if (getDrawable() == null) {
            return;
        }
        if ((this.f4309f != null && this.f4310g != null && this.f4311h != null) || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (getDrawable() instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
            this.f4314k = bitmap.getWidth();
            this.f4315l = bitmap.getHeight();
        } else if (getDrawable() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getDrawable();
            this.f4314k = colorDrawable.getIntrinsicWidth();
            this.f4315l = colorDrawable.getIntrinsicHeight();
        } else if (getDrawable().getIntrinsicWidth() > 0 && getDrawable().getIntrinsicHeight() > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight(), Bitmap.Config.RGB_565);
            this.f4314k = createBitmap.getWidth();
            this.f4315l = createBitmap.getHeight();
        } else {
            this.f4314k = 0;
            this.f4315l = 0;
            return;
        }
        i iVar = new i(this, null);
        this.f4309f = iVar;
        iVar.f4319e = 0;
        if (this.f4312i == null) {
            this.f4312i = new Rect();
        }
        i iVar2 = this.f4309f;
        Rect rect = this.f4312i;
        iVar2.a = rect.left;
        if (z) {
            iVar2.b = rect.top;
        } else {
            iVar2.b = rect.top - e.l.q.c.t0.e.b.a(getContext().getApplicationContext());
        }
        this.f4309f.f4317c = this.f4312i.width();
        this.f4309f.f4318d = this.f4312i.height();
        float width = this.f4312i.width() / this.f4314k;
        float height = this.f4312i.height() / this.f4315l;
        i iVar3 = this.f4309f;
        if (width <= height) {
            width = height;
        }
        iVar3.f4320f = width;
        float width2 = getWidth() / this.f4314k;
        float height2 = getHeight() / this.f4315l;
        i iVar4 = new i(this, null);
        this.f4310g = iVar4;
        if (width2 >= height2) {
            width2 = height2;
        }
        iVar4.f4320f = width2;
        iVar4.f4319e = 255;
        int i2 = (int) (this.f4314k * width2);
        int i3 = (int) (width2 * this.f4315l);
        iVar4.a = (getWidth() - i2) / 2;
        this.f4310g.b = (getHeight() - i3) / 2;
        i iVar5 = this.f4310g;
        iVar5.f4317c = i2;
        iVar5.f4318d = i3;
        Status status = this.f4306c;
        if (status == Status.STATE_IN) {
            this.f4311h = this.f4309f.clone();
        } else if (status == Status.STATE_OUT) {
            this.f4311h = iVar5.clone();
        }
        this.w = this.f4310g;
    }

    private float M() {
        if (this.w == null) {
            L();
        }
        return Math.abs(getTop() / this.w.f4318d);
    }

    private void N() {
        ValueAnimator ofInt = ValueAnimator.ofInt(getTop(), 0);
        ofInt.addUpdateListener(new a());
        ValueAnimator ofInt2 = ValueAnimator.ofInt(getLeft(), 0);
        ofInt2.addUpdateListener(new b());
        ValueAnimator ofInt3 = ValueAnimator.ofInt(this.t, 255);
        ofInt3.addUpdateListener(new c());
        ValueAnimator ofFloat = ValueAnimator.ofFloat(getScaleX(), 1.0f);
        ofFloat.addUpdateListener(new d());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(y);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofInt, ofInt2, ofFloat, ofInt3);
        animatorSet.start();
    }

    private void P() {
        this.f4313j = false;
        if (this.f4311h == null) {
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.n = valueAnimator;
        valueAnimator.setDuration(y);
        this.n.setInterpolator(new AccelerateDecelerateInterpolator());
        Status status = this.f4306c;
        if (status == Status.STATE_IN) {
            this.n.setValues(PropertyValuesHolder.ofFloat("animScale", this.f4309f.f4320f, this.f4310g.f4320f), PropertyValuesHolder.ofInt("animAlpha", this.f4309f.f4319e, this.f4310g.f4319e), PropertyValuesHolder.ofFloat("animLeft", this.f4309f.a, this.f4310g.a), PropertyValuesHolder.ofFloat("animTop", this.f4309f.b, this.f4310g.b), PropertyValuesHolder.ofFloat("animWidth", this.f4309f.f4317c, this.f4310g.f4317c), PropertyValuesHolder.ofFloat("animHeight", this.f4309f.f4318d, this.f4310g.f4318d));
        } else if (status == Status.STATE_OUT) {
            this.n.setValues(PropertyValuesHolder.ofFloat("animScale", this.f4310g.f4320f, this.f4309f.f4320f), PropertyValuesHolder.ofInt("animAlpha", this.f4310g.f4319e, this.f4309f.f4319e), PropertyValuesHolder.ofFloat("animLeft", this.f4310g.a, this.f4309f.a), PropertyValuesHolder.ofFloat("animTop", this.f4310g.b, this.f4309f.b), PropertyValuesHolder.ofFloat("animWidth", this.f4310g.f4317c, this.f4309f.f4317c), PropertyValuesHolder.ofFloat("animHeight", this.f4310g.f4318d, this.f4309f.f4318d));
        }
        this.n.addUpdateListener(new e());
        this.n.addListener(new f());
        this.n.start();
    }

    public static int getDuration() {
        return y;
    }

    public static void setDuration(int i2) {
        y = i2;
    }

    public static void setFullscreen(boolean z2) {
        z = z2;
    }

    public static void setIsScale(boolean z2) {
        A = z2;
    }

    public boolean J() {
        if (getScale() != 1.0f) {
            setScale(1.0f, true);
            return false;
        }
        return true;
    }

    public void O(boolean z2, float f2) {
        this.f4316m = z2;
        this.o = f2;
    }

    public void Q(j jVar) {
        setOnTransformListener(jVar);
        this.f4313j = true;
        this.f4306c = Status.STATE_IN;
        invalidate();
    }

    public void R(j jVar) {
        if (getTop() != 0) {
            offsetTopAndBottom(-getTop());
        }
        if (getLeft() != 0) {
            offsetLeftAndRight(-getLeft());
        }
        if (getScaleX() != 1.0f) {
            setScaleX(1.0f);
            setScaleY(1.0f);
        }
        setOnTransformListener(jVar);
        this.f4313j = true;
        this.f4306c = Status.STATE_OUT;
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:
        if (r0 != 3) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r0 != 3) goto L9;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getAction()
            boolean r1 = com.jihuanshe.ui.widget.imagepreview.wight.SmoothImageView.A
            r2 = 2
            r3 = 3
            r4 = 1
            if (r1 == 0) goto L47
            float r1 = r6.getScale()
            r5 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 != 0) goto L34
            if (r0 == 0) goto L2c
            if (r0 == r4) goto L23
            if (r0 == r2) goto L1e
            if (r0 == r3) goto L23
            goto L2f
        L1e:
            boolean r7 = r6.H(r7)
            return r7
        L23:
            boolean r0 = r6.r
            if (r0 == 0) goto L2f
            boolean r7 = r6.F()
            return r7
        L2c:
            r6.G(r7)
        L2f:
            boolean r7 = super.dispatchTouchEvent(r7)
            return r7
        L34:
            if (r0 == r4) goto L39
            if (r0 == r3) goto L39
            goto L42
        L39:
            boolean r0 = r6.r
            if (r0 == 0) goto L42
            boolean r7 = r6.F()
            return r7
        L42:
            boolean r7 = super.dispatchTouchEvent(r7)
            return r7
        L47:
            if (r0 == 0) goto L5e
            if (r0 == r4) goto L55
            if (r0 == r2) goto L50
            if (r0 == r3) goto L55
            goto L61
        L50:
            boolean r7 = r6.H(r7)
            return r7
        L55:
            boolean r0 = r6.r
            if (r0 == 0) goto L61
            boolean r7 = r6.F()
            return r7
        L5e:
            r6.G(r7)
        L61:
            boolean r7 = super.dispatchTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.ui.widget.imagepreview.wight.SmoothImageView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.jihuanshe.ui.widget.imagepreview.photoview2.PhotoView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4314k = 0;
        this.f4315l = 0;
        this.f4312i = null;
        z = false;
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.n.clone();
            this.n = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        Status status = this.f4306c;
        if (status != Status.STATE_OUT && status != Status.STATE_IN) {
            if (status == Status.STATE_MOVE) {
                this.f4307d.setAlpha(0);
                canvas.drawPaint(this.f4307d);
                super.onDraw(canvas);
                return;
            }
            this.f4307d.setAlpha(255);
            canvas.drawPaint(this.f4307d);
            super.onDraw(canvas);
            return;
        }
        if (this.f4309f == null || this.f4310g == null || this.f4311h == null) {
            L();
        }
        i iVar = this.f4311h;
        if (iVar == null) {
            super.onDraw(canvas);
            return;
        }
        this.f4307d.setAlpha(iVar.f4319e);
        canvas.drawPaint(this.f4307d);
        int saveCount = canvas.getSaveCount();
        Matrix matrix = this.f4308e;
        float f2 = this.f4311h.f4320f;
        matrix.setScale(f2, f2);
        i iVar2 = this.f4311h;
        float f3 = iVar2.f4320f;
        this.f4308e.postTranslate((-((this.f4314k * f3) - iVar2.f4317c)) / 2.0f, (-((this.f4315l * f3) - iVar2.f4318d)) / 2.0f);
        i iVar3 = this.f4311h;
        canvas.translate(iVar3.a, iVar3.b);
        i iVar4 = this.f4311h;
        canvas.clipRect(0.0f, 0.0f, iVar4.f4317c, iVar4.f4318d);
        canvas.concat(this.f4308e);
        getDrawable().draw(canvas);
        canvas.restoreToCount(saveCount);
        if (this.f4313j) {
            P();
        }
    }

    public void setAlphaChangeListener(g gVar) {
        this.u = gVar;
    }

    public void setOnTransformListener(j jVar) {
        this.x = jVar;
    }

    public void setThumbRect(Rect rect) {
        this.f4312i = rect;
    }

    public void setTransformOutListener(h hVar) {
        this.v = hVar;
    }

    public SmoothImageView(Context context) {
        super(context);
        this.f4306c = Status.STATE_NORMAL;
        this.o = 0.8f;
        this.r = false;
        this.s = false;
        this.t = 0;
        K();
    }
}
