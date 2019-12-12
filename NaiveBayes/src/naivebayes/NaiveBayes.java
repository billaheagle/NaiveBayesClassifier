package naivebayes;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class NaiveBayes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<DataModel> data = new ArrayList();
        /*data.add(new DataModel("JENISKELAMIN", "PRODI", SEMESTER, PENGELUARAN, "TEMPAT TINGGAL", "MAKAN SIANG"));
        INPUT JENISKELAMIN = "L" atau "P"
        INPUT PRODI = "CS" untuk Computer Science, "BIS" untuk Business Information System, atau "BM" untuk Business Management
        INPUT SEMESTER = 1, 3, 5, atau 7
        INPUT PENGELUARAN = Diatas 50000 atau dibawah 50000
        INPUT TEMPAT TINGGAL = "Kost" atau "PP"
        INPUT MAKAN SIANG = "CK" atau "B3" */
        data.add(new DataModel("L", "CS", 5, 30000, "PP", "CK"));
        data.add(new DataModel("L", "BM", 3, 30000, "Kost", "CK"));
        data.add(new DataModel("P", "BIS", 7, 30000, "Kost", "CK"));
        data.add(new DataModel("P", "BM", 1, 80000, "PP", "CK"));
        data.add(new DataModel("L", "BIS", 5, 80000, "PP", "CK"));
        data.add(new DataModel("L", "BM", 7, 30000, "Kost", "B3"));
        data.add(new DataModel("L", "CS", 5, 80000, "PP", "B3"));
        data.add(new DataModel("L", "BIS", 3, 30000, "Kost", "B3"));
        data.add(new DataModel("P", "BM", 5, 80000, "PP", "B3"));
        data.add(new DataModel("P", "CS", 7, 30000, "Kost", "B3"));
        
        DataModel dataTesting = new DataModel("L", "BM", 5, 30000, "PP");
        
        Model model = new Model(data);
        model.DataTesting(dataTesting);
        
//        Bayes a = new Bayes(0.5);
//        Bayes b = new Bayes(0.8);
//        BayesianRule rules = new BayesianRule();
//        System.out.println(rules.OneToOne(a, b, new Bayes(0.9)));
    }

}
