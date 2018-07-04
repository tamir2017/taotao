package com.taotao.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.taotao.common.utils.FastDFSClient;

public class FastdfsTest {
	
	@Test
	public void testUpload() throws Exception{
		//1.添加FastDFS的jar包
		//2.初始化全局配置，加载一个配置文件
		ClientGlobal.init("G:\\pro\\workspace-taotao\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\client.conf");
		//3.创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		//4.创建一个TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		//5.声明一个StorageServer对象 null
		StorageServer storageServer = null;
		//6.获得StorageClient对象
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		//7.直接调用StorageClient对象方法，上传文件即可
		String[] strings = storageClient.upload_file("G:\\pic\\a.JPG", "JPG", null);
		for (String string : strings) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testFastDFSClient() throws Exception{
		FastDFSClient fastDFSClient = new FastDFSClient("G:\\pro\\workspace-taotao\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\client.conf");
		String string = fastDFSClient.uploadFile("G:\\pic\\b.jpg", "jpg");
		System.out.println(string);
	}
}
