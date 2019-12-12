/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naivebayes;

/**
 *
 * @author ASUS
 */
public class Bayes {
    private double chanceEvent;
    private double negationEvent;

    public Bayes(double chanceEvent) {
        this.chanceEvent = chanceEvent;
        this.negationEvent = 1 - this.chanceEvent;
    }

    public Bayes() {
        this.chanceEvent = 0;
        this.negationEvent = 1 - this.chanceEvent;
    }

    public double getChanceEvent() {
        return chanceEvent;
    }

    public void setChanceEvent(double chanceEvent) {
        this.chanceEvent = chanceEvent;
        this.negationEvent = 1 - this.chanceEvent;
    }

    public double getNegationEvent() {
        return negationEvent;
    }
}
