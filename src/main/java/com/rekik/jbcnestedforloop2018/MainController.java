package com.rekik.jbcnestedforloop2018;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {

    Multiplication multiplication = new Multiplication();
    ArrayList<String> results = new ArrayList<String>();

    @RequestMapping("/")
    public String showIndex(Model model)
    {

        multiplication.setRow(1);
        multiplication.setColumn(1);

        int multiply;


        int MAX = Multiplication.getMAX(); // as it is static we need to get it from the class not from object

        for(int row = multiplication.getRow(); row <= MAX; row++){
            String result = "";
            for (int column = multiplication.getColumn(); column <= MAX; column++){

                multiply = row * column;
                result += multiply+"\t";

            }
            results.add(result);
        }


        model.addAttribute("table", results);


        return "index";
    }

}
