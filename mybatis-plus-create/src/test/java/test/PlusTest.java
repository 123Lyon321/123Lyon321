package test;

import java.sql.Types;
import java.util.Collections;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class PlusTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastAutoGenerator.create(
				"jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&serverTimezone=Asia/Shanghai&useSSL=false",
				"root", "root").globalConfig(builder -> {
					builder.author("Lyon") // 设置作者
							.enableSwagger() // 开启 swagger 模式
							.fileOverride() // 覆盖已生成文件
							.outputDir("D://mybatisplus"); // 指定输出目录
				}).dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
					int typeCode = metaInfo.getJdbcType().TYPE_CODE;
					if (typeCode == Types.SMALLINT) {
						// 自定义类型转换
						return DbColumnType.INTEGER;
					}
					return typeRegistry.getColumnType(metaInfo);

				})).packageConfig(builder -> {
					builder.parent("com.hj") // 设置父包名
							.moduleName("") // 设置父包模块名
							.pathInfo(Collections.singletonMap(OutputFile.xml, "D://mybatisplus")); // 设置mapperXml生成路径
				}).strategyConfig(builder -> {
					builder.addInclude("tb_dept") // 设置需要生成的表名
							.addTablePrefix("tb_", "c_"); // 设置过滤表前缀
				}).templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
				.execute();
	}

}
