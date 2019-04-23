package com.zhang.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class MessageTM {

    private MessageTM() {
    }

    private static Configuration cfg = new Configuration();

    private static Log logger = LogFactory.getLog(MessageTM.class);

    static {
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath().replace("/classes", "/templates");
            File dir = new File(path);
            cfg.setDirectoryForTemplateLoading(dir);
        } catch (Exception e) {
            logger.error("报文模板装载失败!:", e);
        }
    }

    public static String process(String templatefile, Object param) throws Exception {
        StringWriter sw = new StringWriter();
        try {
            Template template = cfg.getTemplate(templatefile);
            template.process(param, sw);
            return sw.toString();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("报文模板获取失败:", e);
            throw new Exception();
        } finally {
            try {
                sw.close();
            } catch (IOException e) {
                logger.error("sw关闭异常", e);
            }
        }
    }

}
