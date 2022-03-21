package com.miao.mq_activemq.service;

import javax.jms.Destination;
import javax.jms.TextMessage;
import java.util.Map;

public interface AmqReceiveService {

	/**
	 * @param destination
	 * @return
	 * @Description::(从指定的队列接收文本消息). <br/>
	 * @author jingmiao
	 */
	TextMessage receive(Destination destination);

	/**
	 * @param destination
	 * @return
	 * @Description::(从指定的队列接收map消息). <br/>
	 * @author jingmiao
	 */
	Map<String, Object> receiveMap(Destination destination);

	/**
	 * @param destination
	 * @param clazz
	 * @return
	 * @Description::(从指定的队列接收序列化的bean消息). <br/>
	 * @author jingmiao
	 */
	<T> T receiveClazz(Destination destination, Class<T> clazz);

}
