/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.tipapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.tipapp.R


/**
 * A data class to represent the information presented in the dog card
 */
data class Tip(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val day: Int,
    @StringRes val explanation: Int
)

val tips = listOf(
    Tip(R.drawable.day1, R.string.day1, 1, R.string.info1),
    Tip(R.drawable.day2, R.string.day2, 2, R.string.info2),
    Tip(R.drawable.day3, R.string.day3, 3, R.string.info3),
    Tip(R.drawable.day4, R.string.day4, 4, R.string.info4),
    Tip(R.drawable.day5, R.string.day5, 5, R.string.info5),
    Tip(R.drawable.day6, R.string.day6, 6, R.string.info6),
    Tip(R.drawable.day7, R.string.day7, 7, R.string.info7),
    Tip(R.drawable.day8, R.string.day8, 8, R.string.info8),

)