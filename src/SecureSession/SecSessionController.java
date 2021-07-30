package SecureSession;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SecSessionController{
	
	private HashMap<String,ArrayList<String>> map;
	
	public SecSessionController() {
	        map = new HashMap<String,ArrayList<String>>();
	}
	public void setMap(HashMap<String,ArrayList<String>> pMap) {
	    	this.map = pMap;
	    	
	} 
	public boolean isPossible(String newUri, SecSession actualSession){
        boolean sol = false;
        
        for(String checkSession : map.get(actualSession.getLastURI())){
            if(newUri.equals(checkSession)){
                sol = true;
                actualSession.setLastURI(newUri);
            }
        }
        return sol;
    }
    public void createMap(String ruta) throws IOException{
        String cadena;
        FileReader f = new FileReader(ruta);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            String[] splitText = cadena.split(" ");
            ArrayList<String> aux = new ArrayList<String>();
            for(int i = 1; i<splitText.length;i++)aux.add(splitText[i]);
            map.put(splitText[0], aux);
        }
        b.close();
    }
    public void addRutes(String id, ArrayList<String> rutes) {
    	if(map.get(id) != null) {
    		for(String rute : rutes) {
    			map.get(id).add(rute);
    		}
    	}
    	else {
    		map.put(id,rutes);
    	}
    }
    public void addRute(String id, String rute) {
    	if(map.get(id) != null) {
    		map.get(id).add(rute);
    	}
    }
    public void removeRute(String id, String rute) {
    	if(map.get(id) != null) {
    		map.get(id).remove(rute);
    	}    
    }
    public void removeAllRutes(String id) {
    	if(map.get(id) != null) {
    		map.remove(id);
    	}
    }
}
