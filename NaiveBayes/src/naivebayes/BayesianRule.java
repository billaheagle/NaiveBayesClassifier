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
public class BayesianRule {
    public double OneToOne (Bayes eventA, Bayes eventB, Bayes eventAthenB) {
        return eventAthenB.getChanceEvent() * eventA.getChanceEvent() / eventB.getChanceEvent();
    }
    
    public double OneToMany (Bayes eventA, Bayes[] eventB, Bayes[] eventAthenB) {
        int i = 0;
        double result = 0;
        while (i < eventB.length) {
            result = result + (eventAthenB[i].getChanceEvent() * eventB[i].getChanceEvent());
            i++;
        }
        return result;
    }
    
    public double ManyToOne (Bayes[] eventA, Bayes eventB, Bayes[] eventBthenA) {
        int i = 0;
        double result = 0;
        while (i < eventA.length) {
            result = result + (eventBthenA[i].getChanceEvent() * eventA[i].getChanceEvent());
            i++;
        }
        
        result = eventBthenA[0].getChanceEvent() * eventA[0].getChanceEvent() / result;
        return result;
    }
    
    public double ManyToMany (Bayes[] eventA, Bayes[] eventB, Bayes[] eventBthenA) {
        
        return 0;
    }
}
