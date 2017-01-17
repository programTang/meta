package org.tj.meta.base.util.clone;

import java.io.*;

/**
 * Created by 001 on 17/1/10.
 */
public class CloneUtis {

//    利用序列化进行深拷贝
    public static <T extends Serializable> T deepClone(T t){
        T obj = null;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(t);
            obs.close();

            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(out.toByteArray()));
            obj = (T) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
