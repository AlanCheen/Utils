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

import android.graphics.DashPathEffect;

/**
 * Created by 程序亦非猿 on 15/12/27.
 */
public class PathEffectUtil {

    /**
     * 生成一个可用作Path动画的DashPathEffect
     * @param pathLength path的长度
     * @param phase 阶段
     * @return
     */
    public DashPathEffect create(float pathLength, int phase) {
        return new DashPathEffect(new float[]{pathLength*(1-phase),pathLength},0);
    }
}
