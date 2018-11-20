/*
 * Copyright (C) 2018 souldj673
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tsguild.milestone3basics.testing.happyllamas;

/**
 *
 * @author souldj673
 */
public class ExampleWork {

    // When llamas get together they like to bounce on trampolines.
    // However, llamas are very particular about the proper number of trampolines, 
    // and are usually only happy if there are between 24 to 42 (inclusive!).
    // This only changes if the trampolines are made of ultra-bouncey NASA fabric.
    // In those cases, the llamas figure the more trampolines the better!
    // 
    // Return true if the llamas will be happy with their trampolines,
    // or false otherwise.
    //
    //
    // areTheLlamasHappy(false, 20) → false
    // areTheLlamasHappy(false, 30) → true
    // areTheLlamasHappy(true, 100) → true
    public static boolean areTheLlamasHappy(boolean ultraBouncy, int trampolines) {
        if (!ultraBouncy) {
            if (trampolines >= 24 && trampolines <= 42) {
                return true;
            } else {
                return false;
            }
        } else {
            if (trampolines >= 24) {
                return true;
            } else {
                return false;
            }
        }
    }
}
