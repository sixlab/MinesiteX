/**
 * Copyright (c) 2018 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2018/1/25 18:27
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.tools.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    
    public static void writeFile(File pom, String pomText) throws IOException {
        if (!pom.exists()) {
            pom.createNewFile();
            FileWriter writer = new FileWriter(pom);
            writer.write(pomText);
            writer.flush();
            writer.close();
        }
    }
}
