package ravi.model;



public class Creator {
	
	private String lastName;

    private Address address;

    private String email;

    private String locale;

    private String[] attributes;

    private String language;

    private String uuid;

    private String firstName;

    private String openId;

    public String getLastName ()
    {
        return lastName;
    }

    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }

    public Address getAddress ()
    {
        return address;
    }

    public void setAddress (Address address)
    {
        this.address = address;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getLocale ()
    {
        return locale;
    }

    public void setLocale (String locale)
    {
        this.locale = locale;
    }

    public String[] getAttributes ()
    {
        return attributes;
    }

    public void setAttributes (String[] attributes)
    {
        this.attributes = attributes;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public String getUuid ()
    {
        return uuid;
    }

    public void setUuid (String uuid)
    {
        this.uuid = uuid;
    }

    public String getFirstName ()
    {
        return firstName;
    }

    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }

    public String getOpenId ()
    {
        return openId;
    }

    public void setOpenId (String openId)
    {
        this.openId = openId;
    }
}
