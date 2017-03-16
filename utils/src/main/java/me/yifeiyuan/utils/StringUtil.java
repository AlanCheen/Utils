/*
 * Copyright (C) 2017, 程序亦非猿
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

/**
 * Created by 程序亦非猿 on 17/2/22.
 *
 * 安全地从string转成数字类型，避免不合法 string,eg:""
 *
 */
public class StringUtil {


    public static int getInt(String str) {
        return getInt(str, 0);
    }

    public static int getInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return defaultValue;
    }


}
