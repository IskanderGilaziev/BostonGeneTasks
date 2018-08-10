package ru.BostonGene.gilaziev.answers.task3_yandex_translator;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class YandexTranslatorTest {

    private HttpClient httpClient;
    private  final  String yandexApiKey = "trnsl.1.1.20180807T190029Z.8164c743459e7355.6dd52c5c753eb8f1694ecf7e7c821f5c42692e5d";
    private  YandexTranslator yandexTranslator;
    @Before
    public  void init(){
         httpClient = HttpClientBuilder.create().build();
         yandexTranslator = new YandexTranslator(httpClient,yandexApiKey);
    }


    @Test
    public void easyTest(){
        assertEquals("Привет",yandexTranslator.yandexTranslate("Hello"));
    }

    @Test
    public void mediumTest(){
        assertEquals("Вы знаете путь к королеве",yandexTranslator.yandexTranslate("You know the way to the queen"));
    }

    @Test
    public  void HardRussianTest(){
        assertEquals("Привет",yandexTranslator.yandexTranslate("Привет"));
        assertEquals("Возможно нам стоит выпить чашечку чая",
                                yandexTranslator.yandexTranslate("Возможно нам стоит выпить чашечку чая"));
    }

}
