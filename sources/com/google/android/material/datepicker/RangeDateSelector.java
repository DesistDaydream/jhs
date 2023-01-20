package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import e.j.a.c.m.d;
import e.j.a.c.m.f;
import e.j.a.c.m.k;
import e.j.a.c.m.o;
import e.j.a.c.s.e;
import e.j.a.c.s.t;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();
    private String invalidRangeStartError;
    private final String invalidRangeEndError = ExpandableTextView.N;
    @Nullable
    private Long selectedStartItem = null;
    @Nullable
    private Long selectedEndItem = null;
    @Nullable
    private Long proposedTextStart = null;
    @Nullable
    private Long proposedTextEnd = null;

    /* loaded from: classes2.dex */
    public class a extends e.j.a.c.m.c {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f2879h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f2880i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ k f2881j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, k kVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f2879h = textInputLayout2;
            this.f2880i = textInputLayout3;
            this.f2881j = kVar;
        }

        @Override // e.j.a.c.m.c
        public void e() {
            RangeDateSelector.this.proposedTextStart = null;
            RangeDateSelector.this.updateIfValidTextProposal(this.f2879h, this.f2880i, this.f2881j);
        }

        @Override // e.j.a.c.m.c
        public void f(@Nullable Long l2) {
            RangeDateSelector.this.proposedTextStart = l2;
            RangeDateSelector.this.updateIfValidTextProposal(this.f2879h, this.f2880i, this.f2881j);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends e.j.a.c.m.c {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f2883h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f2884i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ k f2885j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, k kVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f2883h = textInputLayout2;
            this.f2884i = textInputLayout3;
            this.f2885j = kVar;
        }

        @Override // e.j.a.c.m.c
        public void e() {
            RangeDateSelector.this.proposedTextEnd = null;
            RangeDateSelector.this.updateIfValidTextProposal(this.f2883h, this.f2884i, this.f2885j);
        }

        @Override // e.j.a.c.m.c
        public void f(@Nullable Long l2) {
            RangeDateSelector.this.proposedTextEnd = l2;
            RangeDateSelector.this.updateIfValidTextProposal(this.f2883h, this.f2884i, this.f2885j);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Parcelable.Creator<RangeDateSelector> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.selectedStartItem = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.selectedEndItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public RangeDateSelector[] newArray(int i2) {
            return new RangeDateSelector[i2];
        }
    }

    private void clearInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !ExpandableTextView.N.contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    private boolean isValidRange(long j2, long j3) {
        return j2 <= j3;
    }

    private void setInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(ExpandableTextView.N);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIfValidTextProposal(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull k<Pair<Long, Long>> kVar) {
        Long l2 = this.proposedTextStart;
        if (l2 != null && this.proposedTextEnd != null) {
            if (isValidRange(l2.longValue(), this.proposedTextEnd.longValue())) {
                this.selectedStartItem = this.proposedTextStart;
                this.selectedEndItem = this.proposedTextEnd;
                kVar.b(getSelection());
                return;
            }
            setInvalidRange(textInputLayout, textInputLayout2);
            kVar.a();
            return;
        }
        clearInvalidRange(textInputLayout, textInputLayout2);
        kVar.a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(@NonNull Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return e.j.a.c.w.b.g(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme, f.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.selectedStartItem;
        if (l2 != null) {
            arrayList.add(l2);
        }
        Long l3 = this.selectedEndItem;
        if (l3 != null) {
            arrayList.add(l3);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        if (this.selectedStartItem != null && this.selectedEndItem != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(this.selectedStartItem, this.selectedEndItem));
            return arrayList;
        }
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l2 = this.selectedStartItem;
        if (l2 == null && this.selectedEndItem == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l3 = this.selectedEndItem;
        if (l3 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, d.c(l2.longValue()));
        }
        if (l2 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, d.c(l3.longValue()));
        }
        Pair<String, String> a2 = d.a(l2, l3);
        return resources.getString(R.string.mtrl_picker_range_header_selected, a2.first, a2.second);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long l2 = this.selectedStartItem;
        return (l2 == null || this.selectedEndItem == null || !isValidRange(l2.longValue(), this.selectedEndItem.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull k<Pair<Long, Long>> kVar) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (e.a()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = inflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat p = o.p();
        Long l2 = this.selectedStartItem;
        if (l2 != null) {
            editText.setText(p.format(l2));
            this.proposedTextStart = this.selectedStartItem;
        }
        Long l3 = this.selectedEndItem;
        if (l3 != null) {
            editText2.setText(p.format(l3));
            this.proposedTextEnd = this.selectedEndItem;
        }
        String q = o.q(inflate.getResources(), p);
        textInputLayout.setPlaceholderText(q);
        textInputLayout2.setPlaceholderText(q);
        editText.addTextChangedListener(new a(q, p, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, kVar));
        editText2.addTextChangedListener(new b(q, p, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, kVar));
        t.o(editText);
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j2) {
        Long l2 = this.selectedStartItem;
        if (l2 == null) {
            this.selectedStartItem = Long.valueOf(j2);
        } else if (this.selectedEndItem == null && isValidRange(l2.longValue(), j2)) {
            this.selectedEndItem = Long.valueOf(j2);
        } else {
            this.selectedEndItem = null;
            this.selectedStartItem = Long.valueOf(j2);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Pair<Long, Long> getSelection() {
        return new Pair<>(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(@NonNull Pair<Long, Long> pair) {
        Long l2 = pair.first;
        if (l2 != null && pair.second != null) {
            Preconditions.checkArgument(isValidRange(l2.longValue(), pair.second.longValue()));
        }
        Long l3 = pair.first;
        this.selectedStartItem = l3 == null ? null : Long.valueOf(o.a(l3.longValue()));
        Long l4 = pair.second;
        this.selectedEndItem = l4 != null ? Long.valueOf(o.a(l4.longValue())) : null;
    }
}
