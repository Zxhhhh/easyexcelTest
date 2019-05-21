package com.zxh.easyexcelTest;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.zxh.easyexcelTest.model.WriteModel;

public class EasyExcelTest {
	
	@Test
	public void writeExcel() throws Exception {
		//文件输出位置
		OutputStream out = new FileOutputStream("D:/test.csv");
		
		//创建excel文件
		ExcelWriter writer = EasyExcelFactory.getWriter(out);
		
		//注解模式创建Sheet
		Sheet sheet1 = new Sheet(1,0,WriteModel.class);
		sheet1.setSheetName("first sheet");
		
		//关联sheet并写入数据到excel中
		writer.write(createModelList(),sheet1);
		
		//将上下文的outputStream最终写到文件中
		writer.finish();
		
		out.close();
	}
	
	public List<WriteModel> createModelList(){
		List<WriteModel> list = new ArrayList<>();
		for(int i = 0;i<500000;i++) {
			WriteModel model = new WriteModel("zxh","123",i);
			list.add(model);
		}
		return list;
	}

}
