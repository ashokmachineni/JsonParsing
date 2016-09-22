package com.prince.jsonparsing.Model;

/**
 * Created by Administrator on 2016/3/31.
 */
import java.lang.reflect.Type;

import com.google.gson.Gson;

public final class JSONUtils {
    public static <T> T parseJSON(String jsonStr, Class<T> t) {
        Gson gson = new Gson();
        T bean = gson.fromJson(jsonStr, t);
        return bean;
    }


    public static <T> T parseJSONArray(String response, Type type) {
        Gson gson = new Gson();
        T data = gson.fromJson(response, type);
        return data;
    }

    private JSONUtils() {
    }
}