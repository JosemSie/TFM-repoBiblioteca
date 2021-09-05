package SecureSession;

public/* abstract*/ class SecSession {
	private String lastURI;
    private Object id;
    public SecSession(Object paramId){
        this.id = paramId;
    }
    public SecSession(Object paramId, String paramLastURI){
        this.id = paramId;
        this.lastURI = paramLastURI;
    }
    public String getLastURI(){
        return this.lastURI;
    }
    public void setLastURI(String newURI){
        this.lastURI = newURI;
    }
    public Object getId(){
        return this.id;
    }

}
