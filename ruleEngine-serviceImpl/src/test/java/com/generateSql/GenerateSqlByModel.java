package com.generateSql;

import com.engine.entity.ruleEngine.RuleSnippet;
import com.engine.entity.task.Incident;
import com.google.common.base.CaseFormat;
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
        Class clazz = Incident.class;


//        data.put("tableName", humpConvertUnderline(clazz.getSimpleName()));
        data.put("tableName", CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, clazz.getSimpleName()));
        List<Map<String, Object>> attrs = new ArrayList<>();

        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(clazz);
        for(PropertyDescriptor descriptor: propertyDescriptors){

            String name = descriptor.getName();
            Class<?> propertyType = descriptor.getPropertyType();
            if(ArrayUtils.contains(fixedField, name)){
                continue;
            }

            String fieldType = decideFieldType(propertyType.getName());

            String range = null;
            String extend = null;
            // 取值范围
            if(regexKey(name,"num,code")){
                range = "(20)";
            }else if(regexKey(name,"description,note,remark,comment")){
                range = "(200)";
            }else if(regexKey(name,"priority")){
                range = "(5)";
                if("java.lang.Integer".equals(propertyType.getName())){
                    extend = "unsigned";
                }
            }

            Map<String, Object> attr = new HashMap<>();
                attr.put("field", CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name));
                attr.put("type", fieldType);
                attr.put("range", range);
                attr.put("extend", extend);
            attrs.add(attr);
        }
        data.put("attrs", attrs);
        drawFTL(data);
    }


    /**
     * 判断 field 的类型
     * @param propertyType
     * @return String
     */
    private String decideFieldType(String propertyType){
        String fieldType = "varchar(20)";
        // 类型
        switch (propertyType){
            case "java.lang.Integer":
                fieldType = "smallint";
                break;
            case "java.lang.Long":
                fieldType = "bigint";
                break;
            case "java.lang.String":
                fieldType = "varchar";
                break;
            case "java.util.Date":
                fieldType = "datetime";
                break;
            default:

        }
        return  fieldType;
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
     * guava 类库中有工具类
     * @param source
     * @return
     * @deprecated
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

    @Test
    public void estimateRange(){
        Pattern pattern = Pattern.compile("[\\s|\\S]*(ab|abc)[\\s|\\S]*");
        Matcher matcher = pattern.matcher("abdd");
        boolean matches = matcher.matches();
        System.out.println(matches);
    }

    @Test
    public void bonding(){
//        String
    }

    /**
     * guava 大小写格式化
     */
    @Test
    public void guavaStringFormat(){
        // 大写下划线 ==> 小写驼峰
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME"));
        // 小写驼峰 ==> 小写下划线
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "constantName"));

    }


    @Test
    public void testRegexKey(){
        boolean abcd = regexKey("abcd", "ab,abcd");
        System.out.println(abcd);
    }


    /**
     *
     * @param sourceStr
     * @param key
     */
    private boolean regexKey(String sourceStr, String key){
        String express = String.format("%s%s%s%s%s", "[\\s|\\S]*", "(", key.replaceAll(",", ")|("), ")", "[\\s|\\S]*");
        System.out.println(express);
        Pattern pattern = Pattern.compile(express);
        Matcher matcher = pattern.matcher(sourceStr);
        return matcher.matches();
    }
}
