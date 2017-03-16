/*
 * Copyright (C) 2015, 程序亦非猿
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.yifeiyuan.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by 程序亦非猿 on 15/12/26.
 *
 * 包含如下方法
 * 1.getDeviceId            获取IMEI
 * 2.isNetworkConnected     网络是否连接
 * 3.isWifiConnected        wifi是否可用
 * 4.getCurNetType          当前网络
 * 5.getCountOfCPU          获取设备CPU数量
 */
public final class DeviceUtil {

    private DeviceUtil() {
        //no instance
        throw new AssertionError("No instances.");
    }

    /**
     * 默认单核
     */
    public static final int DEFAULT_CPU_COUNT = 1;


    /**
     * 获取设备唯一标识
     * 例子:IMEI for GSM and the MEID or ESN for CDMA phones
     * 注意,需要添加权限: {@link android.Manifest.permission#READ_PHONE_STATE}
     *
     * @param context 上下文
     * @return eg.IMEI for GSM
     */
    public static String getDeviceId(@NonNull Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }


    public static String getMacAddress(@NonNull Context context) {
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return wifi.getConnectionInfo().getMacAddress();
    }

    /**
     * 网络是否连接
     *
     * 注意需要权限: {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
     *
     * @param context 上下文
     * @return true 如果网络连接着
     */
    public static boolean isNetworkConnected(@NonNull Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return null != info && info.isAvailable();
    }

    /**
     * wifi是否连接可用
     *
     * 注意需要权限: {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
     *
     * @param context
     * @return true 如果wifi可用
     */
    public static boolean isWifiConnected(@NonNull Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return info != null && info.isConnected();
    }

    /**
     * 得到当前的手机网络类型
     *
     * @param context
     * @return 没网返回"" , 有网返回 2g / 3g /4g/wifi
     */
    public static String getCurrNetType(@NonNull Context context) {
        String type = "";
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            type = "";
        } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
            type = "wifi";
        } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
            int subType = info.getSubtype();
            if (subType == TelephonyManager.NETWORK_TYPE_CDMA || subType == TelephonyManager.NETWORK_TYPE_GPRS
                    || subType == TelephonyManager.NETWORK_TYPE_EDGE) {
                type = "2g";
            } else if (subType == TelephonyManager.NETWORK_TYPE_UMTS || subType == TelephonyManager.NETWORK_TYPE_HSDPA
                    || subType == TelephonyManager.NETWORK_TYPE_EVDO_A || subType == TelephonyManager.NETWORK_TYPE_EVDO_0
                    || subType == TelephonyManager.NETWORK_TYPE_EVDO_B) {
                type = "3g";
            } else if (subType == TelephonyManager.NETWORK_TYPE_LTE) {// LTE是3g到4g的过渡，是3.9G的全球标准
                type = "4g";
            }
        }
        return type;
    }




    /**
     * 来自 小邓子
     * Linux中的设备都是以文件的形式存在，CPU也不例外，因此CPU的文件个数就等价与核数。
     * Android的CPU 设备文件位于/sys/devices/system/cpu/目录，文件名的的格式为cpu\d+。
     *
     * 引用：http://www.jianshu.com/p/f7add443cd32#，感谢 liangfeizc :) (梁飞)
     * https://github.com/facebook/device-year-class
     *
     * @return CPU的个数 默认为1
     */
    public static int getCountOfCPU() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
            //不支持
            return DEFAULT_CPU_COUNT;
        }
        int count;
        try {
            count = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (SecurityException | NullPointerException e) {
            count = DEFAULT_CPU_COUNT;
        }
        return count;
    }

    private static final FileFilter CPU_FILTER = new FileFilter() {
        @Override public boolean accept(File pathname) {
            String path = pathname.getName();
            if (path.startsWith("cpu")) {
                for (int i = 3; i < path.length(); i++) {
                    if (path.charAt(i) < '0' || path.charAt(i) > '9') {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    };
}
