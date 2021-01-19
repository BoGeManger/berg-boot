/*
 * Copyright (c) 2011-2020, baomidou (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.berg.generator.engine;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.berg.generator.config.ConstVal;
import com.berg.generator.config.builder.ConfigBuilder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * Freemarker 模板引擎实现文件输出
 */
public class FreemarkerTemplateEngine extends AbstractTemplateEngine {

    private Configuration configuration;

    @Override
    public com.berg.generator.engine.FreemarkerTemplateEngine init(ConfigBuilder configBuilder) {
        super.init(configBuilder);
        configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setDefaultEncoding(ConstVal.UTF8);
        configuration.setClassForTemplateLoading(com.berg.generator.engine.FreemarkerTemplateEngine.class, StringPool.SLASH);
        return this;
    }


    @Override
    public void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws Exception {
        Template template = configuration.getTemplate(templatePath);
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            template.process(objectMap, new OutputStreamWriter(fileOutputStream, ConstVal.UTF8));
        }
        logger.debug("模板:" + templatePath + ";  文件:" + outputFile);
    }

    @Override
    public void writerStr(Map<String, Object> objectMap, String templatePath) throws Exception{
        Template template = configuration.getTemplate(templatePath);
        System.out.println(FreeMarkerTemplateUtils.processTemplateIntoString(template, objectMap));
        logger.debug("==========================文本生成完成！！！==========================");
    }


    @Override
    public String templateFilePath(String filePath) {
        return filePath + ".ftl";
    }
}
