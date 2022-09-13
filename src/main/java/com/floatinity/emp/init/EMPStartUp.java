package com.floatinity.emp.init;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.floatinity.emp.exception.EMPRuntimeException;

@Component
public class EMPStartUp implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOG = LogManager.getLogger(EMPStartUp.class);

//	public static final List<String> MAC_ADDRESS = Arrays.asList("00-21-CC-66-88-1F", "18-5E-0F-58-31-26",
//			"90-61-AE-7C-C8-BF", "A4-4C-C8-35-1A-21","00-15-5D-D0-A8-8D");

	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		try {
			LOG.info("Starting EMP Application");
			LOG.info("Current Server Time : " + new Date());

//			if (!MAC_ADDRESS.contains(getMacAddress())) {
//				LOG.error("Invalid MAC address.");
//				throw new Exception("Invalid MAC address.");
//			}
		} catch (Exception e) {
			LOG.error("App Initialization Failed.", e);
			throw new EMPRuntimeException("App Initializaion Exception");
		}

		LOG.info("Started Context");
	}

	private String getMacAddress() throws Exception {
		InetAddress ip = InetAddress.getLocalHost();
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
		byte[] mac = network.getHardwareAddress();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}
		String macAddress = sb.toString();
		LOG.info("Current MAC address of machine : {}", macAddress);
		return macAddress;
	}

}
