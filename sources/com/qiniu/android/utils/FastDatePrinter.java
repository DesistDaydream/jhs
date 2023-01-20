package com.qiniu.android.utils;

import com.ss.android.download.api.constant.BaseConstants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import k.b.a.a.n.l;

/* loaded from: classes3.dex */
public final class FastDatePrinter {
    public static final int FULL = 0;
    public static final int LONG = 1;
    private static final int MAX_DIGITS = 10;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;

    /* loaded from: classes3.dex */
    public static class CharacterLiteral implements Rule {
        private final char mValue;

        public CharacterLiteral(char c2) {
            this.mValue = c2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 1;
        }
    }

    /* loaded from: classes3.dex */
    public static class Iso8601_Rule implements Rule {
        public final int length;
        public static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
        public static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
        public static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);

        public Iso8601_Rule(int i2) {
            this.length = i2;
        }

        public static Iso8601_Rule getRule(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return ISO8601_HOURS_COLON_MINUTES;
                    }
                    throw new IllegalArgumentException("invalid number of X");
                }
                return ISO8601_HOURS_MINUTES;
            }
            return ISO8601_HOURS;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i2 = calendar.get(15) + calendar.get(16);
            if (i2 == 0) {
                appendable.append("Z");
                return;
            }
            if (i2 < 0) {
                appendable.append(l.f16189d);
                i2 = -i2;
            } else {
                appendable.append('+');
            }
            int i3 = i2 / BaseConstants.Time.HOUR;
            FastDatePrinter.appendDigits(appendable, i3);
            int i4 = this.length;
            if (i4 < 5) {
                return;
            }
            if (i4 == 6) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i2 / BaseConstants.Time.MINUTE) - (i3 * 60));
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return this.length;
        }
    }

    /* loaded from: classes3.dex */
    public interface NumberRule extends Rule {
        void appendTo(Appendable appendable, int i2) throws IOException;
    }

    /* loaded from: classes3.dex */
    public static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        public PaddedNumberField(int i2, int i3) {
            if (i3 >= 3) {
                this.mField = i2;
                this.mSize = i3;
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mSize;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i2) throws IOException {
            FastDatePrinter.appendFullDigits(appendable, i2, this.mSize);
        }
    }

    /* loaded from: classes3.dex */
    public interface Rule {
        void appendTo(Appendable appendable, Calendar calendar) throws IOException;

        int estimateLength();
    }

    /* loaded from: classes3.dex */
    public static class StringLiteral implements Rule {
        private final String mValue;

        public StringLiteral(String str) {
            this.mValue = str;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mValue.length();
        }
    }

    /* loaded from: classes3.dex */
    public static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        public TextField(int i2, String[] strArr) {
            this.mField = i2;
            this.mValues = strArr;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValues[calendar.get(this.mField)]);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            int length = this.mValues.length;
            int i2 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i2;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i2) {
                    i2 = length2;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class TimeZoneNumberRule implements Rule {
        public static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        public static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        public final boolean mColon;

        public TimeZoneNumberRule(boolean z) {
            this.mColon = z;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i2 = calendar.get(15) + calendar.get(16);
            if (i2 < 0) {
                appendable.append(l.f16189d);
                i2 = -i2;
            } else {
                appendable.append('+');
            }
            int i3 = i2 / BaseConstants.Time.HOUR;
            FastDatePrinter.appendDigits(appendable, i3);
            if (this.mColon) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i2 / BaseConstants.Time.MINUTE) - (i3 * 60));
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 5;
        }
    }

    /* loaded from: classes3.dex */
    public static class TwoDigitMonthField implements NumberRule {
        public static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i2) throws IOException {
            FastDatePrinter.appendDigits(appendable, i2);
        }
    }

    /* loaded from: classes3.dex */
    public static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        public TwoDigitNumberField(int i2) {
            this.mField = i2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i2) throws IOException {
            if (i2 < 100) {
                FastDatePrinter.appendDigits(appendable, i2);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i2, 2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class TwoDigitYearField implements NumberRule {
        public static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(1) % 100);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i2) throws IOException {
            FastDatePrinter.appendDigits(appendable, i2);
        }
    }

    /* loaded from: classes3.dex */
    public static class UnpaddedMonthField implements NumberRule {
        public static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i2) throws IOException {
            if (i2 >= 10) {
                FastDatePrinter.appendDigits(appendable, i2);
            } else {
                appendable.append((char) (i2 + 48));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        public UnpaddedNumberField(int i2) {
            this.mField = i2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i2) throws IOException {
            if (i2 < 10) {
                appendable.append((char) (i2 + 48));
            } else if (i2 < 100) {
                FastDatePrinter.appendDigits(appendable, i2);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i2, 1);
            }
        }
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendDigits(Appendable appendable, int i2) throws IOException {
        appendable.append((char) ((i2 / 10) + 48));
        appendable.append((char) ((i2 % 10) + 48));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendFullDigits(Appendable appendable, int i2, int i3) throws IOException {
        if (i2 < 10000) {
            int i4 = i2 < 1000 ? i2 < 100 ? i2 < 10 ? 1 : 2 : 3 : 4;
            for (int i5 = i3 - i4; i5 > 0; i5--) {
                appendable.append('0');
            }
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            return;
                        }
                        appendable.append((char) ((i2 / 1000) + 48));
                        i2 %= 1000;
                    }
                    if (i2 >= 100) {
                        appendable.append((char) ((i2 / 100) + 48));
                        i2 %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                if (i2 >= 10) {
                    appendable.append((char) ((i2 / 10) + 48));
                    i2 %= 10;
                } else {
                    appendable.append('0');
                }
            }
            appendable.append((char) (i2 + 48));
            return;
        }
        char[] cArr = new char[10];
        int i6 = 0;
        while (i2 != 0) {
            cArr[i6] = (char) ((i2 % 10) + 48);
            i2 /= 10;
            i6++;
        }
        while (i6 < i3) {
            appendable.append('0');
            i3--;
        }
        while (true) {
            i6--;
            if (i6 < 0) {
                return;
            }
            appendable.append(cArr[i6]);
        }
    }

    private String applyRulesToString(Calendar calendar) {
        return ((StringBuilder) applyRules(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    private void init() {
        List<Rule> parsePattern = parsePattern();
        Rule[] ruleArr = (Rule[]) parsePattern.toArray(new Rule[parsePattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int i2 = 0;
        while (true) {
            length--;
            if (length >= 0) {
                i2 += this.mRules[length].estimateLength();
            } else {
                this.mMaxLengthEstimate = i2;
                return;
            }
        }
    }

    private Calendar newCalendar() {
        return Calendar.getInstance(this.mTimeZone, this.mLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    @Deprecated
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return (StringBuffer) applyRules(calendar, (Calendar) stringBuffer);
    }

    public boolean equals(Object obj) {
        if (obj instanceof FastDatePrinter) {
            FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
            return this.mPattern.equals(fastDatePrinter.mPattern) && this.mTimeZone.equals(fastDatePrinter.mTimeZone) && this.mLocale.equals(fastDatePrinter.mLocale);
        }
        return false;
    }

    @Deprecated
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        sb.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    public List<Rule> parsePattern() {
        Rule stringLiteral;
        Rule rule;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int[] iArr = new int[1];
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            iArr[i2] = i3;
            String parseToken = parseToken(this.mPattern, iArr);
            int i4 = iArr[i2];
            int length2 = parseToken.length();
            if (length2 == 0) {
                return arrayList;
            }
            char charAt = parseToken.charAt(i2);
            switch (charAt) {
                case '\'':
                    String substring = parseToken.substring(1);
                    if (substring.length() == 1) {
                        stringLiteral = new CharacterLiteral(substring.charAt(0));
                    } else {
                        stringLiteral = new StringLiteral(substring);
                    }
                    rule = stringLiteral;
                    continue;
                    arrayList.add(rule);
                    i3 = i4 + 1;
                    i2 = 0;
                case 'K':
                    rule = selectNumberRule(10, length2);
                    break;
                case 'M':
                    if (length2 < 4) {
                        if (length2 != 3) {
                            if (length2 == 2) {
                                rule = TwoDigitMonthField.INSTANCE;
                                break;
                            } else {
                                rule = UnpaddedMonthField.INSTANCE;
                                break;
                            }
                        } else {
                            rule = new TextField(2, shortMonths);
                            break;
                        }
                    } else {
                        rule = new TextField(2, months);
                        break;
                    }
                case 'S':
                    rule = selectNumberRule(14, length2);
                    break;
                case 'a':
                    rule = new TextField(9, amPmStrings);
                    break;
                case 'd':
                    rule = selectNumberRule(5, length2);
                    break;
                case 'h':
                    rule = new TwelveHourField(selectNumberRule(10, length2));
                    break;
                case 'k':
                    rule = new TwentyFourHourField(selectNumberRule(11, length2));
                    break;
                case 'm':
                    rule = selectNumberRule(12, length2);
                    break;
                case 's':
                    rule = selectNumberRule(13, length2);
                    break;
                case 'u':
                    rule = new DayInWeekField(selectNumberRule(7, length2));
                    break;
                case 'w':
                    rule = selectNumberRule(3, length2);
                    break;
                default:
                    switch (charAt) {
                        case 'D':
                            rule = selectNumberRule(6, length2);
                            break;
                        case 'E':
                            rule = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                            break;
                        case 'F':
                            rule = selectNumberRule(8, length2);
                            break;
                        case 'G':
                            rule = new TextField(0, eras);
                            break;
                        case 'H':
                            rule = selectNumberRule(11, length2);
                            break;
                        default:
                            switch (charAt) {
                                case 'W':
                                    rule = selectNumberRule(4, length2);
                                    break;
                                case 'X':
                                    rule = Iso8601_Rule.getRule(length2);
                                    break;
                                case 'Y':
                                    break;
                                case 'Z':
                                    if (length2 != 1) {
                                        if (length2 == 2) {
                                            rule = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES;
                                            break;
                                        } else {
                                            rule = TimeZoneNumberRule.INSTANCE_COLON;
                                            break;
                                        }
                                    } else {
                                        rule = TimeZoneNumberRule.INSTANCE_NO_COLON;
                                        break;
                                    }
                                default:
                                    throw new IllegalArgumentException("Illegal pattern component: " + parseToken);
                            }
                    }
                case 'y':
                    if (length2 == 2) {
                        rule = TwoDigitYearField.INSTANCE;
                        break;
                    } else {
                        if (length2 < 4) {
                            length2 = 4;
                        }
                        rule = selectNumberRule(1, length2);
                        break;
                    }
            }
            arrayList.add(rule);
            i3 = i4 + 1;
            i2 = 0;
        }
        return arrayList;
    }

    public String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i2 = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i2);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb.append(charAt);
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= length || str.charAt(i3) != charAt) {
                    break;
                }
                sb.append(charAt);
                i2 = i3;
            }
        } else {
            sb.append('\'');
            boolean z = false;
            while (i2 < length) {
                char charAt2 = str.charAt(i2);
                if (charAt2 != '\'') {
                    if (!z && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                        i2--;
                        break;
                    }
                    sb.append(charAt2);
                } else {
                    int i4 = i2 + 1;
                    if (i4 >= length || str.charAt(i4) != '\'') {
                        z = !z;
                    } else {
                        sb.append(charAt2);
                        i2 = i4;
                    }
                }
                i2++;
            }
        }
        iArr[0] = i2;
        return sb.toString();
    }

    public NumberRule selectNumberRule(int i2, int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return new PaddedNumberField(i2, i3);
            }
            return new TwoDigitNumberField(i2);
        }
        return new UnpaddedNumberField(i2);
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + this.mLocale + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + this.mTimeZone.getID() + "]";
    }

    /* loaded from: classes3.dex */
    public static class DayInWeekField implements NumberRule {
        private final NumberRule mRule;

        public DayInWeekField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i2 = calendar.get(7);
            this.mRule.appendTo(appendable, i2 != 1 ? i2 - 1 : 7);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i2) throws IOException {
            this.mRule.appendTo(appendable, i2);
        }
    }

    private <B extends Appendable> B applyRules(Calendar calendar, B b) {
        try {
            for (Rule rule : this.mRules) {
                rule.appendTo(b, calendar);
            }
        } catch (IOException unused) {
        }
        return b;
    }

    /* loaded from: classes3.dex */
    public static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        public TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i2 = calendar.get(10);
            if (i2 == 0) {
                i2 = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(appendable, i2);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i2) throws IOException {
            this.mRule.appendTo(appendable, i2);
        }
    }

    /* loaded from: classes3.dex */
    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        public TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i2 = calendar.get(11);
            if (i2 == 0) {
                i2 = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(appendable, i2);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i2) throws IOException {
            this.mRule.appendTo(appendable, i2);
        }
    }

    public String format(Object obj) {
        if (obj instanceof Date) {
            return format((Date) obj);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        sb.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    public String format(long j2) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j2);
        return applyRulesToString(newCalendar);
    }

    public String format(Date date) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRulesToString(newCalendar);
    }

    public String format(Calendar calendar) {
        return ((StringBuilder) format(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    public StringBuffer format(long j2, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j2);
        return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return format(calendar.getTime(), stringBuffer);
    }

    public <B extends Appendable> B format(long j2, B b) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j2);
        return (B) applyRules(newCalendar, (Calendar) b);
    }

    public <B extends Appendable> B format(Date date, B b) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (B) applyRules(newCalendar, (Calendar) b);
    }

    public <B extends Appendable> B format(Calendar calendar, B b) {
        if (!calendar.getTimeZone().equals(this.mTimeZone)) {
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.mTimeZone);
        }
        return (B) applyRules(calendar, (Calendar) b);
    }
}
