package com.onelogin.challenges;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.*;

class FractionTest {
    @Test
    void testWhole() {
        Fraction fraction = new Fraction("1");
        assertThat(fraction.getWhole()).isEqualTo(1L);
        assertThat(fraction.getNumerator()).isEqualTo(0);
        assertThat(fraction.getDenominator()).isEqualTo(0);
        assertThat(fraction).hasToString("1");
    }

    @Test
    void testWholeNegative() {
        Fraction fraction = new Fraction("-1");
        assertThat(fraction.getWhole()).isEqualTo(-1L);
        assertThat(fraction.getNumerator()).isEqualTo(0);
        assertThat(fraction.getDenominator()).isEqualTo(0);
        assertThat(fraction).hasToString("-1");
    }


    @Test
    void testFraction() {
        Fraction fraction = new Fraction("1/41");
        assertThat(fraction.getWhole()).isEqualTo(0);
        assertThat(fraction.getNumerator()).isEqualTo(1);
        assertThat(fraction.getDenominator()).isEqualTo(41);
        assertThat(fraction).hasToString("1/41");
    }

    @Test
    void testFractionNegative() {
        Fraction fraction = new Fraction("-1/41");
        assertThat(fraction.getWhole()).isEqualTo(0);
        assertThat(fraction.getNumerator()).isEqualTo(-1);
        assertThat(fraction.getDenominator()).isEqualTo(41);
        assertThat(fraction).hasToString("-1/41");
    }

    @Test
    void testDivisionByZero() {
        assertThatThrownBy(() -> new Fraction("16/0")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testMixed() {
        Fraction fraction = new Fraction("20_12/41");
        assertThat(fraction.getWhole()).isEqualTo(20);
        assertThat(fraction.getNumerator()).isEqualTo(12);
        assertThat(fraction.getDenominator()).isEqualTo(41);
        assertThat(fraction).hasToString("20_12/41");
    }

    @Test
    void testMixedNegative() {
        Fraction fraction = new Fraction("-20_12/41");
        assertThat(fraction.getWhole()).isEqualTo(-20);
        assertThat(fraction.getNumerator()).isEqualTo(12);
        assertThat(fraction.getDenominator()).isEqualTo(41);
        assertThat(fraction).hasToString("-20_12/41");
    }

    @Test
    void testToImproperFraction() {
        Fraction fraction = new Fraction("5");
        assertThat(fraction.toImproper()).hasToString("5/1");

        Fraction fraction1 = new Fraction("-5");
        assertThat(fraction1.toImproper()).hasToString("-5/1");

        Fraction fraction2 = new Fraction("5_1/7");
        assertThat(fraction2.toImproper()).hasToString("36/7");

        Fraction fraction3 = new Fraction("-5_1/7");
        assertThat(fraction3.toImproper()).hasToString("-36/7");
    }

    @Test
    void testToString() {
        assertThat(new Fraction()).hasToString("0");
        assertThat(new Fraction("0_1/125")).hasToString("1/125");
        assertThat(new Fraction("1")).hasToString("1");
        assertThat(new Fraction("1/4")).hasToString("1/4");
        assertThat(new Fraction("125_122/425")).hasToString("125_122/425");


        assertThat(new Fraction("-1")).hasToString("-1");
        assertThat(new Fraction("-1/4")).hasToString("-1/4");
        assertThat(new Fraction("-125_122/425")).hasToString("-125_122/425");

    }


    @Test
    void testAdd() {
        // add whole
        Fraction frac = new Fraction("111");
        assertThat(frac.add(new Fraction("22"))).hasToString("133");

        // whole negatives
        frac = new Fraction("-22");
        assertThat(frac.add(new Fraction("22"))).hasToString("0");

        // fraction
        frac = new Fraction("1/4");
        assertThat(frac.add(new Fraction("1/4"))).hasToString("1/2");

        // Mixed
        Fraction mixed = new Fraction("3_1/16");
        assertThat(mixed.add(new Fraction("4_7/8"))).hasToString("7_15/16");
    }

    @Test
    void testSubstract() {

        // subtract whole
        Fraction frac = new Fraction("22");
        assertThat(frac.subtract(new Fraction("100"))).hasToString("-78");

        // whole negatives
        frac = new Fraction("-22");
        assertThat(frac.subtract(new Fraction("22"))).hasToString("-44");

        // fraction
        frac = new Fraction("1/4");
        assertThat(frac.subtract(new Fraction("1/4"))).hasToString("0");

        // Mixed
        Fraction mixed = new Fraction("5_7/8");
        assertThat(mixed.subtract(new Fraction("3_2/8"))).hasToString("2_5/8");
    }

    @Test
    void testMultiply() {
        Fraction frac = new Fraction("7");
        assertThat(frac.multiply(new Fraction("3"))).hasToString("21");

        Fraction fraction = new Fraction("4_1/5");
        assertThat(fraction.multiply(new Fraction("3_1/8"))).hasToString("13_1/8");

        Fraction fraction2 = new Fraction("4_1/5");
        assertThat(fraction2.multiply(new Fraction("-3_1/8"))).hasToString("-13_1/8");

        Fraction fraction3 = new Fraction("-4_1/5");
        assertThat(fraction3.multiply(new Fraction("-3_1/8"))).hasToString("13_1/8");
    }

    @Test
    void testDivide() {
        Fraction frac = new Fraction("8");
        assertThat(frac.divide(new Fraction("3"))).hasToString("2_2/3");

        Fraction fraction = new Fraction("4_1/5");
        assertThat(fraction.divide(new Fraction("3_1/8"))).hasToString("1_43/125");

        Fraction fraction2 = new Fraction("4_1/5");
        assertThat(fraction2.divide(new Fraction("-3_1/8"))).hasToString("-1_43/125");

        Fraction fraction3 = new Fraction("-4_1/5");
        assertThat(fraction3.divide(new Fraction("-3_1/8"))).hasToString("1_43/125");
    }
}