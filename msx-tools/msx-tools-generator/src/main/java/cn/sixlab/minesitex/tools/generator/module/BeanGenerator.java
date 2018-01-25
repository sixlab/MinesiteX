/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/21 17:08
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.tools.generator.module;

import cn.sixlab.minesitex.tools.generator.FileUtil;
import cn.sixlab.minesitex.tools.generator.XMLUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;

public class BeanGenerator {
    public static void generator(String projectPath, String pluginName)
            throws Exception {
        //获取 bean 和 plugin 目录
        String beanPath = beanPath(projectPath);
        String pluginPath = pluginPath(beanPath, pluginName);
    
        generatorPom(pluginPath, pluginName);
    
        generatorSrc(pluginPath, pluginName);
    
        addModule(beanPath, pluginName);
    }
    
    private static void addModule(String beanPath, String pluginName)
            throws DocumentException, IOException {
        String pom = beanPath + "/pom.xml";
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File(pom));
        
        doc.getRootElement().element("modules").addElement("module").setText("msx-bean-"+pluginName);
        
        XMLUtil.writeXML(pom, doc);
    }
    
    private static void generatorSrc(String pluginPath, String pluginName) throws IOException {
        String entityPath = pluginPath + "src/main/java/cn/sixlab/minesitex/bean/" + pluginName + "/entity/";
        new File(entityPath).mkdirs();
        String voPath = pluginPath + "src/main/java/cn/sixlab/minesitex/bean/" + pluginName + "/vo/";
        new File(voPath).mkdirs();
        
        new File(entityPath + "README.md").createNewFile();
        new File(voPath + "README.md").createNewFile();
    }
    
    private static void generatorPom(String pluginPath, String pluginName) throws IOException {
        File pom = new File(pluginPath + "/pom.xml");
        String pomText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                "         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
                "    <parent>\n" +
                "        <artifactId>msx-beans</artifactId>\n" +
                "        <groupId>cn.sixlab.minesitex</groupId>\n" +
                "        <version>msx.0.2.0-SNAPSHOT</version>\n" +
                "    </parent>\n" +
                "    <modelVersion>4.0.0</modelVersion>\n" +
                "\n" +
                "    <groupId>cn.sixlab.minesitex</groupId>\n" +
                "    <artifactId>msx-bean-" + pluginName + "</artifactId>\n" +
                "    <version>msx.0.2.0-SNAPSHOT</version>\n" +
                "    <packaging>jar</packaging>\n" +
                "\n" +
                "    <name>msx-bean-" + pluginName + "</name>\n" +
                "    <description>Plugin " + pluginName + "'s bean for Minesitex</description>\n" +
                "\n" +
                "    <dependencies>\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-starter-data-jpa</artifactId>\n" +
                "        </dependency>\n" +
                "    </dependencies>\n" +
                "\n" +
                "    <build>\n" +
                "        <plugins>\n" +
                "            <plugin>\n" +
                "                <groupId>org.apache.maven.plugins</groupId>\n" +
                "                <artifactId>maven-compiler-plugin</artifactId>\n" +
                "            </plugin>\n" +
                "        </plugins>\n" +
                "    </build>\n" +
                "\n" +
                "</project>";
    
        FileUtil.writeFile(pom, pomText);
    }
    
    private static String pluginPath(String path, String pluginName) {
        String pluginPath = path + "msx-bean-" + pluginName + "/";
        File pluginDir = new File(pluginPath);
        
        if (!pluginDir.exists()) {
            pluginDir.mkdirs();
        }
        return pluginPath;
    }
    
    private static String beanPath(String projectPath) throws IOException {
        String path = projectPath + "msx-beans/";
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            throw new IOException("不存在 beans 目录");
        }
        return path;
    }
}
