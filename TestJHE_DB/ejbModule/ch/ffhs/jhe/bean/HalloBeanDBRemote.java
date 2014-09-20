package ch.ffhs.jhe.bean;

import javax.ejb.Remote;

@Remote
public interface HalloBeanDBRemote {
	public String sayHello(String msg, int id);
}
