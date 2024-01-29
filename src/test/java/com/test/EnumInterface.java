package com.test;

/**
 * EnumInterface
 *
 * @author 张浩洁
 * @date 2023/8/17 19:07
 */
public interface EnumInterface<E extends Enum<E>> {
    public Class<E> get();
}
