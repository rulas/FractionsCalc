package com.onelogin.challenges;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FracCalculatorTests {

    @Test
    void challengeTests() {
        assertThat(FracCalculator.calc("1/2 * 3_3/4")).isEqualTo("1_7/8");
        assertThat(FracCalculator.calc("2_3/8 + 9/8")).isEqualTo("3_1/2");
    }

    @Test
    public void testWholeOperation() {

        assertThat(FracCalculator.calc("10   +  11")).isEqualTo("21");

        assertThat(FracCalculator.calc("10 -  11")).isEqualTo("-1");

        assertThat(FracCalculator.calc("10 *  11")).isEqualTo("110");

        assertThat(FracCalculator.calc("110 / 10")).isEqualTo("11");
    }

    @Test
    void testFractionsOperations() {
        assertThat(FracCalculator.calc("3/4   +  1/4")).isEqualTo("1");

        assertThat(FracCalculator.calc("6/8   +  0")).isEqualTo("3/4");

        assertThat(FracCalculator.calc("5/8 -  1/8")).isEqualTo("1/2");

        assertThat(FracCalculator.calc("3/5 *  5/3")).isEqualTo("1");

        assertThat(FracCalculator.calc("3/5 *  5")).isEqualTo("3");

        assertThat(FracCalculator.calc("3/7 / 4/5")).isEqualTo("15/28");
    }


}
