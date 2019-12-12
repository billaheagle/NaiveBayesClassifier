package naivebayes;

import java.util.ArrayList;

public class Model {

    private ArrayList<DataModel> dataModel;
    private double modelA; //Model Makan di CK
    private double modelANegation; //Model Makan di B3
    //--------------------------------------------------------------------------
    private double modelB1ThenA; //Laki-laki THEN Model Makan di CK
    private double modelB1ThenANegation; //Laki-laki THEN Model Makan di B3
    private double modelB2ThenA; //Perempuan THEN Model Makan di CK
    private double modelB2ThenANegation; //Perempuan THEN Model Makan di B3
    //--------------------------------------------------------------------------
    private double modelC1ThenA; //BM THEN Model Makan di CK
    private double modelC1ThenANegation; //BM Model Makan di B3
    private double modelC2ThenA; //BiS THEN Model Makan di CK
    private double modelC2ThenANegation; //BIS Model Makan di B3
    private double modelC3ThenA; //CS THEN Model Makan di CK
    private double modelC3ThenANegation; //CS Model Makan di B3
    //--------------------------------------------------------------------------
    private double modelD1ThenA; //>50K THEN Model Makan di CK
    private double modelD1ThenANegation; //>50K THEN Model Makan di B3
    private double modelD2ThenA; //<50K THEN Model Makan di CK
    private double modelD2ThenANegation; //<50K THEN Model Makan di B3
    //--------------------------------------------------------------------------
    private double modelE1ThenA; //Semester 1 THEN Model Makan di CK
    private double modelE1ThenANegation; //Semester 1 THEN Model Makan di B3
    private double modelE2ThenA; //Semester 3 THEN Model Makan di CK
    private double modelE2ThenANegation; //Semester 3 THEN Model Makan di B3
    private double modelE3ThenA; //Semester 5 THEN Model Makan di CK
    private double modelE3ThenANegation; //Semester 5 THEN Model Makan di B3
    private double modelE4ThenA; //Semester 7 THEN Model Makan di CK
    private double modelE4ThenANegation; //Semester 7 THEN Model Makan di B3
    //--------------------------------------------------------------------------
    private double modelF1ThenA; //Kost THEN Model Makan di CK
    private double modelF1ThenANegation; //Kost THEN Model Makan di B3
    private double modelF2ThenA; //PP THEN Model Makan di CK
    private double modelF2ThenANegation; //PP THEN Model Makan di B3

    public Model(ArrayList<DataModel> dataModel) {
        this.dataModel = dataModel;
        this.modelA = 0;
        this.modelANegation = 0;
        this.modelB1ThenA = 0;
        this.modelB1ThenANegation = 0;
        this.modelB2ThenA = 0;
        this.modelB2ThenANegation = 0;
        this.modelC1ThenA = 0;
        this.modelC1ThenANegation = 0;
        this.modelC2ThenA = 0;
        this.modelC2ThenANegation = 0;
        this.modelC3ThenA = 0;
        this.modelC3ThenANegation = 0;
        this.modelD1ThenA = 0;
        this.modelD1ThenANegation = 0;
        this.modelD2ThenA = 0;
        this.modelD2ThenANegation = 0;
        this.modelE1ThenA = 0;
        this.modelE1ThenANegation = 0;
        this.modelE2ThenA = 0;
        this.modelE2ThenANegation = 0;
        this.modelE3ThenA = 0;
        this.modelE3ThenANegation = 0;
        this.modelE4ThenA = 0;
        this.modelE4ThenANegation = 0;
        this.modelF1ThenA = 0;
        this.modelF1ThenANegation = 0;
        this.modelF2ThenA = 0;
        this.modelF2ThenANegation = 0;
        makeModel();
    }

