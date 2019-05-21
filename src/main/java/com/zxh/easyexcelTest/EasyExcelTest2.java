package com.zxh.easyexcelTest;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.metadata.TableStyle;

public class EasyExcelTest2 {

	@Test
	public void writeExcel2() throws Exception {
		//文件输出位置
		OutputStream out = new FileOutputStream("D:/test2.xlsx");
		
		ExcelWriter writer = EasyExcelFactory.getWriter(out);
		
		Sheet sheet1 = new Sheet(1,0);
		sheet1.setSheetName("first sheet");
		
		//创建一个表格，在Sheet中使用
		Table table1 = new Table(1);
		
		//设置Tbale样式
		table1.setTableStyle(createTableStyle());
		
		//无注解模式：动态添加表头
		table1.setHead(createListStringHead());
		
		writer.write1(createModelList(),sheet1,table1);
		
		writer.finish();
		
		out.close();
		
	}
	
	//组合excel表头
	public List<List<String>> createListStringHead(){
		List<List<String>> head = new ArrayList<>();
		List<String> headCoulumn1 = new ArrayList<>();
		List<String> headCoulumn2 = new ArrayList<>();
		List<String> headCoulumn3 = new ArrayList<>();
		
		headCoulumn1.add("第一列");
		headCoulumn2.add("第二列");
		headCoulumn3.add("第三列");

		head.add(headCoulumn1);
		head.add(headCoulumn2);
		head.add(headCoulumn3);
		return head;
	}
	
	//创建动态数据
	public List<List<Object>> createModelList(){
		List<List<Object>> rows = new ArrayList<>();
		for(int i=0;i<100;i++) {
			List<Object> row = new ArrayList<>();
			row.add("字符串"+i);
			row.add("11345");
			row.add("zxh");
			rows.add(row);
		}
		return rows;
	}
	
	public TableStyle createTableStyle() {
		TableStyle tableStyle = new TableStyle();
		
		return tableStyle;
	}
}
