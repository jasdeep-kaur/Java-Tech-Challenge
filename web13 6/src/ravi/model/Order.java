package ravi.model;



public class Order {

	private String pricingDuration;

    private Items[] items;

    private String addonOfferingCode;

    private String[] customAttributes;

    private String editionCode;

    public String getPricingDuration ()
    {
        return pricingDuration;
    }

    public void setPricingDuration (String pricingDuration)
    {
        this.pricingDuration = pricingDuration;
    }

    public Items[] getItems ()
    {
        return items;
    }

    public void setItems (Items[] items)
    {
        this.items = items;
    }

    public String getAddonOfferingCode ()
    {
        return addonOfferingCode;
    }

    public void setAddonOfferingCode (String addonOfferingCode)
    {
        this.addonOfferingCode = addonOfferingCode;
    }

    public String[] getCustomAttributes ()
    {
        return customAttributes;
    }

    public void setCustomAttributes (String[] customAttributes)
    {
        this.customAttributes = customAttributes;
    }

    public String getEditionCode ()
    {
        return editionCode;
    }

    public void setEditionCode (String editionCode)
    {
        this.editionCode = editionCode;
    }
}
