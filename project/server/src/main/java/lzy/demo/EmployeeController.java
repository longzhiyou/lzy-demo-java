package lzy.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * User: longzhiyou
 * Date: 2019/1/9
 * Time: 16:05
 */
@Controller
public class EmployeeController {
    //todo replace this with employee DAO/repository.
    private static List<Employee> employeeList = new ArrayList<>();

    @PostMapping("/")
    public String handlePostRequest(@Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee-form";
        }
        employeeList.add(employee);
        return "redirect:/employees";
    }

    @GetMapping("/")
    public String handleGetRequest(Employee employee) {
        return "employee-form";
    }

    @GetMapping("/employees")
    public String handleGetRequest(Model model) {
        model.addAttribute("employees", employeeList);
        return "employee-view";
    }
}
