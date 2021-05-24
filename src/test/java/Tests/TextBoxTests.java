package Tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @Test
    void successfulSubmitFormTest()
    {
        open("https://demoqa.com/text-box");

        $("[id=userName]").setValue("some user");
        $("[id=userEmail]").setValue("someemail@mail.mail");
        $("[id=currentAddress]").setValue("some user address 74");
        $("[id=permanentAddress]").setValue("some user trali vali");
        $("[id=submit]").click();

        $("id=name").shouldHave(text("Name:"),text("some user"));
        $("id=email").shouldHave(text("Email:"),text("someemail@mail.mail"));
       // $("id=email").shouldHave(text("someemail@mail.mail"));
       // $("id=email").shouldHave(text("someemail@mail.mail"));
    }


}
