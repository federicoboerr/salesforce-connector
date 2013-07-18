package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class DescribeQuickActionListItemResult implements com.sforce.ws.bind.XMLizable {

    /**
     * Constructor
     */
    public DescribeQuickActionListItemResult() {}

    /**
     * element : iconUrl of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo iconUrl__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","iconUrl","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean iconUrl__is_set = false;

    private java.lang.String iconUrl;

    public java.lang.String getIconUrl() {
      return iconUrl;
    }

    public void setIconUrl(java.lang.String iconUrl) {
      this.iconUrl = iconUrl;
      iconUrl__is_set = true;
    }

    /**
     * element : label of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo label__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","label","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean label__is_set = false;

    private java.lang.String label;

    public java.lang.String getLabel() {
      return label;
    }

    public void setLabel(java.lang.String label) {
      this.label = label;
      label__is_set = true;
    }

    /**
     * element : miniIconUrl of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo miniIconUrl__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","miniIconUrl","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean miniIconUrl__is_set = false;

    private java.lang.String miniIconUrl;

    public java.lang.String getMiniIconUrl() {
      return miniIconUrl;
    }

    public void setMiniIconUrl(java.lang.String miniIconUrl) {
      this.miniIconUrl = miniIconUrl;
      miniIconUrl__is_set = true;
    }

    /**
     * element : quickActionName of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo quickActionName__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","quickActionName","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean quickActionName__is_set = false;

    private java.lang.String quickActionName;

    public java.lang.String getQuickActionName() {
      return quickActionName;
    }

    public void setQuickActionName(java.lang.String quickActionName) {
      this.quickActionName = quickActionName;
      quickActionName__is_set = true;
    }

    /**
     * element : targetSobjectType of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo targetSobjectType__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","targetSobjectType","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean targetSobjectType__is_set = false;

    private java.lang.String targetSobjectType;

    public java.lang.String getTargetSobjectType() {
      return targetSobjectType;
    }

    public void setTargetSobjectType(java.lang.String targetSobjectType) {
      this.targetSobjectType = targetSobjectType;
      targetSobjectType__is_set = true;
    }

    /**
     * element : type of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo type__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","type","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean type__is_set = false;

    private java.lang.String type;

    public java.lang.String getType() {
      return type;
    }

    public void setType(java.lang.String type) {
      this.type = type;
      type__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       __typeMapper.writeString(__out, iconUrl__typeInfo, iconUrl, iconUrl__is_set);
       __typeMapper.writeString(__out, label__typeInfo, label, label__is_set);
       __typeMapper.writeString(__out, miniIconUrl__typeInfo, miniIconUrl, miniIconUrl__is_set);
       __typeMapper.writeString(__out, quickActionName__typeInfo, quickActionName, quickActionName__is_set);
       __typeMapper.writeString(__out, targetSobjectType__typeInfo, targetSobjectType, targetSobjectType__is_set);
       __typeMapper.writeString(__out, type__typeInfo, type, type__is_set);
    }

    @Override
    public void load(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __typeMapper.consumeStartTag(__in);
      loadFields(__in, __typeMapper);
      __typeMapper.consumeEndTag(__in);
    }

    protected void loadFields(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, iconUrl__typeInfo)) {
            setIconUrl(__typeMapper.readString(__in, iconUrl__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, label__typeInfo)) {
            setLabel(__typeMapper.readString(__in, label__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, miniIconUrl__typeInfo)) {
            setMiniIconUrl(__typeMapper.readString(__in, miniIconUrl__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, quickActionName__typeInfo)) {
            setQuickActionName(__typeMapper.readString(__in, quickActionName__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, targetSobjectType__typeInfo)) {
            setTargetSobjectType(__typeMapper.readString(__in, targetSobjectType__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, type__typeInfo)) {
            setType(__typeMapper.readString(__in, type__typeInfo, java.lang.String.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[DescribeQuickActionListItemResult ");
      sb.append(" iconUrl=");
      sb.append("'"+com.sforce.ws.util.Verbose.toString(iconUrl)+"'\n");
      sb.append(" label=");
      sb.append("'"+com.sforce.ws.util.Verbose.toString(label)+"'\n");
      sb.append(" miniIconUrl=");
      sb.append("'"+com.sforce.ws.util.Verbose.toString(miniIconUrl)+"'\n");
      sb.append(" quickActionName=");
      sb.append("'"+com.sforce.ws.util.Verbose.toString(quickActionName)+"'\n");
      sb.append(" targetSobjectType=");
      sb.append("'"+com.sforce.ws.util.Verbose.toString(targetSobjectType)+"'\n");
      sb.append(" type=");
      sb.append("'"+com.sforce.ws.util.Verbose.toString(type)+"'\n");
      sb.append("]\n");
      return sb.toString();
    }
}
