package com.es.core;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
	 private static TransportClient client = null;
	 public final static String HOST = "192.168.0.154";
	 public final static int PORT = 9300;
	
	
	
	 public void getConnect() throws UnknownHostException {
	        client = new PreBuiltTransportClient(Settings.builder().put("cluster.name", "my-app").build()).addTransportAddresses(
	                 new TransportAddress(InetAddress.getByName(HOST),PORT));

	    }
	 
	
	   
	 
	 
	 public void addIndex1() throws IOException {
		 SearchResponse response = client.prepareSearch().get();
		 System.out.println(response.toString());
/*	        IndexResponse response = client.prepareIndex("msg", "tweet", "1").setSource(XContentFactory.jsonBuilder()
	                .startObject().field("userName", "张三")
	                .field("sendDate", new Date())
	                .field("msg", "你好李四")
	                .endObject()).get();
	        
	//        logger.info("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
	//                    + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.status());
	        
	        System.out.println("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
	                    + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.status());
	                    */
	    }
	 
	
	 public static void closeConnect() {
	        if(null != client) {
	            client.close();
	        }
	    }
	 
	 public static void main(String[] args) {
		 try {
			client = new PreBuiltTransportClient(Settings.builder().put("cluster.name", "my-app").build()).addTransportAddresses(
			         new TransportAddress(InetAddress.getByName(HOST),PORT));
			SearchResponse response = client.prepareSearch().get();
			 System.out.println(response.toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

}
