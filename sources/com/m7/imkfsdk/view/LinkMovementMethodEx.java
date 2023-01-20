package com.m7.imkfsdk.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: classes2.dex */
public class LinkMovementMethodEx extends LinkMovementMethod {
    private LinkClickListener listener;

    public LinkMovementMethodEx(LinkClickListener linkClickListener) {
        this.listener = linkClickListener;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            int scrollY = y + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            Object[] objArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (objArr.length != 0) {
                if (action == 1) {
                    if (objArr[0] instanceof URLSpan) {
                        URLSpan uRLSpan = (URLSpan) objArr[0];
                        LinkClickListener linkClickListener = this.listener;
                        if (linkClickListener != null && linkClickListener.onLinkClick(uRLSpan.getURL())) {
                            return true;
                        }
                        objArr[0].onClick(textView);
                    } else {
                        objArr[0].onClick(textView);
                    }
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(objArr[0]), spannable.getSpanEnd(objArr[0]));
                }
                return true;
            }
            Selection.removeSelection(spannable);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
