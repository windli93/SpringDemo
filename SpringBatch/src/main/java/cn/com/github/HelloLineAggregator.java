package cn.com.github;

import org.springframework.batch.item.file.transform.LineAggregator;

public class HelloLineAggregator implements  LineAggregator<DeviceCommand>{

	public String aggregate(DeviceCommand deviceCommand) {
		
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append(deviceCommand.getId());
		buffer.append(",");
		buffer.append(deviceCommand.getStatus());
		return buffer.toString();
	}

	
}
