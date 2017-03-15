package com.soecode.lyf.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
* @author  created by liujie
* @date    2017年3月10日 --- @上午11:34:17
*
 */
public class SerializableUtil {

    /**
     * 序列化
     *
     * @param obj
     * @return
     */
    public static byte[] writeObject(Object obj) throws IOException {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buf);
        out.writeObject(obj);

        return buf.toByteArray();
    }

    /**
     * 返序列化
     *
     * @param data
     * @return
     */
    public static Object readObject(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        return in.readObject();
    }
}
