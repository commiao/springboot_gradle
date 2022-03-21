package com.miao.mq_activemq.service;

import javax.jms.Destination;
import java.util.Map;

public interface AmqSenderService {

	/**
	 * @param destination
	 * @param message
	 * @Description::(向指定的队列发送文本信息). <br/>
	 * @author jingmiao
	 */
	void sendMsg(Destination destination, String message);

	/**
	 * @param destination
	 * @param map
	 * @Description::(向指定的队列发送map信息). <br/>
	 * @author jingmiao
	 */
	void sendMap(Destination destination, Map<String, Object> map);

	/**
	 * @param destination
	 * @param bean
	 * @Description::(向指定的队列发送序列化的bean信息). <br/>
	 * @author jingmiao
	 */
	void sendBean(Destination destination, Object bean);

}
