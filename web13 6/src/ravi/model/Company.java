package ravi.model;



public class Company {

	private String phoneNumber;

    private String website;

    private String email;

    private String name;

    private String uuid;

    private String externalId;

    private String country;

    public String getPhoneNumber ()
    {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite ()
    {
        return website;
    }

    public void setWebsite (String website)
    {
        this.website = website;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getUuid ()
    {
        return uuid;
    }

    public void setUuid (String uuid)
    {
        this.uuid = uuid;
    }

    public String getExternalId ()
    {
        return externalId;
    }

    public void setExternalId (String externalId)
    {
        this.externalId = externalId;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }
}
