package ravi.model;



public class ParentBeans {
	
	private String returnUrl;

    private String applicationUuid;

    private String flag;

    private Payload payload;

    private String[] links;

    private Marketplace marketplace;

    private String type;

    private Creator creator;
    
    
    
    public String getReturnUrl ()
    {
        return returnUrl;
    }

    public void setReturnUrl (String returnUrl)
    {
        this.returnUrl = returnUrl;
    }

    public String getApplicationUuid ()
    {
        return applicationUuid;
    }

    public void setApplicationUuid (String applicationUuid)
    {
        this.applicationUuid = applicationUuid;
    }

    public String getFlag ()
    {
        return flag;
    }

    public void setFlag (String flag)
    {
        this.flag = flag;
    }

    public Payload getPayload ()
    {
        return payload;
    }

    public void setPayload (Payload payload)
    {
        this.payload = payload;
    }

    public String[] getLinks ()
    {
        return links;
    }

    public void setLinks (String[] links)
    {
        this.links = links;
    }

    public Marketplace getMarketplace ()
    {
        return marketplace;
    }

    public void setMarketplace (Marketplace marketplace)
    {
        this.marketplace = marketplace;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public Creator getCreator ()
    {
        return creator;
    }

    public void setCreator (Creator creator)
    {
        this.creator = creator;
    }
}
