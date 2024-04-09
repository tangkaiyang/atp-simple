package com.tang.generator;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;
import java.util.Objects;

/**
 * mybatis Generator
 *
 **/
@Slf4j
public class MybatisGenerator extends PluginAdapter {


    public static void main(String[] args) {
        generate();
    }

    public static void generate() {
        String config = Objects.requireNonNull(
                MybatisGenerator.class.getClassLoader().getResource("generatorConfig.xml"))
                .getFile();
        String[] arg = {"-configfile", config, "-overwrite"};
        ShellRunner.main(arg);
    }

    @Override
    public boolean validate(List<String> list) {
        return true;
    }


    /**
     * 实体类添加swagger注解
     *
     * @param field
     * @param topLevelClass
     * @param introspectedColumn
     * @param introspectedTable
     * @param modelClassType
     * @return
     */
    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass,
                                       IntrospectedColumn introspectedColumn,
                                       IntrospectedTable introspectedTable,
                                       ModelClassType modelClassType) {
        String classAnnotation =
                "@ApiModel(value=\"" + topLevelClass.getType().getShortName() + "\")";
        if (!topLevelClass.getAnnotations().contains(classAnnotation)) {
            topLevelClass.addAnnotation(classAnnotation);
        }
        String classLombokAnnotation = "@Data";
        if (!topLevelClass.getAnnotations().contains(classLombokAnnotation)) {
            topLevelClass.addAnnotation(classLombokAnnotation);
        }
        String apiModelAnnotationPackage = this.properties.getProperty("apiModelAnnotationPackage");
        String apiModelPropertyAnnotationPackage = this.properties
                .getProperty("apiModelPropertyAnnotationPackage");
        String lombokDataAnnotationPackage = this.properties
                .getProperty("lombokDataAnnotationPackage");
        if (null == apiModelAnnotationPackage) {
            apiModelAnnotationPackage = "io.swagger.annotations.ApiModel";
        }
        if (null == apiModelPropertyAnnotationPackage) {
            apiModelPropertyAnnotationPackage = "io.swagger.annotations.ApiModelProperty";
        }
        if (null == lombokDataAnnotationPackage) {
            lombokDataAnnotationPackage = "lombok.Data";
        }
        topLevelClass.addImportedType(apiModelAnnotationPackage);
        topLevelClass.addImportedType(apiModelPropertyAnnotationPackage);
        topLevelClass.addImportedType(lombokDataAnnotationPackage);
        field.addAnnotation("@ApiModelProperty(value=\"" + introspectedColumn.getRemarks() +
                "\",name=\"" + introspectedColumn.getJavaProperty() +
                "\")");
        return super
                .modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable,
                        modelClassType);
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable,
                                              ModelClassType modelClassType) {
        return false;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable,
                                              ModelClassType modelClassType) {
        return false;
    }

}
