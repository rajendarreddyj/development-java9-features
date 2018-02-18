package com.rajendarreddyj.jigsaw.calculator.api.subtract.impl;

import com.rajendarreddyj.jigsaw.calculator.api.Algorithm;

/**
 *
 * @author rajendarreddy.jagapathi
 */
public class Subtract implements Algorithm {

    @Override
    public Integer calculate(Integer input, Integer input2) {
        return input - input2;
    }
}
