/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/22 11:46
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.tools.generator;

import org.dom4j.Document;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class XMLUtil {
    public static void writeXML(String path, Document doc) throws IOException {
        //OutputFormat xmlFormat = new OutputFormat();
        //xmlFormat.setEncoding("UTF-8");
        //xmlFormat.setIndent(true);
        //xmlFormat.setIndent("    ");
        
        XMLWriter writer = new XMLWriter(new FileOutputStream(path));
        
        writer.write(doc);
        writer.flush();
        writer.close();
    }
}
