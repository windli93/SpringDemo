package cn.com.github;

import org.springframework.batch.item.file.LineMapper;

public class HelloMapper implements LineMapper<DeviceCommand>{

	public DeviceCommand mapLine(String line, int lineNumber) throws Exception {
		// TODO Auto-generated method stub
		String[] args = line.split(",");
		DeviceCommand command = new DeviceCommand();
		command.setId(args[0]);
		command.setStatus(args[1]);
		
		return command;
	}
      
	
}
