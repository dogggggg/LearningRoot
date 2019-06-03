package org.vito.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Halb
 * @version V1.0
 * @Title: FormatUtil
 * @Package: org.vito.util
 * @Description: TODO
 * @date 2019/06/03 21:20
 */
public class FormatUtil {

    public static void main(String[] args) throws IOException {
        //已知一个json 字符串
        String json = "{\"name\":\"sojson\",\"age\":4,\"domain\":\"https://www.sojson.com\"}";
        //求优雅输出
        ObjectMapper mapper = new ObjectMapper();
        Object obj = mapper.readValue(json, Object.class);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
    }
}