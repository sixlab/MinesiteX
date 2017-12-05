/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/12 13:42
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.lib.base.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {
    
    public static boolean appendJson(String path, Object obj) {
        return writeJson(path, obj, true);
    }
    
    public static boolean overwriteJson(String path, Object obj) {
        return writeJson(path, obj, false);
    }
    
    public static boolean writeJson(String path, Object obj, boolean append) {
        if (null == obj) {
            return false;
        }
        
        String json;
        if (obj instanceof List) {
            List<Object> sourceList = (List) obj;
            
            //不修改原有 list，过滤掉 null 的元素
            List newList = sourceList.stream().filter(o -> o != null).collect(Collectors.toList());
            
            int size = newList.size();
            if (size == 0) {
                return false;
            }
            
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < size; i++) {
                Object o = newList.get(i);
                String toJson = JsonUtl.toJson(o);
                if (null==toJson) {
                    continue;
                } else {
                    sb.append(toJson);
                    if (i < size - 1) {
                        sb.append("\n");
                    }
                }
            }
            if (sb.length() == 0) {
                return false;
            } else {
                json = sb.toString();
            }
        } else {
            json = JsonUtl.toJson(obj);
        }
        return writeData(path, json, append);
    }
    
    public static boolean appendData(String path, String content) {
        return writeData(path, content, true);
    }
    
    public static boolean overwriteData(String path, String content) {
        return writeData(path, content, false);
    }
    
    public static boolean writeData(String path, String content, boolean append) {
        File file = new File(path);
        FileOutputStream fos = null;
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            
            fos = new FileOutputStream(file, append);
            FileChannel channel = fos.getChannel();
            
            ByteBuffer buffer = Charset.forName("utf-8").encode(content + "\n");
            
            int length;
            while ((length = channel.write(buffer)) != 0) {
            
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    
    public static <T> List<T> readList(String path, Class<T> clz) {
        File file = new File(path);
        if (file.exists()) {
            try {
                Reader reader = new InputStreamReader(new FileInputStream(file), Charset.forName("utf-8"));
                BufferedReader buffer = new BufferedReader(reader);
                String line;
                
                List<T> list = new ArrayList<T>();
                while ((line = buffer.readLine()) != null) {
                    if (!"".equals(line)) {
                        T obj = JsonUtl.toBean(line, clz);
                        list.add(obj);
                    }
                }
                return list;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public static <T> T readJson(String path, Class<T> clz) {
        String content = readData(path);
        if (content != null) {
            return JsonUtl.toBean(content, clz);
        }
        return null;
    }
    
    public static String readData(String path) {
        File file = new File(path);
        if (file.exists()) {
            try {
                Reader reader = new InputStreamReader(new FileInputStream(file), Charset.forName("utf-8"));
                BufferedReader buffer = new BufferedReader(reader);
                
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = buffer.readLine()) != null) {
                    if (!"".equals(line)) {
                        builder.append(line);
                    }
                }
                
                return builder.toString();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}