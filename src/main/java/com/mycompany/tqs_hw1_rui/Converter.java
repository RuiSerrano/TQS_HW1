/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tqs_hw1_rui;

/**
 *
 * @author Rui Serrano
 */
//rate service no const
// metodod convert valor e moeda destino caso n dê source de usd
public class Converter {

    private RateService rs;
    private final int minValue = 0;

    public Converter() {
        this.rs = new RateService();
    }

    public double getRate(String from, String to) {
        double tax;
        double valueToDolar;
        if (from.equals("USD")) {
            return rs.getRate(to);
        } else {
            tax = 1 / rs.getRate(from);
            //valueToDolar = tax * value;
            //return valueToDolar * rs.getRate(to);
            return tax*rs.getRate(to);
        }
    }

    public double convert(double value, double rate) throws Exception {
        if (value < minValue) {
            throw new Exception("invalid value argument, needs to be >= 0");
        }
        return value * rate;

    }
}
