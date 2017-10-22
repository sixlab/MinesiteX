/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/12 13:42
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.lib.core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtilTest {
    
    @Test
    public void readList() throws Exception {
        String path = "data/readList.txt";
        TestBean bean1 = new TestBean();
        bean1.setUsername("user\nname");
        bean1.setPassword("us");
    
        TestBean bean2 = new TestBean();
        bean2.setUsername("sdf");
        bean2.setPassword("sdf1");
    
        List<TestBean> list1 = new ArrayList<>();
        list1.add(bean1);
        list1.add(bean2);
        list1.add(bean1);
        list1.add(bean1);
        list1.add(bean2);
        
        FileUtil.overwriteJson(path, list1);
    
        List<TestBean> beanList = FileUtil.readList(path, TestBean.class);
    
        System.out.println(JsonUtl.toJson(beanList));
    }
    
    @Test
    public void readJson() throws Exception {
        String path = "data/readJson.txt";
        TestBean bean1 = new TestBean();
        bean1.setUsername("user\nname");
        bean1.setPassword("us");
    
        TestBean bean2 = new TestBean();
        bean2.setUsername("sdf");
        bean2.setPassword("sdf1");
    
        Map map = new HashMap();
        map.put("ab",bean1);
        map.put("cd",bean2);
        map.put("3a",bean1);
        map.put("bc",bean1);
        map.put("1b",bean2);
        
        FileUtil.overwriteJson(path, map);
    
        Map result = FileUtil.readJson(path, Map.class);
    
        System.out.println(JsonUtl.toJson(result));
    }
    
    @Test
    public void appendJson() throws Exception {
        String path = "data/appendJson.txt";
        TestBean bean1 = new TestBean();
        bean1.setUsername("user\nname");
        bean1.setPassword("us");
        FileUtil.appendJson(path, bean1);
        FileUtil.appendJson(path, bean1);
        FileUtil.appendJson(path, bean1);
        FileUtil.appendJson(path, bean1);
        
        List<TestBean> list1 = new ArrayList<>();
        
        TestBean bean2 = new TestBean();
        bean2.setUsername("sdf");
        bean2.setPassword("sdf1");
        list1.add(bean2);
        list1.add(bean1);
        
        FileUtil.appendJson(path, list1);
        FileUtil.appendJson(path, null);
        FileUtil.appendJson(path, new ArrayList<>());
    
        List list2 = new ArrayList();
        list2.add(null);
        list2.add(bean2);
        list2.add(null);
        FileUtil.appendJson(path, list2);
    
        List list3 = new ArrayList();
        list3.add(null);
        list3.add(bean2);
        list3.add(null);
        FileUtil.appendJson(path, list3);
    }
    
    @Test
    public void overwriteJson() throws Exception {
        String path = "data/overwriteJson.txt";
        TestBean bean1 = new TestBean();
        bean1.setUsername("user\nname");
        bean1.setPassword("us");
        FileUtil.overwriteJson(path, bean1);
        FileUtil.overwriteJson(path, bean1);
        FileUtil.overwriteJson(path, bean1);
        FileUtil.overwriteJson(path, bean1);
    
        List<TestBean> list1 = new ArrayList<>();
    
        TestBean bean2 = new TestBean();
        bean2.setUsername("sdf");
        bean2.setPassword("sdf1");
        list1.add(bean2);
        list1.add(bean1);
    
        FileUtil.overwriteJson(path, list1);
        FileUtil.overwriteJson(path, null);
        FileUtil.overwriteJson(path, new ArrayList<>());
    
        List list2 = new ArrayList();
        list2.add(null);
        list2.add(bean2);
        list2.add(null);
        FileUtil.overwriteJson(path, list2);
    
        List list3 = new ArrayList();
        list3.add(bean1);
        list3.add(null);
        list3.add(bean2);
        FileUtil.overwriteJson(path, list3);
    }
    
    @Test
    public void appendData() throws Exception {
        FileUtil.appendData("data/appendData.txt", "Minesite");
        FileUtil.appendData("data/appendData.txt", "Minesite");
        FileUtil.appendData("data/appendData.txt", "Minesite");
        FileUtil.appendData("data/appendData.txt", "Minesite");
        FileUtil.appendData("data/appendData.txt", "Minesite");
    }
    
    @Test
    public void overwriteData() throws Exception {
        FileUtil.overwriteData("data/overwriteData.txt", "Minesite");
        FileUtil.overwriteData("data/overwriteData.txt", "Minesite");
        FileUtil.overwriteData("data/overwriteData.txt", "Minesite");
        FileUtil.overwriteData("data/overwriteData.txt", "Minesite");
        FileUtil.overwriteData("data/overwriteData.txt", "Minesite");
    }
    
    @Test
    public void writeJson() throws Exception {
    }
    
    @Test
    public void writeData() throws Exception {
    }
    
    @Test
    public void readData() throws Exception {
    }
}