package PresentationLayer;

import BmiUtil.BmiHelperFunctions;
import FunctionLayer.LoginSampleException;
import com.sun.webkit.Utilities;

import javax.rmi.CORBA.Util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Resultat extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        Double height = 0.0;
        Double weight = 0.0;
        try {
            height = Double.parseDouble(request.getParameter("height"));
            weight = Double.parseDouble(request.getParameter("weight"));
        } catch (Exception e){
            throw new LoginSampleException("Du skal indtaste et tal som højde og vægt");
        }

        Double bmi = BmiHelperFunctions.calcBmi(height, weight);

        String bmi_to_dec = String.format("%.2f", bmi);
        String kategori = BmiHelperFunctions.findKategori(bmi);

        request.setAttribute("height", height);
        request.setAttribute("weight", weight);
        request.setAttribute("kategori", kategori);
        request.setAttribute("bmi", bmi_to_dec);

        return "resultat";
    }
}
