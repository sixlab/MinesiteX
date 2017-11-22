/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
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
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;

public class ModuleGenerator {
    public static void generator(String projectPath, String pluginName)
            throws Exception {
        addModules(projectPath, pluginName);
        
        addModule(projectPath, pluginName);
    }
    
    private static void addModule(String projectPath, String pluginName)
            throws DocumentException, IOException {
        String pom = projectPath + "msx-server/msx-web-aio/pom.xml";
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File(pom));
    
        Element dependencies = doc.getRootElement().element("dependencies");
    
        Element beans = dependencies.addElement("dependency");
        beans.addElement("groupId").setText("cn.sixlab.minesitex");
        beans.addElement("artifactId").setText("msx-plugin-" + pluginName);
        beans.addElement("version").setText("${msx.version}");
    
        XMLUtil.writeXML(pom, doc);
    }
    
    private static void addModules(String projectPath, String pluginName)
            throws DocumentException, IOException {
        String pom = projectPath + "/pom.xml";
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File(pom));
    
        Element dependencies = doc.getRootElement().element("dependencyManagement").element("dependencies");
    
        Element beans = dependencies.addElement("dependency");
        beans.addElement("groupId").setText("cn.sixlab.minesitex");
        beans.addElement("artifactId").setText("msx-bean-" + pluginName);
        beans.addElement("version").setText("${msx.version}");
    
        Element data = dependencies.addElement("dependency");
        data.addElement("groupId").setText("cn.sixlab.minesitex");
        data.addElement("artifactId").setText("msx-data-" + pluginName);
        data.addElement("version").setText("${msx.version}");
    
        Element plugins = dependencies.addElement("dependency");
        plugins.addElement("groupId").setText("cn.sixlab.minesitex");
        plugins.addElement("artifactId").setText("msx-plugin-" + pluginName);
        plugins.addElement("version").setText("${msx.version}");
    
        Element server = dependencies.addElement("dependency");
        server.addElement("groupId").setText("cn.sixlab.minesitex");
        server.addElement("artifactId").setText("msx-service-" + pluginName);
        server.addElement("version").setText("${msx.version}");
    
        XMLUtil.writeXML(pom, doc);
    }
}
