package com.m7.imkfsdk.utils;

import android.content.Context;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.m7.imkfsdk.R;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.xiaomi.mipush.sdk.Constants;
import e.t.u.b0;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class DateUtil {
    private static final long ONEDAY = 86400000;
    public static final int SHOW_TYPE_ALL = 2;
    public static final int SHOW_TYPE_CALL_DETAIL = 4;
    public static final int SHOW_TYPE_CALL_LOG = 3;
    public static final int SHOW_TYPE_COMPLEX = 1;
    public static final int SHOW_TYPE_SIMPLE = 0;
    public static final TimeZone tz = TimeZone.getTimeZone("GMT+8:00");
    public static final SimpleDateFormat yearFormat = new SimpleDateFormat(b0.a.b);

    public static String formatDate(int i2, int i3, int i4) {
        return yearFormat.format(new Date(i2 - 1900, i3, i4));
    }

    public static long getActiveTimelong(String str) {
        try {
            return yearFormat.parse(str).getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            return System.currentTimeMillis();
        }
    }

    public static long getCurrentDayTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = yearFormat;
        try {
            return simpleDateFormat.parse(simpleDateFormat.format(date)).getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis() / 1000;
    }

    public static long getDateMills(int i2, int i3, int i4) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i2, i3, i4);
        calendar.setTimeZone(TimeZone.getDefault());
        return calendar.getTimeInMillis();
    }

    public static String getDateString(long j2, int i2, Context context) {
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        Object valueOf4;
        Object valueOf5;
        Object valueOf6;
        Object valueOf7;
        Object valueOf8;
        Object valueOf9;
        Object valueOf10;
        Object valueOf11;
        Object valueOf12;
        Object valueOf13;
        Object valueOf14;
        Object valueOf15;
        Object valueOf16;
        Object valueOf17;
        Object valueOf18;
        Object valueOf19;
        Object valueOf20;
        Object valueOf21;
        Object valueOf22;
        Object valueOf23;
        Object valueOf24;
        Object valueOf25;
        Object valueOf26;
        Object valueOf27;
        Object valueOf28;
        Object valueOf29;
        Object valueOf30;
        Object valueOf31;
        Object valueOf32;
        Object valueOf33;
        Object valueOf34;
        Object valueOf35;
        Object valueOf36;
        Object valueOf37;
        Object valueOf38;
        Object valueOf39;
        Object valueOf40;
        Object valueOf41;
        Object valueOf42;
        Object valueOf43;
        Object valueOf44;
        Calendar.getInstance();
        TimeZone timeZone = tz;
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis(j2);
        long currentTimeMillis = System.currentTimeMillis();
        Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTimeInMillis(currentTimeMillis);
        int i3 = calendar2.get(1);
        int i4 = calendar.get(1);
        int i5 = calendar.get(2) + 1;
        int i6 = calendar.get(5);
        int i7 = calendar.get(11);
        int i8 = calendar.get(12);
        int i9 = calendar.get(13);
        long j3 = currentTimeMillis - j2;
        long currentDayTime = currentTimeMillis - getCurrentDayTime();
        if (j3 < currentDayTime && j3 > 0) {
            if (i2 == 0) {
                StringBuilder sb = new StringBuilder();
                if (i7 < 10) {
                    valueOf43 = "0" + i7;
                } else {
                    valueOf43 = Integer.valueOf(i7);
                }
                sb.append(valueOf43);
                sb.append(Constants.COLON_SEPARATOR);
                if (i8 < 10) {
                    valueOf44 = "0" + i8;
                } else {
                    valueOf44 = Integer.valueOf(i8);
                }
                sb.append(valueOf44);
                return sb.toString();
            } else if (i2 == 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(context.getString(R.string.ykfsdk_ykf_msg_today));
                sb2.append("  ");
                if (i7 < 10) {
                    valueOf41 = "0" + i7;
                } else {
                    valueOf41 = Integer.valueOf(i7);
                }
                sb2.append(valueOf41);
                sb2.append(Constants.COLON_SEPARATOR);
                if (i8 < 10) {
                    valueOf42 = "0" + i8;
                } else {
                    valueOf42 = Integer.valueOf(i8);
                }
                sb2.append(valueOf42);
                return sb2.toString();
            } else if (i2 == 3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(context.getString(R.string.ykfsdk_ykf_msg_today));
                sb3.append("  ");
                if (i7 < 10) {
                    valueOf39 = "0" + i7;
                } else {
                    valueOf39 = Integer.valueOf(i7);
                }
                sb3.append(valueOf39);
                sb3.append(Constants.COLON_SEPARATOR);
                if (i8 < 10) {
                    valueOf40 = "0" + i8;
                } else {
                    valueOf40 = Integer.valueOf(i8);
                }
                sb3.append(valueOf40);
                return sb3.toString();
            } else if (i2 == 4) {
                return context.getString(R.string.ykfsdk_ykf_msg_today) + "  ";
            } else {
                StringBuilder sb4 = new StringBuilder();
                if (i7 < 10) {
                    valueOf36 = "0" + i7;
                } else {
                    valueOf36 = Integer.valueOf(i7);
                }
                sb4.append(valueOf36);
                sb4.append(Constants.COLON_SEPARATOR);
                if (i8 < 10) {
                    valueOf37 = "0" + i8;
                } else {
                    valueOf37 = Integer.valueOf(i8);
                }
                sb4.append(valueOf37);
                sb4.append(Constants.COLON_SEPARATOR);
                if (i9 < 10) {
                    valueOf38 = "0" + i9;
                } else {
                    valueOf38 = Integer.valueOf(i9);
                }
                sb4.append(valueOf38);
                return sb4.toString();
            }
        } else if (j3 < currentDayTime + 86400000 && j3 > 0) {
            if (i2 == 0 || i2 == 4) {
                return context.getString(R.string.ykfsdk_ykf_msg_yesterday) + "  ";
            } else if (i2 == 1) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(context.getString(R.string.ykfsdk_ykf_msg_yesterday));
                sb5.append("  ");
                if (i7 < 10) {
                    valueOf34 = "0" + i7;
                } else {
                    valueOf34 = Integer.valueOf(i7);
                }
                sb5.append(valueOf34);
                sb5.append(Constants.COLON_SEPARATOR);
                if (i8 < 10) {
                    valueOf35 = "0" + i8;
                } else {
                    valueOf35 = Integer.valueOf(i8);
                }
                sb5.append(valueOf35);
                return sb5.toString();
            } else if (i2 == 3) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(context.getString(R.string.ykfsdk_ykf_msg_yesterday));
                sb6.append("  ");
                if (i7 < 10) {
                    valueOf32 = "0" + i7;
                } else {
                    valueOf32 = Integer.valueOf(i7);
                }
                sb6.append(valueOf32);
                sb6.append(Constants.COLON_SEPARATOR);
                if (i8 < 10) {
                    valueOf33 = "0" + i8;
                } else {
                    valueOf33 = Integer.valueOf(i8);
                }
                sb6.append(valueOf33);
                return sb6.toString();
            } else {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(context.getString(R.string.ykfsdk_ykf_msg_yesterday));
                sb7.append("  ");
                if (i7 < 10) {
                    valueOf29 = "0" + i7;
                } else {
                    valueOf29 = Integer.valueOf(i7);
                }
                sb7.append(valueOf29);
                sb7.append(Constants.COLON_SEPARATOR);
                if (i8 < 10) {
                    valueOf30 = "0" + i8;
                } else {
                    valueOf30 = Integer.valueOf(i8);
                }
                sb7.append(valueOf30);
                sb7.append(Constants.COLON_SEPARATOR);
                if (i9 < 10) {
                    valueOf31 = "0" + i9;
                } else {
                    valueOf31 = Integer.valueOf(i9);
                }
                sb7.append(valueOf31);
                return sb7.toString();
            }
        } else if (i4 != i3) {
            if (i2 == 0) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(i4);
                sb8.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                if (i5 < 10) {
                    valueOf12 = "0" + i5;
                } else {
                    valueOf12 = Integer.valueOf(i5);
                }
                sb8.append(valueOf12);
                sb8.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                if (i6 < 10) {
                    valueOf13 = "0" + i6;
                } else {
                    valueOf13 = Integer.valueOf(i6);
                }
                sb8.append(valueOf13);
                return sb8.toString();
            } else if (i2 == 1) {
                StringBuilder sb9 = new StringBuilder();
                sb9.append(i4);
                sb9.append("年");
                if (i5 < 10) {
                    valueOf10 = "0" + i5;
                } else {
                    valueOf10 = Integer.valueOf(i5);
                }
                sb9.append(valueOf10);
                sb9.append("月");
                if (i6 < 10) {
                    valueOf11 = "0" + i6;
                } else {
                    valueOf11 = Integer.valueOf(i6);
                }
                sb9.append(valueOf11);
                sb9.append("日");
                return sb9.toString();
            } else if (i2 == 3 || i2 == 1) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append(i4);
                sb10.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                if (i5 < 10) {
                    valueOf = "0" + i5;
                } else {
                    valueOf = Integer.valueOf(i5);
                }
                sb10.append(valueOf);
                sb10.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                if (i6 < 10) {
                    valueOf2 = "0" + i6;
                } else {
                    valueOf2 = Integer.valueOf(i6);
                }
                sb10.append(valueOf2);
                sb10.append("  ");
                return sb10.toString();
            } else if (i2 == 4) {
                StringBuilder sb11 = new StringBuilder();
                sb11.append(i4);
                sb11.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                if (i5 < 10) {
                    valueOf8 = "0" + i5;
                } else {
                    valueOf8 = Integer.valueOf(i5);
                }
                sb11.append(valueOf8);
                sb11.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                if (i6 < 10) {
                    valueOf9 = "0" + i6;
                } else {
                    valueOf9 = Integer.valueOf(i6);
                }
                sb11.append(valueOf9);
                return sb11.toString();
            } else {
                StringBuilder sb12 = new StringBuilder();
                sb12.append(i4);
                sb12.append("年");
                if (i5 < 10) {
                    valueOf3 = "0" + i5;
                } else {
                    valueOf3 = Integer.valueOf(i5);
                }
                sb12.append(valueOf3);
                sb12.append("月");
                if (i6 < 10) {
                    valueOf4 = "0" + i6;
                } else {
                    valueOf4 = Integer.valueOf(i6);
                }
                sb12.append(valueOf4);
                sb12.append("日 ");
                if (i7 < 10) {
                    valueOf5 = "0" + i7;
                } else {
                    valueOf5 = Integer.valueOf(i7);
                }
                sb12.append(valueOf5);
                sb12.append(Constants.COLON_SEPARATOR);
                if (i8 < 10) {
                    valueOf6 = "0" + i8;
                } else {
                    valueOf6 = Integer.valueOf(i8);
                }
                sb12.append(valueOf6);
                sb12.append(Constants.COLON_SEPARATOR);
                if (i9 < 10) {
                    valueOf7 = "0" + i9;
                } else {
                    valueOf7 = Integer.valueOf(i9);
                }
                sb12.append(valueOf7);
                return sb12.toString();
            }
        } else if (i2 == 0) {
            StringBuilder sb13 = new StringBuilder();
            if (i5 < 10) {
                valueOf27 = "0" + i5;
            } else {
                valueOf27 = Integer.valueOf(i5);
            }
            sb13.append(valueOf27);
            sb13.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            if (i6 < 10) {
                valueOf28 = "0" + i6;
            } else {
                valueOf28 = Integer.valueOf(i6);
            }
            sb13.append(valueOf28);
            return sb13.toString();
        } else if (i2 == 1) {
            StringBuilder sb14 = new StringBuilder();
            if (i5 < 10) {
                valueOf25 = "0" + i5;
            } else {
                valueOf25 = Integer.valueOf(i5);
            }
            sb14.append(valueOf25);
            sb14.append("月");
            if (i6 < 10) {
                valueOf26 = "0" + i6;
            } else {
                valueOf26 = Integer.valueOf(i6);
            }
            sb14.append(valueOf26);
            sb14.append("日");
            return sb14.toString();
        } else if (i2 == 3 || i2 == 1) {
            StringBuilder sb15 = new StringBuilder();
            if (i5 < 10) {
                valueOf14 = "0" + i5;
            } else {
                valueOf14 = Integer.valueOf(i5);
            }
            sb15.append(valueOf14);
            sb15.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            if (i6 < 10) {
                valueOf15 = "0" + i6;
            } else {
                valueOf15 = Integer.valueOf(i6);
            }
            sb15.append(valueOf15);
            sb15.append(ExpandableTextView.N);
            if (i7 < 10) {
                valueOf16 = "0" + i7;
            } else {
                valueOf16 = Integer.valueOf(i7);
            }
            sb15.append(valueOf16);
            sb15.append(Constants.COLON_SEPARATOR);
            if (i8 < 10) {
                valueOf17 = "0" + i8;
            } else {
                valueOf17 = Integer.valueOf(i8);
            }
            sb15.append(valueOf17);
            return sb15.toString();
        } else if (i2 == 4) {
            StringBuilder sb16 = new StringBuilder();
            sb16.append(i4);
            sb16.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            if (i5 < 10) {
                valueOf23 = "0" + i5;
            } else {
                valueOf23 = Integer.valueOf(i5);
            }
            sb16.append(valueOf23);
            sb16.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            if (i6 < 10) {
                valueOf24 = "0" + i6;
            } else {
                valueOf24 = Integer.valueOf(i6);
            }
            sb16.append(valueOf24);
            return sb16.toString();
        } else {
            StringBuilder sb17 = new StringBuilder();
            if (i5 < 10) {
                valueOf18 = "0" + i5;
            } else {
                valueOf18 = Integer.valueOf(i5);
            }
            sb17.append(valueOf18);
            sb17.append("月");
            if (i6 < 10) {
                valueOf19 = "0" + i6;
            } else {
                valueOf19 = Integer.valueOf(i6);
            }
            sb17.append(valueOf19);
            sb17.append("日 ");
            if (i7 < 10) {
                valueOf20 = "0" + i7;
            } else {
                valueOf20 = Integer.valueOf(i7);
            }
            sb17.append(valueOf20);
            sb17.append(Constants.COLON_SEPARATOR);
            if (i8 < 10) {
                valueOf21 = "0" + i8;
            } else {
                valueOf21 = Integer.valueOf(i8);
            }
            sb17.append(valueOf21);
            sb17.append(Constants.COLON_SEPARATOR);
            if (i9 < 10) {
                valueOf22 = "0" + i9;
            } else {
                valueOf22 = Integer.valueOf(i9);
            }
            sb17.append(valueOf22);
            return sb17.toString();
        }
    }
}
