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

import cn.sixlab.minesitex.tools.generator.XMLUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ServerGenerator {
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
        
        doc.getRootElement().element("modules").addElement("module").setText("msx-service-" + pluginName);
    
        XMLUtil.writeXML(pom, doc);
    }
    
    private static void generatorSrc(String pluginPath, String pluginName) throws IOException {
        String clzName = "MsxPlugin" + pluginName.substring(0, 1).toUpperCase()
                + pluginName.substring(1) + "Application";
        String entityPath = pluginPath + "src/main/java/cn/sixlab/minesitex/";
        new File(entityPath).mkdirs();
        File app = new File(entityPath + clzName + ".java");
    
        if (!app.exists()) {
            String appText = "package cn.sixlab.minesitex;\n" +
                    "\n" +
                    "import org.springframework.boot.SpringApplication;\n" +
                    "import org.springframework.boot.autoconfigure.SpringBootApplication;\n" +
                    "import org.springframework.cloud.client.discovery.EnableDiscoveryClient;\n" +
                    "import org.springframework.cloud.netflix.feign.EnableFeignClients;\n" +
                    "\n" +
                    "@EnableFeignClients\n" +
                    "@EnableDiscoveryClient\n" +
                    "@SpringBootApplication\n" +
                    "public class " + clzName + " {\n" +
                    "    \n" +
                    "    public static void main(String[] args) {\n" +
                    "        SpringApplication.run(" + clzName + ".class, args);\n" +
                    "    }\n" +
                    "}\n";
            
            app.createNewFile();
            FileWriter writer = new FileWriter(app);
            writer.write(appText);
            writer.flush();
            writer.close();
        }
        
        String staticPath = pluginPath + "src/main/resources/";
        new File(staticPath).mkdirs();
        File bs = new File(staticPath + "bootstrap.yml");
    
        if (!bs.exists()) {
            String bsText = "spring:\n" +
                    "  application:\n" +
                    "    name: msx-service-"+ pluginName+"\n" +
                    "  profiles:\n" +
                    "    active: msx-service-"+ pluginName+"\n" +
                    "  cloud:\n" +
                    "    config:\n" +
                    "      uri: http://localhost:8500/\n" +
                    "      name: application-msx-service-"+ pluginName+",application-common-lib,application-common-service\n" +
                    "      profile: prod\n";
    
            bs.createNewFile();
            FileWriter writer = new FileWriter(bs);
            writer.write(bsText);
            writer.flush();
            writer.close();
        }
    }
    
    private static void generatorPom(String pluginPath, String pluginName) throws IOException {
        File pom = new File(pluginPath + "/pom.xml");
        String pomText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                "         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
                "    <parent>\n" +
                "        <artifactId>msx-server</artifactId>\n" +
                "        <groupId>cn.sixlab.minesitex</groupId>\n" +
                "        <version>msx.0.2.0-SNAPSHOT</version>\n" +
                "    </parent>\n" +
                "    <modelVersion>4.0.0</modelVersion>\n" +
                "\n" +
                "    <groupId>cn.sixlab.minesitex</groupId>\n" +
                "    <artifactId>msx-service-" + pluginName + "</artifactId>\n" +
                "    <version>msx.0.2.0-SNAPSHOT</version>\n" +
                "    <packaging>jar</packaging>\n" +
                "\n" +
                "    <name>msx-service-" + pluginName + "</name>\n" +
                "    <description>Plugin " + pluginName + "'s web server for Minesitex</description>\n" +
                "\n" +
                "    <dependencies>\n" +
                "        <!-- Cloud 依赖 -->\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.cloud</groupId>\n" +
                "            <artifactId>spring-cloud-starter-config</artifactId>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.cloud</groupId>\n" +
                "            <artifactId>spring-cloud-starter-eureka</artifactId>\n" +
                "            <exclusions>\n" +
                "                <exclusion>\n" +
                "                    <groupId>joda-time</groupId>\n" +
                "                    <artifactId>joda-time</artifactId>\n" +
                "                </exclusion>\n" +
                "            </exclusions>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-starter-web</artifactId>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-starter-data-jpa</artifactId>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>mysql</groupId>\n" +
                "            <artifactId>mysql-connector-java</artifactId>\n" +
                "            <scope>runtime</scope>\n" +
                "        </dependency>\n" +
                "\n" +
                "        <!-- 开发依赖 -->\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-starter-test</artifactId>\n" +
                "            <scope>test</scope>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-devtools</artifactId>\n" +
                "            <scope>runtime</scope>\n" +
                "        </dependency>\n" +
                "\n" +
                "        <!-- bean 依赖 -->\n" +
                "        <dependency>\n" +
                "            <groupId>cn.sixlab.minesitex</groupId>\n" +
                "            <artifactId>msx-bean-" + pluginName + "</artifactId>\n" +
                "        </dependency>\n" +
                "\n" +
                "        <!-- repo 依赖 -->\n" +
                "        <dependency>\n" +
                "            <groupId>cn.sixlab.minesitex</groupId>\n" +
                "            <artifactId>msx-data-" + pluginName + "</artifactId>\n" +
                "        </dependency>\n" +
                "\n" +
                "        <!-- 内部库 依赖 -->\n" +
                "        <dependency>\n" +
                "            <groupId>cn.sixlab.minesitex</groupId>\n" +
                "            <artifactId>msx-lib-base</artifactId>\n" +
                "        </dependency>\n" +
                "\n" +
                "        <dependency>\n" +
                "            <groupId>cn.sixlab.minesitex</groupId>\n" +
                "            <artifactId>msx-plugin-" + pluginName + "</artifactId>\n" +
                "        </dependency>\n" +
                "    </dependencies>\n" +
                "\n" +
                "    <build>\n" +
                "        <finalName>${project.artifactId}</finalName>\n" +
                "        <plugins>\n" +
                "            <plugin>\n" +
                "                <groupId>org.springframework.boot</groupId>\n" +
                "                <artifactId>spring-boot-maven-plugin</artifactId>\n" +
                "            </plugin>\n" +
                "        </plugins>\n" +
                "    </build>\n" +
                "\n" +
                "</project>\n";
        
        if (!pom.exists()) {
            pom.createNewFile();
            FileWriter writer = new FileWriter(pom);
            writer.write(pomText);
            writer.flush();
            writer.close();
        }
    }
    
    private static String pluginPath(String path, String pluginName) {
        String pluginPath = path + "msx-service-" + pluginName + "/";
        File pluginDir = new File(pluginPath);
        
        if (!pluginDir.exists()) {
            pluginDir.mkdirs();
        }
        return pluginPath;
    }
    
    private static String beanPath(String projectPath) throws IOException {
        String path = projectPath + "msx-server/";
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            throw new IOException("不存在 server 目录");
        }
        return path;
    }
}
