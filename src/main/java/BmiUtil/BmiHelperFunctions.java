package BmiUtil;

public class BmiHelperFunctions {

    public static Double calcBmi(Double height, Double weight){
        return  weight / (height * height) * 100 * 100;
    }

    public static String findKategori(Double bmi) {

        String kategori = "";

        if (bmi < 18.5) {
            kategori = "Undervægtig";
        } else if (bmi > 30) {
            kategori = "Svært overvægtig";
        } else if (bmi < 25) {
            kategori = "Normalvægtig";
        } else {
            kategori = "Overvægtig";
        }

        return kategori;
    }
}
