package cn.koboro.offlineservice.utils;

import cn.koboro.offlineservice.exception.TransformerJsonException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @author xdw
 */
public final class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY,true);
//        objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS,true);
    }

    private JsonUtil() {
    }

    public static String objToJson(Object obj) {
        StringWriter sw = new StringWriter();
        try {
            objectMapper.writeValue(sw, obj);
            return sw.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T jsonToObject(Class tClass, String json) throws TransformerJsonException {
        try {
            return (T) objectMapper.readValue(json, tClass);
        } catch (IOException e) {
            throw new TransformerJsonException(e);
        }
    }

    public static JsonNode getJsonNode(String json) {
        try {
            return objectMapper.readTree(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