    public void DataTesting(DataModel dataTesting) {
        double result, resultNegation;
        double param1 = 0, param2 = 0, param3 = 0, param4 = 0, param5 = 0;
        double param1Negation = 0, param2Negation = 0, param3Negation = 0, param4Negation = 0, param5Negation = 0;
        //Param1----------------------------------------------------------------
        if (dataTesting.getGender().equalsIgnoreCase("L")) {
            param1 = this.modelB1ThenA;
            param1Negation = this.modelB1ThenANegation;
        } else if (dataTesting.getGender().equalsIgnoreCase("P")) {
            param1 = this.modelB2ThenA;
            param1Negation = this.modelB2ThenANegation;
        }
        //Param2----------------------------------------------------------------
        if (dataTesting.getProdi().equalsIgnoreCase("BM")) {
            param2 = this.modelC1ThenA;
            param2Negation = this.modelC1ThenANegation;
        } else if (dataTesting.getProdi().equalsIgnoreCase("BIS")) {
            param2 = this.modelC2ThenA;
            param2Negation = this.modelC2ThenANegation;
        } else if (dataTesting.getProdi().equalsIgnoreCase("CS")) {
            param2 = this.modelC3ThenA;
            param2Negation = this.modelC3ThenANegation;
        }
        //Param3----------------------------------------------------------------
        if (dataTesting.getSemester() == 1) {
            param3 = this.modelE1ThenA;
            param4Negation = this.modelE1ThenANegation;
        } else if (dataTesting.getSemester() == 3) {
            param3 = this.modelE2ThenA;
            param4Negation = this.modelE2ThenANegation;
        } else if (dataTesting.getSemester() == 5) {
            param3 = this.modelE3ThenA;
            param4Negation = this.modelE3ThenANegation;
        } else if (dataTesting.getSemester() == 7) {
            param3 = this.modelE4ThenA;
            param4Negation = this.modelE4ThenANegation;
        }
        //Param4----------------------------------------------------------------
        if (dataTesting.getPengeluaran() >= 50000) {
            param4 = this.modelD1ThenA;
            param3Negation = this.modelD1ThenANegation;
        } else if (dataTesting.getPengeluaran() < 50000) {
            param4 = this.modelD2ThenA;
            param3Negation = this.modelD2ThenANegation;
        }
        //Param5----------------------------------------------------------------
        if (dataTesting.getTempatTinggal().equalsIgnoreCase("Kost")) {
            param5 = this.modelF1ThenA;
            param5Negation = this.modelF1ThenANegation;
        } else if (dataTesting.getTempatTinggal().equalsIgnoreCase("PP")) {
            param5 = this.modelF2ThenA;
            param5Negation = this.modelF2ThenANegation;
        }
        
        result = (param1 * param2 * param3 * param4 * param5) * this.modelA;
        resultNegation = (param1Negation * param2Negation * param3Negation * param4Negation * param5Negation) * modelANegation;
        
        System.out.println("P(MAKAN DI CK) = " + this.modelA);
        System.out.println("P(MAKAN DI B3) = " + this.modelANegation);
        System.out.println("----------------------------------------");
        System.out.println("P(MAKAN DI CK|JENIS KELAMIN) = " + param1);
        System.out.println("P(MAKAN DI B3|JENIS KELAMIN) = " + param1Negation);
        System.out.println("----------------------------------------");
        System.out.println("P(MAKAN DI CK|PROGRAM STUDI) = " + param2);
        System.out.println("P(MAKAN DI B3|PROGRAM STUDI) = " + param2Negation);
        System.out.println("----------------------------------------");
        System.out.println("P(MAKAN DI CK|SEMESTER) = " + param3);
        System.out.println("P(MAKAN DI B3|SEMESTER) = " + param3Negation);
        System.out.println("----------------------------------------");
        System.out.println("P(MAKAN DI CK|PENGELUARAN) = " + param4);
        System.out.println("P(MAKAN DI B3|PENGELUARAN) = " + param4Negation);
        System.out.println("----------------------------------------");
        System.out.println("P(MAKAN DI CK|TEMPAT TINGGAL) = " + param5);
        System.out.println("P(MAKAN DI B3|TEMPAT TINGGAL) = " + param5Negation);
        System.out.println("----------------------------------------");
        System.out.println("Didapatkan dari dataTesting :");
        System.out.println("P(dataTesing|MAKAN DI CK) = " + result);
        System.out.println("P(dataTesing|MAKAN DI B3) = " + resultNegation);
        System.out.println("----------------------------------------");
        System.out.println("Kesimpulan dari dataTesting tersebut adalah : ");
        
        if (result > resultNegation) {
            System.out.println("MAKAN DI CK");
        } else {
            System.out.println("MAKAN DI B3");
        }
    }

