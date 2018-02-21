package eu.openminted.registry.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SSH {

    private static Logger logger = LogManager.getLogger(SSH.class);

	private JSch sch;
	private String user;
	private String key; 
	private String pass;
	
	private String IP;
	private int port = 22;
	
	public SSH(String user, String key, String pass, String IP) {
		super();
		this.user = user;
		this.key = key;
		this.pass = pass;
		this.IP = IP;
		
		try{
			sch = new JSch();
			sch.addIdentity(key, pass);
		}catch(Exception e){
			logger.debug(e);
		}
	}
	
	public boolean copy(String srcPath, String dstPath){
		try{
			Session sess = sch.getSession(user, IP, port);	
			sess.setConfig("StrictHostKeyChecking", "no");
			sess.connect();
			
			logger.info("sftp...."); 
			ChannelSftp sftp = (ChannelSftp) sess.openChannel("sftp"); 
			sftp.connect(); 
			logger.info("sftp connected");
			sftp.put(srcPath, dstPath);
			
			sftp.disconnect();
			sess.disconnect();			
		}catch(Exception e){
			logger.debug(e);
			return false;
		}

		return true;
	}
	
}
