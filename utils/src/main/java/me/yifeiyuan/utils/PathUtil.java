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

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.NonNull;

/**
 * Created by 程序亦非猿 on 15/12/26.
 */
public class PathUtil {

    /**
     *  测量path的长度
     *  @param path 需要测量的path
     *  @return path的长度
     */
    public static float measurePath(@NonNull Path path) {
        PathMeasure measure = new PathMeasure(path, false);
        return measure.getLength();
    }

}
