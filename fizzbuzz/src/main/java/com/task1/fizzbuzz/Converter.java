package com.task1.fizzbuzz;

@FunctionalInterface
public interface Converter<T> {
    String convert(T input);

}
