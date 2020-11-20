package ru.vdv.tregulov.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
//        Employee emp = new Employee();
//        emp.setName("Ivan");
//        emp.setSurname("Ivanov");
//        emp.setSalary(300);
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }
//    @RequestMapping("/askDetails")
//    public String askEmployeeDetails() {
//        return "ask-emp-details-view";
//    }

//    @RequestMapping("showDetails")
//    public String showEmpDetails() {
//        return "show-emp-details-view";
//    }

    //    @RequestMapping("/showDetails")
//    public String showEmpDetails(HttpServletRequest request, Model model) {
//        //получаем имя работника с помощью HttpServletRequest и метода getParameter(в котором мы указываем название поля формы)
//        String empName = request.getParameter("employeeName");
//        //изменяем имя
//        empName = "Mr. " + empName;
//        //добавляем изменённое имя в качестве атрибута в модель
//        model.addAttribute("nameAttribute", empName);//"nameAttribute" - название атрибута; empName - значение атрибута
//        model.addAttribute("discription", " - VDV instructor ");
//        model.addAttribute("number", 777);
//        return "show-emp-details-view";
//    }
//    @RequestMapping("/showDetails")
//    //в аннотацию @RequestParam прописываем поле формы из view файла
//    public String showEmpDetails(@RequestParam("employeeName") String empName, Model model) {
//        //изменяем имя
//        empName = "Mr. " + empName + "!!!";
//        //добавляем изменённое имя в качестве атрибута в модель
//        model.addAttribute("nameAttribute", empName);//"nameAttribute" - название атрибута; empName - значение атрибута
//        return "show-emp-details-view";
//    }
    @RequestMapping("/showDetails")
    //этим методом мы говорим: view show-emp-details-view, за которую ответственен этот метод showEmpDetails
    //может использовать атрибут модели под названием "employee"
    //с помощью аннотации @Valid мы говорим, что атрибут "employee" должен пройти валидацию (проверку)
    //и с помощью параметра bindingResult мы проверяем была ли эта валидация успешна или нет
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp,
                                 BindingResult bindingResult) {
       //System.out.println("surname length = " + emp.getSurname().length());

        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else {
//        String name = emp.getName();
//        emp.setName("Mr "+ name);
//
//        String surname = emp.getSurname();
//        emp.setSurname(surname + "!!!");
//
//        int salary = emp.getSalary();
//        emp.setSalary(salary * 10);

            return "show-emp-details-view";
        }
    }
}
