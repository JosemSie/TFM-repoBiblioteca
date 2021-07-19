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
}
