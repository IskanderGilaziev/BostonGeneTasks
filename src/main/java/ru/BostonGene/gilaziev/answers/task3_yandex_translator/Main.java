package ru.BostonGene.gilaziev.answers.task3_yandex_translator;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String yandexApiKey = "API Key";//Enter your yandex api key
        HttpClient httpClient = HttpClientBuilder.create().build();
        Scanner scanner = new Scanner(System.in);
        YandexTranslator yandexTranslator = new YandexTranslator(httpClient,yandexApiKey);

        System.out.println("Переводчик готов к работе. Если желаете выйти из него введите EXIT0."
                                + " Вводите слова на английском языке: ");

        while (true){
            String inputWords = scanner.nextLine();
            if(inputWords.equalsIgnoreCase("exit0")){
                System.out.println("До свидания!");
                System.exit(0);
            }
            else {
                String translatedWords = yandexTranslator.yandexTranslate(inputWords);
                System.out.println(translatedWords);
            }
        }
    }

}
