package docs;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class CssXpathExamples {

    void cssXpathExamples(){

        // group: https://t.me/xpath_help
        // hints: https://devhints.io/xpath

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="royal_email">

        $("[data-testid=\"royal_email\"]").setValue("some@mailmail.bf");
        $(by("data-testid", "royal_email")).setValue("some@email.com");

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">

        $("[id='email']").setValue("some@email.com");
        $("[id=\"email\"]").setValue("some@email.com");
        $("[id=email]").setValue("some@email.com");
        $("#email").setValue("some@email.com");                    // <- use this если элемент начинается с ID
        $(byId("email")).setValue("some@email.com");
        $("input[id=email]").setValue("some@email.com");
        $("input#email").setValue("some@email.com");
        $(by("id", "email")).setValue("some@email.com");

    }
}
