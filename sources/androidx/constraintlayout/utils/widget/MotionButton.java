package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;

/* loaded from: classes.dex */
public class MotionButton extends AppCompatButton {
    private Path mPath;
    public RectF mRect;
    private float mRound;
    private float mRoundPercent;
    public ViewOutlineProvider mViewOutlineProvider;

    public MotionButton(Context context) {
        super(context);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        int i2 = Build.VERSION.SDK_INT;
        setPadding(0, 0, 0, 0);
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.ImageFilterView_round) {
                    if (i2 >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == R.styleable.ImageFilterView_roundPercent && i2 >= 21) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21 || this.mRound == 0.0f || this.mPath == null) {
            z = false;
        } else {
            z = true;
            canvas.save();
            canvas.clipPath(this.mPath);
        }
        super.draw(canvas);
        if (z) {
            canvas.restore();
        }
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    @RequiresApi(21)
    public void setRound(float round) {
        int i2 = Build.VERSION.SDK_INT;
        if (Float.isNaN(round)) {
            this.mRound = round;
            float f2 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.mRound != round;
        this.mRound = round;
        if (round != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (i2 >= 21) {
                if (this.mViewOutlineProvider == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionButton.2
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.mRound);
                        }
                    };
                    this.mViewOutlineProvider = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.mRect;
            float f3 = this.mRound;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else if (i2 >= 21) {
            setClipToOutline(false);
        }
        if (!z || i2 < 21) {
            return;
        }
        invalidateOutline();
    }

    @RequiresApi(21)
    public void setRoundPercent(float round) {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = this.mRoundPercent != round;
        this.mRoundPercent = round;
        if (round != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (i2 >= 21) {
                if (this.mViewOutlineProvider == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionButton.1
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            int width = MotionButton.this.getWidth();
                            int height = MotionButton.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * MotionButton.this.mRoundPercent) / 2.0f);
                        }
                    };
                    this.mViewOutlineProvider = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.mRoundPercent) / 2.0f;
            this.mRect.set(0.0f, 0.0f, width, height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, min, min, Path.Direction.CW);
        } else if (i2 >= 21) {
            setClipToOutline(false);
        }
        if (!z || i2 < 21) {
            return;
        }
        invalidateOutline();
    }

    public MotionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, attrs);
    }

    public MotionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, attrs);
    }
}
