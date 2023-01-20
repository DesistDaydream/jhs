package com.m7.imkfsdk.view.pickerview.utils;

import com.caverock.androidsvg.SVG;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ChinaDate {
    private static final long[] lunarInfo = {19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42448, 83315, 21200, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46496, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19415, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448};
    private static final int[] year20 = {1, 4, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1};
    private static final int[] year19 = {0, 3, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0};
    private static final int[] year2000 = {0, 3, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1};
    public static final String[] nStr1 = {"", "正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "冬", "腊"};
    private static final String[] Gan = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    private static final String[] Zhi = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    private static final String[] Animals = {"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};
    private static final String[] solarTerm = {"小寒", "大寒", "立春", "雨水", "惊蛰", "春分", "清明", "谷雨", "立夏", "小满", "芒种", "夏至", "小暑", "大暑", "立秋", "处暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"};
    private static final String[] sFtv = {"0101*元旦", "0214 情人节", "0308 妇女节", "0312 植树节", "0315 消费者权益日", "0401 愚人节", "0501 劳动节", "0504 青年节", "0512 护士节", "0601 儿童节", "0701 建党节", "0801 建军节", "0808 父亲节", "0909 mzd逝世纪念", "0910 教师节", "0928 孔子诞辰", "1001*国庆节", "1006 老人节", "1024 联合国日", "1112 孙中山诞辰", "1220 澳门回归", "1225 圣诞节", "1226 mzd诞辰"};
    private static final String[] lFtv = {"0101*农历春节", "0115 元宵节", "0505 端午节", "0707 七夕情人节", "0815 中秋节", "0909 重阳节", "1208 腊八节", "1224 小年", "0100*除夕"};
    private static final int[] dayArr = {20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22};
    private static final String[] constellationArr = {"摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"};
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日 EEEEE");

    public static final String AnimalsYear(int i2) {
        return Animals[(i2 - 4) % 12];
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long[] Lunar(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m7.imkfsdk.view.pickerview.utils.ChinaDate.Lunar(int, int):long[]");
    }

    public static final long[] calElement(int i2, int i3, int i4) {
        long j2;
        long j3;
        long[] jArr = new long[7];
        int i5 = LunarCalendar.MIN_YEAR;
        long time = (new GregorianCalendar(i2, i3 - 1, i4).getTime().getTime() - new GregorianCalendar(LunarCalendar.MIN_YEAR, 0, 31).getTime().getTime()) / 86400000;
        jArr[5] = 40 + time;
        jArr[4] = 14;
        int i6 = 0;
        while (i5 < 2050 && time > 0) {
            i6 = lYearDays(i5);
            time -= i6;
            jArr[4] = jArr[4] + 12;
            i5++;
        }
        if (time < 0) {
            time += i6;
            i5--;
            jArr[4] = jArr[4] - 12;
        }
        jArr[0] = i5;
        jArr[3] = i5 - 1864;
        int leapMonth = leapMonth(i5);
        jArr[6] = 0;
        int i7 = 1;
        while (i7 < 13 && time > 0) {
            if (leapMonth > 0 && i7 == leapMonth + 1 && jArr[6] == 0) {
                i7--;
                jArr[6] = 1;
                j3 = time;
                i6 = leapDays((int) jArr[0]);
            } else {
                j3 = time;
                i6 = monthDays((int) jArr[0], i7);
            }
            if (jArr[6] == 1 && i7 == leapMonth + 1) {
                jArr[6] = 0;
            }
            time = j3 - i6;
            if (jArr[6] == 0) {
                jArr[4] = jArr[4] + 1;
            }
            i7++;
        }
        long j4 = time;
        int i8 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i8 == 0 && leapMonth > 0 && i7 == leapMonth + 1) {
            if (jArr[6] == 1) {
                jArr[6] = 0;
            } else {
                jArr[6] = 1;
                i7--;
                jArr[4] = jArr[4] - 1;
            }
        }
        if (i8 < 0) {
            j2 = j4 + i6;
            i7--;
            jArr[4] = jArr[4] - 1;
        } else {
            j2 = j4;
        }
        jArr[1] = i7;
        jArr[2] = j2 + 1;
        return jArr;
    }

    public static final String cyclical(int i2) {
        return cyclicalm((i2 - 1900) + 36);
    }

    private static final String cyclicalm(int i2) {
        return Gan[i2 % 10] + Zhi[i2 % 12];
    }

    public static final String getChinaDate(int i2) {
        if (i2 == 10) {
            return "初十";
        }
        if (i2 == 20) {
            return "二十";
        }
        if (i2 == 30) {
            return "三十";
        }
        int i3 = i2 / 10;
        String str = i3 == 0 ? "初" : "";
        if (i3 == 1) {
            str = "十";
        }
        if (i3 == 2) {
            str = "廿";
        }
        if (i3 == 3) {
            str = "三";
        }
        switch (i2 % 10) {
            case 1:
                return str + "一";
            case 2:
                return str + "二";
            case 3:
                return str + "三";
            case 4:
                return str + "四";
            case 5:
                return str + "五";
            case 6:
                return str + "六";
            case 7:
                return str + "七";
            case 8:
                return str + "八";
            case 9:
                return str + "九";
            default:
                return str;
        }
    }

    public static String getConstellation(int i2, int i3) {
        int i4 = i2 - 1;
        return i3 < dayArr[i4] ? constellationArr[i4] : constellationArr[i2];
    }

    public static ArrayList<String> getLunarDays(int i2) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 1; i3 <= i2; i3++) {
            arrayList.add(getChinaDate(i3));
        }
        return arrayList;
    }

    public static String getLunarYearText(int i2) {
        StringBuilder sb = new StringBuilder();
        int i3 = i2 - 4;
        sb.append(Gan[i3 % 10]);
        sb.append(Zhi[i3 % 12]);
        sb.append("年");
        return sb.toString();
    }

    public static int getMonthByYear(int i2) {
        return leapMonth(i2) == 0 ? 12 : 13;
    }

    public static ArrayList<String> getMonths(int i2) {
        String[] strArr;
        ArrayList<String> arrayList = new ArrayList<>();
        int i3 = 1;
        while (true) {
            strArr = nStr1;
            if (i3 >= strArr.length) {
                break;
            }
            arrayList.add(strArr[i3] + "月");
            i3++;
        }
        if (leapMonth(i2) != 0) {
            int leapMonth = leapMonth(i2);
            arrayList.add(leapMonth, "闰" + strArr[leapMonth(i2)] + "月");
        }
        return arrayList;
    }

    public static ArrayList<String> getYears(int i2, int i3) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (i2 < i3) {
            arrayList.add(String.format("%s(%d)", getLunarYearText(i2), Integer.valueOf(i2)));
            i2++;
        }
        return arrayList;
    }

    private static final int lYearDays(int i2) {
        int i3 = 348;
        for (int i4 = 32768; i4 > 8; i4 >>= 1) {
            if ((lunarInfo[i2 - 1900] & i4) != 0) {
                i3++;
            }
        }
        return i3 + leapDays(i2);
    }

    public static final int leapDays(int i2) {
        if (leapMonth(i2) != 0) {
            return (lunarInfo[i2 + (-1900)] & SVG.D) != 0 ? 30 : 29;
        }
        return 0;
    }

    public static final int leapMonth(int i2) {
        return (int) (lunarInfo[i2 - 1900] & 15);
    }

    public static final int monthDays(int i2, int i3) {
        return (((long) (65536 >> i3)) & lunarInfo[i2 + (-1900)]) == 0 ? 29 : 30;
    }

    public static String oneDay(int i2, int i3, int i4) {
        long[] calElement = calElement(i2, i3, i4);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" 农历");
        stringBuffer.append(cyclical(i2));
        stringBuffer.append('(');
        stringBuffer.append(AnimalsYear(i2));
        stringBuffer.append(")年");
        stringBuffer.append(nStr1[(int) calElement[1]]);
        stringBuffer.append("月");
        stringBuffer.append(getChinaDate((int) calElement[2]));
        return stringBuffer.toString();
    }

    public static String today() {
        Calendar calendar = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
        int i2 = calendar.get(1);
        long[] calElement = calElement(i2, calendar.get(2) + 1, calendar.get(5));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sdf.format(calendar.getTime()));
        stringBuffer.append(" 农历");
        stringBuffer.append(cyclical(i2));
        stringBuffer.append('(');
        stringBuffer.append(AnimalsYear(i2));
        stringBuffer.append(")年");
        stringBuffer.append(nStr1[(int) calElement[1]]);
        stringBuffer.append("月");
        stringBuffer.append(getChinaDate((int) calElement[2]));
        return stringBuffer.toString();
    }
}
