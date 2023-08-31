package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConnectionsPoolImpl implements ConnectionsPool {
	int connectionsSize;
	
	public ConnectionsPoolImpl(int connectionsSize) {
		this.connectionsSize = connectionsSize;
	}
	
	LinkedHashMap <Integer, Connection> connectionsPool = new LinkedHashMap<Integer, Connection>(connectionsSize, 0.75f, true) {
		@Override
		protected boolean removeEldestEntry(Map.Entry<Integer, Connection> entry) {
			return size() > connectionsSize;
		}
	};
	@Override
	public boolean addConnection(Connection connection) {
		if(!connectionsPool.containsKey(connection.id)) {
			connectionsPool.put(connection.getId(), connection);
			return true;
		}
		return false;
	}

	@Override
	public Connection getConnection(int id) {
		
		return connectionsPool.get(id);
	}

	

}