    private void makeModel() {
        for (DataModel i : this.dataModel) {
            if (i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelA++;
            }
            if (i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelANegation++;
            }
            //-------------------------------------------------------------------------------------
            if (i.getGender().equalsIgnoreCase("L") && i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelB1ThenA++;
            }
            if (i.getGender().equalsIgnoreCase("L") && i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelB1ThenANegation++;
            }
            if (i.getGender().equalsIgnoreCase("P") && i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelB2ThenA++;
            }
            if (i.getGender().equalsIgnoreCase("P") && i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelB2ThenANegation++;
            }
            //-------------------------------------------------------------------------------------
            if (i.getProdi().equalsIgnoreCase("BM") && i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelC1ThenA++;
            }
            if (i.getProdi().equalsIgnoreCase("BM") && i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelC1ThenANegation++;
            }
            if (i.getProdi().equalsIgnoreCase("BIS") && i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelC2ThenA++;
            }
            if (i.getProdi().equalsIgnoreCase("BIS") && i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelC2ThenANegation++;
            }
            if (i.getProdi().equalsIgnoreCase("CS") && i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelC3ThenA++;
            }
            if (i.getProdi().equalsIgnoreCase("CS") && i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelC3ThenANegation++;
            }
            //-------------------------------------------------------------------------------------
            if (i.getPengeluaran() >= 50000 && i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelD1ThenA++;
            }
            if (i.getPengeluaran() >= 50000 && i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelD1ThenANegation++;
            }
            if (i.getPengeluaran() < 50000 && i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelD2ThenA++;
            }
            if (i.getPengeluaran() < 50000 && i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelD2ThenANegation++;
            }
            //-------------------------------------------------------------------------------------
            if (i.getSemester() == 1 && i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelE1ThenA++;
            }
            if (i.getSemester() == 1 && i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelE1ThenANegation++;
            }
            if (i.getSemester() == 3 && i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelE2ThenA++;
            }
            if (i.getSemester() == 3 && i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelE2ThenANegation++;
            }
            if (i.getSemester() == 5 && i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelE3ThenA++;
            }
            if (i.getSemester() == 5 && i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelE3ThenANegation++;
            }
            if (i.getSemester() == 7 && i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelE4ThenA++;
            }
            if (i.getSemester() == 7 && i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelE4ThenANegation++;
            }
            //-------------------------------------------------------------------------------------
            if (i.getTempatTinggal().equalsIgnoreCase("Kost") && i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelF1ThenA++;
            }
            if (i.getTempatTinggal().equalsIgnoreCase("Kost") && i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelF1ThenANegation++;
            }
            if (i.getTempatTinggal().equalsIgnoreCase("PP") && i.getTempatMakan().equalsIgnoreCase("CK")) {
                this.modelF2ThenA++;
            }
            if (i.getTempatTinggal().equalsIgnoreCase("PP") && i.getTempatMakan().equalsIgnoreCase("B3")) {
                this.modelF2ThenANegation++;
            }
        }
        getModel();
    }

