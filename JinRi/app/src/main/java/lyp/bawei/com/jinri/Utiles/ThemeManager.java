package lyp.bawei.com.jinri.Utiles;

import android.content.Context;
import android.content.res.Resources;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */

public class ThemeManager {
    private static ThemeMode mThemeMode = ThemeMode.DAY;
    // 主题模式监听器
    private static List<OnThemeChangeListener> mThemeChangeListenerList = new LinkedList<>();
    // 夜间资源的缓存，key : 资源类型, 值<key:资源名称, value:int值>
    private static HashMap<String, HashMap<String, Integer>> sCachedNightResrouces = new HashMap<>();
    // 夜间模式资源的后缀，比如日件模式资源名为：R.color.activity_bg, 那么夜间模式就为 ：R.color.activity_bg_night
    private static final String RESOURCE_SUFFIX = "_night";
    /**  * 主题模式，分为日间模式和夜间模式  */
    public enum ThemeMode {
        DAY, NIGHT
    }
    public static void setThemeMode(ThemeMode themeMode) {
        if (mThemeMode != themeMode) {   mThemeMode = themeMode;
            if (mThemeChangeListenerList.size() > 0) {
                for (OnThemeChangeListener listener : mThemeChangeListenerList) {
                    listener.onThemeChanged();
                }
            }
        }
    }
    public static int getCurrentThemeRes(Context context, int dayResId) {
        if (getThemeMode() == ThemeMode.DAY) {   return dayResId;  }
        // 资源名
        String entryName = context.getResources().getResourceEntryName(dayResId);
        // 资源类型
        String typeName = context.getResources().getResourceTypeName(dayResId);
        HashMap<String, Integer> cachedRes = sCachedNightResrouces.get(typeName);
        // 先从缓存中去取，如果有直接返回该id
        if (cachedRes == null) {
            cachedRes = new HashMap<>();
        }
        Integer resId = cachedRes.get(entryName + RESOURCE_SUFFIX);
        if (resId != null && resId != 0) {   return resId;  }
        else {   //如果缓存中没有再根据资源id去动态获取
            try {    // 通过资源名，资源类型，包名得到资源int值
                int nightResId = context.getResources().getIdentifier(entryName + RESOURCE_SUFFIX, typeName, context.getPackageName());
                // 放入缓存中
                cachedRes.put(entryName + RESOURCE_SUFFIX, nightResId);
                sCachedNightResrouces.put(typeName, cachedRes);
                return nightResId;   }
            catch (Resources.NotFoundException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    public static void registerThemeChangeListener(OnThemeChangeListener listener) {
        if (!mThemeChangeListenerList.contains(listener)) {
            mThemeChangeListenerList.add(listener);
        }
    }
    public static void unregisterThemeChangeListener(OnThemeChangeListener listener) {
        if (mThemeChangeListenerList.contains(listener)) {
            mThemeChangeListenerList.remove(listener);
        }
    }
    public static ThemeMode getThemeMode() {
        return mThemeMode;
    }
    public interface OnThemeChangeListener {
        /**   * 主题切换时回调   */
        void onThemeChanged();
    }
}
