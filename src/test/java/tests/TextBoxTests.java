package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setup()
    {
        Configuration.startMaximized = true;
    }


    @Test
    void successfulSubmitFormTest()
    {
        open("https://demoqa.com/text-box");

        $("[id=userName]").setValue("some user");
        $("[id=userEmail]").setValue("someemail@mailmail.ru");
        $("[id=currentAddress]").setValue("some user address 74");
        $("[id=permanentAddress]").setValue("some user trali vali");
        $("[id=submit]").click();

        $("[id=name]").shouldHave(text("Name:"),text("some user"));
        $("[id=email]").shouldHave(text("Email:"),text("someemail@mailmail.ru"));
        $("p[id=currentAddress]").shouldHave(text("Current Address :"),text("some user address 74"));
        $("[id=permanentAddress]", 1).shouldHave(text("Permananet Address :"),text("some user trali vali"));

    }


    @Test
    void successfulSubmitFormWithVariablesTest() {

        String userName = "some user";
        open("https://demoqa.com/text-box");

        $("[id=userName]").setValue(userName);
        $("[id=userEmail]").setValue("someemail@mailmail.ru");
        $("[id=currentAddress]").setValue("some user address 74");
        $("[id=permanentAddress]").setValue("some user trali vali");
        $("[id=submit]").click();

        $("[id=name]").shouldHave(text("Name:"),text(userName));
        $("[id=email]").shouldHave(text("Email:"),text("someemail@mailmail.ru"));
        $("p[id=currentAddress]").shouldHave(text("Current Address :"),text("some user address 74"));
        $("[id=permanentAddress]", 1).shouldHave(text("Permananet Address :"),text("some user trali vali"));

    }


    @Test
    void successfulSubmitFormWithSearchInOutputTest() {

        String userName = "some user";
        open("https://demoqa.com/text-box");

        $("[id=userName]").setValue(userName);
        $("[id=userEmail]").setValue("someemail@mailmail.ru");
        $("[id=currentAddress]").setValue("some user address 74");
        $("[id=permanentAddress]").setValue("some user trali vali");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text(userName),
                text("Email:"),
                text("someemail@mailmail.ru"),
                text("some user address 74"),
                text("some user trali vali"));

    }

    @Test
    void successfulSubmitFormWithBadLocatorsTest() {

        String userName = "some user";
        open("https://demoqa.com/text-box");

        $("[id=userName]").setValue(userName);
        $("[placeholder=\"name@example.com\"]").setValue("someemail@mailmail.ru");
        $("textarea").setValue("some user address 74");
        $(".form-control", 3).setValue("some user trali vali");
        $(byText("Submit")).click();

        $("[id=output]").shouldHave(text(userName),
                text("Email:"),
                text("someemail@mailmail.ru"),
                text("some user address 74"),
                text("some user trali vali"));

    }
}
