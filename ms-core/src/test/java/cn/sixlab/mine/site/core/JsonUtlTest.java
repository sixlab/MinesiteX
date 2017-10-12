package cn.sixlab.mine.site.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JsonUtlTest {
    @Test
    public void toJson() throws Exception {
        String username = "2cd";
        String password = "sks9";
        TestBean bean = new TestBean();
        bean.setUsername(username);
        bean.setPassword(password);
        
        String json = JsonUtl.toJson(bean);
        
        Assert.assertEquals("{\"username\":\"2cd\",\"password\":\"sks9\"}", json);
    }
    
    @Test
    public void toBean() throws Exception {
        String json = "{\"username\":\"2cd\",\"password\":\"sks9\"}";
        
        TestBean bean = JsonUtl.toBean(json, TestBean.class);
        
        String username = "2cd";
        String password = "sks9";
        
        Assert.assertEquals(username, bean.getUsername());
        Assert.assertEquals(password, bean.getPassword());
    }
    
    @Test
    public void obj2Bean() throws Exception {
        String username = "2cd";
        String password = "sks9";
        
        // 测试 map-> bean
        Map map1 = new HashMap();
        map1.put("username", username);
        map1.put("password", password);
        
        TestBean obj1 = JsonUtl.obj2Bean(map1, TestBean.class);
        
        Assert.assertEquals(username, obj1.getUsername());
        Assert.assertEquals(password, obj1.getPassword());
        
        // 测试 bean-> map
        TestBean obj2 = new TestBean();
        obj2.setUsername(username);
        obj2.setPassword(password);
        
        Map map2 = JsonUtl.obj2Bean(obj2, Map.class);
        
        Assert.assertEquals(username, String.valueOf(map2.get("username")));
        Assert.assertEquals(password, String.valueOf(map2.get("password")));
    }
    
}

