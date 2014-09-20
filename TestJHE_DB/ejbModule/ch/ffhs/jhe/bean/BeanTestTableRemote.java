package ch.ffhs.jhe.bean;

import java.util.Collection;

import javax.ejb.Remote;

import ch.ffhs.jhe.model.TestTable;

@Remote
public interface BeanTestTableRemote {
	public String getName(int id);
	public TestTable setName(String name);
	public Collection<TestTable> getAllTestTable();
}
