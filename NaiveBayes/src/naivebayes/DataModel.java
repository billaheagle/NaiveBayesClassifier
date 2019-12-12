package naivebayes;

public class DataModel {

    private String gender;
    private String prodi;
    private int semester;
    private double pengeluaran;
    private String tempatTinggal;
    private String tempatMakan;

    public DataModel(String gender, String prodi, int semester, double pengeluaran, String tempatTinggal, String tempatMakan) {
        this.gender = gender;
        this.prodi = prodi;
        this.semester = semester;
        this.pengeluaran = pengeluaran;
        this.tempatTinggal = tempatTinggal;
        this.tempatMakan = tempatMakan;
    }

    public DataModel(String gender, String prodi, int semester, double pengeluaran, String tempatTinggal) {
        this.gender = gender;
        this.prodi = prodi;
        this.semester = semester;
        this.pengeluaran = pengeluaran;
        this.tempatTinggal = tempatTinggal;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(double pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    public String getTempatTinggal() {
        return tempatTinggal;
    }

    public void setTempatTinggal(String tempatTinggal) {
        this.tempatTinggal = tempatTinggal;
    }

    public String getTempatMakan() {
        return tempatMakan;
    }

    public void setTempatMakan(String tempatMakan) {
        this.tempatMakan = tempatMakan;
    }

}
