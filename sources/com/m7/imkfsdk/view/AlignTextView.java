package com.m7.imkfsdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.m7.imkfsdk.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AlignTextView extends TextView {
    private Align align;
    private boolean firstCalc;
    private float lineSpacingAdd;
    private float lineSpacingMultiplier;
    private List<String> lines;
    private int originalHeight;
    private int originalLineCount;
    private int originalPaddingBottom;
    private boolean setPaddingFromMe;
    private List<Integer> tailLines;
    private float textHeight;
    private float textLineSpaceExtra;
    private int width;

    /* loaded from: classes2.dex */
    public enum Align {
        ALIGN_LEFT,
        ALIGN_CENTER,
        ALIGN_RIGHT
    }

    public AlignTextView(Context context) {
        super(context);
        this.textLineSpaceExtra = 0.0f;
        this.lines = new ArrayList();
        this.tailLines = new ArrayList();
        this.align = Align.ALIGN_LEFT;
        this.firstCalc = true;
        this.lineSpacingMultiplier = 1.0f;
        this.lineSpacingAdd = 0.0f;
        this.originalHeight = 0;
        this.originalLineCount = 0;
        this.originalPaddingBottom = 0;
        this.setPaddingFromMe = false;
        setTextIsSelectable(false);
    }

    private void calc(Paint paint, String str) {
        if (str.length() == 0) {
            this.lines.add("\n");
            return;
        }
        int measureText = (int) (this.width / paint.measureText("中"));
        int i2 = measureText + 1;
        int i3 = 0;
        StringBuilder sb = new StringBuilder(str.substring(0, Math.min(i2, str.length())));
        while (true) {
            if (i2 >= str.length()) {
                break;
            }
            if (paint.measureText(str.substring(i3, i2 + 1)) > this.width) {
                this.lines.add(sb.toString());
                sb = new StringBuilder();
                if (str.length() - i2 > measureText) {
                    int i4 = i2 + measureText;
                    sb.append(str.substring(i2, i4));
                    i3 = i2;
                    i2 = i4 - 1;
                } else {
                    this.lines.add(str.substring(i2));
                    break;
                }
            } else {
                sb.append(str.charAt(i2));
            }
            i2++;
        }
        if (sb.length() > 0) {
            this.lines.add(sb.toString());
        }
        this.tailLines.add(Integer.valueOf(this.lines.size() - 1));
    }

    private void measureTextViewHeight(String str, float f2, int i2) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextSize(0, f2);
        textView.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.originalLineCount = textView.getLineCount();
        this.originalHeight = textView.getMeasuredHeight();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0090, code lost:
        if (r14 == com.m7.imkfsdk.view.AlignTextView.Align.ALIGN_RIGHT) goto L12;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDraw(android.graphics.Canvas r17) {
        /*
            r16 = this;
            r0 = r16
            android.text.TextPaint r1 = r16.getPaint()
            int r2 = r16.getCurrentTextColor()
            r1.setColor(r2)
            int[] r2 = r16.getDrawableState()
            r1.drawableState = r2
            int r2 = r16.getMeasuredWidth()
            r0.width = r2
            android.graphics.Paint$FontMetrics r2 = r1.getFontMetrics()
            float r3 = r16.getTextSize()
            float r4 = r2.bottom
            float r5 = r2.descent
            float r4 = r4 - r5
            float r5 = r2.ascent
            float r4 = r4 + r5
            float r2 = r2.top
            float r4 = r4 - r2
            float r3 = r3 - r4
            int r2 = r16.getGravity()
            r2 = r2 & 4096(0x1000, float:5.74E-42)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r2 != 0) goto L3c
            float r2 = r0.textHeight
            float r2 = r2 - r3
            float r2 = r2 / r4
            float r3 = r3 + r2
        L3c:
            int r2 = r16.getPaddingTop()
            int r5 = r16.getPaddingLeft()
            int r6 = r16.getPaddingRight()
            int r7 = r0.width
            int r7 = r7 - r5
            int r7 = r7 - r6
            r0.width = r7
            r6 = 0
            r7 = 0
        L50:
            java.util.List<java.lang.String> r8 = r0.lines
            int r8 = r8.size()
            if (r7 >= r8) goto Lc6
            float r8 = (float) r7
            float r9 = r0.textHeight
            float r9 = r9 * r8
            float r9 = r9 + r3
            java.util.List<java.lang.String> r10 = r0.lines
            java.lang.Object r10 = r10.get(r7)
            java.lang.String r10 = (java.lang.String) r10
            float r11 = (float) r5
            int r12 = r0.width
            float r12 = (float) r12
            float r13 = r1.measureText(r10)
            float r12 = r12 - r13
            int r13 = r10.length()
            int r13 = r13 + (-1)
            float r13 = (float) r13
            float r13 = r12 / r13
            java.util.List<java.lang.Integer> r14 = r0.tailLines
            java.lang.Integer r15 = java.lang.Integer.valueOf(r7)
            boolean r14 = r14.contains(r15)
            if (r14 == 0) goto L93
            r13 = 0
            com.m7.imkfsdk.view.AlignTextView$Align r14 = r0.align
            com.m7.imkfsdk.view.AlignTextView$Align r15 = com.m7.imkfsdk.view.AlignTextView.Align.ALIGN_CENTER
            if (r14 != r15) goto L8e
            float r12 = r12 / r4
        L8c:
            float r11 = r11 + r12
            goto L93
        L8e:
            com.m7.imkfsdk.view.AlignTextView$Align r15 = com.m7.imkfsdk.view.AlignTextView.Align.ALIGN_RIGHT
            if (r14 != r15) goto L93
            goto L8c
        L93:
            r12 = 0
        L94:
            int r14 = r10.length()
            if (r12 >= r14) goto Lbe
            java.lang.String r14 = r10.substring(r6, r12)
            float r14 = r1.measureText(r14)
            float r15 = (float) r12
            float r15 = r15 * r13
            float r14 = r14 + r15
            int r15 = r12 + 1
            java.lang.String r12 = r10.substring(r12, r15)
            float r14 = r14 + r11
            float r4 = (float) r2
            float r4 = r4 + r9
            float r6 = r0.textLineSpaceExtra
            float r6 = r6 * r8
            float r4 = r4 + r6
            r6 = r17
            r6.drawText(r12, r14, r4, r1)
            r12 = r15
            r4 = 1073741824(0x40000000, float:2.0)
            r6 = 0
            goto L94
        Lbe:
            r6 = r17
            int r7 = r7 + 1
            r4 = 1073741824(0x40000000, float:2.0)
            r6 = 0
            goto L50
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m7.imkfsdk.view.AlignTextView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.firstCalc) {
            this.width = getMeasuredWidth();
            String charSequence = getText().toString();
            TextPaint paint = getPaint();
            this.lines.clear();
            this.tailLines.clear();
            for (String str : charSequence.split("\\n")) {
                calc(paint, str);
            }
            measureTextViewHeight(charSequence, paint.getTextSize(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            float f2 = (this.originalHeight * 1.0f) / this.originalLineCount;
            this.textHeight = f2;
            float f3 = ((this.lineSpacingMultiplier - 1.0f) * f2) + this.lineSpacingAdd;
            this.textLineSpaceExtra = f3;
            this.setPaddingFromMe = true;
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.originalPaddingBottom + ((int) ((f3 + f2) * (this.lines.size() - this.originalLineCount))));
            this.firstCalc = false;
        }
    }

    public void setAlign(Align align) {
        this.align = align;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        if (!this.setPaddingFromMe) {
            this.originalPaddingBottom = i5;
        }
        this.setPaddingFromMe = false;
        super.setPadding(i2, i3, i4, i5);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.firstCalc = true;
        super.setText(charSequence, bufferType);
    }

    public AlignTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.textLineSpaceExtra = 0.0f;
        this.lines = new ArrayList();
        this.tailLines = new ArrayList();
        Align align = Align.ALIGN_LEFT;
        this.align = align;
        this.firstCalc = true;
        this.lineSpacingMultiplier = 1.0f;
        this.lineSpacingAdd = 0.0f;
        this.originalHeight = 0;
        this.originalLineCount = 0;
        this.originalPaddingBottom = 0;
        this.setPaddingFromMe = false;
        setTextIsSelectable(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843287, 16843288});
        this.lineSpacingAdd = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.lineSpacingMultiplier = obtainStyledAttributes.getFloat(1, 1.0f);
        this.originalPaddingBottom = getPaddingBottom();
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.ykfsdk_AlignTextView);
        int i2 = obtainStyledAttributes2.getInt(R.styleable.ykfsdk_AlignTextView_ykfsdk_align, 1);
        if (i2 == 1) {
            this.align = Align.ALIGN_CENTER;
        } else if (i2 != 2) {
            this.align = align;
        } else {
            this.align = Align.ALIGN_RIGHT;
        }
        obtainStyledAttributes2.recycle();
    }
}
