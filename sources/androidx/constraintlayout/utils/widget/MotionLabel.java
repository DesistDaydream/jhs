package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.view.GravityCompat;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: classes.dex */
public class MotionLabel extends View implements FloatLayout {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    public static String TAG = "MotionLabel";
    private boolean mAutoSize;
    private int mAutoSizeTextType;
    public float mBackgroundPanX;
    public float mBackgroundPanY;
    private float mBaseTextSize;
    private float mDeltaLeft;
    private float mFloatHeight;
    private float mFloatWidth;
    private String mFontFamily;
    private int mGravity;
    private Layout mLayout;
    public boolean mNotBuilt;
    public Matrix mOutlinePositionMatrix;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    public TextPaint mPaint;
    public Path mPath;
    public RectF mRect;
    public float mRotate;
    private float mRound;
    private float mRoundPercent;
    private int mStyleIndex;
    public Paint mTempPaint;
    public Rect mTempRect;
    private String mText;
    private Drawable mTextBackground;
    private Bitmap mTextBackgroundBitmap;
    private Rect mTextBounds;
    private int mTextFillColor;
    private int mTextOutlineColor;
    private float mTextOutlineThickness;
    private float mTextPanX;
    private float mTextPanY;
    private BitmapShader mTextShader;
    private Matrix mTextShaderMatrix;
    private float mTextSize;
    private int mTextureEffect;
    private float mTextureHeight;
    private float mTextureWidth;
    private CharSequence mTransformed;
    private int mTypefaceIndex;
    private boolean mUseOutline;
    public ViewOutlineProvider mViewOutlineProvider;
    public float mZoom;
    public Paint paintCache;
    public float paintTextSize;

    public MotionLabel(Context context) {
        super(context);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = 65535;
        this.mTextOutlineColor = 65535;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = BadgeDrawable.r;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.paintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(context, null);
    }

    private void adjustTexture(float l2, float t, float r, float b) {
        if (this.mTextShaderMatrix == null) {
            return;
        }
        this.mFloatWidth = r - l2;
        this.mFloatHeight = b - t;
        updateShaderMatrix();
    }

