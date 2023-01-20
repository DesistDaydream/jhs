package com.moor.imkf.lib.basedb;

import com.j256.ormlite.dao.Dao;
import com.moor.imkf.lib.analytics.bean.MoorAnalyticsBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MoorAnalyticsDao {
    private Dao<MoorAnalyticsBean, Integer> analyticsDao;

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final MoorAnalyticsDao sInstance = new MoorAnalyticsDao();

        private SingletonHolder() {
        }
    }

    public static MoorAnalyticsDao getInstance() {
        return SingletonHolder.sInstance;
    }

    public void createOrUpdate(MoorAnalyticsBean moorAnalyticsBean) {
        try {
            Dao<MoorAnalyticsBean, Integer> dao = this.analyticsDao;
            if (dao != null) {
                dao.createOrUpdate(moorAnalyticsBean);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void deleteToDao(MoorAnalyticsBean moorAnalyticsBean) {
        try {
            Dao<MoorAnalyticsBean, Integer> dao = this.analyticsDao;
            if (dao != null) {
                dao.delete((Dao<MoorAnalyticsBean, Integer>) moorAnalyticsBean);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public List<MoorAnalyticsBean> queryForLimit(long j2) {
        ArrayList arrayList = new ArrayList();
        try {
            Dao<MoorAnalyticsBean, Integer> dao = this.analyticsDao;
            return dao != null ? dao.queryBuilder().limit(Long.valueOf(j2)).query() : arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    private MoorAnalyticsDao() {
        try {
            this.analyticsDao = MoorBaseLibDbHelper.getInstance().getAnalyticsDaoDao();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void deleteToDao() {
        try {
            Dao<MoorAnalyticsBean, Integer> dao = this.analyticsDao;
            if (dao != null) {
                dao.delete(dao.queryForAll());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
