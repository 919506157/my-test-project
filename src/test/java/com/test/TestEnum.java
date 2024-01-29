package com.test;

/**
 * TestEnum
 *
 * @author 张浩洁
 * @date 2023/8/17 19:11
 */
public enum TestEnum implements EnumInterface<TestEnum> {

    A, B;

    @Override
    public Class<TestEnum> get() {
        return TestEnum.class;
    }

}
