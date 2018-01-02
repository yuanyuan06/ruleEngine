package com.util

import com.engine.entity.task.HumanTask

/**
 * @author yuan.yuan1
 * @date 2017/12/12 14:12
 *
 */

test("hello", "hha");
def test(Object... ss){
    HumanTask humanTask = new HumanTask();
    for (s in ss){
        println s;
    }
}
