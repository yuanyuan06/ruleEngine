package com.generateSql;

import com.engine.entity.ruleEngine.RuleSnippet;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateSqlByModel {

    private String[] fixedField = new String[]{"class", "id", "version", "createUser", "createTime", "lastModifyUser", "lastModifyTime"};

    @Test
    public void generateSqlForMysql() throws IOException, TemplateException {

        Map<String, Object> data = new HashMap<>();
        Class clazz = RuleSnippet.class;

        data.put("tableName", humpConvertUnderline(clazz.getSimpleName()));
        List<Map<String, Object>> attrs = new ArrayList<>();

        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(clazz);
        for(PropertyDescriptor descriptor: propertyDescriptors){

            String name = descriptor.getName();
            Class<?> propertyType = descriptor.getPropertyType();
            if(ArrayUtils.contains(fixedField, name)){
                continue;
            }

            Long.class.getName();
            String fieldType = "varchar(20)";

            switch (propertyType.getName()){
                case "java.lang.Integer":
                    fieldType = "smallint(5) unsigned";
                    break;
                case "java.lang.Long":
                    fieldType = "bigint(20)";
                    break;
                case "java.lang.String":
                    fieldType = "varchar(20)";
                    break;
                case "java.util.Date":
                    fieldType = "datetime";
                    break;
                default:

            }

            Map<String, Object> attr = new HashMap<>();
                attr.put("field", humpConvertUnderline(name));
                attr.put("type", fieldType);
                attr.put("extend", "");
            attrs.add(attr);
        }
        data.put("attrs", attrs);



        drawFTL(data);

    }

    @Test
    public void testClass(){
        System.out.println(Date.class.getName());
        for(Annotation an: RuleSnippet.class.getAnnotations()){
            System.out.println(an.getClass().getName());

        }
    }

    /**
     * 驼峰转换费下划线
     * @param source
     * @return
     */
    private String humpConvertUnderline(String source){
        String regexStr = "[A-Z]";
        Matcher matcher = Pattern.compile(regexStr).matcher(source);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String g = matcher.group();
            matcher.appendReplacement(sb, "_" + g.toLowerCase());
        }
        matcher.appendTail(sb);
        if (sb.charAt(0) == '_') {
            sb.delete(0, 1);
        }
        return sb.toString();
    }

    private void drawFTL(Map<String, Object> data) throws IOException, TemplateException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = resourcePatternResolver.getResource("classpath:freemarker");
        File file = resource.getFile();
        System.out.println(file.isDirectory());
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(file);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Template temp = cfg.getTemplate("generateMysqlTable.ftl");
        Writer out = new OutputStreamWriter(System.out);
        temp.process(data, out);
    }

    @Test
    public void tet(){
        try {
            Map<String, Object> data = new HashMap<>();
            List<Map<String, Object>> attrs = new ArrayList<>();
            Map<String, Object> attr = new HashMap<>();
            attr.put("field", "name");
            attr.put("type", "sting");
            attr.put("extend", "primary");
            attrs.add(attr);
            data.put("tableName", "test");
            data.put("attrs", attrs);
            drawFTL(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void arrayContain(){
        boolean contain = ArrayUtils.contains(new String[]{"class", "id"}, "id");
        System.out.println(contain);
    }
}
