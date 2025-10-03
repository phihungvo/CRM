package com.base.admin.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

public class ClassUtils {
    public static List<String> getAllPropertyNames(Class<?> clazz) {
        List<String> propertyNames = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields).parallel().forEach(field -> propertyNames.add(field.getName()));
        //        for (Field field : fields) {
        //            propertyNames.add(field.getName());
        //        }
        return propertyNames;
    }

    //    public static JSONObject convertDTOToJSON(Object obj) {
    //        try {
    //            Gson gson = new Gson();
    //            String jsonString = gson.toJson(obj);
    //            return new JSONObject(jsonString);
    //        } catch (JSONException e) {
    //            return null;
    //        }
    //    }

    public static Object convertDTOToEntity(Object dto, Object entity) {
        try {
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            mapper.map(dto, entity);
            return entity;
            //            GsonBuilder builder = new GsonBuilder();
            //            builder.registerTypeAdapter(Date.class, new DateJsonSerializer());
            //            builder.registerTypeAdapter(Date.class, new DateDeserializer());
            //            Gson gson = builder.create();
            ////            Type userListType = new TypeToken<entity>() {
            ////            }.getType();
            //
            ////            Gson gson = new Gson();
            //
            ////            String json = gson.toJson(dto);
            //            JSONObject dtojson = new JSONObject(dto);
            //            String json = gson.toJson(entity);
            //            JSONObject entityjson = new JSONObject(json);
            //
            //            for (Iterator it = dtojson.keys(); it.hasNext(); ) {
            //                String key = it.next().toString();
            //                Object value = dtojson.get(key);
            //                entityjson.put(key, value);
            //            }
            //            return gson.fromJson(entityjson.toString(), entity.getClass());
        } catch (JSONException e) {
            return null;
        }
    }

    public static JSONObject newJSONObject(Object dto) {
        try {
            //            Gson gson = new Gson();
            //            String json = gson.toJson(dto);
            //            return new JSONObject(json);
            return new JSONObject(dto);
        } catch (JSONException e) {
            return null;
        }
    }

    public static boolean existsParameter(JSONObject object, String paramName) {
        return object.has(paramName);
    }
}
