Mybatis Generator 自定义注释（生成带有中文字段名注释的Bean) 原

利用工具：maven项目，nuxus私服。 Mybatis Generator基本使用教程传送门


要想生成中文注释，首先我们需要新建一个maven项目


然后新建一个类，名字随便啦。。。我这里叫QnloftCommentGenerator，上代码

package org.mybatis.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * User: R&M www.rmworking.com/blog
 * Date: 16/6/20
 * Time: 00:56
 * mybatis-generator-increase
 * org.mybatis.generator
 */
public class QnloftCommentGenerator extends DefaultCommentGenerator {

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        // 添加字段注释
        StringBuffer sb = new StringBuffer();
        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * <pre>");
        if (introspectedColumn.getRemarks() != null)
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
        sb.append(" * 表字段 : ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" * </pre>");
        field.addJavaDocLine(" * ");
        // addJavadocTag(field, false);
        field.addJavaDocLine(" */");
    }
}
主要就是继承DefaultCommentGenerator，重写addFieldComment方法。

在pom文件中加入

<dependencies>
    <dependency>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-maven-plugin</artifactId>
        <version>1.3.2</version>
    </dependency>
</dependencies>
OK了，我们执行 mvn -package打包上传到nuxus即可。上传nuxus的方法，请自行百度吧，或者给我留言！(jar包压到本地仓库)

然后在需要生成代码的项目的pom.xml加入我们之前上传的这个jar即可

<build>
  <plugins>
      <!-- mybatis代码生成插件 -->
      <plugin>
          <groupId>org.mybatis.generator</groupId>
          <artifactId>mybatis-generator-maven-plugin</artifactId>
          <version>1.3.2</version>
          <configuration>
              <configurationFile>src/main/resources/generatorConfig.xml</configurationFile>
              <verbose>true</verbose>
              <overwrite>true</overwrite>
          </configuration>
          <executions>
              <execution>
                  <id>Generate MyBatis Artifacts</id>
                  <goals>
                      <goal>generate</goal>
                  </goals>
              </execution>
          </executions>
          <dependencies>
                <!-- 这里就是我们自己定义的jar啦 -->
              <dependency>
                        <groupId>qnloft-mybatis-generator</groupId>
                        <artifactId>mybatis-generator-increase</artifactId>
                        <version>0.0.1</version>
                    </dependency>
              <dependency>
                  <groupId>mysql</groupId>
                  <artifactId>mysql-connector-java</artifactId>
                  <version>5.1.35</version>
              </dependency>
          </dependencies>
      </plugin>
  </plugins>
</build>
最后，修改generatorConfig.xml配置文件，在commentGenerator标签中指向我们自定义的注释类。

<commentGenerator type="org.mybatis.generator.QnloftCommentGenerator">
    <!-- 定义是否生成原生注释，我们这里自定义了，所以选择false -->
    <property name="suppressAllComments" value="false"/>
    <!-- This property is used to specify whether MBG will include the generation timestamp in the generated comments -->
    <property name="suppressDate" value="true"/>
</commentGenerator>

