package test.bgl.com.multiprocessdatashare;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @desc:
 *
 * @author: baoguolin
 * @date: 2018/4/2
 */

public final class DataManager {
    public static DataManager sInstance;
    private SharedPreferences mSharedPreferences;

    public static DataManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (DataManager.class) {
                if (sInstance == null) {
                    sInstance = new DataManager(context);
                }
            }
        }
        return sInstance;
    }

    private DataManager(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public boolean isLockerEnable() {
        if (isMainProcess()) {
            return mSharedPreferences.getBoolean("KEY_LOCKER_ENABLE", false);
        } else {
            return InterProcessDataAccessUtil.getBoolean("KEY_LOCKER_ENABLE", false);
        }
    }

    private boolean isMainProcess() {
        return true;
    }
}