    private float getHorizontalOffset() {
        float f2 = Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize;
        TextPaint textPaint = this.mPaint;
        String str = this.mText;
        return (((((Float.isNaN(this.mFloatWidth) ? getMeasuredWidth() : this.mFloatWidth) - getPaddingLeft()) - getPaddingRight()) - (f2 * textPaint.measureText(str, 0, str.length()))) * (this.mTextPanX + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f2 = Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize;
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.mFloatHeight) ? getMeasuredHeight() : this.mFloatHeight) - getPaddingTop()) - getPaddingBottom();
        float f3 = fontMetrics.descent;
        float f4 = fontMetrics.ascent;
        return (((measuredHeight - ((f3 - f4) * f2)) * (1.0f - this.mTextPanY)) / 2.0f) - (f2 * f4);
    }

    private void init(Context context, AttributeSet attrs) {
        int i2 = Build.VERSION.SDK_INT;
        setUpTheme(context, attrs);
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R.styleable.MotionLabel_android_fontFamily) {
                    this.mFontFamily = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MotionLabel_scaleFromTextSize) {
                    this.mBaseTextSize = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mBaseTextSize);
                } else if (index == R.styleable.MotionLabel_android_textSize) {
                    this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mTextSize);
                } else if (index == R.styleable.MotionLabel_android_textStyle) {
                    this.mStyleIndex = obtainStyledAttributes.getInt(index, this.mStyleIndex);
                } else if (index == R.styleable.MotionLabel_android_typeface) {
                    this.mTypefaceIndex = obtainStyledAttributes.getInt(index, this.mTypefaceIndex);
                } else if (index == R.styleable.MotionLabel_android_textColor) {
                    this.mTextFillColor = obtainStyledAttributes.getColor(index, this.mTextFillColor);
                } else if (index == R.styleable.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.mRound);
                    this.mRound = dimension;
                    if (i2 >= 21) {
                        setRound(dimension);
                    }
                } else if (index == R.styleable.MotionLabel_borderRoundPercent) {
                    float f2 = obtainStyledAttributes.getFloat(index, this.mRoundPercent);
                    this.mRoundPercent = f2;
                    if (i2 >= 21) {
                        setRoundPercent(f2);
                    }
                } else if (index == R.styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R.styleable.MotionLabel_android_autoSizeTextType) {
                    this.mAutoSizeTextType = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.MotionLabel_textOutlineColor) {
                    this.mTextOutlineColor = obtainStyledAttributes.getInt(index, this.mTextOutlineColor);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textOutlineThickness) {
                    this.mTextOutlineThickness = obtainStyledAttributes.getDimension(index, this.mTextOutlineThickness);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textBackground) {
                    this.mTextBackground = obtainStyledAttributes.getDrawable(index);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textBackgroundPanX) {
                    this.mBackgroundPanX = obtainStyledAttributes.getFloat(index, this.mBackgroundPanX);
                } else if (index == R.styleable.MotionLabel_textBackgroundPanY) {
                    this.mBackgroundPanY = obtainStyledAttributes.getFloat(index, this.mBackgroundPanY);
                } else if (index == R.styleable.MotionLabel_textPanX) {
                    this.mTextPanX = obtainStyledAttributes.getFloat(index, this.mTextPanX);
                } else if (index == R.styleable.MotionLabel_textPanY) {
                    this.mTextPanY = obtainStyledAttributes.getFloat(index, this.mTextPanY);
                } else if (index == R.styleable.MotionLabel_textBackgroundRotate) {
                    this.mRotate = obtainStyledAttributes.getFloat(index, this.mRotate);
                } else if (index == R.styleable.MotionLabel_textBackgroundZoom) {
                    this.mZoom = obtainStyledAttributes.getFloat(index, this.mZoom);
                } else if (index == R.styleable.MotionLabel_textureHeight) {
                    this.mTextureHeight = obtainStyledAttributes.getDimension(index, this.mTextureHeight);
                } else if (index == R.styleable.MotionLabel_textureWidth) {
                    this.mTextureWidth = obtainStyledAttributes.getDimension(index, this.mTextureWidth);
                } else if (index == R.styleable.MotionLabel_textureEffect) {
                    this.mTextureEffect = obtainStyledAttributes.getInt(index, this.mTextureEffect);
                }
            }
            obtainStyledAttributes.recycle();
        }
        setupTexture();
        setupPath();
    }

    private void setTypefaceFromAttrs(String familyName, int typefaceIndex, int styleIndex) {
        Typeface typeface;
        Typeface create;
        if (familyName != null) {
            typeface = Typeface.create(familyName, styleIndex);
            if (typeface != null) {
                setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        if (typefaceIndex == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (typefaceIndex == 2) {
            typeface = Typeface.SERIF;
        } else if (typefaceIndex == 3) {
            typeface = Typeface.MONOSPACE;
        }
        if (styleIndex > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(styleIndex);
            } else {
                create = Typeface.create(typeface, styleIndex);
            }
            setTypeface(create);
            int i2 = (~(create != null ? create.getStyle() : 0)) & styleIndex;
            this.mPaint.setFakeBoldText((i2 & 1) != 0);
            this.mPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.mPaint.setFakeBoldText(false);
        this.mPaint.setTextSkewX(0.0f);
        setTypeface(typeface);
    }

    private void setUpTheme(Context context, @Nullable AttributeSet attrs) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.mPaint;
        int i2 = typedValue.data;
        this.mTextFillColor = i2;
        textPaint.setColor(i2);
    }

    private void setupTexture() {
        if (this.mTextBackground != null) {
            this.mTextShaderMatrix = new Matrix();
            int intrinsicWidth = this.mTextBackground.getIntrinsicWidth();
            int intrinsicHeight = this.mTextBackground.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.mTextureWidth) ? 128 : (int) this.mTextureWidth;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                intrinsicHeight = Float.isNaN(this.mTextureHeight) ? 128 : (int) this.mTextureHeight;
            }
            if (this.mTextureEffect != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.mTextBackgroundBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.mTextBackgroundBitmap);
            this.mTextBackground.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.mTextBackground.setFilterBitmap(true);
            this.mTextBackground.draw(canvas);
            if (this.mTextureEffect != 0) {
                this.mTextBackgroundBitmap = blur(this.mTextBackgroundBitmap, 4);
            }
            Bitmap bitmap = this.mTextBackgroundBitmap;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.mTextShader = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    private void updateShaderMatrix() {
        float f2 = Float.isNaN(this.mBackgroundPanX) ? 0.0f : this.mBackgroundPanX;
        float f3 = Float.isNaN(this.mBackgroundPanY) ? 0.0f : this.mBackgroundPanY;
        float f4 = Float.isNaN(this.mZoom) ? 1.0f : this.mZoom;
        float f5 = Float.isNaN(this.mRotate) ? 0.0f : this.mRotate;
        this.mTextShaderMatrix.reset();
        float width = this.mTextBackgroundBitmap.getWidth();
        float height = this.mTextBackgroundBitmap.getHeight();
        float f6 = Float.isNaN(this.mTextureWidth) ? this.mFloatWidth : this.mTextureWidth;
        float f7 = Float.isNaN(this.mTextureHeight) ? this.mFloatHeight : this.mTextureHeight;
        float f8 = f4 * (width * f7 < height * f6 ? f6 / width : f7 / height);
        this.mTextShaderMatrix.postScale(f8, f8);
        float f9 = width * f8;
        float f10 = f6 - f9;
        float f11 = f8 * height;
        float f12 = f7 - f11;
        if (!Float.isNaN(this.mTextureHeight)) {
            f12 = this.mTextureHeight / 2.0f;
        }
        if (!Float.isNaN(this.mTextureWidth)) {
            f10 = this.mTextureWidth / 2.0f;
        }
        this.mTextShaderMatrix.postTranslate((((f2 * f10) + f6) - f9) * 0.5f, (((f3 * f12) + f7) - f11) * 0.5f);
        this.mTextShaderMatrix.postRotate(f5, f6 / 2.0f, f7 / 2.0f);
        this.mTextShader.setLocalMatrix(this.mTextShaderMatrix);
    }

    public Bitmap blur(Bitmap bitmapOriginal, int factor) {
        System.nanoTime();
        int width = bitmapOriginal.getWidth() / 2;
        int height = bitmapOriginal.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapOriginal, width, height, true);
        for (int i2 = 0; i2 < factor && width >= 32 && height >= 32; i2++) {
            width /= 2;
            height /= 2;
            createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
        }
        return createScaledBitmap;
    }

    public void buildShape(float scale) {
        if (this.mUseOutline || scale != 1.0f) {
            this.mPath.reset();
            String str = this.mText;
            int length = str.length();
            this.mPaint.getTextBounds(str, 0, length, this.mTextBounds);
            this.mPaint.getTextPath(str, 0, length, 0.0f, 0.0f, this.mPath);
            if (scale != 1.0f) {
                String str2 = TAG;
                String loc = Debug.getLoc();
                StringBuilder sb = new StringBuilder(String.valueOf(loc).length() + 22);
                sb.append(loc);
                sb.append(" scale ");
                sb.append(scale);
                Log.v(str2, sb.toString());
                Matrix matrix = new Matrix();
                matrix.postScale(scale, scale);
                this.mPath.transform(matrix);
            }
            Rect rect = this.mTextBounds;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.mNotBuilt = false;
        }
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getScaleFromTextSize() {
        return this.mBaseTextSize;
    }

    public float getTextBackgroundPanX() {
        return this.mBackgroundPanX;
    }

    public float getTextBackgroundPanY() {
        return this.mBackgroundPanY;
    }

    public float getTextBackgroundRotate() {
        return this.mRotate;
    }

    public float getTextBackgroundZoom() {
        return this.mZoom;
    }

    public int getTextOutlineColor() {
        return this.mTextOutlineColor;
    }

    public float getTextPanX() {
        return this.mTextPanX;
    }

    public float getTextPanY() {
        return this.mTextPanY;
    }

    public float getTextureHeight() {
        return this.mTextureHeight;
    }

    public float getTextureWidth() {
        return this.mTextureWidth;
    }

    public Typeface getTypeface() {
        return this.mPaint.getTypeface();
    }

    @Override // android.view.View
    public void layout(int l2, int t, int r, int b) {
        super.layout(l2, t, r, b);
        boolean isNaN = Float.isNaN(this.mBaseTextSize);
        float f2 = isNaN ? 1.0f : this.mTextSize / this.mBaseTextSize;
        this.mFloatWidth = r - l2;
        this.mFloatHeight = b - t;
        if (this.mAutoSize) {
            if (this.mTempRect == null) {
                this.mTempPaint = new Paint();
                this.mTempRect = new Rect();
                this.mTempPaint.set(this.mPaint);
                this.paintTextSize = this.mTempPaint.getTextSize();
            }
            Paint paint = this.mTempPaint;
            String str = this.mText;
            paint.getTextBounds(str, 0, str.length(), this.mTempRect);
            int width = this.mTempRect.width();
            int height = (int) (this.mTempRect.height() * 1.3f);
            float f3 = (this.mFloatWidth - this.mPaddingRight) - this.mPaddingLeft;
            float f4 = (this.mFloatHeight - this.mPaddingBottom) - this.mPaddingTop;
            if (isNaN) {
                float f5 = width;
                float f6 = height;
                if (f5 * f4 > f6 * f3) {
                    this.mPaint.setTextSize((this.paintTextSize * f3) / f5);
                } else {
                    this.mPaint.setTextSize((this.paintTextSize * f4) / f6);
                }
            } else {
                float f7 = width;
                float f8 = height;
                f2 = f7 * f4 > f8 * f3 ? f3 / f7 : f4 / f8;
            }
        }
        if (this.mUseOutline || !isNaN) {
            adjustTexture(l2, t, r, b);
            buildShape(f2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f2 = Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize;
        super.onDraw(canvas);
        if (!this.mUseOutline && f2 == 1.0f) {
            canvas.drawText(this.mText, this.mDeltaLeft + this.mPaddingLeft + getHorizontalOffset(), this.mPaddingTop + getVerticalOffset(), this.mPaint);
            return;
        }
        if (this.mNotBuilt) {
            buildShape(f2);
        }
        if (this.mOutlinePositionMatrix == null) {
            this.mOutlinePositionMatrix = new Matrix();
        }
        if (this.mUseOutline) {
            this.paintCache.set(this.mPaint);
            this.mOutlinePositionMatrix.reset();
            float horizontalOffset = this.mPaddingLeft + getHorizontalOffset();
            float verticalOffset = this.mPaddingTop + getVerticalOffset();
            this.mOutlinePositionMatrix.postTranslate(horizontalOffset, verticalOffset);
            this.mOutlinePositionMatrix.preScale(f2, f2);
            this.mPath.transform(this.mOutlinePositionMatrix);
            if (this.mTextShader != null) {
                this.mPaint.setFilterBitmap(true);
                this.mPaint.setShader(this.mTextShader);
            } else {
                this.mPaint.setColor(this.mTextFillColor);
            }
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
            canvas.drawPath(this.mPath, this.mPaint);
            if (this.mTextShader != null) {
                this.mPaint.setShader(null);
            }
            this.mPaint.setColor(this.mTextOutlineColor);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
            canvas.drawPath(this.mPath, this.mPaint);
            this.mOutlinePositionMatrix.reset();
            this.mOutlinePositionMatrix.postTranslate(-horizontalOffset, -verticalOffset);
            this.mPath.transform(this.mOutlinePositionMatrix);
            this.mPaint.set(this.paintCache);
            return;
        }
        float horizontalOffset2 = this.mPaddingLeft + getHorizontalOffset();
        float verticalOffset2 = this.mPaddingTop + getVerticalOffset();
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.preTranslate(horizontalOffset2, verticalOffset2);
        this.mPath.transform(this.mOutlinePositionMatrix);
        this.mPaint.setColor(this.mTextFillColor);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        canvas.drawPath(this.mPath, this.mPaint);
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.preTranslate(-horizontalOffset2, -verticalOffset2);
        this.mPath.transform(this.mOutlinePositionMatrix);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        this.mAutoSize = false;
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        if (mode == 1073741824 && mode2 == 1073741824) {
            if (this.mAutoSizeTextType != 0) {
                this.mAutoSize = true;
            }
        } else {
            TextPaint textPaint = this.mPaint;
            String str = this.mText;
            textPaint.getTextBounds(str, 0, str.length(), this.mTextBounds);
            if (mode != 1073741824) {
                size = (int) (this.mTextBounds.width() + 0.99999f);
            }
            size += this.mPaddingLeft + this.mPaddingRight;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.mPaint.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.mPaddingTop + this.mPaddingBottom + fontMetricsInt;
            }
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int gravity) {
        if ((gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
            gravity |= GravityCompat.START;
        }
        if ((gravity & 112) == 0) {
            gravity |= 48;
        }
        int i2 = gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i3 = this.mGravity;
        int i4 = i3 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (gravity != i3) {
            invalidate();
        }
        this.mGravity = gravity;
        int i5 = gravity & 112;
        if (i5 == 48) {
            this.mTextPanY = -1.0f;
        } else if (i5 != 80) {
            this.mTextPanY = 0.0f;
        } else {
            this.mTextPanY = 1.0f;
        }
        int i6 = gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i6 != 3) {
            if (i6 != 5) {
                if (i6 != 8388611) {
                    if (i6 != 8388613) {
                        this.mTextPanX = 0.0f;
                        return;
                    }
                }
            }
            this.mTextPanX = 1.0f;
            return;
        }
        this.mTextPanX = -1.0f;
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
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionLabel.2
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.mRound);
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
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionLabel.1
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            int width = MotionLabel.this.getWidth();
                            int height = MotionLabel.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * MotionLabel.this.mRoundPercent) / 2.0f);
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

    public void setScaleFromTextSize(float size) {
        this.mBaseTextSize = size;
    }

    public void setText(CharSequence text) {
        this.mText = text.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float pan) {
        this.mBackgroundPanX = pan;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundPanY(float pan) {
        this.mBackgroundPanY = pan;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundRotate(float rotation) {
        this.mRotate = rotation;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundZoom(float zoom) {
        this.mZoom = zoom;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextFillColor(int color) {
        this.mTextFillColor = color;
        invalidate();
    }

    public void setTextOutlineColor(int color) {
        this.mTextOutlineColor = color;
        this.mUseOutline = true;
        invalidate();
    }

    public void setTextOutlineThickness(float width) {
        this.mTextOutlineThickness = width;
        this.mUseOutline = true;
        if (Float.isNaN(width)) {
            this.mTextOutlineThickness = 1.0f;
            this.mUseOutline = false;
        }
        invalidate();
    }

    public void setTextPanX(float textPanX) {
        this.mTextPanX = textPanX;
        invalidate();
    }

    public void setTextPanY(float textPanY) {
        this.mTextPanY = textPanY;
        invalidate();
    }

    public void setTextSize(float size) {
        this.mTextSize = size;
        String str = TAG;
        String loc = Debug.getLoc();
        float f2 = this.mBaseTextSize;
        StringBuilder sb = new StringBuilder(String.valueOf(loc).length() + 35);
        sb.append(loc);
        sb.append("  ");
        sb.append(size);
        sb.append(" / ");
        sb.append(f2);
        Log.v(str, sb.toString());
        TextPaint textPaint = this.mPaint;
        if (!Float.isNaN(this.mBaseTextSize)) {
            size = this.mBaseTextSize;
        }
        textPaint.setTextSize(size);
        buildShape(Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float mTextureHeight) {
        this.mTextureHeight = mTextureHeight;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextureWidth(float mTextureWidth) {
        this.mTextureWidth = mTextureWidth;
        updateShaderMatrix();
        invalidate();
    }

    public void setTypeface(Typeface tf) {
        if (this.mPaint.getTypeface() != tf) {
            this.mPaint.setTypeface(tf);
            if (this.mLayout != null) {
                this.mLayout = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public void setupPath() {
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        setTypefaceFromAttrs(this.mFontFamily, this.mTypefaceIndex, this.mStyleIndex);
        this.mPaint.setColor(this.mTextFillColor);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setFlags(128);
        setTextSize(this.mTextSize);
        this.mPaint.setAntiAlias(true);
    }

    @Override // androidx.constraintlayout.motion.widget.FloatLayout
    public void layout(float l2, float t, float r, float b) {
        int i2 = (int) (l2 + 0.5f);
        this.mDeltaLeft = l2 - i2;
        int i3 = (int) (r + 0.5f);
        int i4 = i3 - i2;
        int i5 = (int) (b + 0.5f);
        int i6 = (int) (0.5f + t);
        int i7 = i5 - i6;
        float f2 = r - l2;
        this.mFloatWidth = f2;
        float f3 = b - t;
        this.mFloatHeight = f3;
        adjustTexture(l2, t, r, b);
        if (getMeasuredHeight() == i7 && getMeasuredWidth() == i4) {
            super.layout(i2, i6, i3, i5);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
            super.layout(i2, i6, i3, i5);
        }
        if (this.mAutoSize) {
            if (this.mTempRect == null) {
                this.mTempPaint = new Paint();
                this.mTempRect = new Rect();
                this.mTempPaint.set(this.mPaint);
                this.paintTextSize = this.mTempPaint.getTextSize();
            }
            this.mFloatWidth = f2;
            this.mFloatHeight = f3;
            Paint paint = this.mTempPaint;
            String str = this.mText;
            paint.getTextBounds(str, 0, str.length(), this.mTempRect);
            float height = this.mTempRect.height() * 1.3f;
            float f4 = (f2 - this.mPaddingRight) - this.mPaddingLeft;
            float f5 = (f3 - this.mPaddingBottom) - this.mPaddingTop;
            float width = this.mTempRect.width();
            if (width * f5 > height * f4) {
                this.mPaint.setTextSize((this.paintTextSize * f4) / width);
            } else {
                this.mPaint.setTextSize((this.paintTextSize * f5) / height);
            }
            if (this.mUseOutline || !Float.isNaN(this.mBaseTextSize)) {
                buildShape(Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize);
            }
        }
    }

    public MotionLabel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = 65535;
        this.mTextOutlineColor = 65535;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = BadgeDrawable.r;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.paintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(context, attrs);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = 65535;
        this.mTextOutlineColor = 65535;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = BadgeDrawable.r;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.paintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(context, attrs);
    }
}
