package pl.kapcerSniadek.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {

    double o;

    @GetMapping("/")
    public String calculator(Model model) {
        model.addAttribute("o", o);
        return "index";
    }
    @PostMapping("/")
    public String postCalculator(@RequestParam double num1, @RequestParam double num2, @RequestParam char operator) {
        switch (operator) {
            case '+':
                o = num1 + num2;
                break;
            case '-':
                o = num1 - num2;
                break;
            case '*':
                o = num1 * num2;
                break;
            case '/':
                o = num1 / num2;
                break;
            default:
                o = 0.0;
        }
        return "redirect:/";
    }
}
