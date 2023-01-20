package e.l.q.c.t0.d;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class b implements GestureDetector.OnDoubleTapListener {
    private d a;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.a = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        d dVar = this.a;
        if (dVar == null) {
            return false;
        }
        try {
            float scale = dVar.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.a.getMediumScale()) {
                d dVar2 = this.a;
                dVar2.setScale(dVar2.getMediumScale(), x, y, true);
            } else if (scale >= this.a.getMediumScale() && scale < this.a.getMaximumScale()) {
                d dVar3 = this.a;
                dVar3.setScale(dVar3.getMaximumScale(), x, y, true);
            } else {
                d dVar4 = this.a;
                dVar4.setScale(dVar4.getMinimumScale(), x, y, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        d dVar = this.a;
        if (dVar == null) {
            return false;
        }
        ImageView r = dVar.r();
        if (this.a.u() != null && (displayRect = this.a.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.contains(x, y)) {
                this.a.u().b(r, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
            this.a.u().a();
        }
        if (this.a.v() != null) {
            this.a.v().onViewTap(r, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }
}