    private void getModel() {
        this.modelB1ThenA = this.modelB1ThenA / this.modelA;
        this.modelB1ThenANegation = this.modelB1ThenANegation / this.modelANegation;
        this.modelB2ThenA = this.modelB1ThenA / this.modelA;
        this.modelB2ThenANegation = this.modelB1ThenANegation / this.modelANegation;
        //--------------------------------------------------------------------------
        this.modelC1ThenA = this.modelC1ThenA / this.modelA;
        this.modelC1ThenANegation = this.modelC1ThenANegation / this.modelANegation;
        this.modelC2ThenA = this.modelC2ThenA / this.modelA;
        this.modelC2ThenANegation = this.modelC2ThenANegation / this.modelANegation;
        this.modelC3ThenA = this.modelC3ThenA / this.modelA;
        this.modelC3ThenANegation = this.modelC3ThenANegation / this.modelANegation;
        //--------------------------------------------------------------------------
        this.modelD1ThenA = this.modelD1ThenA / this.modelA;
        this.modelD1ThenANegation = this.modelD1ThenANegation / this.modelANegation;
        this.modelD2ThenA = this.modelD2ThenA / this.modelA;
        this.modelD2ThenANegation = this.modelD2ThenANegation / this.modelANegation;
        //--------------------------------------------------------------------------
        this.modelE1ThenA = this.modelE1ThenA / this.modelA;
        this.modelE1ThenANegation = this.modelE1ThenANegation / this.modelANegation;
        this.modelE2ThenA = this.modelE2ThenA / this.modelA;
        this.modelE2ThenANegation = this.modelE2ThenANegation / this.modelANegation;
        this.modelE3ThenA = this.modelE3ThenA / this.modelA;
        this.modelE3ThenANegation = this.modelE3ThenANegation / this.modelANegation;
        this.modelE4ThenA = this.modelE4ThenA / this.modelA;
        this.modelE4ThenANegation = this.modelE4ThenANegation / this.modelANegation;
        //--------------------------------------------------------------------------
        this.modelF1ThenA = this.modelF1ThenA / this.modelA;
        this.modelF1ThenANegation = this.modelF1ThenANegation / this.modelANegation;
        this.modelF2ThenA = this.modelF2ThenA / this.modelA;
        this.modelF2ThenANegation = this.modelF2ThenANegation / this.modelANegation;
        //--------------------------------------------------------------------------
        this.modelA = this.modelA / this.dataModel.size();
        this.modelANegation = this.modelANegation / this.dataModel.size();
    }

    public double getModelA() {
        return modelA;
    }

    public void setModelA(double modelA) {
        this.modelA = modelA;
    }

    public double getModelANegation() {
        return modelANegation;
    }

    public void setModelANegation(double modelANegation) {
        this.modelANegation = modelANegation;
    }

    public double getModelB1ThenA() {
        return modelB1ThenA;
    }

    public void setModelB1ThenA(double modelB1ThenA) {
        this.modelB1ThenA = modelB1ThenA;
    }

    public double getModelB1ThenANegation() {
        return modelB1ThenANegation;
    }

    public void setModelB1ThenANegation(double modelB1ThenANegation) {
        this.modelB1ThenANegation = modelB1ThenANegation;
    }

    public double getModelB2ThenA() {
        return modelB2ThenA;
    }

    public void setModelB2ThenA(double modelB2ThenA) {
        this.modelB2ThenA = modelB2ThenA;
    }

    public double getModelB2ThenANegation() {
        return modelB2ThenANegation;
    }

    public void setModelB2ThenANegation(double modelB2ThenANegation) {
        this.modelB2ThenANegation = modelB2ThenANegation;
    }

    public double getModelC1ThenA() {
        return modelC1ThenA;
    }

    public void setModelC1ThenA(double modelC1ThenA) {
        this.modelC1ThenA = modelC1ThenA;
    }

    public double getModelC1ThenANegation() {
        return modelC1ThenANegation;
    }

    public void setModelC1ThenANegation(double modelC1ThenANegation) {
        this.modelC1ThenANegation = modelC1ThenANegation;
    }

    public double getModelC2ThenA() {
        return modelC2ThenA;
    }

    public void setModelC2ThenA(double modelC2ThenA) {
        this.modelC2ThenA = modelC2ThenA;
    }

    public double getModelC2ThenANegation() {
        return modelC2ThenANegation;
    }

