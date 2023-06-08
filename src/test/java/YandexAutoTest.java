import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class YandexAutoTest {

    @Test
    public void testYaSearch() {
        // Устанавливаем параметры для использования Chrome
        Configuration.browser = "chrome";

        // Открываем страницу ya.ru
        open("https://ya.ru");

        // Вводим искомое слово в строку поиска и нажимаем Enter
        $("[name='text']").val("автоматизированное тестирование").pressEnter();

        // Проверяем количество результатов поиска на первой странице
        int resultsCount = $$(".serp-item").size();
        System.out.println("Количество результатов - " + resultsCount);

        // Проверяем количество совпадений с искомым словом на странице
        int matchesCount = $$(".serp-item").filterBy(Condition.text("автоматизированное тестирование")).size();
        System.out.println("Количество совпадений - " + matchesCount);
    }
}


