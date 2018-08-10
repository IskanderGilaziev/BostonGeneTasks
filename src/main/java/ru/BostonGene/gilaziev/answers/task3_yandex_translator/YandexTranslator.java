package ru.BostonGene.gilaziev.answers.task3_yandex_translator;



import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class YandexTranslator {
    private static final Logger logger = Logger.getLogger(YandexTranslator.class);
    private HttpClient httpClient;
    private  String yandexApiKey;
    private  String UTF8 = "UTF-8";
    private final String defaultError = "Sorry!Not working";
    private final String error401 = "Неправильный API-ключ.Попробуйте ввести заново ключ.";
    private final String error402 = "Данный API-ключ заблокирован.Попробуйте другой ключ.";
    private final String error404 = "Превышено суточное ограничение на объем переведенного текста.";
    private final String error413 = "Превышен максимально допустимый размер текста.";
    private final String error422 = "Текст не может быть переведен.Проверьте язык ввода.";
    private final String error501 = "Заданное направление перевода не поддерживается.Попробуйте сменить направление.";

    public YandexTranslator(HttpClient httpClient, String ApiKey) {
        this.httpClient = httpClient;
        this.yandexApiKey = ApiKey;
    }

    public  String yandexTranslate(String text) {
        try {
            String urlConnection = "https://translate.yandex.net/api/v1.5/tr.json/translate?"+
                    "key=" + yandexApiKey + "&lang=en-ru" + "&text="+ URLEncoder.encode(text,UTF8);

            HttpPost httpPost = new HttpPost(urlConnection);
            HttpResponse response = httpClient.execute(httpPost);
            Integer status = response.getStatusLine().getStatusCode();
            switch (response.getStatusLine().getStatusCode()){
                case 200:
                    JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity()));
                    return json.getJSONArray("text").getString(0);
                case 401:
                    return error401;
                case 402:
                    return error402;
                case 404:
                    return error404;
                case 413:
                    return error413;
                case 422:
                    return error422;
                case 501:
                    return error501;
                default:
                    return defaultError;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return text;
    }



}
