package ru.vdv.tregulov.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//аннотацыия Target указывает на ту область класса(в нашем случае это поля FIELD),
// к которой мы будем применять нашу аннотацию CheckEmail
@Target(ElementType.FIELD)
//аннотация RetentionPolicy.RUNTIME означает, что информация о нашей аннотации CheckEmail,
// должна сохраняться вплоть до выполнения кода, т.е. вплоть до RUNTIME
@Retention(RetentionPolicy.RUNTIME)
//в аннотации Constraint мы указываем класс, который создадим сами. Именно этот
// класс CheckEmailValidator будет обрабатывать нашу аннотацию CheckEmail. В этом классе
// будет заключена вся бизнес логика CheckEmail
@Constraint(validatedBy = CheckEmailValidator.class)
//в нашем случае аннотация CheckEmail это просто флаг. Мы ставим её над полем email,
// следовательно значение поля email должно валидироваться (проверяться) в
// классе CheckEmailValidator
public @interface CheckEmail {

    //прописываем value и massage по аналогии с другими проверочными
    // аннотациями (Size, Min, Max и т.п)
    //они создаются, как методы и означают, что если мы не пропишем в скобках аннотации
    // над полем наши value и massage, то выведутся по дефолту эти
    public String value() default "xyz.com";
    public String message() default "email must ends with xyz.com";

//groups позволяет программистам разбивать аннотации по группам
    public Class<?>[] groups() default {};
//payloads используется для переноса информации о метаданных клиента
    public Class<? extends Payload>[] payload() default {};
}
