package pers.johnx;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerDemo {

    public static void main(String[] args) throws IOException, TemplateException {

        //创建FreeMarker配置对象
        Configuration configuration = new Configuration(Configuration.getVersion());

        //使用配置对象， 设置模板所在目录
        configuration.setDirectoryForTemplateLoading(new File("./src/main/resources"));

        //设置模板编码
        configuration.setDefaultEncoding("UTF-8");

        //加载指定文件
        Template template = configuration.getTemplate("test.ftl");

        //创建一个数据对象
        Map dataMap = new HashMap();

        //封装变量
        dataMap.put("msg", "Hello FreeMarker!");

        //创建要输出的静态页面文件对象
        FileWriter fileWriter = new FileWriter(new File("./src/test", "test.html"));

        //调用模板对象，进行渲染，输出文件到指定目录
        template.process(dataMap, fileWriter);

        System.out.println("模板渲染成功！");

    }
}