    public void setModelC2ThenANegation(double modelC2ThenANegation) {
        this.modelC2ThenANegation = modelC2ThenANegation;
    }

    public double getModelC3ThenA() {
        return modelC3ThenA;
    }

    public void setModelC3ThenA(double modelC3ThenA) {
        this.modelC3ThenA = modelC3ThenA;
    }

    public double getModelC3ThenANegation() {
        return modelC3ThenANegation;
    }

    public void setModelC3ThenANegation(double modelC3ThenANegation) {
        this.modelC3ThenANegation = modelC3ThenANegation;
    }

    public double getModelD1ThenA() {
        return modelD1ThenA;
    }

    public void setModelD1ThenA(double modelD1ThenA) {
        this.modelD1ThenA = modelD1ThenA;
    }

    public double getModelD1ThenANegation() {
        return modelD1ThenANegation;
    }

    public void setModelD1ThenANegation(double modelD1ThenANegation) {
        this.modelD1ThenANegation = modelD1ThenANegation;
    }

    public double getModelD2ThenA() {
        return modelD2ThenA;
    }

    public void setModelD2ThenA(double modelD2ThenA) {
        this.modelD2ThenA = modelD2ThenA;
    }

    public double getModelD2ThenANegation() {
        return modelD2ThenANegation;
    }

    public void setModelD2ThenANegation(double modelD2ThenANegation) {
        this.modelD2ThenANegation = modelD2ThenANegation;
    }

    public double getModelE1ThenA() {
        return modelE1ThenA;
    }

    public void setModelE1ThenA(double modelE1ThenA) {
        this.modelE1ThenA = modelE1ThenA;
    }

    public double getModelE1ThenANegation() {
        return modelE1ThenANegation;
    }

    public void setModelE1ThenANegation(double modelE1ThenANegation) {
        this.modelE1ThenANegation = modelE1ThenANegation;
    }

    public double getModelE2ThenA() {
        return modelE2ThenA;
    }

    public void setModelE2ThenA(double modelE2ThenA) {
        this.modelE2ThenA = modelE2ThenA;
    }

    public double getModelE2ThenANegation() {
        return modelE2ThenANegation;
    }

    public void setModelE2ThenANegation(double modelE2ThenANegation) {
        this.modelE2ThenANegation = modelE2ThenANegation;
    }

    public double getModelE3ThenA() {
        return modelE3ThenA;
    }

    public void setModelE3ThenA(double modelE3ThenA) {
        this.modelE3ThenA = modelE3ThenA;
    }

    public double getModelE3ThenANegation() {
        return modelE3ThenANegation;
    }

    public void setModelE3ThenANegation(double modelE3ThenANegation) {
        this.modelE3ThenANegation = modelE3ThenANegation;
    }

    public double getModelE4ThenA() {
        return modelE4ThenA;
    }

    public void setModelE4ThenA(double modelE4ThenA) {
        this.modelE4ThenA = modelE4ThenA;
    }

    public double getModelE4ThenANegation() {
        return modelE4ThenANegation;
    }

    public void setModelE4ThenANegation(double modelE4ThenANegation) {
        this.modelE4ThenANegation = modelE4ThenANegation;
    }

    public double getModelF1ThenA() {
        return modelF1ThenA;
    }

    public void setModelF1ThenA(double modelF1ThenA) {
        this.modelF1ThenA = modelF1ThenA;
    }

    public double getModelF1ThenANegation() {
        return modelF1ThenANegation;
    }

    public void setModelF1ThenANegation(double modelF1ThenANegation) {
        this.modelF1ThenANegation = modelF1ThenANegation;
    }

    public double getModelF2ThenA() {
        return modelF2ThenA;
    }

    public void setModelF2ThenA(double modelF2ThenA) {
        this.modelF2ThenA = modelF2ThenA;
    }

    public double getModelF2ThenANegation() {
        return modelF2ThenANegation;
    }

    public void setModelF2ThenANegation(double modelF2ThenANegation) {
        this.modelF2ThenANegation = modelF2ThenANegation;
    }

}
