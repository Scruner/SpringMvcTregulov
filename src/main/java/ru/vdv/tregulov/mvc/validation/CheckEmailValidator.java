package ru.vdv.tregulov.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class CheckEmailValidator
        //в ConstraintValidator мы должны указать два дженерика 1й - это сама наша аннотация,
        // которую будет обрабатывать CheckEmailValidator и 2й - тип данных, к которому
        // мы будем применять аннотацию
        implements ConstraintValidator<CheckEmail, String> {

    //переменная, которая содержит хвост нашего email (то есть часть после символа @)
    private String endOfEmail;

    //в этом методе мы придадим значение переменной endOfEmail
    @Override
    public void initialize(CheckEmail checkEmail) {
        endOfEmail = checkEmail.value();
    }
//в этом методе происходит проверка нашего бизнес правила. Первый параметр в этом методе - это
// именно то значение, которе будет вводится в нашу форму email в листе. И здесь мы проверяем
// конец введённого значения соответствует endOfEmail или нет. Вот здесь enteredValue.endsWith(endOfEmail)
// это и проверяется.
    @Override
    public boolean isValid(String enteredValue,
                           ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue.endsWith(endOfEmail);
    }
}
