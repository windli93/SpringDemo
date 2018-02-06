package cn.com.github.configura;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportDB {
       
	public static void main(String[] args) {
		//读取hibernate.cfg.xml
		Configuration conf = new Configuration().configure();
		//生成sql文件到数据库
		SchemaExport export = new SchemaExport();
		export.setOutputFile(conf);
		export.create(true, true);
	}
}
