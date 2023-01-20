package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import e.j.a.c.m.c;
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
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();
    @Nullable
    private Long selectedItem;

    /* loaded from: classes2.dex */
    public class a extends c {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ k f2887h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, k kVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f2887h = kVar;
        }

        @Override // e.j.a.c.m.c
        public void e() {
            this.f2887h.a();
        }

        @Override // e.j.a.c.m.c
        public void f(@Nullable Long l2) {
            if (l2 == null) {
                SingleDateSelector.this.clearSelection();
            } else {
                SingleDateSelector.this.select(l2.longValue());
            }
            this.f2887h.b(SingleDateSelector.this.getSelection());
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Parcelable.Creator<SingleDateSelector> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public SingleDateSelector createFromParcel(@NonNull Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.selectedItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public SingleDateSelector[] newArray(int i2) {
            return new SingleDateSelector[i2];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelection() {
        this.selectedItem = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context context) {
        return e.j.a.c.w.b.g(context, R.attr.materialCalendarTheme, f.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_date_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.selectedItem;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l2 = this.selectedItem;
        if (l2 == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R.string.mtrl_picker_date_header_selected, d.j(l2.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        return this.selectedItem != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull k<Long> kVar) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (e.a()) {
            editText.setInputType(17);
        }
        SimpleDateFormat p = o.p();
        String q = o.q(inflate.getResources(), p);
        textInputLayout.setPlaceholderText(q);
        Long l2 = this.selectedItem;
        if (l2 != null) {
            editText.setText(p.format(l2));
        }
        editText.addTextChangedListener(new a(q, p, textInputLayout, calendarConstraints, kVar));
        t.o(editText);
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j2) {
        this.selectedItem = Long.valueOf(j2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeValue(this.selectedItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    public Long getSelection() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(@Nullable Long l2) {
        this.selectedItem = l2 == null ? null : Long.valueOf(o.a(l2.longValue()));
    }
}
