package cn.com.github;


import org.springframework.batch.item.ItemProcessor;

public class HelloItemProcessor implements ItemProcessor<DeviceCommand, DeviceCommand>{

	public DeviceCommand process(DeviceCommand command) throws Exception {
		// TODO Auto-generated method stub
		//模拟下发命令给设备
		System.out.println("send command to device, id=" + command.getId());
		//更新命令状态
		command.setStatus("SENT");
		
		return command;
	}
   
	
}
